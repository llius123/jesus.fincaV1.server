-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2019 at 12:45 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `finca`
--

-- --------------------------------------------------------

--
-- Table structure for table `comunidad`
--

CREATE TABLE `comunidad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `nif` varchar(100) DEFAULT NULL,
  `iban` varchar(100) DEFAULT NULL,
  `sufijo` varchar(100) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comunidad`
--

INSERT INTO `comunidad` (`id`, `nombre`, `direccion`, `nif`, `iban`, `sufijo`, `cod_poblacion`) VALUES
(1, 'test', 'test', 'test', 'test', 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `factura_proveedor`
--

CREATE TABLE `factura_proveedor` (
  `id` int(11) NOT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `id_tipofactura` int(11) DEFAULT NULL,
  `base_imponible0` decimal(10,2) DEFAULT NULL,
  `base_imponible1` decimal(10,2) DEFAULT NULL,
  `base_imponible2` decimal(10,2) DEFAULT NULL,
  `base_imponible3` decimal(10,2) DEFAULT NULL,
  `tipo_iva1` decimal(10,2) DEFAULT NULL,
  `tipo_iva2` decimal(10,2) DEFAULT NULL,
  `tipo_iva3` decimal(10,2) DEFAULT NULL,
  `cuota_iva1` decimal(10,2) DEFAULT NULL,
  `cuota_iva2` decimal(10,2) DEFAULT NULL,
  `cuota_iva3` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `id_comunidad` int(11) DEFAULT NULL,
  `num_factura` varchar(100) DEFAULT NULL,
  `cobrado` char(1) DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `incidencia`
--

CREATE TABLE `incidencia` (
  `id` int(11) NOT NULL,
  `id_vecino` int(11) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `atendido` char(1) NOT NULL DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `incidencia`
--

INSERT INTO `incidencia` (`id`, `id_vecino`, `descripcion`, `fecha_creacion`, `atendido`) VALUES
(1, 2, 'post', '2018-12-12', 'n'),
(2, 2, 'post', '2018-12-12', 'n'),
(3, 2, 'post', '2018-12-12', 'n'),
(4, 2, 'post', '2018-12-12', 'n'),
(5, 2, 'post', '2018-12-12', '1'),
(6, 2, 'post', '1970-01-01', '1'),
(7, 2, 'post', '1970-01-01', '1'),
(8, 2, 'post', '1970-01-01', 's'),
(9, 2, 'post', '1970-01-01', 's'),
(10, 2, 'post', '1970-01-01', 's'),
(11, 2, 'post', '1973-11-26', 's'),
(12, 2, 'post', '2018-12-11', 's'),
(13, 2, 'post', '2018-12-11', 's'),
(14, 2, 'post', '2018-12-11', 's'),
(15, 2, 'post', '2018-12-12', 's'),
(16, 2, 'post', '1970-01-01', 's'),
(17, 2, '12', '1970-01-01', 's'),
(18, 2, '12', '1973-11-26', 's'),
(19, 2, 'hola', '2018-12-12', 'n');

-- --------------------------------------------------------

--
-- Table structure for table `poblacion`
--

CREATE TABLE `poblacion` (
  `cod_postal` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cod_provincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `poblacion`
--

INSERT INTO `poblacion` (`cod_postal`, `descripcion`, `cod_provincia`) VALUES
(1, 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `provincia`
--

CREATE TABLE `provincia` (
  `cod_provincia` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

INSERT INTO `provincia` (`cod_provincia`, `descripcion`) VALUES
(1, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `recibo`
--

CREATE TABLE `recibo` (
  `id` int(11) NOT NULL,
  `fecha_emision` datetime DEFAULT NULL,
  `num_registro` decimal(10,2) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `importe` int(11) DEFAULT NULL,
  `fecha_cobro` datetime DEFAULT NULL,
  `id_vecino` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `tag` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id`, `tag`) VALUES
(1, 'test'),
(2, 'segundo');

-- --------------------------------------------------------

--
-- Table structure for table `tarea`
--

CREATE TABLE `tarea` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarea`
--

INSERT INTO `tarea` (`id`, `fecha`, `descripcion`) VALUES
(1, '2019-01-16', 'test'),
(2, '2019-01-16', 'qwe');

-- --------------------------------------------------------

--
-- Table structure for table `tarea_tag`
--

CREATE TABLE `tarea_tag` (
  `id` int(11) NOT NULL,
  `id_tarea` int(11) DEFAULT '0',
  `id_tag` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarea_tag`
--

INSERT INTO `tarea_tag` (`id`, `id_tarea`, `id_tag`) VALUES
(2, 1, 2),
(3, 1, 1),
(5, 2, 2),
(6, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tipofactura`
--

CREATE TABLE `tipofactura` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipofactura`
--

INSERT INTO `tipofactura` (`id`, `descripcion`) VALUES
(1, 'web');

-- --------------------------------------------------------

--
-- Table structure for table `tipovecino`
--

CREATE TABLE `tipovecino` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipovecino`
--

INSERT INTO `tipovecino` (`id`, `descripcion`) VALUES
(1, 'admin'),
(2, 'vecino'),
(3, 'hola'),
(4, 'hola'),
(5, 'hola'),
(6, 'hola'),
(7, 'web');

-- --------------------------------------------------------

--
-- Table structure for table `vecino`
--

CREATE TABLE `vecino` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `numero` varchar(100) DEFAULT NULL,
  `nif` varchar(100) DEFAULT NULL,
  `iban` varchar(100) DEFAULT NULL,
  `num_mandato` varchar(100) DEFAULT NULL,
  `fecha_mandato` datetime DEFAULT NULL,
  `porcentaje_participacion` decimal(5,2) DEFAULT NULL,
  `id_comunidad` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `id_tipovecino` int(11) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL,
  `login` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vecino`
--

INSERT INTO `vecino` (`id`, `nombre`, `direccion`, `numero`, `nif`, `iban`, `num_mandato`, `fecha_mandato`, `porcentaje_participacion`, `id_comunidad`, `email`, `telefono`, `id_tipovecino`, `cod_poblacion`, `login`, `pass`) VALUES
(2, 'test', 'test', 'test', 'test', 'test', 'test', '2019-01-02 00:00:00', '1.00', 1, 'test', 'test', 1, 1, 'admin', 'admin'),
(3, 'qwe', 'qwe', 'qew', 'qwe', 'qwe', 'qwe', '2019-01-15 00:00:00', '1.00', 1, 'qwe', 'qwe', 2, 1, 'user', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comunidad`
--
ALTER TABLE `comunidad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comunidad_poblacion_fk` (`cod_poblacion`);

--
-- Indexes for table `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factura_proveedor_tipofactura_fk` (`id_tipofactura`),
  ADD KEY `factura_proveedor_proveedor_fk` (`id_proveedor`),
  ADD KEY `factura_proveedor_comunidad_fk` (`id_comunidad`);

--
-- Indexes for table `incidencia`
--
ALTER TABLE `incidencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `incidencia_vecino_fk` (`id_vecino`);

--
-- Indexes for table `poblacion`
--
ALTER TABLE `poblacion`
  ADD PRIMARY KEY (`cod_postal`),
  ADD KEY `poblacion_provincia_fk` (`cod_provincia`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `proveedor_poblacion_fk` (`cod_poblacion`);

--
-- Indexes for table `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`cod_provincia`);

--
-- Indexes for table `recibo`
--
ALTER TABLE `recibo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recibo_vecino_fk` (`id_vecino`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tarea_tag`
--
ALTER TABLE `tarea_tag`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_tarea_tag_tarea` (`id_tarea`),
  ADD KEY `FK_tarea_tag_tag` (`id_tag`);

--
-- Indexes for table `tipofactura`
--
ALTER TABLE `tipofactura`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipovecino`
--
ALTER TABLE `tipovecino`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vecino`
--
ALTER TABLE `vecino`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vecino_tipovecino_fk` (`id_tipovecino`),
  ADD KEY `vecino_poblacion_fk` (`cod_poblacion`),
  ADD KEY `vecino_comunidad_fk` (`id_comunidad`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comunidad`
--
ALTER TABLE `comunidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `incidencia`
--
ALTER TABLE `incidencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `recibo`
--
ALTER TABLE `recibo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tarea_tag`
--
ALTER TABLE `tarea_tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tipofactura`
--
ALTER TABLE `tipofactura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tipovecino`
--
ALTER TABLE `tipovecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `vecino`
--
ALTER TABLE `vecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comunidad`
--
ALTER TABLE `comunidad`
  ADD CONSTRAINT `comunidad_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`);

--
-- Constraints for table `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  ADD CONSTRAINT `factura_proveedor_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`),
  ADD CONSTRAINT `factura_proveedor_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`),
  ADD CONSTRAINT `factura_proveedor_tipofactura_fk` FOREIGN KEY (`id_tipofactura`) REFERENCES `tipofactura` (`id`);

--
-- Constraints for table `incidencia`
--
ALTER TABLE `incidencia`
  ADD CONSTRAINT `incidencia_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`);

--
-- Constraints for table `poblacion`
--
ALTER TABLE `poblacion`
  ADD CONSTRAINT `poblacion_provincia_fk` FOREIGN KEY (`cod_provincia`) REFERENCES `provincia` (`cod_provincia`);

--
-- Constraints for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`);

--
-- Constraints for table `recibo`
--
ALTER TABLE `recibo`
  ADD CONSTRAINT `recibo_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`);

--
-- Constraints for table `tarea_tag`
--
ALTER TABLE `tarea_tag`
  ADD CONSTRAINT `FK_tarea_tag_tag` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`),
  ADD CONSTRAINT `FK_tarea_tag_tarea` FOREIGN KEY (`id_tarea`) REFERENCES `tarea` (`id`);

--
-- Constraints for table `vecino`
--
ALTER TABLE `vecino`
  ADD CONSTRAINT `vecino_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`),
  ADD CONSTRAINT `vecino_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`),
  ADD CONSTRAINT `vecino_tipovecino_fk` FOREIGN KEY (`id_tipovecino`) REFERENCES `tipovecino` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
