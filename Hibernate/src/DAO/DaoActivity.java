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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.Activity;


public class DaoActivity implements CRUD {
    
    private EntityManager em;
    
   public DaoActivity(EntityManager em){
        this.em=em;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    
   @Override
   public void add(Object t ) throws SQLException {
            try {
                em.persist((Activity) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(Object t) throws SQLException {
            try {
                em.merge((Activity) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public Activity getById(Long id) throws SQLException {
           Activity t = null;
            try {
                t = em.find(Activity.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    @Override
    public List<Activity> getAll() throws SQLException {
            Query query=em.createQuery("Select a from Activity a");
            return (List<Activity>)query.getResultList();
    }
    
    @Override
    public void delete(Object t) throws SQLException {
            try {
                em.remove((Activity) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}