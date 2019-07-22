-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2019 at 01:44 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinic`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_Patient` (IN `Age` INT, IN `Father_Name` VARCHAR(50) CHARSET utf8, IN `First_Name` VARCHAR(50) CHARSET utf8, IN `Gender` BIT, IN `Id_Color` INT, IN `Last_Name` VARCHAR(50) CHARSET utf8, IN `Phone` TEXT CHARSET utf8, IN `Patient_Number` INT)  NO SQL
INSERT INTO patient (age,faherName,firstName,gender,idColor,lastName,phone,PatientNumber)
VALUES
(Age,Father_Name,First_Name,Gender,Id_Color,Last_Name,Phone,Patient_Number)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Select_AllColor` ()  NO SQL
SELECT idColor ,name from toothcolor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Select_AllPatient` ()  NO SQL
SELECT PatientNumber as 'رقم المريض', firstName as 'الاسم',lastName as 'الكنية', faherName as 'اسم الأب', age as 'العمر', phone as 'رقم الهاتف' ,t.name as 'لون السن' FROM patient p ,toothcolor t WHERE p.idColor=t.idColor$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `idBook` int(11) NOT NULL,
  `Day` text COLLATE utf8_unicode_ci,
  `Time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`idBook`, `Day`, `Time`) VALUES
(1, 'السبت', '10:00:00'),
(2, 'السبت', '10:15:00'),
(3, 'السبت', '10:30:00'),
(4, 'السبت', '10:45:00'),
(5, 'السبت', '11:00:00'),
(6, 'السبت', '11:15:00'),
(7, 'السبت', '11:30:00'),
(8, 'السبت', '11:45:00'),
(9, 'السبت', '12:00:00'),
(10, 'السبت', '12:15:00'),
(11, 'السبت', '12:30:00'),
(12, 'السبت', '12:45:00'),
(13, 'السبت', '13:00:00'),
(14, 'السبت', '13:15:00'),
(15, 'السبت', '13:30:00'),
(16, 'السبت', '13:45:00'),
(17, 'السبت', '14:00:00'),
(18, 'السبت', '14:15:00'),
(19, 'السبت', '14:30:00'),
(20, 'السبت', '14:45:00'),
(21, 'السبت', '15:00:00'),
(22, 'السبت', '15:15:00'),
(23, 'السبت', '15:30:00'),
(24, 'السبت', '15:45:00'),
(25, 'السبت', '16:00:00'),
(26, 'السبت', '16:15:00'),
(27, 'السبت', '16:30:00'),
(28, 'السبت', '16:45:00'),
(29, 'السبت', '17:00:00'),
(30, 'السبت', '17:15:00'),
(31, 'السبت', '17:30:00'),
(32, 'السبت', '17:45:00'),
(33, 'السبت', '18:00:00'),
(34, 'السبت', '18:15:00'),
(35, 'السبت', '18:30:00'),
(36, 'السبت', '18:45:00'),
(37, 'السبت', '19:00:00'),
(38, 'السبت', '19:15:00'),
(39, 'السبت', '19:30:00'),
(40, 'السبت', '19:45:00'),
(41, 'السبت', '20:00:00'),
(42, 'السبت', '20:15:00'),
(43, 'السبت', '20:30:00'),
(44, 'السبت', '20:45:00'),
(45, 'السبت', '21:00:00'),
(46, 'السبت', '21:15:00'),
(47, 'السبت', '21:30:00'),
(48, 'السبت', '21:45:00'),
(49, 'الأحد', '10:00:00'),
(50, 'الأحد', '10:15:00'),
(51, 'الأحد', '10:30:00'),
(52, 'الأحد', '10:45:00'),
(53, 'الأحد', '11:00:00'),
(54, 'الأحد', '11:15:00'),
(55, 'الأحد', '11:30:00'),
(56, 'الأحد', '11:45:00'),
(57, 'الأحد', '12:00:00'),
(58, 'الأحد', '12:15:00'),
(59, 'الأحد', '12:30:00'),
(60, 'الأحد', '12:45:00'),
(61, 'الأحد', '13:00:00'),
(62, 'الأحد', '13:15:00'),
(63, 'الأحد', '13:30:00'),
(64, 'الأحد', '13:45:00'),
(65, 'الأحد', '14:00:00'),
(66, 'الأحد', '14:15:00'),
(67, 'الأحد', '14:30:00'),
(68, 'الأحد', '14:45:00'),
(69, 'الأحد', '15:00:00'),
(70, 'الأحد', '15:15:00'),
(71, 'الأحد', '15:30:00'),
(72, 'الأحد', '15:45:00'),
(73, 'الأحد', '16:00:00'),
(74, 'الأحد', '16:15:00'),
(75, 'الأحد', '16:30:00'),
(76, 'الأحد', '16:45:00'),
(77, 'الأحد', '17:00:00'),
(78, 'الأحد', '17:15:00'),
(79, 'الأحد', '17:30:00'),
(80, 'الأحد', '17:45:00'),
(81, 'الأحد', '18:00:00'),
(82, 'الأحد', '18:15:00'),
(83, 'الأحد', '18:30:00'),
(84, 'الأحد', '18:45:00'),
(85, 'الأحد', '19:00:00'),
(86, 'الأحد', '19:15:00'),
(87, 'الأحد', '19:30:00'),
(88, 'الأحد', '19:45:00'),
(89, 'الأحد', '20:00:00'),
(90, 'الأحد', '20:15:00'),
(91, 'الأحد', '20:30:00'),
(92, 'الأحد', '20:45:00'),
(93, 'الأحد', '21:00:00'),
(94, 'الأحد', '21:15:00'),
(95, 'الأحد', '21:30:00'),
(96, 'الأحد', '21:45:00'),
(97, 'الاثنين', '10:00:00'),
(98, 'الاثنين', '10:15:00'),
(99, 'الاثنين', '10:30:00'),
(100, 'الاثنين', '10:45:00'),
(101, 'الاثنين', '11:00:00'),
(102, 'الاثنين', '11:15:00'),
(103, 'الاثنين', '11:30:00'),
(104, 'الاثنين', '11:45:00'),
(105, 'الاثنين', '12:00:00'),
(106, 'الاثنين', '12:15:00'),
(107, 'الاثنين', '12:30:00'),
(108, 'الاثنين', '12:45:00'),
(109, 'الاثنين', '13:00:00'),
(110, 'الاثنين', '13:15:00'),
(111, 'الاثنين', '13:30:00'),
(112, 'الاثنين', '13:45:00'),
(113, 'الاثنين', '14:00:00'),
(114, 'الاثنين', '14:15:00'),
(115, 'الاثنين', '14:30:00'),
(116, 'الاثنين', '14:45:00'),
(117, 'الاثنين', '15:00:00'),
(118, 'الاثنين', '15:15:00'),
(119, 'الاثنين', '15:30:00'),
(120, 'الاثنين', '15:45:00'),
(121, 'الاثنين', '16:00:00'),
(122, 'الاثنين', '16:15:00'),
(123, 'الاثنين', '16:30:00'),
(124, 'الاثنين', '16:45:00'),
(125, 'الاثنين', '17:00:00'),
(126, 'الاثنين', '17:15:00'),
(127, 'الاثنين', '17:30:00'),
(128, 'الاثنين', '17:45:00'),
(129, 'الاثنين', '18:00:00'),
(130, 'الاثنين', '18:15:00'),
(131, 'الاثنين', '18:30:00'),
(132, 'الاثنين', '18:45:00'),
(133, 'الاثنين', '19:00:00'),
(134, 'الاثنين', '19:15:00'),
(135, 'الاثنين', '19:30:00'),
(136, 'الاثنين', '19:45:00'),
(137, 'الاثنين', '20:00:00'),
(138, 'الاثنين', '20:15:00'),
(139, 'الاثنين', '20:30:00'),
(140, 'الاثنين', '20:45:00'),
(141, 'الاثنين', '21:00:00'),
(142, 'الاثنين', '21:15:00'),
(143, 'الاثنين', '21:30:00'),
(144, 'الاثنين', '21:45:00'),
(145, 'الثلاثاء', '10:00:00'),
(146, 'الثلاثاء', '10:15:00'),
(147, 'الثلاثاء', '10:30:00'),
(148, 'الثلاثاء', '10:45:00'),
(149, 'الثلاثاء', '11:00:00'),
(150, 'الثلاثاء', '11:15:00'),
(151, 'الثلاثاء', '11:30:00'),
(152, 'الثلاثاء', '11:45:00'),
(153, 'الثلاثاء', '12:00:00'),
(154, 'الثلاثاء', '12:15:00'),
(155, 'الثلاثاء', '12:30:00'),
(156, 'الثلاثاء', '12:45:00'),
(157, 'الثلاثاء', '13:00:00'),
(158, 'الثلاثاء', '13:15:00'),
(159, 'الثلاثاء', '13:30:00'),
(160, 'الثلاثاء', '13:45:00'),
(161, 'الثلاثاء', '14:00:00'),
(162, 'الثلاثاء', '14:15:00'),
(163, 'الثلاثاء', '14:30:00'),
(164, 'الثلاثاء', '14:45:00'),
(165, 'الثلاثاء', '15:00:00'),
(166, 'الثلاثاء', '15:15:00'),
(167, 'الثلاثاء', '15:30:00'),
(168, 'الثلاثاء', '15:45:00'),
(169, 'الثلاثاء', '16:00:00'),
(170, 'الثلاثاء', '16:15:00'),
(171, 'الثلاثاء', '16:30:00'),
(172, 'الثلاثاء', '16:45:00'),
(173, 'الثلاثاء', '17:00:00'),
(174, 'الثلاثاء', '17:15:00'),
(175, 'الثلاثاء', '17:30:00'),
(176, 'الثلاثاء', '17:45:00'),
(177, 'الثلاثاء', '18:00:00'),
(178, 'الثلاثاء', '18:15:00'),
(179, 'الثلاثاء', '18:30:00'),
(180, 'الثلاثاء', '18:45:00'),
(181, 'الثلاثاء', '19:00:00'),
(182, 'الثلاثاء', '19:15:00'),
(183, 'الثلاثاء', '19:30:00'),
(184, 'الثلاثاء', '19:45:00'),
(185, 'الثلاثاء', '20:00:00'),
(186, 'الثلاثاء', '20:15:00'),
(187, 'الثلاثاء', '20:30:00'),
(188, 'الثلاثاء', '20:45:00'),
(189, 'الثلاثاء', '21:00:00'),
(190, 'الثلاثاء', '21:15:00'),
(191, 'الثلاثاء', '21:30:00'),
(192, 'الثلاثاء', '21:45:00'),
(193, 'الأربعاء', '10:00:00'),
(194, 'الأربعاء', '10:15:00'),
(195, 'الأربعاء', '10:30:00'),
(196, 'الأربعاء', '10:45:00'),
(197, 'الأربعاء', '11:00:00'),
(198, 'الأربعاء', '11:15:00'),
(199, 'الأربعاء', '11:30:00'),
(200, 'الأربعاء', '11:45:00'),
(201, 'الأربعاء', '12:00:00'),
(202, 'الأربعاء', '12:15:00'),
(203, 'الأربعاء', '12:30:00'),
(204, 'الأربعاء', '12:45:00'),
(205, 'الأربعاء', '13:00:00'),
(206, 'الأربعاء', '13:15:00'),
(207, 'الأربعاء', '13:30:00'),
(208, 'الأربعاء', '13:45:00'),
(209, 'الأربعاء', '14:00:00'),
(210, 'الأربعاء', '14:15:00'),
(211, 'الأربعاء', '14:30:00'),
(212, 'الأربعاء', '14:45:00'),
(213, 'الأربعاء', '15:00:00'),
(214, 'الأربعاء', '15:15:00'),
(215, 'الأربعاء', '15:30:00'),
(216, 'الأربعاء', '15:45:00'),
(217, 'الأربعاء', '16:00:00'),
(218, 'الأربعاء', '16:15:00'),
(219, 'الأربعاء', '16:30:00'),
(220, 'الأربعاء', '16:45:00'),
(221, 'الأربعاء', '17:00:00'),
(222, 'الأربعاء', '17:15:00'),
(223, 'الأربعاء', '17:30:00'),
(224, 'الأربعاء', '17:45:00'),
(225, 'الأربعاء', '18:00:00'),
(226, 'الأربعاء', '18:15:00'),
(227, 'الأربعاء', '18:30:00'),
(228, 'الأربعاء', '18:45:00'),
(229, 'الأربعاء', '19:00:00'),
(230, 'الأربعاء', '19:15:00'),
(231, 'الأربعاء', '19:30:00'),
(232, 'الأربعاء', '19:45:00'),
(233, 'الأربعاء', '20:00:00'),
(234, 'الأربعاء', '20:15:00'),
(235, 'الأربعاء', '20:30:00'),
(236, 'الأربعاء', '20:45:00'),
(237, 'الأربعاء', '21:00:00'),
(238, 'الأربعاء', '21:15:00'),
(239, 'الأربعاء', '21:30:00'),
(240, 'الأربعاء', '21:45:00'),
(241, 'الخميس', '10:00:00'),
(242, 'الخميس', '10:15:00'),
(243, 'الخميس', '10:30:00'),
(244, 'الخميس', '10:45:00'),
(245, 'الخميس', '11:00:00'),
(246, 'الخميس', '11:15:00'),
(247, 'الخميس', '11:30:00'),
(248, 'الخميس', '11:45:00'),
(249, 'الخميس', '12:00:00'),
(250, 'الخميس', '12:15:00'),
(251, 'الخميس', '12:30:00'),
(252, 'الخميس', '12:45:00'),
(253, 'الخميس', '13:00:00'),
(254, 'الخميس', '13:15:00'),
(255, 'الخميس', '13:30:00'),
(256, 'الخميس', '13:45:00'),
(257, 'الخميس', '14:00:00'),
(258, 'الخميس', '14:15:00'),
(259, 'الخميس', '14:30:00'),
(260, 'الخميس', '14:45:00'),
(261, 'الخميس', '15:00:00'),
(262, 'الخميس', '15:15:00'),
(263, 'الخميس', '15:30:00'),
(264, 'الخميس', '15:45:00'),
(265, 'الخميس', '16:00:00'),
(266, 'الخميس', '16:15:00'),
(267, 'الخميس', '16:30:00'),
(268, 'الخميس', '16:45:00'),
(269, 'الخميس', '17:00:00'),
(270, 'الخميس', '17:15:00'),
(271, 'الخميس', '17:30:00'),
(272, 'الخميس', '17:45:00'),
(273, 'الخميس', '18:00:00'),
(274, 'الخميس', '18:15:00'),
(275, 'الخميس', '18:30:00'),
(276, 'الخميس', '18:45:00'),
(277, 'الخميس', '19:00:00'),
(278, 'الخميس', '19:15:00'),
(279, 'الخميس', '19:30:00'),
(280, 'الخميس', '19:45:00'),
(281, 'الخميس', '20:00:00'),
(282, 'الخميس', '20:15:00'),
(283, 'الخميس', '20:30:00'),
(284, 'الخميس', '20:45:00'),
(285, 'الخميس', '21:00:00'),
(286, 'الخميس', '21:15:00'),
(287, 'الخميس', '21:30:00'),
(288, 'الخميس', '21:45:00');

-- --------------------------------------------------------

--
-- Table structure for table `dentaldisease`
--

CREATE TABLE `dentaldisease` (
  `idDentalDisease` int(11) NOT NULL,
  `toothNum` int(11) DEFAULT NULL,
  `toothName` text COLLATE utf8_unicode_ci,
  `toothUp` bit(1) DEFAULT NULL,
  `toothRight` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

CREATE TABLE `lab` (
  `idLab` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci,
  `address` text COLLATE utf8_unicode_ci,
  `phone` text COLLATE utf8_unicode_ci,
  `notes` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `labcontain`
--

CREATE TABLE `labcontain` (
  `id` int(11) NOT NULL,
  `idLab` int(11) DEFAULT NULL,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `idSession` int(11) DEFAULT NULL,
  `idLab` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `idPatient` int(11) NOT NULL,
  `firstName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lastName` text COLLATE utf8_unicode_ci,
  `faherName` text COLLATE utf8_unicode_ci,
  `age` int(11) DEFAULT NULL,
  `phone` text COLLATE utf8_unicode_ci,
  `gender` tinyint(1) DEFAULT NULL,
  `idColor` int(11) DEFAULT NULL,
  `PatientNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`idPatient`, `firstName`, `lastName`, `faherName`, `age`, `phone`, `gender`, `idColor`, `PatientNumber`) VALUES
