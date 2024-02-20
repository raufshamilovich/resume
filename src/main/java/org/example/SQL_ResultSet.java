package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL_ResultSet {
    private static Connection connect()throws Exception{
        String url = "jdbc:mysql://localhost:33066/resume";
        String kullaniciAdi = "root";
        String sifre = "3457707rauffuar";
        Connection c= DriverManager.getConnection(url,kullaniciAdi,sifre);
        return c;

    }
    private static void getAll() throws Exception{
        Connection c=connect();// burda tezden mysql`e baglanmag ucun kodlari yazmag yerine
        //artig connect() metodunu cagirdig

        Statement stmt=c.createStatement();
        stmt.execute("select * from user");
        ResultSet rs=stmt.getResultSet();

        while(rs.next()){
            int id= rs.getInt("id");
            String name= rs.getString("name");
            String surname=rs.getString("surname");
            String phone= rs.getString("phone");
            String email= rs.getString("email");

            System.out.println("id="+id);
            System.out.println("name="+name);
            System.out.println("surname="+surname);
            System.out.println("phone="+phone);
            System.out.println("email="+email);

            System.out.println("---------------");
        }
        System.out.println(c.getClass().getName());
    }

    private static void updateAll()throws Exception{
        Connection c=connect();
        Statement stmt=c.createStatement();
        stmt.execute("UPDATE user SET name='MIKAELSON' WHERE id=7");
    }

    public static void main(String[] args) throws Exception{
       updateAll();
       getAll();
    }
}
