<?php

class donanteComponents extends sfComponents 
{

  public function executeRetrieveSeroles(sfWebRequest $request) {
      $this->seroles = serolHandler::retrieveAllSeroles();
      $this->serolesDonante = Donantehandler::retrieveAllSerolesOfDonante($this->id, Doctrine_Core::HYDRATE_ARRAY);
      /*
      $this->serolesAsociados = array();
      foreach($serolesDonante as $serol)
      {
        $this->serolesAsociados[$serol['serol_valor_id']] = $serol['serol_valor_id'];
      }*/
  }
  
}
