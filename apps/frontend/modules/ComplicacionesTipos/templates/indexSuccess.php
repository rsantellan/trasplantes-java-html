<h1>Complicaciones tiposs List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($complicaciones_tiposs as $complicaciones_tipos): ?>
    <tr>
      <td><a href="<?php echo url_for('ComplicacionesTipos/edit?id='.$complicaciones_tipos->getId()) ?>"><?php echo $complicaciones_tipos->getId() ?></a></td>
      <td><?php echo $complicaciones_tipos->getNombre() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('ComplicacionesTipos/new') ?>">New</a>
