<?php
 
class trasplanteComplicacionesConsultaBehaviorListener extends Doctrine_Record_Listener
{  
	public function postSave(Doctrine_Event $event) 
	{
            $object = $event->getInvoker();
            if(!Doctrine::getTable('mdContent')->retrieveByObject($object)){
                $mdContent = new MdContent();
                $mdContent->setObjectClass(get_class($object));
                $mdContent->setObjectId($object->getId());
                $mdContent->setMdUserId($object->getMdUserIdTmp());
                $mdContent->save();
            }
	}
	
	public function preDelete(Doctrine_Event $event)
  {
            
            $object = $event->getInvoker();
            //$list = $object->retrieveContents();
            $mdContent = Doctrine::getTable('mdContent')->retrieveByObject($object);
            Doctrine::getTable('mdContentRelation')->deleteRelatedOfId($mdContent->getId());
            /*foreach($list as $aux)
            {
              $aux->delete();
            }
            $content = Doctrine::getTable('mdContent')->retrieveByObject($object);
            $content->delete();*/
	}	
}

