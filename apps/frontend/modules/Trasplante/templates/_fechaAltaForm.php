<form class="trasplante_fecha_alta_form" id="cambiar_fecha_alta_form" method="POST" action="<?php echo url_for("@guardarFechaAlta");?>" onsubmit="return trasplanteShowManagement.getInstance().saveFechaAltaForm()">
  <?php echo $form->renderHiddenFields();?>
  <h2><?php echo __("Trasplante_fecha de alta");?></h2>
  <?php echo $form['fecha']->render();?>
  <?php 
		if($form['fecha']->hasError()): 
		?>  
	  <div class="clear"></div>
		<?php
		  $msg_error = __("Trasplante_fecha de alta").': '.__("Trasplante_error ".$form['fecha']->getError());
		  echo $msg_error;  
		endif; 
  ?>  
  <?php echo $form->renderGlobalErrors(); ?>
  
  <hr/>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Trasplante_Guardar Fecha de alta del trasplante");?>"/>
</form>
