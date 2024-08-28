package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() throws SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/controlefuncionario";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco: " + ex.getMessage());
        }
        return con;
    }
}
