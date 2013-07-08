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
import jpa.Project;


public class DaoProject implements CRUD {
    
    private EntityManager em;
    
   public DaoProject(EntityManager em){
        this.em=em;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    
   @Override
   public void add(Object t ) throws SQLException {
            try {
                em.persist((Project) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(Object t) throws SQLException {
            try {
                em.merge((Project) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public Project getById(Long id) throws SQLException {
           Project t = null;
            try {
                t = em.find(Project.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    @Override
    public List<Project> getAll() throws SQLException {
            Query query=em.createQuery("Select a from Project a");
            return (List<Project>)query.getResultList();
    }
    
    @Override
    public void delete(Object t) throws SQLException {
            try {
                em.remove((Project) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}