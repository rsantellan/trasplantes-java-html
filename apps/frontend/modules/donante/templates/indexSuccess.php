<div id="donante_manage_container" class="fancy_manage_container">
  <h1><?php echo __("donante_manejar");?></h1>

  <select class="selector_style" id="donantes_selector" onchange="donantesManagement.getInstance().showDonante()">
    <option value="0">-</option>
    <?php foreach ($list as $object): ?>
      <option id="donante_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getIdentificador() ?></option>
    <?php endforeach; ?>
  </select>
  <a href="javascript:void(0);" onclick="donantesManagement.getInstance().newDonante('<?php echo url_for("@crearDonante");?>');">
    <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
  </a>
  <input type="hidden" id="donante_show_url_input" value="<?php echo url_for("@editarDonante");?>"/>
</div>
<div class="clear"></div>

<div id="donante_container" style="block: none">
  
</div>

<div id="auxiliary_fields" style="block: none">

</div>
