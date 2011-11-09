<form action="<?php echo url_for('@evolucionSalvarExamenes');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveExamenForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Examenes Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Examenes Fecha").': '.__("Evoluciones_Examenes error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Examenes evolucion_trasplante_examenes_tipo_id");?></h4>
	<div class="form_block_field<?php if($form['evolucion_trasplante_examenes_tipo_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['evolucion_trasplante_examenes_tipo_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['evolucion_trasplante_examenes_tipo_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Examenes evolucion_trasplante_examenes_tipo_id").': '.__("Evoluciones_Examenes error ".$form['evolucion_trasplante_examenes_tipo_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Examenes tipo");?></h4>
	<div class="form_block_field<?php if($form['tipo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tipo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tipo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Examenes tipo").': '.__("Tratamiento_error ".$form['tipo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Examenes comentario");?></h4>
	<div class="form_block_field<?php if($form['comentario']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['comentario']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['comentario']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Examenes comentario").': '.__("Evoluciones_Examenes error ".$form['comentario']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Examenes Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteExamen(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Examenes esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionExamenes");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
