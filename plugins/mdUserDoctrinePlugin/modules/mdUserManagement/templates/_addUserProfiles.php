<?php if(count($mdProfiles) != 0): ?>
<form id="show_new_form_profile" action="<?php echo url_for('mdUserManagement/showSmallUserProfileAjax'); ?>" method="post" onsubmit="return showSmallProfile();" >

    <span><?php echo __('mdUserDoctrine_text_selectProfile');?></span>
    <div class="clear"></div>
        <?php use_helper( 'JavascriptBase' );?>
        <?php echo javascript_tag("showProfile();"); ?>
    


    <div id="list_profiles_<?php echo $mdUserId; ?>">
        <?php include_partial('listUserProfiles', array('mdProfiles' => $mdProfiles)); ?>
    </div>
    <input type="hidden" value="<?php echo $mdUserId?>" name="mdUserId" id ="mdUserId"/>
    <div id="profile_form_"></div>
    <input type="button" value="<?php echo __('mdUserDoctrine_text_cancelProfile') ?>"  onclick="mdUserManagement.getInstance().cancelProfile(<?php echo $mdUserId; ?>)" />
</form>
<?php else: ?>
    <?php echo __('mdUserDoctrine_text_noNewProfile'); ?>
<?php endif; ?>
