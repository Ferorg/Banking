package banking.fuctional;

public interface AbstractAdminOperation extends SuperUserOperation {
    void viewAllClients();
    void viewCustomerTransactions(String login);
    void deletingClient(String login);
    void viewAccountWithCommissions();
    void viewTransactionsWithUnpaidCommissions();
    void transferOfCommissionsToTheAccount();
    void receiveTheAmountOfCommissionsNotTransferredToTheAccount();
    void userRegistration(String login, int password, String name, String role);
    void viewClientByLogin(String log);
    void viewAllAccounts();
    void viewAllTransactions();
    void downloadCourseFile();


}
