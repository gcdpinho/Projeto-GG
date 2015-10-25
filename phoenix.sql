-- Deleta a base de dados caso já existir
DROP DATABASE IF EXISTS BluePhoenix;

-- Cria a base de dados BluePhoenix 
CREATE DATABASE BluePhoenix;

-- Coloca a base de dados em uso
USE BluePhoenix;

-- Cria a tabela USUARIO obs: ele reconhece USER como um comando
CREATE TABLE Usuario(
	userId 	  	 INT	     		NOT NULL,
    userEmail	 VARCHAR(100)		NOT NULL,
    userName  	 VARCHAR(100)		NOT NULL,
    userPassword VARCHAR(100)		NOT NULL,
    
PRIMARY KEY (userId)    
);

-- Cria a tabela Project
CREATE TABLE Project(
	nSeq 								INT,
    projectMetrics_idProjectMetrics 	INT,
    classMetrics_idClassMetrics			INT,
    user_userId							INT,
    user_email							VARCHAR(100),
PRIMARY KEY (nSeq),
FOREIGN KEY (projectMetrics_idProjectMetrics) REFERENCES ProjectMetrics (idProjectMetrics),
FOREIGN KEY (classMetrics_idClassMetrics) REFERENCES ClassMetrics (idClassMetrics),
FOREIGN KEY (user_userId) REFERENCES Usuario (userId),
FOREIGN KEY (user_email) REFERENCES Usuario (userEmail)
);

-- Cria a tabela ProjectMetrics
CREATE TABLE ProjectMetrics(
	idProjectMetrics 	INT,
    nClass 				INT,
    nInterfaces			INT,
    nLines				INT,
	ditMax				INT,
PRIMARY KEY (idProjectMetrics)
);

-- Cria a tabela ClassMetrics
CREATE TABLE ClassMetrics (
    idClassMetrics INT,
    av_sd_nChildren INT,
    av_sd_nAttributes INT,
    av_sd_nMethods INT,
    PRIMARY KEY (idCLassMetrics)
);




