<form action="<?php echo url_for('@evolucionSalvarEcg');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveEcgForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecg Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecg Fecha").': '.__("Evoluciones_Ecg error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecg rs_ecg");?></h4>
	<div class="form_block_field<?php if($form['rs_ecg']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['rs_ecg']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['rs_ecg']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecg rs_ecg").': '.__("Evoluciones_Ecg error ".$form['rs_ecg']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecg hvi_ecg");?></h4>
	<div class="form_block_field<?php if($form['hvi_ecg']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hvi_ecg']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hvi_ecg']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecg hvi_ecg").': '.__("Tratamiento_error ".$form['hvi_ecg']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecg onda_q_ecg");?></h4>
	<div class="form_block_field<?php if($form['onda_q_ecg']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['onda_q_ecg']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['onda_q_ecg']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecg onda_q_ecg").': '.__("Evoluciones_Ecg error ".$form['ag_pp65']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Ecg Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteEcg(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Ecg esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionEcg");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
