<form class="nefropatia_new_form" action="<?php echo url_for('@salvarDonanteOrgano');?>" method="post" onsubmit="return donantesManagement.getInstance().saveDonanteOrganoForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("donanteOrgano_nombre");?></h4>
	<div class="form_block_field<?php if($form['nombre']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['nombre']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['nombre']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donanteOrgano_nombre").': '.__("donanteOrgano_error ".$form['nombre']->getError());
		  echo $msg_error;  
		endif; 
		?>
    <div class="donante_causa_muerte_delete_error" style="display: none;">
      <?php echo __("donanteOrgano_error no se puede borrar por que un donante la esta usando");?>
    </div>
  </div>
  
  </div>
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("donanteOrgano_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="donantesManagement.getInstance().deleteDonanteOrgano(<?php echo $form->getObject()->getId();?>, '<?php echo __("donanteOrgano_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarDonanteOrgano");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
