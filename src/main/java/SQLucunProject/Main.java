package SQLucunProject;

import Impl.UserDaoImpl;
import bean.User;
import dao.inter.UserDaoInter;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args)throws Exception {


//        UserDaoInter userDao=Context.instanceUserDao();
//        User u=new User(0, "Sarkhan", "Rasullu", "994555555555","sarkhanrasullu@gmail.com");
//        userDao.addUser(u);
//

        // 1.getAll metodunun cagirishi
//        UserDaoInter userDao=new UserDaoImpl();
//        userDao.getAll();
//        List<User> list=userDao.getAll();
//        System.out.println("list="+list);


        // 2.   id`si 2 olan setirleri silir remove metodu ile ve  getAll metodun cagirir bu halda(remov`lu)
//        UserDaoInter userDao=new UserDaoImpl();
//        List<User> list=userDao.getAll();
//        userDao.removeUser(2);
//        List<User> list2=userDao.getAll();//id`si 2 olan setirleri silir remove metodu ile
//        //ve  getAll metodun cagirir bu halda(remov`lu)
//        System.out.println("list="+list);
//        System.out.println("list2="+list2);


        // 3. MySQldeki name-i "Azay';delete from user;commit;select' etdiyimiz kod
//
//        UserDaoInter userDao=new UserDaoImpl();
//        User u=new User();
//        u.setId(1);
//        u.setName("Azay';delete from user;commit;select'");
//        userDao.updateUser(u);//update `e gonderdik bu kodumuzu
//        System.out.println(u);


        UserDaoInter userDao = Context.instanceUserDao();//Context classinda UserDaoImpl`in obyektin yaratdig ve
        //biz onu Contextdeki metodla cagiririg ve belece bu Main classimizda hec UserDaoImpl`dan istifade etmesek
        // belə çerez-çerez Context metodu ile onu cagira  bildiyimiz ucun classlarimizin bir birinden asılılığı
        // qalmış olmur
        //və bu da `loosely coopling adlanır` gevşek bağlanıt yəni~!
        User u = new User(0, "Sarkhan", "Rasullu", "9945555555", "sarkhanrasullug@gmail.com");
        userDao.addUser(u);
        System.err.println(u);








    }}