package io.stephen.security.demo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.stephen.security.demo.validator.CustomizedValidator;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author 10447
 * @since 2017/10/29
 */
public class User {

    public interface userSimpleView{};
    public interface userDetailView extends userSimpleView{};

    @ApiModelProperty("用户名")
    @CustomizedValidator(message = "验证username")
    private String username;

    @ApiModelProperty("用户密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Length(min = 8,max = 12,message = "ID格式错误")
    @ApiModelProperty("用户ID")
    private String id;

    @ApiModelProperty("用户生日")
    @Past(message = "请填写正确的时间")
    private Date birthday;


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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
