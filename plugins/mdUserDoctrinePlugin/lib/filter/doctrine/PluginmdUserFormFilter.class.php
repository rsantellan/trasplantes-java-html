<?php

/**
 * PluginmdUser form.
 *
 * @package    ##PROJECT_NAME##
 * @subpackage filter
 * @author     ##AUTHOR_NAME##
 * @version    SVN: $Id: sfDoctrineFormFilterPluginTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
abstract class PluginmdUserFormFilter extends BasemdUserFormFilter
{
	
  public function setup()
  {
    parent::setup();

    unset ($this['deleted_at'], $this['updated_at'], $this['super_admin']);
    $emailList = mdUserHandler::retrieveAllEmailsInArray();

    $this->widgetSchema['email'] = new sfWidgetFormChoiceAutocompleteComboBox(array(
                'choices' => $emailList
            ));
    
//    $this->widgetSchema['created_at'] = new sfWidgetFormFilterDate(array(
//        'from_date' => new sfWidgetFormInputDatepicker(array('default' => date('Y-m-d'))),
//        'to_date' => new sfWidgetFormInputDatepicker(array('default' => date('Y-m-d'))),
//        'with_empty' => false,
//        'template' => '<table><tr><td>from</td><td>%from_date%</td></tr><tr><td>to</td><td>%to_date%</td></tr></table>'
//    ));
    
    $this->widgetSchema['created_at'] = new sfWidgetFormFilterDate(array(
        'from_date' => new sfWidgetFormDate(array('default' => date('Y-m-d'))),
        'to_date' => new sfWidgetFormDate(array('default' => date('Y-m-d'))),
        'with_empty' => false,
        'template' => '<table><tr><td>from</td><td>%from_date%</td></tr><tr><td>to</td><td>%to_date%</td></tr></table>'
    ));
    
    $countries = mdBasicFunction::retrieveAllCountriesArray(true);
    $this->widgetSchema['country'] = new sfWidgetFormChoiceAutocompleteComboBox(array(
                'choices' => $countries
            ));

    $this->validatorSchema['created_at'] = new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDate(array('required' => false))));
  
    $this->validatorSchema['country'] = new sfValidatorString(array('max_length' => 2, 'required' => false));
  }

  public function addEmailColumnQuery(Doctrine_Query $query, $field, $values){
      if($values !== ''){
          $query->addWhere($query->getRootAlias().'.email LIKE ?',  '%' . $values . '%');
      }
  }

  public function addCountryColumnQuery(Doctrine_Query $query, $field, $values){
      if($values != ''){
        $query = Doctrine::getTable('mdUserProfile')->addFilterByCountry($query, $values);
      }

  }

  public function addCreatedAtColumnQuery(Doctrine_Query $query, $field, $values)
  {
    if($values['from'] !== NULL && $values['to'] !== NULL)
    {
        $query->addWhere($query->getRootAlias().'.created_at >= ?', $values['from']);
        $query->addWhere($query->getRootAlias().'.created_at <= ?', $values['to']);
        //var_dump($values);
    }
  }
//
//  public function addMdApplicationsColumnQuery(Doctrine_Query $query, $field, $values){
//    if($values != 0){
//
//    }
//  }

  public function getFields(){
    return array_merge(parent::getFields(), array('country_code' => 'Text'));
  }
  	
}
