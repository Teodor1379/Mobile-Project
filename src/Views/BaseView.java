package Views;



import Application.Application;



public abstract class BaseView {
    protected Application associatedApp;



    public BaseView(Application associatedApp) {
        this.associatedApp = associatedApp;
    }



    public void outputSpace() {
        for (int i = 0; i < 10; ++i) {
            System.out.print("\n");
        }
    }
}
