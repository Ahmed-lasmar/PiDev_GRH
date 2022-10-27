-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 10:54 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `id_app` int(11) NOT NULL,
  `candidat` varchar(50) NOT NULL,
  `offre` varchar(50) NOT NULL,
  `cv` varchar(50) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`id_app`, `candidat`, `offre`, `cv`, `etat`, `date`) VALUES
(1, 'aadfsfsd', 'aaff', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09.jpg', 'Accepté(e)', '2022-10-25'),
(2, 'MkaddemKarray', 'javascriptApp', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09 (2).jpg', 'Refusé(e)', '2022-10-26'),
(34, 'Radhwen Rmili', 'Java', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09 (2).jpg', 'Refusé(e)', '2022-10-25'),
(35, 'Radhwen Rmili', 'JavaEEJob', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09 (2).jpg', 'Refusé(e)', '2022-10-25'),
(36, 'Ahmed Lasmar', 'JavaEEJob', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09 (2).jpg', 'Accepté(e)', '2022-10-26'),
(127, 'Radhwen Hassen', 'JavatJob', 'Accepté(e)', 'C:\\\\Users\\\\radhw\\\\Pictures\\\\sep09 (2).jpg', '2022-10-26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id_app`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `id_app` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
