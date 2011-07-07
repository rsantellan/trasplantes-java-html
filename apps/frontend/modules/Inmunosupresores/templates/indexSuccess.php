<h1><?php echo __("inmunosupresores_manejar");?></h1>


<select class="selector_style" id="inmunosupresores_selector" onchange="trasplanteNewManagement.getInstance().showInmunosupresor()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="inmunosupresores_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="trasplanteNewManagement.getInstance().newInmunosupresor('<?php echo url_for("@crearInmunosupresores");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="inmunosupresores_show_url_input" value="<?php echo url_for("@editarInmunosupresores");?>"/>

<div class="clear"></div>

<div id="inmunosupresores_container" style="display: none">
  
</div>