<h1>Consultas List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Sentencia</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($consultas as $consulta): ?>
    <tr>
      <td><a href="<?php echo url_for('consulta/show?id='.$consulta->getId()) ?>"><?php echo $consulta->getId() ?></a></td>
      <td><?php echo $consulta->getNombre() ?></td>
      <td><?php echo $consulta->getSentencia() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('consulta/new') ?>">New</a>
