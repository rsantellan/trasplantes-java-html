<form action="<?php echo url_for('PacienteMuerte/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?paciente_id='.$form->getObject()->getPacienteId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  <div class="form_block">
    <h4><?php echo __("pacienteMuerte_Causa");?></h4>
    <div class="form_block_field<?php if($form['causa_muerte_id']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['causa_muerte_id']->render() ?>
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
  <input class="save_button" type="submit" value="<?php echo __("pacienteMuerte_Guardar");?>"/>  
</form>
<div class="clear"></div>
