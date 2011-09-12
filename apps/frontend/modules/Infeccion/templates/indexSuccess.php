<h1>Medicacioness List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($medicacioness as $medicaciones): ?>
    <tr>
      <td><a href="<?php echo url_for('Medicaciones/show?id='.$medicaciones->getId()) ?>"><?php echo $medicaciones->getId() ?></a></td>
      <td><?php echo $medicaciones->getNombre() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('Medicaciones/new') ?>">New</a>
