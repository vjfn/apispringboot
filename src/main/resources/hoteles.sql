-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-02-2024 a las 11:48:48
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hoteles`
--

CREATE TABLE `hoteles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `desayunoBuffet` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hoteles`
--

INSERT INTO `hoteles` (`id`, `nombre`, `ubicacion`, `puntuacion`, `desayunoBuffet`) VALUES
(1, 'Hotel España', 'Barcelona', 4, 1),
(2, 'Gran Hotel Madrid', 'Madrid', 5, 1),
(3, 'Costa del Sol Resort', 'Marbella', 4, 0),
(4, 'Hotel Valencia Playa', 'Valencia', 3, 1),
(5, 'Sevilla Plaza Hotel', 'Sevilla', 4, 1),
(6, 'Bilbao Grand Palace', 'Bilbao', 4, 0),
(7, 'Mallorca Beach Resort', 'Palma de Mallorca', 5, 1),
(8, 'Granada Hills Hotel', 'Granada', 3, 0),
(9, 'Toledo View Hotel', 'Toledo', 4, 1),
(10, 'Catalunya Tower', 'Tarragona', 4, 1),
(11, 'Galicia Green Hotel', 'Santiago de Compostela', 3, 0),
(12, 'Zaragoza Luxury Suites', 'Zaragoza', 5, 1),
(13, 'Costa Brava Retreat', 'Girona', 4, 1),
(14, 'Ibiza Paradise Hotel', 'Ibiza', 5, 1),
(15, 'Alicante Sands Resort', 'Alicante', 3, 0),
(16, 'Cáceres Heritage Inn', 'Cáceres', 4, 1),
(17, 'Salamanca City Hotel', 'Salamanca', 4, 1),
(18, 'Asturias Mountain Lodge', 'Oviedo', 3, 0),
(19, 'Almería Beachfront Resort', 'Almería', 5, 1),
(20, 'Huelva Serenity Hotel', 'Huelva', 3, 1),
(21, 'Menorca Tranquil Retreat', 'Mahon', 4, 1),
(22, 'Córdoba Oasis Hotel', 'Córdoba', 4, 0),
(23, 'Badajoz Riverside Inn', 'Badajoz', 3, 1),
(24, 'Logroño Wine Country Hotel', 'Logroño', 4, 1),
(25, 'Santander Cliffside Retreat', 'Santander', 5, 1),
(26, 'La Rioja Vineyard Hotel', 'Logroño', 4, 0),
(27, 'Murcia Wellness Resort', 'Murcia', 3, 1),
(28, 'Pamplona Highlands Lodge', 'Pamplona', 4, 1),
(29, 'Teruel Desert Oasis', 'Teruel', 3, 0),
(30, 'Segovia Castle Hotel', 'Segovia', 5, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
