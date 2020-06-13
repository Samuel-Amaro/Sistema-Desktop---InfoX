-- a linhas abaixo modifica a tabela Ordem Serviço, adicionando novos campos na tabela

-- adicionando o campo que vai conter o tipo de ordem de serviço
ALTER TABLE tbl_os ADD tipo_os varchar(15) NOT NULL;

-- adiconando o campo qur vai mostrar a situação do equipamento na ordem de serviço
ALTER TABLE tbl_os ADD situacao_equip VARCHAR(20) NOT NULL;