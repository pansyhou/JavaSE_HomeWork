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


        //���ݿ�����
     void Connected (String url, String username, String ps) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, ps);
            stat = con.createStatement();
            System.out.println("���ӳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //���ѧ��
    public void add() throws SQLException {
        Student stu = new Student();
        if (stat == null) {
            System.out.println("���ݿ�����ʧ��");
            return;
        }
        System.out.println("������ѧ����Ϣ");
        System.out.println("������ѧ��");
        Scanner input = new Scanner(System.in);
        stu.sno = input.nextInt();
        System.out.println("����������");
        stu.name = input.next();
        System.out.println("�������Ա�");
        stu.sex = input.next();
        System.out.println("����������");
        stu.age = input.nextInt();
        System.out.println("�������ַ");
        stu.address = input.next();
        System.out.println("������绰");
        stu.tel = input.next();
        System.out.println("������༶��");
        stu.ClassNum = input.nextInt();

        String sqlStatament = "INSERT INTO student(sno,name,sex,age,address,tel,class) VALUES(?,?,?,?,?,?,?)";;
        PreparedStatement sqlStatm=con.prepareStatement(sqlStatament);
        int i=0;
        try {
            //��ѯ��û������༶
            sqlStatament = "select * from class where class_no = " + stu.ClassNum;
            rs=sqlStatm.executeQuery(sqlStatament);
            if(rs.next()){
                i=1;
            }
            if (i > 0) {
                System.out.println("�༶����");
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
                    System.out.println("��Ӱ༶�ɹ�");
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
                System.out.println("�༶������,�������༶");
                String sql = "insert into class(class_no,class_sum) values(?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, stu.ClassNum);
                ps.setInt(2, 1);
                i = ps.executeUpdate();
                if (i > 0) {
                    System.out.println("��Ӱ༶�ɹ�");
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
                        System.out.println("���ѧ���ɹ�");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //ɾ��ѧ��
    public void Delete() throws SQLException {
        System.out.println("������Ҫɾ��������");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        //�Ȳ�ѯ�Ƿ����,select * from class where class_no =
        String sql = "select * from student where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);

        String sql2="update class set class_sum=? where class_no=?";
        PreparedStatement ps2=con.prepareStatement(sql2);

        ps.setString(1, name);
        ResultSet rs1 = ps.executeQuery();

        if (rs1.next()) {
            System.out.println("ѧ������,��ɾ��ѧ��");
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
                System.out.println("���°༶�ɹ�");
            }else {
                System.out.println("���°༶ʧ��");
            }

            String sql1 = "delete from student where name=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, name);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("ɾ��ѧ���ɹ�");
            }else {
                System.out.println("ɾ��ѧ��ʧ��");
            }
        }else{
            System.out.println("ѧ��������");
        }


    }
    //����ѧ��
    public void Modify() throws SQLException {
        System.out.println("������Ҫ�޸ĵ�����");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("������Ҫ�޸ĺ������");
        String newname = input.next();
        String sql = "select * from student where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("ѧ������,���޸�ѧ��");
            String sql1 = "update student set name=? where name=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, newname);
            ps1.setString(2, name);
            int i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("�޸�ѧ���ɹ�");
            }
        }else {
            System.out.println("ѧ��������");
        }

    }
    //��ѯѧ��
    public void Query() throws SQLException {
        System.out.println("������Ҫ��ѯ��ѧ��");
        Scanner input = new Scanner(System.in);
        int sno = input.nextInt();
        System.out.println("������Ҫ��ѯ������");
        String name = input.next();
        String sqlStatament = "select * from Student where sno=" + "'" + sno + "'" + "and name=" + "'" + name + "'";
        rs = stat.executeQuery(sqlStatament);
        while (rs.next()) {
            System.out.println("ѧ�ţ�" + rs.getInt("sno") + "������" + rs.getString("name") + "�Ա�" + rs.getString("sex")
                    +"����:"+rs.getInt("age")+"��ַ:"+rs.getString("address")+"�绰:"+rs.getString("tel")+"�༶:"+rs.getInt("class"));
        }
    }
    //ͳ�ư༶��Ϣ
    public void statisticsInfo() throws SQLException {
        System.out.println("���༶�����Ա�ͳ��ѧ����Ϣ");
        System.out.println("1.���༶ͳ��");
        System.out.println("2.���Ա�ͳ��");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num == 1) {
            System.out.println("������Ҫͳ�Ƶİ༶");
            int class_no = input.nextInt();
            String sql = "select * from student where class=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, class_no);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ѧ�ţ�" + rs.getInt("sno") + "������" + rs.getString("name") + "�Ա�" + rs.getString("sex")
                        +"����:"+rs.getInt("age")+"��ַ:"+rs.getString("address")+"�绰:"+rs.getString("tel")+"�༶:"+rs.getInt("class"));
            }

        } else if (num==2) {
            System.out.println("������Ҫͳ�Ƶ��Ա�");
            String sex=input.next();
            String sql = "select * from student where sex=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sex);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ѧ�ţ�" + rs.getInt("sno") + "������" + rs.getString("name") + "�Ա�" + rs.getString("sex")
                        +"����:"+rs.getInt("age")+"��ַ:"+rs.getString("address")+"�绰:"+rs.getString("tel")+"�༶:"+rs.getInt("class"));
            }
        }


    }
    //��Ӱ༶
    public void addClass() throws SQLException {
        System.out.println("������Ҫ��ӵİ༶");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        System.out.println("������Ҫ��ӵİ༶����");
        String class_name = input.next();
        //��ѯ�༶�Ƿ����
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            System.out.println("�༶�Ѵ���");
            i++;
        }
        if (i==0){
            String sql1 = "insert into class(class_no,class_name) values(?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, class_no);
            ps1.setString(2, class_name);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("��Ӱ༶�ɹ�");

            }else {
                System.out.println("�༶�Ѵ���");
            }
        }
    }
    //ɾ���༶
    public void deleteClass() throws SQLException {
        System.out.println("������Ҫɾ���İ༶");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        //��ѯ�༶�Ƿ����
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            i++;
        }
        if (i==0){
            System.out.println("�༶������");
        }else {
            //�жϰ༶�Ƿ���ѧ��
            int num=rs.getInt("class_sum");
            if (num==0){
                String sql1 = "delete from class where class_no=?";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, class_no);
                i = ps1.executeUpdate();
                if (i > 0) {
                    System.out.println("ɾ���༶�ɹ�");

                }else {
                    System.out.println("ɾ���༶ʧ��");

                }
            }else {
                System.out.println("�༶����ѧ��������ɾ��");
            }
        }
    }
    //�޸İ༶
    public void updateClass() throws SQLException {
        System.out.println("������Ҫ�޸ĵİ༶");
        Scanner input = new Scanner(System.in);
        int class_no = input.nextInt();
        System.out.println("������Ҫ�޸ĵİ༶����");
        String class_name = input.next();
        //��ѯ�༶�Ƿ����
        String sql = "select * from class where class_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, class_no);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if (rs.next()) {
            i++;
        }
        if (i==0){
            System.out.println("�༶������");
        }
        else {
            String sql1 = "update class set class_name=? where class_no=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, class_name);
            ps1.setInt(2, class_no);
            i = ps1.executeUpdate();
            if (i > 0) {
                System.out.println("�޸İ༶�ɹ�");
            }
            else {
                System.out.println("�޸İ༶ʧ��");
            }

        }
    }


    public static void main(String[] args) throws SQLException {
            StuDatabase stuDatabase = new StuDatabase();
            stuDatabase.Connected("jdbc:mysql://localhost:3306/Persons","root","1230123");
            while (true){
                System.out.println("��ѡ��Ҫ���еĲ���");
                System.out.println("1.���ѧ��");
                System.out.println("2.ɾ��ѧ��");
                System.out.println("3.�޸�ѧ��");
                System.out.println("4.���༶���Ա�ͳ��ѧ����Ϣ");
                System.out.println("5.��ѯѧ��");
                System.out.println("6.��Ӱ༶");
                System.out.println("7.ɾ���༶");
                System.out.println("8.�޸İ༶");
                System.out.println("9.�˳�");
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