(1, 'أميرة', 'مليس', 'محمود', 23, '25252', 1, 1, 1),
(29, 'غنى', 'عطار', 'حمزة', 24, '255282', 0, 1, 2),
(30, 'مجد', 'قزموز', 'محمد فؤاد', 20, '255252', 1, 1, 3),
(31, 'الاء', 'مليس', 'محمود', 21, '2525', 0, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `patientbook`
--

CREATE TABLE `patientbook` (
  `id` int(11) NOT NULL,
  `idBook` int(11) DEFAULT NULL,
  `idPatient` int(11) DEFAULT NULL,
  `type` text COLLATE utf8_unicode_ci,
  `date` date DEFAULT NULL,
  `idSession` int(11) DEFAULT NULL,
  `done` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patientbook`
--

INSERT INTO `patientbook` (`id`, `idBook`, `idPatient`, `type`, `date`, `idSession`, `done`) VALUES
(32, 93, 1, 'معالجة', '2019-02-24', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `pic`
--

CREATE TABLE `pic` (
  `id` int(11) NOT NULL,
  `idSession` int(11) DEFAULT NULL,
  `picURL` text COLLATE utf8_unicode_ci,
  `notes` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `idSession` int(11) NOT NULL,
  `idPatient` int(11) DEFAULT NULL,
  `TypeOfDisease` tinyint(1) DEFAULT NULL,
  `notes` text COLLATE utf8_unicode_ci,
  `totalCost` bigint(20) DEFAULT NULL,
  `paidCost` bigint(20) DEFAULT NULL,
  `soldCost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sessiontooth`
--

CREATE TABLE `sessiontooth` (
  `id` int(11) NOT NULL,
  `idDentalDisease` int(11) DEFAULT NULL,
  `idSession` int(11) DEFAULT NULL,
  `SessionKind` tinyint(1) DEFAULT NULL,
  `notes` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `toothcolor`
--

CREATE TABLE `toothcolor` (
  `idColor` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `toothcolor`
--

INSERT INTO `toothcolor` (`idColor`, `name`) VALUES
(1, 'A1'),
(2, 'A2'),
(3, 'A3');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `idWare` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci,
  `address` text COLLATE utf8_unicode_ci,
  `phone` text COLLATE utf8_unicode_ci,
  `notes` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `warehousecontain`
--

CREATE TABLE `warehousecontain` (
  `id` int(11) NOT NULL,
  `idWare` int(11) DEFAULT NULL,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idBook`);

--
-- Indexes for table `dentaldisease`
--
ALTER TABLE `dentaldisease`
  ADD PRIMARY KEY (`idDentalDisease`);

--
-- Indexes for table `lab`
--
ALTER TABLE `lab`
  ADD PRIMARY KEY (`idLab`);

--
-- Indexes for table `labcontain`
--
ALTER TABLE `labcontain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk4_fk` (`idLab`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk8_fk` (`idSession`),
  ADD KEY `fk9_fk` (`idLab`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`idPatient`),
  ADD KEY `fk7_fk` (`idColor`);

--
-- Indexes for table `patientbook`
--
ALTER TABLE `patientbook`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk10_fk` (`idSession`),
  ADD KEY `fk11_fk` (`idBook`),
  ADD KEY `fk12_fk` (`idPatient`);

--
-- Indexes for table `pic`
--
ALTER TABLE `pic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk3_fk` (`idSession`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`idSession`),
  ADD KEY `fk6_fk` (`idPatient`);

--
-- Indexes for table `sessiontooth`
--
ALTER TABLE `sessiontooth`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_fk` (`idDentalDisease`),
  ADD KEY `fk2_fk` (`idSession`);

--
-- Indexes for table `toothcolor`
--
ALTER TABLE `toothcolor`
  ADD PRIMARY KEY (`idColor`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`idWare`);

--
-- Indexes for table `warehousecontain`
--
ALTER TABLE `warehousecontain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk5_fk` (`idWare`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `idBook` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=289;
--
-- AUTO_INCREMENT for table `dentaldisease`
--
ALTER TABLE `dentaldisease`
  MODIFY `idDentalDisease` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lab`
--
ALTER TABLE `lab`
  MODIFY `idLab` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `labcontain`
--
ALTER TABLE `labcontain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `idPatient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `patientbook`
--
ALTER TABLE `patientbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `pic`
--
ALTER TABLE `pic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `idSession` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sessiontooth`
--
ALTER TABLE `sessiontooth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `toothcolor`
--
ALTER TABLE `toothcolor`
  MODIFY `idColor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `idWare` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warehousecontain`
--
ALTER TABLE `warehousecontain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `labcontain`
--
ALTER TABLE `labcontain`
  ADD CONSTRAINT `fk4_fk` FOREIGN KEY (`idLab`) REFERENCES `lab` (`idLab`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk8_fk` FOREIGN KEY (`idSession`) REFERENCES `session` (`idSession`),
  ADD CONSTRAINT `fk9_fk` FOREIGN KEY (`idLab`) REFERENCES `lab` (`idLab`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `fk7_fk` FOREIGN KEY (`idColor`) REFERENCES `toothcolor` (`idColor`);

--
-- Constraints for table `patientbook`
--
ALTER TABLE `patientbook`
  ADD CONSTRAINT `fk10_fk` FOREIGN KEY (`idSession`) REFERENCES `session` (`idSession`),
  ADD CONSTRAINT `fk11_fk` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`),
  ADD CONSTRAINT `fk12_fk` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`);

--
-- Constraints for table `pic`
--
ALTER TABLE `pic`
  ADD CONSTRAINT `fk3_fk` FOREIGN KEY (`idSession`) REFERENCES `session` (`idSession`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `fk6_fk` FOREIGN KEY (`idPatient`) REFERENCES `patient` (`idPatient`);

--
-- Constraints for table `sessiontooth`
--
ALTER TABLE `sessiontooth`
  ADD CONSTRAINT `fk1_fk` FOREIGN KEY (`idDentalDisease`) REFERENCES `dentaldisease` (`idDentalDisease`),
  ADD CONSTRAINT `fk2_fk` FOREIGN KEY (`idSession`) REFERENCES `session` (`idSession`);

--
-- Constraints for table `warehousecontain`
--
ALTER TABLE `warehousecontain`
  ADD CONSTRAINT `fk5_fk` FOREIGN KEY (`idWare`) REFERENCES `warehouse` (`idWare`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
