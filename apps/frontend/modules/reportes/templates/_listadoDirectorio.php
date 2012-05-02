<?php
  use_helper("Date");
?>
<ul>
  <?php foreach($listado as $item): ?>
    <li>
      <?php if($item["isDir"]): ?>
        <label><?php echo $item["name"];?></label>
        <?php include_partial("listadoDirectorio", array("listado" => $item["contents"]));?>
      <?php else: ?>
        <label><?php echo $item["name"];?> : creado -> <?php echo format_date($item["time"], 'D');?></label>
        <a href="<?php echo url_for("@reporteDownloadFile")."?file=".$item["path"]; ?>">
          <?php echo __("reporte_descargar");?>
        </a>
      <?php endif; ?>
    </li>
  <?php endforeach;?>
</ul>
