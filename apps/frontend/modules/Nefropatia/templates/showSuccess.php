<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $nefropatia->getId() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $nefropatia->getNombre() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('Nefropatia/edit?id='.$nefropatia->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Nefropatia/index') ?>">List</a>
