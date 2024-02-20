package SQLucunProject;

import Impl.UserDaoImpl;
import bean.User;
import dao.inter.UserDaoInter;

import java.util.List;

public class Main {



    public static void main(String[] args)throws Exception {
        UserDaoInter userDao=new UserDaoImpl();

        List<User> list=userDao.getAll();
        userDao.removUser(1);

        List<User> list2=userDao.getAll();

        System.out.println("list="+ list);
        System.out.println("list2="+ list2);

    }
}
