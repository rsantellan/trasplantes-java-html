<h1><?php echo __("reportes_titulo");?></h1>

<h4><?php echo __("reportes_titulo reportes fijos");?></h4>

<ul>
  <li>
    <a href="<?php echo url_for("@reportesDeFondo");?>">
      <?php echo __("reportes_reporte de fondo por anio");?>
    </a>
  </li>
  <li>
    <a href="<?php echo url_for("@reportesDeFondoRACMV");?>">
      <?php echo __("reportes_reporte de fondo RACMV por anio");?>
    </a>
  </li>
</ul>

<h4><?php echo __("reportes_titulo reportes dinamicos");?></h4>
<a href="<?php echo url_for("@reporteDinamico");?>"><?php echo __("reportes_generar dinamico");?></a>