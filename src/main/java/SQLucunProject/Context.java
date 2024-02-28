package SQLucunProject;

import Impl.UserDaoImpl;
import dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
