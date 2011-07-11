<div class="fancy_manage_container">
<h1><?php echo __("serol_manejar");?></h1>

<select class="selector_style" id="serol_selector" onchange="donantesManagement.getInstance().showSerol()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="serol_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getTipo() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="donantesManagement.getInstance().newSerol('<?php echo url_for("@crearSerol");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="serol_show_url_input" value="<?php echo url_for("@editarSerol");?>"/>

  <div class="clear"></div>
  <?php if($trasplante == 0): ?>
	<a href="javascript:void(0)" onclick="donantesManagement.getInstance().verDonante();"><?php echo __("serol_ver donante");?></a>
  <?php endif; ?>
</div>  

<div class="clear"></div>

<div id="serol_container" style="display: none">
  
</div>
