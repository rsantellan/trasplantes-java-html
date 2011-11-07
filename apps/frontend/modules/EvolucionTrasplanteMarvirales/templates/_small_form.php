<form action="<?php echo url_for('@evolucionSalvarMarvirales');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveMarviralesForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales Fecha").': '.__("Evoluciones_Marvirales error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales hsv");?></h4>
	<div class="form_block_field<?php if($form['hsv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hsv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hsv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales hsv").': '.__("Evoluciones_Marvirales error ".$form['hsv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales aghbs");?></h4>
	<div class="form_block_field<?php if($form['aghbs']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['aghbs']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['aghbs']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales aghbs").': '.__("Tratamiento_error ".$form['aghbs']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales hbsac");?></h4>
	<div class="form_block_field<?php if($form['hbsac']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hbsac']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hbsac']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales hbsac").': '.__("Evoluciones_Marvirales error ".$form['hbsac']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales hbcac");?></h4>
	<div class="form_block_field<?php if($form['hbcac']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hbcac']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hbcac']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales hbcac").': '.__("Tratamiento_error ".$form['hbcac']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales hvc");?></h4>
	<div class="form_block_field<?php if($form['hvc']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hvc']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hvc']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales hvc").': '.__("Evoluciones_Marvirales error ".$form['hvc']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Marvirales hiv");?></h4>
	<div class="form_block_field<?php if($form['hiv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hiv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hiv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Marvirales hiv").': '.__("Evoluciones_Marvirales error ".$form['hiv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Marvirales Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteMarvirales(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Marvirales esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionMarvirales");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
