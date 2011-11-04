<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Ecodopler Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Ecodopler fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler estructura");?> : <label class="bold_text"><?php echo $evolucion->getEstructura();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler dilatacion");?> : <label class="bold_text"><?php echo ($evolucion->getDilatacion())? __("Evoluciones_Ecodopler si") : __("Evoluciones_Ecodopler no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler colecciones");?> : <label class="bold_text"><?php echo ($evolucion->getColecciones())? __("Evoluciones_Ecodopler si") : __("Evoluciones_Ecodopler no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler eje_arterial");?> : <label class="bold_text"><?php echo $evolucion->getEjeArterial();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler eje_venoso");?> : <label class="bold_text"><?php echo $evolucion->getEjeVenoso();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler arteria_renal");?> : <label class="bold_text"><?php echo $evolucion->getArteriaRenal();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler vena_renal");?> : <label class="bold_text"><?php echo $evolucion->getVenaRenal();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler anast_venosa");?> : <label class="bold_text"><?php echo $evolucion->getAnastVenosa();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler anast_renosa");?> : <label class="bold_text"><?php echo $evolucion->getAnastRenosa();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler indice");?> : <label class="bold_text"><?php echo $evolucion->getIndice();?></label></li>
  <li><?php echo __("Evoluciones_Ecodopler otros");?> : <label class="bold_text"><?php echo $evolucion->getOtros();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
