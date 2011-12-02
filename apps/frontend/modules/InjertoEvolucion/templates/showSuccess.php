<?php
  use_helper("Date");
?>
<h2><?php echo __("InjertoEvolucions_Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("InjertoEvolucions_fecha");?> : <label class="bold_text"><?php echo format_date($injerto_evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("InjertoEvolucions_tm");?> : <label class="bold_text"><?php echo ($injerto_evolucion->getTm())? __("InjertoEvolucions_si") : __("InjertoEvolucions_no"); ?></label></li>
  <li><?php echo __("InjertoEvolucions_tm cual");?> : <label class="bold_text"><?php echo $injerto_evolucion->getTmCual(); ?></label></li>
  <li><?php echo __("InjertoEvolucions_gp de_novo");?> : <label class="bold_text"><?php echo ($injerto_evolucion->getGpDeNovo())? __("InjertoEvolucions_si") : __("InjertoEvolucions_no"); ?></label></li>
  <li><?php echo __("InjertoEvolucions_recidiva gp_de_novo");?> : <label class="bold_text"><?php echo ($injerto_evolucion->getRecidivaGpDeNovo())? __("InjertoEvolucions_si") : __("InjertoEvolucions_no"); ?></label></li>
  <li><?php echo __("InjertoEvolucions_ra");?> : <label class="bold_text"><?php echo ($injerto_evolucion->getRa())? __("InjertoEvolucions_si") : __("InjertoEvolucions_no"); ?></label></li>
  <li><?php echo __("InjertoEvolucions_rc");?> : <label class="bold_text"><?php echo ($injerto_evolucion->getRc())? __("InjertoEvolucions_si") : __("InjertoEvolucions_no"); ?></label></li>
  <li><?php echo __("InjertoEvolucions_ra tratamiento_id");?> : <label class="bold_text"><?php echo $injerto_evolucion->getRatratamiento()->getNombre(); ?></label></li>
  <li><?php echo __("InjertoEvolucions_pbrs list");?> : 
	  <?php if(count($injerto_evolucion->getInjertoEvolucionPbrs()) > 0 ): ?>
	  <ul>
		<?php foreach($injerto_evolucion->getInjertoEvolucionPbrs() as $evolPbr ): ?>
		  <li>
			<?php echo $evolPbr->__toString()?>
		  </li>
		<?php endforeach; ?>
	  </ul>
	  <?php endif; ?>
  </li>
</ul>
<div class="clear"></div>
<hr/>