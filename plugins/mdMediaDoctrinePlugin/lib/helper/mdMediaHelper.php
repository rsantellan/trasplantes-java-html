<?php

function render_media($mdMediaConcrete, $options = array())
{
    if(is_object($mdMediaConcrete)){
        $array = array_merge(array('mediaConcrete' => $mdMediaConcrete), $options);
        echo get_partial('mdMediaContentAdmin/' . $mdMediaConcrete->getObjectClass(), $array);
    }else {
        sfContext::getInstance()->getLogger()->log('>>> render_media on non object, this is a cache problem');
    }
}