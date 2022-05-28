package jdbc;

import java.sql.*;

public class testForJDBS {
    public static void main(String[] args) {
        new testForJDBS().getDatabase();
    }

    public Connection getDatabase() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); //加载数据库驱动 这个路径下的静态代码会被执行
//
//            String url = "jdbc:mysql://localhost/MySQL";//设置数据库的地址 设置编码  支持汉字
//            String user="root";//用户名
//            String password = "1230123";//用户密码
//            Connection conn = DriverManager.getConnection(url, user, password);//使用mysql驱动当中的连接数据库的API
//
//            //执行SQL语句的步骤
//            //第一步
//            Statement stat = conn.createStatement();
//            //第二步
//            String command = "select * from orders";
//            //第三步
//            ResultSet result =  stat.executeQuery(command);
//
//            //按行读取查询结果当中的数据
//            while(result.next()) {
//                //使用访问器方法获取信息
//                System.out.println(result.getString(1) + " " +  result.getString(2) + " " + result.getString(3) );
//            }
//            result.close();
//            return conn;
//        }
//        catch(Exception e) {
//            e.printStackTrace();//异常处理
//            return null;
//        }
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/MySQL";

        //  Database credentials -- 数据库名和密码自己修改
        String USER = "root";
        String PASS = "1230123";


        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");


        return conn;
    }
}
