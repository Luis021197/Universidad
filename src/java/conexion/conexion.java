/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luis Sotelo
 */
public class conexion {
    private static conexion instance = null;
    private static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";        
    private conexion(){
        try{
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection (URL, USER, PASS);
            System.out.println("Conectado Correctamente");
        }catch(Exception e){
            System.out.println("Error en la conexion :" +e.getLocalizedMessage());
        }
    }
    
    public synchronized static conexion getInstance(){
        if(instance == null){
            instance = new conexion();
        }
        return instance;
    }
      
    public Connection getConnection(){
        return con; 
    }
    
    public void closeConnection(){
        instance = null;
    }
    
}
