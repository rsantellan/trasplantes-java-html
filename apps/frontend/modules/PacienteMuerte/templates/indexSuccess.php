<h1>Paciente muertes List</h1>

<table>
  <thead>
    <tr>
      <th>Paciente</th>
      <th>Causa muerte</th>
      <th>Fecha muerte</th>
      <th>Transplante funcionando</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($paciente_muertes as $paciente_muerte): ?>
    <tr>
      <td><a href="<?php echo url_for('PacienteMuerte/edit?paciente_id='.$paciente_muerte->getPacienteId()) ?>"><?php echo $paciente_muerte->getPacienteId() ?></a></td>
      <td><?php echo $paciente_muerte->getCausaMuerteId() ?></td>
      <td><?php echo $paciente_muerte->getFechaMuerte() ?></td>
      <td><?php echo $paciente_muerte->getTransplanteFuncionando() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('PacienteMuerte/new') ?>">New</a>
