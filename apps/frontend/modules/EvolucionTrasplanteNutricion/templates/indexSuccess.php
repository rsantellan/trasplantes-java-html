<h1>Evolucion trasplante nutricions List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Talla</th>
      <th>Peso deseado</th>
      <th>Estructura osea</th>
      <th>Impresion</th>
      <th>Peso real</th>
      <th>P tricipital</th>
      <th>P tricipital p</th>
      <th>P subescapular</th>
      <th>P subescapular p</th>
      <th>Sum pliegues</th>
      <th>P sum pliegues</th>
      <th>Cf brazo</th>
      <th>P cf brazo</th>
      <th>Cf musc brazo</th>
      <th>P cf musc brazo</th>
      <th>Area brazo</th>
      <th>Area musc brazo</th>
      <th>P area musc brazo</th>
      <th>Area grasa brazo</th>
      <th>P area grasa brazo</th>
      <th>R cintura cadera</th>
      <th>Diag nutricional</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_nutricions as $evolucion_trasplante_nutricion): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteNutricion/edit?id='.$evolucion_trasplante_nutricion->getId()) ?>"><?php echo $evolucion_trasplante_nutricion->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_nutricion->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getTalla() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPesoDeseado() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getEstructuraOsea() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getImpresion() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPesoReal() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPTricipital() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPTricipitalP() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPSubescapular() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPSubescapularP() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getSumPliegues() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPSumPliegues() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getCfBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPCfBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getCfMuscBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPCfMuscBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getAreaBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getAreaMuscBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPAreaMuscBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getAreaGrasaBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getPAreaGrasaBrazo() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getRCinturaCadera() ?></td>
      <td><?php echo $evolucion_trasplante_nutricion->getDiagNutricional() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteNutricion/new') ?>">New</a>
