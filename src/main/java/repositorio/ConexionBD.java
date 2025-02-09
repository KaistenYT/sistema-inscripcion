package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public  static Connection getConexion(){

 Connection conexion = null;
 var baseDatos = "registro_atletas_db";
 var url = "jdbc:mysql://localhost:3306/"+baseDatos;

 var usuario = "root";
 var password = "Nyx7811@";

 try
 {
     Class.forName("com.mysql.cj.jdbc.Driver");
     conexion = DriverManager.getConnection(url,usuario,password);

 }catch (Exception e){
     System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
 }
return  conexion;

    }

    public static void main(String[] args) {
        var conexion = ConexionBD.getConexion();

        if(conexion != null){
            System.out.println("Conexion  exitosa: " + conexion);
        }else {
            System.out.println("Error al conectarse a la base de datos");
        }
    }



}
