<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Ecg Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Ecg fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Ecg RsEcg");?> : <label class="bold_text"><?php echo $evolucion->getRsEcg();?></label></li>
  <li><?php echo __("Evoluciones_Ecg HviEcg");?> : <label class="bold_text"><?php echo $evolucion->getHviEcg(); ?></label></li>
  <li><?php echo __("Evoluciones_Ecg OndaQEcg");?> : <label class="bold_text"><?php echo $evolucion->getOndaQEcg(); ?></label></li>
</ul>

<div class="clear"></div>
<hr/>
