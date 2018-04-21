package io.stephen.test.enums;

/**
 * @author 10447
 * @since 2018/4/9
 */
public class EnSingle {


    public enum En{
        SINGLE;

        public class aaa{
            private String a = "123";

            @Override
            public String toString() {
                return "aaa{" +
                        "a='" + a + '\'' +
                        '}';
            }
        }

        private aaa es;

        En() {
            System.out.println("加载枚举");
            es = new aaa();
        }

        public aaa getInstance(){
            return es;
        }

    }

    private EnSingle() {
    }

    public static En.aaa getInstance(){
        return En.SINGLE.getInstance();
    }

}
