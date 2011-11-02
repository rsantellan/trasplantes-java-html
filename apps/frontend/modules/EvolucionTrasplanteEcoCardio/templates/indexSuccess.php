<h1>Evolucion trasplante eco cardios List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Fevi normal</th>
      <th>Insuf hipodiast</th>
      <th>Iao</th>
      <th>Eao</th>
      <th>Im</th>
      <th>Em</th>
      <th>Ip</th>
      <th>Ep</th>
      <th>It</th>
      <th>Et</th>
      <th>Derrame</th>
      <th>Calcif valvular</th>
      <th>Hvi</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_eco_cardios as $evolucion_trasplante_eco_cardio): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteEcoCardio/show?id='.$evolucion_trasplante_eco_cardio->getId()) ?>"><?php echo $evolucion_trasplante_eco_cardio->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getFeviNormal() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getInsufHipodiast() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIao() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEao() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIm() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEm() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIp() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEp() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIt() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEt() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getDerrame() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getCalcifValvular() ?></td>
      <td><?php echo $evolucion_trasplante_eco_cardio->getHvi() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteEcoCardio/new') ?>">New</a>
