<ul class="donante_show_list">
  <li><?php echo __("donante_identificador");?> : <label class="bold_text"><?php echo $donante->getIdentificador() ?></label></li>
  <li><?php echo __("donante_tipo de donante");?> : <label class="bold_text"><?php echo $donante->getTipoDonante() ?></label></li>
  <li><?php echo __("donante_sexo");?> : 
	<label class="bold_text">
	<?php if($donante->getTipoDonante() == "F"): ?>
	  <?php echo __("donante_sexo femenino");?>
	<?php else: ?>
	  <?php echo __("donante_sexo masculino");?>
	<?php endif; ?>
	</label>
  </li>
  <li><?php echo __("donante_edad");?> : <label class="bold_text"><?php echo $donante->getEdadDonante() ?></label></li>
  <li><?php echo __("donante_enastab hemod");?> : <label class="bold_text"><?php echo $donante->getEnastabHemod() ?></label></li>
  <li><?php echo __("donante_causa de muerte");?> : <label class="bold_text"><?php echo $donante->getDonanteCausaMuerte()->getNombre() ?></label></li>
  <li><?php echo __("donante_cr p");?> : <label class="bold_text"><?php echo $donante->getCrP() ?></label></li>
  <li><?php echo __("donante_grupo sanguineo");?> : <label class="bold_text"><?php echo $donante->getGrupoSanguineo() ?></label></li>
  <li><?php echo __("donante_relacion filiar");?> : <label class="bold_text"><?php echo $donante->getRelacionFiliar() ?></label></li>
  <li><?php echo __("donante_peso");?> : <label class="bold_text"><?php echo $donante->getPeso() ?></label></li>
  <li><?php echo __("donante_altura");?> : <label class="bold_text"><?php echo $donante->getAltura() ?></label></li>
  <li>
		<?php echo __("donante_lista de organos");?>
		<?php if(count($donante->getDonanteOrganos()) > 0): ?>
		<ul>
		  <?php foreach($donante->getDonanteOrganos() as $object): ?>
		  <li>
			<?php echo $object->getNombre(); ?>
		  </li>
		  <?php endforeach; ?>
		</ul>
		<?php endif; ?>
  </li>
  <li>
		<?php echo __("donante_lista de antecedentes");?>
		<?php if(count($donante->getDonanteAntecedentes()) > 0): ?>
		<ul>
		  <?php foreach($donante->getDonanteAntecedentes() as $object): ?>
			<li>
			  <?php echo $object->getNombre(); ?>
			</li>  
		  <?php endforeach; ?>
		</ul>
		<?php endif; ?>  
  </li>
  <li>
	  <?php echo __("serol_seroles");?>
	  <?php $seroles = Donantehandler::retrieveAllSerolesOfDonante($donante->getId()); ?>
		<?php if(count($seroles) > 0): ?>
		  <ul>
			<?php foreach($seroles as $serol): ?>
			  <li><label class="bold_text"><?php echo $serol->getSerol()->getTipo()." : "; ?></label><?php echo $serol->getSerolValor(); ?></li>
			<?php endforeach; ?>
		  </ul>
		<?php endif; ?>	
  </li>
  <li><?php echo __("donante_otros");?> : <label class="bold_text"><?php echo $donante->getOtros() ?></label></li>
</ul>
<div class="clear"></div>