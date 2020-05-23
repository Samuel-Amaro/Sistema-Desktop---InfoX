package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/*
 * classe em que criptografa senha do usuario antes de ir para o banco de dados

*/
public class CriptografaSenha {
 //ATRIBUTO SENHA QUE VAI SER CRIPTOGRAFADA

    private String senha;

    //metodos acessores de senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //metodo estatico que criptografa uma senha usando algoritmo md5 do java security
    public static String criptografaSenhaMD5(String senha) {
        try {
            //criptografando
            MessageDigest resumeMensagem = MessageDigest.getInstance("MD5");
            //a variavel resumo da mensagem contem o algotimo de criptografia especificado
            
            //gerando o hash atraves do md5 na senha,criptografando a senha
            BigInteger hash = new BigInteger(resumeMensagem.digest(senha.getBytes()));
            //digeste(gera o hash criptografado atraves dos bytes da mensagem passada no caso a senha)
            //senha.getBytes(passa os bytes da senha para o digeste para formar o hash criptografado)
            // e no final converte tudo o hash criptografado em um numero muito grande do tipo big integer
            
            return String.format("%32x", hash);
            /*
              * no return :
              * pega o format da classe string
              * format(formatoCodificacao,oquevaisercodificado);
              *lembra de printf em c?
              * e da tabela ASC2 ?
              * lembra que na tabela todo caracter e como um numero na tebela ? tipo exemepo: 1 == a, 2 == l etc..
              * isso que vai acontecer no format:
              * vou passar um sequencia de numero bem grande que no caso e o hash formado da senha criptografada
              * e vai converte em caracteres e retorna essa sequencia de caracteres em uma string para quem chamou.
             */
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Criptografia da Senha Deu Erro -> " + e);
        }
        
        return null; //retorno nullo porque o retorno verdadeiro esta no try,esse e porque o return do try o netbens não encherga.
    }   
}
