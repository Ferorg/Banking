package banking.objeckt;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    private int id;
    private String login;
    private int password;
    private String name;
    private Role role;
    private static final long serialVersionUID =1;

    public Users(int id, String login, int password, String name, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\nUsers{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

}
