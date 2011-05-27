<?php

class preTrasplanteHandler 
{
  
  public static function retrieveAllPacientepreTrasplantesIds()
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveAllPacientepreTrasplantesIds();
  }


  public static function retriveById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retriveById($id, $hydrationMode);
  }

  public static function retrieveNumberPreTrasplantesOfPaciente($pacienteId)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveNumberPreTrasplantesOfPaciente($pacienteId);
  }
    
}
