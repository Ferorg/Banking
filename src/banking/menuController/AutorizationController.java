package banking.menuController;

import banking.fuctional.AutorizationOperation;
import banking.objeckt.Users;
import banking.service.SerializableAndDesirializable;

import java.util.List;
import java.util.Scanner;

public class AutorizationController {
    static boolean inMenu = true;
    public Scanner inText = new Scanner(System.in);
    Scanner inNumber = new Scanner(System.in);

    AutorizationOperation autorizationOperation = new AutorizationOperation();
    SerializableAndDesirializable serializableAndDesirializable = new SerializableAndDesirializable();

    public void menu1() {
        String login;
        int password;
        String name;
        List<Users> users = serializableAndDesirializable.deserializeUsers();
        System.out.println(users.toString());
        do {
            System.out.println("""
                    Начальное меню!
                    \s
                    1)Авторизация.\s
                    2)Регистрация.\s
                    3)Выход.""");
            int choise = inNumber.nextInt();
            switch (choise) {
                case 1 -> {
                    System.out.println("Авторизация:");
                    System.out.println("Введите логин");
                    login = inText.nextLine();
                    System.out.println("Введите пароль");
                    password = inNumber.nextInt();
                    autorizationOperation.autorizationClient(login, password);
                }
                case 2 -> {
                    System.out.println("Регистрация нового пользователя.");
                    System.out.println("Введите логин");
                    login = inText.nextLine();
                    System.out.println("Введите пароль");
                    password = inNumber.nextInt();
                    System.out.println("Введите имя");
                    name = inText.nextLine();
                    autorizationOperation.registrationClient(login, password, name);
                }
                case 3 -> {
                    System.out.println("Всего доброго!");
                    inMenu = false;
                }
                default -> {
                }
                //выбрасывать свое исключение
            }
        } while (inMenu);
    }
}
