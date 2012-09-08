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
    
    var_dump(time());
    var_dump(memory_get_peak_usage());
    reportesHandler::CrearReporteDeFondo();
    var_dump(time());
    var_dump(memory_get_peak_usage());
    return true;
    
    $datos = Doctrine::getTable('Consulta')->retrieveConsultaTotalReporteDeFondo();
    foreach($datos as $row)
    {
      $pacienteMuerte = Doctrine::getTable('Consulta')->retrievePacienteCausaDeMuerte($row["P_ID"]);
      $preTrasplantePerdida = Doctrine::getTable('Consulta')->retrievePreTrasplantePerdidaInjerto($row["PPT_ID"]);
      $trasplanteInducciones = Doctrine::getTable('Consulta')->retrieveTrasplanteInducciones($row["T_ID"]);
      $meses_en_dialisis = "N/A";
      if($row["SIN_DIALISIS"] == "NO")
      {
        $meses_en_dialisis = basicFunction::calculateDifferenceInMonth($row["FECHA_DIALISIS"], $row["T_FECHA"]);
      }
      //var_dump($meses_en_dialisis);
      //var_dump($row);
      //var_dump($pacienteMuerte);
      //var_dump($preTrasplantePerdida);
      var_dump($trasplanteInducciones);
      
      $estado = "3. VIVO EN TR";
      if(count($pacienteMuerte) > 0)
      {
        $estado = "2: FALLECIO EN TR";
      }
      else
      {
        if(count($preTrasplantePerdida) > 0)
        {
          $estado = "1: EN DIALISIS";
        }
      }
      //var_dump($estado);
      unset($pacienteMuerte);
      unset($preTrasplantePerdida);
      unset($trasplanteInducciones);
      
    }
    
    //reportes2Handler::CrearReporteDeFondo(2002);
  }
}
