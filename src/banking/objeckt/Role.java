package banking.objeckt;

public enum Role {
    ADMIN("Админ"),
    CLIENT("Пользователь");
    private String role;


    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
