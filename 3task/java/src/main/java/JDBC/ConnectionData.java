package JDBC;

public class ConnectionData {

    /**
     * Данные для подключения к БД.
     */
    private static final String driver ="org.postgresql.Driver";
    private static final String url ="jdbc:postgresql://localhost:5432/postgres";
    private static final String userName ="postgres";
    private static final String password ="postgres123";

    public String getDriver(){
        return driver;
    }
    public String getUrl(){
        return url;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
}
