<?php

class PacienteHandler 
{

  public static function retrivePacienteByTrasplanteId($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Pacientes")->retrivePacienteByTrasplanteId($trasplanteId, $hydrationMode);
  }

}
