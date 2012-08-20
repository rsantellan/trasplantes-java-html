<?php

class correctPreTrasplanteDatesTask extends sfBaseTask
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
    $this->name             = 'correctPreTrasplanteDates';
    $this->briefDescription = 'Corrige las fechas de los pre trasplantes';
    $this->detailedDescription = <<<EOF
The [updateEvolucionCounter|INFO] Lo que hace es corregir la fecha de alta de los pre trasplantes.
Call it with:

  [php symfony updateEvolucionCounter|INFO]
EOF;
  }

  protected function execute($arguments = array(), $options = array())
  {
    // initialize the database connection
    $databaseManager = new sfDatabaseManager($this->configuration);
    $connection = $databaseManager->getDatabase($options['connection'])->getConnection();

    // add your code here
    echo "---------------------------Verifica que la fecha de alta del pre trasplante sea correcta. ---------------------------------------\n";
    // Obtengo todos los trasplantes.
    $trasplantes = trasplanteHandler::retriveAll(Doctrine_Core::HYDRATE_ARRAY);
    foreach($trasplantes as $trasplante)
    {
      //Le hago update al pretrasplante con la fecha del mismo poniendolo en la fecha de alta.
      preTrasplanteHandler::updatePreTrasplanteFechaAlta($trasplante["paciente_pre_trasplante_id"], $trasplante["fecha"]);
    }
  }
}
