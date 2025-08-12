package Views;



import java.util.Scanner;



public interface ViewStrategy {
    Integer render(Scanner scanner);

    void action(Integer choice);
}
