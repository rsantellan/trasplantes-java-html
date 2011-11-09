<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Examenes Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Examenes fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Examenes evolucion_trasplante_examenes_tipo_id");?> : <label class="bold_text"><?php echo $evolucion->getEvolucionTrasplanteExamenesTipo()->getNombre();?></label></li>
  <li><?php echo __("Evoluciones_Examenes tipo");?> : <label class="bold_text"><?php echo $evolucion->getTipo();?></label></li>
  <li><?php echo __("Evoluciones_Examenes comentario");?> : <label class="bold_text"><?php echo $evolucion->getComentario();?></label></li>
</ul>

<div class="clear"></div>
<hr/>
