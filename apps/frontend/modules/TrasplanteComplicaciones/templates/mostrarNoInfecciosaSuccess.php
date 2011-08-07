<?php
  use_helper("Date");
?>
<h2><?php echo __("trasplanteComplicacion_Complicacion no infecciosa");?></h2>
<ul class="complicacion_no_infecciosa_show_ul">
  <li><?php echo __("trasplanteComplicacion_fecha");?> : <label class="bold_text"><?php echo format_date($complicacion->getFecha(), "D"); ?></label></li>
  <li><?php echo __("trasplanteComplicacion_medicacion");?> : <label class="bold_text"><?php echo $complicacion->getMedicaciones()->getNombre(); ?></label></li>
  <li><?php echo __("trasplanteComplicacion_tipo de complicacion");?> : <label class="bold_text"><?php echo $complicacion->getComplicacionesTiposValores()->__toString(); ?></label></li>
  <li><?php echo __("trasplanteComplicacion_internado");?> : <label class="bold_text"><?php echo ($complicacion->getInternado())? __("trasplanteComplicacion_si") : __("trasplanteComplicacion_no"); ?></label></li>
  <li><?php echo __("trasplanteComplicacion_dias internado");?> : <label class="bold_text"><?php echo $complicacion->getDiasDeInternacion(); ?></label></li>
  <li><?php echo __("trasplanteComplicacion_comentario");?> : <label class="bold_text"><?php echo $complicacion->getComentario(); ?></label></li>
</ul>

<div class="clear"></div>
<hr/>