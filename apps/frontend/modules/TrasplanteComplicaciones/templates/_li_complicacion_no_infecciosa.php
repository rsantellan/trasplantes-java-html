<?php
  use_helper("Date");
?>
  <?php echo format_date($fecha, "D"); ?> <a href="<?php echo url_for("@mostrarComplicacionNoInfecciosa?id=".$id); ?>" class="fancy_link"><?php echo __("trasplanteComplicacion_mas info");?></a>

