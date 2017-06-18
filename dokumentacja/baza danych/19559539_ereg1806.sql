-- phpMyAdmin SQL Dump
-- version home.pl
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 18 Cze 2017, 15:05
-- Wersja serwera: 5.5.54-38.6-log
-- Wersja PHP: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `19559539_ereg`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ADDRESSES`
--

CREATE TABLE IF NOT EXISTS `ADDRESSES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `house_number` varchar(4) COLLATE utf8_polish_ci DEFAULT NULL,
  `flat_number` smallint(3) unsigned DEFAULT NULL,
  `postal_code` char(6) COLLATE utf8_polish_ci NOT NULL DEFAULT '44-100',
  `city` varchar(30) COLLATE utf8_polish_ci NOT NULL DEFAULT 'Gliwice',
  `country` varchar(30) COLLATE utf8_polish_ci NOT NULL DEFAULT 'Polska',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=41 ;

--
-- Zrzut danych tabeli `ADDRESSES`
--

INSERT INTO `ADDRESSES` (`id`, `street`, `house_number`, `flat_number`, `postal_code`, `city`, `country`) VALUES
(1, 'Dolnych Wałów', '22b', 5, '44-100', 'Gliwice', 'Polska'),
(2, 'Zwycięstwa', '68', 3, '44-100', 'Gliwice', 'Polska'),
(4, 'Wojska Polskiego', '16', 7, '43-100', 'Tychy', 'Polska'),
(5, 'Czecha Bronisława', '15', NULL, '44-100', 'Gliwice', 'Polska'),
(6, 'Dudka Józefa', '21', 5, '44-100', 'Gliwice', 'Polska'),
(7, 'Chodzki Ignacego', '38', 14, '44-100', 'Gliwice', 'Polska'),
(8, 'Słodowiec', '75', 2, '44-100', 'Gliwice', 'Polska'),
(9, 'Hutnicza', '73', 2, '44-100', 'Gliwice', 'Polska'),
(10, 'Traktorowa', '65', NULL, '44-100', 'Gliwice', 'Polska'),
(11, '1 Maja', '20', 3, '40-224', 'Katowice', 'Polska'),
(12, 'Górniczego Stanu', '66', 4, '40-468', 'Katowice', 'Polska'),
(13, 'Żółta', '78', NULL, '44-100', 'Gliwice', 'Polska'),
(14, 'Czerwona', '16', 2, '44-100', 'Gliwice', 'Polska'),
(15, 'Inwalidów', '64', NULL, '44-100', 'Gliwice', 'Polska'),
(16, 'Zwycięstwa', '11', 2, '44-100', 'Gliwice', 'Polska'),
(17, 'Kujawska', '15', 6, '44-100', 'Gliwice', 'Polska'),
(18, 'Bojkowska', '66', 4, '44-100', 'Gliwice', 'Polska'),
(19, 'Adwokacka', '107', 5, '44-100', 'Gliwice', 'Polska'),
(20, 'Katowicka', '43', 1, '44-100', 'Gliwice', 'Polska'),
(21, 'Andersa', '101', 2, '44-100', 'Gliwice', 'Polska'),
(22, 'Wrocławska', '101', 2, '44-100', 'Gliwice', 'Polska'),
(23, 'Łużycka', '5', 2, '44-100', 'Gliwice', 'Polska'),
(24, 'Barlickiego', '34', NULL, '44-100', 'Gliwice', 'Polska'),
(25, 'Kaszubska', '23', 4, '44-100', 'Gliwice', 'Polska'),
(26, 'Kaszubska', '4', 11, '44-100', 'Gliwice', 'Polska'),
(27, 'Stanisława Konarskie', '94', 5, '44-100', 'Gliwice', 'Polska'),
(28, 'Wincentego Pola', '100', 3, '44-100', 'Gliwice', 'Polska'),
(29, 'Zabrska', '34', 1, '44-100', 'Gliwice', 'Polska'),
(30, 'Zabrska', '36', 1, '44-100', 'Gliwice', 'Polska'),
(31, 'Zabrska', '34', 3, '44-100', 'Gliwice', 'Polska'),
(32, 'Lipowa', '4', 6, '44-100', 'Gliwice', 'Polska'),
(33, 'Rolna', '58', NULL, '44-100', 'Gliwice', 'Polska'),
(34, 'Bielska', '13', 2, '43-100', 'Tychy', 'Polska'),
(36, 'Częstochowska', '2', 4, '44-100', 'Gliwice', 'Polska'),
(37, 'Kujawska', '2', 16, '44-100', 'Gliwice', 'Polska');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `BELONGS`
--

