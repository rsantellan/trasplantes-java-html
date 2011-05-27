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
  
}
