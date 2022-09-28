CREATE TABLE `application` (
  `id` int(8) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `uid` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `job` (
  `id` int(8) NOT NULL,
  `title` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `application`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;


CREATE DEFINER=`root`@`localhost` PROCEDURE `searchLocation` (IN `locationIN` VARCHAR(50))   SELECT * FROM job
WHERE job.location LIKE CONCAT('%', locationIN , '%');

CREATE DEFINER=`root`@`localhost` PROCEDURE `searchtJOB` (IN `titleIN` VARCHAR(50))   SELECT * FROM job
WHERE job.title LIKE CONCAT('%', titleIN , '%');

CREATE DEFINER=`root`@`localhost` PROCEDURE `validAPI` (IN `uuidIN` VARCHAR(50), OUT `sumOUT` INT(1))   SELECT COUNT(application.uid) into sumOUT FROM application
where application.uid = uuidIN;

