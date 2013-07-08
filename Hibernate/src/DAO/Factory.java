package DAO;

import util.JPAUtil;



public class Factory {
     
      private static DaoActivity projDao = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public DaoActivity getDaoActivity(){
            if (projDao == null){
              projDao = new DaoActivity(JPAUtil.getEntityManager());
            }
            return projDao;
      }  
}