package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SQLupdate {
    public static void Update() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:33066/resume";
        String username="root";
        String sifre="3457707rauffuar";

       try( Connection c= DriverManager.getConnection(url, username, sifre)){
        String updatequery="UPDATE user SET name='AZAY' WHERE id=2 ";

        try(PreparedStatement stmt=c.prepareStatement(updatequery)){
        stmt.execute();
            System.out.println(stmt);
    }}}
    public static void main(String []args) throws Exception{
        Update();

    }
}
