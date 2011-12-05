<h1>Consulta campos List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Nombre visible</th>
      <th>Consulta</th>
      <th>Tipo</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($consulta_campos as $consulta_campo): ?>
    <tr>
      <td><a href="<?php echo url_for('ConsultaCampo/edit?id='.$consulta_campo->getId()) ?>"><?php echo $consulta_campo->getId() ?></a></td>
      <td><?php echo $consulta_campo->getNombre() ?></td>
      <td><?php echo $consulta_campo->getNombreVisible() ?></td>
      <td><?php echo $consulta_campo->getConsultaId() ?></td>
      <td><?php echo $consulta_campo->getTipoId() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('ConsultaCampo/new') ?>">New</a>
