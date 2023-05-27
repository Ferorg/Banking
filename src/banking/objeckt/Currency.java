package banking.objeckt;

public enum Currency {
    BYN("Белорусский рубль"),
    RUB("Российский рубль"),
    USD("Доллар США"),
    EUR("Евро");
    private String curency;

    Currency(String curency) {
        this.curency = curency;
    }

    public String getCurency() {
        return curency;
    }

    public void setCurency(String curency) {
        this.curency = curency;
    }

}
