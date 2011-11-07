<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Ecografia Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Ecografia fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Ecografia diametros");?> : <label class="bold_text"><?php echo $evolucion->getDiametros();?></label></li>
  <li><?php echo __("Evoluciones_Ecografia dilatacion");?> : <label class="bold_text"><?php echo ($evolucion->getDilatacion())? __("Evoluciones_Ecografia si") : __("Evoluciones_Ecografia no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecografia litiasin");?> : <label class="bold_text"><?php echo ($evolucion->getLitiasin())? __("Evoluciones_Ecografia si") : __("Evoluciones_Ecografia no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecografia vejiga");?> : <label class="bold_text"><?php echo $evolucion->getVejiga();?></label></li>
  <li><?php echo __("Evoluciones_Ecografia espesor");?> : <label class="bold_text"><?php echo $evolucion->getEspesor();?></label></li>
  <li><?php echo __("Evoluciones_Ecografia otros");?> : <label class="bold_text"><?php echo $evolucion->getOtros();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
