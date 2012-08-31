<?php

/**
 * reportes actions.
 *
 * @package    transplantes
 * @subpackage reportes
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class reportesActions extends sfActions
{
  
  public function preExecute()
  {
    $this->realPathFondo = sfConfig::get('sf_cache_dir')."/reportes/reporteFondo/";
    $this->realPathFondoRACMV = sfConfig::get('sf_cache_dir')."/reportes/reporteFondoPreTrasplante/";
    $this->start_year = 2000;
  }
  
 /**
  * Executes index action
  *
  * @param sfRequest $request A request object
  */
  public function executeIndex(sfWebRequest $request)
  {

    //reportesHandler::createReportePaciente(1);
  }
  
  public function executeFondo(sfWebRequest $request)
  {

  }

  public function executeFondoPreTrasplanteRACMV(sfWebRequest $request)
  {

  }
  
  public function executeCrearReporteDinamico(sfWebRequest $request)
  {
	$this->pacientes = PacienteHandler::retrieveAllPacientesNamesArray(false);
  }
  
  public function executeProcessFondoRACMV(sfWebRequest $request)
  {
    set_time_limit ( 0 );
    $year = (int)$request->getParameter('year');
    $yearFinish = (int)$request->getParameter('yearFinish');
    if($year != 0)
    {
      $this->forward404Unless($year);
    }
    $this->forward404Unless($yearFinish);
    switch($year)
    {
      case -1:
          $yearFinish = date("Y");
          $myYear = date("Y");
          reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFinish);
          while($myYear >= $this->start_year)
          {
            $yearFinish = date("Y");
            while($yearFinish >= $this->start_year)
            {
              $this->generateFondoRACMV($yearFinish, $myYear);
              $yearFinish--;
            }
            //reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFinish, $myYear);
            $myYear--;
          }
        break;
      case 0;
          $this->generateFondoRACMV($yearFinish);
          //reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFinish);
        break;
      default:
          $this->generateFondoRACMV($yearFinish, $year);
          //reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFinish, $year);
        break;
    }
    //$this->redirect("@reportesDeFondoRACMV");
    $listado = basicFunction::retrieveFilesArrayOfDirectory($this->realPathFondoRACMV);
    $body = $this->getPartial('listadoDirectorio', array("listado" => $listado));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  private function generateFondoRACMV($yearFinish, $year = null)
  {
    if(!is_null($year))
    {
      if($year < $yearFinish)
      {
        return false;
      }
    }
    reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV($yearFinish, $year);
    sleep(5);
  }

  public function executeDummy(sfWebRequest $request)
  {
    reportesHandler::CrearReporteDeFondoPreTrasplanteRACMV(2011, 2011);
    exit('termino');
  }
  
  public function executeProcessFondo(sfWebRequest $request)
  {
    set_time_limit ( 0 );
    $year = (int)$request->getParameter('year');
    if($year != 0)
    {
      $this->forward404Unless($year);
    }
    switch($year)
    {
      case -1:
          reportesHandler::CrearReporteDeFondo();
          $myYear = date("Y");
          while($myYear >= $this->start_year)
          {
            reportesHandler::CrearReporteDeFondo($myYear);
            $myYear--;
          }
        break;
      case 0;
          reportesHandler::CrearReporteDeFondo();
        break;
      default:
          reportesHandler::CrearReporteDeFondo($year);
        break;
    }
    $this->redirect("@reportesDeFondo");
    $listado = basicFunction::retrieveFilesArrayOfDirectory($this->realPathFondo);
    $body = $this->getPartial('listadoDirectorio', array("listado" => $listado));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  public function executeDownloadFile(sfWebRequest $request)
  {
    $file = $request->getParameter('file');
    $this->forward404Unless($file);
    //var_dump($file);die;
    //$file = $file_path; //"/home/rodrigo/Mastodonte/clientes/manosdeluruguay/trunk/web/uploads/images/productos/90f031093046335d65a91516f91fa3a0.jpg";
    $path_info = pathinfo($file);
    $ctype = "";
    switch ($path_info['extension']) 
    {
      case "pdf":
        $ctype = "application/pdf";
        break;
      case "exe":
        $ctype = "application/octet-stream";
        break;
      case "zip":
        $ctype = "application/zip";
        break;
      case "doc":
        $ctype = "application/msword";
        break;
      case "xls":
        $ctype = "application/vnd.ms-excel";
        break;
      case "ppt":
        $ctype = "application/vnd.ms-powerpoint";
        break;
      case "gif":
        $ctype = "image/gif";
        break;
      case "png":
        $ctype = "image/png";
        break;
      case "jpeg":
      case "jpg":
        $ctype = "image/jpg";
        break;
      default:
        $ctype = "application/force-download";
        break;
    }
    header("Pragma: public"); // required
    header("Expires: 0");
    header("Cache-Control: must-revalidate, post-check=0, pre-check=0");
    header("Cache-Control: private", false); // required for certain browsers
    header("Content-Type: $ctype");
    // change, added quotes to allow spaces in filenames, by Rajkumar Singh
    header("Content-Disposition: attachment; filename=\"" . $path_info['basename'] . "\";");
    header("Content-Transfer-Encoding: binary");
    header("Content-Length: " . filesize($file));
    readfile($file);
    exit(0);
  }
}
