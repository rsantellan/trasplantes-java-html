<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $trasplante_complicaciones->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $trasplante_complicaciones->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $trasplante_complicaciones->getFecha() ?></td>
    </tr>
    <tr>
      <th>Medicacion:</th>
      <td><?php echo $trasplante_complicaciones->getMedicacionId() ?></td>
    </tr>
    <tr>
      <th>Internado:</th>
      <td><?php echo $trasplante_complicaciones->getInternado() ?></td>
    </tr>
    <tr>
      <th>Dias de internacion:</th>
      <td><?php echo $trasplante_complicaciones->getDiasDeInternacion() ?></td>
    </tr>
    <tr>
      <th>Evolucion:</th>
      <td><?php echo $trasplante_complicaciones->getEvolucion() ?></td>
    </tr>
    <tr>
      <th>Comentario:</th>
      <td><?php echo $trasplante_complicaciones->getComentario() ?></td>
    </tr>
    <tr>
      <th>Infecciosa:</th>
      <td><?php echo $trasplante_complicaciones->getInfecciosa() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('TrasplanteComplicaciones/edit?id='.$trasplante_complicaciones->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('TrasplanteComplicaciones/index') ?>">List</a>
