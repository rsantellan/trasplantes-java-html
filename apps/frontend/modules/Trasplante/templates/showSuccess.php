<?php 
  use_helper("date");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("trasplanteShowManagement.js",'last');
?>
<div class="trasplante_min_info_basica">
  <h2><?php echo __("Trasplante_Informacion basica")?></h2>
  <?php echo __("Trasplante_Fecha del trasplante");?> : <label class="bold_text"><?php echo format_date($trasplante['fecha'], 'D'); ?></label>
  <div class="clear"></div>
  <p class="slide">
	<a href="javascript:void(0)" onclick="trasplanteShowManagement.getInstance().showTrasplanteMoreInfo(this)" class="trasplante_min_info_basica_link"><?php echo __("Trasplante_Ver Informacion")?></a>
  </p>
</div>
<div class="trasplante_info_basica">
  <?php include_partial("showTrasplante", array("id" => $id)); ?>
</div>
<div class="clear"></div>
<a href="<?php echo url_for('Trasplante/edit?id='.$id) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Trasplante/index') ?>">List</a>
