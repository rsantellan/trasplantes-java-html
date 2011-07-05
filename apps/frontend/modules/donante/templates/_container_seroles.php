<div class="serol_container serol_container_<?php echo $serol->getId();?>" >
  <h4><?php echo $serol->getTipo();?></h4>
  <?php foreach($serol->getSerolValor() as $valor): ?>
    <?php echo $valor->getId();?>
    <input type="radio" name="seroles[valor][<?php echo $serol->getTipo();?>][]" value="<?php echo $valor->getId();?>" <?php if(array_key_exists($valor->getId(),$serolesAsociados->getRawValue())) echo "checked"?>/> 
    <?php echo $valor->__toString();?>
    <br/>
  <?php endforeach;?>
</div>
