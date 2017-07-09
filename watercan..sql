-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.0.67-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5169
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table watercan.address
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(11) NOT NULL auto_increment,
  `plate_no` varchar(50),
  `road_no` int(11),
  `pincode` int(11),
  `city` varchar(30),
  `area` varchar(30),
  `reg_name` varchar(50) default NULL,
  PRIMARY KEY  (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `booking_id` int(11) NOT NULL auto_increment,
  `number_of_tins` int(11) NOT NULL default '0',
  `tin_id` int(11) NOT NULL default '0',
  `user_id` int(11) NOT NULL default '0',
  `final_fare` double NOT NULL default '0',
  `status` varchar(20) NOT NULL default '0',
  `date_of_booking` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`booking_id`),
  KEY `fk1_user_id` (`user_id`),
  KEY `fk2_tin_id` (`tin_id`),
  CONSTRAINT `fk1_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk2_tin_id` FOREIGN KEY (`tin_id`) REFERENCES `tin` (`tin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.login_log
CREATE TABLE IF NOT EXISTS `login_log` (
  `login_log_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `login_time` timestamp NULL default NULL,
  `user_ip` varchar(50) default NULL,
  `user_agent` varchar(50) default NULL,
  `session_id` varchar(100) default NULL,
  PRIMARY KEY  (`login_log_id`),
  KEY `fk2_user_id` (`user_id`),
  CONSTRAINT `fk2_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.otp_authentication
CREATE TABLE IF NOT EXISTS `otp_authentication` (
  `otp_id` int(11) NOT NULL auto_increment,
  `otp` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `generated_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`otp_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.product
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL auto_increment,
  `no_of_tins` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `available_tins` int(11) NOT NULL,
  `tin_id` int(11) NOT NULL,
  PRIMARY KEY  (`product_id`),
  KEY `fk1_tin_id` (`tin_id`),
  CONSTRAINT `fk1_tin_id` FOREIGN KEY (`tin_id`) REFERENCES `tin` (`tin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for procedure watercan.register_user
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `register_user`(
	IN `plate_no_in` VARCHAR(50),
	IN `road_no_in` INT,
	IN `pincode_in` INT,
	IN `city_in` VARCHAR(50),
	IN `area_in` VARCHAR(50),
	IN `reg_name_in` VARCHAR(50),
	IN `user_name_in` VARCHAR(50),
	IN `mobile_in` VARCHAR(12),
	IN `email_in` VARCHAR(50),
	IN `password_in` VARCHAR(300),
	IN `role_in` VARCHAR(30),
	IN `status_in` INT


,
	OUT `user_id_out` INT

)
BEGIN START TRANSACTION;

    insert into address(address.plate_no,address.road_no,address.pincode,address.city,address.area,address.reg_name)   values(plate_no_in,road_no_in,pincode_in,city_in,area_in,reg_name_in);
    
if(true) then
    insert into user(user.user_name,user.mobile,user.email,user.password,user.status,user.role,user.address_id) values(user_name_in,mobile_in,email_in,password_in,status_in,role_in,LAST_INSERT_ID());
     set user_id_out=LAST_INSERT_ID();
   
    COMMIT;
else 
    ROLLBACK;
end if;
END//
DELIMITER ;

-- Dumping structure for table watercan.tin
CREATE TABLE IF NOT EXISTS `tin` (
  `tin_id` int(11) NOT NULL auto_increment,
  `tin_type_id` int(11) default NULL,
  `status` int(11) default NULL,
  `fare` double default NULL,
  PRIMARY KEY  (`tin_id`),
  KEY `fk1_tin_type_id` (`tin_type_id`),
  CONSTRAINT `fk1_tin_type_id` FOREIGN KEY (`tin_type_id`) REFERENCES `tin_type` (`tin_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.tin_type
CREATE TABLE IF NOT EXISTS `tin_type` (
  `tin_type_id` int(11) NOT NULL auto_increment,
  `tin_name` varchar(50) NOT NULL,
  `capacity` int(11) NOT NULL,
  `meterial` varchar(50) NOT NULL,
  PRIMARY KEY  (`tin_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table watercan.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) NOT NULL,
  `mobile` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `status` tinyint(2) NOT NULL,
  `created_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `role` varchar(50) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `fk1_address_id` (`address_id`),
  CONSTRAINT `fk1_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
