package banking.fuctional;

import banking.objeckt.*;

import java.util.List;

public interface generalFuctionality {
    boolean checkLogin(List<Users> users, String login);

    List<Users> idRecalculating(List<Users> users);

    double searchTransferCoefficient(List<Account> accountList, int numberWith, int numberIn);

    int generateNumberAccount(List<Account> list);

    Currency choiceCurrency(String curency);

    void outputInformation(Users user);

    void outputAccountIntformation(Users users);

    double searchTransferCoefficientByCyrrency(Currency currency);

    int searchByAccountNumber(List<Account> accounts, int number);

    Role changeRole(String role);

    List<Users> registrtionClient(List<Users> users, Users user);

    void outputClientInformationByLogin(String log, List<Users> users, List<Account> accountsList);

    int searcClientsIdByLogin(List<Users> users, String login);

    List<Integer> searchAllAccountsById(List<Account> accountsList, int id);

    List<Account> clientAccountDeletion(List<Account> accountList, List<Integer> massAccountNumber);

    List<Account> idAccountRecalculating(List<Account> accountList, int id);

    void creatingOperations(int numberAccount, int numberWith, double money, double peny, boolean flag);

    void creatingOperations(int numberAccount, double money, double peny);

    int cretedNumberOperations(List<OperationsHistory> historyList);

    void addSummComissions(double temp);

}
