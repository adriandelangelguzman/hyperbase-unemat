CREATE DATABASE vseace;

CREATE TABLE alunos (
	idAluno INT NOT NULL AUTO_INCREMENT ,
	matricula INT NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idAluno) 
)ENGINE = InnoDB;

CREATE TABLE professores (
	idProfessor INT NOT NULL AUTO_INCREMENT ,
	matricula INT NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idAluno) 
)ENGINE = InnoDB;

CREATE TABLE projetos (
	idProjeto INT NOT NULL AUTO_INCREMENT ,
	titulo VARCHAR(150) NOT NULL ,
	resumo TEXT,
	local	VARCHAR(100) ,
	publico	VARCHAR(100) ,
	ano	VARCHAR(4),
	semestre VARCHAR(2),
	palavraschave VARCHAR(100),
	localpdf VARCHAR(100),
	PRIMARY KEY (idProjeto)
)ENGINE = InnoDB;

CREATE TABLE monografias (
	idMonografia INT NOT NULL AUTO_INCREMENT ,
	titulo VARCHAR(150) NOT NULL ,
	resumo TEXT,
	abstract TEXT,
	data	DATE,
	palavraschave VARCHAR(100),
	localpdf VARCHAR(100),
	PRIMARY KEY (idMonografia)
)ENGINE = InnoDB;

CREATE TABLE autores (
	idAutores INT NOT NULL AUTO_INCREMENT ,
	idDiscente INT NOT NULL,
	idDocumento INT NOT NULL,
	PRIMARY KEY (idAutores) 
)ENGINE = InnoDB;

CREATE TABLE orientadores (
	idOrientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idProjeto INT NOT NULL,
	PRIMARY KEY (idOrientadores) 
)ENGINE = InnoDB;

CREATE TABLE coorientadores (
	idCoorientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idProjeto INT NOT NULL,
	PRIMARY KEY (idCoorientadores) 
)ENGINE = InnoDB;
  
  
  
