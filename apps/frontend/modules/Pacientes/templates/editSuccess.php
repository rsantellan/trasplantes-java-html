<?php
  use_javascript("pacientesNewManagement.js");
?>
<h1><?php echo __("paciente_Editar Paciente");?></h1>

<div class="form_container">
  <?php include_partial('small_form', array('form' => $form)) ?>
  
</div>

<hr/>


<div>
    <form action="<?php echo url_for('@eliminarPaciente');?>" method="POST" onsubmit="return deletePaciente('<?php echo __("paciente_Eliminar Paciente confirmacion 1");?>', '<?php echo __("paciente_Eliminar Paciente confirmacion 2");?>');">
        <input type="hidden" value="<?php echo $form->getObject()->getId(); ?>" name="id" /> 
        <input class="save_button" type="submit" value="<?php echo __("paciente_Eliminar Paciente");?>"/>
    </form>
</div>
