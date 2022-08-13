CREATE Table employee
(
   employeeid INTEGER,
   firstname VARCHAR (150) NOT NULL,
   lastname VARCHAR (150) NOT NULL UNIQUE,
   email VARCHAR (10) NOT NULL,
   age INTEGER,
   salary INTEGER,
   companyid VARCHAR (150) NOT NULL
)

