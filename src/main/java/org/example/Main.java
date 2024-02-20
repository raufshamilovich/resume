package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void foo() throws  Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");//bunu yazmasag da olar

        // Veritabanı bağlantı bilgileri
        String url = "jdbc:mysql://localhost:33066/resume";
        String kullaniciAdi = "root";
        String sifre = "3457707rauffuar";
        // Veritabanına bağlantı oluşturma


        Connection connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
        System.out.println(connection.getClass().getName());

        Statement stmt= connection.createStatement();
        stmt.execute("select * from user");
        ResultSet rs=stmt.getResultSet();


        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");//hal hazirda ustunde oldugu setrin String// olan name sutununu verir
            String surname=rs.getString("surname");
            String phone=rs.getString("phone");;
            String email=rs.getString("email");

            System.out.println("id="+id);
            System.out.println("name="+name);
            System.out.println("surname="+surname);
            System.out.println("phone="+phone);
            System.out.println("email="+email);
        }
        connection.close();



    }

    public static void main(String[] args) throws Exception{
        foo();
    }
}