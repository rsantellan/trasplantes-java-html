-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 05, 2011 at 12:36 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `trasplante`
--

-- --------------------------------------------------------

--
-- Table structure for table `cmv`
--

CREATE TABLE IF NOT EXISTS `cmv` (
  `Trasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL,
  `Diagnostico` smallint(6) DEFAULT NULL,
  `TM` tinyint(1) DEFAULT NULL,
  `SindromeViral` tinyint(1) DEFAULT NULL,
  `Profilaxis` tinyint(1) DEFAULT NULL,
  `Droga` smallint(6) DEFAULT NULL,
  `diasTm` smallint(6) DEFAULT NULL,
  `EfectoSecundario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Trasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cmvdiagnostico`
--

CREATE TABLE IF NOT EXISTS `cmvdiagnostico` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `cmvdrogas`
--

CREATE TABLE IF NOT EXISTS `cmvdrogas` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `cmvemfermedades`
--

CREATE TABLE IF NOT EXISTS `cmvemfermedades` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `cmv_uso_enfermedades`
--

CREATE TABLE IF NOT EXISTS `cmv_uso_enfermedades` (
  `Trasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL,
  `cmvenfermedades` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Trasplante`,`FECHA`,`cmvenfermedades`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complicaciones_inf`
--

CREATE TABLE IF NOT EXISTS `complicaciones_inf` (
  `ID_TR_COMPLICACION` int(11) NOT NULL DEFAULT '0',
  `INFECCION` smallint(6) NOT NULL,
  `GERMEN` smallint(6) NOT NULL,
  PRIMARY KEY (`ID_TR_COMPLICACION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complicaciones_no_inf`
--

CREATE TABLE IF NOT EXISTS `complicaciones_no_inf` (
  `ID_TR_COMPLICACION` int(11) NOT NULL DEFAULT '0',
  `ID_COMPLICACION` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID_TR_COMPLICACION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complicaciones_tipos`
--

CREATE TABLE IF NOT EXISTS `complicaciones_tipos` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(50) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=92 ;

-- --------------------------------------------------------

--
-- Table structure for table `consultas`
--

CREATE TABLE IF NOT EXISTS `consultas` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Sentencia` varchar(10000) NOT NULL,
  `Tipos` varchar(10000) NOT NULL,
  `Nombres` varchar(10000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `datosutiles`
--

CREATE TABLE IF NOT EXISTS `datosutiles` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL DEFAULT 'pass',
  `Fecha` datetime NOT NULL,
  `Root` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `donante`
--

CREATE TABLE IF NOT EXISTS `donante` (
  `ID` varchar(20) NOT NULL,
  `TIPO_DONANTE` varchar(10) NOT NULL,
  `SEXO_DONANTE` char(1) DEFAULT NULL,
  `EDAD_DONANTE` tinyint(3) unsigned DEFAULT NULL,
  `ENASTAB_HEMOD` tinyint(1) DEFAULT NULL,
  `CAUSA_MUERTE_DONANTE` mediumint(9) DEFAULT NULL,
  `CR_P` float DEFAULT NULL,
  `OTROS` varchar(255) DEFAULT NULL,
  `GRUPO_SANG` char(2) DEFAULT NULL,
  `RELACION_FILIAR` varchar(11) DEFAULT NULL,
  `PESO` int(11) DEFAULT NULL,
  `ALTURA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donanterefantecedentes`
--

CREATE TABLE IF NOT EXISTS `donanterefantecedentes` (
  `ID_DONANTE` varchar(20) NOT NULL,
  `ID_ANTECEDENTE` mediumint(9) NOT NULL,
  PRIMARY KEY (`ID_DONANTE`,`ID_ANTECEDENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donante_antecedentes`
--

CREATE TABLE IF NOT EXISTS `donante_antecedentes` (
  `ID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `DETALLES` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Table structure for table `donante_causa_muerte`
--

CREATE TABLE IF NOT EXISTS `donante_causa_muerte` (
  `ID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `DETALLES` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

-- --------------------------------------------------------

--
-- Table structure for table `donante_organos`
--

CREATE TABLE IF NOT EXISTS `donante_organos` (
  `ID_DONANTE` varchar(20) NOT NULL,
  `ORGANO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donante_serol`
--

CREATE TABLE IF NOT EXISTS `donante_serol` (
  `id_donante` varchar(20) NOT NULL,
  `id_serol` smallint(6) NOT NULL,
  `valor` varchar(50) NOT NULL,
  PRIMARY KEY (`id_donante`,`id_serol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `PAS` float DEFAULT NULL,
  `PAD` float DEFAULT NULL,
  `DIURESIS` float DEFAULT NULL,
  `PESO` float DEFAULT NULL,
  `UREA` float DEFAULT NULL,
  `CREATININA` float DEFAULT NULL,
  `HT` float DEFAULT NULL,
  `HB` float DEFAULT NULL,
  `GB` float DEFAULT NULL,
  `PLAQUETAS` float DEFAULT NULL,
  `SODIO` float DEFAULT NULL,
  `POTASIO` float DEFAULT NULL,
  `CLORO` float DEFAULT NULL,
  `CALCIO` float DEFAULT NULL,
  `FOSFORO` float DEFAULT NULL,
  `GLICEMIA` float DEFAULT NULL,
  `URICEMIA` float DEFAULT NULL,
  `PROT_U` float DEFAULT NULL,
  `CCREATININA` float DEFAULT NULL,
  `CUREA` float DEFAULT NULL,
  `NA_U` float DEFAULT NULL,
  `K_U` float DEFAULT NULL,
  `CyA_PV` float DEFAULT NULL,
  `CyA_PP` float DEFAULT NULL,
  `FK_P` float DEFAULT NULL,
  `MFM_P` float DEFAULT NULL,
  `EVE_P` float DEFAULT NULL,
  `BD` float DEFAULT NULL,
  `BI` float DEFAULT NULL,
  `TGO` float DEFAULT NULL,
  `TGP` float DEFAULT NULL,
  `GAMMAGT` float DEFAULT NULL,
  `F_ALC` float DEFAULT NULL,
  `T_PROT` float DEFAULT NULL,
  `KPTT` float DEFAULT NULL,
  `HOWELL` float DEFAULT NULL,
  `FIBRINOGENO` float DEFAULT NULL,
  `COLESTEROL` float DEFAULT NULL,
  `HDL` float DEFAULT NULL,
  `LDL` float DEFAULT NULL,
  `R_AT` float DEFAULT NULL,
  `TG` float DEFAULT NULL,
  `HNA1C` float DEFAULT NULL,
  `ALBUMINA` float DEFAULT NULL,
  `GLOBULINAS` float DEFAULT NULL,
  `PTHi` varchar(10) DEFAULT NULL,
  `OTROS` varchar(255) DEFAULT NULL,
  `NUMPTHi` float DEFAULT NULL,
  PRIMARY KEY (`FECHA`,`IdTrasplante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplanteexamenes`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplanteexamenes` (
  `IdTrasplante` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `Tipo` varchar(255) NOT NULL,
  `Normal` tinyint(1) NOT NULL,
  `Comentario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`Fecha`,`Tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_cmv`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_cmv` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `IgG_CMV` tinyint(1) DEFAULT NULL,
  `IgM_CMV` tinyint(1) DEFAULT NULL,
  `PCR_CMV` tinyint(1) DEFAULT NULL,
  `Ag_pp65` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_ecg`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_ecg` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `RS_ECG` varchar(8) DEFAULT NULL,
  `HVI_ECG` varchar(8) DEFAULT NULL,
  `Onda_Q_ECG` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_ecodopler`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_ecodopler` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `ESTRUCTURA` varchar(20) DEFAULT NULL,
  `DILATACION` tinyint(1) DEFAULT NULL,
  `COLECCIONES` tinyint(1) DEFAULT NULL,
  `EJE_ARTERIAL` varchar(20) DEFAULT NULL,
  `EJE_VENOSO` varchar(20) DEFAULT NULL,
  `ARTERIA_RENAL` varchar(20) DEFAULT NULL,
  `VENA_RENAL` varchar(20) DEFAULT NULL,
  `ANAST_VENOSA` varchar(20) DEFAULT NULL,
  `ANAST_RENOSA` varchar(20) DEFAULT NULL,
  `INDICE` double DEFAULT NULL,
  `OTROS` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_ecografia`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_ecografia` (
  `IdTrasplante` int(11) unsigned NOT NULL,
  `Fecha` date NOT NULL DEFAULT '0000-00-00',
  `Diametros` varchar(45) NOT NULL,
  `Dilatacion` tinyint(1) NOT NULL,
  `Litiasin` tinyint(1) NOT NULL,
  `Vejiga` varchar(255) NOT NULL DEFAULT '',
  `Espesor` int(11) unsigned NOT NULL,
  `OTROS` varchar(1000) DEFAULT ' ',
  PRIMARY KEY (`IdTrasplante`,`Fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_eco_cardio`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_eco_cardio` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `FEVI_NORMAL` tinyint(1) DEFAULT NULL,
  `Insuf_Hipodiast` tinyint(1) DEFAULT NULL,
  `I_Ao` tinyint(1) DEFAULT NULL,
  `E_Ao` tinyint(1) DEFAULT NULL,
  `I_M` tinyint(1) DEFAULT NULL,
  `E_M` tinyint(1) DEFAULT NULL,
  `I_P` tinyint(1) DEFAULT NULL,
  `E_P` tinyint(1) DEFAULT NULL,
  `I_T` tinyint(1) DEFAULT NULL,
  `E_T` tinyint(1) DEFAULT NULL,
  `Derrame` tinyint(1) DEFAULT NULL,
  `Calcif_valvular` tinyint(1) DEFAULT NULL,
  `HVI` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_marvirales`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_marvirales` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `HSV` tinyint(1) DEFAULT NULL,
  `AGHBS` varchar(13) DEFAULT NULL,
  `HBSAC` varchar(13) DEFAULT NULL,
  `HBCAC` varchar(13) DEFAULT NULL,
  `HVC` varchar(13) DEFAULT NULL,
  `HIV` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_nutricion`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_nutricion` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `TALLA` smallint(5) unsigned DEFAULT NULL,
  `PESO_DESEADO` tinyint(3) unsigned DEFAULT NULL,
  `ESTRUCTURA_OSEA` varchar(8) DEFAULT NULL,
  `IMPRESION` varchar(11) DEFAULT NULL,
  `PESO_REAL` tinyint(3) unsigned DEFAULT NULL,
  `P_TRICIPITAL` int(11) DEFAULT NULL,
  `P_TRICIPITAL_P` varchar(6) DEFAULT NULL,
  `P_SUBESCAPULAR` int(11) DEFAULT NULL,
  `P_SUBESCAPULAR_P` varchar(6) DEFAULT NULL,
  `SUM_PLIEGUES` int(11) DEFAULT NULL,
  `P_SUM_PLIEGUES` varchar(6) DEFAULT NULL,
  `CF_BRAZO` smallint(6) DEFAULT NULL,
  `P_CF_BRAZO` varchar(6) DEFAULT NULL,
  `CF_MUSC_BRAZO` smallint(6) DEFAULT NULL,
  `P_CF_MUSC_BRAZO` varchar(6) DEFAULT NULL,
  `AREA_BRAZO` smallint(6) DEFAULT NULL,
  `AREA_MUSC_BRAZO` smallint(6) DEFAULT NULL,
  `P_AREA_MUSC_BRAZO` varchar(6) DEFAULT NULL,
  `AREA_GRASA_BRAZO` smallint(6) DEFAULT NULL,
  `P_AREA_GRASA_BRAZO` varchar(6) DEFAULT NULL,
  `R_CINTURA_CADERA` smallint(6) DEFAULT NULL,
  `DIAG_NUTRICIONAL` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evolucion_trasplante_txtorax`
--

CREATE TABLE IF NOT EXISTS `evolucion_trasplante_txtorax` (
  `IdTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL DEFAULT '0000-00-00',
  `RCT` int(11) DEFAULT NULL,
  `FOCO` tinyint(1) DEFAULT NULL,
  `LATERALIZADO` varchar(9) DEFAULT NULL,
  `DERRAME_PLEURAL` tinyint(1) DEFAULT NULL,
  `LATERAL_DERRAME` varchar(9) DEFAULT NULL,
  `SECUELAS` tinyint(1) DEFAULT NULL,
  `OTROS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fecha_control`
--

CREATE TABLE IF NOT EXISTS `fecha_control` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `FECHA` varchar(50) DEFAULT NULL,
  `ANOS` smallint(6) DEFAULT NULL,
  `MESES` smallint(6) DEFAULT NULL,
  `DIAS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

-- --------------------------------------------------------

--
-- Table structure for table `germenes`
--

CREATE TABLE IF NOT EXISTS `germenes` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

-- --------------------------------------------------------

--
-- Table structure for table `induccion`
--

CREATE TABLE IF NOT EXISTS `induccion` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Table structure for table `infeccion`
--

CREATE TABLE IF NOT EXISTS `infeccion` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

-- --------------------------------------------------------

--
-- Table structure for table `injerto_evolucion`
--

CREATE TABLE IF NOT EXISTS `injerto_evolucion` (
  `PreTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL,
  `TM` tinyint(1) DEFAULT NULL,
  `TM_CUAL` varchar(255) DEFAULT NULL,
  `GP_DE_NOVO` tinyint(1) DEFAULT NULL,
  `Recidiva_GP_DE_NOVO` tinyint(1) DEFAULT NULL,
  `RA` tinyint(1) DEFAULT NULL,
  `RC` tinyint(1) DEFAULT NULL,
  `tratamiento` int(6) DEFAULT NULL,
  `trasplante` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`PreTrasplante`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `injerto_evolucion_pbr`
--

CREATE TABLE IF NOT EXISTS `injerto_evolucion_pbr` (
  `PreTrasplante` int(11) NOT NULL DEFAULT '0',
  `FECHA` date NOT NULL,
  `RESULTADO_PBR` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PreTrasplante`,`FECHA`,`RESULTADO_PBR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inmunosupresores`
--

CREATE TABLE IF NOT EXISTS `inmunosupresores` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `medicaciones`
--

CREATE TABLE IF NOT EXISTS `medicaciones` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=84 ;

-- --------------------------------------------------------

--
-- Table structure for table `nefropatia`
--

CREATE TABLE IF NOT EXISTS `nefropatia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NEFROPATIA` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

-- --------------------------------------------------------

--
-- Table structure for table `pacientepretrasplante`
--

CREATE TABLE IF NOT EXISTS `pacientepretrasplante` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `THE` int(11) NOT NULL,
  `FECHA_INGRESO_LISTA` date DEFAULT NULL,
  `FECHA_EGRESO` date DEFAULT NULL,
  `MODALIDAD_D` char(10) DEFAULT NULL,
  `PBR` tinyint(1) DEFAULT NULL,
  `DIABETES` char(7) DEFAULT NULL,
  `HTA` tinyint(1) DEFAULT NULL,
  `OBESIDAD` tinyint(1) DEFAULT NULL,
  `IMC` varchar(13) DEFAULT NULL,
  `DISLIPEMIA` tinyint(1) DEFAULT NULL,
  `TABAQUISMO` tinyint(1) DEFAULT NULL,
  `ORIGEN` varchar(4) DEFAULT NULL,
  `IAM` tinyint(1) NOT NULL DEFAULT '0',
  `AVE` tinyint(1) NOT NULL DEFAULT '0',
  `REVASC_CARDIO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=152 ;

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
  `THE` int(11) NOT NULL AUTO_INCREMENT,
  `CI` char(12) NOT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `NUM_FNR` mediumint(9) DEFAULT NULL,
  `RAZA` char(15) DEFAULT NULL,
  `SEXO` char(1) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `FECHA_DIALISIS` date DEFAULT NULL,
  `NEFROPATIA` smallint(6) DEFAULT NULL,
  `GRUPO_SANG` char(2) DEFAULT NULL,
  PRIMARY KEY (`THE`),
  UNIQUE KEY `CI` (`CI`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=152 ;

-- --------------------------------------------------------

--
-- Table structure for table `paciente_causa_muerte`
--

CREATE TABLE IF NOT EXISTS `paciente_causa_muerte` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `DETALLES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Table structure for table `paciente_causa_perdida_injerto`
--

CREATE TABLE IF NOT EXISTS `paciente_causa_perdida_injerto` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `DETALLES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Table structure for table `paciente_muerte`
--

CREATE TABLE IF NOT EXISTS `paciente_muerte` (
  `THE` int(11) NOT NULL DEFAULT '0',
  `CAUSA` smallint(6) NOT NULL,
  `FECHA_MUERTE` date NOT NULL,
  `TR_Funcionando` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`THE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `paciente_perdida_injerto`
--

CREATE TABLE IF NOT EXISTS `paciente_perdida_injerto` (
  `THE` int(11) NOT NULL DEFAULT '0',
  `CAUSA` smallint(6) DEFAULT NULL,
  `FECHA_PERDIDA` date NOT NULL DEFAULT '1900-01-01',
  `ID_PRETRASPLANTE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`THE`,`FECHA_PERDIDA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ratratamiento`
--

CREATE TABLE IF NOT EXISTS `ratratamiento` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Table structure for table `resultado_pbr`
--

CREATE TABLE IF NOT EXISTS `resultado_pbr` (
  `ID` smallint(6) NOT NULL AUTO_INCREMENT,
  `GRADO` varchar(100) DEFAULT NULL,
  `CRITERIO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

-- --------------------------------------------------------

--
-- Table structure for table `serol`
--

CREATE TABLE IF NOT EXISTS `serol` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `serol_valor`
--

CREATE TABLE IF NOT EXISTS `serol_valor` (
  `id` smallint(6) unsigned DEFAULT NULL,
  `valor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante`
--

CREATE TABLE IF NOT EXISTS `trasplante` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `PreTrasplante` int(11) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `NUM_TR` int(11) DEFAULT NULL,
  `ID_DONANTE` varchar(20) DEFAULT NULL,
  `INESTAB_HEMOD` tinyint(1) DEFAULT NULL,
  `RINHON` varchar(10) DEFAULT NULL,
  `ANOMALIA_VASC` tinyint(1) DEFAULT NULL,
  `NUM_ART` tinyint(1) DEFAULT NULL,
  `NUM_VENAS` tinyint(1) DEFAULT NULL,
  `URETER` varchar(5) DEFAULT NULL,
  `NUM_COMP_A_B` mediumint(9) DEFAULT NULL,
  `NUM_COMP_DR` mediumint(9) DEFAULT NULL,
  `NUM_IMCOMP_A_B` mediumint(9) DEFAULT NULL,
  `NUM_IMCOMP_DR` mediumint(9) DEFAULT NULL,
  `AUTOAC` tinyint(1) DEFAULT NULL,
  `PRA_MAX` varchar(10) DEFAULT NULL,
  `PRA_TR` varchar(20) DEFAULT NULL,
  `TRANS_PREVIAS` tinyint(1) DEFAULT NULL,
  `NUM_TRANSF` tinyint(4) DEFAULT NULL,
  `EMBARAZO` varchar(9) DEFAULT NULL,
  `NUM_EMBARAZO` tinyint(4) DEFAULT NULL,
  `LIQ_PERFUSION` varchar(11) DEFAULT NULL,
  `TQ_DE_BANCO` tinyint(1) DEFAULT NULL,
  `LADO_IMPLANTE` varchar(10) DEFAULT NULL,
  `ANAST_VENOSA` varchar(17) DEFAULT NULL,
  `ANAST_ARTERIAL` varchar(17) DEFAULT NULL,
  `ANAST_URETERAL` varchar(9) DEFAULT NULL,
  `T_ISQ_CAL_MIN` mediumint(9) DEFAULT NULL,
  `T_ISQ_FRIA_HS` mediumint(9) DEFAULT NULL,
  `T_ISQ_FRIA_MIN` mediumint(9) DEFAULT NULL,
  `T_ISQ_TIBIA_HS` mediumint(9) DEFAULT NULL,
  `REPERCUSION` varchar(7) DEFAULT NULL,
  `SANGRADO_I_OP` tinyint(1) DEFAULT NULL,
  `LESION_ARTERIAL` tinyint(1) DEFAULT NULL,
  `LESION_VENOSA` tinyint(1) DEFAULT NULL,
  `NECESIDAD_REPEFUNDIR` tinyint(1) DEFAULT NULL,
  `OTRAS_COMPL_QUIRUR` varchar(250) DEFAULT NULL,
  `DIURESIS_I_OP` tinyint(1) DEFAULT NULL,
  `CR_INICIAL` float DEFAULT NULL,
  `DIA_REC_DIURESIS` smallint(6) DEFAULT NULL,
  `DIA_REC_FUNCIONAL` smallint(6) DEFAULT NULL,
  `DIALISIS` tinyint(1) DEFAULT NULL,
  `NUM_DE_HD` smallint(6) DEFAULT NULL,
  `COMENTARIO` varchar(255) DEFAULT NULL,
  `FECHA_ALTA` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=154 ;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante_complicaciones`
--

CREATE TABLE IF NOT EXISTS `trasplante_complicaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IdPreTrasplante` int(11) NOT NULL DEFAULT '-1',
  `FECHA` date NOT NULL,
  `MEDICACION` smallint(6) NOT NULL,
  `INTERNADO` tinyint(1) NOT NULL,
  `DIAS_DE_INTERNACION` smallint(6) DEFAULT NULL,
  `EVOLUCION` tinyint(1) NOT NULL,
  `COMENTARIO` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=832 ;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante_induccion`
--

CREATE TABLE IF NOT EXISTS `trasplante_induccion` (
  `id_trasplante` mediumint(9) NOT NULL,
  `id_induccion` smallint(6) NOT NULL,
  `valor` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_trasplante`,`id_induccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante_inmunosupresores`
--

CREATE TABLE IF NOT EXISTS `trasplante_inmunosupresores` (
  `id_trasplante` mediumint(9) NOT NULL,
  `id_inmunosupresores` smallint(6) NOT NULL,
  `valor` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_trasplante`,`id_inmunosupresores`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante_reoperacion`
--

CREATE TABLE IF NOT EXISTS `trasplante_reoperacion` (
  `id_trasplante` mediumint(9) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `complicacion` mediumint(9) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_trasplante`,`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trasplante_serol`
--

CREATE TABLE IF NOT EXISTS `trasplante_serol` (
  `id_trasplante` mediumint(9) NOT NULL,
  `id_serol` smallint(6) NOT NULL,
  `valor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_trasplante`,`id_serol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tratamiento`
--

CREATE TABLE IF NOT EXISTS `tratamiento` (
  `THE` int(11) NOT NULL,
  `MEDICACION` smallint(6) NOT NULL,
  `DOSIS` varchar(50) DEFAULT NULL,
  `FECHA_INICIO` date NOT NULL DEFAULT '0000-00-00',
  `FECHA_FIN` date DEFAULT NULL,
  PRIMARY KEY (`THE`,`MEDICACION`,`FECHA_INICIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
