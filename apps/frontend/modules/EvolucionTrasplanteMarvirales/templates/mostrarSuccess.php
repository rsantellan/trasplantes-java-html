<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Marvirales Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Marvirales fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Marvirales hsv");?> : <label class="bold_text"><?php echo ($evolucion->getHsv())? __("Evoluciones_Marvirales si") : __("Evoluciones_Marvirales no"); ?></label></li>
  <li><?php echo __("Evoluciones_Marvirales aghbs");?> : <label class="bold_text"><?php echo $evolucion->getAghbs();?></label></li>
  <li><?php echo __("Evoluciones_Marvirales hbsac");?> : <label class="bold_text"><?php echo $evolucion->getHbsac();?></label></li>
  <li><?php echo __("Evoluciones_Marvirales hbcac");?> : <label class="bold_text"><?php echo $evolucion->getHbcac();?></label></li>
  <li><?php echo __("Evoluciones_Marvirales hvc");?> : <label class="bold_text"><?php echo $evolucion->getHvc();?></label></li>
  <li><?php echo __("Evoluciones_Marvirales hiv");?> : <label class="bold_text"><?php echo $evolucion->getHiv();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
