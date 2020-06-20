-- script para mostrar como vai funcionar os relatorios do banco de dados usando o framework java ireport

USE db_info;
-- consulta que vai ajudar a gerar o relatorio
-- criando um relatorio do banco de dados, usando um exemplo: criando relatorio mostrando todos clinetes cadastrados.
-- 1 passo para criar relatorios do banco de dados
-- uma consulta que traz todos clientes, mas que venha todos os clientes ordenados, por nome em ordem alfabetica.
SELECT * FROM tbl_clientes ORDER BY nome;

-- consulta que vai ajudar a gerar relatorio
-- criando relatório agora de duas tabelas, isso e vai mostrar dados da tabela OS e Clientes ao mesmo tempo em um mesmo relatorio, vai ser um relatorio completo
-- a linha abaixo, com o bloco de istruções faz a seleção e união de dados de duas ou mais tabelas
-- usando o join, vai trazer as OS e seus respectivos clientes, mas vai trazer so um resumo não todos os campos
SELECT OS.id_os,OS.data_hora,OS.equipamento,OS.problema,OS.valor,OS.tipo_os,CLI.Nome_Cliente,CLI.telefone_Cliente,CLI.email_Cliente 
FROM tbl_os AS OS INNER JOIN tbl_clientes AS CLI
ON OS.id_cliente = CLI.id_cliente;