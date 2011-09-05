<div class="fancy_manage_container">
<h1><?php echo __("ComplicacionTipo_manejar");?></h1>

<select class="selector_style" id="complicacion_tipo_selector" onchange="complicacionesManagement.getInstance().showComplicacionTipo()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="complicacion_tipo_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="complicacionesManagement.getInstance().newComplicacionTipo('<?php echo url_for("@crearComplicacionTipo");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="complicacion_tipo_show_url_input" value="<?php echo url_for("@editarComplicacionTipo");?>"/>

  <div class="clear"></div>
  <a href="javascript:void(0)" onclick="complicacionesManagement.getInstance().verComplicacion();"><?php echo __("trasplanteComplicacion_ver complicacion");?></a>
</div>  

<div class="clear"></div>

<div id="complicacion_tipo_container" style="display: none">
  
</div>
