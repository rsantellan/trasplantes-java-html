<h1>Evolucion trasplante exameness List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Evolucion trasplante examenes tipo</th>
      <th>Tipo</th>
      <th>Comentario</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_exameness as $evolucion_trasplante_examenes): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteExamenes/edit?id='.$evolucion_trasplante_examenes->getId()) ?>"><?php echo $evolucion_trasplante_examenes->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_examenes->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_examenes->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_examenes->getEvolucionTrasplanteExamenesTipoId() ?></td>
      <td><?php echo $evolucion_trasplante_examenes->getTipo() ?></td>
      <td><?php echo $evolucion_trasplante_examenes->getComentario() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteExamenes/new') ?>">New</a>
