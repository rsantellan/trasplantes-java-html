<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $cmv->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $cmv->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $cmv->getFecha() ?></td>
    </tr>
    <tr>
      <th>Cmv diagnostico:</th>
      <td><?php echo $cmv->getCmvDiagnosticoId() ?></td>
    </tr>
    <tr>
      <th>Tipo:</th>
      <td><?php echo $cmv->getTipo() ?></td>
    </tr>
    <tr>
      <th>Cmv droga:</th>
      <td><?php echo $cmv->getCmvDrogaId() ?></td>
    </tr>
    <tr>
      <th>Dias tratamiento:</th>
      <td><?php echo $cmv->getDiasTratamiento() ?></td>
    </tr>
    <tr>
      <th>Efecto secundario:</th>
      <td><?php echo $cmv->getEfectoSecundario() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Cmv/edit?id='.$cmv->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Cmv/index') ?>">List</a>
