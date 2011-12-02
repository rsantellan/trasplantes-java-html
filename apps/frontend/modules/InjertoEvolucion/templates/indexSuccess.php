<?php 
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("manejadorInjertoEvolucion.js", "last"); 
?>

<div class="volver">
    <a href="<?php echo url_for("@mostrarTrasplante?id=".$trasplanteId);?>"><?php echo __("Trasplante_volver a ver trasplante");?></a>
</div>

<h1><?php echo __("InjertoEvolucions_Titulo");?></h1>

<h3><?php echo __("InjertoEvolucions_Titulo listado injerto evolucion en trasplante");?></h3>
<ul id="injerto_evolucion_trasplante_list_container">
<?php if($evolucionTrasplante): ?>
  <?php include_partial("injertoEvolucionLista", array("injerto" => $evolucionTrasplante));?>
<?php endif;?>
</ul>
<?php if(!$evolucionTrasplante): ?>
<a id="injerto_evolucion_trasplante_new_link" class="fancy_link" href="<?php echo url_for("@agregarEvolucionInjertoTrasplante?id=".$trasplanteId);?>">
  <?php echo __("InjertoEvolucions_agregar nuevo evolucion");?>
</a>
<?php endif;?>

<h3><?php echo __("InjertoEvolucions_Titulo listado injerto evolucion en evolucion");?></h3>
<ul id="injerto_evolucion_list_container">
<?php foreach($evolucionEvolucion as $injerto): ?>
  <?php include_partial("injertoEvolucionLista", array("injerto" => $injerto));?>
<?php endforeach;?>
</ul>

<a id="injerto_evolucion_trasplante_new_link" class="fancy_link" href="<?php echo url_for("@agregarEvolucionInjertoEvolucion?id=".$trasplanteId);?>">
  <?php echo __("InjertoEvolucions_agregar nuevo evolucion");?>
</a>

