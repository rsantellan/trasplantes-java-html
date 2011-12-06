<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>

<form action="<?php echo url_for('consulta/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
<?php echo $form->renderHiddenFields(false) ?>
  <div class="form_block">
    <h4><?php echo __("consulta_nombre");?></h4>
    <div class="form_block_field<?php if($form['nombre']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['nombre']->render(array('size'=> '100')) ?>
    </div>
    <div>
      <?php 
      
      if($form['nombre']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("consulta_nombre").': '.__("consulta_error ".$form['nombre']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>
  </div> 
  <div class="clear"></div>
  <div class="form_block">
    <h4><?php echo __("consulta_sentencia");?></h4>
    <div class="form_block_field<?php if($form['sentencia']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['sentencia']->render(array('cols' => 120, 'rows' => 6)) ?>
    </div>
    <div>
      <?php 
      
      if($form['sentencia']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("consulta_sentencia").': '.__("consulta_error ".$form['sentencia']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>
  </div> 
  <div class="clear"></div>
  <input class="save_button" type="submit" value="<?php echo __("consulta_Guardar");?>"/>
</form>
<?php if (!$form->getObject()->isNew()): ?>
    &nbsp;<?php echo link_to('Delete', 'consulta/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
<?php endif; ?>

<?php if (!$form->getObject()->isNew()): ?>
  <div class="clear">

  </div>
<?php endif; ?>
