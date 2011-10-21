<form action="<?php echo url_for('@evolucionSalvarCmv');?>" method="post" onsubmit="return tratamientoManagement.getInstance().saveForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Cmv Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Cmv Fecha").': '.__("Evoluciones_Cmv error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Cmv Fecha igg");?></h4>
	<div class="form_block_field<?php if($form['igg_cmv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['igg_cmv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['igg_cmv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Cmv Fecha igg").': '.__("Evoluciones_Cmv error ".$form['igg_cmv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Cmv Fecha igm");?></h4>
	<div class="form_block_field<?php if($form['igm_cmv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['igm_cmv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['igm_cmv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Cmv Fecha igm").': '.__("Tratamiento_error ".$form['igm_cmv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Cmv Fecha pcr");?></h4>
	<div class="form_block_field<?php if($form['igg_cmv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['igg_cmv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['pcr_cmv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Cmv Fecha pcr").': '.__("Evoluciones_Cmv error ".$form['pcr_cmv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Cmv Fecha ag_pp65");?></h4>
	<div class="form_block_field<?php if($form['ag_pp65']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['igg_cmv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ag_pp65']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Cmv Fecha ag_pp65").': '.__("Evoluciones_Cmv error ".$form['ag_pp65']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Cmv Guardar");?>" />
 
</form>
