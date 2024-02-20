package dao.inter;

import bean.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll();
    public boolean updateUser(User u);
    public boolean removUser(int id);
}
