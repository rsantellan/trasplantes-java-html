<?php

class preTrasplanteHandler 
{
  
  /**
   * Devuelve los ids de todos los pretrasplantes.
   * @return array de ids 
   */
  public static function retrieveAllPacientepreTrasplantesIds()
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveAllPacientepreTrasplantesIds();
  }

  /**
   * Devuelve todos los id de los pre trasplantes del año dado
   * @param int $year
   * @return array de ids
   */
  public static function retrieveAllPacientepreTrasplantesIdsByYear($year)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveAllPacientepreTrasplantesIdsByYear($year);
  }

  /**
   * Devuelve un pretrasplante
   * @param int $id
   * @param Doctrine_Core $hydrationMode metodo de hidratacion
   * @return Depende del metodo de hidratacion 
   */
  public static function retriveById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retriveById($id, $hydrationMode);
  }

  /**
   * Devuelve la cantidad de pre trasplantes que tuvo el paciente dado
   * @param int $pacienteId
   * @return array doble para acceder al numero se usa $array[0][0]
   */
  public static function retrieveNumberPreTrasplantesOfPaciente($pacienteId)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveNumberPreTrasplantesOfPaciente($pacienteId);
  }

  /**
   * Devuelve la lista de pretrasplante de un paciente
   * @param int $id del paciente
   * @param Doctrine_Core $hydrationMode metodo de hidratacion
   * @return Depende del metodo de hidratacion 
   */
  public static function retriveByPacienteId($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retriveByPacienteId($id, $hydrationMode);
  }

  /**
   * Devuelve la lista de pretrasplante de un paciente ordenada
   * @param int $id del paciente
   * @param Doctrine_Core $hydrationMode metodo de hidratacion
   * @return Depende del metodo de hidratacion 
   */
  public static function retriveByPacienteIdOrdered($id, $order = "DESC",  $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientepretrasplante")->retriveByPacienteId($id, $hydrationMode);
  }  
}
