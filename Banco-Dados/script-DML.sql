-- script DML do banco de dados, praticamente o CRUD
USE db_info;

-- inserido  o admi do sistema
INSERT INTO tbl_usuario(nome,telefone,login,senha) VALUES ('Administrador Sistema','99999-9999','admin','1234');

-- inserindo um usuario comun do sistema
INSERT INTO tbl_usuario(nome,telefone,login,senha,perfil) VALUES ('Samuel Amaro','99999-9999','Samuel-Amaro','1234','user comun');