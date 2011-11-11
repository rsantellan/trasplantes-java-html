<?php
  use_helper("Date");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("cmvManagement.js",'last');
?>
<h1><?php echo __("CMV_titulo lista");?></h1>

<div id="cmv_container">
    <?php foreach ($cmvs as $cmv): ?>
        <?php include_partial("cmvList", array("cmv" => $cmv)); ?>
    <?php endforeach;?>
</div>
<div class="clear"></div>

<a class="fancy_link" href="<?php echo url_for('@agregarCmv?id='.$id) ?>"><?php echo __("CMV_agregar nuevo");?></a>
<hr/>
<div class="volver">
    <a href="<?php echo url_for("@mostrarTrasplante?id=".$id);?>"><?php echo __("Trasplante_volver a ver trasplante");?></a>
</div>
