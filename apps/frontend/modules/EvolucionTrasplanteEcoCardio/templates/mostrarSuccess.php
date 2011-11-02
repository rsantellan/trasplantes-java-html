<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Ecocardio Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Ecocardio fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio fevi_normal");?> : <label class="bold_text"><?php echo ($evolucion->getFeviNormal())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio insuf_hipodiast");?> : <label class="bold_text"><?php echo ($evolucion->getInsufHipodiast())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio iao");?> : <label class="bold_text"><?php echo ($evolucion->getIao())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio eao");?> : <label class="bold_text"><?php echo ($evolucion->getEao())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio im");?> : <label class="bold_text"><?php echo ($evolucion->getIm())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio em");?> : <label class="bold_text"><?php echo ($evolucion->getEm())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio ip");?> : <label class="bold_text"><?php echo ($evolucion->getIp())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio ep");?> : <label class="bold_text"><?php echo ($evolucion->getEp())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio it");?> : <label class="bold_text"><?php echo ($evolucion->getIt())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio et");?> : <label class="bold_text"><?php echo ($evolucion->getEt())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio derrame");?> : <label class="bold_text"><?php echo ($evolucion->getDerrame())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio calcif_valvular");?> : <label class="bold_text"><?php echo ($evolucion->getCalcifValvular())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  <li><?php echo __("Evoluciones_Ecocardio hvi");?> : <label class="bold_text"><?php echo ($evolucion->getHvi())? __("Evoluciones_Ecocardio si") : __("Evoluciones_Ecocardio no"); ?></label></li>
  
</ul>

<div class="clear"></div>
<hr/>
