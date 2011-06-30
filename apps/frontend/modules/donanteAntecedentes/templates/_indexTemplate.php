<div class="fancy_manage_container">
<h1><?php echo __("donanteAntecedentes_manejar");?></h1>

<select class="selector_style" id="donantes_antecedentes_selector" onchange="donantesManagement.getInstance().showDonanteAntecedente()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="donante_antecedentes_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="donantesManagement.getInstance().newDonanteAntecedentes('<?php echo url_for("@crearDonanteAntecedentes");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="donante_antecedentes_show_url_input" value="<?php echo url_for("@editarDonanteAntecedentes");?>"/>

  <div class="clear"></div>
  <a href="javascript:void(0)" onclick="donantesManagement.getInstance().verDonante();"><?php echo __("donante_ver donante");?></a>
</div>  

<div class="clear"></div>

<div id="donante_antecedentes_container" style="display: none">
  
</div>
