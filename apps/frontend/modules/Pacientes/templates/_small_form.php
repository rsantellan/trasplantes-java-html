<form id="paciente_form" action="<?php echo url_for('Pacientes/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  <div class="form_block">
	<h4><?php echo __("paciente_Cedula de identida");?></h4>
	<div class="form_block_field<?php if($form['ci']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ci']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ci']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("paciente_Cedula de identida").': '.__("paciente_error ".$form['ci']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>  
  <div class="form_block">
	<h4><?php echo __("paciente_Nombre");?></h4>
	<div class="form_block_field<?php if($form['nombre']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['nombre']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['nombre']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Nombre").': '.__("paciente_error ".$form['nombre']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  <div class="form_block">
	<h4><?php echo __("paciente_Apellido");?></h4>
	<div class="form_block_field<?php if($form['apellido']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['apellido']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['apellido']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Apellido").': '.__("paciente_error ".$form['apellido']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="form_block">
	<h4><?php echo __("paciente_Numero del fondo nacional de recursos");?></h4>
	<div class="form_block_field<?php if($form['num_fnr']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['num_fnr']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['num_fnr']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Numero del fondo nacional de recursos").': '.__("paciente_error ".$form['num_fnr']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  <div class="form_block">
  
	<h4><?php echo __("paciente_Raza");?></h4>
	<div class="form_block_field<?php if($form['raza']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['raza']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['raza']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Raza").': '.__("paciente_error ".$form['raza']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="form_block">
	<h4><?php echo __("paciente_Sexo");?></h4>
	<div class="form_block_field<?php if($form['sexo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['sexo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['sexo']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Sexo").': '.__("paciente_error ".$form['sexo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  <div class="form_block">
	<h4><?php echo __("paciente_Fecha de nacimiento");?></h4>
	<a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
	</a>
	<div class="form_block_field<?php if($form['fecha_nacimiento']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha_nacimiento']->render(array("class" => "date_widget")) ?>
	</div>
	<div>
		<?php 
		if($form['fecha_nacimiento']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Fecha de nacimiento").': '.__("paciente_error ".$form['fecha_nacimiento']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>		
  </div>
  <div class="form_block">
	<h4><?php echo __("paciente_Fecha de dialisis");?></h4>
	<a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
	</a>
	<div class="form_block_field<?php if($form['fecha_dialisis']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha_dialisis']->render(array("class" => "date_widget")) ?>
	</div>
	<div>
		<?php 
		if($form['fecha_dialisis']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Fecha de dialisis").': '.__("paciente_error ".$form['fecha_dialisis']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  <div class="form_block">
	<h4><?php echo __("paciente_Nefropatia");?></h4>
	<div class="form_block_field<?php if($form['nefropatia_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['nefropatia_id']->render() ?>
	</div>
	<div>
		<?php 
		if($form['nefropatia_id']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Nefropatia").': '.__("paciente_error ".$form['nefropatia_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="form_block">
	<h4><?php echo __("paciente_Grupo sanguineo");?></h4>
	<div class="form_block_field<?php if($form['grupo_sanguineo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['grupo_sanguineo']->render() ?>
	</div>
	<div>
		<?php 
		if($form['grupo_sanguineo']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("paciente_Grupo sanguineo").': '.__("paciente_error ".$form['grupo_sanguineo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  <?php if($form->getObject()->isNew()) : ?>
    <a href="<?php echo url_for("@buscar");?>" class="save_button" ><?php echo __("paciente_Cancelar");?></a> 
  <?php else: ?>
    <a href="<?php echo url_for("@mostrarPaciente?id=".$form->getObject()->getId());?>" class="save_button"><?php echo __("paciente_Cancelar");?></a> 
  <?php endif;?>
  <input class="save_button" type="submit" value="<?php echo __("paciente_Guardar");?>"/>
</form>
<div class="clear"></div>
