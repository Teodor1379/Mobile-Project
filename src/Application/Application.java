package Application;



import java.util.Scanner;



import Menu.*               ;
import Menu.CommandsUser.*  ;
import Menu.CommandsList.*  ;
import Menu.CommandsChat.*  ;

import Users.*              ;
import Views.*              ;

import Listings.*           ;
import Notifications.*      ;
import Languages.*          ;



public class Application {
    private static  Application     APPLICATION ;

    private final   Scanner         scanner     ;
    private         String          userCurr    ;
    private         ViewStrategy    baseView    ;
    private         CommandRegistry registry    ;

    private final   UserService         userService;
    private final   NotificationService notfService;
    private final   ListingService      listService;
    private         LanguageTranslator  langService;





    private Application() {
        this.scanner    =   new Scanner(System.in)      ;
        this.userCurr   =   ""                          ;
        this.baseView   =   new LangView(this);
        this.registry   =   new CommandRegistry()       ;

        this.userService    =   new UserService         (new UserContainer()                        );
        this.notfService    =   new NotificationService (                                           );
        this.listService    =   new ListingService      (new ListingContainer(), this.notfService   );
        this.langService    =   new LanguageTranslator  (                                           );
    }



    public static Application getInstance() {
        if (APPLICATION == null) {
            APPLICATION = new Application();
        }

        return APPLICATION;
    }



    public Scanner          getScanner  ()  { return this.scanner   ;   }
    public String           getUserCurr ()  { return this.userCurr  ;   }
    public ViewStrategy     getBaseView ()  { return this.baseView  ;   }
    public CommandRegistry  getRegistry ()  { return this.registry  ;   }

    public UserService          getUserService()    { return this.userService;  }
    public NotificationService  getNotfService()    { return this.notfService;  }
    public ListingService       getListService()    { return this.listService;  }
    public LanguageTranslator   getLangService()    { return this.langService;  }



    public  void    setUserCurr(String          userCurr)   { this.userCurr = userCurr; }
    public  void    setBaseView(ViewStrategy    baseView)   { this.baseView = baseView; }



    public void run() {
        System.out.println("Welcome to the Application!");


        Integer choice = this.baseView.render(this.scanner);
        this.baseView.action(choice);


        this.baseView = new InitView(this);

        while (true) {
            try {
                choice = this.baseView.render(this.scanner);
                this.baseView.action(choice);
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
