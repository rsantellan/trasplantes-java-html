<form action="<?php echo url_for('@evolucionSalvarTxTorax');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveTxToraxForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax Fecha").': '.__("Evoluciones_TxTorax error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax rct");?></h4>
	<div class="form_block_field<?php if($form['rct']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['rct']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['rct']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax rct").': '.__("Evoluciones_TxTorax error ".$form['rct']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax foco");?></h4>
	<div class="form_block_field<?php if($form['foco']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['foco']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['foco']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax foco").': '.__("Tratamiento_error ".$form['foco']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax lateralizado");?></h4>
	<div class="form_block_field<?php if($form['lateralizado']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['lateralizado']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['lateralizado']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax lateralizado").': '.__("Evoluciones_TxTorax error ".$form['lateralizado']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax derrame_pleural");?></h4>
	<div class="form_block_field<?php if($form['derrame_pleural']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['derrame_pleural']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['derrame_pleural']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax derrame_pleural").': '.__("Tratamiento_error ".$form['derrame_pleural']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax lateral_derrame");?></h4>
	<div class="form_block_field<?php if($form['lateral_derrame']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['lateral_derrame']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['lateral_derrame']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax lateral_derrame").': '.__("Evoluciones_TxTorax error ".$form['lateral_derrame']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax secuelas");?></h4>
	<div class="form_block_field<?php if($form['secuelas']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['secuelas']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['secuelas']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax secuelas").': '.__("Evoluciones_TxTorax error ".$form['secuelas']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
 
  <div class="form_block">
	<h4><?php echo __("Evoluciones_TxTorax otros");?></h4>
	<div class="form_block_field<?php if($form['otros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['otros']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['otros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_TxTorax otros").': '.__("Evoluciones_TxTorax error ".$form['otros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_TxTorax Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteTxTorax(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_TxTorax esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionTxTorax");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
