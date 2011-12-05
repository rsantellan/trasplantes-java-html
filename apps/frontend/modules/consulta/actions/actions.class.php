<?php

/**
 * consulta actions.
 *
 * @package    transplantes
 * @subpackage consulta
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class consultaActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->consultas = Doctrine_Core::getTable('consulta')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->consulta);
    //var_dump($this->consulta->retrieveFieldsList());die;
    $lista = $this->consulta->getConsultaCampo();
    var_dump(count($lista));
    $q = Doctrine_Manager::getInstance()->getCurrentConnection();
    $this->result = $q->fetchAssoc($this->consulta->getSentencia());	
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new consultaForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new consultaForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $consulta->delete();

    $this->redirect('consulta/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $consulta = $form->save();

      $this->redirect('consulta/edit?id='.$consulta->getId());
    }
  }
}
