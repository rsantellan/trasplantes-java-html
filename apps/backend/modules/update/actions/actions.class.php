<?php

/**
 * update actions.
 *
 * @package    transplantes
 * @subpackage update
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class updateActions extends sfActions
{
 /**
  * Executes index action
  *
  * @param sfRequest $request A request object
  */
  public function executeIndex(sfWebRequest $request)
  {
    
    $root_dir = sfConfig::get('sf_root_dir');
    $command = "svn update ".$root_dir;
    $return = null;
    exec($command, $return);
    var_dump($root_dir);
    var_dump($return);
  }
}
