<form class="nefropatia_new_form" action="<?php echo url_for('@salvarSerolValor');?>" method="post" onsubmit="return donantesManagement.getInstance().saveSerolValorForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("serolValor_nombre");?></h4>
	<div class="form_block_field<?php if($form['valor']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['valor']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['valor']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("serolValor_nombre").': '.__("serolValor_error ".$form['valor']->getError());
		  echo $msg_error;  
		endif; 
		?>
    <div class="donante_causa_muerte_delete_error" style="display: none;">
      <?php echo __("serolValor_error no se puede borrar por que un donante la esta usando");?>
    </div>
  </div>
  
  </div>
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("serolValor_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="donantesManagement.getInstance().deleteSerolValor(<?php echo $form->getObject()->getId();?>, '<?php echo __("serolValor_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarSerolValor");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
