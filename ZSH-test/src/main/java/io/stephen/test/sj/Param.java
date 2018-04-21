package io.stephen.test.sj;

/**
 * @author 10447
 * @since 2018/3/16
 */
public class Param {

    private Integer value;

    private  int num = 0;

    public Param(int value, int num) {
        this.value = value;
        this.num = num;
    }


    public Integer getValue() {
        return value;
    }

    public int getNum() {
        return num;
    }

    public void addNum() {
        num++;
    }

    @Override
    public String toString() {
        return value.toString() + "出现了" + num + "次";
    }

}
