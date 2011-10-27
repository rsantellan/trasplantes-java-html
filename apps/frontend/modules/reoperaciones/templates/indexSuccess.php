<h1>Trasplante reoperacions List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Descripcion</th>
      <th>Trasplante complicacion infeccion</th>
      <th>Trasplante complicacion no infeccion</th>
      <th>Es infecciosa</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($trasplante_reoperacions as $trasplante_reoperacion): ?>
    <tr>
      <td><a href="<?php echo url_for('reoperaciones/edit?id='.$trasplante_reoperacion->getId()) ?>"><?php echo $trasplante_reoperacion->getId() ?></a></td>
      <td><?php echo $trasplante_reoperacion->getTrasplanteId() ?></td>
      <td><?php echo $trasplante_reoperacion->getFecha() ?></td>
      <td><?php echo $trasplante_reoperacion->getDescripcion() ?></td>
      <td><?php echo $trasplante_reoperacion->getTrasplanteComplicacionInfeccionId() ?></td>
      <td><?php echo $trasplante_reoperacion->getTrasplanteComplicacionNoInfeccionId() ?></td>
      <td><?php echo $trasplante_reoperacion->getEsInfecciosa() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('reoperaciones/new') ?>">New</a>
