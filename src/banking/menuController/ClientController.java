package banking.menuController;

import banking.exception.TransferException;
import banking.fuctional.Opetaions;
import banking.fuctional.UsersOperation;
import banking.exception.MenuException;
import banking.objeckt.Account;
import banking.objeckt.Users;


import java.util.Scanner;


public class ClientController {
    private Scanner inText=new Scanner(System.in);
    private Scanner inNumber=new Scanner(System.in);
    private UsersOperation usersOperation=new UsersOperation();
    private Opetaions opetaions =new Opetaions();
    public void menuClient (Users user){
        boolean inMenu=true;

        do{
            opetaions.outputInformation(user);
            System.out.println("\n1)Обмен валюты. \n2)Перевод средств на другой счет. " +
                    "\n3)Просмотр баланса на счетах"+
                    "\n4)Просмотр текущих курсов \n5)Создание счета " +
                    "\n6)Внесение денег на счет. \n7)Удаление счета"+
                    "\n8)Подсчет общей суммы на счетах в BYN " +
                    "\n9)Поиск операций текущего пользователя за временной диапозон(история)"+
                    "\n10)Смена пароля \n11)Смена логина \n12)Выход из аккаунта");
            int choise = inNumber.nextInt();
           try {


               switch (choise) {
                   case 1:
                       opetaions.outputInformation(user);
                       System.out.println("Введите номер счета с которого будете переводить деньги:");
                       int numberWith = inNumber.nextInt();
                       System.out.println("Введите номер счета на который будете переводить деньги:");
                       int numberIn = inNumber.nextInt();
                       System.out.println("Введите сумму: ");
                       Double money = (double) inNumber.nextInt();
                       try {
                           if(opetaions.cheackByAccountNumber(numberIn,numberWith)){
                               usersOperation.curencyExchange(numberWith, numberIn, money);
                           }else{
                               throw new TransferException("неправельно введ номер счета");
                           }
                       }catch (TransferException e){
                           System.err.println(e.getMessage());
                       }
                       break;
                   case 2:
                       System.out.println("Введите номер счета с которого будете переводить деньги:");
                       numberWith = inNumber.nextInt();
                       System.out.println("Введите номер счета на который будете переводить деньги:");
                       numberIn = inNumber.nextInt();
                       System.out.println("Введите сумму: ");
                       money = (double) inNumber.nextInt();
                       try {
                           if(opetaions.cheackByAccountNumber(numberIn,numberWith)){
                               usersOperation.transferringFundsToAnotherAccoint(numberWith, numberIn, money);
                           }else{
                               throw new TransferException("неправельно введ номер счета");
                           }
                       }catch (TransferException e){
                           System.err.println(e.getMessage());
                       }
                       break;
                   case 3:
                       usersOperation.viewAccountBalance(user);
                       break;
                   case 4:
                       usersOperation.viewCurrentRates();
                       break;
                   case 5:
                       System.out.println("Выберите валюту счета: BYN/EUR/USD/RUB ");
                       String curency = inText.nextLine().toLowerCase();
                       usersOperation.creatingAnAccount(user, curency);
                       break;
                   case 6:
                       System.out.println("Введите номер счета на который вносите деньги:");
                       opetaions.outputInformation(user);
                       System.out.println("Введите номер счета на который вносите деньги:");
                       int number = inNumber.nextInt();
                       System.out.println("Введите сумму:");
                       money = (double) inNumber.nextInt();
                       usersOperation.depositingMoneyIntoAnAccount(user, number, money);
                       break;
                   case 7:
                       opetaions.outputAccountIntformation(user);
                       System.out.println("Введите номер счета который хотите удалить: ");
                       int num = inNumber.nextInt();
                       usersOperation.accountDeletion( num);
                       break;
                   case 8:
                       usersOperation.calculationOfTheTotalAmountInTheAccountsInBYN(user);
                       break;
                   case 9:
                       usersOperation.operationHistory(user);
                       break;
                   case 10:
                       System.out.println("Введите новый пароль: ");
                       int newPassword = inNumber.nextInt();
                       usersOperation.changePassword(user, newPassword);
                       break;
                   case 11:
                       System.out.println("Введите новый логин: ");
                       String newlogin = inText.nextLine();
                       usersOperation.changeLogin(user, newlogin);
                       break;
                   case 12:
                       inMenu = false;
                       break;
                   default:
                       throw new MenuException("Выбрали неверный пункт");

               }
           }catch (MenuException e){
               System.err.println(e.getMessage());
           }
        }while(inMenu);
    }

}
