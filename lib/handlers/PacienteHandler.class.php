<?php

class PacienteHandler 
{

  public static function retrivePacienteByTrasplanteId($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientes")->retrivePacienteByTrasplanteId($trasplanteId, $hydrationMode);
  }

  public static function retriveAllPacientesId()
  {
      return Doctrine::getTable("Pacientes")->retrieveAllPacientesIds();
  }
  
  public static function retriveNefropatiaByPacienteId($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Nefropatia")->retriveByPacienteId($pacienteId, $hydrationMode);
  }  
  
  public static function retrivePacienteMuerteByPacienteId($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("PacienteMuerte")->retriveByPacienteId($pacienteId, $hydrationMode);
  }
  
  public static function retrivePacientePerdidasByPacienteId($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("PacientePerdidaInjerto")->retriveByPacienteId($pacienteId, $hydrationMode);
  }       
}
