package DAO;

import util.HibernateUtil;



public class Factory {
     
      private static Dao projDao = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public Dao getDao(){
            if (projDao == null){
              projDao = new Dao(HibernateUtil.getSessionFactory().openSession());
            }
            return projDao;
      }  
}