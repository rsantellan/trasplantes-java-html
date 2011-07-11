<?php

class TrasplanteComponents extends sfComponents 
{

  public function executeRetrieveSeroles(sfWebRequest $request) {
      $this->seroles = serolHandler::retrieveAllSeroles();
      $this->serolesTrasplante = trasplanteHandler::retrieveAllSerolesOfTrasplante($this->id, Doctrine_Core::HYDRATE_ARRAY);
  }
  
}
