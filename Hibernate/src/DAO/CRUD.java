/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author rixter 
 * */
public interface CRUD<T> {
    
    public void add(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public T getById(Long id) throws SQLException;
    public List<T> getAll() throws SQLException;
    public void delete(T t) throws SQLException;
    
}
