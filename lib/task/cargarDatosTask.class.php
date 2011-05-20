<?php

class cargarDatosTask extends sfBaseTask
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
    $this->name             = 'cargarDatos';
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

        // add your code here
        Md_TaskManager::unlockTask(__class__);
        $username="root";
        $password="root";
        $database="trasplante";    
        echo "---------------------------- Cargando las nefropatias --------------------------------------\n";
        $page = 0;
        $hasValue = true;
        while($hasValue)
        {
          $hasValue = nefropatiasConvertorHandler::saveAllNefropatias($username,$password, $database, $page, 1);
          $page++;
        }
        echo "----------------------------Cargando los pacientes --------------------------------------\n";
        pacientesConvertorHandler::saveAllPacientes($username,$password, $database);
        echo "---------------------------------Cargando las causas de muere---------------------------------\n";
        pacientesMuerteConvertorHandler::saveAllPacientesCausaDeMuerte($username,$password, $database);
        echo "--------------------------Cargando las muertes de los pacientes---------------------------------------\n";
        pacientesMuerteConvertorHandler::saveAllPacientesMuertes($username, $password, $database);
        echo "--------------------------------Cargando los pre trasplantes----------------------------------\n";
        pacientesConvertorHandler::saveAllPacientesPreTransplantes($username, $password, $database);
        echo "-----------------------------Cargando los donantes-------------------------------------\n";
        donantesConvertorHandler::proccessDonantes($username, $password, $database);
    } else {
        die('Task is Locked');
    }    
  }
}
