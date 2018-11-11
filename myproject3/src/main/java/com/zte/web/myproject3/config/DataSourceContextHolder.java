package com.zte.web.myproject3.config;

public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "datasource1";

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDB(String dbType) {
        System.out.println("切换到{"+dbType+"}数据源");
        contextHolder.set(dbType);
    }

    public static String getDB() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
