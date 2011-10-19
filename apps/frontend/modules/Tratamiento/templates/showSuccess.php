<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $tratamiento->getId() ?></td>
    </tr>
    <tr>
      <th>Paciente:</th>
      <td><?php echo $tratamiento->getPacienteId() ?></td>
    </tr>
    <tr>
      <th>Medicacion:</th>
      <td><?php echo $tratamiento->getMedicacionId() ?></td>
    </tr>
    <tr>
      <th>Dosis:</th>
      <td><?php echo $tratamiento->getDosis() ?></td>
    </tr>
    <tr>
      <th>Fecha inicio:</th>
      <td><?php echo $tratamiento->getFechaInicio() ?></td>
    </tr>
    <tr>
      <th>Fecha fin:</th>
      <td><?php echo $tratamiento->getFechaFin() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Tratamiento/edit?id='.$tratamiento->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Tratamiento/index') ?>">List</a>
