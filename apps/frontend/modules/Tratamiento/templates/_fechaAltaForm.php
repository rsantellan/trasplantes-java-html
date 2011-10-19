<form class="trasplante_fecha_alta_form" id="cambiar_fecha_alta_form" method="POST" action="<?php echo url_for("@guardarFechaAltaTratamiento");?>" onsubmit="return tratamientoManagement.getInstance().saveFechaAltaForm(this)">
  <?php echo $form->renderHiddenFields();?>
  <h2><?php echo __("Tratamiento_fecha de alta");?></h2>
  <?php echo $form['fecha']->render();?>
  <?php 
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Tratamiento_fecha de alta").': '.__("Tratamiento_error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
  ?>  
  <?php echo $form->renderGlobalErrors(); ?>
  
  <hr/>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Tratamiento_Guardar Fecha de alta del tratamiento");?>"/>
</form>
