<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('Pacientepretrasplante/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors() ?>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_the");?></h4>
	<div class="form_block_field<?php if($form['the']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['the']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['the']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_the").': '.__("pacientePreTrasplante_error ".$form['the']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>  
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_fecha de ingreso a la lista");?></h4>
	<a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
	</a>
	<div class="form_block_field<?php if($form['fecha_ingreso_lista']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['the']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha_ingreso_lista']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_fecha de ingreso a la lista").': '.__("pacientePreTrasplante_error ".$form['fecha_ingreso_lista']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_modalidad de dialisis");?></h4>
	<div class="form_block_field<?php if($form['modalidad_d']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['modalidad_d']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['modalidad_d']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_modalidad de dialisis").': '.__("pacientePreTrasplante_error ".$form['modalidad_d']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_diabetes");?></h4>
	<div class="form_block_field<?php if($form['diabetes']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['diabetes']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['diabetes']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_diabetes").': '.__("pacientePreTrasplante_error ".$form['diabetes']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_imc");?></h4>
	<div class="form_block_field<?php if($form['imc']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['imc']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['imc']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_imc").': '.__("pacientePreTrasplante_error ".$form['imc']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_origen");?></h4>
	<div class="form_block_field<?php if($form['origen']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['origen']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['origen']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_origen").': '.__("pacientePreTrasplante_error ".$form['origen']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>

<!-- aca -->

<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_pbr");?></h4>
	<div class="form_block_field<?php if($form['pbr']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['pbr']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['pbr']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_pbr").': '.__("pacientePreTrasplante_error ".$form['pbr']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_hta");?></h4>
	<div class="form_block_field<?php if($form['hta']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hta']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hta']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_hta").': '.__("pacientePreTrasplante_error ".$form['hta']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_obesidad");?></h4>
	<div class="form_block_field<?php if($form['obesidad']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['obesidad']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['obesidad']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_obesidad").': '.__("pacientePreTrasplante_error ".$form['obesidad']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_dislipemia");?></h4>
	<div class="form_block_field<?php if($form['dislipemia']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['dislipemia']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['dislipemia']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_dislipemia").': '.__("pacientePreTrasplante_error ".$form['dislipemia']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_tabaquismo");?></h4>
	<div class="form_block_field<?php if($form['tabaquismo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tabaquismo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tabaquismo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_tabaquismo").': '.__("pacientePreTrasplante_error ".$form['tabaquismo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_iam");?></h4>
	<div class="form_block_field<?php if($form['iam']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['iam']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['iam']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_iam").': '.__("pacientePreTrasplante_error ".$form['iam']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="clear"></div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_ave");?></h4>
	<div class="form_block_field<?php if($form['ave']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ave']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ave']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_ave").': '.__("pacientePreTrasplante_error ".$form['ave']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>
<div class="form_block">
	<h4><?php echo __("pacientePreTrasplante_revasc cardio");?></h4>
	<div class="form_block_field<?php if($form['revasc_cardio']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['revasc_cardio']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['revasc_cardio']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("pacientePreTrasplante_revasc cardio ").': '.__("pacientePreTrasplante_error ".$form['revasc_cardio']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
</div>

<div class="clear"></div>
  <table>
    
    <tbody>
    </tbody>
<tfoot>
      <tr>
        <td colspan="2">
          
          &nbsp;<a href="<?php echo url_for('Pacientepretrasplante/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'Pacientepretrasplante/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
          <?php endif; ?>
          <input type="submit" value="Save" />
        </td>
      </tr>
    </tfoot>
  </table>
</form>
