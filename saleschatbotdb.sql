-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.28-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for saleschatbot
DROP DATABASE IF EXISTS `saleschatbot`;
CREATE DATABASE IF NOT EXISTS `saleschatbot` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `saleschatbot`;

-- Dumping structure for table saleschatbot.branches
DROP TABLE IF EXISTS `branches`;
CREATE TABLE IF NOT EXISTS `branches` (
  `branchId` int(11) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`branchId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table saleschatbot.branches: ~4 rows (approximately)
DELETE FROM `branches`;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` (`branchId`, `branchName`) VALUES
	(1, 'Chennai\r\n'),
	(2, 'Coimbatore'),
	(3, 'Trichy'),
	(4, 'Bangalore');
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;

-- Dumping structure for table saleschatbot.generaldata
DROP TABLE IF EXISTS `generaldata`;
CREATE TABLE IF NOT EXISTS `generaldata` (
  `access_id` varchar(50) DEFAULT NULL,
  `seq_no` varchar(50) DEFAULT NULL,
  `display_value` varchar(500) DEFAULT NULL,
  `display_type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table saleschatbot.generaldata: ~30 rows (approximately)
DELETE FROM `generaldata`;
/*!40000 ALTER TABLE `generaldata` DISABLE KEYS */;
INSERT INTO `generaldata` (`access_id`, `seq_no`, `display_value`, `display_type`) VALUES
	('L_01_00_00_00_00', '1', 'Sales', 'L'),
	('L_01_00_00_00_00', '2', 'Location', 'L'),
	('L_01_00_00_00_00', '3', 'Product', 'L'),
	('L_01_01_00_00_00', '1', 'Region', 'L'),
	('L_01_01_00_00_00', '2', 'Product', 'L'),
	('L_01_01_01_00_00', '1', 'TN', 'L'),
	('L_01_01_01_00_00', '2', 'AP', 'L'),
	('L_01_01_01_00_00', '3', 'KL', 'L'),
	('L_01_01_01_00_00', '4', 'KA', 'L'),
	('L_01_01_01_00_00', '5', 'TL', 'L'),
	('L_01_01_01_01_00', '1', 'Chennai', 'L'),
	('L_01_01_01_01_00', '2', 'Coimbatore', 'L'),
	('L_01_01_01_01_00', '3', 'Trichy', 'L'),
	('L_01_01_01_01_00', '4', 'Madurai', 'L'),
	('L_01_01_01_01_01', '1', '100000', 'T'),
	('L_01_01_01_01_02', '1', '200000', 'T'),
	('L_01_01_01_01_03', '1', '3000000', 'T'),
	('L_01_01_01_01_04', '1', '40000000', 'T'),
	('L_01_03_00_00_00', '1', 'Dove', 'L'),
	('L_01_03_00_00_00', '2', 'Lakme', 'L'),
	('L_01_03_00_00_00', '3', 'Knor Noodles', 'L'),
	('L_01_03_00_00_00', '4', '3 Roses', 'L'),
	('L_01_03_01_00_00', '1', '111111111', 'T'),
	('L_01_03_02_00_00', '1', '22222222222', 'T'),
	('L_01_03_03_00_00', '1', '33333333', 'T'),
	('L_01_03_04_00_00', '1', '4444444', 'T'),
	('L_01_02_00_00_00', '1', 'Banglore', 'L'),
	('L_01_02_00_00_00', '2', 'Mumbai', 'L'),
	('L_01_02_01_00_00', '1', 'Whitefield,Banglore', 'T'),
	('L_01_02_02_00_00', '2', 'Bandra ,Mumbai', 'T');
/*!40000 ALTER TABLE `generaldata` ENABLE KEYS */;

-- Dumping structure for table saleschatbot.sales
DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `responseid` int(11) NOT NULL AUTO_INCREMENT,
  `responsevalue` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`responseid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table saleschatbot.sales: ~0 rows (approximately)
DELETE FROM `sales`;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` (`responseid`, `responsevalue`) VALUES
	(1, '1500');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
