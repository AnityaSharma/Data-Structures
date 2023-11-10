package OOPS.Singelton;

public class Singelton {
    private Singelton() {

    }
    private static Singelton instance;
    public static Singelton getInstance(){
        if (instance == null){
            instance = new Singelton();
        }
        return instance;
    }

}
