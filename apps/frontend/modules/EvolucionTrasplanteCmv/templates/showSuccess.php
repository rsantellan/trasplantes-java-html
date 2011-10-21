<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $evolucion_trasplante_cmv->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $evolucion_trasplante_cmv->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $evolucion_trasplante_cmv->getFecha() ?></td>
    </tr>
    <tr>
      <th>Igg cmv:</th>
      <td><?php echo $evolucion_trasplante_cmv->getIggCmv() ?></td>
    </tr>
    <tr>
      <th>Igm cmv:</th>
      <td><?php echo $evolucion_trasplante_cmv->getIgmCmv() ?></td>
    </tr>
    <tr>
      <th>Pcr cmv:</th>
      <td><?php echo $evolucion_trasplante_cmv->getPcrCmv() ?></td>
    </tr>
    <tr>
      <th>Ag pp65:</th>
      <td><?php echo $evolucion_trasplante_cmv->getAgPp65() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('EvolucionTrasplanteCmv/edit?id='.$evolucion_trasplante_cmv->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('EvolucionTrasplanteCmv/index') ?>">List</a>
