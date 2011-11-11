<form action="<?php echo url_for('@salvarCmv');?>" method="post" onsubmit="return cmvManagement.getInstance().saveCmvForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("CMV_campo fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo fecha").': '.__("CMV_campo error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("CMV_campo diagnostico");?></h4>
	<div class="form_block_field<?php if($form['cmv_diagnostico_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cmv_diagnostico_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cmv_diagnostico_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo diagnostico").': '.__("CMV_campo error ".$form['cmv_diagnostico_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("CMV_campo tipo");?></h4>
	<div class="form_block_field<?php if($form['tipo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tipo']->render(array("onchange" => "cmvManagement.getInstance().showHideEmfermedades();")) ?>
	</div>
	<div>
		<?php 
		
		if($form['tipo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo tipo").': '.__("Tratamiento_error ".$form['tipo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block" id="emfermedades_block">
	<h4><?php echo __("CMV_campo emfermedades");?></h4>
	<div class="form_block_field<?php if($form['cmv_emfermedades_list']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cmv_emfermedades_list']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cmv_emfermedades_list']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo emfermedades").': '.__("CMV_campo error ".$form['cmv_emfermedades_list']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
    
  
  <div class="clear"></div>

  <div class="form_block">
	<h4><?php echo __("CMV_campo droga");?></h4>
	<div class="form_block_field<?php if($form['cmv_droga_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cmv_droga_id']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cmv_droga_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo droga").': '.__("CMV_campo error ".$form['cmv_droga_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  
  <div class="form_block">
	<h4><?php echo __("CMV_campo tratamiento");?></h4>
	<div class="form_block_field<?php if($form['dias_tratamiento']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dias_tratamiento']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dias_tratamiento']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo tratamiento").': '.__("CMV_campo error ".$form['dias_tratamiento']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("CMV_campo efecto secundario");?></h4>
	<div class="form_block_field<?php if($form['efecto_secundario']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['efecto_secundario']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['efecto_secundario']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("CMV_campo efecto secundario").': '.__("CMV_campo error ".$form['efecto_secundario']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("CMV_campo Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="cmvManagement.getInstance().deleteCmv(<?php echo $form->getObject()->getId();?>, '<?php echo __("CMV_campo esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionCmv");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
