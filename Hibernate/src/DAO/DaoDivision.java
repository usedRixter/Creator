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
import jpa.Division;
import jpa.Employee;


public class DaoDivision implements CRUD {
    
    private EntityManager em;
    
    public DaoDivision(EntityManager em){
        this.em=em;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    
   @Override
   public void add(Object t ) throws SQLException {
            try {
                em.persist((Division) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "add() Failed", JOptionPane.OK_OPTION);
            }
    }
    
   @Override
    public void update(Object t) throws SQLException {
            try {
                em.merge((Division) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "update() Failed", JOptionPane.OK_OPTION);
            }
    }
    @Override
    public Division getById(Long id) throws SQLException {
           Division t = null;
            try {
                t = em.find(Division.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "getById() Failed", JOptionPane.OK_OPTION);
            }
            return t;
    }
    public List<Employee> getAllEmps(Division d){
        Query emps=em.createQuery("Select e from Employee e Where e.divs = :arg1");
        emps.setParameter("arg1", d);
        return emps.getResultList();
    }
    @Override
    public List<Division> getAll() throws SQLException {
            Query query=em.createQuery("Select a from Division a");
            return (List<Division>)query.getResultList();
    }
    
    @Override
    public void delete(Object t) throws SQLException {
            try {
                em.remove((Division) t);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "delete() Failed", JOptionPane.OK_OPTION);
            }
    }


}