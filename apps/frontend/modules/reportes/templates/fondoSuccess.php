<?php
  $year = date("Y");
  use_javascript("reportesFondo.js", "last");
?>

<label>
  <a href="<?php echo url_for("@reportes"); ?>">  
    <?php echo __("reportes_volver");?>
  </a>
</label>

<h1><?php echo __("reportes_Titulo reporte de fondo por anio");?></h1>

<p><?php echo __("reportes_Descripcion reporte de fondo por anio");?></p>
<form action="<?php echo url_for("@reportedDeFondoCrear")?>" method="post">
<select id="reporte_fondo_selector" name="year">
    <option value="-1"><?php echo __("reportes_generar todo");?></option>
    <option value="0"><?php echo __("reportes_generar completo");?></option>
  <?php while($year >= $start_year): ?>
    <option value="<?php echo $year;?>"><?php echo $year;?></option>
    <?php $year--; ?>
  <?php endwhile; ?>
</select>
  <input type="submit" value="<?php echo __("reporte_generar reporte");?>" />
</form>
<hr/>
<input id="reporte_fondo_button" type="button" value="<?php echo __("reporte_generar reporte");?>" onclick="sendFondoData('<?php echo url_for("@reportedDeFondoCrear")?>')"/>
<div id="reporte_fondo_image_container" style="display:none">
  <?php echo image_tag("ajax-loader.gif");?>
</div>
<hr/>

<?php
//$realPath = sfConfig::get('sf_cache_dir')."/reportes/reporteFondo/";

$listado = basicFunction::retrieveFilesArrayOfDirectory($realPathFondo);
?>
<div id="listado_container">
  <?php include_partial("listadoDirectorio", array("listado" => $listado));?>
</div>
