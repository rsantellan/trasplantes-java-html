<?php

/**
 * Cmv actions.
 *
 * @package    transplantes
 * @subpackage Cmv
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class CmvActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->id = $request->getParameter('id');
    $this->forward404Unless($this->id);
    $this->cmvs = cmvHandler::retrieveByTrasplanteId($this->id);
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->cmv);
  }

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $cmv = new Cmv();
    $cmv->setTrasplanteId($trasplanteId);
    
    $this->form = new CmvForm($cmv);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new CmvForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $Cmv = Doctrine::getTable('Cmv')->find($id);
        $this->forward404Unless($Cmv);
        $form = new CmvForm($Cmv); 
        $isNew = false;
      }
      else
      {
        $evolucion = new Cmv();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new CmvForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $CmvAux = $form->save();
        $form = new CmvForm($CmvAux);
        $body = $this->getPartial("cmvList", array( "evolucion" => $CmvAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$CmvAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }  
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new CmvForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id'))), sprintf('Object cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new CmvForm($cmv);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id'))), sprintf('Object cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new CmvForm($cmv);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id'))), sprintf('Object cmv does not exist (%s).', $request->getParameter('id')));
    $cmv->delete();

    $this->redirect('Cmv/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $cmv = $form->save();

      $this->redirect('Cmv/edit?id='.$cmv->getId());
    }
  }
}
