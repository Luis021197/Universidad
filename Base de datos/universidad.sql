-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-03-2023 a las 16:11:15
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `codigo` varchar(5) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `dni` int(8) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `carrera` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `nombre`, `apellido`, `correo`, `dni`, `direccion`, `carrera`) VALUES
('P0001', 'Luis', 'Sotelo', 'sotelo@hotmail.com', 72564928, 'los cipreses', 'Ingenieria de Sistemas'),
('P0002', 'robert', 'salazar', 'salazar@hotmail.com', 74512368, 'SAN MARTIN DE PORRES', 'neurologia'),
('P0003', 'Oswaldo', 'Martinez', 'oswaldo@gmail.com', 74561238, 'dominicos', 'matematicas'),
('P0010', 'Roger', 'Martinez', 'martinez@hotmail.com', 78542361, 'los santos', 'contabilidad'),
('P0049', 'Alonso', 'Manolo', 'manolo@gmail.com', 87654123, 'los portales', 'ing de sistemas'),
('P0051', 'Ramiro', 'Priale', 'priale@gmail.com', 12345687, 'los rosales', 'fisica nuclear'),
('P0111', 'Carla', 'Salazar', 'salazar@hotmail.com', 87654123, 'comas', 'ing de alimentos'),
('P1111', 'Giorelma', 'Herrada', 'herrada@gmail.com', 98765432, 'los olivos', 'medicina'),
('P2211', 'Francisco', 'Arce', 'arce@gmail.com', 45687123, 'BERTELLO', 'ING AMBIENTAL');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
