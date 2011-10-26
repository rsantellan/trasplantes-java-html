<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Cmv Titulo");?></h2>
<ul class="evolucion_cmv">
  <li><?php echo __("Evoluciones_Cmv fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Cmv Igg");?> : <label class="bold_text"><?php echo ($evolucion->getIggCmv())? __("Evoluciones_Cmv si") : __("Evoluciones_Cmv no"); ?></label></li>
  <li><?php echo __("Evoluciones_Cmv Igm");?> : <label class="bold_text"><?php echo ($evolucion->getIgmCmv())? __("Evoluciones_Cmv si") : __("Evoluciones_Cmv no"); ?></label></li>
  <li><?php echo __("Evoluciones_Cmv Pcr");?> : <label class="bold_text"><?php echo ($evolucion->getPcrCmv())? __("Evoluciones_Cmv si") : __("Evoluciones_Cmv no"); ?></label></li>
  <li><?php echo __("Evoluciones_Cmv Agpp 65");?> : <label class="bold_text"><?php echo ($evolucion->getAgPp65())? __("Evoluciones_Cmv si") : __("Evoluciones_Cmv no"); ?></label></li>
</ul>

<div class="clear"></div>
<hr/>
