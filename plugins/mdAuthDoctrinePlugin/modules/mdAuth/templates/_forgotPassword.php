<div class="modal_bg">
    <div id="modal_center">
        <div class="cabezal">
            <h1 class="float_left">Recordar contraseña</h1>
            <div class="close float_right"><a href="">Cerrar</a></div>
        </div>
        <div class="clear"></div>
        <div>
            <form action="<?php echo url_for('@resetPassword') ?>" method="post" id="form_reset_password_ajax">
                <ul>
                    <li>
				Le enviaremos sus datos de login a su casilla de mail
                    </li>
                    <li>
                        <?php echo $form['email']->render(array('value'=>'Email')); ?><?php echo $form['email']->renderError(); ?>
                        <?php echo $form['_csrf_token']->render(); ?>
                    </li>
                    <li>
                        <?php if(isset ($exception)): ?>
                            <?php print_r($exception); ?>
                        <?php endif; ?>
                    </li>
                    <li>
                        <div class="float_right">
                            <input type="submit" value="enviar clave">
                        </div>
                        <div class="clear"></div>
                    </li>
                    <li>
                        <a href="">loguerame</a>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
