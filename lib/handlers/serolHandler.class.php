<?php

class serolHandler 
{
  
  public static function retrieveAllSeroles($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Serol")->retrieveAll($hydrationMode);
  }

  public static function retrieveSerolValor($serolValorId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("SerolValor")->retriveById($serolValorId, $hydrationMode);
  }
  
}
