<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getId() ?></td>
    </tr>
    <tr>
      <th>Trasplante:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getTrasplanteId() ?></td>
    </tr>
    <tr>
      <th>Fecha:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getFecha() ?></td>
    </tr>
    <tr>
      <th>Fevi normal:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getFeviNormal() ?></td>
    </tr>
    <tr>
      <th>Insuf hipodiast:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getInsufHipodiast() ?></td>
    </tr>
    <tr>
      <th>Iao:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIao() ?></td>
    </tr>
    <tr>
      <th>Eao:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEao() ?></td>
    </tr>
    <tr>
      <th>Im:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIm() ?></td>
    </tr>
    <tr>
      <th>Em:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEm() ?></td>
    </tr>
    <tr>
      <th>Ip:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIp() ?></td>
    </tr>
    <tr>
      <th>Ep:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEp() ?></td>
    </tr>
    <tr>
      <th>It:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getIt() ?></td>
    </tr>
    <tr>
      <th>Et:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getEt() ?></td>
    </tr>
    <tr>
      <th>Derrame:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getDerrame() ?></td>
    </tr>
    <tr>
      <th>Calcif valvular:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getCalcifValvular() ?></td>
    </tr>
    <tr>
      <th>Hvi:</th>
      <td><?php echo $evolucion_trasplante_eco_cardio->getHvi() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('EvolucionTrasplanteEcoCardio/edit?id='.$evolucion_trasplante_eco_cardio->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('EvolucionTrasplanteEcoCardio/index') ?>">List</a>
