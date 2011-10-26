<?php 
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("manejadorEvolucionesManagement.js", "last"); 
?>
<div class="evoluciones_cmv_container">
    <h2><?php echo __("Evoluciones_Cmv titulo");?></h2>
    <ul id="evolucion_cmv_ul">
        <?php foreach($listEvolucionesCmv as $evolucion): ?>
            <?php include_partial("EvolucionTrasplanteCmv/listadoEvolucion", array("evolucion" => $evolucion)); ?>
        <?php endforeach; ?>
    </ul>
    <a class="fancy_link" href="<?php echo url_for("@evolucionAgregarCmv?id=".$trasplanteId); ?>"> 
        <?php echo __("Evoluciones_Cmv Agregar");?>
    </a>
</div>