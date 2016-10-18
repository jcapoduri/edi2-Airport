--CREATE DATABASE Airlines;
--USE Airlines;

--select * from sysobjects where xtype='U'

DECLARE @name VARCHAR(128)
DECLARE @foreignName VARCHAR(128)
DECLARE @SQL VARCHAR(254)

SELECT TOP 1 * FROM sys.foreign_keys WHERE parent_object_id = object_id('Destinies') ORDER BY [name]

SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [xtype] = 'U' ORDER BY [name])

WHILE @name is not null
BEGIN    
    SELECT @foreignName = (SELECT TOP 1 [name] FROM sys.foreign_keys WHERE parent_object_id = object_id(@name) ORDER BY [name])
    print  @foreignName
    WHILE @foreignName is not null
    BEGIN        
        SELECT @SQL = 'ALTER TABLE [dbo].[' + RTRIM(@name) +'] DROP CONSTRAINT ' + @foreignName
        PRINT 'Dropped foreign key: ' + @foreignName + @SQL
        EXEC (@SQL)        
        SELECT @foreignName = (SELECT TOP 1 [name] FROM sys.foreign_keys WHERE parent_object_id = object_id(@name))
    END
    SELECT @SQL = 'DROP TABLE [dbo].[' + RTRIM(@name) +']'
    EXEC (@SQL)
    PRINT 'Dropped table: ' + @name
    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [xtype] = 'U' ORDER BY [name])
END
GO

CREATE TABLE Entity (
    id int identity (1,1) NOT NULL PRIMARY KEY,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
);

CREATE TABLE Destinies (
    id int identity (1,1) NOT NULL PRIMARY KEY,
	code VARCHAR(3) NOT NULL,
	name VARCHAR(255) NOT NULL,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
);

CREATE TABLE FlightRoutes (
    id int identity (1,1) NOT NULL PRIMARY KEY,
	code VARCHAR(3) NOT NULL,
	origin int,
	destiny int,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
    CONSTRAINT FK_FlightRoutes_origin FOREIGN KEY (origin)     
    REFERENCES Destinies (id),     
    CONSTRAINT FK_FlightRoutes_destiny FOREIGN KEY (destiny)     
    REFERENCES Destinies (id)     
);

CREATE TABLE Airlines (
    id int identity (1,1) NOT NULL PRIMARY KEY,
    code VARCHAR(3) NOT NULL,
    name VARCHAR(512) NOT NULL,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
);

CREATE TABLE Flights (
    id int identity (1,1) NOT NULL PRIMARY KEY,
    innerCode VARCHAR(6) NOT NULL,
	idFlightRoute int,
    idAirline int,
	backwads bit,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
    CONSTRAINT FK_FlightRoutes_destiny FOREIGN KEY (idFlightRoute)     
    REFERENCES Destinies (id),     
    CONSTRAINT FK_Aerolines_aeroline FOREIGN KEY (idAirline)     
    REFERENCES Airlines (id)     
);

CREATE TABLE Passengers (
    id int identity (1,1) NOT NULL PRIMARY KEY,
	name varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    preferedName varchar(255) NOT NULL,
    email        varchar(255) NOT NULL,
    telephone    varchar(255) NOT NULL,
    passport     varchar(255) NOT NULL,
    document     varchar(255) NOT NULL,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
);



CREATE TABLE Reservations (
    id int identity (1,1) NOT NULL PRIMARY KEY,
    idPassenger int,
    idFlight    int,
    creationDateTime DateTime NOT NULL DEFAULT GETDATE(),
    modificationDateTime DateTime  NULL DEFAULT NULL,
    deletionDateTime DateTime NULL DEFAULT NULL,
    isDeleted bit default 0
    CONSTRAINT FK_Passengers_passenger FOREIGN KEY (idPassenger)     
    REFERENCES Passengers (id), 
    CONSTRAINT FK_Flights_flight FOREIGN KEY (idFlight)     
    REFERENCES Flights (id), 
)


