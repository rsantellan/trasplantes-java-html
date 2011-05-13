<?php

class cargarDatosTransplanteTask extends sfBaseTask
{
  protected function configure()
  {
    // // add your own arguments here
    // $this->addArguments(array(
    //   new sfCommandArgument('my_arg', sfCommandArgument::REQUIRED, 'My argument'),
    // ));

    $this->addOptions(array(
      new sfCommandOption('application', null, sfCommandOption::PARAMETER_REQUIRED, 'The application name'),
      new sfCommandOption('env', null, sfCommandOption::PARAMETER_REQUIRED, 'The environment', 'dev'),
      new sfCommandOption('connection', null, sfCommandOption::PARAMETER_REQUIRED, 'The connection name', 'doctrine'),
      // add your own options here
    ));

    $this->namespace        = 'loading';
    $this->name             = 'cargarDatosTransplante';
    $this->briefDescription = 'Carga los datos de la base vieja';
    $this->detailedDescription = <<<EOF
The [cargarDatos|INFO] task lo que hace es ir cargando los datos que existen en la base de datos vieja.
Call it with:

  [php symfony cargarDatos|INFO]
EOF;
  }

  protected function execute($arguments = array(), $options = array())
  {
    if (!Md_TaskManager::isTaskLocked(__class__)) {
        Md_TaskManager::lockTask(__class__); 
        
           
        // initialize the database connection
        $databaseManager = new sfDatabaseManager($this->configuration);
        
        $connection = $databaseManager->getDatabase($options['connection'])->getConnection();
        
        Doctrine_Manager::connection()->setAttribute(Doctrine_Core::ATTR_AUTO_FREE_QUERY_OBJECTS, true ); 
        // add your code here
        Md_TaskManager::unlockTask(__class__);
        $username="root";
        $password="root";
        $database="trasplante";    
        
        echo "---------------------------Guarda los cmv---------------------------------------\n";
        cmvConvertorHandler::startAll($username, $password, $database);
        echo "-------------------------Guarda los seroles de los trasplantes-----------------------------------------\n";
        transplanteConvertorHandler::saveTrasplanteSerol($username, $password, $database);
        echo "-----------------------Guarda los tipos de complicaciones-------------------------------------------\n";
        //complicacionHandler::saveAllComplicacionesTipo($username, $password, $database);
        echo "--------------------------Guarda las medicaciones----------------------------------------\n";
        //complicacionHandler::saveAllMedicaciones($username, $password, $database);
        echo "---------------------------Guarda los trasplantes complicaciones---------------------------------------\n"; 
        //complicacionHandler::saveAllTrasplantesComplicaciones($username, $password, $database);    
        echo "---------------------------Guarda los trasplantes complicaciones no infecciosas---------------------------------------\n"; 
       // complicacionHandler::saveAllComplicacionesNoInfecciosas($username, $password, $database);

        echo "---------------------------Guarda las inducciones---------------------------------------\n";
        transplanteConvertorHandler::saveAllInducciones($username, $password, $database);
        echo "---------------------------Guarda las inducciones de trasplantes---------------------------------------\n";
        transplanteConvertorHandler::saveAllTrasplanteInducciones($username, $password, $database);
        echo "---------------------------Guarda las inmunosupresores---------------------------------------\n";
        transplanteConvertorHandler::saveAllInmunosupresores($username, $password, $database);
        echo "---------------------------Guarda las inmunosupresores de trasplantes---------------------------------------\n";
        transplanteConvertorHandler::saveAllTrasplanteInmunosupresores($username, $password, $database);
        echo "---------------------------Guarda los resultados pbr ---------------------------------------\n";
        transplanteConvertorHandler::saveAllResultadosPbr($username, $password, $database);
        echo "---------------------------Guarda los ra tratamientos---------------------------------------\n";
        transplanteConvertorHandler::saveAllRaTratamiento($username, $password, $database);
        echo "---------------------------Guarda los Evolucion trasplante Cmv---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionCmv($username, $password, $database);
        echo "---------------------------Guarda los Evolucion trasplante Ecg---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionEcg($username, $password, $database);

        
    } else {
        die('Task is Locked');
    }    
  }
}
