import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.Conexao;

public class Funcionario {

    int idFunc;
    String nomeFunc;
    int idDepto;
    double SalHora;

    // Inclusão de FUNCIONARIO
    public boolean incluirFuncionario() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO funcionario";
        sql += "(nomeFunc,idDepto,SalHora)";
        sql += "VALUES (?,?,?)";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getNomeFunc());
            stm.setInt(2, this.getIdDepto());
            stm.setDouble(3, this.getSalHora());
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro na inclusão do funcionario");
            return false;
        }
        return true;
    }

    // Alterar FUNCIONARIO
    public boolean alterarFuncionario() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE funcionario ";
        sql += "SET nomeFunc = ? ,idDepto = ?,SalHora = ?  ";
        sql += "WHERE idFunc = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getNomeFunc());
            stm.setInt(2, this.getIdDepto());
            stm.setDouble(3, this.getSalHora());
            stm.setInt(4, this.getIdFunc());
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro na alteração do funcionario");
            return false;
        }
        return true;
    }

    // Excluir FUNCIONARIO
    public boolean excluirFuncionario() throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM funcionario ";
        sql += "WHERE idFunc = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getIdFunc());
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro na exclusão do funcionário");
            return false;
        }
        return true;
    }

    // Listar todos os FUNCIONARIOS
    public List<Funcionario> listarFuncionarios() throws ClassNotFoundException, SQLException {
        List<Funcionario> listaFunc = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT idFunc, nomeFunc, idDepto, salHora FROM funcionario ORDER BY idFunc";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setIdFunc(rs.getInt("idFunc"));
                func.setNomeFunc(rs.getString("nomeFunc"));
                func.setIdDepto(rs.getInt("idDepto"));
                func.setSalHora(rs.getDouble("salHora"));
                listaFunc.add(func);
            }
        } catch (SQLException e) {
            System.out.println("Erro na lista de funcionários");
            return null;
        }
        return listaFunc;
    }

    // Consultar um FUNCIONARIO
    public Funcionario consultaFuncionario() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.conectar();
        Funcionario func = null;
        String sql = "SELECT nomeFunc, idDepto, salHora FROM funcionario WHERE idFunc = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getIdFunc());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                func = new Funcionario();
                func.setNomeFunc(rs.getString("nomeFunc"));
                func.setIdDepto(rs.getInt("idDepto"));
                func.setSalHora(rs.getDouble("salHora"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta do funcionário");
            return null;
        }
        return func;
    }


    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public int getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    public double getSalHora() {
        return SalHora;
    }

    public void setSalHora(double salHora) {
        SalHora = salHora;
    }
}
