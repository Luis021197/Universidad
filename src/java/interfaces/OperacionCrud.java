/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datos.Alumnos;
import java.util.ArrayList;

/**
 *
 * @author Luis Sotelo
 */
public interface OperacionCrud <T> {
    public abstract Boolean insert(T t);
    public abstract Boolean update(T t);
    public abstract Boolean delete(Object id);
    public abstract Alumnos selectById(String id);
    public abstract ArrayList<T> selectAll();  
}
