package org.teamsmarteat;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class ConnectionTest extends TestCase {

    private static final Logger logger = LogManager.getLogger(ConnectionTest.class);
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
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        }
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            logger.info("Successful connection - Schema: " + schema);
            return true;
        }

        catch (Exception e) {
            logger.error(e);
            return false;
        }
    }
}

