/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.AlumnoDAO;
import datos.Alumnos;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Luis Sotelo
 */
@WebService(serviceName = "AlumnosCRUD")
public class AlumnosCRUD {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Listar")
    public ArrayList<Alumnos> Listar(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.selectAll();
    }
    
    @WebMethod(operationName = "Insertar")
    public Boolean Insertar(@WebParam(name = "codigo") String codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "correo") String correo, @WebParam(name = "dni") String dni, @WebParam(name = "direccion") String direccion, @WebParam(name = "carrera") String carrera) {
        //TODO write your implementation code here:
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        if(alumnoDAO.insertWs(codigo, nombre, apellido, correo, dni, direccion, carrera)){
            return true;
        }else{
            return false;
        }
    }
    
    @WebMethod(operationName = "Actualizar")
    public Boolean Actualizar(@WebParam(name = "codigo") String codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "correo") String correo, @WebParam(name = "dni") String dni, @WebParam(name = "direccion") String direccion, @WebParam(name = "carrera") String carrera) {
        //TODO write your implementation code here:
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        
        //se usa null para que no llegue null al médoto UpdateWS
            if (nombre==null){
                nombre="";
            }
            if (apellido==null){
                apellido="";
            }
            if (correo==null){
                correo="";
            }
            if (dni==null){
                dni="";
            }
            if (direccion==null){
                direccion="";
            }
            if (carrera==null){
                carrera="";
            }

        return alumnoDAO.updateWs(codigo, nombre, apellido, correo, dni, direccion, carrera);
    }
    
    @WebMethod(operationName = "Eliminar")
    public Boolean EliminarWs(@WebParam(name ="codigo") String codigo){
         AlumnoDAO alumnoDAO = new AlumnoDAO();
         return alumnoDAO.deleteWs(codigo);
    }
}
