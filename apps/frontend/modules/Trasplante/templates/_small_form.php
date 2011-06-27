<?php
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<form action="<?php echo url_for('Trasplante/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
  <?php echo $form->renderHiddenFields(false) ?>
  <?php echo $form->renderGlobalErrors() ?>
  
  <div class="form_block">
    <h4><?php echo __("Trasplante_Fecha del trasplante");?></h4>
    <a href="javascript:void(0)" class="simple_tip_container">
      <?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
      <div class="tooltip_text"><?php echo __("ayuda_formato de las fechas yy - mm - dd");?></div>		
    </a>    
    <div class="form_block_field<?php if($form['fecha']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['fecha']->render() ?>
    </div>
    <div>
      <?php 
      if($form['fecha']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Fecha del trasplante").': '.__("Trasplante_error ".$form['fecha']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>
  </div> 
  
  <div class="form_block">
    <h4><?php echo __("Trasplante_Numero de trasplantes realizados");?></h4>
    <div class="form_block_field<?php if($form['numero_de_transplantes_realizados']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['numero_de_transplantes_realizados']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['numero_de_transplantes_realizados']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Numero de trasplantes realizados").': '.__("Trasplante_error ".$form['numero_de_transplantes_realizados']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>
  </div>
  <div class="clear"></div>

  <div class="form_block">
    <h4><?php echo __("Trasplante_Donante");?></h4>
    <div class="form_block_field<?php if($form['donante_id']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['donante_id']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['donante_id']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Donante").': '.__("Trasplante_error ".$form['donante_id']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>
  </div>  
  
  <div class="form_block">
    <h4><?php echo __("Trasplante_Inestabilidad hemodial");?></h4>
    <div class="form_block_field<?php if($form['inestab_hemodial']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['inestab_hemodial']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['inestab_hemodial']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Inestabilidad hemodial").': '.__("Trasplante_error ".$form['inestab_hemodial']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>    
  </div>
  <div class="clear"></div>
  
  <div class="form_block">
    <h4><?php echo __("Trasplante_Riñon");?></h4>
    <div class="form_block_field<?php if($form['rinhon']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['rinhon']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['rinhon']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Riñon").': '.__("Trasplante_error ".$form['rinhon']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>    
  </div>

  <div class="form_block">
    <h4><?php echo __("Trasplante_Anomalia vascular");?></h4>
    <div class="form_block_field<?php if($form['anomalia_vascular']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['anomalia_vascular']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['anomalia_vascular']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Anomalia vascular").': '.__("Trasplante_error ".$form['anomalia_vascular']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>    
  </div>
  <div class="clear"></div>
  
  <div class="form_block">
    <h4><?php echo __("Trasplante_Numero de arterias");?></h4>
    <div class="form_block_field<?php if($form['numero_arterias']->hasError()):?> error_msg<?php endif; ?>">
      <?php echo $form['numero_arterias']->render() ?>
    </div>
    <div>
      <?php 
      
      if($form['numero_arterias']->hasError()): 
      ?>  
      <div class="clear"></div>
      <?php
        $msg_error = __("Trasplante_Riñon").': '.__("Trasplante_error ".$form['numero_arterias']->getError());
        echo $msg_error;  
      endif; 
      ?>
    </div>    
  </div>  
  
         
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tbody>

      <tr>
        <th><?php echo $form['numero_arterias']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_arterias']->renderError() ?>
          <?php echo $form['numero_arterias'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_venas']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_venas']->renderError() ?>
          <?php echo $form['numero_venas'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ureter']->renderLabel() ?></th>
        <td>
          <?php echo $form['ureter']->renderError() ?>
          <?php echo $form['ureter'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_compatibilidad_ab']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_compatibilidad_ab']->renderError() ?>
          <?php echo $form['numero_compatibilidad_ab'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_compatibilidad_dr']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_compatibilidad_dr']->renderError() ?>
          <?php echo $form['numero_compatibilidad_dr'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_incompatibilidad_ab']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_incompatibilidad_ab']->renderError() ?>
          <?php echo $form['numero_incompatibilidad_ab'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_incompatibilidad_dr']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_incompatibilidad_dr']->renderError() ?>
          <?php echo $form['numero_incompatibilidad_dr'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['autoac']->renderLabel() ?></th>
        <td>
          <?php echo $form['autoac']->renderError() ?>
          <?php echo $form['autoac'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pra_max']->renderLabel() ?></th>
        <td>
          <?php echo $form['pra_max']->renderError() ?>
          <?php echo $form['pra_max'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pra_tr']->renderLabel() ?></th>
        <td>
          <?php echo $form['pra_tr']->renderError() ?>
          <?php echo $form['pra_tr'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['trans_previas']->renderLabel() ?></th>
        <td>
          <?php echo $form['trans_previas']->renderError() ?>
          <?php echo $form['trans_previas'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_transf']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_transf']->renderError() ?>
          <?php echo $form['numero_transf'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['embarazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['embarazo']->renderError() ?>
          <?php echo $form['embarazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numero_embarazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['numero_embarazo']->renderError() ?>
          <?php echo $form['numero_embarazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['liquido_perfusion']->renderLabel() ?></th>
        <td>
          <?php echo $form['liquido_perfusion']->renderError() ?>
          <?php echo $form['liquido_perfusion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tq_de_banco']->renderLabel() ?></th>
        <td>
          <?php echo $form['tq_de_banco']->renderError() ?>
          <?php echo $form['tq_de_banco'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['lado_implante']->renderLabel() ?></th>
        <td>
          <?php echo $form['lado_implante']->renderError() ?>
          <?php echo $form['lado_implante'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['anast_venosa']->renderLabel() ?></th>
        <td>
          <?php echo $form['anast_venosa']->renderError() ?>
          <?php echo $form['anast_venosa'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['anast_arterial']->renderLabel() ?></th>
        <td>
          <?php echo $form['anast_arterial']->renderError() ?>
          <?php echo $form['anast_arterial'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['anast_ureteral']->renderLabel() ?></th>
        <td>
          <?php echo $form['anast_ureteral']->renderError() ?>
          <?php echo $form['anast_ureteral'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['t_isq_cal_min']->renderLabel() ?></th>
        <td>
          <?php echo $form['t_isq_cal_min']->renderError() ?>
          <?php echo $form['t_isq_cal_min'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['t_isq_fria_hs']->renderLabel() ?></th>
        <td>
          <?php echo $form['t_isq_fria_hs']->renderError() ?>
          <?php echo $form['t_isq_fria_hs'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['t_isq_fria_min']->renderLabel() ?></th>
        <td>
          <?php echo $form['t_isq_fria_min']->renderError() ?>
          <?php echo $form['t_isq_fria_min'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['t_isq_tibia_hs']->renderLabel() ?></th>
        <td>
          <?php echo $form['t_isq_tibia_hs']->renderError() ?>
          <?php echo $form['t_isq_tibia_hs'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['reperfusion']->renderLabel() ?></th>
        <td>
          <?php echo $form['reperfusion']->renderError() ?>
          <?php echo $form['reperfusion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['sangrado_i_op']->renderLabel() ?></th>
        <td>
          <?php echo $form['sangrado_i_op']->renderError() ?>
          <?php echo $form['sangrado_i_op'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['lesion_arterial']->renderLabel() ?></th>
        <td>
          <?php echo $form['lesion_arterial']->renderError() ?>
          <?php echo $form['lesion_arterial'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['lesion_venosa']->renderLabel() ?></th>
        <td>
          <?php echo $form['lesion_venosa']->renderError() ?>
          <?php echo $form['lesion_venosa'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['necesidad_repefundir']->renderLabel() ?></th>
        <td>
          <?php echo $form['necesidad_repefundir']->renderError() ?>
          <?php echo $form['necesidad_repefundir'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['otras_compl_quirur']->renderLabel() ?></th>
        <td>
          <?php echo $form['otras_compl_quirur']->renderError() ?>
          <?php echo $form['otras_compl_quirur'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['diuresis_i_op']->renderLabel() ?></th>
        <td>
          <?php echo $form['diuresis_i_op']->renderError() ?>
          <?php echo $form['diuresis_i_op'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cr_inicial']->renderLabel() ?></th>
        <td>
          <?php echo $form['cr_inicial']->renderError() ?>
          <?php echo $form['cr_inicial'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dia_rec_diuresis']->renderLabel() ?></th>
        <td>
          <?php echo $form['dia_rec_diuresis']->renderError() ?>
          <?php echo $form['dia_rec_diuresis'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dia_rec_funcional']->renderLabel() ?></th>
        <td>
          <?php echo $form['dia_rec_funcional']->renderError() ?>
          <?php echo $form['dia_rec_funcional'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dialisis']->renderLabel() ?></th>
        <td>
          <?php echo $form['dialisis']->renderError() ?>
          <?php echo $form['dialisis'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['num_de_hd']->renderLabel() ?></th>
        <td>
          <?php echo $form['num_de_hd']->renderError() ?>
          <?php echo $form['num_de_hd'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['comentario']->renderLabel() ?></th>
        <td>
          <?php echo $form['comentario']->renderError() ?>
          <?php echo $form['comentario'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
