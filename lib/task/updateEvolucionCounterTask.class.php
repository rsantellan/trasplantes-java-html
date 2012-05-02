<?php

class updateEvolucionCounterTask extends sfBaseTask
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
    $this->name             = 'updateEvolucionCounter';
    $this->briefDescription = 'Actualiza el counter';
    $this->detailedDescription = <<<EOF
The [updateEvolucionCounter|INFO] Lo que hace es actualizar los registros de la tabla evolucion counter.
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
    echo "---------------------------Guarda todas las evoluciones para poder actualizar los contadores.---------------------------------------\n";
    $listado_cmv = Doctrine::getTable("EvolucionTrasplanteCmv")->findAll();
    foreach($listado_cmv as $evolucion)
    {
        $evolucion->save();
    }
    $listado_cmv->clear();
    unset($listado_cmv);
    $listado_ecg = Doctrine::getTable("EvolucionTrasplanteEcg")->findAll();
    foreach($listado_ecg as $evolucion)
    {
        $evolucion->save();
    }
    $listado_ecg->clear();
    unset($listado_ecg);
    
    $listado_ecocardio = Doctrine::getTable("EvolucionTrasplanteEcoCardio")->findAll();
    foreach($listado_ecocardio as $evolucion)
    {
        $evolucion->save();
    }
    $listado_ecocardio->clear();
    unset($listado_ecocardio);
    
    $listado_nutricion = Doctrine::getTable("EvolucionTrasplanteNutricion")->findAll();
    foreach($listado_nutricion as $evolucion)
    {
        $evolucion->save();
    }
    $listado_nutricion->clear();
    unset($listado_nutricion);
    
    $listado_paraclinica = Doctrine::getTable("EvolucionTrasplanteParaclinica")->findAll();
    foreach($listado_paraclinica as $evolucion)
    {
        $evolucion->save();
    }
    $listado_paraclinica->clear();
    unset($listado_paraclinica);
    
    $listado_ecodopler = Doctrine::getTable("EvolucionTrasplanteEcodopler")->findAll();
    foreach($listado_ecodopler as $evolucion)
    {
        $evolucion->save();
    }
    $listado_ecodopler->clear();
    unset($listado_ecodopler);
    
    $listado_ecografia = Doctrine::getTable("EvolucionTrasplanteEcografia")->findAll();
    foreach($listado_ecografia as $evolucion)
    {
        $evolucion->save();
    }
    $listado_ecografia->clear();
    unset($listado_ecografia);
    
    $listado_marvirales = Doctrine::getTable("EvolucionTrasplanteMarvirales")->findAll();
    foreach($listado_marvirales as $evolucion)
    {
        $evolucion->save();
    }
    $listado_marvirales->clear();
    unset($listado_marvirales);
    
    $listado_txtorax = Doctrine::getTable("EvolucionTrasplanteTxtorax")->findAll();
    foreach($listado_txtorax as $evolucion)
    {
        $evolucion->save();
    }
    $listado_txtorax->clear();
    unset($listado_txtorax);
  }
}
