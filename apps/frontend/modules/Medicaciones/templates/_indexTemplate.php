<div class="fancy_manage_container">
<h1><?php echo __("Medicacion_manejar");?></h1>

<select class="selector_style" id="complicacion_medicacion_selector" onchange="complicacionesManagement.getInstance().showMedicacion()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="complicacion_medicacion_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="complicacionesManagement.getInstance().newMedicacion('<?php echo url_for("@crearMedicacion");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="complicacion_medicacion_show_url_input" value="<?php echo url_for("@editarMedicacion");?>"/>

  <div class="clear"></div>
  <a href="javascript:void(0)" onclick="complicacionesManagement.getInstance().verComplicacion();"><?php echo __("trasplanteComplicacion_ver complicacion");?></a>
</div>  

<div class="clear"></div>

<div id="complicacion_medicacion_container" style="display: none">
  
</div>
