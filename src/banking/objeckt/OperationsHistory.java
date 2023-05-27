package banking.objeckt;

import banking.objeckt.Currency;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class OperationsHistory implements Serializable {
    private LocalDateTime date;
    private int numberOperation;
    private String textOperation;
    private String login;
    private int numberAccount;
    Currency currency;
    private double money;
    private double comissioms;
    private StatusOperations statusOperations;
    private static final long serialVersionUID =2;

    public OperationsHistory(LocalDateTime date, int numberOperation, String textOperation,
                             String login, int numberAccount, Currency currency, double money,
                             double comissioms,StatusOperations statusOperations) {
        this.date = date;
        this.numberOperation = numberOperation;
        this.textOperation = textOperation;
        this.login = login;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.money = money;
        this.comissioms = comissioms;
        this.statusOperations=statusOperations;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNumberOperation() {
        return numberOperation;
    }

    public void setNumberOperation(int numberOperation) {
        this.numberOperation = numberOperation;
    }

    public String getTextOperation() {
        return textOperation;
    }

    public void setTextOperation(String textOperation) {
        this.textOperation = textOperation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getComissioms() {
        return comissioms;
    }

    public void setComissioms(double comissioms) {
        this.comissioms = comissioms;
    }

    public StatusOperations getStatusOperations() {
        return statusOperations;
    }

    public void setStatusOperations(StatusOperations statusOperations) {
        this.statusOperations = statusOperations;
    }

    @Override
    public String toString() {
        return "OperationsHistory{" +
                "date=" + date +
                ", numberOperation=" + numberOperation +
                ", textOperation='" + textOperation + '\'' +
                ", login='" + login + '\'' +
                ", numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", money=" + money +
                ", comissioms=" + comissioms +
                ", statusOperations=" + statusOperations +
                '}';
    }
}
