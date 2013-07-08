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
import jpa.Report;


public class DaoReport implements CRUD {
    
    private EntityManager em;
    
    public DaoReport(EntityManager em){
        this.em=em;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    
   @Override
   public void add(Object t ) throws SQLException {
            try {
                em.persist((Report) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(Object t) throws SQLException {
            try {
                em.merge((Report) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public Report getById(Long id) throws SQLException {
           Report t = null;
            try {
                t = em.find(Report.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    @Override
    public List<Report> getAll() throws SQLException {
            Query query=em.createQuery("Select a from Report a");
            return (List<Report>)query.getResultList();
    }
    
    public List<Activity> getAllActivities(Report rep){
        Query emps=em.createQuery("Select a from Activity a Where a.report = :arg1");
        emps.setParameter("arg1", rep);
        return emps.getResultList();
    }
    
    @Override
    public void delete(Object t) throws SQLException {
            try {
                em.remove((Report) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}