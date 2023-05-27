package banking.fuctional;

import banking.objeckt.Users;

public interface SuperUserOperation {
    Users changePassword(Users user, int newPassword);

    Users changeLogin(Users user, String newlogin);

    void creatingAnAccount(Users user, String curency);
}
