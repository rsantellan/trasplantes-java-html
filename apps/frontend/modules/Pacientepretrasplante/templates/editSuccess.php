<h1><?php echo __("pacientePreTrasplante_Titulo de editar");?></h1>

<span>
  <a href="<?php echo url_for("@mostrarPaciente?id=".$form->getObject()->getPacienteId());?>">
	<?php echo __("pacientePreTrasplante_Volver");?>
  </a>
</span>
<?php include_partial('small_form', array('form' => $form)) ?>

<script type="text/javascript">
$(document).ready(function(){
$('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["-5", "-60"]
	  });
  });  
  $(".save_button").button();
  $(".cancel_link").button();
});
</script>
