CREATE DATABASE hyperbase;

USE hyperbase;

CREATE TABLE administradores(

)ENGINE = InnoDB;

CREATE TABLE alunos (
	idAluno INT NOT NULL AUTO_INCREMENT ,
	matricula VARCHAR(15) NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idAluno) 
)ENGINE = InnoDB;

CREATE TABLE professores (
	idProfessor INT NOT NULL AUTO_INCREMENT ,
	matricula VARCHAR(15) NOT NULL,
	login VARCHAR(50) NOT NULL ,
	senha VARCHAR(50) NOT NULL ,
	nome VARCHAR(100) NOT NULL ,
	email VARCHAR(45) NOT NULL ,
	PRIMARY KEY (idProfessor) 
)ENGINE = InnoDB;

CREATE TABLE projetos (
	idProjeto INT NOT NULL AUTO_INCREMENT ,
	titulo VARCHAR(150) NOT NULL ,
	resumo TEXT,
	numpage INT ,
	data DATE ,
	local	VARCHAR(100) ,
	publico	VARCHAR(100) ,
	ano	VARCHAR(4) NOT NULL,
	semestre VARCHAR(2) NOT NULL,
	localpdf VARCHAR(100) NOT NULL,
	PRIMARY KEY (idProjeto)
)ENGINE = InnoDB;

CREATE TABLE discente_projetos (
	idDiscentesProjeto INT NOT NULL AUTO_INCREMENT ,
	idDiscente INT NOT NULL,
	idProjeto INT NOT NULL,
	PRIMARY KEY (idDiscentesProjeto) ,
	FOREIGN KEY (idDiscente) REFERENCES alunos (idAluno) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idProjeto) REFERENCES projetos (idProjeto) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE monografias (
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

CREATE TABLE discente_monografia (
	idDiscentesMono INT NOT NULL AUTO_INCREMENT ,
	idDiscente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idDiscentesMono) ,
	FOREIGN KEY (idDiscente) REFERENCES alunos (idAluno) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE orientadores (
	idOrientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idOrientadores) ,
	FOREIGN KEY (idDocente) REFERENCES professores (idProfessor) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE coorientadores (
	idCoorientadores INT NOT NULL AUTO_INCREMENT ,
	idDocente INT NOT NULL,
	idMonografia INT NOT NULL,
	PRIMARY KEY (idCoorientadores) ,
	FOREIGN KEY (idDocente) REFERENCES professores (idProfessor) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (idMonografia) REFERENCES monografias (idMonografia) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;
  
