package Products;



import Languages.LanguageTranslator;



import java.util.Scanner;



public class ProductFactory {
    public static Product createProduct(LanguageTranslator service, Scanner scanner) {
        System.out.println("Select product type: ");

        System.out.println("01. Car"      );
        System.out.println("02. Part"     );
        System.out.println("03. Service"  );

        System.out.print(service.getMessage("ENTER_CHOICE") + " ");

        return switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> ProductFactory.createCar     (service, scanner);
            case 2 -> ProductFactory.createPart    (service, scanner);
            case 3 -> ProductFactory.createService (service, scanner);

            default -> throw new RuntimeException(service.getMessage("ERROR_PFP"));
        };
    }



    private static Car createCar(LanguageTranslator service, Scanner scanner) {
        System.out.print(service.getMessage("ENTER_PRODUCT_E") + " ");  String  name    =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_D") + " ");  String  desc    =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_N") + " ");  String  numb    =   scanner.nextLine();

        System.out.print(service.getMessage("ENTER_CAR_B") + " ");  String  brand   =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_CAR_M") + " ");  String  model   =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_CAR_C") + " ");  String  color   =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_CAR_P") + " ");  String  power   =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_CAR_Y") + " ");  String  year    =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_CAR_L") + " ");  String  manual  =   scanner.nextLine();

        return new Car(name, desc, numb, brand, model, color, Integer.parseInt(power), Integer.parseInt(year), Boolean.parseBoolean(manual));
    }



    private static Part createPart(LanguageTranslator service, Scanner scanner) {
        System.out.print(service.getMessage("ENTER_PRODUCT_E") + " ");  String name     =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_D") + " ");  String desc     =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_N") + " ");  String numb     =   scanner.nextLine();

        System.out.print(service.getMessage("ENTER_PART_M") + " "); String materials    =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PART_D") + " "); String dimension    =   scanner.nextLine();

        return new Part(name, desc, numb, materials, dimension);
    }



    private static Service createService(LanguageTranslator service, Scanner scanner) {
        System.out.print(service.getMessage("ENTER_PRODUCT_E") + " ");  String name     =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_D") + " ");  String desc     =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_PRODUCT_N") + " ");  String numb     =   scanner.nextLine();

        System.out.print(service.getMessage("ENTER_SERVICE_I") + " ");  String dataInfo =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_SERVICE_T") + " ");  String dataTime =   scanner.nextLine();
        System.out.print(service.getMessage("ENTER_SERVICE_C") + " ");  String dataCond =   scanner.nextLine();

        return new Service(name, desc, numb, dataInfo, dataTime, dataCond);
    }
}
