public class Check {
    public static void main(String[] args) {

    }
}
class Singleton {
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){ // Single check
            synchronized (Singleton.class){
                if (instance == null){ // Double check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


















