-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2019 at 11:28 AM
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
(1, 'Comunidad Serreria', 'Jeronimo de monsoriu', '0123456A', 'ES7620770024003102575766', '123456789', 1);

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

--
-- Dumping data for table `factura_proveedor`
--

INSERT INTO `factura_proveedor` (`id`, `fecha_registro`, `id_proveedor`, `id_tipofactura`, `base_imponible0`, `base_imponible1`, `base_imponible2`, `base_imponible3`, `tipo_iva1`, `tipo_iva2`, `tipo_iva3`, `cuota_iva1`, `cuota_iva2`, `cuota_iva3`, `total`, `id_comunidad`, `num_factura`, `cobrado`) VALUES
(1, '2019-02-01 00:00:00', 1, 1, '0.00', '1.00', '2.00', '3.00', '1.00', '2.00', '3.00', '1.00', '2.00', '3.00', '12.00', 1, 'ACDB', 's'),
(2, '2019-01-31 00:00:00', 2, 3, '1.00', '2.00', '3.00', '4.00', '1.00', '2.00', '3.00', '1.00', '2.00', '3.00', '12.00', 1, '12', 's');

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
(1, 2, 'Bombilla del piso 3 apagada', '2018-12-12', 's'),
(2, 2, 'Telefonillo arreglar', '2018-12-13', 'n'),
(3, 40, 'Agua de la piscina de color verde', '2018-12-13', 'n'),
(4, 38, 'El ascensor hace ruidos raros', '2018-12-13', 'n');

-- --------------------------------------------------------

--
-- Table structure for table `poblacion`
--

CREATE TABLE `poblacion` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cod_provincia` int(11) DEFAULT NULL,
  `cod_postal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `poblacion`
--

INSERT INTO `poblacion` (`id`, `descripcion`, `cod_provincia`, `cod_postal`) VALUES
(1, 'Valencia', 1, 46000),
(2, 'Castellon', 1, 12000),
(4, 'Alicante', 1, 3000);

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

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id`, `direccion`, `telefono`, `email`, `cod_poblacion`) VALUES
(1, 'Avenida alameda 32', '123456789', 'pepito@gmail.com', 1),
(2, 'Avenida Castellon 12', '987654321', 'juanito@gmail.com', 2),
(4, 'Plaza ayuntamiento', '9786754564', 'pisinasSL@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `provincia`
--

CREATE TABLE `provincia` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cod_provincia` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

INSERT INTO `provincia` (`id`, `descripcion`, `cod_provincia`) VALUES
(1, 'Comunidad Valenciana', '1');

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
(6, '2019-01-17', 'Llamar al electricista'),
(8, '2019-01-22', 'Añadir al servidor la factura de agua de este mes'),
(15, '2019-02-06', 'Revision de la piscina mañana a las 11:00'),
(17, '2019-02-07', 'Revision ascensor');

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
(1, 'Agua'),
(3, 'Gas'),
(5, 'Luz'),
(6, 'Ascensor'),
(7, 'Piscina'),
(8, 'Jardin');

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
(1, 'Administrador'),
(2, 'Usuario');

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
  `porcentaje_participacion` decimal(5,2) DEFAULT NULL,
  `id_comunidad` int(11) DEFAULT NULL,
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

INSERT INTO `vecino` (`id`, `nombre`, `direccion`, `numero`, `nif`, `iban`, `porcentaje_participacion`, `id_comunidad`, `email`, `telefono`, `id_tipovecino`, `cod_poblacion`, `login`, `pass`) VALUES
(2, 'Jesus Berisa Nuñez', 'Jeronimo monsoriu', '999', '1234567A', '123456789', '10.00', 1, 'jesus@gmail.com', '123456789', 1, 1, 'admin', 'admin'),
(38, 'Pepito Perez', 'Jeronimo monsoriu', '999', '1234567A', '123456789', '10.00', 1, 'juanita@gmail.com', '321', 2, 1, 'vecino', 'vecino'),
(40, 'Juanita Pepita', 'Plaza ayuntamiento', '12', '3213123123', '123456789', '1.00', 1, 'juanita@gmail.com', '321', 2, 1, 'vecino2', 'vecino2');

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
  ADD PRIMARY KEY (`id`),
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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `incidencia`
--
ALTER TABLE `incidencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `poblacion`
--
ALTER TABLE `poblacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tipofactura`
--
ALTER TABLE `tipofactura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tipovecino`
--
ALTER TABLE `tipovecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vecino`
--
ALTER TABLE `vecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comunidad`
--
ALTER TABLE `comunidad`
  ADD CONSTRAINT `comunidad_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  ADD CONSTRAINT `factura_proveedor_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_proveedor_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_proveedor_tipofactura_fk` FOREIGN KEY (`id_tipofactura`) REFERENCES `tipofactura` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `incidencia`
--
ALTER TABLE `incidencia`
  ADD CONSTRAINT `incidencia_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `poblacion`
--
ALTER TABLE `poblacion`
  ADD CONSTRAINT `poblacion_provincia_fk` FOREIGN KEY (`cod_provincia`) REFERENCES `provincia` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `vecino`
--
ALTER TABLE `vecino`
  ADD CONSTRAINT `vecino_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `vecino_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `vecino_tipovecino_fk` FOREIGN KEY (`id_tipovecino`) REFERENCES `tipovecino` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
