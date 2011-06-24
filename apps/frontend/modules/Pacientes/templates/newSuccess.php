<?php
  use_javascript("pacientesNewManagement.js");
  use_javascript("nefropatiasManagement.js");
?>
<h1><?php echo __("paciente_Agregar Paciente");?></h1>

<div class="form_container">
  <?php include_partial('small_form', array('form' => $form)) ?>
  
</div>

