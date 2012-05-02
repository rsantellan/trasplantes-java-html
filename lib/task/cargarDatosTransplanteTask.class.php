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
        complicacionHandler::saveAllComplicacionesTipo($username, $password, $database);
        echo "--------------------------Guarda las medicaciones----------------------------------------\n";
        complicacionHandler::saveAllMedicaciones($username, $password, $database);
        //echo "---------------------------Guarda los trasplantes complicaciones---------------------------------------\n"; 
        //complicacionHandler::saveAllTrasplantesComplicaciones($username, $password, $database);    
        echo "---------------------------Guarda los trasplantes complicaciones no infecciosas---------------------------------------\n"; 
        complicacionHandler::saveAllComplicacionesNoInfecciosas($username, $password, $database);
        echo "---------------------------Guarda las infeciones---------------------------------------\n"; 
        complicacionHandler::saveAllInfeccion($username, $password, $database);
        echo "---------------------------Guarda los Germenes---------------------------------------\n"; 
        complicacionHandler::saveAllGermenes($username, $password, $database);
        echo "---------------------------Guarda las complicaciones infecciosas---------------------------------------\n"; 
        complicacionHandler::saveAllComplicacionesInfecciosas($username, $password, $database);
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
        echo "---------------------------Guarda los Evolucion trasplante Eco cardio---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionEcoCardio($username, $password, $database);
        echo "---------------------------Guarda los Evolucion trasplante Nutricionales---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionNutricionales($username, $password, $database);
        echo "---------------------------Guarda los Tratamientos---------------------------------------\n";
        pacientesConvertorHandler::saveAllTratamientos($username, $password, $database); 
        echo "---------------------------Guarda los Evolucion trasplante Paraclinicas---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionParaclinica($username, $password, $database);        
        echo "---------------------------Guarda los Evolucion trasplante Ecodopler---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionEcoDopler($username, $password, $database); 
        echo "---------------------------Guarda los Evolucion trasplante Ecografias---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionEcografias($username, $password, $database);                                 
        echo "---------------------------Guarda los Evolucion trasplante Marvirales---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionMarvirales($username, $password, $database);    
        echo "---------------------------Guarda los Evolucion trasplante Tx Torax---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionTxTorax($username, $password, $database);
        echo "---------------------------Guarda los Evolucion trasplante Examenes---------------------------------------\n";
        evolucionConvertorHandler::saveAllEvolucionExamenenes($username, $password, $database);
        echo "---------------------------Guarda las Causas de perdidas de Injerto---------------------------------------\n";
        pacientesConvertorHandler::saveAllPacientePerdidaDeInjertoCausa($username, $password, $database);        
        echo "---------------------------Guarda las perdidas de Injerto---------------------------------------\n";
        pacientesConvertorHandler::saveAllPacientePerdidaDeInjerto($username, $password, $database);
        echo "---------------------------Guarda las reoperaciones de trasplantes---------------------------------------\n";
        transplanteConvertorHandler::saveAllTrasplanteReoperacion($username, $password, $database);        
        echo "---------------------------Guarda las evoluciones de los injertos de los trasplantes---------------------------------------\n";
        transplanteConvertorHandler::saveAllTrasplanteInjertoEvolucion($username, $password, $database); 
        echo "---------------------------Guarda las evoluciones de los injertos pbr de los trasplantes---------------------------------------\n";
        transplanteConvertorHandler::saveAllTrasplanteInjertoEvolucionPbr($username, $password, $database); 
        echo "---------------------------Pone todas las edades del receptor en los trasplantes---------------------------------------\n";
        transplanteConvertorHandler::cargarEdadesDelReceptorEnTrasplante();
        echo "---------------------------Pone los meses en lista del receptor ---------------------\n";
        transplanteConvertorHandler::cargarMesesEnListaPaciente();                        
                        
    } else {
        die('Task is Locked');
    }    
  }
}
