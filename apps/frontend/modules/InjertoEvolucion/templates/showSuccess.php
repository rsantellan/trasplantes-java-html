<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $injerto_evolucion->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $injerto_evolucion->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $injerto_evolucion->getFecha() ?></td>
    </tr>
    <tr>
      <th>Tm:</th>
      <td><?php echo $injerto_evolucion->getTm() ?></td>
    </tr>
    <tr>
      <th>Tm cual:</th>
      <td><?php echo $injerto_evolucion->getTmCual() ?></td>
    </tr>
    <tr>
      <th>Gp de novo:</th>
      <td><?php echo $injerto_evolucion->getGpDeNovo() ?></td>
    </tr>
    <tr>
      <th>Recidiva gp de novo:</th>
      <td><?php echo $injerto_evolucion->getRecidivaGpDeNovo() ?></td>
    </tr>
    <tr>
      <th>Ra:</th>
      <td><?php echo $injerto_evolucion->getRa() ?></td>
    </tr>
    <tr>
      <th>Rc:</th>
      <td><?php echo $injerto_evolucion->getRc() ?></td>
    </tr>
    <tr>
      <th>Ra tratamiento:</th>
      <td><?php echo $injerto_evolucion->getRaTratamientoId() ?></td>
    </tr>
    <tr>
      <th>En trasplante:</th>
      <td><?php echo $injerto_evolucion->getEnTrasplante() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('InjertoEvolucion/edit?id='.$injerto_evolucion->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('InjertoEvolucion/index') ?>">List</a>
