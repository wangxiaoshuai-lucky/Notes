package cn.wzy.algorithm;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println(f().age);
    }

    static class User {
        Integer age;
    }

    private static User f() {
        User a = new User();
        a.age = 1;
        try {
            a.age = 15;
            System.out.println("try" + a.age);
            return a;
        } finally {
            a.age++;
            System.out.println("finally" + a);
        }
    }
}
