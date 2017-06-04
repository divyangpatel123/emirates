/*
SQLyog Community v12.2.6 (64 bit)
MySQL - 5.6.35-log : Database - emirates
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`emirates` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `emirates`;

/*Table structure for table `flight_seat` */

DROP TABLE IF EXISTS `flight_seat`;

CREATE TABLE `flight_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `departure_date` datetime NOT NULL,
  `modified_date` datetime NOT NULL,
  `passenger_email` varchar(255) NOT NULL,
  `passenger_id` varchar(255) NOT NULL,
  `passenger_mobile` varchar(255) NOT NULL,
  `passenger_name` varchar(255) NOT NULL,
  `seat_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `flight_seat` */

insert  into `flight_seat`(`id`,`created_date`,`departure_date`,`modified_date`,`passenger_email`,`passenger_id`,`passenger_mobile`,`passenger_name`,`seat_id`) values 
(1,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','divyangpatel74@gmail.com','EMIPASS1','+91 7698221862','Divyang Patel',1),
(2,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','ravi@gmail.com','EMIPASS2','+91 XXXXXXXXXX','Ravi Shah',2),
(3,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','ankit@gmail.com','EMIPASS3','+91 XXXXXXXXXX','Ankit Pancholi',3),
(4,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS4','+91 XXXXXXXXXX','Passenger',4),
(5,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS5','+91 XXXXXXXXXX','Passenger',5),
(6,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS6','+91 XXXXXXXXXX','Passenger',99),
(7,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS7','+91 XXXXXXXXXX','Passenger',98),
(8,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS8','+91 XXXXXXXXXX','Passenger',85),
(9,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS9','+91 XXXXXXXXXX','Passenger',80),
(10,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS10','+91 XXXXXXXXXX','Passenger',70),
(11,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS11','+91 XXXXXXXXXX','Passenger',71),
(12,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS12','+91 XXXXXXXXXX','Passenger',72),
(13,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS13','+91 XXXXXXXXXX','Passenger',73),
(14,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS14','+91 XXXXXXXXXX','Passenger',74),
(15,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS15','+91 XXXXXXXXXX','Passenger',75),
(16,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS16','+91 XXXXXXXXXX','Passenger',76),
(17,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS17','+91 XXXXXXXXXX','Passenger',77),
(18,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS18','+91 XXXXXXXXXX','Passenger',78),
(19,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS19','+91 XXXXXXXXXX','Passenger',79),
(20,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS20','+91 XXXXXXXXXX','Passenger',50),
(21,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS21','+91 XXXXXXXXXX','Passenger',51),
(22,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS22','+91 XXXXXXXXXX','Passenger',52),
(23,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS23','+91 XXXXXXXXXX','Passenger',53),
(24,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS24','+91 XXXXXXXXXX','Passenger',54),
(25,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS25','+91 XXXXXXXXXX','Passenger',55),
(26,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS26','+91 XXXXXXXXXX','Passenger',56),
(27,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS27','+91 XXXXXXXXXX','Passenger',57),
(28,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS28','+91 XXXXXXXXXX','Passenger',58),
(29,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS29','+91 XXXXXXXXXX','Passenger',59),
(30,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS30','+91 XXXXXXXXXX','Passenger',60),
(31,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS31','+91 XXXXXXXXXX','Passenger',31),
(32,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS32','+91 XXXXXXXXXX','Passenger',32),
(33,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS33','+91 XXXXXXXXXX','Passenger',33),
(34,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS34','+91 XXXXXXXXXX','Passenger',34),
(35,'2017-06-02 12:20:45','2017-06-10 17:11:53','2017-06-02 12:21:31','passenger@gmail.com','EMIPASS35','+91 XXXXXXXXXX','Passenger',35);

/*Table structure for table `seatmap` */

DROP TABLE IF EXISTS `seatmap`;

CREATE TABLE `seatmap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Data for the table `seatmap` */

insert  into `seatmap`(`id`,`name`) values 
(1,'A1'),
(2,'A2'),
(3,'A3'),
(4,'A4'),
(5,'A5'),
(6,'A6'),
(7,'A7'),
(8,'A8'),
(9,'A9'),
(10,'A10'),
(11,'B1'),
(12,'B2'),
(13,'B3'),
(14,'B4'),
(15,'B5'),
(16,'B6'),
(17,'B7'),
(18,'B8'),
(19,'B9'),
(20,'B10'),
(21,'C1'),
(22,'C2'),
(23,'C3'),
(24,'C4'),
(25,'C5'),
(26,'C6'),
(27,'C7'),
(28,'C8'),
(29,'C9'),
(30,'C10'),
(31,'D1'),
(32,'D2'),
(33,'D3'),
(34,'D4'),
(35,'D5'),
(36,'D6'),
(37,'D7'),
(38,'D8'),
(39,'D9'),
(40,'D10'),
(41,'E1'),
(42,'E2'),
(43,'E3'),
(44,'E4'),
(45,'E5'),
(46,'E6'),
(47,'E7'),
(48,'E8'),
(49,'E9'),
(50,'E10'),
(51,'F1'),
(52,'F2'),
(53,'F3'),
(54,'F4'),
(55,'F5'),
(56,'F6'),
(57,'F7'),
(58,'F8'),
(59,'F9'),
(60,'F10'),
(61,'G1'),
(62,'G2'),
(63,'G3'),
(64,'G4'),
(65,'G5'),
(66,'G6'),
(67,'G7'),
(68,'G8'),
(69,'G9'),
(70,'G10'),
(71,'H1'),
(72,'H2'),
(73,'H3'),
(74,'H4'),
(75,'H5'),
(76,'H6'),
(77,'H7'),
(78,'H8'),
(79,'H9'),
(80,'H10'),
(81,'I1'),
(82,'I2'),
(83,'I3'),
(84,'I4'),
(85,'I5'),
(86,'I6'),
(87,'I7'),
(88,'I8'),
(89,'I9'),
(90,'I10'),
(91,'J1'),
(92,'J2'),
(93,'J3'),
(94,'J4'),
(95,'J5'),
(96,'J6'),
(97,'J7'),
(98,'J8'),
(99,'J9'),
(100,'J10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
