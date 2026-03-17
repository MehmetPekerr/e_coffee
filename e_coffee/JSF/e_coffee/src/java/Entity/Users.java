package entity;

import java.io.Serializable;
import java.util.Objects;

public class Users implements Serializable {

    private Long user_id;
    private String username;
    private String password;
    private Roles role_id;
    private Addresses address_id;

    public Users() {
    }

    public Users(String username, String password, Roles role_id, Addresses address_id) {
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.address_id = address_id;
    }

    public Users(Long user_id, String username, String password, Roles role_id, Addresses address_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.address_id = address_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole_id() {
        return role_id;
    }

    public void setRole_id(Roles role_id) {
        this.role_id = role_id;
    }

    public Addresses getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Addresses address_id) {
        this.address_id = address_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.user_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        return Objects.equals(this.user_id, other.user_id);
    }
}
