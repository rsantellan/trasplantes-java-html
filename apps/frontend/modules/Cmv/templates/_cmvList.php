<ul class="cmv_list" id="cmv_list_<?php echo $cmv->getId();?>">
      <li><?php echo __("CMV_campo fecha");?> : <label class="bold_text"><?php echo format_date($cmv->getFecha(), 'D');?></label></li>
      <li><?php echo __("CMV_campo diagnostico");?> : <label class="bold_text"><?php echo $cmv->getCmvDiagnosticoId() ?></label></li>
      <li><?php echo __("CMV_campo tipo");?> : <label class="bold_text"><?php echo $cmv->getTipo() ?></label></li>
      <li><?php echo __("CMV_campo droga");?> : <label class="bold_text"><?php echo $cmv->getCmvDrogaId() ?></label></li>
      <li><?php echo __("CMV_campo tratamiento");?> : <label class="bold_text"><?php echo $cmv->getDiasTratamiento() ?></label></li>
      <li><?php echo __("CMV_campo efecto secundario");?> : <label class="bold_text"><?php echo $cmv->getEfectoSecundario() ?></label></li>
      <?php if($cmv->getCmvEmfermedades()->count() > 0) : ?>
        <li><?php echo __("CMV_campo emfermedades");?>
            <ol>
        <?php foreach($cmv->getCmvEmfermedades() as $emfermedad): ?>
            <li><?php echo $emfermedad->getNombre(); ?> </li>
        <?php endforeach; ?>
            </ol>
        </li>
      <?php endif; ?>
</ul>