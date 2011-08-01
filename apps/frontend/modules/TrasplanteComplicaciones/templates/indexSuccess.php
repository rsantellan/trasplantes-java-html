<h1>Trasplante complicacioness List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Medicacion</th>
      <th>Internado</th>
      <th>Dias de internacion</th>
      <th>Evolucion</th>
      <th>Comentario</th>
      <th>Infecciosa</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($trasplante_complicacioness as $trasplante_complicaciones): ?>
    <tr>
      <td><a href="<?php echo url_for('TrasplanteComplicaciones/show?id='.$trasplante_complicaciones->getId()) ?>"><?php echo $trasplante_complicaciones->getId() ?></a></td>
      <td><?php echo $trasplante_complicaciones->getTrasplanteId() ?></td>
      <td><?php echo $trasplante_complicaciones->getFecha() ?></td>
      <td><?php echo $trasplante_complicaciones->getMedicacionId() ?></td>
      <td><?php echo $trasplante_complicaciones->getInternado() ?></td>
      <td><?php echo $trasplante_complicaciones->getDiasDeInternacion() ?></td>
      <td><?php echo $trasplante_complicaciones->getEvolucion() ?></td>
      <td><?php echo $trasplante_complicaciones->getComentario() ?></td>
      <td><?php echo $trasplante_complicaciones->getInfecciosa() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('TrasplanteComplicaciones/new') ?>">New</a>
