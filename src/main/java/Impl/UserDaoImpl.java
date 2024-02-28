package Impl;

import bean.User;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


                result.add(new User(id, name, surname, phone, email));
            }
            c.close();

        } catch(Exception ex){
            ex.printStackTrace();
        }return result;
    }




    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect();
             PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, phone=?, email=? where id=?")){

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getId());

            return stmt.execute();


        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }




    @Override
    public boolean addUser(User u) {
        try{ Connection c=connect();
            PreparedStatement stmt=c.prepareStatement("insert into user(name,surname,phone,email) values(?,?,?,?)");

            stmt.setString(1,u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3,u.getPhone());
            stmt.setString(4,u.getEmail());
            return stmt.execute();

        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
    }}

    @Override
    public boolean removeUser(int id) {
        try{ Connection c=connect();
            Statement stmt=c.createStatement();
            stmt.execute("DELETE from user WHERE id="+id);}
        catch(Exception ex){
            ex.printStackTrace();
            return false;//exception varsa false verecek bunu yazdigimizda
        }
        return true;
    }


    @Override
    public User getById(int userId){
        User result=new User();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id="+userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");



                result = new User(id, name, surname, phone, email);

            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }return result;
            }

//public User getById(int userId){
//        User result=null;
//        try(Connection c=connect()){
//            Statement stmt=c.createStatement();
//            stmt.execute("SELECT"
//                    u.*,
//                    n.name AS nationality,
//                    c.countyr_name AS birthplace
//                    FROM user u
//                    LEFT JOIN nationality n ON u.nationality_id = n.id
//                    LEFT JOIN country c ON u.birthplace_id = c.id where u.id=+userId);
//
//            ResultSet rs=stmt.getResultSet();
//
//            while(rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//
//               result = new User(new User(id, name, surname, phone, email));
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }return result;
//
//            }
//        }
}




