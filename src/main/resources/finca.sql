-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-12-2018 a las 19:44:24
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `finca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comunidad`
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_proveedor`
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
  `total` double DEFAULT NULL,
  `id_comunidad` int(11) DEFAULT NULL,
  `num_factura` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencia`
--

CREATE TABLE `incidencia` (
  `id` int(11) NOT NULL,
  `id_vecino` int(11) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacion`
--

CREATE TABLE `poblacion` (
  `cod_postal` int(11) NOT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `cod_provincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `poblacion` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `cod_provincia` int(11) NOT NULL,
  `desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo`
--

CREATE TABLE `recibo` (
  `id` int(11) NOT NULL,
  `fecha_emision` datetime DEFAULT NULL,
  `num_registro` int(11) DEFAULT NULL,
  `id_vecino` int(11) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `importe` int(11) DEFAULT NULL,
  `fecha_cobro` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipofactura`
--

CREATE TABLE `tipofactura` (
  `id` int(11) NOT NULL,
  `desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipovecino`
--

CREATE TABLE `tipovecino` (
  `id` int(11) NOT NULL,
  `desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vecino`
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
  `porcentaje_participacion` int(11) DEFAULT NULL,
  `id_comunidad` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `id_tipovecino` int(11) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comunidad`
--
ALTER TABLE `comunidad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comunidad_poblacion_fk` (`cod_poblacion`);

--
-- Indices de la tabla `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factura_proveedor_tipofactura_fk` (`id_tipofactura`),
  ADD KEY `factura_proveedor_proveedor_fk` (`id_proveedor`),
  ADD KEY `factura_proveedor_comunidad_fk` (`id_comunidad`);

--
-- Indices de la tabla `incidencia`
--
ALTER TABLE `incidencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `incidencia_vecino_fk` (`id_vecino`);

--
-- Indices de la tabla `poblacion`
--
ALTER TABLE `poblacion`
  ADD PRIMARY KEY (`cod_postal`),
  ADD KEY `poblacion_provincia_fk` (`cod_provincia`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `proveedor_poblacion_fk` (`cod_poblacion`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`cod_provincia`);

--
-- Indices de la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recibo_vecino_fk` (`id_vecino`);

--
-- Indices de la tabla `tipofactura`
--
ALTER TABLE `tipofactura`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipovecino`
--
ALTER TABLE `tipovecino`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vecino`
--
ALTER TABLE `vecino`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vecino_tipovecino_fk` (`id_tipovecino`),
  ADD KEY `vecino_poblacion_fk` (`cod_poblacion`),
  ADD KEY `vecino_comunidad_fk` (`id_comunidad`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comunidad`
--
ALTER TABLE `comunidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recibo`
--
ALTER TABLE `recibo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipofactura`
--
ALTER TABLE `tipofactura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipovecino`
--
ALTER TABLE `tipovecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vecino`
--
ALTER TABLE `vecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comunidad`
--
ALTER TABLE `comunidad`
  ADD CONSTRAINT `comunidad_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`);

--
-- Filtros para la tabla `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  ADD CONSTRAINT `factura_proveedor_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`),
  ADD CONSTRAINT `factura_proveedor_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`),
  ADD CONSTRAINT `factura_proveedor_tipofactura_fk` FOREIGN KEY (`id_tipofactura`) REFERENCES `tipofactura` (`id`);

--
-- Filtros para la tabla `incidencia`
--
ALTER TABLE `incidencia`
  ADD CONSTRAINT `incidencia_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`);

--
-- Filtros para la tabla `poblacion`
--
ALTER TABLE `poblacion`
  ADD CONSTRAINT `poblacion_provincia_fk` FOREIGN KEY (`cod_provincia`) REFERENCES `provincia` (`cod_provincia`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`);

--
-- Filtros para la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD CONSTRAINT `recibo_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`);

--
-- Filtros para la tabla `vecino`
--
ALTER TABLE `vecino`
  ADD CONSTRAINT `vecino_comunidad_fk` FOREIGN KEY (`id_comunidad`) REFERENCES `comunidad` (`id`),
  ADD CONSTRAINT `vecino_poblacion_fk` FOREIGN KEY (`cod_poblacion`) REFERENCES `poblacion` (`cod_postal`),
  ADD CONSTRAINT `vecino_tipovecino_fk` FOREIGN KEY (`id_tipovecino`) REFERENCES `tipovecino` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
