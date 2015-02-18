<?php

/**
 * Trasplante form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteForm extends BaseTrasplanteForm
{
  public function configure()
  {
    unset($this["created_at"], $this["updated_at"], $this["fecha_alta"]);
    
    $paciente_pre_trasplante_id = $this->getObject()->getPacientePreTrasplanteId();
    $preTrasplante = preTrasplanteHandler::retriveById($paciente_pre_trasplante_id, Doctrine_Core::HYDRATE_ARRAY);
    $this->widgetSchema['paciente_pre_trasplante_id'] = new sfWidgetFormInputHidden();
    $age = mdBasicFunction::calculateAge($preTrasplante["fecha_ingreso_lista"], true);
    $years = range(date('Y') - $age,date('Y')+ 1);
    $years = array_combine($years, $years);
    
    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));
                                
                                    
    $this->widgetSchema['otras_compl_quirur'] = new sfWidgetFormTextarea();
    
    $this->widgetSchema['comentario'] = new sfWidgetFormTextarea();
    $this->widgetSchema['dialisis'] =  new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                  ));
    
  }
}
