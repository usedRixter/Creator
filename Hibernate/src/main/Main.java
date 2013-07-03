package main;
import DAO.Dao;
import java.sql.SQLException;
import java.util.List;

import hibernate.Project;

import DAO.Factory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {
   
    public static void main(String[] args) throws SQLException {
        //Создадим два проекта
        Project s1 = new Project();
        Project s2 = new Project();
       
        //Проинициализируем их
        Dao<Project> d=Factory.getInstance().getDao();
        s1.setName("ProjDead");
        s1.setDescription("Another big description Dead");
        s2.setName("Projstd");
        s2.setDescription("Another big description std"); 
        Transaction t=d.getSeesion().beginTransaction();
        //Сохраним их в бд, id будут сгенерированы автоматически
        //Factory.getInstance().getDao().add(s1);
        //Factory.getInstance().getDao().add(s1);
        d.add(s1);
        d.add(s2);
        //Выведем все проекты из бд
        List<Project> projs = Factory.getInstance().getDao().getAll();
        t.commit();
        System.out.println("========Все проекты=========");
        for(int i = 0; i < projs.size(); ++i) {
                System.out.println("Имя проекта : " + projs.get(i).getName() +",  id : " + projs.get(i).getId());
                System.out.println("=============================");             
        }      
    }
}