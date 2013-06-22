<?php
  use_javascript("trasplanteNewManagement.js");
  use_javascript("donantesManagement.js");
  use_stylesheet("tabsLeft.css");
?>

<h1><?php echo __("Trasplante_Titulo de edicion nuevo");?></h1>

<a href="<?php echo url_for("@mostrarTrasplante?id=".$form->getObject()->getId());?>">
  <span><?php echo __("reoperacion_Volver al trasplante.");?></span>
</a>

<?php include_partial('small_form', array('form' => $form)) ?>
