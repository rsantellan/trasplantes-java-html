<?php 
  $trasplante = trasplanteHandler::retriveById($id, Doctrine_Core::HYDRATE_ARRAY ); 
  $donante = Donantehandler::retrieveById($trasplante['donante_id'], Doctrine_Core::HYDRATE_ARRAY );
  $inducciones = trasplanteHandler::retriveAllInduccionesByTrasplanteId($id, Doctrine_Core::HYDRATE_ARRAY );
  $inmunosupresores = trasplanteHandler::retriveAllInmunosupresoresByTrasplanteId($id, Doctrine_Core::HYDRATE_ARRAY );
  $seroles = trasplanteHandler::retrieveAllSerolesOfTrasplante($id );
  //var_dump($seroles);
?>
<div>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_Fecha del trasplante");?> : <label class="bold_text"><?php echo $trasplante['fecha']?></label></li>
	<li>
	  <a id="fancy_donante_link" href="<?php echo url_for("@mostrarDonante?id=".$trasplante['donante_id']);?>" title="<?php echo __("Trasplante_Donante");?>">
		<?php echo __("Trasplante_Donante");?> : <label class="bold_text"><?php echo $donante['identificador']?></label>
	  </a>
	</li>
	<li><?php echo __("Trasplante_Numero de trasplantes realizados");?> : <label class="bold_text"><?php echo $trasplante['numero_de_transplantes_realizados']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_pra max");?> : <label class="bold_text"><?php echo $trasplante['pra_max']?></label></li>
	<li><?php echo __("Trasplante_pra tr");?> : <label class="bold_text"><?php echo $trasplante['pra_tr']?></label></li>
	<li><?php echo __("Trasplante_numero de transf");?> : <label class="bold_text"><?php echo $trasplante['numero_transf']?></label></li>
	<li><?php echo __("Trasplante_trans previas");?> : <label class="bold_text"><?php echo $trasplante['trans_previas']?></label></li>
	<li><?php echo __("Trasplante_embarazo");?> : <label class="bold_text"><?php echo $trasplante['embarazo']?></label></li>
	<li><?php echo __("Trasplante_Numero de embarazo");?> : <label class="bold_text"><?php echo $trasplante['numero_embarazo']?></label></li>
	<li><?php echo __("Trasplante_autoac");?> : <label class="bold_text"><?php echo $trasplante['autoac']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_Numero de compatibilidad AB");?> : <label class="bold_text"><?php echo $trasplante['numero_compatibilidad_ab']?></label></li>
	<li><?php echo __("Trasplante_Numero de compatibilidad DR");?> : <label class="bold_text"><?php echo $trasplante['numero_compatibilidad_dr']?></label></li>
	<li><?php echo __("Trasplante_Numero de incompatibilidad AB");?> : <label class="bold_text"><?php echo $trasplante['numero_incompatibilidad_ab']?></label></li>
	<li><?php echo __("Trasplante_Numero de incompatibilidad DR");?> : <label class="bold_text"><?php echo $trasplante['numero_incompatibilidad_dr']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_Riñon");?> : <label class="bold_text"><?php echo $trasplante['rinhon']?></label></li>
	<li><?php echo __("Trasplante_Numero de arterias");?> : <label class="bold_text"><?php echo $trasplante['numero_arterias']?></label></li>
	<li><?php echo __("Trasplante_Numero de venas");?> : <label class="bold_text"><?php echo $trasplante['numero_venas']?></label></li>
	<li><?php echo __("Trasplante_Ureter");?> : <label class="bold_text"><?php echo $trasplante['ureter']?></label></li>
	<li><?php echo __("Trasplante_liquido de perfusion");?> : <label class="bold_text"><?php echo $trasplante['liquido_perfusion']?></label></li>
	<li><?php echo __("Trasplante_lado del implante");?> : <label class="bold_text"><?php echo $trasplante['lado_implante']?></label></li>
	<li><?php echo __("Trasplante_anast venosa");?> : <label class="bold_text"><?php echo $trasplante['anast_venosa']?></label></li>
	<li><?php echo __("Trasplante_anast arterial");?> : <label class="bold_text"><?php echo $trasplante['anast_arterial']?></label></li>
	<li><?php echo __("Trasplante_anast ureteral");?> : <label class="bold_text"><?php echo $trasplante['anast_ureteral']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_sangrado i op");?> : <label class="bold_text"><?php echo $trasplante['sangrado_i_op']?></label></li>
	<li><?php echo __("Trasplante_lesion arterial");?> : <label class="bold_text"><?php echo $trasplante['lesion_arterial']?></label></li>
	<li><?php echo __("Trasplante_tq de banco");?> : <label class="bold_text"><?php echo $trasplante['tq_de_banco']?></label></li>
	<li><?php echo __("Trasplante_Anomalia vascular");?> : <label class="bold_text"><?php echo $trasplante['anomalia_vascular']?></label></li>
	<li><?php echo __("Trasplante_Inestabilidad hemodial");?> : <label class="bold_text"><?php echo $trasplante['inestab_hemodial']?></label></li>
	<li><?php echo __("Trasplante_lesion venosa");?> : <label class="bold_text"><?php echo $trasplante['lesion_venosa']?></label></li>
	<li><?php echo __("Trasplante_necesidad de repefundir");?> : <label class="bold_text"><?php echo $trasplante['necesidad_repefundir']?></label></li>
	<li><?php echo __("Trasplante_otras complicaciones quirurgicas");?> : <label class="bold_text"><?php echo $trasplante['otras_compl_quirur']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_t isq cal min");?> : <label class="bold_text"><?php echo $trasplante['t_isq_cal_min']?></label></li>
	<li><?php echo __("Trasplante_t isq fria hs");?> : <label class="bold_text"><?php echo $trasplante['t_isq_fria_hs']?></label></li>
	<li><?php echo __("Trasplante_t isq fria min");?> : <label class="bold_text"><?php echo $trasplante['t_isq_fria_min']?></label></li>
	<li><?php echo __("Trasplante_t isq tibia hs");?> : <label class="bold_text"><?php echo $trasplante['t_isq_tibia_hs']?></label></li>
	<li><?php echo __("Trasplante_reperfusion");?> : <label class="bold_text"><?php echo $trasplante['reperfusion']?></label></li>
	<li><?php echo __("Trasplante_diuresis i op");?> : <label class="bold_text"><?php echo $trasplante['diuresis_i_op']?></label></li>
	<li><?php echo __("Trasplante_diuresis i op");?> : <label class="bold_text"><?php echo $trasplante['diuresis_i_op']?></label></li>
  </ul>
  <ul class="trasplante_info_ul">
	<li>
	  <?php echo __("Trasplante_Inducciones");?>
	  <?php if(count($inducciones) > 0): ?>
	  <ul>
		<?php foreach($inducciones as $induccion): ?>
		<li><?php echo $induccion["nombre"]; ?></li>
		<?php endforeach; ?>
	  </ul>
	  <?php endif; ?>
	</li>
	<li>
	  <?php echo __("Trasplante_Inmunosupresores");?>
	  <?php if(count($inmunosupresores) > 0): ?>
	  <ul>
		<?php foreach($inmunosupresores as $inmunosupresor): ?>
		<li><?php echo $inmunosupresor["nombre"]; ?></li>
		<?php endforeach; ?>
	  </ul>
	  <?php endif; ?>
	</li>
	<li>
	  <?php echo __("serol_seroles");?>
	  <?php if(count($seroles) > 0): ?>
	  <ul>
		<?php foreach($seroles as $serol): ?>
		<li><label class="bold_text"><?php echo $serol->getSerol()->getTipo()." : "; ?></label><?php echo $serol->getSerolValor(); ?></li>
		<?php endforeach; ?>
	  </ul>
	  <?php endif; ?>
	</li>
  </ul>
  <ul class="trasplante_info_ul">
	<li><?php echo __("Trasplante_dialisis");?> : <label class="bold_text"><?php echo $trasplante['dialisis']?></label></li>
	<li><?php echo __("Trasplante_numero de hd");?> : <label class="bold_text"><?php echo $trasplante['num_de_hd']?></label></li>
	<li><?php echo __("Trasplante_comentario");?> : <label class="bold_text"><?php echo $trasplante['comentario']?></label></li>
  </ul>
</div>
<div class="clear"></div>
<h4><a href="<?php echo url_for("@editarTrasplante?id=".$id);?>"><?php echo __("Trasplante_editar");?></a></h4>