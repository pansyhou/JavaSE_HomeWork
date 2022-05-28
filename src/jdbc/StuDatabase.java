package jdbc;

import java.sql.*;
import java.util.Scanner;

public class StuDatabase {

    class Student {
        private int sno;
        private String name;
        private String sex;
        private int age = 0;
        private String address = null;
        private String tel = null;
        private int ClassNum;
    }

    class Class_table {
        private int class_no;
        private String class_name;
        private int sum;
    }

    private Connection con = null;
    private Statement stat = null;
    private ResultSet rs = null;


        //数据库连接
     void Connected (String url, String username, String ps) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, ps);
            stat = con.createStatement();
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加学生
    public void add() throws SQLException {
        Student stu = new Student();
        if (stat == null) {
            System.out.println("数据库连接失败");
            return;
        }
        System.out.println("请输入学生信息");
        System.out.println("请输入学号");
        Scanner input = new Scanner(System.in);
        stu.sno = input.nextInt();
        System.out.println("请输入姓名");
        stu.name = input.next();
        System.out.println("请输入性别");
        stu.sex = input.next();
        System.out.println("请输入年龄");
        stu.age = input.nextInt();
        System.out.println("请输入地址");
        stu.address = input.next();
        System.out.println("请输入电话");
        stu.tel = input.next();
        System.out.println("请输入班级号");
        stu.ClassNum = input.nextInt();

        String sqlStatament = "INSERT INTO student(sno,name,sex,age,address,tel,class) VALUES(?,?,?,?,?,?,?)";;
        PreparedStatement sqlStatm=con.prepareStatement(sqlStatament);
        int i=0;
        try {
            //查询有没有这个班级
            sqlStatament = "select * from class where class_no = " + stu.ClassNum;
            rs=sqlStatm.executeQuery(sqlStatament);
            if(rs.next()){
                i=1;
            }
            if (i > 0) {
                System.out.println("班级存在");
                int num = rs.getInt("class_sum");
                //ps1 is for update class_sum
                String sq1 = "update class set class_sum=? where class_no=?";
                PreparedStatement ps1 = con.prepareStatement(sq1);
                ps1.setInt(1, num + 1);
                ps1.setInt(2, stu.ClassNum);
                //System.out.println(num + 1);
                //System.out.print("execute: " + sq1);
                i = ps1.executeUpdate();

                if (i > 0) {
                    System.out.println("添加班级成功");
                    sqlStatament = "INSERT INTO student(sno,name,sex,age,address,tel,class) VALUES(?,?,?,?,?,?,?)";
                    sqlStatm.setInt(1, stu.sno);
                    sqlStatm.setString(2, stu.name);
                    sqlStatm.setString(3, stu.sex);
                    sqlStatm.setInt(4, stu.age);
                    sqlStatm.setString(5, stu.address);
                    sqlStatm.setString(6, stu.tel);
                    sqlStatm.setInt(7, stu.ClassNum);
                    //System.out.print("execute: " + sqlStatament);
                    i = sqlStatm.executeUpdate();
                }
            } else {
                System.out.println("班级不存在,将新增班级");
                String sql = "insert into class(class_no,class_sum) values(?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, stu.ClassNum);
                ps.setInt(2, 1);
                i = ps.executeUpdate();
                if (i > 0) {
                    System.out.println("添加班级成功");
                    sqlStatm.setInt(1, stu.sno);
                    sqlStatm.setString(2, stu.name);
                    sqlStatm.setString(3, stu.sex);
                    sqlStatm.setInt(4, stu.age);
                    sqlStatm.setString(5, stu.address);
                    sqlStatm.setString(6, stu.tel);
                    sqlStatm.setInt(7, stu.ClassNum);
                    //System.out.print("execute: " + sqlStatament);
                    i = sqlStatm.executeUpdate();
                    if(i>0){
                        System.out.println("添加学生成功");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //删除学生
    public void Delete() throws SQLException {
        System.out.println("请输入要删除的姓名");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        //先查询是否存在,select * from class where class_no =
        String sql = "select * from student where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);

        String sql2="update class set class_sum=? where class_no=?";
        PreparedStatement ps2=con.prepareStatement(sql2);

        ps.setString(1, name);
        ResultSet rs1 = ps.executeQuery();

        if (rs1.next()) {
            System.out.println("学生存在,将删除学生");
            int num=rs1.getInt("class");
            int numclass=0;
            String sql3="select * from class where class_no=?";
            PreparedStatement ps3=con.prepareStatement(sql3);
            ps3.setInt(1, num);
            ResultSet rs2=ps3.executeQuery();
            if(rs2.next()){
                numclass=rs2.getInt("class_sum");
            }
            String sql4="update class set class_sum=? where  class_no=?";
            PreparedStatement ps4=con.prepareStatement(sql4);
            ps4.setInt(1, numclass-1);
            ps4.setInt(2, num);
            int i=ps4.executeUpdate();
            if(i>0){
                System.out.println("更新班级成功");
            }else {
                System.out.println("更新班级失败");
            }

            String sql1 = "delete from student where name=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, name);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("删除学生成功");
            }else {
                System.out.println("删除学生失败");
            }
        }else{
            System.out.println("学生不存在");
        }


    }
    //更新学生
    public void Modify() throws SQLException {
        System.out.println("请输入要修改的姓名");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("请输入要修改后的姓名");
        String newname = input.next();
        String sql = "select * from student where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("学生存在,将修改学生");
            String sql1 = "update student set name=? where name=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, newname);
            ps1.setString(2, name);
            int i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("修改学生成功");
            }
        }else {
            System.out.println("学生不存在");
        }

    }
    //查询学生
    public void Query() throws SQLException {
        System.out.println("请输入要查询的学号");
        Scanner input = new Scanner(System.in);
        int sno = input.nextInt();
        System.out.println("请输入要查询的姓名");
        String name = input.next();
        String sqlStatament = "select * from Student where sno=" + "'" + sno + "'" + "and name=" + "'" + name + "'";
        rs = stat.executeQuery(sqlStatament);
        while (rs.next()) {
            System.out.println("学号：" + rs.getInt("sno") + "姓名：" + rs.getString("name") + "性别：" + rs.getString("sex")
                    +"年龄:"+rs.getInt("age")+"地址:"+rs.getString("address")+"电话:"+rs.getString("tel")+"班级:"+rs.getInt("class"));
        }
    }
    //统计班级信息
    public void statisticsInfo() throws SQLException {
        System.out.println("按班级还是性别统计学生信息");
        System.out.println("1.按班级统计");
        System.out.println("2.按性别统计");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num == 1) {
            System.out.println("请输入要统计的班级");
            int class_no = input.nextInt();
            String sql = "select * from student where class=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, class_no);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("学号：" + rs.getInt("sno") + "姓名：" + rs.getString("name") + "性别：" + rs.getString("sex")
                        +"年龄:"+rs.getInt("age")+"地址:"+rs.getString("address")+"电话:"+rs.getString("tel")+"班级:"+rs.getInt("class"));
            }

        } else if (num==2) {
            System.out.println("请输入要统计的性别");
            String sex=input.next();
            String sql = "select * from student where sex=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sex);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("学号：" + rs.getInt("sno") + "姓名：" + rs.getString("name") + "性别：" + rs.getString("sex")
                        +"年龄:"+rs.getInt("age")+"地址:"+rs.getString("address")+"电话:"+rs.getString("tel")+"班级:"+rs.getInt("class"));
            }
        }


    }
    //添加班级
    public void addClass() throws SQLException {
        System.out.println("请输入要添加的班级");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        System.out.println("请输入要添加的班级名称");
        String class_name = input.next();
        //查询班级是否存在
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            System.out.println("班级已存在");
            i++;
        }
        if (i==0){
            String sql1 = "insert into class(class_no,class_name) values(?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, class_no);
            ps1.setString(2, class_name);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("添加班级成功");

            }else {
                System.out.println("班级已存在");
            }
        }
    }
    //删除班级
    public void deleteClass() throws SQLException {
        System.out.println("请输入要删除的班级");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        //查询班级是否存在
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            i++;
        }
        if (i==0){
            System.out.println("班级不存在");
        }else {
            //判断班级是否有学生
            int num=rs.getInt("class_sum");
            if (num==0){
                String sql1 = "delete from class where class_no=?";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, class_no);
                i = ps1.executeUpdate();
                if (i > 0) {
                    System.out.println("删除班级成功");

                }else {
                    System.out.println("删除班级失败");

                }
            }else {
                System.out.println("班级中有学生，不能删除");
            }
        }
    }
    //修改班级
    public void updateClass() throws SQLException {
        System.out.println("请输入要修改的班级");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        System.out.println("请输入要修改的班级名称");
        String class_name = input.next();
        //查询班级是否存在
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            i++;
        }
        if (i==0){
            System.out.println("班级不存在");
        }
        else {
            String sql1 = "update class set class_name=? where class_no=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, class_name);
            ps1.setInt(2, class_no);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("修改班级成功");
            }
            else {
                System.out.println("修改班级失败");
            }

        }
    }


    public static void main(String[] args) throws SQLException {
            StuDatabase stuDatabase = new StuDatabase();
            stuDatabase.Connected("jdbc:mysql://localhost:3306/Persons","root","1230123");
            while (true){
                System.out.println("请选择要进行的操作");
                System.out.println("1.添加学生");
                System.out.println("2.删除学生");
                System.out.println("3.修改学生");
                System.out.println("4.按班级或性别统计学生信息");
                System.out.println("5.查询学生");
                System.out.println("6.添加班级");
                System.out.println("7.删除班级");
                System.out.println("8.修改班级");
                System.out.println("9.退出");
                Scanner input = new Scanner(System.in);
                int i = input.nextInt();
                switch (i){
                    case 1: {
                        stuDatabase.add();
                    }break;

                    case 2: {
                        stuDatabase.Delete();
                    }break;

                    case 3: {
                        stuDatabase.Modify();
                    }break;

                    case 4: {
                        stuDatabase.statisticsInfo();
                    }break;

                    case 5: {
                        stuDatabase.Query();
                    }break;

                    case 6: {
                        stuDatabase.addClass();
                    }break;

                    case 7: {
                        stuDatabase.deleteClass();
                    }break;

                    case 8: {
                        stuDatabase.updateClass();
                    }break;

                    case 9: {
                        System.exit(0);
                    }
                }

            }
    }
}
