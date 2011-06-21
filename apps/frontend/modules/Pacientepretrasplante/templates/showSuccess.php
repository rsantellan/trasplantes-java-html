<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $pacientepretrasplante->getId() ?></td>
    </tr>
    <tr>
      <th>Paciente:</th>
      <td><?php echo $pacientepretrasplante->getPacienteId() ?></td>
    </tr>
    <tr>
      <th>The:</th>
      <td><?php echo $pacientepretrasplante->getThe() ?></td>
    </tr>
    <tr>
      <th>Fecha ingreso lista:</th>
      <td><?php echo $pacientepretrasplante->getFechaIngresoLista() ?></td>
    </tr>
    <tr>
      <th>Fecha egreso:</th>
      <td><?php echo $pacientepretrasplante->getFechaEgreso() ?></td>
    </tr>
    <tr>
      <th>Modalidad d:</th>
      <td><?php echo $pacientepretrasplante->getModalidadD() ?></td>
    </tr>
    <tr>
      <th>Diabetes:</th>
      <td><?php echo $pacientepretrasplante->getDiabetes() ?></td>
    </tr>
    <tr>
      <th>Imc:</th>
      <td><?php echo $pacientepretrasplante->getImc() ?></td>
    </tr>
    <tr>
      <th>Origen:</th>
      <td><?php echo $pacientepretrasplante->getOrigen() ?></td>
    </tr>
    <tr>
      <th>Pbr:</th>
      <td><?php echo $pacientepretrasplante->getPbr() ?></td>
    </tr>
    <tr>
      <th>Hta:</th>
      <td><?php echo $pacientepretrasplante->getHta() ?></td>
    </tr>
    <tr>
      <th>Obesidad:</th>
      <td><?php echo $pacientepretrasplante->getObesidad() ?></td>
    </tr>
    <tr>
      <th>Dislipemia:</th>
      <td><?php echo $pacientepretrasplante->getDislipemia() ?></td>
    </tr>
    <tr>
      <th>Tabaquismo:</th>
      <td><?php echo $pacientepretrasplante->getTabaquismo() ?></td>
    </tr>
    <tr>
      <th>Iam:</th>
      <td><?php echo $pacientepretrasplante->getIam() ?></td>
    </tr>
    <tr>
      <th>Ave:</th>
      <td><?php echo $pacientepretrasplante->getAve() ?></td>
    </tr>
    <tr>
      <th>Revasc cardio:</th>
      <td><?php echo $pacientepretrasplante->getRevascCardio() ?></td>
    </tr>
    <tr>
      <th>Meses en lista:</th>
      <td><?php echo $pacientepretrasplante->getMesesEnLista() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Pacientepretrasplante/edit?id='.$pacientepretrasplante->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Pacientepretrasplante/index') ?>">List</a>
