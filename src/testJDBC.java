

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by andrepapazoglu on 15/05/15.
 */
public class testJDBC {
    public static void main(String[] args) {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root" ;
        String senha = "";

        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println(" Abrindo conexão ... ") ;
            Connection conexao =
                    DriverManager. getConnection(stringDeConexao, usuario, senha) ;

            System.out.println(" Digite o nome da editora : ") ;
            String nome = entrada.nextLine() ;

            System.out.println(" Digite o email da editora : ") ;
            String email = entrada.nextLine() ;

            String sql = " INSERT INTO Editora ( nome , email ) " +
                    " VALUES ( ?, ?) " ;

            PreparedStatement comando = conexao.prepareStatement(sql) ;

            comando.setString(1, nome);
            comando.setString(2,email);

            System.out.println(" Executando comando ... ") ;
            comando.execute() ;

            System.out.println(" Fechando conexão ... ") ;
            conexao.close() ;
        } catch ( Exception e ) {
            e.printStackTrace() ;
        }
    }
}
