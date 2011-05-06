<h1>Trasplantes List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Paciente pre trasplante</th>
      <th>Fecha</th>
      <th>Numero de transplantes realizados</th>
      <th>Donante</th>
      <th>Inestab hemodial</th>
      <th>Rinhon</th>
      <th>Anomalia vascular</th>
      <th>Numero arterias</th>
      <th>Numero venas</th>
      <th>Ureter</th>
      <th>Numero compatibilidad ab</th>
      <th>Numero compatibilidad dr</th>
      <th>Numero incompatibilidad ab</th>
      <th>Numero incompatibilidad dr</th>
      <th>Autoac</th>
      <th>Pra max</th>
      <th>Pra tr</th>
      <th>Trans previas</th>
      <th>Numero transf</th>
      <th>Embarazo</th>
      <th>Numero embarazo</th>
      <th>Liquido perfusion</th>
      <th>Tq de banco</th>
      <th>Lado implante</th>
      <th>Anast venosa</th>
      <th>Anast arterial</th>
      <th>Anast ureteral</th>
      <th>T isq cal min</th>
      <th>T isq fria hs</th>
      <th>T isq fria min</th>
      <th>T isq tibia hs</th>
      <th>Reperfusion</th>
      <th>Sangrado i op</th>
      <th>Lesion arterial</th>
      <th>Lesion venosa</th>
      <th>Necesidad repefundir</th>
      <th>Otras compl quirur</th>
      <th>Diuresis i op</th>
      <th>Cr inicial</th>
      <th>Dia rec diuresis</th>
      <th>Dia rec funcional</th>
      <th>Dialisis</th>
      <th>Num de hd</th>
      <th>Comentario</th>
      <th>Fecha alta</th>
      <th>Created at</th>
      <th>Updated at</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($trasplantes as $trasplante): ?>
    <tr>
      <td><a href="<?php echo url_for('Trasplante/show?id='.$trasplante->getId()) ?>"><?php echo $trasplante->getId() ?></a></td>
      <td><?php echo $trasplante->getPacientePreTrasplanteId() ?></td>
      <td><?php echo $trasplante->getFecha() ?></td>
      <td><?php echo $trasplante->getNumeroDeTransplantesRealizados() ?></td>
      <td><?php echo $trasplante->getDonanteId() ?></td>
      <td><?php echo $trasplante->getInestabHemodial() ?></td>
      <td><?php echo $trasplante->getRinhon() ?></td>
      <td><?php echo $trasplante->getAnomaliaVascular() ?></td>
      <td><?php echo $trasplante->getNumeroArterias() ?></td>
      <td><?php echo $trasplante->getNumeroVenas() ?></td>
      <td><?php echo $trasplante->getUreter() ?></td>
      <td><?php echo $trasplante->getNumeroCompatibilidadAb() ?></td>
      <td><?php echo $trasplante->getNumeroCompatibilidadDr() ?></td>
      <td><?php echo $trasplante->getNumeroIncompatibilidadAb() ?></td>
      <td><?php echo $trasplante->getNumeroIncompatibilidadDr() ?></td>
      <td><?php echo $trasplante->getAutoac() ?></td>
      <td><?php echo $trasplante->getPraMax() ?></td>
      <td><?php echo $trasplante->getPraTr() ?></td>
      <td><?php echo $trasplante->getTransPrevias() ?></td>
      <td><?php echo $trasplante->getNumeroTransf() ?></td>
      <td><?php echo $trasplante->getEmbarazo() ?></td>
      <td><?php echo $trasplante->getNumeroEmbarazo() ?></td>
      <td><?php echo $trasplante->getLiquidoPerfusion() ?></td>
      <td><?php echo $trasplante->getTqDeBanco() ?></td>
      <td><?php echo $trasplante->getLadoImplante() ?></td>
      <td><?php echo $trasplante->getAnastVenosa() ?></td>
      <td><?php echo $trasplante->getAnastArterial() ?></td>
      <td><?php echo $trasplante->getAnastUreteral() ?></td>
      <td><?php echo $trasplante->getTIsqCalMin() ?></td>
      <td><?php echo $trasplante->getTIsqFriaHs() ?></td>
      <td><?php echo $trasplante->getTIsqFriaMin() ?></td>
      <td><?php echo $trasplante->getTIsqTibiaHs() ?></td>
      <td><?php echo $trasplante->getReperfusion() ?></td>
      <td><?php echo $trasplante->getSangradoIOp() ?></td>
      <td><?php echo $trasplante->getLesionArterial() ?></td>
      <td><?php echo $trasplante->getLesionVenosa() ?></td>
      <td><?php echo $trasplante->getNecesidadRepefundir() ?></td>
      <td><?php echo $trasplante->getOtrasComplQuirur() ?></td>
      <td><?php echo $trasplante->getDiuresisIOp() ?></td>
      <td><?php echo $trasplante->getCrInicial() ?></td>
      <td><?php echo $trasplante->getDiaRecDiuresis() ?></td>
      <td><?php echo $trasplante->getDiaRecFuncional() ?></td>
      <td><?php echo $trasplante->getDialisis() ?></td>
      <td><?php echo $trasplante->getNumDeHd() ?></td>
      <td><?php echo $trasplante->getComentario() ?></td>
      <td><?php echo $trasplante->getFechaAlta() ?></td>
      <td><?php echo $trasplante->getCreatedAt() ?></td>
      <td><?php echo $trasplante->getUpdatedAt() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('Trasplante/new') ?>">New</a>
