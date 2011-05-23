<?php

/**
 * PacientesTable
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 */
class PacientesTable extends Doctrine_Table
{
    /**
     * Returns an instance of this class.
     *
     * @return object PacientesTable
     */
    public static function getInstance()
    {
        return Doctrine_Core::getTable('Pacientes');
    }
    
    public function retrivePacienteByTrasplanteId($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
    {
      $query = $this->createQuery("p")
                ->select("p.*")
                ->addFrom("Pacientepretrasplante pa, Trasplante t")
                ->addWhere("pa.id = t.paciente_pre_trasplante_id")
                ->addWhere("pa.paciente_id = p.id")
                ->addWhere("t.id = ?", $trasplanteId);
 
      $query->setHydrationMode($hydrationMode);
      return $query->execute();
    }
}
