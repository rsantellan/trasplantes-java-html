<form action="<?php echo url_for('@salvarDonante');?>" method="post" onsubmit="return donantesManagement.getInstance().saveForm(this)">
<?php echo $form->renderHiddenFields(false) ?>
<?php echo $form->renderGlobalErrors(); ?>
  <div class="form_block">
	<h4><?php echo __("donante_identificador");?></h4>
	<div class="form_block_field<?php if($form['identificador']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['identificador']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['identificador']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_identificador").': '.__("donante_error ".$form['identificador']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_tipo de donante");?></h4>
	<div class="form_block_field<?php if($form['tipo_donante']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['tipo_donante']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['tipo_donante']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_tipo de donante").': '.__("donante_error ".$form['tipo_donante']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("donante_sexo");?></h4>
	<div class="form_block_field<?php if($form['sexo_donante']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['sexo_donante']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['sexo_donante']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_sexo").': '.__("donante_error ".$form['sexo_donante']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_edad");?></h4>
	<div class="form_block_field<?php if($form['edad_donante']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['edad_donante']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['edad_donante']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_edad").': '.__("donante_error ".$form['edad_donante']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  
  <div class="form_block">
	<h4><?php echo __("donante_enastab hemod");?></h4>
	<div class="form_block_field<?php if($form['enastab_hemod']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['enastab_hemod']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['enastab_hemod']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_enastab hemod").': '.__("donante_error ".$form['enastab_hemod']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("donante_causa de muerte");?></h4>
	<div class="form_block_field<?php if($form['donante_causa_muerte_id']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['donante_causa_muerte_id']->render() ?>
	</div>
    <a href="javascript:void(0)" class="simple_tip_container" onclick="return donantesManagement.getInstance().showCausaMuerteManagement('<?php echo url_for("@manejarDonanteCausaMuerte");?>');">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("donante_manejar causa muerte");?></div>		
    </a>
	<div>
		<?php 
		
		if($form['donante_causa_muerte_id']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_causa de muerte").': '.__("donante_error ".$form['donante_causa_muerte_id']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  
  <div class="form_block">
	<h4><?php echo __("donante_cr p");?></h4>
	<div class="form_block_field<?php if($form['cr_p']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['cr_p']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['enastab_hemod']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_cr p").': '.__("donante_error ".$form['cr_p']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("donante_grupo sanguineo");?></h4>
	<div class="form_block_field<?php if($form['grupo_sanguineo']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['grupo_sanguineo']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['grupo_sanguineo']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_grupo sanguineo").': '.__("donante_error ".$form['grupo_sanguineo']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_relacion filiar");?></h4>
	<div class="form_block_field<?php if($form['relacion_filiar']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['relacion_filiar']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['relacion_filiar']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_relacion filiar").': '.__("donante_error ".$form['relacion_filiar']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("donante_peso");?></h4>
	<div class="form_block_field<?php if($form['peso']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['peso']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['peso']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_peso").': '.__("donante_error ".$form['peso']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_altura");?></h4>
	<div class="form_block_field<?php if($form['altura']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['altura']->render() ?>
	</div>
	<div>
		<?php 
		
		if($form['altura']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_altura").': '.__("donante_error ".$form['altura']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_lista de organos");?></h4>
	<div class="form_block_field<?php if($form['donante_organos_list']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['donante_organos_list']->render() ?>
	</div>
    <a href="javascript:void(0)" class="simple_tip_container" onclick="return donantesManagement.getInstance().showOrganosManagement('<?php echo url_for("@manejarDonanteOrganos");?>');">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("donante_manejar");?></div>		
    </a>  
	<div>
		<?php 
		
		if($form['donante_organos_list']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_lista de organos").': '.__("donante_error ".$form['donante_organos_list']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="form_block">
	<h4><?php echo __("donante_lista de antecedentes");?></h4>
	<div class="form_block_field<?php if($form['donante_antecedentes_list']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['donante_antecedentes_list']->render() ?>
	</div>
    <a href="javascript:void(0)" class="simple_tip_container" onclick="return donantesManagement.getInstance().showAntecedentesManagement('<?php echo url_for("@manejarDonanteAntecedentes");?>');">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("donante_manejar");?></div>		
    </a>
	<div>
    
		<?php 
		
		if($form['donante_antecedentes_list']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_lista de antecedentes").': '.__("donante_error ".$form['donante_antecedentes_list']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  
  <div class="clear"></div>
  
  <div class="form_block">
	<h4><?php echo __("donante_otros");?></h4>
	<div class="form_block_field<?php if($form['otros']->hasError()):?> error_msg<?php endif; ?>">
	  <?php echo $form['otros']->render(array('cols' => 62)) ?>
	</div>
	<div>
		<?php 
		
		if($form['otros']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("donante_otros").': '.__("donante_error ".$form['otros']->getError());
		  echo $msg_error;  
		endif; 
		?>
	</div>
  </div>
  
  <div class="clear"></div>
	<?php include_component("donante", "retrieveSeroles", array("id" => $form->getObject()->getId()));?>
	
  <div class="clear"></div>
  <br/>
  <hr/>
  <input class="save_button" type="submit" value="<?php echo __("donante_Guardar");?>" />
  <?php if(!$form->isNew()): ?>
    <a href="javascript:void(0);" onclick="donantesManagement.getInstance().deleteDonante(<?php echo $form->getObject()->getId();?>, '<?php echo __("donante_esta seguro de querer eliminar?");?>','<?php echo url_for("@eliminarDonante");?>');">
      <?php echo image_tag("trash.png", array("width" => 24)); ?>
    </a>
  <?php endif;?>   
</form>
