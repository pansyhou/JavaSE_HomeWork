package jdbc;



import java.sql.*;

public class Comprehension1 {
    private Connection con=null;
    private Statement stat=null;
    private ResultSet rs = null;

    void getConnection(String url, String username,String ps) {//数据库连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, ps);
            stat=con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    void query() {//默认查询
        query("select * from person");
    }

    void query(String sqlstatement) {
        try {
            rs = stat.executeQuery(sqlstatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                System.out.println(" "+rs.getInt("ID")+" "+rs.getString("Name")+" "+rs.getString("Email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insert() {
        String sqlStatament="insert into person(name,password,email,birthday)"
                +"value('zs','123','zs@','1920-12-12')";
        insert(sqlStatament);
    }
    void insert(String s) {
        try {
            stat.executeUpdate(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("添加数据后的信息为：");
        query();

    }

    void delete() {
        delete("DELETE FROM person WHERE Name='zs'");

    }

    void delete(String s) {
        try {
            stat.executeUpdate(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("删除数据后的信息为：");
        query();
    }

    void update() {
        update("UPDATE person SET Name='ls' WHERE Name='zs'");
    }

    void update(String s) {
        try {
            stat.executeUpdate(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query();
    }

    public static void main(String[] args) {
        Comprehension1 c = new Comprehension1();
        c.getConnection("jdbc:mysql://localhost:3306/Persons","root","1230123");
        c.query();
        c.insert();
        c.query();
    }

}
