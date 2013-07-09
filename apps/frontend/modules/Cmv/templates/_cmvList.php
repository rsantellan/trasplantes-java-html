<ul class="cmv_list" id="cmv_list_<?php echo $cmv->getId();?>">
      <li>
        <?php echo __("CMV_campo fecha");?> : <label class="bold_text"><?php echo format_date($cmv->getFecha(), 'D');?></label>
        <a href="<?php echo url_for("@editarCmv?id=".$cmv->getId());?>" class="fancy_link">
            <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
        </a>
      </li>
      <li><?php echo __("CMV_campo diagnostico");?> : <label class="bold_text"><?php echo $cmv->getCmvDiagnostico()->getNombre() ?></label></li>
      <?php $choices = datosBasicosHandler::cmvChoicesOptions(); ?>
      <li><?php echo __("CMV_campo tipo");?> : <label class="bold_text"><?php echo $choices[$cmv->getTipo()] ?></label></li>
      <li><?php echo __("CMV_campo droga");?> : <label class="bold_text"><?php echo $cmv->getCmvDrogas()->getNombre() ?></label></li>
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
