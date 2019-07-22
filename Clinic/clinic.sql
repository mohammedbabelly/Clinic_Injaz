-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2019 at 02:31 PM
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
  `Time` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`idBook`, `Day`, `Time`) VALUES
(1, 'السبت', '10:00'),
(2, 'السبت', '10:15'),
(3, 'السبت', '10:30'),
(4, 'السبت', '10:45'),
(5, 'السبت', '11:00'),
(6, 'السبت', '11:15'),
(7, 'السبت', '11:30'),
(8, 'السبت', '11:45'),
(9, 'السبت', '12:00'),
(10, 'السبت', '12:15'),
(11, 'السبت', '12:30'),
(12, 'السبت', '12:45'),
(13, 'السبت', '1:00'),
(14, 'السبت', '1:15'),
(15, 'السبت', '1:30'),
(16, 'السبت', '1:45'),
(17, 'السبت', '2:00'),
(18, 'السبت', '2:15'),
(19, 'السبت', '2:30'),
(20, 'السبت', '2:45'),
(21, 'السبت', '3:00'),
(22, 'السبت', '3:15'),
(23, 'السبت', '3:30'),
(24, 'السبت', '3:45'),
(25, 'السبت', '4:00'),
(26, 'السبت', '4:15'),
(27, 'السبت', '4:30'),
(28, 'السبت', '4:45'),
(29, 'السبت', '5:00'),
(30, 'السبت', '5:15'),
(31, 'السبت', '5:30'),
(32, 'السبت', '5:45'),
(33, 'السبت', '6:00'),
(34, 'السبت', '6:15'),
(35, 'السبت', '6:30'),
(36, 'السبت', '6:45'),
(37, 'السبت', '7:00'),
(38, 'السبت', '7:15'),
(39, 'السبت', '7:30'),
(40, 'السبت', '7:45'),
(41, 'السبت', '8:00'),
(42, 'السبت', '8:15'),
(43, 'السبت', '8:30'),
(44, 'السبت', '8:45'),
(45, 'السبت', '9:00'),
(46, 'السبت', '9:15'),
(47, 'السبت', '9:30'),
(48, 'السبت', '9:45'),
(49, 'الأحد', '10:00'),
(50, 'الأحد', '10:15'),
(51, 'الأحد', '10:30'),
(52, 'الأحد', '10:45'),
(53, 'الأحد', '11:00'),
(54, 'الأحد', '11:15'),
(55, 'الأحد', '11:30'),
(56, 'الأحد', '11:45'),
(57, 'الأحد', '12:00'),
(58, 'الأحد', '12:15'),
(59, 'الأحد', '12:30'),
(60, 'الأحد', '12:45'),
(61, 'الأحد', '1:00'),
(62, 'الأحد', '1:15'),
(63, 'الأحد', '1:30'),
(64, 'الأحد', '1:45'),
(65, 'الأحد', '2:00'),
(66, 'الأحد', '2:15'),
(67, 'الأحد', '2:30'),
(68, 'الأحد', '2:45'),
(69, 'الأحد', '3:00'),
(70, 'الأحد', '3:15'),
(71, 'الأحد', '3:30'),
(72, 'الأحد', '3:45'),
(73, 'الأحد', '4:00'),
(74, 'الأحد', '4:15'),
(75, 'الأحد', '4:30'),
(76, 'الأحد', '4:45'),
(77, 'الأحد', '5:00'),
(78, 'الأحد', '5:15'),
(79, 'الأحد', '5:30'),
(80, 'الأحد', '5:45'),
(81, 'الأحد', '6:00'),
(82, 'الأحد', '6:15'),
(83, 'الأحد', '6:30'),
(84, 'الأحد', '6:45'),
(85, 'الأحد', '7:00'),
(86, 'الأحد', '7:15'),
(87, 'الأحد', '7:30'),
(88, 'الأحد', '7:45'),
(89, 'الأحد', '8:00'),
(90, 'الأحد', '8:15'),
(91, 'الأحد', '8:30'),
(92, 'الأحد', '8:45'),
(93, 'الأحد', '9:00'),
(94, 'الأحد', '9:15'),
(95, 'الأحد', '9:30'),
(96, 'الأحد', '9:45'),
(97, 'الاثنين', '10:00'),
(98, 'الاثنين', '10:15'),
(99, 'الاثنين', '10:30'),
(100, 'الاثنين', '10:45'),
(101, 'الاثنين', '11:00'),
(102, 'الاثنين', '11:15'),
(103, 'الاثنين', '11:30'),
(104, 'الاثنين', '11:45'),
(105, 'الاثنين', '12:00'),
(106, 'الاثنين', '12:15'),
(107, 'الاثنين', '12:30'),
(108, 'الاثنين', '12:45'),
(109, 'الاثنين', '1:00'),
(110, 'الاثنين', '1:15'),
(111, 'الاثنين', '1:30'),
(112, 'الاثنين', '1:45'),
(113, 'الاثنين', '2:00'),
(114, 'الاثنين', '2:15'),
(115, 'الاثنين', '2:30'),
(116, 'الاثنين', '2:45'),
(117, 'الاثنين', '3:00'),
(118, 'الاثنين', '3:15'),
(119, 'الاثنين', '3:30'),
(120, 'الاثنين', '3:45'),
(121, 'الاثنين', '4:00'),
(122, 'الاثنين', '4:15'),
(123, 'الاثنين', '4:30'),
(124, 'الاثنين', '4:45'),
(125, 'الاثنين', '5:00'),
(126, 'الاثنين', '5:15'),
(127, 'الاثنين', '5:30'),
(128, 'الاثنين', '5:45'),
(129, 'الاثنين', '6:00'),
(130, 'الاثنين', '6:15'),
(131, 'الاثنين', '6:30'),
(132, 'الاثنين', '6:45'),
(133, 'الاثنين', '7:00'),
(134, 'الاثنين', '7:15'),
(135, 'الاثنين', '7:30'),
(136, 'الاثنين', '7:45'),
(137, 'الاثنين', '8:00'),
(138, 'الاثنين', '8:15'),
(139, 'الاثنين', '8:30'),
(140, 'الاثنين', '8:45'),
(141, 'الاثنين', '9:00'),
(142, 'الاثنين', '9:15'),
(143, 'الاثنين', '9:30'),
(144, 'الاثنين', '9:45'),
(145, 'الثلاثاء', '10:00'),
(146, 'الثلاثاء', '10:15'),
(147, 'الثلاثاء', '10:30'),
(148, 'الثلاثاء', '10:45'),
(149, 'الثلاثاء', '11:00'),
(150, 'الثلاثاء', '11:15'),
(151, 'الثلاثاء', '11:30'),
(152, 'الثلاثاء', '11:45'),
(153, 'الثلاثاء', '12:00'),
(154, 'الثلاثاء', '12:15'),
(155, 'الثلاثاء', '12:30'),
(156, 'الثلاثاء', '12:45'),
(157, 'الثلاثاء', '1:00'),
(158, 'الثلاثاء', '1:15'),
(159, 'الثلاثاء', '1:30'),
(160, 'الثلاثاء', '1:45'),
(161, 'الثلاثاء', '2:00'),
(162, 'الثلاثاء', '2:15'),
(163, 'الثلاثاء', '2:30'),
(164, 'الثلاثاء', '2:45'),
(165, 'الثلاثاء', '3:00'),
(166, 'الثلاثاء', '3:15'),
(167, 'الثلاثاء', '3:30'),
(168, 'الثلاثاء', '3:45'),
(169, 'الثلاثاء', '4:00'),
(170, 'الثلاثاء', '4:15'),
(171, 'الثلاثاء', '4:30'),
(172, 'الثلاثاء', '4:45'),
(173, 'الثلاثاء', '5:00'),
(174, 'الثلاثاء', '5:15'),
(175, 'الثلاثاء', '5:30'),
(176, 'الثلاثاء', '5:45'),
(177, 'الثلاثاء', '6:00'),
(178, 'الثلاثاء', '6:15'),
(179, 'الثلاثاء', '6:30'),
(180, 'الثلاثاء', '6:45'),
(181, 'الثلاثاء', '7:00'),
(182, 'الثلاثاء', '7:15'),
(183, 'الثلاثاء', '7:30'),
(184, 'الثلاثاء', '7:45'),
(185, 'الثلاثاء', '8:00'),
(186, 'الثلاثاء', '8:15'),
(187, 'الثلاثاء', '8:30'),
(188, 'الثلاثاء', '8:45'),
(189, 'الثلاثاء', '9:00'),
(190, 'الثلاثاء', '9:15'),
(191, 'الثلاثاء', '9:30'),
(192, 'الثلاثاء', '9:45'),
(193, 'الأربعاء', '10:00'),
(194, 'الأربعاء', '10:15'),
(195, 'الأربعاء', '10:30'),
(196, 'الأربعاء', '10:45'),
(197, 'الأربعاء', '11:00'),
(198, 'الأربعاء', '11:15'),
(199, 'الأربعاء', '11:30'),
(200, 'الأربعاء', '11:45'),
(201, 'الأربعاء', '12:00'),
(202, 'الأربعاء', '12:15'),
(203, 'الأربعاء', '12:30'),
(204, 'الأربعاء', '12:45'),
(205, 'الأربعاء', '1:00'),
(206, 'الأربعاء', '1:15'),
(207, 'الأربعاء', '1:30'),
(208, 'الأربعاء', '1:45'),
(209, 'الأربعاء', '2:00'),
(210, 'الأربعاء', '2:15'),
(211, 'الأربعاء', '2:30'),
(212, 'الأربعاء', '2:45'),
(213, 'الأربعاء', '3:00'),
(214, 'الأربعاء', '3:15'),
(215, 'الأربعاء', '3:30'),
(216, 'الأربعاء', '3:45'),
(217, 'الأربعاء', '4:00'),
(218, 'الأربعاء', '4:15'),
(219, 'الأربعاء', '4:30'),
(220, 'الأربعاء', '4:45'),
(221, 'الأربعاء', '5:00'),
(222, 'الأربعاء', '5:15'),
(223, 'الأربعاء', '5:30'),
(224, 'الأربعاء', '5:45'),
(225, 'الأربعاء', '6:00'),
(226, 'الأربعاء', '6:15'),
(227, 'الأربعاء', '6:30'),
(228, 'الأربعاء', '6:45'),
(229, 'الأربعاء', '7:00'),
(230, 'الأربعاء', '7:15'),
(231, 'الأربعاء', '7:30'),
(232, 'الأربعاء', '7:45'),
(233, 'الأربعاء', '8:00'),
(234, 'الأربعاء', '8:15'),
(235, 'الأربعاء', '8:30'),
(236, 'الأربعاء', '8:45'),
(237, 'الأربعاء', '9:00'),
(238, 'الأربعاء', '9:15'),
(239, 'الأربعاء', '9:30'),
(240, 'الأربعاء', '9:45'),
(241, 'الخميس', '10:00'),
(242, 'الخميس', '10:15'),
(243, 'الخميس', '10:30'),
(244, 'الخميس', '10:45'),
(245, 'الخميس', '11:00'),
(246, 'الخميس', '11:15'),
(247, 'الخميس', '11:30'),
(248, 'الخميس', '11:45'),
(249, 'الخميس', '12:00'),
(250, 'الخميس', '12:15'),
(251, 'الخميس', '12:30'),
(252, 'الخميس', '12:45'),
(253, 'الخميس', '1:00'),
(254, 'الخميس', '1:15'),
(255, 'الخميس', '1:30'),
(256, 'الخميس', '1:45'),
(257, 'الخميس', '2:00'),
(258, 'الخميس', '2:15'),
(259, 'الخميس', '2:30'),
(260, 'الخميس', '2:45'),
(261, 'الخميس', '3:00'),
(262, 'الخميس', '3:15'),
(263, 'الخميس', '3:30'),
(264, 'الخميس', '3:45'),
(265, 'الخميس', '4:00'),
(266, 'الخميس', '4:15'),
(267, 'الخميس', '4:30'),
(268, 'الخميس', '4:45'),
(269, 'الخميس', '5:00'),
(270, 'الخميس', '5:15'),
(271, 'الخميس', '5:30'),
(272, 'الخميس', '5:45'),
(273, 'الخميس', '6:00'),
(274, 'الخميس', '6:15'),
(275, 'الخميس', '6:30'),
(276, 'الخميس', '6:45'),
(277, 'الخميس', '7:00'),
(278, 'الخميس', '7:15'),
(279, 'الخميس', '7:30'),
(280, 'الخميس', '7:45'),
(281, 'الخميس', '8:00'),
(282, 'الخميس', '8:15'),
(283, 'الخميس', '8:30'),
(284, 'الخميس', '8:45'),
(285, 'الخميس', '9:00'),
(286, 'الخميس', '9:15'),
(287, 'الخميس', '9:30'),
(288, 'الخميس', '9:45');

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
  `date` text COLLATE utf8_unicode_ci,
  `idSession` int(11) DEFAULT NULL,
  `done` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patientbook`
--

INSERT INTO `patientbook` (`id`, `idBook`, `idPatient`, `type`, `date`, `idSession`, `done`) VALUES
(1, 204, 1, 'معاينة', '20/02/2019', NULL, 0),
(2, 283, 1, 'معاينة', '21/02/2019', NULL, 0),
(8, 249, 29, 'معاينة', '21/02/2019', NULL, 0),
(9, 12, 30, 'معاينة', '02/02/2019', NULL, 0),
(10, 12, 31, 'معاينة', '09/02/2019', NULL, 0),
(11, 245, 1, 'معاينة', '21/02/2019', NULL, 0),
(12, 9, 1, 'معاينة', '23/02/2019', NULL, 0),
(13, 57, 1, 'معاينة', '24/02/2019', NULL, 0),
(14, 105, 1, 'معاينة', '25/02/2019', NULL, 0),
(15, 153, 1, 'معاينة', '26/02/2019', NULL, 0),
(16, 204, 1, 'معاينة', '27/02/2019', NULL, 0),
(17, 251, 1, 'معاينة', '28/02/2019', NULL, 0);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
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
