<?php

function format_text($text)
{
  if(preg_match('/^<p/', $text))
  {
    return $text;
  }
  else
  {
    return '<p>'.$text.'</p>';
  }
}
