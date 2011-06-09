<?php use_javascript("jquery-1.6.1.min.js","first");?>
<?php 
  use_helper('mdAsset') ;
  use_plugin_javascript('mastodontePlugin', 'jquery-ui-1.8.4/js/jquery-ui-1.8.4.custom.min.js', 'first');
  use_plugin_stylesheet('mastodontePlugin', '../js/jquery-ui-1.8.4/css/smoothness/jquery-ui-1.8.4.custom.css');
  use_plugin_javascript('mastodontePlugin','jquery-ui-1.8.4/development-bundle/ui/i18n/jquery.ui.datepicker-'.sfContext::getInstance()->getUser()->getCulture().'.js','last'); 
?>

<h1><?php echo __("paciente_Agregar Paciente");?></h1>

<div class="form_container">
  <?php include_partial('small_form', array('form' => $form)) ?>
  
</div>
<?php //include_partial('form', array('form' => $form)) ?>
