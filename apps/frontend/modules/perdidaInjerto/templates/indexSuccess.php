<h1>Paciente perdida injertos List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Paciente</th>
      <th>Paciente causa perdida injerto</th>
      <th>Fecha perdida</th>
      <th>Paciente pre trasplante</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($paciente_perdida_injertos as $paciente_perdida_injerto): ?>
    <tr>
      <td><a href="<?php echo url_for('perdidaInjerto/show?id='.$paciente_perdida_injerto->getId()) ?>"><?php echo $paciente_perdida_injerto->getId() ?></a></td>
      <td><?php echo $paciente_perdida_injerto->getPacienteId() ?></td>
      <td><?php echo $paciente_perdida_injerto->getPacienteCausaPerdidaInjertoId() ?></td>
      <td><?php echo $paciente_perdida_injerto->getFechaPerdida() ?></td>
      <td><?php echo $paciente_perdida_injerto->getPacientePreTrasplanteId() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('perdidaInjerto/new') ?>">New</a>
