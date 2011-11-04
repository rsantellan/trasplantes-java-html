<form action="<?php echo url_for('@evolucionSalvarParaclinica');?>" method="post" onsubmit="return manejadorEvolucionesManagement.getInstance().saveParaclinicaForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica Fecha");?></h4>
	<div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fecha']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica Fecha").': '.__("Evoluciones_Paraclinica error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica pas");?></h4>
	<div class="form_block_field<?php if($form['pas']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['pas']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['pas']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica pas").': '.__("Evoluciones_Paraclinica error ".$form['pas']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
    <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica pad");?></h4>
	<div class="form_block_field<?php if($form['pad']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['pad']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['pad']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica pad").': '.__("Tratamiento_error ".$form['pad']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica diuresis");?></h4>
	<div class="form_block_field<?php if($form['diuresis']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['diuresis']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['diuresis']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica diuresis").': '.__("Evoluciones_Paraclinica error ".$form['diuresis']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica peso");?></h4>
	<div class="form_block_field<?php if($form['peso']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['peso']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['peso']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica peso").': '.__("Tratamiento_error ".$form['peso']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica urea");?></h4>
	<div class="form_block_field<?php if($form['urea']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['urea']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['urea']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica urea").': '.__("Evoluciones_Paraclinica error ".$form['urea']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica creatinina");?></h4>
	<div class="form_block_field<?php if($form['creatinina']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['creatinina']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['creatinina']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica creatinina").': '.__("Tratamiento_error ".$form['creatinina']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica ht");?></h4>
	<div class="form_block_field<?php if($form['ht']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ht']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ht']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica ht").': '.__("Evoluciones_Paraclinica error ".$form['ht']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica hb");?></h4>
	<div class="form_block_field<?php if($form['hb']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hb']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hb']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica hb").': '.__("Tratamiento_error ".$form['hb']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica gb");?></h4>
	<div class="form_block_field<?php if($form['gb']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['gb']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['gb']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica gb").': '.__("Evoluciones_Paraclinica error ".$form['gb']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica plaquetas");?></h4>
	<div class="form_block_field<?php if($form['plaquetas']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['plaquetas']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['plaquetas']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica plaquetas").': '.__("Tratamiento_error ".$form['plaquetas']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica sodio");?></h4>
	<div class="form_block_field<?php if($form['sodio']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['sodio']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['sodio']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica sodio").': '.__("Evoluciones_Paraclinica error ".$form['sodio']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica potasio");?></h4>
	<div class="form_block_field<?php if($form['potasio']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['potasio']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['potasio']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica potasio").': '.__("Tratamiento_error ".$form['potasio']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica calcio");?></h4>
	<div class="form_block_field<?php if($form['calcio']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['calcio']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['calcio']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica calcio").': '.__("Evoluciones_Paraclinica error ".$form['calcio']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica fosforo");?></h4>
	<div class="form_block_field<?php if($form['fosforo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fosforo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fosforo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica fosforo").': '.__("Tratamiento_error ".$form['fosforo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica glicemia");?></h4>
	<div class="form_block_field<?php if($form['glicemia']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['glicemia']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['glicemia']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica glicemia").': '.__("Evoluciones_Paraclinica error ".$form['glicemia']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica uricemia");?></h4>
	<div class="form_block_field<?php if($form['uricemia']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['uricemia']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['uricemia']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica uricemia").': '.__("Tratamiento_error ".$form['uricemia']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica prot_u");?></h4>
	<div class="form_block_field<?php if($form['prot_u']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['prot_u']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['prot_u']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica prot_u").': '.__("Evoluciones_Paraclinica error ".$form['prot_u']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica ccreatinina");?></h4>
	<div class="form_block_field<?php if($form['ccreatinina']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ccreatinina']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ccreatinina']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica ccreatinina").': '.__("Tratamiento_error ".$form['ccreatinina']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica curea");?></h4>
	<div class="form_block_field<?php if($form['curea']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['curea']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['curea']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica curea").': '.__("Evoluciones_Paraclinica error ".$form['curea']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica na_u");?></h4>
	<div class="form_block_field<?php if($form['na_u']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['na_u']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['na_u']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica na_u").': '.__("Tratamiento_error ".$form['na_u']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica ku");?></h4>
	<div class="form_block_field<?php if($form['ku']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ku']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ku']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica ku").': '.__("Evoluciones_Paraclinica error ".$form['ku']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica cya_pv");?></h4>
	<div class="form_block_field<?php if($form['cya_pv']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cya_pv']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cya_pv']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica cya_pv").': '.__("Tratamiento_error ".$form['cya_pv']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica cya_pp");?></h4>
	<div class="form_block_field<?php if($form['cya_pp']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cya_pp']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['cya_pp']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica cya_pp").': '.__("Tratamiento_error ".$form['cya_pp']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica fk_p");?></h4>
	<div class="form_block_field<?php if($form['fk_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fk_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fk_p']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica fk_p").': '.__("Tratamiento_error ".$form['fk_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica mfm_p");?></h4>
	<div class="form_block_field<?php if($form['mfm_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['mfm_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['mfm_p']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica mfm_p").': '.__("Tratamiento_error ".$form['mfm_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica eve_p");?></h4>
	<div class="form_block_field<?php if($form['eve_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['eve_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['eve_p']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica eve_p").': '.__("Tratamiento_error ".$form['eve_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica bd");?></h4>
	<div class="form_block_field<?php if($form['bd']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['bd']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['bd']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica bd").': '.__("Tratamiento_error ".$form['bd']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica bi");?></h4>
	<div class="form_block_field<?php if($form['bi']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['bi']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['bi']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica bi").': '.__("Tratamiento_error ".$form['bi']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica tgo");?></h4>
	<div class="form_block_field<?php if($form['tgo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tgo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tgo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica tgo").': '.__("Tratamiento_error ".$form['tgo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica tgp");?></h4>
	<div class="form_block_field<?php if($form['tgp']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tgp']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tgp']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica tgp").': '.__("Tratamiento_error ".$form['tgp']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica gammagt");?></h4>
	<div class="form_block_field<?php if($form['gammagt']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['gammagt']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['gammagt']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica gammagt").': '.__("Tratamiento_error ".$form['gammagt']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica f_alc");?></h4>
	<div class="form_block_field<?php if($form['f_alc']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['f_alc']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['f_alc']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica f_alc").': '.__("Tratamiento_error ".$form['f_alc']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica t_prot");?></h4>
	<div class="form_block_field<?php if($form['t_prot']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['t_prot']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['t_prot']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica t_prot").': '.__("Tratamiento_error ".$form['t_prot']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica kptt");?></h4>
	<div class="form_block_field<?php if($form['kptt']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['kptt']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['kptt']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica kptt").': '.__("Tratamiento_error ".$form['kptt']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica howell");?></h4>
	<div class="form_block_field<?php if($form['howell']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['howell']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['howell']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica howell").': '.__("Tratamiento_error ".$form['howell']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica fibrinogeno");?></h4>
	<div class="form_block_field<?php if($form['fibrinogeno']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['fibrinogeno']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['fibrinogeno']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica fibrinogeno").': '.__("Tratamiento_error ".$form['fibrinogeno']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica colesterol");?></h4>
	<div class="form_block_field<?php if($form['colesterol']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['colesterol']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['colesterol']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica colesterol").': '.__("Tratamiento_error ".$form['colesterol']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica hdl");?></h4>
	<div class="form_block_field<?php if($form['hdl']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hdl']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hdl']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica hdl").': '.__("Tratamiento_error ".$form['hdl']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica ldl");?></h4>
	<div class="form_block_field<?php if($form['ldl']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['ldl']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['ldl']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica ldl").': '.__("Tratamiento_error ".$form['ldl']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica r_at");?></h4>
	<div class="form_block_field<?php if($form['r_at']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['r_at']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['r_at']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica r_at").': '.__("Tratamiento_error ".$form['r_at']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica tg");?></h4>
	<div class="form_block_field<?php if($form['tg']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tg']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tg']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica tg").': '.__("Tratamiento_error ".$form['tg']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica hna1c");?></h4>
	<div class="form_block_field<?php if($form['hna1c']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['hna1c']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['hna1c']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica hna1c").': '.__("Tratamiento_error ".$form['hna1c']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica albumina");?></h4>
	<div class="form_block_field<?php if($form['albumina']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['albumina']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['albumina']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica albumina").': '.__("Tratamiento_error ".$form['albumina']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica globulinas");?></h4>
	<div class="form_block_field<?php if($form['globulinas']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['globulinas']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['globulinas']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica globulinas").': '.__("Tratamiento_error ".$form['globulinas']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica pthi");?></h4>
	<div class="form_block_field<?php if($form['pthi']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['pthi']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['pthi']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica pthi").': '.__("Tratamiento_error ".$form['pthi']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica otros");?></h4>
	<div class="form_block_field<?php if($form['otros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['otros']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['otros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica otros").': '.__("Tratamiento_error ".$form['otros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>

  <div class="form_block">
	<h4><?php echo __("Evoluciones_Paraclinica numpthi");?></h4>
	<div class="form_block_field<?php if($form['numpthi']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['numpthi']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['numpthi']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Evoluciones_Paraclinica numpthi").': '.__("Tratamiento_error ".$form['numpthi']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("Evoluciones_Paraclinica Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="manejadorEvolucionesManagement.getInstance().deleteParaclinica(<?php echo $form->getObject()->getId();?>, '<?php echo __("Evoluciones_Paraclinica esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarEvolucionParaclinica");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?> 
</form>
