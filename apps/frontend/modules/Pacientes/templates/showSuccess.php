<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $pacientes->getId() ?></td>
    </tr>
    <tr>
      <th>The:</th>
      <td><?php echo $pacientes->getThe() ?></td>
    </tr>
    <tr>
      <th>Ci:</th>
      <td><?php echo $pacientes->getCi() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $pacientes->getNombre() ?></td>
    </tr>
    <tr>
      <th>Apellido:</th>
      <td><?php echo $pacientes->getApellido() ?></td>
    </tr>
    <tr>
      <th>Num fnr:</th>
      <td><?php echo $pacientes->getNumFnr() ?></td>
    </tr>
    <tr>
      <th>Raza:</th>
      <td><?php echo $pacientes->getRaza() ?></td>
    </tr>
    <tr>
      <th>Sexo:</th>
      <td><?php echo $pacientes->getSexo() ?></td>
    </tr>
    <tr>
      <th>Fecha nacimiento:</th>
      <td><?php echo $pacientes->getFechaNacimiento() ?></td>
    </tr>
    <tr>
      <th>Fecha dialisis:</th>
      <td><?php echo $pacientes->getFechaDialisis() ?></td>
    </tr>
    <tr>
      <th>Nefropatia:</th>
      <td><?php echo $pacientes->getNefropatiaId() ?></td>
    </tr>
    <tr>
      <th>Grupo sanguineo:</th>
      <td><?php echo $pacientes->getGrupoSanguineo() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Pacientes/edit?id='.$pacientes->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Pacientes/index') ?>">List</a>
