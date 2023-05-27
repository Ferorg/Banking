package banking.fuctional;

import banking.objeckt.Users;

public interface AbstractClientOperation extends SuperUserOperation {
    void curencyExchange(int numberWith, int numberIn,double money);
    void transferringFundsToAnotherAccoint(int numberWith, int numberIn,double money);
    void viewAccountBalance(Users user);
    void viewCurrentRates();
    void creatingAnAccount(Users user,String curency);
    void depositingMoneyIntoAnAccount(Users user,int number,Double money);
    void accountDeletion(int num);
    void calculationOfTheTotalAmountInTheAccountsInBYN(Users user);
    void operationHistory(Users user);
    Users changePassword(Users user,int newPassword);
    Users changeLogin(Users user, String newlogin);


}
