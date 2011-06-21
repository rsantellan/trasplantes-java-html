<h1>Pacientepretrasplantes List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Paciente</th>
      <th>The</th>
      <th>Fecha ingreso lista</th>
      <th>Fecha egreso</th>
      <th>Modalidad d</th>
      <th>Diabetes</th>
      <th>Imc</th>
      <th>Origen</th>
      <th>Pbr</th>
      <th>Hta</th>
      <th>Obesidad</th>
      <th>Dislipemia</th>
      <th>Tabaquismo</th>
      <th>Iam</th>
      <th>Ave</th>
      <th>Revasc cardio</th>
      <th>Meses en lista</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($pacientepretrasplantes as $pacientepretrasplante): ?>
    <tr>
      <td><a href="<?php echo url_for('Pacientepretrasplante/show?id='.$pacientepretrasplante->getId()) ?>"><?php echo $pacientepretrasplante->getId() ?></a></td>
      <td><?php echo $pacientepretrasplante->getPacienteId() ?></td>
      <td><?php echo $pacientepretrasplante->getThe() ?></td>
      <td><?php echo $pacientepretrasplante->getFechaIngresoLista() ?></td>
      <td><?php echo $pacientepretrasplante->getFechaEgreso() ?></td>
      <td><?php echo $pacientepretrasplante->getModalidadD() ?></td>
      <td><?php echo $pacientepretrasplante->getDiabetes() ?></td>
      <td><?php echo $pacientepretrasplante->getImc() ?></td>
      <td><?php echo $pacientepretrasplante->getOrigen() ?></td>
      <td><?php echo $pacientepretrasplante->getPbr() ?></td>
      <td><?php echo $pacientepretrasplante->getHta() ?></td>
      <td><?php echo $pacientepretrasplante->getObesidad() ?></td>
      <td><?php echo $pacientepretrasplante->getDislipemia() ?></td>
      <td><?php echo $pacientepretrasplante->getTabaquismo() ?></td>
      <td><?php echo $pacientepretrasplante->getIam() ?></td>
      <td><?php echo $pacientepretrasplante->getAve() ?></td>
      <td><?php echo $pacientepretrasplante->getRevascCardio() ?></td>
      <td><?php echo $pacientepretrasplante->getMesesEnLista() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('Pacientepretrasplante/new') ?>">New</a>
