package Views;



import Application.Application;

import Menu.Command         ;
import Menu.CommandsUser.*  ;
import Menu.CommandsChat.*  ;
import Menu.CommandsList.*  ;
import Menu.CommandsChan.*  ;

import Listings.Listing;

import Products.Product         ;
import Products.ProductFactory  ;



import java.util.Scanner;



public class UserView extends BaseView implements ViewStrategy {
    public UserView(Application application) {
        super(application);
    }



    @Override
    public Integer render(Scanner scanner) {
        this.outputSpace();

        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_ADL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_RML"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_EDL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_SAL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_SOL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_SBL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_SRL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_STL"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_CRC"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_SNM"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_VWM"));
        System.out.println(this.associatedApp.getLangService().getMessage("OPTION_USER_LOS"));

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHOICE") + " ");

        return Integer.parseInt(scanner.nextLine());
    }



    @Override
    public void action(Integer choice) {
        switch (choice) {
            case  1 -> this.addListing      ()  ;
            case  2 -> this.remListing      ()  ;
            case  3 -> this.updListing      ()  ;
            case  4 -> this.showAllListing  ()  ;
            case  5 -> this.showOwnListing  ()  ;
            case  6 -> this.showBuyListing  ()  ;
            case  7 -> this.searchListing   ()  ;
            case  8 -> this.statsListing    ()  ;
            case  9 -> this.createChannel   ()  ;
            case 10 -> this.sendMessage     ()  ;
            case 11 -> this.viewMessage     ()  ;
            case 12 -> this.logOut          ()  ;
        }
    }



    public void addListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.println("If you create something else from the car, the filter is not implemented yet... :)");

        Product product = ProductFactory.createProduct(this.associatedApp.getLangService(), this.associatedApp.getScanner());

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_P") + " ");  String  price       =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_T") + " ");  String  title       =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_D") + " ");  String  descrip     =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_C") + " ");  String  category    =   this.associatedApp.getScanner().nextLine();

        Listing listing = new Listing(product, Double.parseDouble(price), title, descrip, category);

        Command command = new AddListingCommand(listing, this.associatedApp.getListService(), this.associatedApp.getUserCurr());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_LSA"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void remListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_T") + " ");

        String title = this.associatedApp.getScanner().nextLine();

        Command command = new RemListingCommand(this.associatedApp.getListService(), title, this.associatedApp.getUserCurr());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_LSR"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void updListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_P") + " ");  String price    =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_T") + " ");  String title    =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_D") + " ");  String descrip  =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_LISTING_C") + " ");  String category =   this.associatedApp.getScanner().nextLine();

        Command command = new EdtListingCommand(this.associatedApp.getListService(), Double.parseDouble(price), title, descrip, category);

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_LSU"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void showAllListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        Command command = new ShowFullListingCommand(this.associatedApp.getListService());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void showOwnListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        Command command = new ShowOwnListingCommand(
                this.associatedApp.getListService(),
                this.associatedApp.getUserCurr()
        );

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void showBuyListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        Command command = new ShowBuyListingCommand(
                this.associatedApp.getListService(),
                this.associatedApp.getUserCurr()
        );

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void searchListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_QR") + " ");

        String query = this.associatedApp.getScanner().nextLine();

        Command command = new SrcListingCommand(this.associatedApp.getListService(), query);

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void statsListing() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        Command command = new StatsListingCommand(this.associatedApp.getListService());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }



    public void createChannel() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CH") + " ");

        String channel  =   this.associatedApp.getScanner().nextLine()  ;

        Command command = new AddChannelCommand(
                this.associatedApp.getUserService(),
                this.associatedApp.getUserCurr(),
                channel
        );

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_CHN"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }



    public void sendMessage() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHAT_USER") + " ");  String user =   this.associatedApp.getScanner().nextLine();
        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHAT_MESS") + " ");  String mess =   this.associatedApp.getScanner().nextLine();

        Command command = new SndMessageCommand(
                this.associatedApp.getUserService   (),
                this.associatedApp.getUserCurr      (),
                user, mess
        );

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }

    public void viewMessage() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        System.out.print(this.associatedApp.getLangService().getMessage("ENTER_CHAT_USER") + " ");

        String user =   this.associatedApp.getScanner().nextLine();

        Command command = new ShwMessageCommand(
                this.associatedApp.getUserService   (),
                this.associatedApp.getUserCurr      (),
                user
        );

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("ERROR_MSC"));
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }



    public void logOut() {
        if (this.associatedApp.getUserCurr().isEmpty()) {
            throw new RuntimeException(this.associatedApp.getLangService().getMessage("ERROR_ANT"));
        }

        this.outputSpace();

        Command command = new LogOCommand(this.associatedApp.getUserCurr());

        if (this.associatedApp.getRegistry().setCommand(command).executeCommand()) {
            this.associatedApp.setUserCurr(""                               );
            this.associatedApp.setBaseView(new InitView(this.associatedApp) );

            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_OK"));
        } else {
            System.out.println(this.associatedApp.getLangService().getMessage("STATUS_ER"));
        }
    }
}
