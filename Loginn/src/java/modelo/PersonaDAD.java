
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class PersonaDAD implements validar {
Connection con;
Connection cn=(Connection) new Conexion();
PreparedStatement ps;
ResultSet rs;
int r = 0;

    @Override
    public int validar(persona per) {
    String sql="Select * from persona where Nombres=? and correo=? and contraseña=?";
    
    try{
  
    ps=con.prepareStatement(sql);
    ps.setString(1, per.getNom());
     ps.setString(1, per.getcorreo());
      ps.setString(3, per.getcontraseña());
    rs=ps.executeQuery();
    while(rs.next()){
        r += 1;
        per.setNom(rs.getString("NOMBRE_REGISTRO"));
        per.setcorreo(rs.getString("EMAIL"));
        per.setcontraseña(rs.getString("PSSWD"));
        
    } 
     if(r==1){
            return 1;
        }else
        {
            return  0;
        }
       
    } catch (SQLException ex) {
        Logger.getLogger(PersonaDAD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return 0;
    }}