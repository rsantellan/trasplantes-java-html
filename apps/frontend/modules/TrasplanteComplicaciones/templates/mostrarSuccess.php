<?php 
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("complicacionesManagement.js", "last"); 
?>

<?php 
  $complicaciones_no_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplanteId, false, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplanteId, false, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_no_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplanteId, true, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplanteId, true, false, Doctrine_Core::HYDRATE_ARRAY);
?>
<div class="complicaciones_no_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion no infecciosas en trasplante");?></h3>
  <ul id="complicaciones_no_infecciosas_trasplante_list">
	<?php foreach($complicaciones_no_infecciosas_trasplante as $complicacion): ?>
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	<?php endforeach; ?>
  </ul>
  <a href="<?php echo url_for("@agregarComplicacionesNoInfecciosaTrasplante?trasplanteId=".$trasplanteId); ?>" class="fancy_link"><?php echo __("trasplanteComplicacion_agregar");?></a>
</div>

<div class="complicaciones_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion infecciosas en trasplante");?></h3>
  <ul>
	<?php foreach($complicaciones_infecciosas_trasplante as $complicacion): ?>
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	<?php endforeach; ?>
  </ul>
  <a href="<?php echo url_for("@agregarComplicacionesInfecciosaTrasplante?trasplanteId=".$trasplanteId); ?>" class="fancy_link"><?php echo __("trasplanteComplicacion_agregar");?></a>
</div>

<div class="complicaciones_no_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion no infecciosas en evolucion");?></h3>
  <ul id="complicaciones_no_infecciosas_evolucion_list">
	<?php foreach($complicaciones_no_infecciosas_evolucion as $complicacion): ?>
    <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	<?php endforeach; ?>
  </ul>
  <a href="<?php echo url_for("@agregarComplicacionesNoInfecciosaEvolucion?trasplanteId=".$trasplanteId); ?>" class="fancy_link"><?php echo __("trasplanteComplicacion_agregar");?></a>
</div>

<div class="complicaciones_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion infecciosas en evolucion");?></h3>
  <ul>
	<?php foreach($complicaciones_infecciosas_evolucion as $complicacion): ?>
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	<?php endforeach; ?>
  </ul>  
</div>
