<?php 
  use_helper('mdAsset', 'Date'); 
  use_javascript("jquery-1.6.1.min.js","first");
  use_javascript("simpleTip/jquery.simpletip-1.3.1.js"); 
  use_javascript("tratamientos.js");
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<h1><?php echo __("Tratamiento_Lista");?></h1>

<table>
  <thead>
    <tr>
      <th><?php echo __("Tratamiento_Medicacion");?></th>
      <th><?php echo __("Tratamiento_Dosis");?></th>
      <th><?php echo __("Tratamiento_Fecha inicio");?></th>
      <th><?php echo __("Tratamiento_Fecha fin");?></th>
      <th><?php echo __("Tratamiento_Editar");?></th>
      <th><?php echo __("Tratamiento_Finalizar");?></th>
      <th><?php echo __("Tratamiento_Eliminar");?></th>
    </tr>
  </thead>
  <tbody id="tratamientos_tbody">
    <?php foreach ($tratamientos as $tratamiento): ?>
      <?php include_partial("table_row", array( "tratamiento" => $tratamiento)); ?>
    <?php endforeach; ?>
  </tbody>
</table>
<div class="clear"></div>
<br/>
<a class="fancy_small_link" href="<?php echo url_for("@agregarTratamientos?id=".$paciente_id); ?>"><?php echo __("Tratamiento_agregar nuevo");?></a>
<div class="clear"></div>
<br/>

<h4><a href="<?php echo url_for("@mostrarPaciente?id=".$paciente_id); ?>"><?php echo __("Tratamiento_Volver");?></a></h4>