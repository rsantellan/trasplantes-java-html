<form action="<?php echo url_for('@salvarComplicacionesNoInfecciosa');?>" id="trasplante_complicacion_no_infecciosa_form" method="post" onsubmit="return complicacionesManagement.getInstance().saveFormNoInfecciosa(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_fecha").': '.__("trasplanteComplicacion_error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_medicacion");?></h4>
	<div class="form_block_field<?php if($form['medicacion_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['medicacion_id']->render() ?>
	</div>
	<a href="javascript:void(0)" class="simple_tip_container" onclick="return complicacionesManagement.getInstance().showMedicacionesManagement('<?php echo url_for("@manejarComplicacionMedicacion");?>');">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("trasplanteComplicacion_manejar medicacion");?></div>		
    </a>
	<div>
		<?php 
		
		if($form['medicacion_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_medicacion").': '.__("trasplanteComplicacion_error ".$form['medicacion_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_tipo de complicacion");?></h4>
	<div class="form_block_field<?php if($form['complicacion_valor_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['complicacion_valor_id']->render() ?>
	</div>
	<a href="javascript:void(0)" class="simple_tip_container" onclick="return complicacionesManagement.getInstance().showMedicacionesManagement('<?php echo url_for("@manejarComplicacionMedicacion");?>');">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("donante_manejar causa muerte");?></div>		
    </a>
	
	<div>
		<?php 
		
		if($form['complicacion_valor_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_tipo de complicacion").': '.__("trasplanteComplicacion_error ".$form['complicacion_valor_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <?php 
    $is_evolucion = false;
	if($form->getObject()->getEvolucion())
	{
	  $is_evolucion = true;
	}
  ?>
  
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_internado");?></h4>
	<?php if(!$is_evolucion): ?>
	  <?php echo __("trasplanteComplicacion_si");?>
	<?php else: ?>
	<div class="form_block_field<?php if($form['internado']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['internado']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['internado']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_internado").': '.__("trasplanteComplicacion_error ".$form['internado']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
	<?php endif; ?>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_dias internado");?></h4>
	<?php if(!$is_evolucion): ?>
	  <?php echo __("trasplanteComplicacion_sin dias");?>
	<?php else: ?>
	<div class="form_block_field<?php if($form['dias_de_internacion']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dias_de_internacion']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dias_de_internacion']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_dias internado").': '.__("trasplanteComplicacion_error ".$form['dias_de_internacion']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
	<?php endif; ?>
  </div>
  
  
  
  <div class="form_block">
	<h4><?php echo __("trasplanteComplicacion_comentario");?></h4>
	<div class="form_block_field<?php if($form['comentario']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['comentario']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['comentario']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("trasplanteComplicacion_comentario").': '.__("trasplanteComplicacion_error ".$form['comentario']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <br/>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("trasplanteComplicacion_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="complicacionesManagement.getInstance().deleteTrasplanteComplicacion(<?php echo $form->getObject()->getId();?>, '<?php echo __("trasplanteComplicacion_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarComplicacionNoInfecciosa?id=".$form->getObject()->getId());?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
<div id="auxiliary_fields" style="display: none">

</div>