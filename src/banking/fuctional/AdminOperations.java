package banking.fuctional;

import banking.exception.AutorizationException;
import banking.objeckt.*;
import banking.repsitory.SerializableAndDesirializable;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AdminOperations implements AbstractAdminOperation {
    SerializableAndDesirializable serializableAndDesirializable = new SerializableAndDesirializable();
Opetaions opetaions =new Opetaions();
    @Override
    public void downloadCourseFile() {
        Map<String,Double> map=serializableAndDesirializable.deserializeCurrencyDop();
        serializableAndDesirializable.serializableCurrency(map);
        System.out.println("Загрузка файла завершена");
    }

    @Override
    public void viewAllClients() {
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        System.out.print(usersList.toString());
    }

    @Override
    public void viewCustomerTransactions(String login) {
        List<OperationsHistory> operationsHistories=serializableAndDesirializable.deserializeOperations();
        for (OperationsHistory o:operationsHistories) {
            if (o.getLogin().equals(login)) {
                System.out.println(o.toString());
            }
            }
        }
    @Override
    public void deletingClient(String login) {
        List<Users> users = serializableAndDesirializable.deserializeUsers();
        List<Account> accountList = serializableAndDesirializable.deserializeAccount();
        int tempId = opetaions.searcClientsIdByLogin(users, login);
       accountList= opetaions.clientAccountDeletion(accountList, opetaions.searchAllAccountsById(accountList, tempId));
        accountList = opetaions.idAccountRecalculating(accountList, tempId);
        users.remove(tempId);
        users = opetaions.idRecalculating(users);
        serializableAndDesirializable.serializableUsers(users);
        serializableAndDesirializable.serializableAccount(accountList);
    }

    @Override
    public void viewAccountWithCommissions() {
        List<Account> accountList=serializableAndDesirializable.deserializeAccount();
        for (Account a:accountList) {
            if(a.getId()==999){
                System.out.println("Счет с комиссиями: "+a.toString());
                break;
            }

        }

    }

    @Override
    public void viewTransactionsWithUnpaidCommissions() {
        List<OperationsHistory> operationsHistories=serializableAndDesirializable.deserializeOperations();
        for (OperationsHistory op:operationsHistories) {
            if(op.getStatusOperations().equals(StatusOperations.NOTPAID)){
                System.out.println(op.toString());
            }
        }

    }

    @Override
    public void transferOfCommissionsToTheAccount() {
        List<Account> accountList = serializableAndDesirializable.deserializeAccount();
        List<Double> commisions = serializableAndDesirializable.deserializeCommisions();
        for (Account a : accountList) {
            if (a.getId() == 999) {
                a.setMoney(a.getMoney()+commisions.get(0));
            }
        }
       double temp=0.0;
        List<Double> commisionss = new ArrayList<>();
        commisionss.add(temp);
        serializableAndDesirializable.serializableCommisions(commisionss);
        serializableAndDesirializable.serializableAccount(accountList);
    }

    @Override
    public void receiveTheAmountOfCommissionsNotTransferredToTheAccount() {
        List<Double> commisions = serializableAndDesirializable.deserializeCommisions();
        if(commisions!=null) {
            System.out.println("Сумма комиссий не перевведенных на счет: " + commisions.get(0).toString());
        }
    }

    @Override
    public void userRegistration(String login, int password, String name, String role) {
        List<Users> users = serializableAndDesirializable.deserializeUsers();
        Users user = new Users(0, login, password, name, opetaions.changeRole(role));
        users = opetaions.registrtionClient(users, user);
        serializableAndDesirializable.serializableUsers(users);

    }

    @Override
    public void viewClientByLogin(String log) {

        List<Users> users = serializableAndDesirializable.deserializeUsers();
        List<Account> accountsList = serializableAndDesirializable.deserializeAccount();
        opetaions.outputClientInformationByLogin(log, users, accountsList);
    }

    @Override
    public void viewAllAccounts() {
        List<Account> accountsList = serializableAndDesirializable.deserializeAccount();
        System.out.println(accountsList.toString());
    }

    @Override
    public void viewAllTransactions() {
        List<OperationsHistory> historyList = serializableAndDesirializable.deserializeOperations();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyy HH:mm:ss");
        for (OperationsHistory operations:historyList) {
            System.out.println("Чек "+operations.getNumberOperation()+
                    "\nДата и время операции:" +operations.getDate().format(dateTimeFormatter)+
                    ". Логин: "+operations.getLogin() +
                    ". перевод "+operations.getMoney()+" "+operations.getCurrency()+
                    " на счет "+operations.getNumberAccount()+". комиссия "+operations.getComissioms()+
                    ". Итоговая сумма:"+(operations.getMoney()+operations.getComissioms())+
                    ". Статус операции "+operations.getStatusOperations().toString());
        }
    }

    @Override
    public Users changePassword(Users user, int newPassword) {
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        usersList.get(user.getId()).setPassword(newPassword);
        user.setPassword(newPassword);
        serializableAndDesirializable.serializableUsers(usersList);
        return user;
    }

    @Override
    public Users changeLogin(Users user, String newlogin) {
        List<Users> usersList = serializableAndDesirializable.deserializeUsers();
        boolean flag = opetaions.checkLogin(usersList, newlogin);
        try {
            if (!flag) {
                usersList.get(user.getId()).setLogin(newlogin);
                user.setLogin(newlogin);
                System.out.println(user.getLogin());
            } else {
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

    @Override
    public void creatingAnAccount(Users user, String curency) {
        List<Account> accountsList = serializableAndDesirializable.deserializeAccount();
        int numberAccount = opetaions.generateNumberAccount(accountsList);
        Currency cur = opetaions.choiceCurrency(curency);
        Account newAccount = new Account(user.getId(), numberAccount, cur, 0.0);
        accountsList.add(newAccount);
        serializableAndDesirializable.serializableAccount(accountsList);
    }


}
