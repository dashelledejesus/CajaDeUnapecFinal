/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Character.UnicodeScript.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try {
  String connectionUrl = "jdbc:derby://localhost:1527/CajadelUnapec//;database=Cajadelunapec;integratedSecurity=true;";
  con = DriverManager.getConnection(connectionUrl);
  System.out.println("Conectado.");
} 
catch (SQLException e) 
{
  System.out.println("Error.");
}
        return con;
    }
}
