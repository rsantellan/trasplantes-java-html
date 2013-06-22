<?php
  use_javascript("trasplanteNewManagement.js");
  use_javascript("donantesManagement.js");
  use_stylesheet("tabsLeft.css");
?>

<?php if(!$form->getObject()->isNew()): ?>
<h1><?php echo __("Trasplante_Titulo edicion");?></h1>
<a href="<?php echo url_for("@mostrarTrasplante?id=".$form->getObject()->getId());?>">
  <span><?php echo __("trasplante_Volver al trasplante.");?></span>
</a>
<?php else: ?>
<h1><?php echo __("Trasplante_Titulo de uno nuevo");?></h1>
<?php endif; ?>

<?php include_partial('small_form', array('form' => $form)) ?>

