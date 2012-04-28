<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $paciente_perdida_injerto->getId() ?></td>
    </tr>
    <tr>
      <th>Paciente:</th>
      <td><?php echo $paciente_perdida_injerto->getPacienteId() ?></td>
    </tr>
    <tr>
      <th>Paciente causa perdida injerto:</th>
      <td><?php echo $paciente_perdida_injerto->getPacienteCausaPerdidaInjertoId() ?></td>
    </tr>
    <tr>
      <th>Fecha perdida:</th>
      <td><?php echo $paciente_perdida_injerto->getFechaPerdida() ?></td>
    </tr>
    <tr>
      <th>Paciente pre trasplante:</th>
      <td><?php echo $paciente_perdida_injerto->getPacientePreTrasplanteId() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('perdidaInjerto/edit?id='.$paciente_perdida_injerto->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('perdidaInjerto/index') ?>">List</a>
