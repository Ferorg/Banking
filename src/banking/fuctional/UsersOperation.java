package banking.fuctional;

import banking.exception.AutorizationException;
import banking.exception.TransferException;
import banking.objeckt.Account;
import banking.objeckt.Currency;
import banking.objeckt.OperationsHistory;
import banking.objeckt.Users;
import banking.repsitory.SerializableAndDesirializable;

import java.time.format.DateTimeFormatter;
import java.util.*;

import static banking.objeckt.Currency.BYN;

public class UsersOperation implements AbstractClientOperation {
    private Scanner inNumber=new Scanner(System.in);
    private Scanner inText=new Scanner(System.in);
SerializableAndDesirializable serializableAndDesirializable=new SerializableAndDesirializable();
Opetaions opetaions = new Opetaions();
    @Override
    public void curencyExchange(int numberWith, int numberIn,double money) {
        try {
            List<Account> accountList = serializableAndDesirializable.deserializeAccount();
            Double comissionsKoef = opetaions.searchTransferCoefficient(accountList, numberWith, 999);
            double tempMoneyCom = money * 0.01 * comissionsKoef;
            boolean flagOperations;
            if(accountList.get(opetaions.searchByAccountNumber(accountList, numberWith)).getMoney()>money+money*0.01) {
               flagOperations=true;
                accountList.get(opetaions.searchByAccountNumber(accountList, numberWith)).setMoney(accountList.get(opetaions.searchByAccountNumber(accountList, numberWith)).getMoney() - (money - tempMoneyCom));
                opetaions.addSummComissions(tempMoneyCom);
                //вызвать метод перевода пени на счет комиссий
                Double koef = opetaions.searchTransferCoefficient(accountList, numberWith, numberIn);
                accountList.get(opetaions.searchByAccountNumber(accountList, numberIn)).setMoney(accountList.get(opetaions.searchByAccountNumber(accountList, numberIn)).getMoney() + money * koef);
                opetaions.creatingOperations(numberIn, numberWith, money, tempMoneyCom,flagOperations);
                serializableAndDesirializable.serializableAccount(accountList);
            }else{
                flagOperations=false;
                opetaions.creatingOperations(999, numberWith, money, tempMoneyCom,flagOperations);
                serializableAndDesirializable.serializableAccount(accountList);
                throw new TransferException("Недостаточно денег на балансе");
            }
        }catch (TransferException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void transferringFundsToAnotherAccoint(int numberWith, int numberIn,double money) {
curencyExchange(numberWith,numberIn,money);
    }



    @Override
    public void viewAccountBalance(Users user) {
opetaions.outputInformation(user);
    }

    @Override
    public void viewCurrentRates() {
            Set<Map.Entry<String, Double>> entrySet = serializableAndDesirializable.deserializeCurrency();
            for (Map.Entry<String, Double> a:entrySet) {
                System.out.print(a + "; ");
            }
    }

    @Override
    public void creatingAnAccount(Users user,String curency) {
            List<Account> accountsList = serializableAndDesirializable.deserializeAccount();
            Account newAccount = new Account(user.getId(),opetaions.generateNumberAccount(accountsList), opetaions.choiceCurrency(curency), 0.0);
            accountsList.add(newAccount);
            serializableAndDesirializable.serializableAccount(accountsList);
    }

    @Override
    public void depositingMoneyIntoAnAccount(Users user,int number, Double money) {
        List<Account> accountsList = serializableAndDesirializable.deserializeAccount();
        List<Double> commisions = serializableAndDesirializable.deserializeCommisions();
        accountsList.get(opetaions.searchByAccountNumber(accountsList, number)).setMoney(accountsList.get(opetaions.searchByAccountNumber(accountsList, number)).getMoney()+money);
        double peny=money*0.01;
        opetaions.addSummComissions(peny);
        opetaions.creatingOperations(number, money, peny);
        serializableAndDesirializable.serializableAccount(accountsList);
    }

    @Override
    public void accountDeletion(int num) {
        List<Account> accounts = serializableAndDesirializable.deserializeAccount();
        accounts.remove(opetaions.searchByAccountNumber(accounts, num));
        serializableAndDesirializable.serializableAccount(accounts);
    }

    @Override
    public void calculationOfTheTotalAmountInTheAccountsInBYN(Users user) {
        List<Account> accounts = serializableAndDesirializable.deserializeAccount();
        double transferCoefficient = 0.0;
        int summ = 0;
        for (Account a : accounts) {
            if (a.getId() == user.getId()) {
                switch (a.getCurrency()) {
                    case BYN:
                        transferCoefficient =opetaions.searchTransferCoefficientByCyrrency(BYN);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case RUB:
                        transferCoefficient = opetaions.searchTransferCoefficientByCyrrency(Currency.RUB);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case EUR:
                        transferCoefficient = opetaions.searchTransferCoefficientByCyrrency(Currency.EUR);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case USD:
                        transferCoefficient = opetaions.searchTransferCoefficientByCyrrency(Currency.USD);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                }
            }

        }
        System.out.println("Общая сумма на счетах в BYN: " + summ);

    }

    @Override
    public void operationHistory(Users user) {
        List<OperationsHistory> historyList = serializableAndDesirializable.deserializeOperations();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        for (OperationsHistory operation:historyList) {
            if((user.getLogin().equals(operation.getLogin()))){
                System.out.println("Чек "+operation.getNumberOperation()+
                        "\nДата и время операции:" +operation.getDate().format(dateTimeFormatter)+
                        ". Логин: "+operation.getLogin() +
                        ". перевод "+operation.getMoney()+" "+operation.getCurrency()+
                        " на счет "+operation.getNumberAccount()+". комиссия "+operation.getComissioms()+
                        ". Итоговая сумма:"+(operation.getMoney()+operation.getComissioms()));
            }
        }

    }
    @Override
    public Users changePassword(Users user,int newPassword) {
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        usersList.get(user.getId()).setPassword(newPassword);
        user.setPassword(newPassword);
        serializableAndDesirializable.serializableUsers(usersList);
        return user;
    }

    @Override
    public Users changeLogin(Users user, String newlogin) {
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        boolean flag = opetaions.checkLogin( usersList,newlogin);
        try {
            if(!flag) {
                usersList.get(user.getId()).setLogin(newlogin);
                user.setLogin(newlogin);
                System.out.println(user.getLogin());
            }else{
                throw new AutorizationException("Логин занят");
            }
        } catch (AutorizationException e){
            System.err.println(e.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        serializableAndDesirializable.serializableUsers(usersList);
        return user;
    }


}
