<h1><?php echo __("Consultas_titulo");?></h1>

<a href="<?php echo url_for('consulta/new') ?>"><?php echo __("Consultas_agregar nuevo");?></a>

<ul class="consulta_list_ul">
  <?php foreach ($consultas as $consulta): ?>
  <li>
    <label class="consulta_list_ul_label"><?php echo $consulta->getNombre() ?></label>
    <a href="<?php echo url_for('consulta/show?id='.$consulta->getId().'&name='.mdBasicFunction::slugify($consulta->getNombre())) ?>">
      <?php echo image_tag("search-icon.png", array("width" => 24)); ?>
    </a>
    <a href="<?php echo url_for('consulta/edit?id='.$consulta->getId()) ?>">
      <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
    </a>
  </li>
  <?php endforeach; ?>
</ul>

<div class="clear margenes_separadores"></div>
