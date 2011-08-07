<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $medicaciones->getId() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $medicaciones->getNombre() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Medicaciones/edit?id='.$medicaciones->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Medicaciones/index') ?>">List</a>
