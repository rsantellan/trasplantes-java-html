<?php

/**
 * DonanteCausaMuerteTable
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 */
class DonanteCausaMuerteTable extends Doctrine_Table
{
    /**
     * Returns an instance of this class.
     *
     * @return object DonanteCausaMuerteTable
     */
    public static function getInstance()
    {
        return Doctrine_Core::getTable('DonanteCausaMuerte');
    }
    
    public function retriveById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
    {
      $query = $this->createQuery("dcm")
                ->addWhere("dcm.id = ?", $id);

      $query->setHydrationMode($hydrationMode);
      return $query->fetchOne();
    } 
    
    
	public function retrieveAll($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
	{
	  $query = $this->createQuery("dcm");
	  $query->setHydrationMode($hydrationMode);
	  return $query->execute();
	}    
}
