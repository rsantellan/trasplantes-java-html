<div class="paciente_estado_container">
  <?php $muerte = PacienteHandler::retrivePacienteMuerteByPacienteId($id, Doctrine_Core::HYDRATE_ARRAY); ?>
  <?php $perdidas = PacienteHandler::retrivePacientePerdidasByPacienteId($id, Doctrine_Core::HYDRATE_ARRAY); ?>
  <?php $cantidad_pre_trasplantes = preTrasplanteHandler::retrieveNumberPreTrasplantesOfPaciente($id);?>
  <label><?php echo __("paciente_Estado del paciente :");?></label>
  <?php if($muerte): ?>
	<?php if($muerte["transplante_funcionando"] == 1): ?>
	  <?php echo __("paciente_El paciente fallecio con trasplante funcionando.");?>
	<?php else: ?>
	  <?php echo __("paciente_El paciente fallecio sin el trasplante funcionando.");?>
	<?php endif;?>
  <?php else: ?>
	<?php if($cantidad_pre_trasplantes[0][0] == 0): ?>
	  <?php echo __("paciente_El paciente no se a realizado ningun trasplante.");?>
	<?php else: ?>
	  <?php if($cantidad_pre_trasplantes[0][0] == count($perdidas)): ?>
		<?php echo __("paciente_El paciente se hizo un trasplante que resulto en perdida.");?>
	  <?php else: ?>
		<?php echo __("paciente_El paciente esta vivo con el trasplante funcionando.");?>
	  <?php endif;?>
	<?php endif;?>
  <?php endif;?>
  <a href="<?php echo url_for("@editarEstadoPaciente?id=".$id); ?>" class="simple_tip_container">
    <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
    <div class="tooltip_text"><?php echo __("paciente_editar el estado del paciente");?></div>		
  </a>  
</div>
