<div class="reoperacion_basic_info">
  <ul>
	<li><?php echo __("reoperacion_fecha");?> : <label class="bold_text"><?php echo format_date($reoperacion->getFecha(), 'D');?></label></li>
	<li><?php echo __("reoperacion_descripcion");?> : <label class="bold_text"><?php echo $reoperacion->getDescripcion()?></label></li>
	<li>
	  <?php 
	  if($reoperacion->getEsInfecciosa()):
		echo __("reoperacion_es infecciosa");
		$complicacion = $reoperacion->getTrasplanteComplicacionesInfecciosas();
	  ?>
	  <ul class="complicacion_no_infecciosa_show_ul">
		<li><?php echo __("trasplanteComplicacion_fecha");?> : <label class="bold_text"><?php echo format_date($complicacion->getFecha(), "D"); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_medicacion");?> : <label class="bold_text"><?php echo $complicacion->getMedicaciones()->getNombre(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_Infeccion");?> : <label class="bold_text"><?php echo $complicacion->getInfeccion()->getNombre(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_Germen");?> : <label class="bold_text"><?php echo $complicacion->getGermenes()->getNombre(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_internado");?> : <label class="bold_text"><?php echo ($complicacion->getInternado())? __("trasplanteComplicacion_si") : __("trasplanteComplicacion_no"); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_dias internado");?> : <label class="bold_text"><?php echo $complicacion->getDiasDeInternacion(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_comentario");?> : <label class="bold_text"><?php echo $complicacion->getComentario(); ?></label></li>
	  </ul>
	  <?php 
	  else: 
		echo __("reoperacion_no es infecciosa");
		$complicacion = $reoperacion->getTrasplanteComplicacionesNoInfecciosas();
//		var_dump($complicacion->toArray());
//		var_dump($reoperacion->toArray());
	  ?>
	  <ul class="complicacion_no_infecciosa_show_ul">
		<li><?php echo __("trasplanteComplicacion_fecha");?> : <label class="bold_text"><?php echo format_date($complicacion->getFecha(), "D"); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_medicacion");?> : <label class="bold_text"><?php echo $complicacion->getMedicaciones()->getNombre(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_tipo de complicacion");?> : <label class="bold_text"><?php echo $complicacion->getComplicacionesTiposValores()->__toString(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_internado");?> : <label class="bold_text"><?php echo ($complicacion->getInternado())? __("trasplanteComplicacion_si") : __("trasplanteComplicacion_no"); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_dias internado");?> : <label class="bold_text"><?php echo $complicacion->getDiasDeInternacion(); ?></label></li>
		<li><?php echo __("trasplanteComplicacion_comentario");?> : <label class="bold_text"><?php echo $complicacion->getComentario(); ?></label></li>
	  </ul>

	  <?php	
	  endif; 
	  ?>
	</li>
  </ul>
</div>