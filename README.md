# Projeto Info-X
![Logo que representa o projeto](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/logo-Projeto-Java.png)
## Objetivo Projeto
Projeto, Que envolve a criação de um sistema de emissão de ordem de serviços e emissão de relatórios para um pequena empresa de pequeno porte, 
que se trata de uma assistência técnica de microcomputadores e notebooks e periféricos ficticia,onde o gestor deseja obter controle dos serviços da empresa. 
E o administrador possa obter o controle da emissão de relatórios, de ordem de serviços executadas, ou somente feitas para orçamentos, onde cada ordem de serviço possui, um cliente vinculado, sendo que o Adm também possa o obter o relatório de clientes cadastrados.
Que pode acessar o sistema Desktop, e só o ADM ou so os funcionarios(Que vão possuir um acesso restrito, com algumas funcionalidades desativadas para eles). E um projeto que pode ter uma aplicação real, mas que por enquanto e so ficticio, para fins de aprendizado, onde requisitos e informações foram elaboradas por um professor.
## Contéudo e Material Usado Em todo o Projeto, Oriundo
 * [Curso-Completo](https://www.youtube.com/watch?v=eA4WjjkzK3c&list=PLbEOwbQR9lqxsTusvu8wfkUECrmcV81MU)
 * [Curso-Com-Certificado](https://www.aulaead.com/)
## Informações e Requisitos Do Projeto
 * [Documentação Completa do Projeto](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/tree/master/Documentacao/Levantamento-Requisistos)
 * [Modelo Banco Dados a Ser Implementado](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/Banco-Dados/Banco-Dados-MER-MYSQL.pdf)
### Tecnologias(Ferramentas Usadas) Na Implementação Do Projeto e Codificação
 * Linguagem Java 
 * Banco Dados - MySQL
 * IDE - Netbeans 11.0
 * SGBD - My-SQL-Workbench 8.0
 * API Swing( GUI - interface de Usuário Gráfica)
 * API [Driver de Conexão com o banco de dados](https://dev.mysql.com/downloads/connector/j/5.1.html)
 * Conectando o Sistema Com o Banco de dados usando(usando a DriverManager interface JDBC 8.0.20)
 #### Frameworks Compativeis Com o Java Usados No Projetos
 * [API usada para poder elaborar uma pesquisa avançada de clientes no sistema](https://sourceforge.net/projects/finalangelsanddemons/)
 * [API usada para poder emitir Relatórios Dinamicos Diretamente do banco de dados Vinculado ao Projeto](https://sourceforge.net/projects/ireport/)
 * [Para Saber Mais Sobre o Framework Java Ireport 5.6.0](https://community.jaspersoft.com/project/ireport-designer)
 ##### Ferramentas Externas Usadas
 * [para modelagem relacional do banco dados](https://app.diagrams.net/)
 * [Balsamiq Wireframes](https://balsamiq.com/wireframes/) (para prototipação de Window)
 * [Site Para baixar icones dos componentes do projeto](https://www.iconfinder.com/)

### Prototipagem das Telas
* **COMO SE AUTENTICAR(ENTRAR NO SISTEMA) E SAIR DO SISTEMA**
  * Preview que demostra ao usuario como e a interface de Login e a interface principal do sistema, mostrando as funções principais do sistema, onde acessalas, e como sair do sistema;
  * Mostrando como um ***USUARIO COM PERFIL ADMIN pode se autenticar;***
  * Existe dois tipos de acessos no sistema;
    1. Usuarios que possui Perfil ADMIN(Tem todas funcionalidades do sistema liberada para ele);
    1. Usuarios que Possui Perfil USER(algumas funcionalidades são restritas a esse perfil);
   
   
![Tela Login](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-login-tela-princiapal.gif)  
* **PREVIEW CLIENTES - DEMOSTRANDO COMO PODE SE UTLIZAR UM CLIENTE NO SISTEMA**
  * Como se cadastrar um novo cliente, como se altera o cadastro de um cliente, e como excluir um cliente do sistema;


![Tela Principal](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-crud-clientes.gif)
* **PREVIEW USUARIO - DESMOTRANDO COMO UTILIZAR AS FUNCIONALIDADES DE UM USUARIO NO SISTEMA**
  * Um Usuario logado Com permissão perfil de ADMIN pode cadastrar,alterar,excluir outros usuarios no sistema;
  * Um usuario com perfil de USER tem funcionalidades de Alteração,cadastro,exclusão de outros usuarios inibidas;


![Tela Usuarios](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-crud-usuarios.gif)
* **PREVIEW ORDEM SERVIÇO - DEMOSTRANDO COMO SE USA AS FUNCIONALIDADES DA INTERFACE DE ORDEM DE SERVIÇO NO SISTEMA**
  1. Abaixo segue como se cadastra um nova ordem de serviço ou orçamento, tudo pode ser configurado antes de se cadastrar o novo item no sistema;


  ![Tela Usuarios](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-insert-os.gif)
  1. Abaixo segue como pode se buscar uma ordem de serviço ou um orçamento cadastrado no sistema, e fazer uma alteração de uma informação, e manter atualiada!


  ![Tela Relatorios](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-update-os.gif)
  1. Abaixo segue como se busca uma ordem de serviço ou orçamento, e como fazer a impressão desse item, em papel fisico A4;


  ![Tela Relatorios Cliente](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-imprimindo-os.gif)
* **PREVIEW RELATÓRIO - DEMOSTRANDO COMO UM USUARIO COM PERFIL ADMIN PODE OBTER INFORMAÇÕES DO SISTEMA, EMITINDO RELATORIOS DINAMICOS**
  * Somente usuario com perfil ADMIN, pode ter acesso a essa funcionalidade, onde ele consegue imprimir um relatorio dinamico, do banco de dados com informações atualizadas, de   todos os clientes que seu seguimento comercial possui, dentro do sistema. Ao final pode se obter a impressão desse relatorio;


![Tela Sobre](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/blob/master/previews-gif-software/preview-imprimindo-relatorios-clientes.gif)
* **PREVIEW RELATÓRIO - DESMOSTRANDO COMO UM USUARIO COM PERFIL ADMIN, PODE OBTER INFORMAÇÕES DO SISTEMA, EMITINDO RELATORIOS DINAMICOS**
  * Somente usuario Logado e com perfil ADMIN, tem acesso a essa funcionalidade, de emitir um relatorio dinamico diretamente do banco de dados, de quantas ordem serviços ou       orçamentos ja emitiu, durante a existencia do sistema, no final pode se imprimir em um papel A4.


### Arquivo .jar do projeto para costrui um EXE para Windows e para Outras Plataformas, Multiplataforme
 * [.jar](https://github.com/Samuel-Amaro/Sistema-Desktop---InfoX/tree/master/ProjetoSistemaAssistenciaInformatica/dist)
