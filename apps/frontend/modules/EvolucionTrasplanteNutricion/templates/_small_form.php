<form action="<?php echo url_for('@evolucionSalvarNutricion');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveNutricionForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion Fecha").': '.__("Evoluciones_Nutricion error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion talla");?></h4>
	<div class="form_block_field<?php if($form['talla']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['talla']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['talla']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion talla").': '.__("Evoluciones_Nutricion error ".$form['talla']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion peso_deseado");?></h4>
	<div class="form_block_field<?php if($form['peso_deseado']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['peso_deseado']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['peso_deseado']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion peso_deseado").': '.__("Tratamiento_error ".$form['peso_deseado']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion estructura_osea");?></h4>
	<div class="form_block_field<?php if($form['estructura_osea']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['estructura_osea']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['estructura_osea']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion estructura_osea").': '.__("Evoluciones_Nutricion error ".$form['estructura_osea']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion impresion");?></h4>
	<div class="form_block_field<?php if($form['impresion']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['impresion']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['impresion']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion impresion").': '.__("Tratamiento_error ".$form['impresion']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion peso_real");?></h4>
	<div class="form_block_field<?php if($form['peso_real']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['peso_real']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['peso_real']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion peso_real").': '.__("Evoluciones_Nutricion error ".$form['peso_real']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_tricipital");?></h4>
	<div class="form_block_field<?php if($form['p_tricipital']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_tricipital']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_tricipital']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_tricipital").': '.__("Tratamiento_error ".$form['p_tricipital']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_tricipital_p");?></h4>
	<div class="form_block_field<?php if($form['p_tricipital_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_tricipital_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_tricipital_p']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_tricipital_p").': '.__("Evoluciones_Nutricion error ".$form['p_tricipital_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_subescapular");?></h4>
	<div class="form_block_field<?php if($form['p_subescapular']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_subescapular']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_subescapular']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_subescapular").': '.__("Tratamiento_error ".$form['p_subescapular']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_subescapular_p");?></h4>
	<div class="form_block_field<?php if($form['p_subescapular_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_subescapular_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_subescapular_p']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_subescapular_p").': '.__("Evoluciones_Nutricion error ".$form['p_subescapular_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion sum_pliegues");?></h4>
	<div class="form_block_field<?php if($form['sum_pliegues']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['sum_pliegues']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['sum_pliegues']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion sum_pliegues").': '.__("Tratamiento_error ".$form['sum_pliegues']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_sum_pliegues");?></h4>
	<div class="form_block_field<?php if($form['p_sum_pliegues']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_sum_pliegues']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_sum_pliegues']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_sum_pliegues").': '.__("Evoluciones_Nutricion error ".$form['p_sum_pliegues']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion cf_brazo");?></h4>
	<div class="form_block_field<?php if($form['cf_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cf_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cf_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion cf_brazo").': '.__("Tratamiento_error ".$form['cf_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_cf_brazo");?></h4>
	<div class="form_block_field<?php if($form['p_cf_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_cf_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_cf_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_cf_brazo").': '.__("Evoluciones_Nutricion error ".$form['p_cf_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion cf_musc_brazo");?></h4>
	<div class="form_block_field<?php if($form['cf_musc_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cf_musc_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cf_musc_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion cf_musc_brazo").': '.__("Tratamiento_error ".$form['cf_musc_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_cf_musc_brazo");?></h4>
	<div class="form_block_field<?php if($form['p_cf_musc_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_cf_musc_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_cf_musc_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_cf_musc_brazo").': '.__("Evoluciones_Nutricion error ".$form['p_cf_musc_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion area_brazo");?></h4>
	<div class="form_block_field<?php if($form['area_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['area_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['area_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion area_brazo").': '.__("Tratamiento_error ".$form['area_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion area_musc_brazo");?></h4>
	<div class="form_block_field<?php if($form['area_musc_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['area_musc_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['area_musc_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion area_musc_brazo").': '.__("Evoluciones_Nutricion error ".$form['area_musc_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_area_musc_brazo");?></h4>
	<div class="form_block_field<?php if($form['p_area_musc_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_area_musc_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_area_musc_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_area_musc_brazo").': '.__("Tratamiento_error ".$form['p_area_musc_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion area_grasa_brazo");?></h4>
	<div class="form_block_field<?php if($form['area_grasa_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['area_grasa_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['area_grasa_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion area_grasa_brazo").': '.__("Evoluciones_Nutricion error ".$form['area_grasa_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion p_area_grasa_brazo");?></h4>
	<div class="form_block_field<?php if($form['p_area_grasa_brazo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['p_area_grasa_brazo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['p_area_grasa_brazo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion p_area_grasa_brazo").': '.__("Tratamiento_error ".$form['p_area_grasa_brazo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion r_cintura_cadera");?></h4>
	<div class="form_block_field<?php if($form['r_cintura_cadera']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['r_cintura_cadera']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['r_cintura_cadera']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion r_cintura_cadera").': '.__("Evoluciones_Nutricion error ".$form['r_cintura_cadera']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Nutricion diag_nutricional");?></h4>
	<div class="form_block_field<?php if($form['diag_nutricional']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['diag_nutricional']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['diag_nutricional']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Nutricion diag_nutricional").': '.__("Tratamiento_error ".$form['diag_nutricional']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Nutricion Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteNutricion(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Nutricion esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionNutricion");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
