package Views;



import Application.Application;

import Users.User;

import Menu.Command                     ;
import Menu.CommandsUser.AddUserCommand ;
import Menu.CommandsUser.LogICommand    ;



import java.util.Scanner;



public class InitView extends BaseView implements ViewStrategy {
    public InitView(Application application) {
        super(application);
    }



    @Override
    public Integer render(Scanner scanner) {
        this.outputSpace();

        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_SU"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_SI"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_GU"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_EA"));

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHOICE") + " ");

        return Integer.parseInt(scanner.nextLine());
    }



    @Override
    public void action(Integer choice) {
        switch (choice) {
            case 1 -> this.regst()          ;
            case 2 -> this.login()          ;
            case 3 -> this.guest()          ;
            case 4 -> System.exit(0)    ;

            default -> throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_COMM"));
        }
    }



    private void regst() {
        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_US") + " "); String username = this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_EM") + " "); String email    = this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_PH") + " "); String phone    = this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_PS") + " "); String password = this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_AD") + " "); String address  = this.associatedApp.getScanner().nextLine();

        User user = new User(username, email, phone, password, address);

        Command command = new AddUserCommand(this.associatedApp.getUserService(), user);

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_ADU"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    private void login() {
        if (!this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_US") + " "); String username =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_PS") + " "); String password =   this.associatedApp.getScanner().nextLine();

        Command command = new LogICommand(this.associatedApp.getUserService(), username, password);

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            this.associatedApp.setUserCurr(username                         );
            this.associatedApp.setBaseView(new UserView(this.associatedApp) );

            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    private void guest() {
        this.associatedApp.setUserCurr("GUEST"                          );
        this.associatedApp.setBaseView(new GestView(this.associatedApp) );
    }
}
