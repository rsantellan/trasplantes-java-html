<form action="<?php echo url_for('@evolucionSalvarEcografia');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveEcografiaForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia Fecha").': '.__("Evoluciones_Ecografia error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia diametros");?></h4>
	<div class="form_block_field<?php if($form['diametros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['diametros']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['diametros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia diametros").': '.__("Evoluciones_Ecografia error ".$form['diametros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia dilatacion");?></h4>
	<div class="form_block_field<?php if($form['dilatacion']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dilatacion']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dilatacion']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia dilatacion").': '.__("Tratamiento_error ".$form['dilatacion']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia litiasin");?></h4>
	<div class="form_block_field<?php if($form['litiasin']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['litiasin']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['litiasin']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia litiasin").': '.__("Evoluciones_Ecografia error ".$form['litiasin']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia vejiga");?></h4>
	<div class="form_block_field<?php if($form['vejiga']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['vejiga']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['vejiga']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia vejiga").': '.__("Tratamiento_error ".$form['vejiga']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia espesor");?></h4>
	<div class="form_block_field<?php if($form['espesor']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['espesor']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['espesor']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia espesor").': '.__("Evoluciones_Ecografia error ".$form['espesor']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecografia otros");?></h4>
	<div class="form_block_field<?php if($form['otros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['otros']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['otros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecografia otros").': '.__("Evoluciones_Ecografia error ".$form['otros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Ecografia Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteEcografia(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Ecografia esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionEcografia");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
