CREATE DATABASE IF NOT EXISTS hyperbase;

USE hyperbase;

CREATE TABLE  IF NOT EXISTS administradores(
	idAdministrador INT NOT NULL AUTO_INCREMENT ,
	login VARCHAR(100) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idAdministrador)
) ENGINE=InnoDB;

CREATE TABLE  IF NOT EXISTS alunos (
	idAluno INT NOT NULL AUTO_INCREMENT ,
	matricula VARCHAR(15) NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idAluno) 
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS professores (
	idProfessor INT NOT NULL AUTO_INCREMENT ,
	matricula VARCHAR(15) NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idProfessor) 
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS projetos (
	idProjeto INT NOT NULL AUTO_INCREMENT ,
	titulo VARCHAR(250) NOT NULL ,
	local	VARCHAR(200) ,
	publico	VARCHAR(200) ,
	ano	INT,
	semestre INT ,
	localpdf VARCHAR(200) ,
	PRIMARY KEY (idProjeto)
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS discente_projetos (
	idDiscentesProjeto INT NOT NULL AUTO_INCREMENT ,
	idDiscente INT NOT NULL,
	idProjeto INT NOT NULL,
	PRIMARY KEY (idDiscentesProjeto) ,
	FOREIGN KEY (idDiscente) REFERENCES alunos (idAluno) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idProjeto) REFERENCES projetos (idProjeto) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS monografias (
	idMonografia INT NOT NULL AUTO_INCREMENT ,
	titulo VARCHAR(150) NOT NULL ,
	resumo TEXT,
	abstract TEXT,
	numpage INT,
	data DATE,
	palavraschave VARCHAR(100),
	localpdf VARCHAR(100),
	PRIMARY KEY (idMonografia)
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS discente_monografia (
	idDiscentesMono INT NOT NULL AUTO_INCREMENT ,
	idDiscente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idDiscentesMono) ,
	FOREIGN KEY (idDiscente) REFERENCES alunos (idAluno) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS orientadores (
	idOrientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idOrientadores) ,
	FOREIGN KEY (idDocente) REFERENCES professores (idProfessor) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS coorientadores (
	idCoorientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idCoorientadores) ,
	FOREIGN KEY (idDocente) REFERENCES professores (idProfessor) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;
  
