package com.my.common.listener;


import com.my.common.modules.cache.CacheFacade;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

/**
 * Created by conan on 2017/5/24.
 */
public class ContextDestroyListener implements ServletContextListener{
    private static Logger logger = Logger.getLogger(ContextDestroyListener.class);

    public static final List<String> MANUAL_DESTROY_THREAD_IDENTIFIERS = Arrays.asList("Memcached", "QuartzScheduler", "scheduler_Worker", "Okio Watchdog", "OkHttp ConnectionPool", "Abandoned connection cleanup thread");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Ignore
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        CacheFacade.shutdown();
        destroyJDBCDrivers();
        destroySpecifyThreads();
    }

    private void destroySpecifyThreads() {
        final Set<Thread> threads = Thread.getAllStackTraces().keySet();
        for (Thread thread : threads) {
            if (needManualDestroy(thread)) {
                synchronized (this) {
                    try {
                        thread.stop();
                        logger.warn(String.format("Destroy  %s successful", thread));
                    } catch (Exception e) {
                        logger.warn(String.format("Destroy %s error", thread), e);
                    }
                }
            }
        }
    }

    private boolean needManualDestroy(Thread thread) {
        final String threadName = thread.getName();
        for (String manualDestroyThreadIdentifier : MANUAL_DESTROY_THREAD_IDENTIFIERS) {
            if (threadName.toLowerCase().contains(manualDestroyThreadIdentifier.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private void destroyJDBCDrivers() {
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver;
        while (drivers.hasMoreElements()) {
            driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                logger.warn(String.format("Deregister JDBC driver %s successful", driver));
            } catch (SQLException e) {
                logger.warn(String.format("Deregister JDBC driver %s error", driver), e);
            }
        }
    }
}
