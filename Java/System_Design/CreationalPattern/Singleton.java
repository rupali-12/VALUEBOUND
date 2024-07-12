public class Singleton {
    private static Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        // if (instance == null) {
        // synchronized (Singleton.class) {
        // if (instance == null) {
        // instance = new Singleton(data);
        // }
        // }
        // }

        // us9ing local variable improve the method overall performance by 40%
        Singleton result = instance;
        if (instance == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (instance == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        // return instance;
        return result;
    }
}