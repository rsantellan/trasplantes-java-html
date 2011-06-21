<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <?php include_http_metas() ?>
    <?php include_metas() ?>
    <?php include_title() ?>
    <link rel="shortcut icon" href="/favicon.ico" />
    <?php use_stylesheet("styles.css");?>
	<?php use_javascript("jquery-1.6.1.min.js","first");?>
	<?php 
	  use_helper('mdAsset') ;
	  use_plugin_javascript('mastodontePlugin', 'jquery-ui-1.8.4/js/jquery-ui-1.8.4.custom.min.js', 'first');
	  use_plugin_stylesheet('mastodontePlugin', '../js/jquery-ui-1.8.4/css/smoothness/jquery-ui-1.8.4.custom.css');
	  use_javascript("simpleTip/jquery.simpletip-1.3.1.js");
	?>	
    <?php include_stylesheets() ?>
    <?php include_javascripts() ?>
    	
  </head>
  <body>
	<!--<a name="top" id="top"></a>-->
	<center>
	  <div class="menu">
		<?php include_partial("global/menu");?>	
	  </div>
	  <?php if(has_slot('layout_paciente')): ?>
		<?php include_partial("global/header_paciente");?>
	  <?php else: ?>
		<?php include_partial("global/header");?>
	  <?php endif; ?>
	  <div class="content">
		<?php if(has_slot('layout_introduccion')): ?>
		  <?php include_partial("global/introduccion");?>
		<?php endif; ?>
		<div class="mainbar">
		  <?php echo $sf_content ?>        
		</div>
	  </div>
	  <div class="footer">
		<?php include_partial("global/footer");?>
	  </div>
	</center>
  </body>
</html>
