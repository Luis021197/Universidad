/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.AlumnoDAO;
import conexion.conexion;
import datos.Alumnos;

/**
 *
 * @author Luis Sotelo
 */
public class test {
        public static void main (String[] args){
            conexion.getInstance();
            Alumnos alumno = new Alumnos();
            alumno.setCodigo("P0010");
            alumno.setNombre("Roger");
            alumno.setApellido("Martinez");
            alumno.setCorreo("martinez@hotmail.com");
            alumno.setDni("78542361");
            alumno.setDireccion("los santos");
            alumno.setCarrera("contabilidad");
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            if(alumnoDAO.insert(alumno)){
                System.out.println("Se insertaron correctamente los datos");
            }else{
                System.err.println("No se insertaron los datos");
            }
        }
}
