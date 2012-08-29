<?php

class reporteFondoRACMVTask extends sfBaseTask
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
      new sfCommandOption('yearFrom', null, sfCommandOption::PARAMETER_REQUIRED, "Este es el año que se quiere ver", null),
      new sfCommandOption('year', null, sfCommandOption::PARAMETER_REQUIRED, "Este es el año de los trasplantes", null),
      new sfCommandOption('completo', null, sfCommandOption::PARAMETER_OPTIONAL, "Si se quiere completo", false),
    ));

    $this->namespace        = 'loading';
    $this->name             = 'reporteFondoRACMV';
    $this->briefDescription = '';
    $this->detailedDescription = <<<EOF
The [reporteFondoRACMV|INFO] task does things.
Call it with:

  [php symfony reporteFondoRACMV|INFO]
EOF;
  }

  protected function execute($arguments = array(), $options = array())
  {
    // initialize the database connection
    $databaseManager = new sfDatabaseManager($this->configuration);
    $connection = $databaseManager->getDatabase($options['connection'])->getConnection();

    // add your code here
    
    if(is_null($options['yearFrom']) || is_null($options['year']))
    {
      return;
    }
    
    $yearFrom = (int) $options['yearFrom'];
    $year = (int) $options['year'];
    $completo = (boolean) $options['completo'];
    if($completo)
    {
      reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFrom);
      return;
    }
    
    while($yearFrom <= $year)
    {
      reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFrom, $year);
      $yearFrom++;
    }
    
    
    
    
  }
}
