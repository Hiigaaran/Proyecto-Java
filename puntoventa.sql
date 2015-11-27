-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2015 a las 19:18:42
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntoventa`
--
CREATE DATABASE IF NOT EXISTS `puntoventa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `puntoventa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `rut_cliente` int(10) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rut_cliente`, `nombre`) VALUES
(456, 'qwert'),
(789, 'tyuio'),
(4561, 'qwerty'),
(4567, 'qwerty'),
(123456, 'Aquiles Bailo'),
(159753, 'Esteban Quito'),
(417258, 'Jorge Guerrero'),
(934852, 'Sergio Matamala'),
(987654, 'Aquiles Baeza'),
(178052772, 'Jordan Silva'),
(178192655, 'Simon Morales'),
(189974345, 'Marcelo Guerrer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadistica`
--

CREATE TABLE IF NOT EXISTS `estadistica` (
  `cod_estadistica` int(11) NOT NULL,
  `fecha_estadistica` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total_semanal` int(20) NOT NULL,
  `total_mensual` int(20) NOT NULL,
  `total_anual` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `cod_producto` int(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `clase` varchar(15) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `stock` int(10) NOT NULL,
  `valor_neto` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_producto`, `nombre`, `clase`, `descripcion`, `stock`, `valor_neto`) VALUES
(1, 'Pendrive', 'Almacenamiento', 'pendrive entero bueno', 80, 9990),
(5, 'Hoja', 'papel', 'papeleria', 70, 100),
(6, 'Kingston', 'Pendrive', 'almacenamiento masivo', 900, 10000),
(7, 'Cartonero', 'Papeleria', 'cartonero para papel', 89, 1000),
(8, 'Disco duro', 'Almacenamiento', 'disco duro 320gb', 39, 35000),
(9, 'Disco duro', 'Almacenamiento', 'HDD 500gb', 50, 40000),
(10, 'Mouse', 'Accesorio', 'Razer ', 56, 54000),
(11, 'Audifonos', 'Audio', 'Beats solo hd', 70, 98000),
(12, 'Teclado', 'Accesorio', 'Logitech g500', 70, 68990),
(14, 'Monitor', 'Video', 'LG UHD 142CS457', 60, 409990),
(15, 'Notebook', 'Notebook', 'Hp k049LA ', 70, 500000),
(16, 'Audifonos', 'Audio', 'Panasonic hq78954', 40, 7000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `cod_venta` int(10) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rut_cliente` int(10) NOT NULL,
  `cant_prod` int(11) NOT NULL,
  `valor_neto_total` int(10) NOT NULL,
  `cod_producto` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`cod_venta`, `fecha`, `rut_cliente`, `cant_prod`, `valor_neto_total`, `cod_producto`) VALUES
(1, '2015-11-27 15:33:15', 934852, 4, 45000, 10),
(2, '2015-11-27 15:33:52', 178192655, 1, 5000, 1),
(3, '2015-11-27 16:02:48', 934852, 5, 50000, 6),
(4, '2015-11-27 16:04:26', 178052772, 2, 60000, 12),
(5, '2015-11-27 16:03:52', 987654, 5, 69000, 10),
(6, '2015-11-27 17:02:59', 789, 3, 3000, 7);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut_cliente`);

--
-- Indices de la tabla `estadistica`
--
ALTER TABLE `estadistica`
  ADD PRIMARY KEY (`cod_estadistica`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`cod_venta`),
  ADD KEY `rut_cliente` (`rut_cliente`),
  ADD KEY `cod_producto` (`cod_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estadistica`
--
ALTER TABLE `estadistica`
  MODIFY `cod_estadistica` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `cod_producto` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `cod_venta` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`cod_producto`) REFERENCES `producto` (`cod_producto`),
  ADD CONSTRAINT `venta_ibfk_4` FOREIGN KEY (`rut_cliente`) REFERENCES `cliente` (`rut_cliente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
