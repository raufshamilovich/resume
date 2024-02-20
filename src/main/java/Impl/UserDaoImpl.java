package Impl;

import bean.User;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List <User> result =new ArrayList<>();
        try {
            Connection c = connect();// burda tezden mysql`e baglanmag ucun kodlari yazmag yerine
            //artig connect() metodunu cagirdig

            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                result.add(new User(id,name,surname,phone,email));
            }
            c.close();

        } catch(Exception ex){
            ex.printStackTrace();
        }return result;
    }


    @Override
    public boolean updateUser(User u) {
       try{ Connection c=connect();
        Statement stmt=c.createStatement();
        stmt.execute("UPDATE user SET name='KLAUS' WHERE id=5");}
       catch(Exception ex){
           ex.printStackTrace();
           return false;//exception varsa false verecek bunu yazdigimizda
       }
       return true;
    }

    @Override
    public boolean removUser(int id) {
        try{ Connection c=connect();
            Statement stmt=c.createStatement();
            stmt.execute("DELETE from user WHERE id=5");}
        catch(Exception ex){
            ex.printStackTrace();
            return false;//exception varsa false verecek bunu yazdigimizda
        }
        return true;
    }




}
