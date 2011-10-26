<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $evolucion_trasplante_ecg->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $evolucion_trasplante_ecg->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $evolucion_trasplante_ecg->getFecha() ?></td>
    </tr>
    <tr>
      <th>Rs ecg:</th>
      <td><?php echo $evolucion_trasplante_ecg->getRsEcg() ?></td>
    </tr>
    <tr>
      <th>Hvi ecg:</th>
      <td><?php echo $evolucion_trasplante_ecg->getHviEcg() ?></td>
    </tr>
    <tr>
      <th>Onda q ecg:</th>
      <td><?php echo $evolucion_trasplante_ecg->getOndaQEcg() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('EvolucionTrasplanteEcg/edit?id='.$evolucion_trasplante_ecg->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('EvolucionTrasplanteEcg/index') ?>">List</a>
