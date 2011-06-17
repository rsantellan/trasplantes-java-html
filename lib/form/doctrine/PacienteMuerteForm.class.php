<?php

/**
 * PacienteMuerte form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacienteMuerteForm extends BasePacienteMuerteForm
{
  public function configure()
  {
    
    $years = range(1920,date('Y'));
    
    $this->widgetSchema['fecha_muerte'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' =>array_combine($years, $years)));
                                
    $this->widgetSchema['transplante_funcionando'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => array('0' => "No funcionando", '1' => "Funcionando"),
                                                            ));  
    $this->validatorSchema['paciente_id'] = new sfValidatorString(array('required' => true));

  }
  
}
