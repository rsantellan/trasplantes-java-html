<?php

class preTrasplanteHandler 
{
  
  public static function retrieveAllPacientepreTrasplantesIds()
  {
      return Doctrine::getTable("Pacientepretrasplante")->retrieveAllPacientepreTrasplantesIds();
  }

}
