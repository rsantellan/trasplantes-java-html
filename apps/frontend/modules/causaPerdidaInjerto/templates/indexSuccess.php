<h1><?php echo __("causaPerdidaInjerto_manejar");?></h1>


<select class="selector_style" id="causaPerdidaInjerto_selector" onchange="causaPerdidaInjertoManagement.getInstance().showCausa()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="nefropatia_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="causaPerdidaInjertoManagement.getInstance().newCausa('<?php echo url_for("@crearCausaPerdidaInjerto");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="causaPerdidaInjerto_show_url_input" value="<?php echo url_for("@editarCausaPerdidaInjerto");?>"/>

<div class="clear"></div>

<div id="nefropatia_container" style="block: none">
  
</div>
