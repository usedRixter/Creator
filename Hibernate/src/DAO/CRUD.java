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
public interface CRUD {
    
    public void add(Object t) throws SQLException;
    public void update(Object t) throws SQLException;
    public Object getById(Long id) throws SQLException;
    public List getAll() throws SQLException;
    public void delete(Object t) throws SQLException;
    
}
