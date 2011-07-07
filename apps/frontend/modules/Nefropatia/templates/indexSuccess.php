<h1><?php echo __("nefropatias_manejar");?></h1>


<select class="selector_style" id="nefropatias_selector" onchange="nefropatiasManagement.getInstance().showNefropatia()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="nefropatia_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="nefropatiasManagement.getInstance().newNefropatia('<?php echo url_for("@crearNefropatia");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="nefropatias_show_url_input" value="<?php echo url_for("@editarNefropatia");?>"/>

<div class="clear"></div>

<div id="nefropatia_container" style="block: none">
  
</div>