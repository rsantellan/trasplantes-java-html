<?php

/**
 * mdSortable actions.
 *
 * @package    plugins
 * @subpackage mdMediaDoctrinePlugin
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class mdSortableActions extends sfActions
{

    /**
     * Recibe los datos del mdContentConcrete en:
     * $_MD_Object_Ids:
     * $_MD_Object_Class_Names:
     * $_MD_Priorities:
     * 
     * @param sfWebRequest $request
     */
    public function executeSortable(sfWebRequest $request)
    {
        try {
            $_MD_Object_Ids         = explode('|', $request->getParameter("_MD_Object_Ids", ""));
            $_MD_Object_Class_Names = explode('|', $request->getParameter("_MD_Object_Class_Names", ""));
            $_MD_Priorities         = explode('|', $request->getParameter("_MD_Priorities", ""));
            $_MD_Page               = $request->getParameter("_MD_Page", 1);
            $_MD_Limit              = $request->getParameter("_MD_Limit", 0);

            $offset = $_MD_Limit * ($_MD_Page - 1);

            if($_MD_Object_Ids == "" || $_MD_Object_Class_Names == "" || $_MD_Priorities == "")
            {
                throw new Exception("wrong _MD_Object_Id or _MD_Object_Class_Name", 100);
            }

            $i = 0;
            foreach($_MD_Object_Ids as $object_id)
            {
                $object_class_name = $_MD_Object_Class_Names[$i];
                $priority = $_MD_Priorities[$i] + $offset;

                $mdContentConcrete = Doctrine::getTable($object_class_name)->find($object_id);
                $mdContentConcrete->setPriority($priority);
                $mdContentConcrete->save();
                $i++;
            }

            return $this->renderText(json_encode(array('response' => 'OK')));

        }catch(Exception $e){

            return $this->renderText(json_encode(array('response' => 'ERROR', 'options' => array('message' => $e->getMessage()))));

        }
    }
}
