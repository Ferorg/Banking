package banking;

import banking.menuController.AutorizationController;

public class Start {


    public static void main(String[] args) {
        AutorizationController autorization = new AutorizationController();
        autorization.menu1();


//        SerializableAndDesirializable serializableAndDesirializable=new SerializableAndDesirializable();
//        List<Account> accounts = new ArrayList<>();
//        Account penia = new Account(999, 1, Currency.BYN, 0.0);
//        Account penia1 = new Account(1, 12, Currency.BYN, 0.0);
//        Account penia2 = new Account(1, 15, Currency.BYN, 0.0);
//        Account penia3 = new Account(2, 17, Currency.BYN, 0.0);
//        Account penia4 = new Account(2, 222, Currency.BYN, 0.0);
//        Account penia5 = new Account(1, 21, Currency.BYN, 0.0);
//        Account penia6 = new Account(2, 22, Currency.BYN, 0.0);
//        accounts.add(penia);
//        accounts.add(penia1);
//        accounts.add(penia2);
//        accounts.add(penia3);
//        accounts.add(penia4);
//        accounts.add(penia5);
//        accounts.add(penia6);
//
//        serializableAndDesirializable.serializableAccount(accounts);
//
//        List<Users> users=new ArrayList<>();
//        Users user = new Users(0, "ant", 123, "Anton", Role.ADMIN);
//        Users user1 = new Users(1, "gen", 123, "GEna", Role.CLIENT);
//        Users user2 = new Users(2, "nik", 123, "Nik", Role.CLIENT);
//        users.add(user);
//        users.add(user1);
//        users.add(user2);
//        String file = "src/banking/domain/UsersList.txt";
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
//            objectOutputStream.writeObject(users);
//            objectOutputStream.close();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }



    }


}