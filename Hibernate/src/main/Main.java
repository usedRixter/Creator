package main;
import DAO.DaoActivity;
import DAO.DaoDivision;
import DAO.DaoEmployee;
import DAO.DaoReport;
import java.sql.SQLException;
import java.util.List;

import jpa.Project;

import DAO.Factory;
import java.util.Collection;
import javax.persistence.EntityManager;
import jpa.Activity;
import jpa.Division;
import jpa.Employee;
import jpa.Report;
import util.JPAUtil;

public class Main {
   
    public static void main(String[] args) throws SQLException {
        EntityManager em=JPAUtil.getEntityManager();
        DaoDivision dd=new DaoDivision(em);
        DaoEmployee de=new DaoEmployee(em);
        DaoReport dr=new DaoReport(em);
        DaoActivity da=new DaoActivity(em);
        
        Division d1=new Division();
        Division d2=new Division();
        Employee e1=new Employee();
        Employee e2=new Employee();
        Activity a1=new Activity();
        Activity a2=new Activity();
        Report r1=new Report();
        Report r2=new Report();
        
        ///////////////////////////
        em.getTransaction().begin();
        
        a1.setAct_name("New Activity1");
        a2.setAct_name("New Activity2");
        
        r1.setBug_id(new Long(132));
        r2.setBug_id(new Long(133));
        
        a1.setReport(r1);
        a1.setReport(r2);
        a2.setReport(r1);
        a2.setReport(r2);
        r1.setEmps(e1);
        r2.setEmps(e1);
        
        d1.setName("div1");
        
        e1.setId(new Long(1));
        e1.setName("Ivan");
        e1.setPassword("223344");
        e1.setDivs(d1);
        
        
        
        e2.setId(new Long(2));
        e2.setName("IvanIvan");
        e2.setPassword("223344");
        e2.setDivs(d1);
        
        dr.add(r1);
        dr.add(r2);
        da.add(a1);
        da.add(a2);
        dd.add(d1);
        de.add(e1);
        de.add(e2);
        
        em.getTransaction().commit();
        em.getTransaction().begin();
        List<Activity> emps=de.getAllActivities(e1);
        em.getTransaction().commit();
        
        System.out.println("========Все проекты=========");        
        for(Activity e : emps) System.out.println(e.getAct_name());
       /* for(int i = 0; i < emps.size(); ++i) {
                System.out.println("Имя проекта : " + emps.get(i).getName() +",  id : " + emps.get(i).getId());
                System.out.println("=============================");             
        }  */    
    }
}