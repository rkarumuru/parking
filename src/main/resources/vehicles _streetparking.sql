CREATE TABLE PARKED_VEHICLES
(sessionId  int NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  
tagId VARCHAR(100),


transId VARCHAR(100) NOT NULL,  
locationId VARCHAR(100),
 
startTime TIMESTAMP DEFAULT NULL,
  
endTime TIMESTAMP DEFAULT NULL,
  

status VARCHAR(100),
 
displayLongitude FLOAT(10, 6),
displayLatitude FLOAT(10, 6),

actualLongitude FLOAT(10, 6),
actualLatitude  FLOAT(10, 6),
totalcharge double DEFAULT NULL

);


CREATE TABLE PARKED_VEHICLES
(`sessionId` int(11) NOT NULL AUTO_INCREMENT,
  `tagId` varchar(100) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `transId` varchar(100) DEFAULT '0',
  `locationId` varchar(100) DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `displayLongitude` float(10,6) DEFAULT NULL,
  `displayLatitude` float(10,6) DEFAULT NULL,
  `actualLongitude` float(10,6) DEFAULT NULL,
  `actualLatitude` float(10,6) DEFAULT NULL,
  `totalcharge` double NOT NULL,
  PRIMARY KEY (`sessionId`)
);


INSERT INTO PARKED_VEHICLES (tagId,


transId,userId,locationId,
startTime,

endTime,
status,

displayLongitude,
displayLatitude,

actualLongitude,
actualLatitude,
totalcharge
) VALUES('11111', '11111','kirantala', '11111',NOW(), NOW(),'EXPIRED', 
-122.340145, 47.608941,-122.340145,47.608941,  6.00);




INSERT INTO PARKED_VEHICLES (tagId,


transId,userId,locationId,
startTime,

endTime,
status,

displayLongitude,
displayLatitude,

actualLongitude,
actualLatitude,
totalcharge
) VALUES('11112', '11111','kirantala' ,'1112',NOW(), NOW(), 'ACTIVE', -122.340145, 47.608941,-122.340145,47.608941 , 4.00);



INSERT INTO PARKED_VEHICLES (tagId,


transId,userId,locationId,
startTime,

endTime,
status,

displayLongitude,
displayLatitude,

actualLongitude,
actualLatitude,
totalcharge
) VALUES('11111', '11111','naveen', '11111',NOW(), NOW(),'EXPIRED', 
-122.340145, 47.608941,-122.340145,47.608941,  6.00);




INSERT INTO PARKED_VEHICLES (tagId,


transId,userId,locationId,
startTime,

endTime,
status,

displayLongitude,
displayLatitude,

actualLongitude,
actualLatitude,
totalcharge
) VALUES('11112', '11111','naveen' ,'1112',NOW(), NOW(), 'ACTIVE', -122.340145, 47.608941,-122.340145,47.608941 , 4.00);



CREATE TABLE USER_DETAILS
(
beaconId VARCHAR(100) NOT NULL PRIMARY KEY,
  
vehicleId VARCHAR(100),

 userId VARCHAR(100),username VARCHAR(100),  
address VARCHAR(200));

INSERT INTO USER_DETAILS
 VALUES('11111', '11A2121', 'kirantala','John Smith', '111 QUARTZ CRYSTAL PL, CARY NC 27519');

INSERT INTO USER_DETAILS
 VALUES('11112', '11A2212','naveen' ,'Alex Smith', '121 QUARTZ CRYSTAL PL, CARY NC 27513');

CREATE TABLE RATE_DETAILS
(locationId VARCHAR(100) NOT NULL PRIMARY KEY, 
RateId VARCHAR(100),
  
CHARGE double NOT NULL,

 maxTime double NOT NULL,  FREEDAYS VARCHAR(100), FREETIME TIME);


INSERT INTO RATE_DETAILS
 VALUES('11111','1RA1', 11.12, 2.00, 'Sunday', '00:02:00');


INSERT INTO RATE_DETAILS
 VALUES('11112','1RA2', 12.12, 1.50, 'Saturday', '00:03:00');

CREATE TABLE BEACON_DETAILS
(
beaconId VARCHAR(100) NOT NULL PRIMARY KEY,
  
vehicleId VARCHAR(100),

  userId VARCHAR(100),beaconType VARCHAR(10), username VARCHAR(100),  
address VARCHAR(200));

INSERT INTO BEACON_DETAILS
 VALUES('11111', '11A2121', 'kirantala', 'U','Kiran Talasila','111 QUARTZ CRYSTAL PL, CARY NC 27519');

INSERT INTO BEACON_DETAILS
 VALUES('11112', '11A2212', 'naveen','U','Naveen Polavarapu','121 QUARTZ CRYSTAL PL, CARY NC 27513');
INSERT INTO BEACON_DETAILS
 VALUES('11113', '11A2121', 'kirantala','U','Kiran Talasila', '111 QUARTZ CRYSTAL PL, CARY NC 27519');
INSERT INTO BEACON_DETAILS
 VALUES('11114', '11A2121', 'naveen','U', 'Naveen Polavarapu','121 QUARTZ CRYSTAL PL, CARY NC 27513');
INSERT INTO BEACON_DETAILS
 VALUES('11115', '11A2121', 'garage_one','G', '','121 QUARTZ CRYSTAL PL, CARY NC 27513');
INSERT INTO BEACON_DETAILS
 VALUES('11116', '11A2121', 'garage_two','G', '','121 QUARTZ CRYSTAL PL, CARY NC 27513');


