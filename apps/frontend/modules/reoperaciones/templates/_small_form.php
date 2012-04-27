<?php
use_javascript("reoperacionesManagement.js");
//  use_helper('mdAsset');
//  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
//  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<form id="reoperacion_form" onsubmit="return reoperacionesManagement.getInstance().basicFormValidation()" action="<?php echo url_for('reoperaciones/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  <div class="form_block">
	<h4><?php echo __("reoperacion_Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("reoperacion_Fecha").': '.__("reoperacion_error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>  
  <div class="form_block">
	<h4><?php echo __("reoperacion_Descripcion");?></h4>
	<div class="form_block_field<?php if($form['descripcion']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['descripcion']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['descripcion']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("reoperacion_Descripcion").': '.__("reoperacion_error ".$form['descripcion']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  
  <div class="clear"></div>
  <div class="form_block">
  
	<h4><?php echo __("reoperacion_complicacion es infecciosa");?></h4>
	<div class="form_block_field<?php if($form['es_infecciosa']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['es_infecciosa']->render(array('onchange'=>'reoperacionesManagement.getInstance().showHideComplicationType(this)')) ?>
	</div>
	<div>
		<?php 
		
		if($form['es_infecciosa']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("reoperacion_complicacion es infecciosa").': '.__("reoperacion_error ".$form['es_infecciosa']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <?php 
	$infecciosa = ($form->getObject()->getEsInfecciosa());
  ?>
  <div id="complicacion_infecciosa" class="form_block <?php echo ($infecciosa == 0)? '' : 'hide'; ?>">
	<h4><?php echo __("reoperacion_complicacion infecciosa");?></h4>
	<div class="form_block_field<?php if($form['trasplante_complicacion_infeccion_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['trasplante_complicacion_infeccion_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['trasplante_complicacion_infeccion_id']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("reoperacion_complicacion infecciosa").': '.__("reoperacion_error ".$form['trasplante_complicacion_infeccion_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  
  <div id="complicacion_no_infecciosa" class="form_block <?php echo ($infecciosa == 1)? '' : 'hide'; ?>">
	<h4><?php echo __("reoperacion_complicacion no infecciosa");?></h4>
	<div class="form_block_field<?php if($form['trasplante_complicacion_no_infeccion_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['trasplante_complicacion_no_infeccion_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['trasplante_complicacion_no_infeccion_id']->hasError()): 
		?>  
	  <div class="clear"></div>
	  <label>
		<?php
		  $msg_error = __("reoperacion_complicacion no infecciosa").': '.__("reoperacion_error ".$form['trasplante_complicacion_no_infeccion_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	  </label>
	</div>	
  </div>
  <div class="clear"></div>
  
  <a href="<?php echo url_for("@manejarReoperaciones?id=".$form->getObject()->getTrasplanteId());?>" class="save_button"><?php echo __("reoperacion_Cancelar");?></a> 
  <input class="save_button" type="submit" value="<?php echo __("reoperacion_Guardar");?>"/>
</form>
<div class="clear"></div>

<input type="hidden" id="reoperacion_sin_infeccion_error" value="<?php echo __("reoperacion_tiene que elejir una complicacion");?>" />