package banking.fuctional;

import banking.menuController.AdminController;
import banking.menuController.ClientController;
import banking.exception.AutorizationException;
import banking.objeckt.Role;
import banking.objeckt.Users;
import banking.repsitory.SerializableAndDesirializable;

import java.util.List;
import java.util.Scanner;

public class AutorizationOperation {
    private Scanner inText=new Scanner(System.in);
    private Scanner inNumber=new Scanner(System.in);
     private SerializableAndDesirializable serializableAndDesirializable=new SerializableAndDesirializable();
  AdminController adminController = new AdminController();
  ClientController clientController= new ClientController();
 Opetaions opetaions = new Opetaions();
    public void autorizationClient(String login,int password){
        List<Users> users=serializableAndDesirializable.deserializeUsers();
        try {
            boolean flag=false;
            for (Users u : users) {
                if ((login.equals(u.getLogin())) && (password == u.getPassword())) {
                    checkRoleAndChoiseMenu(u);
                    flag=true;
                    break;
                }else {
                    flag=false;
                }
            }
            if(!flag){
                throw new AutorizationException("Ошибка при вводе логина или пароля");
            }
        }catch (AutorizationException e){
            System.err.println(e.getMessage());
        }
    }
    public void registrationClient(String login,int password,String name){
        Users user=new Users(0,login,password,name,Role.CLIENT);
        List<Users> users=serializableAndDesirializable.deserializeUsers();
        boolean flag = checkLogin(users,login);
        try {
            if(!flag) {
                users.add(user);
            }else {
                throw new AutorizationException("Логин занят");
            }
        } catch (AutorizationException e){
            System.err.println(e.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        opetaions.idRecalculating(users);
        serializableAndDesirializable.serializableUsers(users);
    }


    public boolean checkLogin(List<Users> users, String login){
        boolean flag=false;
        for (Users u:users) {
            if(u.getLogin().equals(login)){
                flag=true;
                break;
            }else{
                flag=false;
            }
        }
        return flag;
    }
    public  void checkRoleAndChoiseMenu(Users user){
        if(user.getRole().equals(Role.ADMIN)){
            System.out.println(user.getName()+" Добро пожаловать ");
            adminController.menuAdmin (user);
        }else{
            System.out.println(user.getName()+" Добро пожаловать ");
            clientController.menuClient(user);
        }
    }
}
