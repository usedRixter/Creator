/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author rixter
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;


public class Dao<T> implements CRUD<T> {
    
    private Session session;
    
    Dao(Session session){
        this.session=session;
    }
    public Session getSeesion(){
        return session;
    }
    
   @Override
   public void add(T t ) throws SQLException {
            try {
                session.save(t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(T t) throws SQLException {
            try {
                session.update(t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public T getById(Long id) throws SQLException {
           T t = null;
            try {
                t = (T) session.load(Object.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    @Override
    public List<T> getAll() throws SQLException {
            List<T> ts = new ArrayList<T>();
            try {
                ts = session.createCriteria(Object.class).list();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getAll() Failed", JOptionPane.OK_OPTION);
            }
            return ts;
    }
    @Override
    public void delete(T t) throws SQLException {
            try {
                session.delete(t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}