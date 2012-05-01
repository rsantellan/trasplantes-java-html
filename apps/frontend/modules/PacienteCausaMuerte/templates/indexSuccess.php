<h1><?php echo __("causaMuerte_manejar");?></h1>


<select class="selector_style" id="causaMuerte_selector" onchange="causaMuerteManagement.getInstance().showCausaMuerte()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="nefropatia_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="causaMuerteManagement.getInstance().newCausaMuerte('<?php echo url_for("@crearCausaMuerte");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="causaMuerte_show_url_input" value="<?php echo url_for("@editarCausaMuerte");?>"/>

<div class="clear"></div>

<div id="nefropatia_container" style="block: none">
  
</div>