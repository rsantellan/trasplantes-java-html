<img id="md_user_<?php echo $sf_user->getProfile()->getId();?>" src="<?php echo $sf_user->getProfile()->retrieveAvatar(array(mdWebOptions::WIDTH => $width, mdWebOptions::HEIGHT => $height, mdWebOptions::CODE => $code)); ?>" alt="<?php echo $sf_user->getProfile()->getFullName()?>"/>