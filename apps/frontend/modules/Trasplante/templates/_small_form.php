<?php
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
?>

<form action="<?php echo url_for('@salvarTrasplante?pre_trasplante_id='.$form->getObject()->getPacientePreTrasplanteId()) ?>" method="post">
  <?php echo $form->renderHiddenFields() ?>
  <?php echo $form->renderGlobalErrors() ?>
  
  <?php
  
    $error_1 = false;
    if($form['fecha']->hasError() || $form['donante_id']->hasError() || $form['numero_de_transplantes_realizados']->hasError())
    {
      $error_1 = true;
    }
    
    $error_2 = false;
    if($form['pra_max']->hasError() || $form['pra_tr']->hasError() || $form['numero_transf']->hasError() || $form['trans_previas']->hasError() || $form['embarazo']->hasError() || $form['numero_embarazo']->hasError() || $form['autoac']->hasError())
    {
      $error_2 = true;
    }
    
    $error_3 = false;
    if($form['numero_compatibilidad_ab']->hasError() || $form['numero_incompatibilidad_dr']->hasError() || $form['numero_compatibilidad_dr']->hasError() || $form['numero_incompatibilidad_ab']->hasError())
    {
      $error_3 = true;
    }

    $error_4 = false;
    if($form['rinhon']->hasError() || $form['anast_ureteral']->hasError() || $form['anast_arterial']->hasError() || $form['anast_venosa']->hasError() || $form['lado_implante']->hasError() || $form['liquido_perfusion']->hasError() || $form['ureter']->hasError() || $form['numero_arterias']->hasError() || $form['numero_venas']->hasError())
    {
      $error_4 = true;
    }    

    $error_5 = false;
    if($form['cr_inicial']->hasError() || $form['dia_rec_diuresis']->hasError() || $form['dia_rec_funcional']->hasError())
    {
      $error_5 = true;
    }

    $error_6 = false;
    if($form['sangrado_i_op']->hasError() || $form['otras_compl_quirur']->hasError() || $form['necesidad_repefundir']->hasError() || $form['lesion_venosa']->hasError() || $form['inestab_hemodial']->hasError() || $form['anomalia_vascular']->hasError() || $form['lesion_arterial']->hasError() || $form['tq_de_banco']->hasError())
    {
      $error_6 = true;
    }

    $error_7 = false;
    if($form['t_isq_cal_min']->hasError() || $form['diuresis_i_op']->hasError() || $form['reperfusion']->hasError() || $form['t_isq_tibia_hs']->hasError() || $form['t_isq_fria_hs']->hasError() || $form['t_isq_fria_min']->hasError())
    {
      $error_7 = true;
    }

    $error_9 = false;
    if($form['comentario']->hasError())
    {
      $error_9 = true;
    }
    
    $error_10 = false;
    if($form['dialisis']->hasError() || $form['num_de_hd']->hasError())
    {
      $error_10 = true;
    }                
  ?>
  
  <div id="form_tabs" class="tabs-left">
    <ul>
	  
	  
      <li>
          <a href="#contenedor-1">
            <?php echo __("Trasplante_contenedor 1");?>
            <?php if($error_1): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-2">
            <?php echo __("Trasplante_contenedor 2");?>
            <?php if($error_2): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-3">
            <?php echo __("Trasplante_contenedor 3");?>
            <?php if($error_3): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-4">
            <?php echo __("Trasplante_contenedor 4");?>
            <?php if($error_4): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-5">
            <?php echo __("Trasplante_contenedor 5");?>
            <?php if($error_5): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-6">
            <?php echo __("Trasplante_contenedor 6");?>
            <?php if($error_6): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-7">
            <?php echo __("Trasplante_contenedor 7");?>
            <?php if($error_7): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-8">
            <?php echo __("Trasplante_contenedor 8");?>
            <?php if(false && $error_7): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-9">
            <?php echo __("Trasplante_contenedor 9");?>
            <?php if($error_9): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>
      <li>
          <a href="#contenedor-10">
            <?php echo __("Trasplante_contenedor 10");?>
            <?php if($error_10): ?>
              <label class="acordion_error"><?php echo __("Trasplante_error en acordion");?></label>
            <?php endif;?>
          </a>
      </li>                                                      
    </ul>

    <div id="contenedor-1">
      <h2><?php echo __("Trasplante_contenedor 1");?></h2>
      <div class="form_accordion_block">
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

      <div class="clear"></div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Donante");?></h4>
        <div class="form_block_field<?php if($form['donante_id']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['donante_id']->render() ?>
        </div>
        <a id="manage_donantes_link" href="<?php echo url_for("@manejarDonante");?>" class="simple_tip_container">
          <?php echo image_tag("add_block.png", array("width" => 24)); ?>
          <div class="tooltip_text"><?php echo __("donante_manejar");?></div>		
        </a>
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
      
      

      <div class="clear"></div>
      <div class="form_accordion_block">
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
      
    </div>  
    
    <div id="contenedor-2">
      <h2><?php echo __("Trasplante_contenedor 2");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_pra max");?></h4>
        <div class="form_block_field<?php if($form['pra_max']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['pra_max']->render() ?>
        </div>
        <div>
        <?php 

        if($form['pra_max']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_pra max").': '.__("Trasplante_error ".$form['pra_max']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_pra tr");?></h4>
        <div class="form_block_field<?php if($form['pra_tr']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['pra_tr']->render() ?>
        </div>
        <div>
        <?php 

        if($form['pra_tr']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_pra tr").': '.__("Trasplante_error ".$form['pra_tr']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_numero de transf");?></h4>
        <div class="form_block_field<?php if($form['numero_transf']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['numero_transf']->render() ?>
        </div>
        <div>
          <?php 
          
          if($form['numero_transf']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_numero de transf").': '.__("Trasplante_error ".$form['numero_transf']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>    
   
	  <div class="clear"></div>
	  
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_trans previas");?></h4>
        <div class="form_block_field<?php if($form['trans_previas']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['trans_previas']->render() ?>
        </div>
        <div>
        <?php 

        if($form['trans_previas']->hasError()): 
        
          ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_trans previas").': '.__("Trasplante_error ".$form['trans_previas']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_embarazo");?></h4>
        <div class="form_block_field<?php if($form['embarazo']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['embarazo']->render() ?>
        </div>
        <div>
        <?php 

        if($form['embarazo']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_embarazo").': '.__("Trasplante_error ".$form['embarazo']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de embarazo");?></h4>
        <div class="form_block_field<?php if($form['numero_embarazo']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_embarazo']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_embarazo']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de embarazo").': '.__("Trasplante_error ".$form['numero_embarazo']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_autoac");?></h4>
        <div class="form_block_field<?php if($form['autoac']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['autoac']->render() ?>
        </div>
        <div>
        <?php 

        if($form['autoac']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_autoac").': '.__("Trasplante_error ".$form['autoac']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>      
    </div>
  
    <div id="contenedor-3">
      <h2><?php echo __("Trasplante_contenedor 3");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de compatibilidad AB");?></h4>
        <div class="form_block_field<?php if($form['numero_compatibilidad_ab']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_compatibilidad_ab']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_compatibilidad_ab']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de compatibilidad AB").': '.__("Trasplante_error ".$form['numero_compatibilidad_ab']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de compatibilidad DR");?></h4>
        <div class="form_block_field<?php if($form['numero_compatibilidad_dr']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_compatibilidad_dr']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_compatibilidad_dr']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de compatibilidad DR").': '.__("Trasplante_error ".$form['numero_compatibilidad_dr']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>	

      <div class="clear"></div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de incompatibilidad AB");?></h4>
        <div class="form_block_field<?php if($form['numero_incompatibilidad_ab']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_incompatibilidad_ab']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_incompatibilidad_ab']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de incompatibilidad AB").': '.__("Trasplante_error ".$form['numero_incompatibilidad_ab']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de incompatibilidad DR");?></h4>
        <div class="form_block_field<?php if($form['numero_incompatibilidad_dr']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_incompatibilidad_dr']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_incompatibilidad_dr']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de incompatibilidad DR").': '.__("Trasplante_error ".$form['numero_incompatibilidad_dr']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>      
    </div>
    
    <div id="contenedor-4">
      <h2><?php echo __("Trasplante_contenedor 4");?></h2>
      <div class="form_accordion_block">
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

      <div class="form_accordion_block">
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
          $msg_error = __("Trasplante_Numero de arterias").': '.__("Trasplante_error ".$form['numero_arterias']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>  
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Numero de venas");?></h4>
        <div class="form_block_field<?php if($form['numero_venas']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['numero_venas']->render() ?>
        </div>
        <div>
        <?php 

        if($form['numero_venas']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Numero de venas").': '.__("Trasplante_error ".$form['numero_venas']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>  

	  <div class="clear"></div>
	  
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Ureter");?></h4>
        <div class="form_block_field<?php if($form['ureter']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['ureter']->render() ?>
        </div>
        <div>
        <?php 

        if($form['ureter']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_Ureter").': '.__("Trasplante_error ".$form['ureter']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_liquido de perfusion");?></h4>
        <div class="form_block_field<?php if($form['liquido_perfusion']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['liquido_perfusion']->render() ?>
        </div>
        <div>
        <?php 

        if($form['liquido_perfusion']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_liquido de perfusion").': '.__("Trasplante_error ".$form['liquido_perfusion']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_lado del implante");?></h4>
        <div class="form_block_field<?php if($form['lado_implante']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['lado_implante']->render() ?>
        </div>
        <div>
        <?php 

        if($form['lado_implante']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_lado del implante").': '.__("Trasplante_error ".$form['lado_implante']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="clear"></div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_anast venosa");?></h4>
        <div class="form_block_field<?php if($form['anast_venosa']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['anast_venosa']->render() ?>
        </div>
        <div>
        <?php 

        if($form['anast_venosa']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_anast venosa").': '.__("Trasplante_error ".$form['anast_venosa']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_anast arterial");?></h4>
        <div class="form_block_field<?php if($form['anast_arterial']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['anast_arterial']->render() ?>
        </div>
        <div>
        <?php 

        if($form['anast_arterial']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_anast arterial").': '.__("Trasplante_error ".$form['anast_arterial']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>	
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_anast ureteral");?></h4>
        <div class="form_block_field<?php if($form['anast_ureteral']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['anast_ureteral']->render() ?>
        </div>
        <div>
        <?php 

        if($form['anast_ureteral']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_anast ureteral").': '.__("Trasplante_error ".$form['anast_ureteral']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>      
    </div>
  
    <div id="contenedor-5">
      <h2><?php echo __("Trasplante_contenedor 5");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_cr inicial");?></h4>
        <div class="form_block_field<?php if($form['cr_inicial']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['cr_inicial']->render() ?>
        </div>
        <div>
        <?php 

        if($form['cr_inicial']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_cr inicial").': '.__("Trasplante_error ".$form['cr_inicial']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_dias rec diuresis");?></h4>
        <div class="form_block_field<?php if($form['dia_rec_diuresis']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['dia_rec_diuresis']->render() ?>
        </div>
        <div>
        <?php 

        if($form['dia_rec_diuresis']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_dias rec diuresis").': '.__("Trasplante_error ".$form['dia_rec_diuresis']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="clear"></div>

      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_dias rec funcional");?></h4>
        <div class="form_block_field<?php if($form['dia_rec_funcional']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['dia_rec_funcional']->render() ?>
        </div>
        <div>
        <?php 

        if($form['dia_rec_funcional']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_dias rec funcional").': '.__("Trasplante_error ".$form['dia_rec_funcional']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="clear"></div>
    
    </div>  

    <div id="contenedor-6">
      <h2><?php echo __("Trasplante_contenedor 6");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_sangrado i op");?></h4>
        <div class="form_block_field<?php if($form['sangrado_i_op']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['sangrado_i_op']->render() ?>
        </div>
        <div>
        <?php 

        if($form['sangrado_i_op']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_sangrado i op").': '.__("Trasplante_error ".$form['sangrado_i_op']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_lesion arterial");?></h4>
        <div class="form_block_field<?php if($form['lesion_arterial']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['lesion_arterial']->render() ?>
        </div>
        <div>
        <?php 

        if($form['lesion_arterial']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_lesion arterial").': '.__("Trasplante_error ".$form['lesion_arterial']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>	

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_tq de banco");?></h4>
        <div class="form_block_field<?php if($form['tq_de_banco']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['tq_de_banco']->render() ?>
        </div>
        <div>
        <?php 

        if($form['tq_de_banco']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_tq de banco").': '.__("Trasplante_error ".$form['tq_de_banco']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
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
      <div class="form_accordion_block">
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
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_lesion venosa");?></h4>
        <div class="form_block_field<?php if($form['lesion_venosa']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['lesion_venosa']->render() ?>
        </div>
        <div>
        <?php 

        if($form['lesion_venosa']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_lesion venosa").': '.__("Trasplante_error ".$form['lesion_venosa']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_necesidad de repefundir");?></h4>
        <div class="form_block_field<?php if($form['necesidad_repefundir']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['necesidad_repefundir']->render() ?>
        </div>
        <div>
        <?php 

        if($form['necesidad_repefundir']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_necesidad de repefundir").': '.__("Trasplante_error ".$form['necesidad_repefundir']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      <div class="clear"></div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_otras complicaciones quirurgicas");?></h4>
        <div class="form_block_field<?php if($form['otras_compl_quirur']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['otras_compl_quirur']->render() ?>
        </div>
        <div>
        <?php 

        if($form['otras_compl_quirur']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_otras complicaciones quirurgicas").': '.__("Trasplante_error ".$form['otras_compl_quirur']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
    
    </div>	

    <div id="contenedor-7">
      <h2><?php echo __("Trasplante_contenedor 7");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_t isq cal min");?></h4>
        <div class="form_block_field<?php if($form['t_isq_cal_min']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['t_isq_cal_min']->render() ?>
        </div>
        <div>
        <?php 

        if($form['t_isq_cal_min']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_t isq cal min").': '.__("Trasplante_error ".$form['t_isq_cal_min']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_t isq fria hs");?></h4>
        <div class="form_block_field<?php if($form['t_isq_fria_hs']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['t_isq_fria_hs']->render() ?>
        </div>
        <div>
        <?php 

        if($form['t_isq_fria_hs']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_t isq fria hs").': '.__("Trasplante_error ".$form['t_isq_fria_hs']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
      
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_t isq fria min");?></h4>
        <div class="form_block_field<?php if($form['t_isq_fria_min']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['t_isq_fria_min']->render() ?>
        </div>
        <div>
        <?php 

        if($form['t_isq_fria_min']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_t isq fria min").': '.__("Trasplante_error ".$form['t_isq_fria_min']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

	  <div class="clear"></div>
	  
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_t isq tibia hs");?></h4>
        <div class="form_block_field<?php if($form['t_isq_tibia_hs']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['t_isq_tibia_hs']->render() ?>
        </div>
        <div>
        <?php 

        if($form['t_isq_tibia_hs']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_t isq tibia hs").': '.__("Trasplante_error ".$form['t_isq_tibia_hs']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_reperfusion");?></h4>
        <div class="form_block_field<?php if($form['reperfusion']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['reperfusion']->render() ?>
        </div>
        <div>
        <?php 

        if($form['reperfusion']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_reperfusion").': '.__("Trasplante_error ".$form['reperfusion']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_diuresis i op");?></h4>
        <div class="form_block_field<?php if($form['diuresis_i_op']->hasError()):?> error_msg<?php endif; ?>">
        <?php echo $form['diuresis_i_op']->render() ?>
        </div>
        <div>
        <?php 

        if($form['diuresis_i_op']->hasError()): 
        ?>  
        <div class="clear"></div>
        <?php
          $msg_error = __("Trasplante_diuresis i op").': '.__("Trasplante_error ".$form['diuresis_i_op']->getError());
          echo $msg_error;  
        endif; 
        ?>
        </div>    
      </div>
    </div>	

    <div id="contenedor-8">
      <h2><?php echo __("Trasplante_contenedor 8");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Inducciones");?></h4>
        <a id="manage_inducciones_link" href="<?php echo url_for("@manejarInduccion");?>" class="simple_tip_container">
          <?php echo image_tag("add_block.png", array("width" => 24)); ?>
          <div class="tooltip_text tooltip_text_top"><?php echo __("induccion_manejar");?></div>		
        </a>
        <div class="form_block_field<?php if($form['trasplante_inducciones_list']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['trasplante_inducciones_list']->render() ?>
        </div>
        <div>
          <?php 
          
          if($form['trasplante_inducciones_list']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_Inducciones").': '.__("Trasplante_error ".$form['trasplante_inducciones_list']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_Inmunosupresores");?></h4>
        <a id="manage_inmunosupresores_link" href="<?php echo url_for("@manejarInmunosupresores");?>" class="simple_tip_container">
          <?php echo image_tag("add_block.png", array("width" => 24)); ?>
          <div class="tooltip_text tooltip_text_top"><?php echo __("inmunosupresores_manejar");?></div>		
        </a>
		<div class="form_block_field<?php if($form['trasplante_inmunosupresores_list']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['trasplante_inmunosupresores_list']->render() ?>
        </div>
		
        <div>
          <?php 
          
          if($form['trasplante_inmunosupresores_list']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_Inmunosupresores").': '.__("Trasplante_error ".$form['trasplante_inmunosupresores_list']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>
      <div class="clear"></div>
            
      
	  <?php include_component("Trasplante", "retrieveSeroles", array("id" => $form->getObject()->getId()));?>
    </div>

    <div id="contenedor-9">
      <h2><?php echo __("Trasplante_contenedor 9");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_comentario");?></h4>
        <div class="form_block_field<?php if($form['comentario']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['comentario']->render() ?>
        </div>
        <div>
          <?php 
          
          if($form['comentario']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_comentario").': '.__("Trasplante_error ".$form['comentario']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>
    </div>      
  
    <div id="contenedor-10">
      <h2><?php echo __("Trasplante_contenedor 10");?></h2>
      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_dialisis");?></h4>
        <div class="form_block_field<?php if($form['dialisis']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['dialisis']->render() ?>
        </div>
        <div>
          <?php 
          
          if($form['dialisis']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_dialisis").': '.__("Trasplante_error ".$form['dialisis']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>

      <div class="form_accordion_block">
        <h4><?php echo __("Trasplante_numero de hd");?></h4>
        <div class="form_block_field<?php if($form['num_de_hd']->hasError()):?> error_msg<?php endif; ?>">
          <?php echo $form['num_de_hd']->render() ?>
        </div>
        <div>
          <?php 
          
          if($form['num_de_hd']->hasError()): 
          ?>  
          <div class="clear"></div>
          <?php
            $msg_error = __("Trasplante_numero de hd").': '.__("Trasplante_error ".$form['num_de_hd']->getError());
            echo $msg_error;  
          endif; 
          ?>
        </div>    
      </div>    
    </div>
      
  </div>
<div class="clear"></div>
<div class="inputs_container">
  
  <input type="submit" value="<?php echo __("Trasplante_Guardar")?>"/>
</div>
</form>

<div class="clear"></div>
