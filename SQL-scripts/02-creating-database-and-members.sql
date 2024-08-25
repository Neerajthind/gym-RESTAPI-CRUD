CREATE DATABASE  IF NOT EXISTS `member_mgmt`;
USE `member_mgmt`;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `membership_type` varchar(45) DEFAULT NULL,
  `membership_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `member`
--

INSERT INTO `member` VALUES 
	(1,'Drake','Brown','drake@gmail.com', '123-456-7890', 'Basic', 'Active'),
	(2,'Emma','Miller','emma@gmail.com', '098-765-4321', 'Basic', 'Active'),
	(3,'Avani','Jones','avani@gmail.com', '510-123-2359', 'Basic', 'Active'),
	(4,'Luke','Williams','luke@gmail.com', '210-452-1235', 'Premium', 'Active'),
	(5,'Juan','Davis','juan@gmail.com', '205-456-9087', 'Premium', 'Active');

