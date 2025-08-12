package Views;



import java.util.Scanner;



import Application.Application;



public class LangView extends BaseView implements ViewStrategy {
    public LangView(Application application) {
        super(application);
    }



    @Override
    public Integer render(Scanner scanner) {
        this.outputSpace();

        System.out.println("Please enter the language you would like to view: ");

        System.out.println("1. English  ");
        System.out.println("2. Bulgarian");

        System.out.print("Enter your choice: ");

        return Integer.parseInt(scanner.nextLine());
    }



    @Override
    public void action(Integer choice) {
        this.associatedApp.getLangService().changeLanguage(choice);
    }
}
