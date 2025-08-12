import Application.Application;



public class Main {
    public static void main(String[] args) {
        try {
            Application.getInstance().run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
