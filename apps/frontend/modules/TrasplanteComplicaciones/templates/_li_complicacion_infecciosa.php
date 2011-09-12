<?php
  use_helper("Date");
?>
<li id="complicacion_<?php echo $id; ?>">
  <?php echo format_date($fecha, "D"); ?> 
  <a href="<?php echo url_for("@mostrarComplicacionInfecciosa?id=".$id); ?>" class="fancy_link">
	<?php echo image_tag("search-icon.png", array("width" => 24)); ?>
  </a>
  <a href="<?php echo url_for("@editarComplicacionesInfecciosa?id=".$id);?>" class="fancy_link">
	<?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
  </a>
</li>  
  

