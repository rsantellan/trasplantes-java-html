<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of datosBasicosHandler
 *
 * @author Rodrigo Santellan
 */
class datosBasicosHandler {
  
  /**
   * Retorna las opciones si y no para los widgets. Se usa aca para ponerles i18n.
   * @return array() 
   */
  public static function yesOrNoChoicesOptions()
  {
	return array('0' => "No", '1' => "Si");
  }
  
  public static function cmvChoicesOptions()
  {
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('I18N'));
      return array(
          0 => __("cmv_emfermedad"),
          1 => __("cmv_tratamiento anticipado"),
          2 => __("cmv_sindrome viral"),
          3 => __("cmv_profilaxis")
      );
  }
  
}


