package Views;



import Application.Application;

import Menu.Command         ;
import Menu.CommandsList.*  ;



import java.util.Scanner;



public class GestView extends BaseView implements ViewStrategy {
    public GestView(Application application) {
        super(application);
    }



    @Override
    public Integer render(Scanner scanner) {
        this.outputSpace();

        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_GUEST_ADL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_GUEST_SRL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_GUEST_STL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_GUEST_BCK"));

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHOICE") + " ");

        return Integer.parseInt(scanner.nextLine());
    }



    @Override
    public void action(Integer choice) {
        switch (choice) {
            case 1  -> this.showListings    ()  ;
            case 2  -> this.searchListings  ()  ;
            case 3  -> this.statsListings   ()  ;
            case 4  -> this.back            ()  ;

            default -> throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_COM"));
        }
    }



    private void showListings() {
        this.outputSpace();

        Command command = new ShowFullListingCommand(this.associatedApp.getListService());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            this.associatedApp.getLangService().getMessage("STATUS_OK");
        } else {
            this.associatedApp.getLangService().getMessage("STATUS_ER");
        }
    }

    private void searchListings() {
        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_QR") + " ");

        String query = this.associatedApp.getScanner().nextLine();

        Command command = new SrcListingCommand(this.associatedApp.getListService(), query);

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            this.associatedApp.getLangService().getMessage("STATUS_OK");
        } else {
            this.associatedApp.getLangService().getMessage("STATUS_ER");
        }
    }

    private void statsListings() {
        this.outputSpace();

        Command command = new StatsListingCommand(this.associatedApp.getListService());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            this.associatedApp.getLangService().getMessage("STATUS_OK");
        } else {
            this.associatedApp.getLangService().getMessage("STATUS_ER");
        }
    }



    private void back() {
        this.associatedApp.setUserCurr(""                               );
        this.associatedApp.setBaseView(new InitView(this.associatedApp) );
    }
}
