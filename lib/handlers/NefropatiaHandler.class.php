<?php

/**
 * Description of NefropatiaHandler
 *
 * @author Rodrigo Santellan
 */
class NefropatiaHandler {
  
  /**
   * Busca una nefropatia por id 
   * 
   * @param int $nefropatiaId
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion 
   */
  public static function retriveById($nefropatiaId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Nefropatia")->retriveById($nefropatiaId, $hydrationMode);
  }
  
  /**
   * Busca una nefropatia por id del paciente que la usa
   * 
   * @param int $pacienteId
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion 
   */
  public static function retriveNefropatiaByPacienteId($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Nefropatia")->retriveByPacienteId($pacienteId, $hydrationMode);
  }
}

