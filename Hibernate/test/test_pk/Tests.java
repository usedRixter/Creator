/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_pk;

import DAO.DaoActivity;
import DAO.Factory;
import jpa.Project;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rixter
 */
public class Tests {
    static Project p1;
    static Project p2;
    static DaoActivity<Project> dao;
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        p1 = new Project();
        p2 = new Project();
        p1.setName("ProjDead");
        p1.setDescription("Another big description Dead");
        p2.setName("Projstd");
        p2.setDescription("Another big description std"); 
        dao=Factory.getInstance().getDao();
    }
    
    @AfterClass
    public static void tearDownClass(){
        dao.getSeesion().close();
    }
    
    @Test
    public void test_add() throws SQLException{           
        dao.add(p1);

    }
    
    @Test
    public void test_print() throws SQLException{
        List<Project> projs = Factory.getInstance().getDao().getAll();
        assertFalse(projs==null);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}