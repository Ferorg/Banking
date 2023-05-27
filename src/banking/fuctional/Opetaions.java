package banking.fuctional;

import banking.exception.TransferException;
import banking.objeckt.*;
import banking.repsitory.SerializableAndDesirializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static banking.objeckt.Currency.BYN;

public class Opetaions implements generalFuctionality{
  SerializableAndDesirializable serializableAndDesirializable=new SerializableAndDesirializable();


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


    public List<Users> idRecalculating(List<Users> users){
        for(int i=0;i< users.size();i++){
            users.get(i).setId(i);
        }
        return users;

    }

    public  double searchTransferCoefficient(List<Account> accountList, int numberWith, int numberIn) {
        Set<Map.Entry<String, Double>> entrySet = serializableAndDesirializable.deserializeCurrency();
        double transferCoefficient = 0.0;
        if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == BYN) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    transferCoefficient = 1.0;
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.RUB) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    transferCoefficient = 1.0;
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.EUR) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    transferCoefficient = 1.0;
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.USD) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    transferCoefficient = 1.0;
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        }
        return transferCoefficient;
    }
    public int generateNumberAccount(List<Account> list) {
        boolean flag = false;
        int i = 0;
        int tempNumber = (int) (Math.random() * 1000);
        do {
            for (Account a : list) {
                if (a.getNumberAccount() == tempNumber) {
                    i++;
                }
            }
            if (i > 0) {
                tempNumber = (int) (Math.random() * 1000);
            } else {
                flag = true;
            }
        } while (!flag);
        return tempNumber;
    }
    public   Currency choiceCurrency(String curency) {
        Currency cur = null;
        switch (curency) {
            case "byn":
                cur= Currency.BYN;
                break;
            case "eur":
                cur=Currency.EUR;
                break;
            case "usd":
                cur=Currency.USD;
                break;
            case "rub":
                cur=Currency.RUB;
                break;
            default:
                //выброситьошибку если ввели неправильно
                break;
        }
        return cur;
    }
    public  void outputInformation(Users user) {
        List<Account> account = serializableAndDesirializable.deserializeAccount();
        System.out.println("\n-------------");
        System.out.println(user.toString());
        for (Account a : account) {
            if (user.getId() == a.getId()) {
                System.out.println(a.toString());
            }
        }
    }
    public  void outputAccountIntformation( Users users) {
        List<Account>accounts=serializableAndDesirializable.deserializeAccount();
        for (Account a : accounts) {
            if (users.getId() == a.getId()) {
                System.out.println(a.toString());
            }
        }
    }
    public  double searchTransferCoefficientByCyrrency(Currency currency) {
        Set<Map.Entry<String, Double>> entrySet =serializableAndDesirializable.deserializeCurrency();
        double transferCoefficient = 0.0;
        switch (currency) {
            case RUB:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("RUB/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
            case BYN:
                transferCoefficient = 1.0;
                break;
            case EUR:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("EUR/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
            case USD:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("USD/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
        }
        return transferCoefficient;
    }
    public int searchByAccountNumber(List<Account> accounts, int number) {
        int j = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumberAccount() == number) {
                j = i;
            }
        }
        return j;
    }
    public boolean cheackByAccountNumber(int number1,int number2) {
        List<Account> accounts=serializableAndDesirializable.deserializeAccount();
        boolean flag=false;
        int j = 0;
            for (int i = 0; i < accounts.size(); i++) {
                if ((accounts.get(i).getNumberAccount() == number1) || (accounts.get(i).getNumberAccount() == number2)) {
                    j++;
                }
            }
            if (j == 2) {
                flag=true;
            }else {
                flag=false;
            }
       return flag;
    }
    public Role changeRole(String role) {
        role = role.toLowerCase();
        Role temp = null;
        switch (role) {
            case "client":
                temp = Role.CLIENT;
                break;
            case "admin":
                temp = Role.ADMIN;
                break;
        }
        return temp;
    }

    public List<Users> registrtionClient(List<Users> users, Users user) {
        //проверка логина
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        String login = user.getLogin();
        boolean flag = checkLogin(users, login);
        try {
            if (!flag) {
                users.add(user);
            } else {
                System.out.println("логин занят");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        idRecalculating(users);
        return users;
    }

    public void outputClientInformationByLogin(String log, List<Users> users, List<Account> accountsList) {
        int tempID = 0;
        for (Users u : users) {
            if (u.getLogin().equals(log)) {
                tempID = u.getId();
                System.out.println(u.toString());
            }
        }
        for (Account a : accountsList) {
            if (a.getId() == tempID) {
                System.out.println(a.toString());
            }
        }
    }

    public void safeAndCalculateComissions(double money, int numberWith) {
        List<Account> accountList = serializableAndDesirializable.deserializeAccount();
        double tempkof = searchTransferCoefficient(accountList, numberWith, 999);
        money = money * tempkof;
    }

    public int searcClientsIdByLogin(List<Users> users, String login) {
        int tempId = 0;
        for (Users u : users) {
            if (u.getLogin().equals(login)) {
                tempId = u.getId();
            }
        }
        return tempId;
    }
    public List<Integer> searchAllAccountsById(List<Account> accountsList, int id) {
        List<Integer> allAccountsClient = new ArrayList<>();
        for (Account a : accountsList) {
            if (a.getId() == id) {
                allAccountsClient.add(a.getNumberAccount());
            }
        }
        return allAccountsClient;
    }

    public List<Account> clientAccountDeletion(List<Account> accountList, List<Integer> massAccountNumber) {
       int j=0;
        for (Integer a:massAccountNumber) {
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getNumberAccount() == a) {
                    j = i;
                    break;
                }
            }
            accountList.remove(j);
        }
        serializableAndDesirializable.serializableAccount(accountList);
        return accountList;
    }

    public List<Account> idAccountRecalculating( List<Account> accountList, int id) {
        boolean flag;
        do {
            flag = true;
            List<Integer> massNumber = searchAllAccountsById(accountList, id + 1);
            for(int i=0;i<massNumber.size();i++)
            for (Account a : accountList) {
                if (a.getNumberAccount() == massNumber.get(i)) {
                    a.setId(id);
                    flag = false;
                    break;
                }
            }
            id++;
        } while (!flag);
        return accountList;
    }
    public void creatingOperations(int numberAccount,int numberWith,double money,double peny,boolean flag){
        List<Account> accountList= serializableAndDesirializable.deserializeAccount();
        List<Users> users=serializableAndDesirializable.deserializeUsers();
        List<OperationsHistory> historyList = serializableAndDesirializable.deserializeOperations();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        StatusOperations statusOperations;
        if(flag){
            statusOperations=StatusOperations.PAID;
        }else{
             statusOperations=StatusOperations.NOTPAID;
        }
        OperationsHistory  operations= new OperationsHistory(localDateTime,cretedNumberOperations (historyList),
                "перевод денег",users.get(accountList.get(searchByAccountNumber(accountList,numberWith)).getId()).getLogin(),
                numberAccount,accountList.get(searchByAccountNumber(accountList,numberWith)).getCurrency()
                ,money,peny,statusOperations);
        historyList.add(operations);
        serializableAndDesirializable.serializableOperation(historyList);
        System.out.println("Чек "+operations.getNumberOperation()+
                "\nДата и время операции:" +operations.getDate().format(dateTimeFormatter)+
                ". Логин: "+operations.getLogin() +
                ". перевод "+operations.getMoney()+" "+operations.getCurrency()+
                " на счет "+operations.getNumberAccount()+". комиссия "+operations.getComissioms()+
                ". Итоговая сумма:"+(operations.getMoney()+operations.getComissioms())+
                ". Статус операции: "+operations.getStatusOperations().toString());
    }
    public void creatingOperations(int numberAccount,double money,double peny){
        List<Account> accountList= serializableAndDesirializable.deserializeAccount();
        List<Users> users=serializableAndDesirializable.deserializeUsers();
        List<OperationsHistory> historyList = serializableAndDesirializable.deserializeOperations();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        OperationsHistory  operations= new OperationsHistory(localDateTime,cretedNumberOperations (historyList),
                "жепозит денег",users.get(accountList.get(searchByAccountNumber(accountList,numberAccount)).getId()).getLogin(),
                numberAccount,accountList.get(searchByAccountNumber(accountList,numberAccount)).getCurrency()
                ,money,peny,StatusOperations.PAID);
        historyList.add(operations);
        serializableAndDesirializable.serializableOperation(historyList);
        System.out.println("Чек "+operations.getNumberOperation()+
                "\nДата и время операции:" +operations.getDate().format(dateTimeFormatter)+
                ". Логин: "+operations.getLogin() +
                ". депозит "+operations.getMoney()+" "+operations.getCurrency()+
                " на счет "+operations.getNumberAccount()+". комиссия "+operations.getComissioms()+
                ". Итоговая сумма:"+(operations.getMoney()+operations.getComissioms())+
                ". Статус операции: "+operations.getStatusOperations().toString());
    }
    public  int cretedNumberOperations (List<OperationsHistory> historyList) {
        boolean flag = false;
        int i = 0;
        int tempNumber = (int) (Math.random() * 1000);
        do {
            for (OperationsHistory h : historyList) {
                if (h.getNumberOperation() == tempNumber) {
                    i++;
                }
            }
            if (i > 0) {
                tempNumber = (int) (Math.random() * 1000);
            } else {

                flag = true;
            }
        } while (!flag);
        return tempNumber;
    }
    public void addSummComissions(double temp){
        List<Double> temp1=serializableAndDesirializable.deserializeCommisions();
        double temp3=temp+temp1.get(0);
        List<Double> temp2=new ArrayList<>();
        temp2.add(temp3);
        serializableAndDesirializable.serializableCommisions(temp2);
        List<Double> cc=serializableAndDesirializable.deserializeCommisions();
        System.out.println(cc.toString());
    }
}
