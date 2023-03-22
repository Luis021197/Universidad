/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.xml.ws.util.StringUtils;
import conexion.conexion;
import datos.Alumnos;
import interfaces.OperacionCrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis Sotelo
 */
public class AlumnoDAO implements OperacionCrud<Alumnos>{
    private static ResultSet res = null;
    private static PreparedStatement pstm = null;
    private static conexion con = null;
    public AlumnoDAO(){
        con = conexion.getInstance();        
    }
    
        public Boolean insertWs(String codigo, String nombre, String apellido, String correo, String dni, String direccion, String carrera){
        Boolean result = false;
        final String SQL_INSERT = "insert into alumno values(?,?,?,?,?,?,?)";
        try{
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, codigo);
            pstm.setString(2, nombre);
            pstm.setString(3, apellido);
            pstm.setString(4, correo);
            pstm.setString(5, dni);
            pstm.setString(6, direccion);
            pstm.setString(7, carrera);
            int resultInsert = pstm.executeUpdate();
            if(resultInsert > 0){
                result = true;
            }
        }catch (Exception e){
            System.out.println("Error al insertar alumno: "+e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    } 

    @Override
    public Boolean insert(Alumnos alumno) {
        Boolean result = false;
         final String SQL_INSERT = "insert into alumno values(?,?,?,?,?,?,?)";
         try{
             pstm = con.getConnection().prepareStatement(SQL_INSERT);
             pstm.setString(1, alumno.getCodigo());
             pstm.setString(2, alumno.getNombre());
             pstm.setString(3, alumno.getApellido());
             pstm.setString(4, alumno.getCorreo());
             pstm.setString(5, alumno.getDni());
             pstm.setString(6, alumno.getDireccion());
             pstm.setString(7, alumno.getCarrera());
             int resultInsert = pstm.executeUpdate();
             if(resultInsert > 0){
                 result = true;
             }
         }catch(Exception e){
             System.out.println("Error al insertar alumno :" + e.getMessage());
             e.printStackTrace();
         } finally {
             closeConnection();
         }
         return result;
    }
    
    public Boolean updateWs(String codigo, String nombre, String apellido, String correo, String dni, String direccion, String carrera){
        Boolean result = false;
        final String SQL_UPDATE = "update alumno set nombre=?, apellido=?, correo=?, dni=?, direccion=?, carrera=? where codigo=?";
        
        try{
            Alumnos alumno = selectById(codigo);
            //length se usa para contar la cantidad de caracteres
            if (nombre.length()>0){
                alumno.setNombre(nombre);
            }
            if (apellido.length()>0){
                alumno.setApellido(apellido);
            }
            if (correo.length()>0){
                alumno.setCorreo(correo);
            }
            if (dni.length()>0){
                alumno.setDni(dni);
            }
            if (direccion.length()>0){
                alumno.setDireccion(direccion);
            }
            if (carrera.length()>0){
                alumno.setCarrera(carrera);
            }
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, alumno.getNombre());
            pstm.setString(2, alumno.getApellido());
            pstm.setString(3, alumno.getCorreo());
            pstm.setString(4, alumno.getDni());
            pstm.setString(5, alumno.getDireccion());
            pstm.setString(6, alumno.getCarrera());
            pstm.setString(7, codigo);
            int resultUpdate = pstm.executeUpdate();
            if(resultUpdate > 0){
                result = true;
            }
        }catch (SQLException e){
            System.out.println("Error al actualizar: "+e.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Boolean update(Alumnos t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean deleteWs(String codigo){
        Boolean result = false;
        final String SQL_DELETE = "delete from alumno where codigo=?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_DELETE);
            pstm.setString(1, codigo);
            int resultDelete = pstm.executeUpdate();
            if (resultDelete > 0){
                result = true;
            }
        }catch(Exception e){
            System.out.println("Error al eliminar: " + e.getMessage());
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    @Override
    public Boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumnos selectById(String id) {
        Alumnos alumno = new Alumnos();
        final String SQL_SELECTBYID = "select * from alumno where codigo= ?";
        
        
        try{
           pstm = con.getConnection().prepareStatement(SQL_SELECTBYID);
           pstm.setString(1, id);
           res = pstm.executeQuery();
           while(res.next()){
               alumno.setCodigo(res.getString("codigo"));
               alumno.setNombre(res.getString("nombre"));
               alumno.setApellido(res.getString("apellido"));
               alumno.setCorreo(res.getString("correo"));
               alumno.setDni(res.getString("dni"));
               alumno.setDireccion(res.getString("direccion")); 
               alumno.setCarrera(res.getString("carrera"));
           }
                
        }catch(Exception e){
            System.out.println("Error al seleccionar: " +e.getMessage());
        }finally{
            closeConnection();
        }
        return alumno;
    
    }

    @Override
    public ArrayList<Alumnos> selectAll() {
        ArrayList<Alumnos> alumnos = new ArrayList<>();
        final String SQL_SELECTALL = "select * from alumno";
        try{
           pstm = con.getConnection().prepareStatement(SQL_SELECTALL);
           res = pstm.executeQuery();
           while(res.next()){
               Alumnos alumno = new Alumnos();
               alumno.setCodigo(res.getString("codigo"));
               alumno.setNombre(res.getString("nombre"));
               alumno.setApellido(res.getString("apellido"));
               alumno.setCorreo(res.getString("correo"));
               alumno.setDni(res.getString("dni"));
               alumno.setDireccion(res.getString("direccion"));
               alumno.setCarrera(res.getString("carrera"));
               alumnos.add(alumno);
           }
        }catch(Exception e){
            System.out.println("Error al seleccionar: " +e.getMessage());
        }finally{
            closeConnection();
        }
        return alumnos;
    }

    private void closeConnection() {
        try{
            if(res != null){
                res.close();
            }
            if(pstm !=null){
                pstm.close();
            }
            if(con != null){
                con.closeConnection();
            }
        }catch(Exception e){
            System.out.println("Error al cerrar: "+e.getMessage());
        }
    }

}
    

        
