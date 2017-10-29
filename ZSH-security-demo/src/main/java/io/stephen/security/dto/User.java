package io.stephen.security.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author 10447
 * @since 2017/10/29
 */
public class User {

    public interface userSimpleView{};
    public interface userDetailView extends userSimpleView{};

    private String username;
    private String password;
    private String id;


    @JsonView(userDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(userSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(userSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
