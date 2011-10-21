<h1>Evolucion trasplante cmvs List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Igg cmv</th>
      <th>Igm cmv</th>
      <th>Pcr cmv</th>
      <th>Ag pp65</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_cmvs as $evolucion_trasplante_cmv): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteCmv/show?id='.$evolucion_trasplante_cmv->getId()) ?>"><?php echo $evolucion_trasplante_cmv->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_cmv->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_cmv->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_cmv->getIggCmv() ?></td>
      <td><?php echo $evolucion_trasplante_cmv->getIgmCmv() ?></td>
      <td><?php echo $evolucion_trasplante_cmv->getPcrCmv() ?></td>
      <td><?php echo $evolucion_trasplante_cmv->getAgPp65() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteCmv/new') ?>">New</a>
