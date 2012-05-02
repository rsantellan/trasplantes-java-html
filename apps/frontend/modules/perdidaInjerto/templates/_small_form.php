<?php 

  use_javascript("causaPerdidaInjertoManagement.js");
  use_javascript("perdidaInjertoPaciente.js");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<form action="<?php echo url_for('perdidaInjerto/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  <div class="form_block">
    <h4><?php echo __("pacientePerdidaInjerto_Causa");?></h4>
    <div class="form_block_field<?php if($form['paciente_causa_perdida_injerto_id']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['paciente_causa_perdida_injerto_id']->render() ?>
      <a id="manage_causas_link" href="<?php echo url_for("@manejarCausaPerdidaInjerto");?>" class="simple_tip_container">
		<?php echo image_tag("add_block.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("pacientePerdidaInjerto_manejar");?></div>		
	</a>
    </div>
    <div>
      <?php 
      if($form['paciente_causa_perdida_injerto_id']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
      $msg_error = __("pacientePerdidaInjerto_Causa").': '.__("pacientePerdidaInjerto_error ".$form['paciente_causa_perdida_injerto_id']->getError());
      echo $msg_error;  
      endif; 
      ?>
    </div>
  </div> 
  <div class="form_block">
    <h4><?php echo __("pacientePerdidaInjerto_Fecha de muerte");?></h4>
	<a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
	</a>	
    <div class="form_block_field<?php if($form['fecha_perdida']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['fecha_perdida']->render() ?>
    </div>
    <div>
      <?php 
      if($form['fecha_perdida']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
      $msg_error = __("pacientePerdidaInjerto_Fecha de muerte").': '.__("pacientePerdidaInjerto_error ".$form['fecha_perdida']->getError());
      echo $msg_error;  
      endif; 
      ?>
    </div>
  </div>
  <div class="clear"></div>
  
  <a class="cancel_href" href="<?php echo url_for("@mostrarPaciente?id=".$form->getObject()->getPacienteId()); ?>"><?php echo __("pacientePerdidaInjerto_Cancelar");?></a>
  <?php if (!$form->getObject()->isNew()): ?>
	<?php echo link_to(__("pacientePerdidaInjerto_Eliminar"), 'perdidaInjerto/delete?id='.$form->getObject()->getId(), array('class'=> 'cancel_href' , 'method' => 'delete', 'confirm' => __("pacientePerdidaInjerto_Esta seguro de querer eliminar?"))) ?>
  <?php endif; ?>  
  
  <input class="save_button" type="submit" value="<?php echo __("pacientePerdidaInjerto_Guardar");?>"/>  
  
</form>
<div class="clear"></div>
