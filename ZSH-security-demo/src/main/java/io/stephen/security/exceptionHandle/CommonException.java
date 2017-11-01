package io.stephen.security.exceptionHandle;

/**
 * 通用异常
 * @author 10447
 * @since 2017/10/31
 */
public class CommonException extends Exception {

    private String id;

    public CommonException(String id) {
        super("内部出错");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
