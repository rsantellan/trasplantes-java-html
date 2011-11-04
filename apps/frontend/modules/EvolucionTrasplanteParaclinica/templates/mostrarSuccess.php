<?php
  use_helper("Date");
?>
<h2><?php echo __("Evoluciones_Paraclinica Titulo");?></h2>
<ul class="evolucion_Ecg">
  <li><?php echo __("Evoluciones_Paraclinica fecha");?> : <label class="bold_text"><?php echo format_date($evolucion->getFecha(), 'D');?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica pas");?> : <label class="bold_text"><?php echo $evolucion->getPas();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica pad");?> : <label class="bold_text"><?php echo $evolucion->getPad();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica diuresis");?> : <label class="bold_text"><?php echo $evolucion->getDiuresis();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica peso");?> : <label class="bold_text"><?php echo $evolucion->getPeso();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica urea");?> : <label class="bold_text"><?php echo $evolucion->getUrea();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica creatinina");?> : <label class="bold_text"><?php echo $evolucion->getCreatinina();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica ht");?> : <label class="bold_text"><?php echo $evolucion->getHt();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica hb");?> : <label class="bold_text"><?php echo $evolucion->getHb();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica gb");?> : <label class="bold_text"><?php echo $evolucion->getGb();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica plaquetas");?> : <label class="bold_text"><?php echo $evolucion->getPlaquetas();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica sodio");?> : <label class="bold_text"><?php echo $evolucion->getSodio();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica potasio");?> : <label class="bold_text"><?php echo $evolucion->getPotasio();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica cloro");?> : <label class="bold_text"><?php echo $evolucion->getCloro();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica calcio");?> : <label class="bold_text"><?php echo $evolucion->getCalcio();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica fosforo");?> : <label class="bold_text"><?php echo $evolucion->getFosforo();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica glicemia");?> : <label class="bold_text"><?php echo $evolucion->getGlicemia();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica uricemia");?> : <label class="bold_text"><?php echo $evolucion->getUricemia();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica prot_u");?> : <label class="bold_text"><?php echo $evolucion->getProtU();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica ccreatinina");?> : <label class="bold_text"><?php echo $evolucion->getCcreatinina();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica curea");?> : <label class="bold_text"><?php echo $evolucion->getCurea();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica na_u");?> : <label class="bold_text"><?php echo $evolucion->getNaU();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica ku");?> : <label class="bold_text"><?php echo $evolucion->getKu();?></label></li>

  <li><?php echo __("Evoluciones_Paraclinica cya_pv");?> : <label class="bold_text"><?php echo $evolucion->getCyaPv();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica cya_pp");?> : <label class="bold_text"><?php echo $evolucion->getCyaPp();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica fk_p");?> : <label class="bold_text"><?php echo $evolucion->getFkP();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica mfm_p");?> : <label class="bold_text"><?php echo $evolucion->getMfmP();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica eve_p");?> : <label class="bold_text"><?php echo $evolucion->getEveP();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica bd");?> : <label class="bold_text"><?php echo $evolucion->getBd();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica bi");?> : <label class="bold_text"><?php echo $evolucion->getBi();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica tgo");?> : <label class="bold_text"><?php echo $evolucion->getTgo();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica tgp");?> : <label class="bold_text"><?php echo $evolucion->getTgp();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica gammagt");?> : <label class="bold_text"><?php echo $evolucion->getGammagt();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica f_alc");?> : <label class="bold_text"><?php echo $evolucion->getFAlc();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica t_prot");?> : <label class="bold_text"><?php echo $evolucion->getTProt();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica kptt");?> : <label class="bold_text"><?php echo $evolucion->getKptt();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica howell");?> : <label class="bold_text"><?php echo $evolucion->getHowell();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica fibrinogeno");?> : <label class="bold_text"><?php echo $evolucion->getFibrinogeno();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica colesterol");?> : <label class="bold_text"><?php echo $evolucion->getColesterol();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica hdl");?> : <label class="bold_text"><?php echo $evolucion->getHdl();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica ldl");?> : <label class="bold_text"><?php echo $evolucion->getLdl();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica r_at");?> : <label class="bold_text"><?php echo $evolucion->getRAt();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica tg");?> : <label class="bold_text"><?php echo $evolucion->getTg();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica hna1c");?> : <label class="bold_text"><?php echo $evolucion->getHna1c();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica albumina");?> : <label class="bold_text"><?php echo $evolucion->getAlbumina();?></label></li>
  
  <li><?php echo __("Evoluciones_Paraclinica globulinas");?> : <label class="bold_text"><?php echo $evolucion->getGlobulinas();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica pthi");?> : <label class="bold_text"><?php echo $evolucion->getPthi();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica otros");?> : <label class="bold_text"><?php echo $evolucion->getOtros();?></label></li>
  <li><?php echo __("Evoluciones_Paraclinica numpthi");?> : <label class="bold_text"><?php echo $evolucion->getNumpthi();?></label></li>

</ul>

<div class="clear"></div>
<hr/>
