package Utils;
import java.sql.Connection;
import java.sql.SQLException;

public class testeconexao {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            System.out.println("deu certo");
        }
        catch (SQLException erro){
            System.out.println("não deu certo:" + erro);
        }
    }
}
