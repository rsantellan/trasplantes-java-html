<div style="height: 51px; margin: 4px;" ajax-url="<?php echo url_for("mdUserManagement/openBox")."?id=".$object->getId() ?>">
    <ul class="md_closed_object">
        <li class="md_img">
            
            <?php $hasImage = false; ?>
            <?php if( sfConfig::get( 'sf_plugins_user_media', false ) ):  ?>
                <?php $mdUserProfile = $object->getMdUserProfile(); ?>
                <?php if($mdUserProfile):?>
                    <img id="user_<?php echo $object->getId()?>" src="<?php echo $mdUserProfile->retrieveAvatar(array(mdWebOptions::WIDTH => 46, mdWebOptions::HEIGHT => 46, mdWebOptions::CODE => mdWebCodes::RESIZE)); ?>" />
                    <?php $hasImage = true; ?>
                <?php endif; ?>
            <?php endif; ?>
            <?php if(!$hasImage): ?>
                <?php use_helper('mdAsset');?>
                <?php echo plugin_image_tag('mdUserDoctrinePlugin','md_user_image.jpg'); ?>            
            <?php endif;?>
        </li>
        <li class="md_object_name">
        	<div class="md_object_owner">
                <?php $mdPassport = $object->retrieveMdPassport(); ?>
                
                <?php if($mdPassport): ?>
                    <div>
                        <label style="font-weight:bolder"><?php echo $mdPassport->getUsername();?></label>
                        <?php $mdUserProfile = $object->getMdUserProfile(); ?>
                        <?php if($mdUserProfile):?>
                            <span>
                                <?php echo $mdUserProfile->getName(); ?>
                                -
                                <?php echo $mdUserProfile->getLastName();?>
                            </span>
                        <?php endif;?>
                        -
                        <?php if($mdPassport->getAccountActive() == 1): ?>
                            <?php echo __('mdUserDoctrine_text_isActive') ?>
                        <?php else: ?>
                            <?php echo __('mdUserDoctrine_text_notIsActive') ?>
                        <?php endif; ?>
                    </div>
                <?php endif;?>
                <div>
                    <?php echo $object->getEmail()?> 
                </div>
        	</div>
            <div class="md_object_categories">
                <?php if(!$mdPassport): ?>
                    <span>-</span> Solo de mailing
                <?php endif;?>
            </div>
        </li>
    </ul>
</div>
