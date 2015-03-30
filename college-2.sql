-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2015 at 06:24 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `date` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`date`, `value`, `student_id`, `class_id`) VALUES
('20-02-2015', 'Present', '12', '1'),
('20-02-2015', 'Present', '13', '1'),
('20-02-2015', 'Present', '14', '1'),
('20-02-2015', 'Present', '15', '1'),
('20-02-2015', 'Present', '16', '1'),
('20-02-2015', 'Present', '27', '1'),
('21-02-2015', 'Absent', '12', '1'),
('21-02-2015', 'Absent', '13', '1'),
('21-02-2015', 'Absent', '14', '1'),
('21-02-2015', 'Absent', '15', '1'),
('21-02-2015', 'Present', '16', '1'),
('21-02-2015', 'Present', '27', '1'),
('26-02-2015', 'Present', '17', '2'),
('26-02-2015', 'Present', '18', '2'),
('26-02-2015', 'Present', '19', '2'),
('26-02-2015', 'Present', '20', '2'),
('26-02-2015', 'Present', '21', '2'),
('', 'Present', '12', '1'),
('', 'Absent', '13', '1'),
('', 'Present', '14', '1'),
('', 'Present', '15', '1'),
('', 'Present', '16', '1'),
('', 'Absent', '27', '1'),
('26-02-2015', 'Present', '17', '2'),
('26-02-2015', 'Present', '18', '2'),
('26-02-2015', 'Present', '19', '2'),
('26-02-2015', 'Absent', '20', '2'),
('26-02-2015', 'Present', '21', '2'),
('28-02-2015', 'Absent', '12', '1'),
('28-02-2015', 'Present', '13', '1'),
('28-02-2015', 'Present', '14', '1'),
('28-02-2015', 'Present', '15', '1'),
('28-02-2015', 'Present', '16', '1'),
('28-02-2015', 'Present', '27', '1'),
('12-02-2015', 'Absent', '12', '1'),
('12-02-2015', 'Present', '13', '1'),
('12-02-2015', 'Present', '14', '1'),
('12-02-2015', 'Present', '15', '1'),
('12-02-2015', 'Present', '16', '1'),
('12-02-2015', 'Present', '27', '1'),
('12-12-2015', 'Absent', '12', '1'),
('12-12-2015', 'Present', '13', '1'),
('12-12-2015', 'Present', '14', '1'),
('12-12-2015', 'Present', '15', '1'),
('12-12-2015', 'Absent', '16', '1'),
('12-12-2015', 'Present', '27', '1'),
('12-12-2015', 'Present', '50', '1'),
('01-01-2015', 'Absent', '12', '1'),
('01-01-2015', 'Present', '13', '1'),
('01-01-2015', 'Present', '14', '1'),
('01-01-2015', 'Absent', '15', '1'),
('01-01-2015', 'Present', '16', '1'),
('01-01-2015', 'Present', '27', '1'),
('01-01-2015', 'Absent', '50', '1'),
('12-12-12', 'Absent', '12', '1'),
('12-12-12', 'Absent', '13', '1'),
('12-12-12', 'Present', '14', '1'),
('12-12-12', 'Absent', '15', '1'),
('12-12-12', 'Present', '16', '1'),
('12-12-12', 'Present', '27', '1'),
('12-12-12', 'Absent', '50', '1'),
('1-1-1', 'Absent', '12', '1'),
('1-1-1', 'Absent', '13', '1'),
('1-1-1', 'Present', '14', '1'),
('1-1-1', 'Absent', '15', '1'),
('1-1-1', 'Present', '16', '1'),
('1-1-1', 'Present', '27', '1'),
('1-1-1', 'Absent', '50', '1'),
('11-11-11', 'Absent', '12', '1'),
('11-11-11', 'Absent', '13', '1'),
('11-11-11', 'Present', '14', '1'),
('11-11-11', 'Absent', '15', '1'),
('11-11-11', 'Present', '16', '1'),
('11-11-11', 'Present', '27', '1'),
('11-11-11', 'Absent', '50', '1'),
('aaa', 'Absent', '12', '1'),
('aaa', 'Absent', '13', '1'),
('aaa', 'Present', '14', '1'),
('aaa', 'Absent', '15', '1'),
('aaa', 'Present', '16', '1'),
('aaa', 'Present', '27', '1'),
('aaa', 'Absent', '50', '1'),
('z', 'Present', '12', '1'),
('z', 'Present', '13', '1'),
('z', 'Present', '14', '1'),
('z', 'Present', '15', '1'),
('z', 'Present', '16', '1'),
('z', 'Present', '27', '1'),
('z', 'Present', '50', '1'),
('12-12-2014', 'Present', '51', '5'),
('12-12-2014', 'Present', '54', '5'),
('13-03-2015', 'Absent', '55', '6'),
('13-03-2015', 'Absent', '56', '6'),
('13-03-2015', 'Present', '57', '6'),
('13-03-2015', 'Present', '58', '6'),
('13-03-2015', 'Present', '59', '6'),
('14-03-2015', 'Present', '55', '6'),
('14-03-2015', 'Present', '56', '6'),
('14-03-2015', 'Present', '57', '6'),
('14-03-2015', 'Present', '58', '6'),
('14-03-2015', 'Present', '59', '6'),
('15-03-2015', 'Absent', '55', '6'),
('15-03-2015', 'Present', '56', '6'),
('15-03-2015', 'Absent', '57', '6'),
('15-03-2015', 'Present', '58', '6'),
('15-03-2015', 'Present', '59', '6'),
('12-01-1993', 'Absent', '55', '6'),
('12-01-1993', 'Present', '56', '6'),
('12-01-1993', 'Absent', '57', '6'),
('12-01-1993', 'Present', '58', '6'),
('12-01-1993', 'Present', '59', '6'),
('12`12`12', 'Absent', '55', '6'),
('12`12`12', 'Present', '56', '6'),
('12`12`12', 'Absent', '57', '6'),
('12`12`12', 'Present', '58', '6'),
('12`12`12', 'Present', '59', '6'),
('12', 'Absent', '55', '6'),
('12', 'Present', '56', '6'),
('12', 'Absent', '57', '6'),
('12', 'Present', '58', '6'),
('12', 'Present', '59', '6'),
('', 'Absent', '55', '6'),
('', 'Present', '56', '6'),
('', 'Absent', '57', '6'),
('', 'Present', '58', '6'),
('', 'Present', '59', '6'),
('12-12-12', 'Present', '12', '1'),
('12-12-12', 'Present', '13', '1'),
('12-12-12', 'Present', '14', '1'),
('12-12-12', 'Present', '15', '1'),
('12-12-12', 'Present', '16', '1'),
('12-12-12', 'Present', '27', '1'),
('12-12-12', 'Present', '50', '1'),
('12', 'Present', '12', '1'),
('12', 'Present', '13', '1'),
('12', 'Present', '14', '1'),
('12', 'Present', '15', '1'),
('12', 'Present', '16', '1'),
('12', 'Present', '27', '1'),
('12', 'Present', '50', '1'),
('n', 'Present', '12', '1'),
('n', 'Present', '13', '1'),
('n', 'Present', '14', '1'),
('n', 'Present', '15', '1'),
('n', 'Present', '16', '1'),
('n', 'Present', '27', '1'),
('n', 'Present', '50', '1'),
('12-02-2015', 'Present', '12', '1'),
('12-02-2015', 'Present', '13', '1'),
('12-02-2015', 'Present', '14', '1'),
('12-02-2015', 'Present', '15', '1'),
('12-02-2015', 'Present', '16', '1'),
('12-02-2015', 'Present', '27', '1'),
('12-02-2015', 'Present', '50', '1'),
('12-02-2015', 'Absent', '12', '1'),
('12-02-2015', 'Present', '13', '1'),
('12-02-2015', 'Absent', '14', '1'),
('12-02-2015', 'Present', '15', '1'),
('12-02-2015', 'Present', '16', '1'),
('12-02-2015', 'Present', '27', '1'),
('12-02-2015', 'Present', '50', '1'),
('12-02-2015', 'Absent', '12', '1'),
('12-02-2015', 'Absent', '13', '1'),
('12-02-2015', 'Absent', '14', '1'),
('12-02-2015', 'Present', '15', '1'),
('12-02-2015', 'Present', '16', '1'),
('12-02-2015', 'Present', '27', '1'),
('12-02-2015', 'Present', '50', '1'),
('12-12-2015', 'Absent', '51', '5'),
('12-12-2015', 'Present', '54', '5'),
('vv', 'Present', '12', '1'),
('vv', 'Present', '13', '1'),
('vv', 'Present', '14', '1'),
('vv', 'Present', '15', '1'),
('vv', 'Present', '16', '1'),
('vv', 'Present', '27', '1'),
('vv', 'Present', '50', '1'),
('a', 'Absent', '12', '1'),
('a', 'Present', '13', '1'),
('a', 'Present', '14', '1'),
('a', 'Present', '15', '1'),
('a', 'Present', '16', '1'),
('a', 'Present', '27', '1'),
('a', 'Present', '50', '1'),
('c', 'Absent', '12', '1'),
('c', 'Present', '13', '1'),
('c', 'Present', '14', '1'),
('c', 'Present', '15', '1'),
('c', 'Present', '16', '1'),
('c', 'Present', '27', '1'),
('c', 'Present', '50', '1'),
('', 'Absent', '51', '5'),
('', 'Absent', '54', '5'),
('111', 'Absent', '12', '1'),
('111', 'Present', '13', '1'),
('111', 'Absent', '14', '1'),
('111', 'Present', '15', '1'),
('111', 'Present', '16', '1'),
('111', 'Present', '27', '1'),
('111', 'Present', '50', '1'),
('12-12-2014', 'Absent', '12', '1'),
('12-12-2014', 'Present', '13', '1'),
('12-12-2014', 'Present', '14', '1'),
('12-12-2014', 'Present', '15', '1'),
('12-12-2014', 'Present', '16', '1'),
('12-12-2014', 'Present', '27', '1'),
('12-12-2014', 'Present', '50', '1'),
('12-12-2015', 'Absent', '60', '9');

