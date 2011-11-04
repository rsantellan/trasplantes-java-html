<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Nutricion Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Nutricion fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Nutricion talla");?> : <label class="bold_text"><?php echo $evolucion->getTalla();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion peso_deseado");?> : <label class="bold_text"><?php echo $evolucion->getPesoDeseado();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion estructura_osea");?> : <label class="bold_text"><?php echo $evolucion->getEstructuraOsea();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion impresion");?> : <label class="bold_text"><?php echo $evolucion->getImpresion();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion peso_real");?> : <label class="bold_text"><?php echo $evolucion->getPesoReal();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_tricipital");?> : <label class="bold_text"><?php echo $evolucion->getPTricipital();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_tricipital_p");?> : <label class="bold_text"><?php echo $evolucion->getPTricipitalP();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_subescapular");?> : <label class="bold_text"><?php echo $evolucion->getPSubescapular();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_subescapular_p");?> : <label class="bold_text"><?php echo $evolucion->getPSubescapularP();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion sum_pliegues");?> : <label class="bold_text"><?php echo $evolucion->getSumPliegues();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_sum_pliegues");?> : <label class="bold_text"><?php echo $evolucion->getPSumPliegues();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion cf_brazo");?> : <label class="bold_text"><?php echo $evolucion->getCfBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_cf_brazo");?> : <label class="bold_text"><?php echo $evolucion->getPCfBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion cf_musc_brazo");?> : <label class="bold_text"><?php echo $evolucion->getCfMuscBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_cf_musc_brazo");?> : <label class="bold_text"><?php echo $evolucion->getPCfMuscBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion area_brazo");?> : <label class="bold_text"><?php echo $evolucion->getAreaBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion area_musc_brazo");?> : <label class="bold_text"><?php echo $evolucion->getAreaMuscBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_area_musc_brazo");?> : <label class="bold_text"><?php echo $evolucion->getPAreaMuscBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion area_grasa_brazo");?> : <label class="bold_text"><?php echo $evolucion->getAreaGrasaBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion p_area_grasa_brazo");?> : <label class="bold_text"><?php echo $evolucion->getPAreaGrasaBrazo();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion r_cintura_cadera");?> : <label class="bold_text"><?php echo $evolucion->getRCinturaCadera();?></label></li>
  <li><?php echo __("Evoluciones_Nutricion diag_nutricional");?> : <label class="bold_text"><?php echo $evolucion->getDiagNutricional();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
