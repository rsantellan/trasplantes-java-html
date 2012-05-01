<?php 

  use_javascript("causaMuerteManagement.js");
  use_javascript("muertePaciente.js");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<form action="<?php echo url_for('PacienteMuerte/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?paciente_id='.$form->getObject()->getPacienteId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  <div class="form_block">
    <h4><?php echo __("pacienteMuerte_Causa");?></h4>
    <div class="form_block_field<?php if($form['causa_muerte_id']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['causa_muerte_id']->render() ?>
      <a id="manage_causas_link" href="<?php echo url_for("@manejarCausaMuerte");?>" class="simple_tip_container">
		<?php echo image_tag("add_block.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("CausaMuerte_manejar");?></div>		
	</a>
    </div>
    <div>
      <?php 
      if($form['causa_muerte_id']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
      $msg_error = __("pacienteMuerte_Causa").': '.__("pacienteMuerte_error ".$form['causa_muerte_id']->getError());
      echo $msg_error;  
      endif; 
      ?>
    </div>
  </div> 
  <div class="form_block">
    <h4><?php echo __("pacienteMuerte_Fecha de muerte");?></h4>
	<a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
	</a>	
    <div class="form_block_field<?php if($form['fecha_muerte']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['fecha_muerte']->render() ?>
    </div>
    <div>
      <?php 
      if($form['fecha_muerte']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
      $msg_error = __("pacienteMuerte_Fecha de muerte").': '.__("pacienteMuerte_error ".$form['fecha_muerte']->getError());
      echo $msg_error;  
      endif; 
      ?>
    </div>
  </div>
  <div class="clear"></div>
  <div class="form_block">
    <h4><?php echo __("pacienteMuerte_Trasplante funcionando");?></h4>
    <div class="form_block_field<?php if($form['transplante_funcionando']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['transplante_funcionando']->render() ?>
    </div>
    <div>
      <?php 
      if($form['transplante_funcionando']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
      $msg_error = __("pacienteMuerte_Trasplante funcionando").': '.__("pacienteMuerte_error ".$form['transplante_funcionando']->getError());
      echo $msg_error;  
      endif; 
      ?>
    </div>
  </div>
  <div class="clear"></div>
  <a class="cancel_href" href="<?php echo url_for("@editarEstadoPaciente?id=".$form->getObject()->getPacienteId()); ?>"><?php echo __("pacienteMuerte_Cancelar");?></a>
  <?php if (!$form->getObject()->isNew()): ?>
	<?php echo link_to(__("pacienteMuerte_Eliminar"), 'PacienteMuerte/delete?id='.$form->getObject()->getPacienteId(), array('class'=> 'cancel_href' , 'method' => 'delete', 'confirm' => __("pacienteMuerte_Esta seguro de querer eliminar?"))) ?>
  <?php endif; ?>  
  
  <input class="save_button" type="submit" value="<?php echo __("pacienteMuerte_Guardar");?>"/>  
  
</form>
<div class="clear"></div>
