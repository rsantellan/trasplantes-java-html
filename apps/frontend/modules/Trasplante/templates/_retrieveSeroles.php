<div id="trasplante_serol_container" class="seroles_container all_seroles_container">
<?php
$serolesAsociados = array();
foreach($serolesTrasplante as $serol)
{
  $serolesAsociados[$serol['serol_valor_id']] = $serol['serol_valor_id'];
}
?>
<?php var_dump($serolesAsociados); ?>

  <div class="seroles_container_title">
    <label><?php echo __("serol_seroles");?></label>
    <a href="<?php echo url_for("@manejarSeroles?trasplante=1");?>" class="simple_tip_container" id="manage_seroles_link">
      <?php echo image_tag("add_block.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("serol_manejar seroles");?></div>		
    </a>
  </div>
  <?php foreach($seroles as $serol): ?>
    <?php include_partial("container_seroles", array('serol' => $serol, 'serolesAsociados' => $serolesAsociados)); ?>
  <?php endforeach; ?>

</div>
