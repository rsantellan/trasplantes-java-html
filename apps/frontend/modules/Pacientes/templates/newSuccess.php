<?php use_javascript("jquery-1.6.1.min.js","first");?>
<?php 
  use_helper('mdAsset') ;
  use_plugin_javascript('mastodontePlugin', 'jquery-ui-1.8.4/js/jquery-ui-1.8.4.custom.min.js', 'first');
  use_plugin_stylesheet('mastodontePlugin', '../js/jquery-ui-1.8.4/css/smoothness/jquery-ui-1.8.4.custom.css');
?>
<h1>New Pacientes</h1>

<?php include_partial('form', array('form' => $form)) ?>
