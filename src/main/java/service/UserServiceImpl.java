package service;

import dao.UserDAOImpl;
import domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserDAOImpl userDAO;

    public void insert(UserDTO userDTO){
        int answer = 0;
        System.out.println("service insert");
        userDAO.insertMember(userDTO);
        answer = 1;
        System.out.println(answer);
    }
}
