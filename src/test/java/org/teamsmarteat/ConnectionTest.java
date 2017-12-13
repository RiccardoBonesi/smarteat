package org.teamsmarteat;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class ConnectionTest extends TestCase {

    public void testConnection() throws Exception {
        assertTrue(connectDB());
    }

    private boolean connectDB () {
        String hostName = "smarteat-server.database.windows.net";
        String dbName = "smarteatdb";
        String user = "lars";
        String password = "BananaU24";

        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            return true;
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

