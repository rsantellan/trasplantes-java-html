<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $paciente_causa_muerte->getId() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $paciente_causa_muerte->getNombre() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('PacienteCausaMuerte/edit?id='.$paciente_causa_muerte->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('PacienteCausaMuerte/index') ?>">List</a>
