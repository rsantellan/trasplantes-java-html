<form action="<?php echo url_for('@salvarEvolucionInjerto');?>" method="post" onsubmit="return manejadorInjertoEvolucion.getInstance().saveForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_Fecha").': '.__("InjertoEvolucions_error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_pbrs list");?></h4>
	<div class="form_block_field<?php if($form['injerto_evolucion_pbrs_list']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['injerto_evolucion_pbrs_list']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['injerto_evolucion_pbrs_list']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_pbrs list").': '.__("InjertoEvolucions_error ".$form['injerto_evolucion_pbrs_list']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_ra tratamiento_id");?></h4>
	<div class="form_block_field<?php if($form['ra_tratamiento_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ra_tratamiento_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ra_tratamiento_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_ra tratamiento_id").': '.__("Tratamiento_error ".$form['ra_tratamiento_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_tm cual");?></h4>
	<div class="form_block_field<?php if($form['tm_cual']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tm_cual']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tm_cual']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_tm cual").': '.__("InjertoEvolucions_error ".$form['tm_cual']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_tm");?></h4>
	<div class="form_block_field<?php if($form['tm']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tm']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tm']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_tm").': '.__("InjertoEvolucions_error ".$form['tm']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_gp de_novo");?></h4>
	<div class="form_block_field<?php if($form['gp_de_novo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['gp_de_novo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['gp_de_novo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_gp de_novo").': '.__("InjertoEvolucions_error ".$form['gp_de_novo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_recidiva gp_de_novo");?></h4>
	<div class="form_block_field<?php if($form['recidiva_gp_de_novo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['recidiva_gp_de_novo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['recidiva_gp_de_novo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_recidiva gp_de_novo").': '.__("InjertoEvolucions_error ".$form['recidiva_gp_de_novo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_ra");?></h4>
	<div class="form_block_field<?php if($form['ra']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ra']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ra']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_ra").': '.__("InjertoEvolucions_error ".$form['ra']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("InjertoEvolucions_rc");?></h4>
	<div class="form_block_field<?php if($form['rc']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['rc']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['rc']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("InjertoEvolucions_rc").': '.__("InjertoEvolucions_error ".$form['rc']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
   <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("InjertoEvolucions_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorInjertoEvolucion.getInstance().delete(<?php echo $form->getObject()->getId();?>, '<?php echo __("InjertoEvolucions_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionInjerto");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
