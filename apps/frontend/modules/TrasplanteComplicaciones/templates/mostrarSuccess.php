<?php 
  $complicaciones_no_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplanteId, false, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplanteId, false, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_no_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplanteId, true, false, Doctrine_Core::HYDRATE_ARRAY);
  $complicaciones_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplanteId, true, false, Doctrine_Core::HYDRATE_ARRAY);
?>
<div class="complicaciones_no_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion no infecciosas en trasplante");?></h3>
  <ul>
	<?php foreach($complicaciones_no_infecciosas_trasplante as $complicacion): ?>
	<li id="complicacion_<?php echo $complicacion["id"]; ?>">
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	  <?php //var_dump($complicacion); ?>
	</li>  
	<?php endforeach; ?>
  </ul>
  <a href="<?php echo url_for("@agregarComplicacionesNoInfecciosaTrasplante?trasplanteId=".$trasplanteId); ?>" class="fancy_link"><?php echo __("trasplanteComplicacion_agregar");?></a>
</div>

<div class="complicaciones_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion infecciosas en trasplante");?></h3>
  <ul>
	<?php foreach($complicaciones_infecciosas_trasplante as $complicacion): ?>
	<li id="complicacion_<?php echo $complicacion["id"]; ?>">
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	  <?php //var_dump($complicacion); ?>
	</li>  
	<?php endforeach; ?>
  </ul>  
</div>

<div class="complicaciones_no_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion no infecciosas en evolucion");?></h3>
  <ul>
	<?php foreach($complicaciones_no_infecciosas_evolucion as $complicacion): ?>
	<li id="complicacion_<?php echo $complicacion["id"]; ?>">
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	  <?php //var_dump($complicacion); ?>
	</li>  
	<?php endforeach; ?>
  </ul>
</div>

<div class="complicaciones_infecciosas_trasplante_container">
  <h3><?php echo __("trasplanteComplicacion_complicacion infecciosas en evolucion");?></h3>
  <ul>
	<?php foreach($complicaciones_infecciosas_evolucion as $complicacion): ?>
	<li id="complicacion_<?php echo $complicacion["id"]; ?>">
	  <?php include_partial("li_complicacion_no_infecciosa", array("id" => $complicacion["id"], "fecha" => $complicacion["fecha"])); ?>
	  <?php //var_dump($complicacion); ?>
	</li>  
	<?php endforeach; ?>
  </ul>  
</div>