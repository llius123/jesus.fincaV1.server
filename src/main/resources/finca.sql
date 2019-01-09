-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 09-01-2019 a las 01:35:42
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.1.24

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

--
-- Volcado de datos para la tabla `comunidad`
--

INSERT INTO `comunidad` (`id`, `nombre`, `direccion`, `nif`, `iban`, `sufijo`, `cod_poblacion`) VALUES
(1, 'test_comunidad', 'test_comunidad', 'test_comunidad', 'test_comunidad', 'test_comunidad', 1);

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
  `total` decimal(10,2) DEFAULT NULL,
  `id_comunidad` int(11) DEFAULT NULL,
  `num_factura` varchar(100) DEFAULT NULL,
  `cobrado` char(1) DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura_proveedor`
--

INSERT INTO `factura_proveedor` (`id`, `fecha_registro`, `id_proveedor`, `id_tipofactura`, `base_imponible0`, `base_imponible1`, `base_imponible2`, `base_imponible3`, `tipo_iva1`, `tipo_iva2`, `tipo_iva3`, `cuota_iva1`, `cuota_iva2`, `cuota_iva3`, `total`, `id_comunidad`, `num_factura`, `cobrado`) VALUES
(1, '2018-12-20 00:00:00', 1, 1, '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', 1, '12', 'n'),
(2, '2018-12-20 00:00:00', 1, 1, '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', '12.00', 1, '12', 'n');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencia`
--

CREATE TABLE `incidencia` (
  `id` int(11) NOT NULL,
  `id_vecino` int(11) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `atendido` char(1) NOT NULL DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `incidencia`
--

INSERT INTO `incidencia` (`id`, `id_vecino`, `descripcion`, `fecha_creacion`, `atendido`) VALUES
(1, 1, 'post', NULL, 'n'),
(10, 1, 'wqe', '2019-01-02', 'n'),
(12, 1, NULL, '2018-12-12', 's'),
(14, 1, NULL, '2018-12-12', 's'),
(15, 1, NULL, '2018-12-12', 's'),
(16, 1, 'test', '2018-12-12', 's');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacion`
--

CREATE TABLE `poblacion` (
  `cod_postal` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cod_provincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `poblacion`
--

INSERT INTO `poblacion` (`cod_postal`, `descripcion`, `cod_provincia`) VALUES
(0, 'test_poblacion', 1),
(1, 'test_poblacion', 1),
(3, 'test', 1),
(4, 'test', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cod_poblacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `direccion`, `telefono`, `email`, `cod_poblacion`) VALUES
(1, 'test', 'test', 'test', 1),
(2, '2', '2', '2', 1),
(3, '2', '2', '2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `cod_provincia` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`cod_provincia`, `descripcion`) VALUES
(1, 'test_provincia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo`
--

CREATE TABLE `recibo` (
  `id` int(11) NOT NULL,
  `fecha_emision` datetime DEFAULT NULL,
  `num_registro` decimal(10,2) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `importe` int(11) DEFAULT NULL,
  `fecha_cobro` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recibo`
--

INSERT INTO `recibo` (`id`, `fecha_emision`, `num_registro`, `descripcion`, `importe`, `fecha_cobro`) VALUES
(1, '2018-12-27 00:00:00', '12.00', 'test', 12, '2018-12-19 00:00:00'),
(2, '2018-12-27 00:00:00', '12.00', 'test', 12, '2018-12-19 00:00:00'),
(3, '2018-12-27 00:00:00', '12.00', 'test', 12, '2018-12-19 00:00:00'),
(4, '2018-12-27 00:00:00', '12.00', 'test', 12, '2018-12-19 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo_vecino`
--

CREATE TABLE `recibo_vecino` (
  `id` int(11) NOT NULL,
  `id_vecino` int(11) NOT NULL,
  `id_recibo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recibo_vecino`
--

INSERT INTO `recibo_vecino` (`id`, `id_vecino`, `id_recibo`) VALUES
(1, 1, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipofactura`
--

CREATE TABLE `tipofactura` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipofactura`
--

INSERT INTO `tipofactura` (`id`, `descripcion`) VALUES
(1, 'test');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipovecino`
--

CREATE TABLE `tipovecino` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipovecino`
--

INSERT INTO `tipovecino` (`id`, `descripcion`) VALUES
(1, 'test_tipovecino'),
(4, 'updated2'),
(5, 'hola'),
(6, 'hola'),
(7, 'updated2'),
(8, 'updated2'),
(9, 'hola'),
(10, 'test');

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
-- Volcado de datos para la tabla `vecino`
--

INSERT INTO `vecino` (`id`, `nombre`, `direccion`, `numero`, `nif`, `iban`, `num_mandato`, `fecha_mandato`, `porcentaje_participacion`, `id_comunidad`, `email`, `telefono`, `id_tipovecino`, `cod_poblacion`, `login`, `pass`) VALUES
(1, 'test_vecino', 'test_vecino', 'test_vecino', 'test_vecino', 'test_vecino', 'test_vecino', '2018-12-05 00:00:00', '0.00', 1, 'test_vecino', 'test_vecino', 1, 1, 'admin', 'admin');

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
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recibo_vecino`
--
ALTER TABLE `recibo_vecino`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recibo_vecino_vecino_fk` (`id_vecino`),
  ADD KEY `recibo_vecino_recibo_fk` (`id_recibo`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura_proveedor`
--
ALTER TABLE `factura_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `incidencia`
--
ALTER TABLE `incidencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `recibo`
--
ALTER TABLE `recibo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `recibo_vecino`
--
ALTER TABLE `recibo_vecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipofactura`
--
ALTER TABLE `tipofactura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipovecino`
--
ALTER TABLE `tipovecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `vecino`
--
ALTER TABLE `vecino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
-- Filtros para la tabla `recibo_vecino`
--
ALTER TABLE `recibo_vecino`
  ADD CONSTRAINT `recibo_vecino_recibo_fk` FOREIGN KEY (`id_recibo`) REFERENCES `recibo` (`id`),
  ADD CONSTRAINT `recibo_vecino_vecino_fk` FOREIGN KEY (`id_vecino`) REFERENCES `vecino` (`id`);

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
