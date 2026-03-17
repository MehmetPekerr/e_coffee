package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * 
 */
public class DBConnect {
     private Connection connect;
     public Connection getConnect() {
        if(this.connect==null){

            try{
                
                Class.forName("org.postgresql.Driver");
                
                this.connect=DriverManager.getConnection("jdbc:postgresql://localhost:5432/e_coffee","postgres","mpfb1907");
                
            }catch(ClassNotFoundException | SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }
}