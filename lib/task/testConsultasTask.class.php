<?php

class testConsultasTask extends sfBaseTask
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

    $this->namespace        = 'testing';
    $this->name             = 'testConsultas';
    $this->briefDescription = '';
    $this->detailedDescription = <<<EOF
The [testConsultas|INFO] task does things.
Call it with:

  [php symfony testConsultas|INFO]
EOF;
  }

  protected function execute($arguments = array(), $options = array())
  {
    // initialize the database connection
    $databaseManager = new sfDatabaseManager($this->configuration);
    $connection = $databaseManager->getDatabase($options['connection'])->getConnection();

    // add your code here
    $datos = Doctrine::getTable('Consulta')->retrieveConsultaTotalReporteDeFondo();
    foreach($datos as $row)
    {
      $pacienteMuerte = Doctrine::getTable('Consulta')->retrievePacienteCausaDeMuerte($row["P_ID"]);
      $preTrasplantePerdida = Doctrine::getTable('Consulta')->retrievePreTrasplantePerdidaInjerto($row["PPT_ID"]);
      $trasplanteInducciones = Doctrine::getTable('Consulta')->retrieveTrasplanteInducciones($row["T_ID"]);
      
      $meses_en_dialisis = basicFunction::calculateDifferenceInMonth($row["FECHA_DIALISIS"], $row["T_FECHA"]);
      
      var_dump($meses_en_dialisis);
      //var_dump($row);
      //var_dump($pacienteMuerte);
      //var_dump($preTrasplantePerdida);
      //var_dump($trasplanteInducciones);
      
    }
  }
}
