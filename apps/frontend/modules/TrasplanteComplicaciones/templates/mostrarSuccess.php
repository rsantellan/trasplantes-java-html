<?php 
  $complicaciones_no_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplanteId, false, false, Doctrine_Core::HYDRATE_ARRAY);

?>