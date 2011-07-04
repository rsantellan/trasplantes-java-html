<form class="nefropatia_new_form" action="<?php echo url_for('@salvarSerol');?>" method="post" onsubmit="return donantesManagement.getInstance().saveSerolForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("serol_nombre");?></h4>
	<div class="form_block_field<?php if($form['tipo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tipo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tipo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("serol_nombre").': '.__("serol_error ".$form['tipo']->getError());
		  echo $msg_error;  
		endif; 
		?>
    <div class="donante_causa_muerte_delete_error" style="display: none;">
      <?php echo __("serol_error no se puede borrar por que un donante la esta usando");?>
    </div>
  </div>
  
  </div>
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("serol_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="donantesManagement.getInstance().deleteSerol(<?php echo $form->getObject()->getId();?>, '<?php echo __("serol_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarSerol");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>

<?php if(!$form->isNew()): ?>

  <div class="fancy_manage_container">
  <h2><?php echo __("serol_manejar valor");?></h2>

  <select class="selector_style" id="serol_valor_selector" onchange="donantesManagement.getInstance().showSerolValor()">
    <option value="0">-</option>
    <?php foreach ($form->getObject()->getSerolValor() as $object): ?>
      <option id="serol_valor_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getValor() ?></option>
    <?php endforeach; ?>
  </select>
  <a href="javascript:void(0);" onclick="donantesManagement.getInstance().newSerolValor('<?php echo url_for("@crearSerolValor");?>', <?php echo $form->getObject()->getId();?>);">
    <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
  </a>
  <input type="hidden" id="serol_valor_show_url_input" value="<?php echo url_for("@editarSerolValor");?>"/>

    <div class="clear"></div>
  </div>  

  <div class="clear"></div>

  <div id="serol_valor_container" style="display: none">
    
  </div>

<?php endif;?>
