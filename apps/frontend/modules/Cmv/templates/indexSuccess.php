<?php
  use_helper("Date");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("cmvManagement.js",'last');
?>
<h1><?php echo __("CMV_titulo lista");?></h1>

<div id="cmv_container">
    <?php foreach ($cmvs as $cmv): ?>
        <?php include_partial("cmvList", array("cmv" => $cmv)); ?>
    <?php endforeach;?>
</div>
<div class="clear"></div>

<a class="fancy_link" href="<?php echo url_for('@agregarCmv?id='.$id) ?>"><?php echo __("CMV_agregar nuevo");?></a>
<hr/>
<div class="volver">
    <a href="<?php echo url_for("@mostrarTrasplante?id=".$id);?>"><?php echo __("Trasplante_volver a ver trasplante");?></a>
</div>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Cmv diagnostico</th>
      <th>Tipo</th>
      <th>Cmv droga</th>
      <th>Dias tratamiento</th>
      <th>Efecto secundario</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($cmvs as $cmv): ?>
    <tr>
      <td><a href="<?php echo url_for('Cmv/show?id='.$cmv->getId()) ?>"><?php echo $cmv->getId() ?></a></td>
      <td><?php echo $cmv->getTrasplanteId() ?></td>
      <td><?php echo $cmv->getFecha() ?></td>
      <td><?php echo $cmv->getCmvDiagnosticoId() ?></td>
      <td><?php echo $cmv->getTipo() ?></td>
      <td><?php echo $cmv->getCmvDrogaId() ?></td>
      <td><?php echo $cmv->getDiasTratamiento() ?></td>
      <td><?php echo $cmv->getEfectoSecundario() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('Cmv/new') ?>">New</a>
