package main;
import java.sql.SQLException;
import java.util.List;

import hibernate.Project;

import DAO.Factory;

public class Main {
   
    public static void main(String[] args) throws SQLException {
        //Создадим два проекта
        Project s1 = new Project();
        Project s2 = new Project();
       
        //Проинициализируем их
        s1.setName("ProjDead");
        s1.setDescription("Another big description Dead");
        s2.setName("Projstd");
        s2.setDescription("Another big description std");     
        //Сохраним их в бд, id будут сгенерированы автоматически
        Factory.getInstance().getDao().add(s1);
        Factory.getInstance().getDao().add(s1);
        //Выведем все проекты из бд
        List<Project> projs = Factory.getInstance().getDao().getAll();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < projs.size(); ++i) {
                System.out.println("Имя студента : " + projs.get(i).getName() +",  id : " + projs.get(i).getId());
                System.out.println("=============================");             
        }      
    }
}