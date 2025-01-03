import java.sql.Connection;
import java.sql.DriverManager;

public class LinkDatabase {
    public static Connection getConnection() {
        // TODO Auto-generated method stub
        String driverName="com.mysql.cj.jdbc.Driver";

        String dbURL="jdbc:mysql:///order management system";
        //账户
        String userName="root";
        //密码
        String userPwd="123456";
        Connection conn=null;
        try {
            Class.forName(driverName);
            conn= DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("数据库连接成功");
        }catch(Exception e) {
            System.out.println("数据库连接失败");
        }
        return conn;
    }
}

