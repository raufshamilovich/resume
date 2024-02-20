package org.example;

import java.sql.*;

public class SQLinsert {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:33066/resume";
        String username="root";
        String password="3457707rauffuar";


//ashagidaki try`da getConnection`un icindeki url username password sira ile yazilmalidir yoxsa ERROR verir

        try(Connection connection= DriverManager.getConnection(url,username,password)){
        String insertQuery="INSERT INTO user(name, surname, phone) VALUES(?,?,?) ";
            System.out.println(connection.getClass().getName()); //bunu elebele hansi classdi onu oyrenmek ucun yazdim


       try( PreparedStatement stmt=connection.prepareStatement(insertQuery)){
        stmt.setString(1, "Rauf");
        stmt.setString(2,"Nazir");
        stmt.setString(3,"+99450701600");

        stmt.execute();   //burda .execute() veya .executeUpdate() arasinda hecbir ferg yoxdur
       System.out.println(stmt); } //bunu javada da ekrana yazdirmag ucun yazdim

       catch(Exception ex) {
           ex.printStackTrace();
       }}
       }}
//





