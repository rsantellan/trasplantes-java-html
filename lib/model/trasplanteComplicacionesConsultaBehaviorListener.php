<?php
 
class trasplanteComplicacionesConsultaBehaviorListener extends Doctrine_Record_Listener
{  
	public function postSave(Doctrine_Event $event) 
	{
      $object = $event->getInvoker();
      $tcObject = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByObjectClassAndId($object->getId(), $object->getObjectClass());
      
      
      $trasplante = trasplanteHandler::retriveById($object->getTrasplanteId(), Doctrine_Core::HYDRATE_ARRAY );
      //var_dump($trasplante);
      //var_dump($object->getFecha());
      $years = basicFunction::calculateDifferenceInYears($trasplante["fecha"], $object->getFecha());
      $months = basicFunction::calculateDifferenceInMonth($trasplante["fecha"], $object->getFecha());
      $days = basicFunction::calculateDifferenceInDays($trasplante["fecha"], $object->getFecha());
      if(!$tcObject)
      {
        $tcObject = new TrasplanteComplicacionesConsulta();
        $tcObject->setComplicacionClass($object->getObjectClass());
        $tcObject->setTrasplanteId($object->getTrasplanteId());
        $tcObject->setComplicacionId($object->getId());
        $tcObject->setDiasDesdeTrasplante($days);
        $tcObject->setMesesDesdeTrasplante($months);
        $tcObject->setYearsDesdeTrasplante($years);
        $tcObject->save(); 
      }
      else
      {
        $tcObject->setDiasDesdeTrasplante($days);
        $tcObject->setMesesDesdeTrasplante($months);
        $tcObject->setYearsDesdeTrasplante($years);
        $tcObject->save(); 
      }
	}
	
	public function postDelete(Doctrine_Event $event)
    {
      $object = $event->getInvoker();
      $tcObject = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByObjectClassAndId($object->getId(), $object->getObjectClass());
      if($tcObject)
        $tcObject->delete();
	}	
}

