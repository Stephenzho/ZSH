package io.stephen.test;

/**
 * @author zhoushuyi
 * @since 2018/5/31
 */
public class BeanTe {

    private String name;
    private String value;

    private Integer code;

    public Integer look() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"name："+name);
        System.out.println(Thread.currentThread().getName()+"value："+value);


        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"name："+name);
        System.out.println(Thread.currentThread().getName()+"value："+value);
        return code;
    }


    public BeanTe() {
    }

    public BeanTe(String name, String value, Integer code) {
        this.name = name;
        this.value = value;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
