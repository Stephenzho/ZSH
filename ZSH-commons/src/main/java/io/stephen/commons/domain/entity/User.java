package io.stephen.commons.domain.entity;


import java.util.List;

/**
 * 用户Bean
 * @author zhouShuYi
 */
public class User extends Throwable  {

    private static final long serialVersionUID = 1435515995276255188L;

    protected String userID;
    protected String password;
    protected String userName;
    protected String sex;
    protected String registerTime;
    protected String email;
    protected String avatar;
    protected String enabled;
    protected List<String> roles;


    public String getUserID() {
        return userID;
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", enabled='" + enabled + '\'' +
                ", roles=" + roles +
                '}';
    }
}
