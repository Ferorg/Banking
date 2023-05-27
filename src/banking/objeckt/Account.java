package banking.objeckt;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Account implements Serializable {
    private int id;
    Currency currency;
    private int numberAccount;
    private Double money;
    public static double peny;
    public static final long serialVersionUID = 1l;
    private List<Account> accountList;


    public Account(int id, int numberAccount, Currency currency, Double money) {
        this.id = id;
        this.currency = currency;
        this.numberAccount = numberAccount;
        this.money = money;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "id=" + id +
                ", currency=" + currency +
                ", numberAccount=" + numberAccount +
                ", money=" + money +
                '}';
    }
}