-- --------------------------------------------------------

--
-- Table structure for table `bus_details`
--

CREATE TABLE IF NOT EXISTS `bus_details` (
`bus_id` int(11) NOT NULL,
  `route` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bus_details`
--

INSERT INTO `bus_details` (`bus_id`, `route`) VALUES
(2, 'chennai'),
(3, 'sat 1'),
(4, 'tambaram'),
(5, 'beach');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE IF NOT EXISTS `class` (
`class_id` int(11) NOT NULL,
  `year` varchar(45) NOT NULL,
  `room_no` varchar(45) NOT NULL,
  `time_id` varchar(45) NOT NULL,
  `department_id` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `year`, `room_no`, `time_id`, `department_id`) VALUES
(1, '1', '1', '1', '1'),
(2, '2', '2', '2', '1'),
(3, '3', '3', '3', '1'),
(4, '4', '4', '4', '1'),
(5, '1', '5', '5', '2'),
(6, '2', '6', '6', '2'),
(7, '3', '7', '7', '2'),
(8, '4', '8', '8', '2'),
(9, '1', '9', '9', '3'),
(10, '2', '10', '10', '3'),
(11, '3', '11', '11', '3'),
(12, '4', '12', '12', '3'),
(13, '1', '13', '13', '4'),
(14, '2', '14', '14', '4'),
(15, '3', '15', '15', '4'),
(16, '4', '16', '16', '4'),
(17, '1', '17', '17', '5'),
(18, '2', '18', '18', '5'),
(19, '3', '19', '19', '5'),
(20, '4', '20', '20', '5'),
(21, '1', '21', '21', '6'),
(22, '2', '22', '22', '6'),
(23, '3', '23', '24', '6'),
(24, '4', '24', '24', '6');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
`dep_id` int(11) NOT NULL,
  `dep_name` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dep_id`, `dep_name`) VALUES
