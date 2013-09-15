DROP TABLE IF EXISTS `users`;
CREATE TABLE  `pim`.`users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL DEFAULT '',
  `password` varchar(12) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


DROP TABLE IF EXISTS `exams`;
CREATE TABLE  `exams` (
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  `subject` varchar(255) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `semester` varchar(255) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `ects` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `room` varchar(255) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `grade` float unsigned NOT NULL DEFAULT '0',
  `numbers1` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers2` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers3` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers4` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers5` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers6` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers7` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers8` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers9` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers10` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers11` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers12` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers13` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers14` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers15` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers16` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers17` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers18` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers19` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers20` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers21` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers22` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers23` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers24` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers25` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers26` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers27` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers28` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers29` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers30` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers31` smallint(5) unsigned NOT NULL DEFAULT '0',
  `numbers32` smallint(5) unsigned NOT NULL DEFAULT '0',
  KEY `FK_exams_userid` (`userid`),
  CONSTRAINT `FK_exams_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `mail` varchar(255) NOT NULL DEFAULT '',
  `number` varchar(255) NOT NULL DEFAULT '',
  `description1` varchar(255) NOT NULL DEFAULT '',
  `content1` varchar(255) NOT NULL DEFAULT '',
  `description2` varchar(255) NOT NULL DEFAULT '',
  `content2` varchar(255) NOT NULL DEFAULT '',
  `description3` varchar(255) NOT NULL DEFAULT '',
  `content3` varchar(255) NOT NULL DEFAULT '',
  `image` mediumblob,
  KEY `FK_contacts_userid` (`userid`),
  CONSTRAINT `FK_contacts_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  `title` varchar(255) NOT NULL DEFAULT '',
  `content` varchar(255) NOT NULL DEFAULT '',
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  KEY `FK_notes_userid` (`userid`),
  CONSTRAINT `FK_notes_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DELIMITER $$
DROP FUNCTION IF EXISTS `insertUser` $$
CREATE FUNCTION `insertUser` (u VARCHAR(12), p VARCHAR(12)) RETURNS INT
BEGIN
      DECLARE userid INT;
      IF EXISTS (SELECT * FROM users WHERE username = u) THEN
            SET userid = 0;
      ELSE
            INSERT INTO users (username, password) VALUES (u, p);
            SET userid = (SELECT id FROM users WHERE username = u AND password = p);
      END IF;
      RETURN userid;
END $$
DELIMITER ;