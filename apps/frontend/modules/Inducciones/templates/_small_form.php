<form class="nefropatia_new_form" action="<?php echo url_for('@salvarInduccion');?>" method="post" onsubmit="return trasplanteNewManagement.getInstance().saveInduccionForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("induccion_nombre");?></h4>
	<div class="form_block_field<?php if($form['nombre']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['nombre']->render() ?>
	</div>
	<div>
		<?php 
		if($form['nombre']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("induccion_nombre").': '.__("induccion_error ".$form['nombre']->getError());
		  echo $msg_error;  
		endif; 
		?>
    <div class="donante_causa_muerte_delete_error" style="display: none;">
      <?php echo __("induccion_error no se puede borrar por que un trasplante la esta usando");?>
    </div>
  </div>
  
  </div>
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("induccion_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="trasplanteNewManagement.getInstance().deleteInduccion(<?php echo $form->getObject()->getId();?>, '<?php echo __("induccion_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarInduccion");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