(1, 'IT'),
(2, 'CSE'),
(3, 'EC'),
(4, 'MEC'),
(5, 'EEE'),
(6, 'CIVIL');

-- --------------------------------------------------------

--
-- Table structure for table `sec_user`
--

CREATE TABLE IF NOT EXISTS `sec_user` (
`user_id` int(11) NOT NULL,
  `login_name` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL COMMENT '	',
  `bloodgroup` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `cd_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sec_user`
--

INSERT INTO `sec_user` (`user_id`, `login_name`, `password`, `role`, `first_name`, `last_name`, `bloodgroup`, `address`, `mobile`, `cd_id`) VALUES
(11, 'teacher1', '123456', 'Faculty', 'Teacher', 'one', 'b+', 'chennai,tn,ind', '1234567890', 'IT'),
(12, 'student1', '123456', 'Student', 'student', 'one', 'a+', 'chennai', '1234567890', '1'),
(13, 'student2', '123456', 'Student', 'student', 'two', 'a+', 'chennai', '1234567890', '1'),
(14, 'student3', '123456', 'Student', 'student', 'three', 'a+', 'chennai', '1234567890', '1'),
(15, 'student4', '123456', 'Student', 'student', 'four', 'a+', 'chennai', '1234567890', '1'),
(16, 'student5', '123456', 'Student', 'student', 'five', 'a+', 'chennai', '1234567890', '1'),
(17, 'student21', '123456', 'Student', 'student', 'one', 'a+', 'chennai', '1234567890', '2'),
(18, 'student22', '123456', 'Student', 'student', 'two', 'a+', 'chennai', '1234567890', '2'),
(19, 'student23', '123456', 'Student', 'student', 'three', 'a+', 'chennai', '1234567890', '2'),
(20, 'student24', '123456', 'Student', 'student', 'four', 'a+', 'chennai', '1234567890', '2'),
(21, 'student25', '123456', 'Student', 'student', 'five', 'a+', 'chennai', '1234567890', '2'),
(22, 'student31', '123456', 'Student', 'student', 'one', 'a+', 'chennai', '1234567890', '3'),
(23, 'student32', '123456', 'Student', 'student', 'two', 'a+', 'chennai', '1234567890', '3'),
(24, 'student33', '123456', 'Student', 'student', 'three', 'a+', 'chennai', '1234567890', '3'),
(25, 'student34', '123456', 'Student', 'student', 'four', 'a+', 'chennai', '1234567890', '3'),
(26, 'student35', '123456', 'Student', 'student', 'five', 'a+', 'chennai', '1234567890', '3'),
(27, 'student7', '123456', 'Student', 'student', 'seven', 'a+', 'chennai', '9876543210', '1'),
(28, 'teacher2', '123456', 'Faculty', 'teacher', 'two', 'A+', 'Chennai', '9876543210', 'IT'),
(50, 'student7@mail', '123456', 'Student', 'student', 'seven', 'b+', 'chennai', '9551854456', '1'),
(51, 'studentcse1', '123456', 'Student', 'student', 'one', 'b', 'chennai', '99989898989', '5'),
(54, 'cse1', '123456', 'Student', 'cse', 'two', 'b', 'chennai', '998989898', '5'),
(55, 'cse21', '123456', 'Student', 'cse', '21', 'b', 'chennai', '9551854456', '6'),
(56, 'cse22', '123456', 'Student', 'cse', '22', 'c', 'chennai', '9551854456', '6'),
(57, 'cse23', '123456', 'Student', 'cse', '23', 'c', 'chennai', '9551854456', '6'),
(58, 'cse24', '123456', 'Student', 'cse', '24', 'c', 'chennai', '9551854456', '6'),
(59, 'cse25', '123456', 'Student', 'cse', '25', 'c', 'chennai', '9551854456', '6'),
(60, 'stu@mail', '123456', 'Student', 'stu', 'stu', 'b', 'chennai', '9047042430', '9');

-- --------------------------------------------------------

--
-- Table structure for table `test1`
--

CREATE TABLE IF NOT EXISTS `test1` (
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL,
  `sub1` varchar(45) NOT NULL,
  `sub2` varchar(45) NOT NULL,
  `sub3` varchar(45) NOT NULL,
  `sub4` varchar(45) NOT NULL,
  `sub5` varchar(45) NOT NULL,
  `sub6` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `test1`
--

INSERT INTO `test1` (`student_id`, `class_id`, `sub1`, `sub2`, `sub3`, `sub4`, `sub5`, `sub6`) VALUES
('12', '1', '50', '60', '70', '80', '90', '75'),
('13', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('14', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('15', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('16', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('27', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('17', '2', '50', '50', '60', '70', '80', '50'),
('18', '2', '50', '89', '50', '69', '77', '86'),
('19', '2', '60', '67', '49', '67', '98', '98'),
('20', '2', '76', '54', '78', '98', '79', '87'),
('21', '2', '56', '78', '90', '87', '65', '87'),
('12', '1', '50', '70', 'sub3', 'sub4', 'sub5', 'sub6'),
('13', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('14', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('15', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('16', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('27', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('12', '1', '60', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('13', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('14', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('15', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('16', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('27', '1', 'sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6'),
('55', '6', '50', '60', '70', '80', '90', '50'),
('56', '6', '50', '60', '70', '80', '90', '50'),
('57', '6', '50', '60', '70', '80', '90', '50'),
('58', '6', '50', '60', '70', '80', '90', '50'),
('59', '6', '50', '60', '70', '80', '90', '50'),
('51', '5', '50', '50', '90', '90', '90', '90'),
('54', '5', '10', '90', '90', '90', '90', '90'),
('51', '5', '10', '10', '101', '10', '101', '10'),
('54', '5', '90', '90', '90', '90', '90', '90'),
('51', '5', '10', '10', '10', '10', '10', '10'),
('54', '5', '90', '90', '90', '90', '90', '90'),
('51', '5', '10', '10', '10', '10', '10', '10'),
('54', '5', '90', '90', '90', '90', '90', '90'),
('51', '5', '10', '10', '10', '10', '10', '10'),
('54', '5', '90', '90', '90', '90', '90', '90'),
('60', '9', '10', '10', '10', '10', '10', '10'),
('60', '9', '10', '10', '10', '10', '10', '10'),
('60', '9', '10', '90', '90', '90', '90', '90');

-- --------------------------------------------------------

--
-- Table structure for table `test2`
--

CREATE TABLE IF NOT EXISTS `test2` (
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL,
  `sub1` varchar(45) NOT NULL,
  `sub2` varchar(45) NOT NULL,
  `sub3` varchar(45) NOT NULL,
  `sub4` varchar(45) NOT NULL,
  `sub5` varchar(45) NOT NULL,
  `sub6` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `test3`
--

CREATE TABLE IF NOT EXISTS `test3` (
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL,
  `sub1` varchar(45) NOT NULL,
  `sub2` varchar(45) NOT NULL,
  `sub3` varchar(45) NOT NULL,
  `sub4` varchar(45) NOT NULL,
  `sub5` varchar(45) NOT NULL,
  `sub6` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `test3`
--

INSERT INTO `test3` (`student_id`, `class_id`, `sub1`, `sub2`, `sub3`, `sub4`, `sub5`, `sub6`) VALUES
('60', '9', '10', '10', '10', '10', '10', '10');

-- --------------------------------------------------------

--
-- Table structure for table `test4`
--

CREATE TABLE IF NOT EXISTS `test4` (
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL,
  `sub1` varchar(45) NOT NULL,
  `sub2` varchar(45) NOT NULL,
  `sub3` varchar(45) NOT NULL,
  `sub4` varchar(45) NOT NULL,
  `sub5` varchar(45) NOT NULL,
  `sub6` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `test5`
--

CREATE TABLE IF NOT EXISTS `test5` (
  `student_id` varchar(45) NOT NULL,
  `class_id` varchar(45) NOT NULL,
  `sub1` varchar(45) NOT NULL,
  `sub2` varchar(45) NOT NULL,
  `sub3` varchar(45) NOT NULL,
  `sub4` varchar(45) NOT NULL,
  `sub5` varchar(45) NOT NULL,
  `sub6` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `time_table`
--

CREATE TABLE IF NOT EXISTS `time_table` (
`time_id` int(11) NOT NULL,
  `day` varchar(45) NOT NULL,
  `period1` varchar(45) DEFAULT NULL,
  `period2` varchar(45) DEFAULT NULL,
  `period3` varchar(45) DEFAULT NULL,
  `period4` varchar(45) DEFAULT NULL,
  `period5` varchar(45) DEFAULT NULL,
  `period6` varchar(45) DEFAULT NULL,
  `period7` varchar(45) DEFAULT NULL,
  `period8` varchar(45) DEFAULT NULL,
  `classid` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `time_table`
--

INSERT INTO `time_table` (`time_id`, `day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) VALUES
(1, 'Monday', 'mon 11', 'mon 12', 'mon 13', 'mon 14', 'mon 15', 'mon 16', 'mon 17', 'mon 18', '1'),
(2, 'Tuesday', 'tue 21', 'tue 22', 'tue 23', 'tue 24', 'tue 25', 'tue 26', 'tue 27', 'tue 28', '1'),
(3, 'Wednesday', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', '1'),
(4, 'Thursday', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', '1'),
(5, 'Friday', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', '1'),
(6, 'Saturday', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', '1'),
(7, 'Monday', 'mon 1', 'mon 2', 'mon 3', 'mon 4', 'mon 5', 'mon 6', 'mon 7', 'mon 8', '2'),
(8, 'Tuesday', 'tue 1', 'tue 2', 'tue 3', 'tue 4', 'tue 5', 'tue 6', 'tue 7', 'tue 8', '2'),
(9, 'Wednesday', 'wed 1', 'wed 2', 'wed 3', 'wed 4', 'wed 5', 'wed 6', 'wed 7', 'wed 8', '2'),
(10, 'Thursday', 'thur 1', 'thur 2', 'thur 3', 'thur 4', 'thur 5', 'thur 6', 'thur 7', 'thur 8', '2'),
(11, 'Friday', 'fri 1', 'fri 2', 'fri 3', 'fri 4', 'fri 5', 'fri 6', 'fri 7', 'fri 8', '2'),
(12, 'Saturday', 'sat 1', 'sat 2', 'sat 3', 'sat 4', 'sat 5', 'sat 6', 'sat 7', 'sat 8', '2'),
(13, 'Monday', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', '9'),
(14, 'Tuesday', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', '9'),
(15, 'Wednesday', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', '9'),
(16, 'Thursday', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', '9'),
(17, 'Friday', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', '9'),
(18, 'Saturday', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', '9'),
(19, 'Monday', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', '5'),
(20, 'Tuesday', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', '5'),
(21, 'Wednesday', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', '5'),
(22, 'Thursday', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', '5'),
(23, 'Friday', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', '5'),
(24, 'Saturday', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', '5'),
(25, 'Monday', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', 'mon 1', '6'),
(26, 'Tuesday', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', 'tue 1', '6'),
(27, 'Wednesday', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', 'wed 1', '6'),
(28, 'Thursday', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', 'thur 1', '6'),
(29, 'Friday', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', 'fri 1', '6'),
(30, 'Saturday', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', 'sat 1', '6');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus_details`
--
ALTER TABLE `bus_details`
 ADD PRIMARY KEY (`bus_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
 ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
 ADD PRIMARY KEY (`dep_id`);

--
-- Indexes for table `sec_user`
--
ALTER TABLE `sec_user`
 ADD PRIMARY KEY (`user_id`,`login_name`), ADD UNIQUE KEY `login_name_UNIQUE` (`login_name`);

--
-- Indexes for table `time_table`
--
ALTER TABLE `time_table`
 ADD PRIMARY KEY (`time_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus_details`
--
ALTER TABLE `bus_details`
MODIFY `bus_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sec_user`
--
ALTER TABLE `sec_user`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `time_table`
--
ALTER TABLE `time_table`
MODIFY `time_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
