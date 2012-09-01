<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of updatesHandler
 *
 * @author Rodrigo Santellan
 */
class updatesHandler 
{
    const PRIMERA = "2.0.0";
    
    public static function doUpdate($version)
    {
      $actual = Doctrine::getTable('version')->findOneBy("nombre", $version);  
      $doSomething = false;
      if(!$actual)
      {
          $actual = new Version();
          $actual->setNombre($version);
          $can_save = $actual->doProgramUpdate();
          if($can_save)
          {
             $actual->save();
          }
          
      }
    }
    
    public static function versionExists($version)
    {
        if($version == self::PRIMERA)
        {
            return true;
        }
        return false;
    }
}

