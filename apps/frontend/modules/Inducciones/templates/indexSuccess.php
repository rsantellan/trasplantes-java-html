<h1><?php echo __("induccion_manejar");?></h1>


<select class="selector_style" id="induccion_selector" onchange="trasplanteNewManagement.getInstance().showInduccion()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="induccion_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="trasplanteNewManagement.getInstance().newInduccion('<?php echo url_for("@crearInduccion");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="induccion_show_url_input" value="<?php echo url_for("@editarInduccion");?>"/>

<div class="clear"></div>

<div id="induccion_container" style="display: none">
  
</div>