package com.example.adswarehousesem2;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.sql.*;

/**
 * The OracleDatabaseBean helps the oracle client to be connected with
 * the oracle database which can be used by stateless session beans to
 * get data and return it back to related jsp files.
 */
@Singleton(name = "OracleDatabaseEJB")
public class OracleDatabaseBean {

    final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String DB_USER = "gusto30";
    final static String DB_PASSWORD = "gusto30";

    public OracleDatabaseBean() {
    }

    private Connection oracleClient = null;

    @Lock(LockType.READ)
    public Connection getOracleClient() { return oracleClient; }

    @PostConstruct
    public void init()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            oracleClient = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            if(oracleClient != null)
            {
                System.out.println("****************************************8");
                System.out.println("Oracle Cloud DB Connection is Success!");

            }
            else{
                System.out.println("****************************************8");
                System.out.println("Oracle Cloud DB Connection is fail!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
