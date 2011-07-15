<?php

class trasplanteHandler 
{

  public static function retriveAllTrasplantesId()
  {
      return Doctrine::getTable("Trasplante")->retrieveAllTrasplantesIds();
  }
  
  public static function retrieveTrasplanteFechaFromPreTrasplanteId($paciente_pre_trasplante_id)
  {
    return Doctrine::getTable("Trasplante")->retrieveTrasplanteFechaFromPreTrasplanteId($paciente_pre_trasplante_id);
  }

  public static function retriveByPacientePreTrasplanteId($PreTrasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Trasplante")->retriveByPacientePreTrasplanteId($PreTrasplanteId, $hydrationMode);
  }

  public static function retriveById($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Trasplante")->retriveById($trasplanteId, $hydrationMode);
  }

  public static function retriveAllInduccionesByTrasplanteId($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Induccion")->retriveAllInduccionesByTrasplanteId($trasplanteId, $hydrationMode);
  }
    
  public static function retrieveAllSerolesOfTrasplante($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("TrasplanteSerol")->retrieveAllSeroles($trasplanteId, $hydrationMode);
  }

  public static function saveSerolesOfTrasplante($trasplanteId, $seroles_valores_id_list)
  {
    //Borro todos los seroles que ya existian.
    $antiguos = self::retrieveAllSerolesOfTrasplante($trasplanteId);
    foreach($antiguos as $trasplante_serol)
    {
      $trasplante_serol->delete();
    }
    
    // Ahora agrego los nuevos.
    foreach($seroles_valores_id_list as $seroles_valores_id)
    {
      $serolValor = serolHandler::retrieveSerolValor($seroles_valores_id);
      $TrasplanteSerol = new TrasplanteSerol();
      $TrasplanteSerol->setTrasplanteId($trasplanteId);
      $TrasplanteSerol->setSerolId($serolValor->getSerolId());
      $TrasplanteSerol->setSerolValorId($serolValor->getId());
      $TrasplanteSerol->save();
    }
  }
    
}
