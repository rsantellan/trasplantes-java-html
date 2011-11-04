<form action="<?php echo url_for('@evolucionSalvarEcodopler');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveEcodoplerForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler Fecha").': '.__("Evoluciones_Ecodopler error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler estructura");?></h4>
	<div class="form_block_field<?php if($form['estructura']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['estructura']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['estructura']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler estructura").': '.__("Evoluciones_Ecodopler error ".$form['estructura']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler dilatacion");?></h4>
	<div class="form_block_field<?php if($form['dilatacion']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dilatacion']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dilatacion']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler dilatacion").': '.__("Tratamiento_error ".$form['dilatacion']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler colecciones");?></h4>
	<div class="form_block_field<?php if($form['colecciones']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['colecciones']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['colecciones']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler colecciones").': '.__("Evoluciones_Ecodopler error ".$form['colecciones']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler eje_arterial");?></h4>
	<div class="form_block_field<?php if($form['eje_arterial']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['eje_arterial']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['eje_arterial']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler eje_arterial").': '.__("Tratamiento_error ".$form['eje_arterial']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler eje_venoso");?></h4>
	<div class="form_block_field<?php if($form['eje_venoso']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['eje_venoso']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['eje_venoso']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler eje_venoso").': '.__("Evoluciones_Ecodopler error ".$form['eje_venoso']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler arteria_renal");?></h4>
	<div class="form_block_field<?php if($form['arteria_renal']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['arteria_renal']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['arteria_renal']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler arteria_renal").': '.__("Tratamiento_error ".$form['arteria_renal']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler vena_renal");?></h4>
	<div class="form_block_field<?php if($form['vena_renal']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['vena_renal']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['vena_renal']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler vena_renal").': '.__("Evoluciones_Ecodopler error ".$form['vena_renal']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler anast_venosa");?></h4>
	<div class="form_block_field<?php if($form['anast_venosa']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['anast_venosa']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['anast_venosa']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler anast_venosa").': '.__("Tratamiento_error ".$form['anast_venosa']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler anast_renosa");?></h4>
	<div class="form_block_field<?php if($form['anast_renosa']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['anast_renosa']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['anast_renosa']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler anast_renosa").': '.__("Evoluciones_Ecodopler error ".$form['anast_renosa']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler indice");?></h4>
	<div class="form_block_field<?php if($form['indice']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['indice']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['indice']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler indice").': '.__("Tratamiento_error ".$form['indice']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecodopler otros");?></h4>
	<div class="form_block_field<?php if($form['otros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['otros']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['otros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecodopler otros").': '.__("Evoluciones_Ecodopler error ".$form['otros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Ecodopler Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteEcodopler(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Ecodopler esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionEcodopler");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
