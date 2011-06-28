<?php use_javascript("donantesManagement.js"); ?>
<h1><?php echo __("donante_manejar");?></h1>

<select class="selector_style" id="donantes_selector" onchange="donantesManagement.getInstance().showDonante()">
  <option value="0">-</option>
  <?php foreach ($list as $object): ?>
    <option id="donante_option_<?php echo $object->getId();?>" value="<?php echo $object->getId();?>"><?php echo $object->getIdentificador() ?></option>
  <?php endforeach; ?>
</select>
<a href="javascript:void(0);" onclick="donantesManagement.getInstance().newDonante('<?php echo url_for("@crearDonante");?>');">
  <?php echo image_tag("add-icon.png", array("width" => 24)); ?>
</a>
<input type="hidden" id="donante_show_url_input" value="<?php echo url_for("@editarDonante");?>"/>

<div class="clear"></div>

<div id="donante_container" style="block: none">
  
</div>


<!-- <table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Identificador</th>
      <th>Tipo donante</th>
      <th>Sexo donante</th>
      <th>Edad donante</th>
      <th>Enastab hemod</th>
      <th>Donante causa muerte</th>
      <th>Cr p</th>
      <th>Otros</th>
      <th>Grupo sanguineo</th>
      <th>Relacion filiar</th>
      <th>Peso</th>
      <th>Altura</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($list as $donante): ?>
    <tr>
      <td><a href="<?php echo url_for('donante/show?id='.$donante->getId()) ?>"><?php echo $donante->getId() ?></a></td>
      <td><?php echo $donante->getIdentificador() ?></td>
      <td><?php echo $donante->getTipoDonante() ?></td>
      <td><?php echo $donante->getSexoDonante() ?></td>
      <td><?php echo $donante->getEdadDonante() ?></td>
      <td><?php echo $donante->getEnastabHemod() ?></td>
      <td><?php echo $donante->getDonanteCausaMuerteId() ?></td>
      <td><?php echo $donante->getCrP() ?></td>
      <td><?php echo $donante->getOtros() ?></td>
      <td><?php echo $donante->getGrupoSanguineo() ?></td>
      <td><?php echo $donante->getRelacionFiliar() ?></td>
      <td><?php echo $donante->getPeso() ?></td>
      <td><?php echo $donante->getAltura() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('donante/new') ?>">New</a>-->
