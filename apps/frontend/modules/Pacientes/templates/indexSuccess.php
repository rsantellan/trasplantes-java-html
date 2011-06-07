<h1>Pacientess List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>The</th>
      <th>Ci</th>
      <th>Nombre</th>
      <th>Apellido</th>
      <th>Num fnr</th>
      <th>Raza</th>
      <th>Sexo</th>
      <th>Fecha nacimiento</th>
      <th>Fecha dialisis</th>
      <th>Nefropatia</th>
      <th>Grupo sanguineo</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($pacientess as $pacientes): ?>
    <tr>
      <td><a href="<?php echo url_for('Pacientes/show?id='.$pacientes->getId()) ?>"><?php echo $pacientes->getId() ?></a></td>
      <td><?php echo $pacientes->getThe() ?></td>
      <td><?php echo $pacientes->getCi() ?></td>
      <td><?php echo $pacientes->getNombre() ?></td>
      <td><?php echo $pacientes->getApellido() ?></td>
      <td><?php echo $pacientes->getNumFnr() ?></td>
      <td><?php echo $pacientes->getRaza() ?></td>
      <td><?php echo $pacientes->getSexo() ?></td>
      <td><?php echo $pacientes->getFechaNacimiento() ?></td>
      <td><?php echo $pacientes->getFechaDialisis() ?></td>
      <td><?php echo $pacientes->getNefropatiaId() ?></td>
      <td><?php echo $pacientes->getGrupoSanguineo() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('Pacientes/new') ?>">New</a>
