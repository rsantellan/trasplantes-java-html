<div class="seroles_container">
<?php
$serolesAsociados = array();
foreach($serolesDonante as $serol)
{
  $serolesAsociados[$serol['serol_valor_id']] = $serol['serol_valor_id'];
}
?>
<?php var_dump($serolesAsociados); ?>

<div class="seroles_container_title">
  <label><?php echo __("serol_seroles");?></label>
  <a href="javascript:void(0)" class="simple_tip_container" onclick="return donantesManagement.getInstance().showSerolesManagement('<?php echo url_for("@manejarSeroles");?>');">
    <?php echo image_tag("add_block.png", array("width" => 24)); ?>
    <div class="tooltip_text"><?php echo __("donante_manejar causa muerte");?></div>		
  </a>
</div>
<?php foreach($seroles as $serol): ?>
  <?php include_partial("container_seroles", array('serol' => $serol)); ?>
<?php endforeach; ?>

</div>