CREATE TABLE IF NOT EXISTS `BELONGS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_student` int(10) unsigned NOT NULL,
  `id_group` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_student_3` (`id_student`,`id_group`),
  KEY `id_student` (`id_student`),
  KEY `id_group` (`id_group`),
  KEY `id_student_2` (`id_student`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=23 ;

--
-- Zrzut danych tabeli `BELONGS`
--

INSERT INTO `BELONGS` (`id`, `id_student`, `id_group`) VALUES
(1, 3, 1),
(9, 3, 6),
(2, 4, 1),
(11, 4, 9),
(14, 5, 4),
(17, 6, 5),
(18, 7, 5),
(3, 8, 1),
(12, 8, 9),
(4, 9, 1),
(13, 9, 9),
(5, 10, 1),
(10, 10, 6),
(15, 11, 4),
(16, 12, 4),
(19, 13, 5),
(20, 14, 5),
(6, 15, 2),
(7, 16, 2),
(8, 17, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `CARES`
--

CREATE TABLE IF NOT EXISTS `CARES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_guardian` int(10) unsigned NOT NULL,
  `id_student` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cares_unique` (`id_guardian`,`id_student`),
  KEY `id_guardian` (`id_guardian`),
  KEY `id_student` (`id_student`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=17 ;

--
-- Zrzut danych tabeli `CARES`
--

INSERT INTO `CARES` (`id`, `id_guardian`, `id_student`) VALUES
(1, 1, 4),
(2, 2, 5),
(3, 3, 6),
(4, 3, 7),
(5, 4, 8),
(6, 5, 9),
(7, 5, 10),
(8, 7, 11),
(9, 8, 12),
(10, 9, 13),
(11, 10, 14),
(12, 11, 15),
(13, 12, 16),
(14, 13, 17);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `CLASSES`
--

CREATE TABLE IF NOT EXISTS `CLASSES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `profile` varchar(12) COLLATE utf8_polish_ci DEFAULT NULL,
  `id_teacher` int(10) unsigned NOT NULL,
  `id_group` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_group_2` (`id_group`),
  UNIQUE KEY `id_teacher_2` (`id_teacher`),
  UNIQUE KEY `classes_unique` (`id_teacher`,`id_group`),
  KEY `id_teacher` (`id_teacher`),
  KEY `id_group` (`id_group`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=12 ;

--
-- Zrzut danych tabeli `CLASSES`
--

INSERT INTO `CLASSES` (`id`, `name`, `profile`, `id_teacher`, `id_group`) VALUES
(1, 'IA', NULL, 1, 1),
(2, 'IB', NULL, 4, 2),
(3, 'IIA', NULL, 5, 3),
(4, 'IIIA', NULL, 6, 4),
(5, 'IVA', NULL, 7, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `FINAL_GRADES`
--

CREATE TABLE IF NOT EXISTS `FINAL_GRADES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark` enum('niedostateczny','dopuszczający','dostateczny','dobry','bardzo dobry','celujący') COLLATE utf8_polish_ci NOT NULL,
  `date` date NOT NULL DEFAULT '2017-06-23',
  `id_student` int(10) unsigned NOT NULL,
  `id_lesson` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_student_2` (`id_student`,`id_lesson`),
  UNIQUE KEY `final_grades_unique` (`id_student`,`id_lesson`),
  KEY `id_lesson` (`id_lesson`),
  KEY `id_student` (`id_student`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=44 ;

--
-- Zrzut danych tabeli `FINAL_GRADES`
--

INSERT INTO `FINAL_GRADES` (`id`, `mark`, `date`, `id_student`, `id_lesson`) VALUES
(1, 'bardzo dobry', '2017-06-23', 3, 21),
(2, 'bardzo dobry', '2017-06-23', 3, 16),
(3, 'dopuszczający', '2017-06-23', 3, 1),
(4, 'dobry', '2017-06-23', 4, 22),
(5, 'dobry', '2017-06-23', 4, 23),
(6, 'celujący', '2017-06-23', 5, 31),
(7, 'bardzo dobry', '2017-06-23', 5, 14),
(8, 'niedostateczny', '2017-06-23', 5, 19),
(9, 'dostateczny', '2017-06-23', 5, 4),
(10, 'bardzo dobry', '2017-06-23', 6, 32),
(11, 'niedostateczny', '2017-06-23', 6, 5),
(12, 'dopuszczający', '2017-06-23', 6, 27),
(13, 'dopuszczający', '2017-06-23', 7, 10),
(14, 'dopuszczający', '2017-06-23', 7, 9),
(15, 'dostateczny', '2017-06-23', 7, 37),
(16, 'bardzo dobry', '2017-06-23', 8, 38),
(17, 'dobry', '2017-06-23', 9, 33),
(18, 'dostateczny', '2017-06-23', 9, 21),
(19, 'bardzo dobry', '2017-06-23', 10, 21),
(20, 'dopuszczający', '2017-06-23', 10, 28),
(21, 'dostateczny', '2017-06-23', 11, 31),
(22, 'dobry', '2017-06-23', 11, 36),
(23, 'bardzo dobry', '2017-06-23', 11, 26),
(24, 'dobry', '2017-06-23', 11, 4),
(25, 'celujący', '2017-06-23', 11, 19),
(26, 'dopuszczający', '2017-06-23', 11, 14),
(27, 'celujący', '2017-06-23', 12, 4),
(28, 'dostateczny', '2017-06-23', 12, 26),
(29, 'dobry', '2017-06-23', 12, 36),
(30, 'dopuszczający', '2017-06-23', 13, 8),
(31, 'dobry', '2017-06-23', 13, 5),
(32, 'dobry', '2017-06-23', 13, 15),
(33, 'dobry', '2017-06-23', 13, 20),
(34, 'dostateczny', '2017-06-23', 14, 9),
(35, 'bardzo dobry', '2017-06-23', 15, 2),
(36, 'dostateczny', '2017-06-23', 15, 17),
(37, 'bardzo dobry', '2017-06-23', 16, 24),
(38, 'celujący', '2017-06-23', 16, 2),
(39, 'bardzo dobry', '2017-06-23', 17, 34),
(40, 'dostateczny', '2017-06-23', 17, 29),
(41, 'dostateczny', '2017-06-23', 17, 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `GROUPS`
--

CREATE TABLE IF NOT EXISTS `GROUPS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `year` char(4) COLLATE utf8_polish_ci NOT NULL DEFAULT '2017',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=10 ;

--
-- Zrzut danych tabeli `GROUPS`
--

INSERT INTO `GROUPS` (`id`, `name`, `year`, `is_active`) VALUES
(1, 'IA', '2017', 1),
(2, 'IB', '2017', 1),
(3, 'IIA', '2017', 1),
(4, 'IIIA', '2017', 1),
(5, 'IVA', '2017', 1),
(6, 'IA_WF_dziewczyny', '2017', 1),
(7, 'IIA_angielski_gr1', '2017', 1),
(8, 'IIA_angielski_gr2', '2017', 1),
(9, 'IA_WF_chłopcy', '2017', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `GUARDIANS`
--

CREATE TABLE IF NOT EXISTS `GUARDIANS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_person` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_person` (`id_person`),
  KEY `id_people` (`id_person`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=14 ;

--
-- Zrzut danych tabeli `GUARDIANS`
--

INSERT INTO `GUARDIANS` (`id`, `id_person`) VALUES
(1, 3),
(2, 7),
(3, 11),
(4, 13),
(5, 16),
(7, 20),
(8, 24),
(9, 27),
(10, 29),
(11, 31),
(12, 35),
(13, 37);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `LESSONS`
--

CREATE TABLE IF NOT EXISTS `LESSONS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `year` char(9) COLLATE utf8_polish_ci NOT NULL DEFAULT '2016/2017',
  `semester` enum('letni','zimowy') COLLATE utf8_polish_ci NOT NULL,
  `id_teacher` int(10) unsigned NOT NULL,
  `id_group` int(10) unsigned NOT NULL,
  `id_subject` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_teacher` (`id_teacher`),
  KEY `id_group` (`id_group`),
  KEY `id_subject` (`id_subject`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=40 ;

--
-- Zrzut danych tabeli `LESSONS`
--

INSERT INTO `LESSONS` (`id`, `year`, `semester`, `id_teacher`, `id_group`, `id_subject`) VALUES
(1, '2016/2017', 'letni', 4, 1, 1),
(2, '2016/2017', 'zimowy', 1, 2, 1),
(3, '2016/2017', 'zimowy', 1, 3, 1),
(4, '2016/2017', 'zimowy', 1, 4, 1),
(5, '2016/2017', 'zimowy', 1, 5, 1),
(6, '2016/2017', 'zimowy', 4, 7, 2),
(7, '2016/2017', 'zimowy', 4, 8, 3),
(8, '2016/2017', 'zimowy', 5, 5, 4),
(9, '2016/2017', 'zimowy', 6, 5, 5),
(10, '2016/2017', 'zimowy', 7, 5, 6),
(12, '2016/2017', 'zimowy', 8, 2, 7),
(13, '2016/2017', 'zimowy', 8, 3, 7),
(14, '2016/2017', 'zimowy', 8, 4, 7),
(15, '2016/2017', 'zimowy', 8, 5, 7),
(16, '2016/2017', 'zimowy', 9, 1, 8),
(17, '2016/2017', 'zimowy', 9, 2, 8),
(18, '2016/2017', 'zimowy', 9, 3, 8),
(19, '2016/2017', 'zimowy', 9, 4, 8),
(20, '2016/2017', 'zimowy', 9, 5, 8),
(21, '2016/2017', 'zimowy', 10, 6, 9),
(22, '2016/2017', 'zimowy', 10, 9, 9),
(23, '2016/2017', 'zimowy', 11, 1, 10),
(24, '2016/2017', 'zimowy', 11, 2, 10),
(25, '2016/2017', 'zimowy', 11, 3, 10),
(26, '2016/2017', 'zimowy', 11, 4, 10),
(27, '2016/2017', 'zimowy', 11, 5, 10),
(28, '2016/2017', 'zimowy', 12, 1, 11),
(29, '2016/2017', 'zimowy', 12, 2, 11),
(30, '2016/2017', 'zimowy', 12, 3, 11),
(31, '2016/2017', 'zimowy', 12, 4, 11),
(32, '2016/2017', 'zimowy', 12, 5, 11),
(33, '2016/2017', 'zimowy', 13, 1, 12),
(34, '2016/2017', 'zimowy', 13, 2, 12),
(35, '2016/2017', 'zimowy', 13, 3, 12),
(36, '2016/2017', 'zimowy', 13, 4, 12),
(37, '2016/2017', 'zimowy', 13, 5, 12),
(38, '2016/2017', 'zimowy', 8, 1, 7);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PARTIAL_GRADES`
--

CREATE TABLE IF NOT EXISTS `PARTIAL_GRADES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark` enum('1','2','3','4','5','6') COLLATE utf8_polish_ci NOT NULL,
  `weight` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `description` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `date` date NOT NULL,
  `id_student` int(10) unsigned NOT NULL,
  `id_lesson` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_student` (`id_student`),
  KEY `id_lesson` (`id_lesson`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=48 ;

--
-- Zrzut danych tabeli `PARTIAL_GRADES`
--

INSERT INTO `PARTIAL_GRADES` (`id`, `mark`, `weight`, `description`, `date`, `id_student`, `id_lesson`) VALUES
(1, '3', 1, NULL, '2016-10-19', 5, 4),
(2, '4', 1, NULL, '2016-10-19', 11, 4),
(3, '6', 1, NULL, '2016-10-19', 12, 4),
(4, '3', 1, NULL, '2016-10-19', 9, 21),
(5, '5', 1, NULL, '2016-10-19', 10, 21),
(6, '3', 1, '"Kartkówka"', '2016-11-07', 5, 4),
(7, '1', 1, '"Sprawdzian"', '2016-12-01', 5, 4),
(8, '2', 1, 'Odpowiedź ustna', '2016-09-15', 3, 1),
(9, '5', 1, NULL, '2016-09-14', 15, 2),
(10, '6', 1, NULL, '2016-10-19', 16, 2),
(11, '5', 1, NULL, '2016-10-19', 5, 4),
(12, '1', 1, NULL, '2016-10-19', 6, 5),
(13, '4', 1, NULL, '2016-10-19', 13, 5),
(14, '2', 1, NULL, '2016-09-14', 13, 8),
(15, '3', 1, NULL, '2016-09-14', 14, 9),
(16, '2', 1, NULL, '2016-09-14', 7, 9),
(17, '2', 1, NULL, '2016-09-14', 7, 10),
(18, '3', 1, NULL, '2016-09-14', 17, 12),
(19, '5', 1, 'dwdwq', '2016-09-14', 5, 14),
(20, '2', 1, 'sws', '2016-09-14', 11, 14),
(21, '4', 1, 'wdwd', '2016-09-14', 13, 15),
(22, '6', 1, 'wdwdw', '2016-09-14', 3, 16),
(23, '3', 1, NULL, '2016-09-14', 15, 17),
(24, '1', 1, NULL, '2016-09-14', 5, 19),
(25, '6', 1, NULL, '2016-09-14', 11, 19),
(26, '4', 1, 'wdwdw', '2016-09-14', 13, 20),
(27, '6', 1, 'wdwdw', '2016-09-14', 3, 21),
(28, '1', 1, NULL, '2016-09-14', 4, 22),
(29, '4', 1, 'dva', '2016-09-14', 4, 23),
(30, '5', 1, NULL, '2016-09-14', 16, 24),
(31, '2', 1, NULL, '2016-09-14', 11, 26),
(32, '3', 1, NULL, '2016-09-14', 12, 26),
(33, '1', 1, NULL, '2016-09-14', 6, 27),
(34, '2', 1, NULL, '2016-09-14', 10, 28),
(35, '3', 1, NULL, '2016-09-14', 17, 29),
(36, '6', 1, NULL, '2016-09-14', 5, 31),
(37, '3', 1, NULL, '2016-09-14', 11, 31),
(38, '5', 1, NULL, '2016-09-14', 6, 32),
(39, '4', 1, NULL, '2016-09-14', 9, 33),
(40, '5', 1, NULL, '2016-09-14', 17, 34),
(41, '4', 1, NULL, '2016-09-14', 12, 36),
(42, '4', 1, NULL, '2016-09-14', 11, 36),
(43, '3', 1, NULL, '2016-09-14', 7, 37),
(44, '5', 1, NULL, '2016-09-14', 8, 38),
(45, '5', 1, NULL, '2016-09-14', 6, 32),
(46, '3', 1, NULL, '2016-09-14', 12, 36),
(47, '4', 1, NULL, '2016-09-14', 7, 37);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PEOPLE`
--

CREATE TABLE IF NOT EXISTS `PEOPLE` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `sex` enum('kobieta','mężczyzna') COLLATE utf8_polish_ci NOT NULL,
  `phone` char(9) COLLATE utf8_polish_ci DEFAULT NULL,
  `mail` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `expiration_date` date NOT NULL DEFAULT '2019-08-31',
  `id_address` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ADDRESS` (`id_address`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=43 ;

--
-- Zrzut danych tabeli `PEOPLE`
--

INSERT INTO `PEOPLE` (`id`, `name`, `surname`, `date_of_birth`, `sex`, `phone`, `mail`, `expiration_date`, `id_address`) VALUES
(1, 'Natalia', 'Bobek', '2010-03-08', 'kobieta', '514568222', 'nat.bobek@gmail.com', '2019-08-30', 1),
(2, 'Michał', 'Ptak', '2010-04-02', 'mężczyzna', '668154654', 'michas@fotka.pl', '2019-08-31', 4),
(3, 'Elżbieta', 'Ptak', '1988-10-13', 'kobieta', '606454656', 'ela.ptak@gmail.com', '2019-08-31', 4),
(4, 'Paweł', 'Mamek', '1966-08-14', 'mężczyzna', '514847817', NULL, '2019-08-31', 2),
(5, 'Ziemowit', 'Chmielewski', '1980-01-23', 'mężczyzna', '675443067', 'ZiemowitChmielewski@o2.pl', '2019-08-31', 5),
(6, 'Katarzyna', 'Majewska', '2008-04-30', 'kobieta', '673395739', 'kat_maaa@tlen.pl', '2019-08-31', 6),
(7, 'Irenka', 'Majewska', '1980-08-04', 'kobieta', '505505505', 'irenkaNowicka@gmail.com', '2019-08-31', 6),
(8, 'Krystyna', 'Jasińska', '1973-02-03', 'kobieta', '532648154', 'krysia@o2.pl', '2019-08-31', 8),
(9, 'Marcin', 'Michalewski', '2007-01-03', 'mężczyzna', '604635299', NULL, '2019-08-31', 9),
(10, 'Maciek', 'Michalewski', '2007-01-03', 'mężczyzna', '604354811', NULL, '2019-08-31', 9),
(11, 'Kalina', 'Michalewska', '1974-12-09', 'kobieta', '604123456', 'kalina_mich@gmail.com', '2019-08-31', 9),
(12, 'Piotr', 'Sobczak', '2010-06-03', 'mężczyzna', NULL, NULL, '2019-08-31', 10),
(13, 'Alicja', 'Sobczak', '1979-04-27', 'kobieta', '503486153', 'ala@gmail.com', '2019-08-31', 10),
(14, 'Sławomir', 'Pawłowski', '1964-01-13', 'mężczyzna', '519524652', 'slawek.pawlowski@szkola.pl', '2019-08-31', 11),
(15, 'Karol', 'Maciejewski', '2010-04-25', 'mężczyzna', NULL, 'karolek@op.pl', '2019-08-31', 12),
(16, 'Andrzej', 'Maciejewski', '1969-09-20', 'mężczyzna', '506481354', 'andrzej.maciejewski@o2.pl', '2019-08-31', 12),
(17, 'Wiktoria', 'Maciejewska', '2010-11-14', 'kobieta', NULL, NULL, '2019-08-31', 12),
(18, 'Błażej', 'Czerwiński', '1965-05-28', 'mężczyzna', '504159753', 'blazej.czerwinski@szkola.pl', '2019-08-31', 13),
(19, 'Dominik', 'Woźniak', '2008-01-13', 'mężczyzna', NULL, 'dominik1234@gmail.com', '2019-08-31', 14),
(20, 'Elżbieta', 'Woźniak', '1983-03-19', 'kobieta', '600154685', 'ela.wozniak@o2.pl', '2019-08-31', 14),
(21, 'Iwona', 'Grabowska', '1960-10-02', 'kobieta', '518645987', 'iwona.grabowska@szkola.pl', '2019-08-31', 15),
(22, 'Honorata', 'Zając', '1993-08-28', 'kobieta', '504684562', 'honorata.zajac@szkola.pl', '2019-08-31', 16),
(23, 'Hanna', 'Pawlik', '2008-07-16', 'kobieta', '513945684', NULL, '2019-08-31', 17),
(24, 'Anna', 'Pawlik', '1984-05-20', 'kobieta', '505808909', 'anna_pawlik@tlen.pl', '2019-08-31', 17),
(25, 'Marek', 'Szczepański', '1974-03-15', 'mężczyzna', '788202644', 'marek.szczepanski@szkola.pl', '2019-08-31', 18),
(26, 'Marcelina', 'Jasińska', '2007-05-05', 'kobieta', '883446262', NULL, '2019-08-31', 19),
(27, 'Beata', 'Jasińska', '1989-09-01', 'kobieta', '808465465', 'marcelina@gmail.com', '2019-08-31', 19),
(28, 'Bożena', 'Chmielewska', '2007-03-18', 'kobieta', '697782315', NULL, '2019-08-31', 20),
(29, 'Artur', 'Chmielewski', '1980-01-31', 'mężczyzna', '503415354', 'artur_chmielewski@gmail.com', '2019-08-31', 20),
(30, 'Dorota', 'Kalinowska', '2010-04-22', 'kobieta', NULL, NULL, '2019-08-31', 21),
(31, 'Bogumiła', 'Kalinowska', '1977-11-11', 'kobieta', '796476804', 'bogumila1845@o2.pl', '2019-08-31', 22),
(32, 'Adriana', 'Małek', '1971-12-20', 'kobieta', '506418265', 'adriana.malek@szkola.pl', '2019-08-31', 23),
(33, 'Rafał', 'Garlicki', '1967-05-16', 'mężczyzna', '504848999', 'rafal.garlicki@szkola.pl', '2019-08-31', 24),
(34, 'Szymon', 'Jaskierski', '2010-10-08', 'mężczyzna', NULL, 'szymek04@o2.pl', '2019-08-31', 25),
(35, 'Celina', 'Jaskierska', '1981-08-21', 'kobieta', '504156456', 'celina_j21@gmail.com', '2019-08-31', 25),
(36, 'Kamil', 'Bembok', '2010-05-11', 'mężczyzna', NULL, 'kamilek0111@tlen.pl', '2019-08-31', 26),
(37, 'Marlena', 'Bembok', '1979-03-19', 'kobieta', '515654456', 'marlena_bembok@op.pl', '2019-08-31', 26),
(38, 'Paulina', 'Bęgo', '1989-04-05', 'kobieta', '485654123', 'paula_bego@gmail.com', '2018-06-30', 36),
(39, 'Paweł', 'Momko', '1980-10-15', 'mężczyzna', '505411223', 'pawmom@gmail.com', '2018-06-30', 37);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `SEMIFINAL_GRADES`
--

CREATE TABLE IF NOT EXISTS `SEMIFINAL_GRADES` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark` enum('niedostateczny','dopuszczający','dostateczny','dobry','bardzo dobry','celujący') NOT NULL,
  `date` date NOT NULL DEFAULT '2017-01-20',
  `id_student` int(10) unsigned NOT NULL,
  `id_lesson` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `semifinal_grades_unique` (`id_student`,`id_lesson`),
  KEY `id_student` (`id_student`,`id_lesson`),
  KEY `id_lesson` (`id_lesson`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin2 AUTO_INCREMENT=43 ;

--
-- Zrzut danych tabeli `SEMIFINAL_GRADES`
--

INSERT INTO `SEMIFINAL_GRADES` (`id`, `mark`, `date`, `id_student`, `id_lesson`) VALUES
(1, 'bardzo dobry', '2017-01-20', 3, 21),
(2, 'bardzo dobry', '2017-01-20', 3, 16),
(3, 'dopuszczający', '2017-01-20', 3, 1),
(4, 'dopuszczający', '2017-01-20', 4, 22),
(5, 'dobry', '2017-01-20', 4, 23),
(6, 'celujący', '2017-01-20', 5, 31),
(7, 'bardzo dobry', '2017-01-20', 5, 14),
(8, 'niedostateczny', '2017-01-20', 5, 19),
(9, 'dostateczny', '2017-01-20', 5, 4),
(10, 'bardzo dobry', '2017-01-20', 6, 32),
(11, 'niedostateczny', '2017-01-20', 6, 5),
(12, 'niedostateczny', '2017-01-20', 6, 27),
(13, 'dopuszczający', '2017-01-20', 7, 10),
(14, 'dopuszczający', '2017-01-20', 7, 9),
(15, 'dostateczny', '2017-01-20', 7, 37),
(16, 'bardzo dobry', '2017-01-20', 8, 38),
(17, 'dobry', '2017-01-20', 9, 33),
(18, 'dostateczny', '2017-01-20', 9, 21),
(19, 'bardzo dobry', '2017-01-20', 10, 21),
(20, 'dopuszczający', '2017-01-20', 10, 28),
(21, 'dostateczny', '2017-01-20', 11, 31),
(22, 'dobry', '2017-01-20', 11, 36),
(23, 'dopuszczający', '2017-01-20', 11, 26),
(24, 'dobry', '2017-01-20', 11, 4),
(25, 'celujący', '2017-01-20', 11, 19),
(26, 'dopuszczający', '2017-01-20', 11, 14),
(27, 'celujący', '2017-01-20', 12, 4),
(28, 'dostateczny', '2017-01-20', 12, 26),
(29, 'dobry', '2017-01-20', 12, 36),
(30, 'dopuszczający', '2017-01-20', 13, 8),
(31, 'dobry', '2017-01-20', 13, 5),
(32, 'dobry', '2017-01-20', 13, 15),
(33, 'dobry', '2017-01-20', 13, 20),
(34, 'dostateczny', '2017-01-20', 14, 9),
(35, 'bardzo dobry', '2017-01-20', 15, 2),
(36, 'dostateczny', '2017-01-20', 15, 17),
(37, 'bardzo dobry', '2017-01-20', 16, 24),
(38, 'celujący', '2017-01-20', 16, 2),
(39, 'bardzo dobry', '2017-01-20', 17, 34),
(40, 'dostateczny', '2017-01-20', 17, 29),
(41, 'dostateczny', '2017-01-20', 17, 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `STUDENTS`
--

CREATE TABLE IF NOT EXISTS `STUDENTS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_person` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_person` (`id_person`),
  KEY `id_people` (`id_person`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=19 ;

--
-- Zrzut danych tabeli `STUDENTS`
--

INSERT INTO `STUDENTS` (`id`, `id_person`) VALUES
(3, 1),
(4, 2),
(5, 6),
(6, 9),
(7, 10),
(8, 12),
(9, 15),
(10, 17),
(11, 19),
(12, 23),
(13, 26),
(14, 28),
(15, 30),
(16, 34),
(17, 36);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `SUBJECTS`
--

CREATE TABLE IF NOT EXISTS `SUBJECTS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `advance_level` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=13 ;

--
-- Zrzut danych tabeli `SUBJECTS`
--

INSERT INTO `SUBJECTS` (`id`, `name`, `advance_level`) VALUES
(1, 'język polski', NULL),
(2, 'język angielski', 'podstawowy'),
(3, 'język angielski', 'zaawansowany'),
(4, 'historia', NULL),
(5, 'WOS', NULL),
(6, 'WOK', NULL),
(7, 'przyroda', NULL),
(8, 'matematyka', NULL),
(9, 'WF', NULL),
(10, 'religia', NULL),
(11, 'plastyka', NULL),
(12, 'muzyka', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `TEACHERS`
--

CREATE TABLE IF NOT EXISTS `TEACHERS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_person` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_person_2` (`id_person`),
  UNIQUE KEY `id_person_3` (`id_person`),
  KEY `id_people` (`id_person`),
  KEY `id_person` (`id_person`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=16 ;

--
-- Zrzut danych tabeli `TEACHERS`
--

INSERT INTO `TEACHERS` (`id`, `id_person`) VALUES
(1, 4),
(4, 5),
(5, 8),
(6, 14),
(7, 16),
(8, 18),
(9, 21),
(10, 22),
(11, 25),
(12, 32),
(13, 33);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `USERS`
--

CREATE TABLE IF NOT EXISTS `USERS` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` char(9) COLLATE utf8_polish_ci NOT NULL,
  `password` char(32) COLLATE utf8_polish_ci NOT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `id_person` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `id_person` (`id_person`),
  KEY `id_people` (`id_person`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=48 ;

--
-- Zrzut danych tabeli `USERS`
--

INSERT INTO `USERS` (`id`, `login`, `password`, `last_password_reset_date`, `enabled`, `id_person`) VALUES
(3, 'natbob123', '12345678', '2017-05-08 09:16:35', 1, 1),
(4, 'micpta123', '12345678', NULL, 1, 2),
(5, 'elzpta123', '12345678', NULL, 1, 3),
(6, 'pawmam123', '12345678', '2017-05-15 19:43:29', 1, 4),
(7, 'ziechm123', '12345678', NULL, 1, 5),
(8, 'katmaj123', '12345678', NULL, 1, 6),
(9, 'iremaj123', '12345678', NULL, 1, 7),
(10, 'kryjas123', '12345678', NULL, 1, 8),
(11, 'marmic123', '12345678', NULL, 1, 9),
(12, 'macmic123', '12345678', NULL, 1, 10),
(13, 'kalmic123', '12345678', NULL, 1, 11),
(14, 'piosob123', '12345678', NULL, 1, 12),
(15, 'alisob123', '12345678', NULL, 1, 13),
(16, 'slapaw123', '12345678', NULL, 1, 14),
(17, 'karmac123', '12345678', NULL, 1, 15),
(18, 'andmac123', '12345678', NULL, 1, 16),
(19, 'wikmac123', '12345678', NULL, 1, 17),
(20, 'blacze123', '12345678', NULL, 1, 18),
(21, 'domwoz123', '12345678', NULL, 1, 19),
(22, 'elzwoz123', '12345678', NULL, 1, 20),
(23, 'iwogra123', '12345678', NULL, 1, 21),
(24, 'honzaj123', '12345678', NULL, 1, 22),
(25, 'hanpaw123', '12345678', NULL, 1, 23),
(26, 'annpaw123', '12345678', NULL, 1, 24),
(27, 'marszc123', '12345678', NULL, 1, 25),
(28, 'marjas123', '12345678', NULL, 1, 26),
(29, 'beajas123', '12345678', NULL, 1, 27),
(30, 'bozchm123', '12345678', NULL, 1, 28),
(31, 'artchm123', '12345678', NULL, 1, 29),
(32, 'dorkal123', '12345678', NULL, 1, 30),
(33, 'bogkal123', '12345678', NULL, 1, 31),
(34, 'adrmal123', '12345678', NULL, 1, 32),
(35, 'rafgar123', '12345678', NULL, 1, 33),
(36, 'szyjas123', '12345678', NULL, 1, 34),
(37, 'celjas123', '12345678', NULL, 1, 35),
(38, 'kambem123', '12345678', NULL, 1, 36),
(39, 'marbem123', '12345678', NULL, 1, 37);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `BELONGS`
--
ALTER TABLE `BELONGS`
  ADD CONSTRAINT `BELONGS_ibfk_1` FOREIGN KEY (`id_group`) REFERENCES `GROUPS` (`id`),
  ADD CONSTRAINT `BELONGS_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `STUDENTS` (`id`);

--
-- Ograniczenia dla tabeli `CARES`
--
ALTER TABLE `CARES`
  ADD CONSTRAINT `CARES_ibfk_1` FOREIGN KEY (`id_guardian`) REFERENCES `GUARDIANS` (`id`),
  ADD CONSTRAINT `CARES_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `STUDENTS` (`id`);

--
-- Ograniczenia dla tabeli `CLASSES`
--
ALTER TABLE `CLASSES`
  ADD CONSTRAINT `CLASSES_ibfk_2` FOREIGN KEY (`id_group`) REFERENCES `GROUPS` (`id`),
  ADD CONSTRAINT `CLASSES_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `TEACHERS` (`id`);

--
-- Ograniczenia dla tabeli `FINAL_GRADES`
--
ALTER TABLE `FINAL_GRADES`
  ADD CONSTRAINT `FINAL_GRADES_ibfk_2` FOREIGN KEY (`id_lesson`) REFERENCES `LESSONS` (`id`),
  ADD CONSTRAINT `FINAL_GRADES_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `STUDENTS` (`id`);

--
-- Ograniczenia dla tabeli `GUARDIANS`
--
ALTER TABLE `GUARDIANS`
  ADD CONSTRAINT `GUARDIANS_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `PEOPLE` (`id`);

--
-- Ograniczenia dla tabeli `LESSONS`
--
ALTER TABLE `LESSONS`
  ADD CONSTRAINT `LESSONS_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `TEACHERS` (`id`),
  ADD CONSTRAINT `LESSONS_ibfk_2` FOREIGN KEY (`id_group`) REFERENCES `GROUPS` (`id`),
  ADD CONSTRAINT `LESSONS_ibfk_3` FOREIGN KEY (`id_subject`) REFERENCES `SUBJECTS` (`id`);

--
-- Ograniczenia dla tabeli `PARTIAL_GRADES`
--
ALTER TABLE `PARTIAL_GRADES`
  ADD CONSTRAINT `PARTIAL_GRADES_ibfk_1` FOREIGN KEY (`id_lesson`) REFERENCES `LESSONS` (`id`),
  ADD CONSTRAINT `PARTIAL_GRADES_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `STUDENTS` (`id`);

--
-- Ograniczenia dla tabeli `PEOPLE`
--
ALTER TABLE `PEOPLE`
  ADD CONSTRAINT `PEOPLE_ibfk_1` FOREIGN KEY (`id_address`) REFERENCES `ADDRESSES` (`id`);

--
-- Ograniczenia dla tabeli `SEMIFINAL_GRADES`
--
ALTER TABLE `SEMIFINAL_GRADES`
  ADD CONSTRAINT `SEMIFINAL_GRADES_ibfk_2` FOREIGN KEY (`id_lesson`) REFERENCES `LESSONS` (`id`),
  ADD CONSTRAINT `SEMIFINAL_GRADES_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `STUDENTS` (`id`);

--
-- Ograniczenia dla tabeli `STUDENTS`
--
ALTER TABLE `STUDENTS`
  ADD CONSTRAINT `STUDENTS_ibfk_3` FOREIGN KEY (`id_person`) REFERENCES `PEOPLE` (`id`);

--
-- Ograniczenia dla tabeli `TEACHERS`
--
ALTER TABLE `TEACHERS`
  ADD CONSTRAINT `TEACHERS_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `PEOPLE` (`id`);

--
-- Ograniczenia dla tabeli `USERS`
--
ALTER TABLE `USERS`
  ADD CONSTRAINT `USERS_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `PEOPLE` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
