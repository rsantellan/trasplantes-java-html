<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_TxTorax Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_TxTorax fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_TxTorax rct");?> : <label class="bold_text"><?php echo $evolucion->getRct();?></label></li>
  <li><?php echo __("Evoluciones_TxTorax foco");?> : <label class="bold_text"><?php echo ($evolucion->getFoco())? __("Evoluciones_TxTorax si") : __("Evoluciones_TxTorax no"); ?></label></li>
  <li><?php echo __("Evoluciones_TxTorax lateralizado");?> : <label class="bold_text"><?php echo $evolucion->getLateralizado();?></label></li>
  <li><?php echo __("Evoluciones_TxTorax derrame_pleural");?> : <label class="bold_text"><?php echo ($evolucion->getDerramePleural())? __("Evoluciones_TxTorax si") : __("Evoluciones_TxTorax no"); ?></label></li>
  <li><?php echo __("Evoluciones_TxTorax lateral_derrame");?> : <label class="bold_text"><?php echo $evolucion->getLateralDerrame();?></label></li>
  <li><?php echo __("Evoluciones_TxTorax secuelas");?> : <label class="bold_text"><?php echo ($evolucion->getSecuelas())? __("Evoluciones_TxTorax si") : __("Evoluciones_TxTorax no"); ?></label></li>
  <li><?php echo __("Evoluciones_TxTorax otros");?> : <label class="bold_text"><?php echo $evolucion->getOtros();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
