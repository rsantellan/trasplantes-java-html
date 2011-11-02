<form action="<?php echo url_for('@evolucionSalvarEcocardio');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveEcocardioForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio Fecha").': '.__("Evoluciones_Ecocardio error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio fevi_normal");?></h4>
	<div class="form_block_field<?php if($form['fevi_normal']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fevi_normal']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fevi_normal']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio fevi_normal").': '.__("Evoluciones_Ecocardio error ".$form['fevi_normal']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio insuf_hipodiast");?></h4>
	<div class="form_block_field<?php if($form['insuf_hipodiast']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['insuf_hipodiast']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['insuf_hipodiast']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio insuf_hipodiast").': '.__("Tratamiento_error ".$form['insuf_hipodiast']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio iao");?></h4>
	<div class="form_block_field<?php if($form['iao']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['iao']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['iao']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio iao").': '.__("Evoluciones_Ecocardio error ".$form['iao']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio eao");?></h4>
	<div class="form_block_field<?php if($form['eao']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['eao']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['eao']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio eao").': '.__("Tratamiento_error ".$form['eao']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio im");?></h4>
	<div class="form_block_field<?php if($form['im']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['im']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['im']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio im").': '.__("Evoluciones_Ecocardio error ".$form['im']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio em");?></h4>
	<div class="form_block_field<?php if($form['em']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['em']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['em']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio em").': '.__("Tratamiento_error ".$form['em']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio ip");?></h4>
	<div class="form_block_field<?php if($form['ip']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ip']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ip']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio ip").': '.__("Evoluciones_Ecocardio error ".$form['ip']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio ep");?></h4>
	<div class="form_block_field<?php if($form['ep']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['em']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ep']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio ep").': '.__("Tratamiento_error ".$form['ep']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio it");?></h4>
	<div class="form_block_field<?php if($form['it']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['it']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['it']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio it").': '.__("Evoluciones_Ecocardio error ".$form['it']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio et");?></h4>
	<div class="form_block_field<?php if($form['et']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['et']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['et']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio et").': '.__("Tratamiento_error ".$form['et']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio derrame");?></h4>
	<div class="form_block_field<?php if($form['derrame']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['derrame']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['derrame']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio derrame").': '.__("Evoluciones_Ecocardio error ".$form['derrame']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio calcif_valvular");?></h4>
	<div class="form_block_field<?php if($form['calcif_valvular']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['calcif_valvular']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['calcif_valvular']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio calcif_valvular").': '.__("Tratamiento_error ".$form['calcif_valvular']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Ecocardio hvi");?></h4>
	<div class="form_block_field<?php if($form['hvi']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hvi']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hvi']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Ecocardio hvi").': '.__("Evoluciones_Ecocardio error ".$form['hvi']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Ecocardio Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteEcocardio(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Ecocardio esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionEcocardio");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
