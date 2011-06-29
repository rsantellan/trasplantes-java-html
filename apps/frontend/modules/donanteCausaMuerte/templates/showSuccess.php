<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $donante_causa_muerte->getId() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $donante_causa_muerte->getNombre() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('donanteCausaMuerte/edit?id='.$donante_causa_muerte->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('donanteCausaMuerte/index') ?>">List</a>
