<form class="nefropatia_new_form" action="<?php echo url_for('@salvarNefropatia');?>" method="post" onsubmit="return nefropatiasManagement.getInstance().saveForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("donanteCausaMuerte_nombre");?></h4>
	<div class="form_block_field<?php if($form['nombre']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['nombre']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['nombre']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donanteCausaMuerte_nombre").': '.__("donanteCausaMuerte_error ".$form['nombre']->getError());
		  echo $msg_error;  
		endif; 
		?>
    <div class="nefropatia_delete_error">
      <?php echo __("donanteCausaMuerte_error no se puede borrar por que un donante la esta usando");?>
    </div>
  </div>
  
  </div>
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("donanteCausaMuerte_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="nefropatiasManagement.getInstance().deleteNefropatia(<?php echo $form->getObject()->getId();?>, '<?php echo __("nefropatias_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarNefropatia");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
