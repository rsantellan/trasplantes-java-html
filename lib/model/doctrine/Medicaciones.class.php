<?php

/**
 * Medicaciones
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
class Medicaciones extends BaseMedicaciones
{
  public function __toString()
  {
	return $this->getNombre();
  }
}
