-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2015 a las 04:35:54
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
(7854, 'jordansilva'),
(123456, 'Aquiles Bailo'),
(159753, 'Esteban Quito'),
(417258, 'Jorge Guerrero'),
(934852, 'Sergio Matamala'),
(987654, 'Aquiles Baeza'),
(178052772, 'jordan'),
(178192655, 'Simon Morales'),
(189974345, 'Marcelo Guerrer'),
(789456123, 'grace');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadistica`
--

INSERT INTO `estadistica` (`cod_estadistica`, `fecha_estadistica`, `total_semanal`, `total_mensual`, `total_anual`) VALUES
(1, '2015-12-02 03:00:00', 100000, 200000, 300000),
(2, '2015-12-02 17:11:21', 100000, 200000, 300000);

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
(1, 'Pendrive', 'Almacenamiento', 'pendrive entero bueno', 77, 9990),
(5, 'Hoja', 'papel', 'papeleria', 65, 100),
(6, 'Kingston', 'Pendrive', 'almacenamiento masivo', 890, 10000),
(7, 'Cartonero', 'Papeleria', 'cartonero para papel', 69, 1000),
(8, 'Disco duro', 'Almacenamiento', 'disco duro 320gb', 29, 35000),
(9, 'Disco duro', 'Almacenamiento', 'HDD 500gb', 45, 40000),
(10, 'Mouse', 'Accesorio', 'Razer ', 44, 54000),
(11, 'Audifonos', 'Audio', 'Beats solo hd', 66, 98000),
(12, 'Teclado', 'Accesorio', 'Logitech g500', 66, 68990),
(14, 'Monitor', 'Video', 'LG UHD 142CS457', 57, 409990),
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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`cod_venta`, `fecha`, `rut_cliente`, `cant_prod`, `valor_neto_total`, `cod_producto`) VALUES
(1, '2015-11-27 15:33:15', 934852, 4, 45000, 10),
(2, '2015-11-27 15:33:52', 178192655, 1, 5000, 1),
(3, '2015-11-27 16:02:48', 934852, 5, 50000, 6),
(5, '2015-11-27 16:03:52', 987654, 5, 69000, 10),
(41, '2015-12-02 17:20:26', 178052772, 3, 30000, 6),
(42, '2015-12-02 17:20:39', 178052772, 4, 216000, 10),
(43, '2015-12-02 17:21:01', 178052772, 3, 3000, 7);

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
  MODIFY `cod_estadistica` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `cod_producto` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `cod_venta` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
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
