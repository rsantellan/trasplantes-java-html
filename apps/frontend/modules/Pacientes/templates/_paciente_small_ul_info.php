<div id="paciente_basic_info" class="paciente_basic_info">
  <ul>
	<li><?php echo __("paciente_Nombre");?> : <label class="bold_text"><?php echo $paciente['nombre']?></label></li>
	<li><?php echo __("paciente_Apellido");?> : <label class="bold_text"><?php echo $paciente['apellido']?></label></li>
	<li><?php echo __("paciente_Cedula de identida");?> : <label class="bold_text"><?php echo $paciente['ci']?></label></li>
	<li><?php echo __("paciente_Numero del fondo nacional de recursos");?> : <label class="bold_text"><?php echo $paciente['num_fnr']?></label></li>
	<li><?php echo __("paciente_Raza");?> : <label class="bold_text"><?php echo $paciente['raza']?></label></li>
	<li><?php echo __("paciente_Sexo");?> : <label class="bold_text"><?php echo $paciente['sexo']?></label></li>
	<li><?php echo __("paciente_Fecha de nacimiento");?> : <label class="bold_text"><?php echo format_date($paciente['fecha_nacimiento'], 'D'); ?></label></li>
	<li><?php echo __("paciente_Fecha de dialisis");?> : <label class="bold_text"><?php echo format_date($paciente['fecha_dialisis'], 'D'); ?></label></li>
	<?php $nefropatia = NefropatiaHandler::retriveById($paciente['nefropatia_id'], Doctrine_Core::HYDRATE_ARRAY);?>
	<li><?php echo __("paciente_Nefropatia");?> : <label class="bold_text"><?php echo $nefropatia['nombre']?></label></li>
	<li><?php echo __("paciente_Grupo sanguineo");?> : <label class="bold_text"><?php echo $paciente['grupo_sanguineo']?></label></li>
  </ul>
  <div style="float: right;width: 25px;">
	<a href="<?php echo url_for("@editarPaciente?id=".$paciente['id']); ?>"><?php echo image_tag("edit-icon.png")?></a>
  </div>
</div>