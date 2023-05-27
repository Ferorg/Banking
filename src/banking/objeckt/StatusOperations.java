package banking.objeckt;

public enum StatusOperations {
    PAID("ОПЛАЧЕНО"),
    NOTPAID("Не оплачено");
    private String statusOperations;

    StatusOperations(String statusOperations) {
        this.statusOperations = statusOperations;
    }

    @Override
    public String toString() {
        return statusOperations;
    }
}
