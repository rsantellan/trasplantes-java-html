<div class="fancy_manage_container">
<h1><?php echo __("donanteOrganos_manejar");?></h1>

<select class="selector_style" id="donantes_organos_selector" onchange="donantesManagement.getInstance().showDonanteOrgano()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="donante_organos_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getNombre() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="donantesManagement.getInstance().newDonanteOrgano('<?php echo url_for("@crearDonanteOrgano");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="donante_organos_show_url_input" value="<?php echo url_for("@editarDonanteOrgano");?>"/>

  <div class="clear"></div>
  <a href="javascript:void(0)" onclick="donantesManagement.getInstance().verDonante();"><?php echo __("donante_ver donante");?></a>
</div>  

<div class="clear"></div>

<div id="donante_organos_container" style="display: none">
  
</div>
