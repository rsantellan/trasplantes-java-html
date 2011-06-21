<h1><?php echo __("muertePaciente_agregar informacion a la nueva muerte del paciente.");?></h1>

<div class="form_container">
  <?php include_partial('small_form', array('form' => $form)) ?>
</div>

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
  $(".cancel_href").button();
  
});
</script>