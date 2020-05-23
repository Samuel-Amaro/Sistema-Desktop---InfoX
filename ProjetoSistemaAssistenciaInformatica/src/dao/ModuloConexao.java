package dao;

/*
 * Classe de Conexão Com o Banco De Dados MySql e o banco de dados que vou usar, e os respectivos atributos,
   necessarios que o java precisa conhecer para se conectar ao banco. então aqui e tratar, tudo do banco de dados
   para o java poder conectar;
 */
//tras todas bibliotecas do sql 
import java.sql.*;

public class ModuloConexao {

//metodo responsavel por estabelecer conexão com o banco de dados
    public static Connection conector() {
        //objeto que armazenara as informações do banco de dados
        Connection conexao = null;
        //carregando o driver especifico que adicionei as libraries, no caso e proprio do mysql
        String driver = "com.mysql.cj.jdbc.Driver";
        //variaveis para armazenar informações referentes ao banco de dados
        //caminho ate o banco de dados
        String url = "jdbc:mysql://localhost:3306/db_info?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "[96284269]Ai";
        //estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            //executa arquivo do driver
            conexao = DriverManager.getConnection(url, usuario, senha);
            //vai criar a conexão e armazena ela na variavel
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
