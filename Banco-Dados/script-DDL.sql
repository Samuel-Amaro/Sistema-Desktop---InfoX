-- Script Sql Do Banco de Dados e das Suas Tabelas

-- Criando Banco de dados
CREATE DATABASE db_info;

USE db_info;

-- Criando Tabela usuario, dos funcionarios da assistencia, aqueles que tem permissão de usar o sistema
CREATE TABLE tbl_usuario(id_user int primary key auto_increment,
                         nome varchar(50) not null,
                         telefone varchar(15),
                         login varchar(30) unique not null,
                         senha varchar(30) not null
                         );
                         
-- alterando o tamanho do campo senha
ALTER TABLE tbl_usuario MODIFY senha varchar(200) not null;   
                      
-- Criando Tabela dos Clientes da assistencia tecnica
CREATE TABLE tbl_clientes(id_cliente int primary key auto_increment,
						  nome varchar(50) not null,
                          referencia_endereco varchar(200),
                          cep varchar(11),
                          cidade varchar(50),
                          estado varchar(50),
                          telefone varchar(15) not null,
                          email varchar(30) 
                          );
                          
-- Criando Tabela de ordem de serviço, onde vai ser armazenada as ordens de serviço 
CREATE TABLE tbl_os (
    id_os INT PRIMARY KEY AUTO_INCREMENT,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    equipamento VARCHAR(150) NOT NULL,
    problema VARCHAR(200) NOT NULL,
    descricao VARCHAR(300),
    tecnico VARCHAR(30),
    valor DECIMAL(10 , 2 ),
    id_cliente INT NOT NULL
);
                    
-- CRIANDO O RELACIONAMENTO ENTRE A TABELA CLIENTE E OS
-- um CLIENTE PODE contratar varios serviços, mas um serviço so possui um cliente
ALTER TABLE tbl_os ADD CONSTRAINT fk_cliente FOREIGN KEY(id_cliente) REFERENCES tbl_clientes(id_cliente);


-- adicionando um novo campo na tabela usuarios
USE db_info;
ALTER TABLE tbl_usuario ADD COLUMN perfil varchar(20) not null;

-- vendo se deu certo
DESCRIBE tbl_usuario;

SELECT * FROM tbl_usuario;

-- acrecentando nos usuarios existenetes um perfil
UPDATE tbl_usuario SET perfil = 'admin' WHERE id_user = 1;


