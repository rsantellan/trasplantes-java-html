<form action="<?php echo url_for('@salvarTratamiento');?>" method="post" onsubmit="return tratamientoManagement.getInstance().saveForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Tratamiento_medicacion");?></h4>
	<div class="form_block_field<?php if($form['medicacion_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['medicacion_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['medicacion_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Tratamiento_medicacion").': '.__("Tratamiento_error ".$form['medicacion_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Tratamiento_dosis");?></h4>
	<div class="form_block_field<?php if($form['dosis']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dosis']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dosis']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Tratamiento_dosis").': '.__("Tratamiento_error ".$form['dosis']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
<div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Tratamiento_fecha de inicio");?></h4>
	<div class="form_block_field<?php if($form['fecha_inicio']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha_inicio']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha_inicio']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Tratamiento_fecha de inicio").': '.__("Tratamiento_error ".$form['fecha_inicio']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Tratamiento_Guardar");?>" />
 
</form>
