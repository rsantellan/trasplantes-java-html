<?php 
  //use_helper('mdAsset');
  //use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  //use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  //use_javascript("complicacionesManagement.js", "last"); 
?>
<h1><?php echo __("trasplanteComplicacion_agregar complicacion no infecciosa");?></h1>
<?php include_partial("small_form_no_infecciosa", array("form" => $form)); ?>
