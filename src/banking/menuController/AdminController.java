package banking.menuController;

import banking.fuctional.AdminOperations;
import banking.exception.MenuException;
import banking.fuctional.Opetaions;
import banking.objeckt.Users;

import java.util.Scanner;

public class AdminController {
    private Scanner inText = new Scanner(System.in);
    private Scanner inNumber = new Scanner(System.in);
    private Scanner inTex = new Scanner(System.in);
    private AdminOperations adminOperations = new AdminOperations();
    private Opetaions opetaions = new Opetaions();

    public void menuAdmin(Users user) {
        boolean inMenu = true;

        do {
            opetaions.outputInformation(user);
            System.out.println("\n1)Просмотр всех клиентов \n2)Просмотр операий по клиенту." +
                    " \n3)Удаление клиента \n4)Смена пароля \n5)Смена логина \n6)Создание счёта" +
                    "\n7)Просмотр счета с комиссиями. \n8)Просмотр операций снеоплаченными комиссиями " +
                    "\n9)Перевод комиссий на счёт \n10)Получить сумму комиссий не переведенных на счет" +
                    "\n11)Регистрация пользователя \n12)Просмотр клиента по логину \n13)Просмотр всех счетов" +
                    "\n14)Просмотр всех операций  \n15)Загрузка файла с курсами \n16)Выход из аккаунта");
            try {
                int choise = inNumber.nextInt();
                switch (choise) {
                    case 1:
                        adminOperations.viewAllClients();
                        break;
                    case 2:
                        System.out.println("Введите логин");
                        String login1 = inTex.nextLine();
                        adminOperations.viewCustomerTransactions(login1);
                        break;
                    case 3:
                        System.out.println("Введите логин");
                        String login2 = inTex.nextLine();
                        adminOperations.deletingClient(login2);
                        break;
                    case 4:
                        System.out.println("Введите новый пароль: ");
                        int newPassword = inNumber.nextInt();
                        adminOperations.changePassword(user, newPassword);
                        break;
                    case 5:
                        System.out.println("Введите новый логин: ");
                        String newlogin = inTex.nextLine();
                        adminOperations.changeLogin(user, newlogin);
                        break;
                    case 6:
                        System.out.println("Выберите валюту счета: BYN/EUR/USD/RUB ");
                        String curency = inTex.nextLine().toLowerCase();
                        adminOperations.creatingAnAccount(user, curency);
                        break;
                    case 7:
                        adminOperations.viewAccountWithCommissions();
                        break;
                    case 8:
                        adminOperations.viewTransactionsWithUnpaidCommissions();
                        break;
                    case 9:
                        adminOperations.transferOfCommissionsToTheAccount();
                        break;
                    case 10:
                        adminOperations.receiveTheAmountOfCommissionsNotTransferredToTheAccount();
                        break;
                    case 11:
                        System.out.println("Введите логин");
                        String login = inText.nextLine();
                        System.out.println("Введите пароль");
                        int password = inNumber.nextInt();
                        System.out.println("Введите имя");
                        String name = inText.nextLine();
                        System.out.println("установите роль пользователя: client/admin");
                        String role = inText.nextLine();
                        adminOperations.userRegistration(login, password, name, role);
                        break;
                    case 12:
                        System.out.println("Введите логин клиента: ");
                        String log = inText.nextLine();
                        adminOperations.viewClientByLogin(log);
                        break;
                    case 13:
                        adminOperations.viewAllAccounts();
                        break;
                    case 14:
                        adminOperations.viewAllTransactions();
                        break;
                    case 15:
                        adminOperations.downloadCourseFile();
                        break;
                    case 16:
                        inMenu = false;
                        break;
                    default:
                        throw new MenuException("Выбрали неверный пункт");
                }
            } catch (MenuException e) {
                System.err.println(e.getMessage());
            }

        } while (inMenu);
    }
}