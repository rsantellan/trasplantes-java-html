<?php
  use_javascript("trasplanteNewManagement.js");
  use_javascript("donantesManagement.js");
?>

<h1><?php echo __("Trasplante_Titulo de uno nuevo");?></h1>

<?php include_partial('small_form', array('form' => $form)) ?>

