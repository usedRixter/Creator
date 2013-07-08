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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.Activity;
import jpa.Employee;
import jpa.Report;


public class DaoEmployee implements CRUD {
    
    private EntityManager em;
    
   public DaoEmployee(EntityManager em){
        this.em=em;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    
   @Override
   public void add(Object t ) throws SQLException {
            try {
                em.persist((Employee) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(Object t) throws SQLException {
            try {
                em.merge((Employee) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public Employee getById(Long id) throws SQLException {
           Employee t = null;
            try {
                t = em.find(Employee.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    @Override
    public List<Employee> getAll() throws SQLException {
            Query query=em.createQuery("Select a from Employee a");
            return (List<Employee>)query.getResultList();
    }
    public List<Activity> getAllActivities(Employee emp){
        Query emps=em.createQuery("Select r from Report r Where r.emps = :arg1");
        emps.setParameter("arg1", emp);
        List<Report> reps=emps.getResultList();
        List<Activity> acts=new ArrayList();
        Query q_reps;
        
        for(Report r : reps){
            q_reps=em.createQuery("Select a from Activity a Where a.report = :arg1");
            q_reps.setParameter("arg1", r);
            acts.addAll(q_reps.getResultList());
        }
        
        return acts;
    }
    @Override
    public void delete(Object t) throws SQLException {
            try {
                em.remove((Employee) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}