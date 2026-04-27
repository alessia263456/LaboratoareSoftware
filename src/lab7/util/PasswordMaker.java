package lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
    private static PasswordMaker instance;
    private String name;
    private static int counter;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker("default");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance() {
        counter++;
        return instance;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
    public static int getCallingCount() {
        return counter;
    }
}

