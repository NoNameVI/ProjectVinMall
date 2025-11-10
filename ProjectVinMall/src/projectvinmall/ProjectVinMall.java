package projectvinmall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Comparator;

interface IMall {

    void sortByName();

    void sortByRating();

    void sortByPrice();
}

public class ProjectVinMall {

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String BLUE = "\u001B[34m";
    public static String PURPLE = "\u001B[35m";
    public static String CYAN = "\u001B[36m";
    public static String WHITE = "\u001B[37m";
    
    Scanner sc = new Scanner(System.in);
    ArrayList<String> BooksList = new ArrayList<>();
    ArrayList<String> AppliancesList = new ArrayList<>();
    ArrayList<String> DrinksList = new ArrayList<>();
    ArrayList<String> ElectronicsList = new ArrayList<>();
    ArrayList<String> FoodsList = new ArrayList<>();
    ArrayList<String> VehiclesList = new ArrayList<>();
    ArrayList<String> EmployeesList = new ArrayList<>();

    List<Book> bookData = new ArrayList<>();
    List<Appliance> applianceData = new ArrayList<>();
    List<Drink> drinkData = new ArrayList<>();
    List<Electronic> electronicData = new ArrayList<>();
    List<Food> foodData = new ArrayList<>();
    List<Vehicle> vehicleData = new ArrayList<>();
    List<Employee> employeeData = new ArrayList<>();

    HashMap<String, ArrayList<String>> dataMap = new HashMap<>();

    String[] fileList = {
        "foodin.txt",
        "appliancein.txt",
        "bookin.txt",
        "drinkin.txt",
        "electronicin.txt",
        "vehiclesin.txt",
        "employeein.txt"
    };

    public void setFile() {
        dataMap.put("foodin.txt", FoodsList);
        dataMap.put("appliancein.txt", AppliancesList);
        dataMap.put("bookin.txt", BooksList);
        dataMap.put("drinkin.txt", DrinksList);
        dataMap.put("electronicin.txt", ElectronicsList);
        dataMap.put("vehiclesin.txt", VehiclesList);
        dataMap.put("employeein.txt", EmployeesList);
    }

    ArrayList<String> inputLines = new ArrayList<>();
    ArrayList<String> outputLines = new ArrayList<>();

    String df;

    public void readData(String df) {
        setFile();
        try (Scanner sc = new Scanner(new File(df))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                delay(40);
                System.out.println("Data loaded: " + line);
                dataMap.get(df).add(line);
            }

            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Input Exception # " + ex);
        }

    }

    public void loadData() {
        bookData.clear();
        employeeData.clear();
        applianceData.clear();
        drinkData.clear();
        electronicData.clear();
        vehicleData.clear();
        foodData.clear();
        for (int i = 0; i < fileList.length; i++) {
            readData(fileList[i]);
            switch (fileList[i]) {
                case "bookin.txt": {
                    for (int j = 0; j < BooksList.size(); j++) {
                        String[] item = BooksList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String author = item[4];
                        int pages = Integer.parseInt(item[5]);
                        bookData.add(new Book(id, name, price, rating, author, pages));
                    }
                    break;
                }
                case "employeein.txt": {
                    for (int j = 0; j < EmployeesList.size(); j++) {
                        String[] item = EmployeesList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        String position = item[2];
                        String phoneNum = item[3];
                        double salary = Double.parseDouble(item[4]);
                        employeeData.add(new Employee(id, name, position, phoneNum, salary));
                    }
                    break;
                }
                case "appliancein.txt": {
                    for (int j = 0; j < AppliancesList.size(); j++) {
                        String[] item = AppliancesList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String brand = item[4];
                        String model = item[5];
                        int releaseYear = Integer.parseInt(item[6]);
                        applianceData.add(new Appliance(id, name, price, rating, brand, model, releaseYear));
                    }
                    break;
                }
                case "drinkin.txt": {
                    for (int j = 0; j < DrinksList.size(); j++) {
                        String[] item = DrinksList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String size = item[4];
                        drinkData.add(new Drink(id, name, price, rating, size));
                    }
                    break;
                }
                case "electronicin.txt": {
                    for (int j = 0; j < ElectronicsList.size(); j++) {
                        String[] item = ElectronicsList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String brand = item[4];
                        String model = item[5];
                        int releaseYear = Integer.parseInt(item[6]);
                        int batteryCapacity = Integer.parseInt(item[7]);

                        electronicData.add(new Electronic(id, name, price, rating, brand, model, releaseYear, batteryCapacity));
                    }
                    break;
                }
                case "vehiclesin.txt": {
                    for (int j = 0; j < VehiclesList.size(); j++) {

                        String[] item = VehiclesList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String chassisNumber = item[4];
                        String engineType = item[5];
                        String brand = item[6];
                        int manufactureYear = Integer.parseInt(item[7]);
                        double inspectionFee = Double.parseDouble(item[8]);
                        vehicleData.add(new Vehicle(id, name, price, rating, chassisNumber, engineType, brand, manufactureYear, inspectionFee));
                    }
                    break;
                }
                case "foodin.txt": {
                    for (int j = 0; j < FoodsList.size(); j++) {
                        String[] item = FoodsList.get(j).split("-");
                        String id = item[0];
                        String name = item[1];
                        double price = Double.parseDouble(item[2]);
                        double rating = Double.parseDouble(item[3]);
                        String size = item[4];
                        foodData.add(new Food(id, name, price, rating, size));
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }

    public void writeData(String df) {
        try (FileWriter fw = new FileWriter(df)) {

            ArrayList<String> tempList = dataMap.get(df);

            if (tempList != null) {

                for (String line : tempList) {
                    fw.write(line + System.lineSeparator());
                    System.out.println("Data stored: " + line);
                    delay(40);
                }
            }

        } catch (IOException ex) {
            System.out.println("Output Exception # " + ex);
        }
    }

       public void saveData() {
        for (String file : fileList) {
            switch (file) {
                case "bookin.txt":
                    BooksList.clear();
                    for (Book b : bookData) {
                        BooksList.add(b.toString());
                    }
                    dataMap.put(file, BooksList);
                    clearScreen();
                    System.out.println("\n---Book store data---\n");
                    break;
                
                case "employeein.txt":
                    EmployeesList.clear();
                    for (Employee e : employeeData) {
                        EmployeesList.add(e.getInfo());
                    }
                    dataMap.put(file, EmployeesList);
                    clearScreen();
                    System.out.println("\n---Employees data---\n");
                    break;
                
                case "appliancein.txt":
                    AppliancesList.clear();
                    for (Appliance a : applianceData) {
                        AppliancesList.add(a.toString());
                    }
                    dataMap.put(file, AppliancesList);
                    clearScreen();
                    System.out.println("\n---Appliance store data---\n");
                    break;
                
                case "drinkin.txt":
                    DrinksList.clear();
                    for (Drink d : drinkData) {
                        DrinksList.add(d.toString());
                    }
                    dataMap.put(file, DrinksList);
                    clearScreen();
                    System.out.println("\n---Drink store data---\n");
                    break;
                
                case "electronicin.txt":
                    ElectronicsList.clear();
                    for (Electronic e : electronicData) {
                        ElectronicsList.add(e.toString());
                    }
                    dataMap.put(file, ElectronicsList);
                    clearScreen();
                    System.out.println("\n---Electronic store data---\n");
                    break;
                
                case "vehiclesin.txt":
                    VehiclesList.clear();
                    for (Vehicle v : vehicleData) {
                        VehiclesList.add(v.toString());
                    }
                    dataMap.put(file, VehiclesList);
                    clearScreen();
                    System.out.println("\n---Vehicle store data---\n");
                    delay(100);
                    break;
                
                case "foodin.txt":
                    FoodsList.clear();
                    for (Food f : foodData) {
                        FoodsList.add(f.toString());
                    }
                    dataMap.put(file, FoodsList);
                    clearScreen();
                    System.out.println("\n---Food store data---\n");
                    delay(100);
                    break;
                
                default:
                    break;
            }
            writeData(file);
        }
    }

    //--------------------------------------------------Ham ho tro -------------------------------------------------------------------------------------------------------------------------------
    void listEmployee() {
        employeeData.forEach(Employee -> {
            System.out.println(Employee.getInfo());
        });
    }
    void displayElectronic(){
    electronicData.forEach(Electronic -> {
        System.out.println(Electronic.toString());
    });
    }
    void addElectronic(){
    System.out.println("Please enter ID: ");
    String EId = getValidString();
    boolean value = false;
    for (int index = 0; index < electronicData.size();index++ ){
        if (electronicData.get(index).getId().equalsIgnoreCase(EId)){
            value = true;
            System.out.println("ID already exists");
            System.out.println("Please enter another ID!");
            return;
        }      
        }
    if (!value){
    System.out.println("Please enter Name: ");
            String EName = getValidString();
            System.out.println("Please enter Price: ");
            double EPrice = sc.nextDouble();
            sc.nextLine();
            System.out.println("Please enter Rating: ");
            double ERating = sc.nextDouble();
            sc.nextLine();
            System.out.println("Please enter Brand: ");
            String EBrand = getValidString();
            System.out.println("Please enter Model: ");
            String EModel = getValidString();
            System.out.println("Please enter Release Year: ");
            int EreleaseYear = sc.nextInt();
            System.out.println("Please enter Battery Capacity: ");
            int EbatteryCapacity = sc.nextInt();
            Electronic newApp = new Electronic(EId, EName, EPrice, ERating, EBrand, EModel, EreleaseYear,EbatteryCapacity);
            electronicData.add(newApp);
            System.out.println("Electronic add success. "); 
            return;
    }
    }
    void deleteElectronic(){
        System.out.println("Please enter ID: ");
        String EId = getValidString();
        for (int index = 0; index < electronicData.size();index++ ){
        if (electronicData.get(index).getId().equalsIgnoreCase(EId)){
        electronicData.remove(index);
        System.out.println("Electronic delete success.");
        break;     
        }
         else {System.out.println("Electronic delete unsuccess.");break;}
        }        
    }
    void editElectronic(){
    System.out.println("Please enter ID: ");
    String EId = getValidString().trim();
    boolean value = false;
    for (int index = 0; index < electronicData.size();index++ ){
        if (electronicData.get(index).getId().equalsIgnoreCase(EId)){
            value = true;
        System.out.println("Please enter Name: ");
        String ENewName = getValidString();
        System.out.println("Please enter Price: ");
        double ENewPrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter Rating: ");
        double ENewRating = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter Brand: ");
        String ENewBrand = getValidString();
        System.out.println("Please enter Model: ");
        String ENewModel = getValidString();
        System.out.println("Please enter Release Year: ");
        int ENewreleaseYear = sc.nextInt();
        System.out.println("Please enter Battery Capacity: ");
        int ENewbatteryCapacity = sc.nextInt();
        Electronic newApp = new Electronic(EId, ENewName, ENewPrice, ENewRating, ENewBrand, ENewModel, ENewreleaseYear,ENewbatteryCapacity);
        electronicData.set(index, newApp);
        System.out.println("Electronic edit success.");  
        break;
        }    
        }
    if (!value){System.out.println("Electronic edit unsuccess.");}     
    }
    
    
    void searchElectronic(){
    boolean value = true;
    while(value){
            System.out.println("Search by: ");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            boolean found = false;
            switch(choose){
                case 1:
                    System.out.println("Enter ID: ");
                    String id = getValidString();
                    for (int index = 0; index < electronicData.size();index++ ){
                     if (electronicData.get(index).getId().equalsIgnoreCase(id)){
                     found = true;
                       System.out.println(electronicData.get(index).toString());
                       return;
        }
                     
    }
                    if (!found){System.out.println("Electronic id or name not found.");return;}
                    
                
                case 2:
                    System.out.println("Enter Name: ");
                    String name = getValidString();
                    for (int index = 0; index < electronicData.size();index++ ){
                     if ( electronicData.get(index).getName().equalsIgnoreCase(name)){
                     found = true;
                      System.out.println(electronicData.get(index).toString());
                      break;
        }                     
    }
                    if (!found){System.out.println("Electronic id or name not found.");return;}
                    
                   
                
                case 0:
                    System.out.println("Exit.");
                    value=false;
                break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }
    void sortElectronic(){
        boolean value = true;
        List<Appliance> app;
        while(value){
            System.out.println("Sort by: ");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch(choose){
                case 1:
                    applianceData.sort(Comparator.comparing(Appliance::getBrand));
                    System.out.println("Sorted by Price successfully!");
                    value=false;
                break;
                case 2:
                    applianceData.sort(Comparator.comparing(Appliance::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    value=false;
                break;
                case 0:
                    System.out.println("Exit.");
                    value=false;
                break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    void listAppliance(){
        applianceData.forEach(Appliance -> System.out.println(Appliance.toString()));
    }
    void addAppliance(){
        System.out.print("Please enter ID: ");
        String Aid = getValidString();
        System.out.print("Please enter Name: ");
        String Aname= getValidString();
        System.out.print("Please enter Price: ");
        double Aprice = sc.nextDouble();
        System.out.print("Please enter Rating: ");
        double Arating = sc.nextDouble();
        sc.nextLine();
        System.out.print("Please enter Brand: ");
        String Abrand = getValidString();
        System.out.print("Please enter Model: ");
        String Amodel = getValidString();
        System.out.print("Please enter Release Year: ");
        int AreleaseYear = sc.nextInt();
        Appliance newapp = new Appliance(Aid, Aname, Aprice, Arating,Abrand,Amodel,AreleaseYear);
        applianceData.add(newapp);
        System.out.println("Appliance added success.");
    }
    void deleteAppliance(){
        System.out.print("Please enter ID: ");
        String Aid = getValidString();
        for (int index = 0; index < applianceData.size();index++){
            if (applianceData.get(index).getId().equalsIgnoreCase(Aid)){
                applianceData.remove(index);
                System.out.println("Appliance deleted success.");
                break;
            }
            else{
                System.out.println("Appliance ID not found.");
                break;
            }
        }
    }
    void editAppliance(){
        System.out.print("Please enter ID: ");
        String Aid = getValidString();
        for (int index = 0; index < applianceData.size();index++){
            if (applianceData.get(index).getId().equalsIgnoreCase(Aid)){
                System.out.print("Please enter Name: ");
                String Anewname= getValidString();
                System.out.print("Please enter Price: ");
                double Anewprice = sc.nextDouble();
                System.out.print("Please enter Rating: ");
                double Anewrating = sc.nextDouble();
                sc.nextLine();
                System.out.print("Please enter Brand: ");
                String Anewbrand = getValidString();
                System.out.print("Please enter Model: ");
                String Anewmodel = getValidString();
                System.out.print("Please enter Release Year: ");
                int AnewreleaseYear = sc.nextInt();
                Appliance newapp = new Appliance(Aid, Anewname, Anewprice, Anewrating,Anewbrand,Anewmodel,AnewreleaseYear);
                applianceData.set(index, newapp);
                break;
            }
            else{
                System.out.println("Appliance ID not found.");
                break;
            }
        }
    }
    void sortAppliance(){
        boolean Asort = true;
        while(Asort){
            System.out.println("Sort by: ");
            System.out.println("1. Brand");
            System.out.println("2. Price");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch(choose){
                case 1:
                    applianceData.sort(Comparator.comparing(Appliance::getBrand));
                    System.out.println("Sorted by Price successfully!");
                    applianceData.forEach(Appliance -> System.out.println(Appliance.toString()));
                    Asort=false;
                break;
                case 2:
                    applianceData.sort(Comparator.comparing(Appliance::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    applianceData.forEach(Appliance -> System.out.println(Appliance.toString()));
                    Asort=false;
                break;
                case 0:
                    System.out.println("Exit.");
                    Asort=false;
                break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }
    void searchAppliance(){
        boolean Asearch=true;
        while(Asearch){
            System.out.println("Search by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch(choose){
                case 1:
                    System.out.print("Enter ID: ");
                    String searchId = getValidString();
                    boolean foundId = false;
                    for (Appliance a : applianceData) {
                        if (a.getId().equalsIgnoreCase(searchId)) {
                            System.out.println("Found appliance:");
                            System.out.println(a.toString());
                            foundId = true;
                            break;
                        }
                    }
                    if (!foundId) {
                        System.out.println("ID not found!");
                    }
                    Asearch = false;
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String searchName = getValidString().toLowerCase();
                    boolean foundName = false;
                    for (Appliance a : applianceData) {
                        if (a.getName().equalsIgnoreCase(searchName)) {
                            if (!foundName) {
                                System.out.println("Found appliance:");
                                foundName = true;
                            }
                            System.out.println(a.toString());
                        }
                    }
                    if (!foundName) {
                        System.out.println("Name not found!");
                    }
                    Asearch = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Asearch = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    static String getValidString(){
    String string;
        try (Scanner scanner = new Scanner(System.in)) {
            string = null;
            while (true){
                string = scanner.nextLine().trim();
                if (string == null || string.isEmpty()){
                    System.out.println("Try again!");
                } else {
                    break;
                }
            }
        }
        return string;
       
    }
    ///Bookmethot///
    public void listAllBooks() {
        for (Book book : bookData) {
            System.out.println(book);
        }
}

public void addBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Book ID: ");
    String id = sc.nextLine();
    System.out.print("Book Name: ");
    String name = sc.nextLine();
    System.out.print("Price: ");
    double price = Double.parseDouble(sc.nextLine());
    System.out.print("Rating: ");
    double rating = Double.parseDouble(sc.nextLine());
    System.out.print("Author: ");
    String author = sc.nextLine();
    System.out.print("Pages: ");
    int pages = Integer.parseInt(sc.nextLine());
    bookData.add(new Book(id, name, price, rating, author, pages));
    System.out.println("Book added.");
}

public void editBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter book ID to edit: ");
    String id = sc.nextLine();
    Book book = null;
    for (Book b : bookData) {
        if (b.getId().equals(id)) {
            book = b;
            break;
        }
    }
    if (book != null) {
        System.out.print("New Name [" + book.getName() + "]: ");
        String name = sc.nextLine();
        if (!name.isEmpty()) book.setName(name);

        System.out.print("New Price [" + book.getPrice() + "]: ");
        String price = sc.nextLine();
        if (!price.isEmpty()) book.setPrice(Double.parseDouble(price));

        System.out.print("New Rating [" + book.getRating() + "]: ");
        String rating = sc.nextLine();
        if (!rating.isEmpty()) book.setRating(Double.parseDouble(rating));

        System.out.print("New Author [" + book.getAuthor() + "]: ");
        String author = sc.nextLine();
        if (!author.isEmpty()) book.setAuthor(author);

        System.out.print("New Pages [" + book.getPages() + "]: ");
        String pages = sc.nextLine();
        if (!pages.isEmpty()) book.setPages(Integer.parseInt(pages));

        System.out.println("Book updated.");
    } else {
        System.out.println("Book not found.");
    }
}

public void deleteBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter book ID to delete: ");
    String id = sc.nextLine();
    boolean removed = bookData.removeIf(b -> b.getId().equals(id));
    if (removed) {
        System.out.println("Book deleted.");
    } else {
        System.out.println("Book not found.");
    }
}

// ------- Drink methods -------
public void listAllDrinks() {
        for (Drink drink : drinkData) {
            System.out.println(drink);
        }
}
public void addDrink() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Drink ID: ");
    String id = sc.nextLine();
    System.out.print("Drink Name: ");
    String name = sc.nextLine();
    System.out.print("Price: ");
    double price = Double.parseDouble(sc.nextLine());
    System.out.print("Rating: ");
    double rating = Double.parseDouble(sc.nextLine());
    System.out.print("Size: ");
    String size = sc.nextLine();
    drinkData.add(new Drink(id, name, price, rating, size));
    System.out.println("Drink added.");
}

public void editDrink() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter drink ID to edit: ");
    String id = sc.nextLine();
    Drink drink = null;
    for (Drink d : drinkData) {
        if (d.getId().equals(id)) {
            drink = d;
            break;
        }
    }
    if (drink != null) {
        System.out.print("New Name [" + drink.getName() + "]: ");
        String name = sc.nextLine();
        if (!name.isEmpty()) drink.setName(name);

        System.out.print("New Price [" + drink.getPrice() + "]: ");
        String price = sc.nextLine();
        if (!price.isEmpty()) drink.setPrice(Double.parseDouble(price));

        System.out.print("New Rating [" + drink.getRating() + "]: ");
        String rating = sc.nextLine();
        if (!rating.isEmpty()) drink.setRating(Double.parseDouble(rating));

        System.out.print("New Size [" + drink.getSize() + "]: ");
        String size = sc.nextLine();
        if (!size.isEmpty()) drink.setSize(size);

        System.out.println("Drink updated.");
    } else {
        System.out.println("Drink not found.");
    }
}

public void deleteDrink() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter drink ID to delete: ");
    String id = sc.nextLine();
    boolean removed = drinkData.removeIf(d -> d.getId().equals(id));
    if (removed) {
        System.out.println("Drink deleted.");
    } else {
        System.out.println("Drink not found.");
    }
}

    
    //----------------------------------------------------Anh em them ham UI o day----------------------------------------------------------------------------------------------------------------
    public void mainUI() {//Vi du y nhu cai nay
        System.out.println("----MALL MANAGEMENT SYSTEM----");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Appliances");
        System.out.println("3. Manage Drinks");
        System.out.println("4. Manage Electronics");
        System.out.println("5. Manage Foods");
        System.out.println("6. Manage Vehicles");
        System.out.println("7. Manage Employees");
        System.out.println("0. Exit");

    }

    public void EmployeeUI() {

        System.out.println("----EMPLOYEE MANAGEMENT----");
        System.out.println("1. Hire Emloyee");
        System.out.println("2. Edit Emloyee Information");
        System.out.println("3. Dismiss Employee");
        System.out.println("4. Find Employee");
        System.out.println("0. Back To MALL MANAGEMENT");

    }

    public void ApplianceUI() {
        System.out.println("----EMPLOYEE MANAGEMENT----");
        System.out.println("1. Display list");
        System.out.println("2. Add new appliance");
        System.out.println("3. Edit information");
        System.out.println("4. Delete appliance");
        System.out.println("5. Sort by (brand or price)");
        System.out.println("6. Search information by (id or name)");
        System.out.println("0. Back To MALL MANAGEMEN");
    }
    public void BookUI() {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("---- BOOK MANAGEMENT ----");
        System.out.println("1. List all books");
        System.out.println("2. Add a book");
        System.out.println("3. Edit a book");
        System.out.println("4. Delete a book");
        System.out.println("5. Sort books by (ID, Name, Rating, Price)");
        System.out.println("6. Search books by (ID or Name)");
        System.out.println("0. Back to Main Menu");
        int choice = getValidInput(6);
        switch (choice) {
            case 1:
                    listAllBooks();
                break;
            case 2:
                System.out.print("Enter Book ID: "); String id = sc.nextLine();
                System.out.print("Enter Book Name: "); String name = sc.nextLine();
                System.out.print("Enter Book Price: "); double price = Double.parseDouble(sc.nextLine());
                System.out.print("Enter Book Rating: "); double rating = Double.parseDouble(sc.nextLine());
                System.out.print("Enter Author: "); String author = sc.nextLine();
                System.out.print("Enter Number of Pages: "); int pages = Integer.parseInt(sc.nextLine());
                bookData.add(new Book(id, name, price, rating, author, pages));
                System.out.println("Book added successfully.");
                break;
            case 3:
                System.out.print("Enter the ID of the book to edit: "); String editId = sc.nextLine();
                Book toEdit = null;
                for (Book b : bookData) if (b.getId().equals(editId)) toEdit = b;
                if (toEdit != null) {
                    System.out.print("New Name ("+toEdit.getName()+"): "); toEdit.setName(sc.nextLine());
                    System.out.print("New Price ("+toEdit.getPrice()+"): "); toEdit.setPrice(Double.parseDouble(sc.nextLine()));
                    System.out.print("New Rating ("+toEdit.getRating()+"): "); toEdit.setRating(Double.parseDouble(sc.nextLine()));
                    System.out.print("New Author ("+toEdit.getAuthor()+"): "); toEdit.setAuthor(sc.nextLine());
                    System.out.print("New Number of Pages ("+toEdit.getPages()+"): "); toEdit.setPages(Integer.parseInt(sc.nextLine()));
                    System.out.println("Book information updated.");
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 4:
                System.out.print("Enter the ID of the book to delete: "); String delId = sc.nextLine();
                boolean removed = bookData.removeIf(b -> b.getId().equals(delId));
                if (removed) System.out.println("Book deleted.");
                else System.out.println("Book not found.");
                break;
            case 5:
                System.out.println("Sort by: 1. ID, 2. Name, 3. Rating, 4. Price");
                int sortChoice = getValidInput(4);
                switch (sortChoice) {
                    case 1: bookData.sort((a, b) -> a.getId().compareTo(b.getId())); break;
                    case 2: bookData.sort((a, b) -> a.getName().compareTo(b.getName())); break;
                    case 3: bookData.sort((a, b) -> Double.compare(a.getRating(), b.getRating())); break;
                    case 4: bookData.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice())); break;
                }
                System.out.println("Sorted successfully.");
                break;
            case 6:
                System.out.println("Search by: 1. ID, 2. Name");
                int searchChoice = getValidInput(2);
                boolean found = false;
                if (searchChoice == 1) {
                    System.out.print("Enter book ID: ");
                    String sid = sc.nextLine();
                    for (Book b : bookData) {
                        if (b.getId().equals(sid)) {
                            System.out.println(b);
                            found = true;
                        }
                    }
                } else {
                    System.out.print("Enter book name: ");
                    String sname = sc.nextLine().toLowerCase();
                    for (Book b : bookData) {
                        if (b.getName().toLowerCase().contains(sname)) {
                            System.out.println(b);
                            found = true;
                        }
                    }
                }
                if (!found) System.out.println("Book not found.");
                break;
            case 0:
                return;
        }
    }
}

public void DrinkUI() {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("---- DRINK MANAGEMENT ----");
        System.out.println("1. List all drinks");
        System.out.println("2. Add a drink");
        System.out.println("3. Edit a drink");
        System.out.println("4. Delete a drink");
        System.out.println("5. Sort drinks by (ID, Name, Rating, Price)");
        System.out.println("6. Search drinks by (ID or Name)");
        System.out.println("0. Back to Main Menu");
        int choice = getValidInput(6);
        switch (choice) {
            case 1:
                    listAllDrinks();;
                    break;
            case 2:
                System.out.print("Enter Drink ID: "); String id = sc.nextLine();
                System.out.print("Enter Drink Name: "); String name = sc.nextLine();
                System.out.print("Enter Drink Price: "); double price = Double.parseDouble(sc.nextLine());
                System.out.print("Enter Drink Rating: "); double rating = Double.parseDouble(sc.nextLine());
                System.out.print("Enter Drink Size: "); String size = sc.nextLine();
                drinkData.add(new Drink(id, name, price, rating, size));
                break;
            case 3:
                System.out.print("Enter the ID of the drink to edit: "); String editId = sc.nextLine();
                Drink toEdit = null;
                for (Drink d : drinkData) if (d.getId().equals(editId)) toEdit = d;
                if (toEdit != null) {
                    System.out.print("New Name ("+toEdit.getName()+"): "); toEdit.setName(sc.nextLine());
                    System.out.print("New Price ("+toEdit.getPrice()+"): "); toEdit.setPrice(Double.parseDouble(sc.nextLine()));
                    System.out.print("New Rating ("+toEdit.getRating()+"): "); toEdit.setRating(Double.parseDouble(sc.nextLine()));
                    System.out.print("New Size ("+toEdit.getSize()+"): "); toEdit.setSize(sc.nextLine());
                    System.out.println("Drink information updated.");
                } else {
                    System.out.println("Drink not found.");
                }
                break;
            case 4:
                System.out.print("Enter the ID of the drink to delete: "); String delId = sc.nextLine();
                boolean removed = drinkData.removeIf(d -> d.getId().equals(delId));
                if (removed) System.out.println("Drink deleted.");
                else System.out.println("Drink not found.");
                break;
            case 5:
                System.out.println("Sort by: 1. ID, 2. Name, 3. Rating, 4. Price");
                int sortChoice = getValidInput(4);
                switch (sortChoice) {
                    case 1: drinkData.sort((a, b) -> a.getId().compareTo(b.getId())); break;
                    case 2: drinkData.sort((a, b) -> a.getName().compareTo(b.getName())); break;
                    case 3: drinkData.sort((a, b) -> Double.compare(a.getRating(), b.getRating())); break;
                    case 4: drinkData.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice())); break;
                }
                break;
            case 6:
                    System.out.println("Search by: 1. ID, 2. Name");
                    int searchChoice = getValidInput(2);
                    boolean found = false;
                    if (searchChoice == 1) {
                        System.out.print("Enter drink ID: ");
                        String sid = sc.nextLine();
                        for (Drink d : drinkData) {
                            if (d.getId().equals(sid)) {
                                System.out.println(d);
                                found = true;
                            }
                        }
                    } else {
                        System.out.print("Enter drink name: ");
                        String sname = sc.nextLine().toLowerCase();
                        for (Drink d : drinkData) {
                            if (d.getName().toLowerCase().contains(sname)) {
                                System.out.println(d);
                                found = true;
                            }
                        }
                    }
                    if (!found) System.out.println("Drink not found.");
                    break;
            case 0:
                return;
        }
    }
}

    //###########################Dung ham nay de nhan input ma nguoi dung nhap ############################
        public static int getValidInput(int range) {
       Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print("Please select an option: ");
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input >= 0 && input <= range) { //Nho truyen range la gia tri toi da vao 
                    break; // valid
                } else {
                    System.out.printf("The value is out of range(0-%d).", range);
                }
            } else {
                System.out.println("Vui long nhap so nguyen.");
                sc.next();
            }
        }
        sc.close();
        return input;
    }
    public static String getValidString(){
    String string;
            Scanner sc = new Scanner(System.in);
            string = null;
            while (true){
                string = sc.nextLine().trim();
                if (string == null || string.isEmpty()){
                    System.out.println("Try again!");
                } else {
                    break;
                }
            }
        
        sc.close();
        return string;
    }
    public static void clearScreen() {
        try {
            Thread.sleep(1000);
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Không thể xóa màn hình: " + e.getMessage());
        }
    }
    // clear cmd cho dep
    public static void delay(long s) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < s) {
        }
    }
    
    public static void printfc(String color, String format, Object... args) {
        System.out.printf(color + format + RESET, args);
    }
    //----------------------------------------------------Bat dau code o day-----------------------------------------------------------------------
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        /*----------------------------------Mang luu du lieu cua anh em day--------------------------------------------------------------------------
        
        List<Book> bookData = new ArrayList<>();
        List<Appliance> applianceData = new ArrayList<>();
        List<Drink> drinkData = new ArrayList<>();
        List<Electronic> electronicData = new ArrayList<>();
        List<Food> foodData = new ArrayList<>();
        List<Vehicle> vehicleData = new ArrayList<>();
        List<Employee> employeeData = new ArrayList<>();
        
         */
        ProjectVinMall VinMall = new ProjectVinMall();

        VinMall.loadData();

        boolean stop = false;

        while (!stop) {
            clearScreen();
            VinMall.mainUI();
            int MainSelect = getValidInput(7);

            switch (MainSelect) {
                case 1: //Book

                    //------------------------------------endBook-------------------------------------
                    break;
                case 2://Appliance
                    boolean stopA = true;
                    while(stopA){
                        VinMall.ApplianceUI();
                        int ApplianceSelect = getValidInput(7);
                        switch(ApplianceSelect){
                            case 1:
                                VinMall.listAppliance();
                            break;
                            case 2:
                                VinMall.addAppliance();
                            break;
                            case 3:
                                VinMall.editAppliance();
                            break;
                            case 4:
                                VinMall.deleteAppliance();
                            break;
                            case 5:
                                VinMall.sortAppliance();
                            break;
                            case 6:
                                VinMall.searchAppliance();
                            break;
                            default:
                                System.out.println("Data saved.");
                                System.out.println("Exit.");
                                stopA = false;
                            break;
                        }
                    }
                    //------------------------------------endAppliance--------------------------------
                    break;
                case 3://Drinks

                    //------------------------------------endDrinks--------------------------------
                    break;
                case 4:{
                    boolean stopE = true;
                while(stopE){
                 VinMall.ElectronicUI();
                 int ElectronicSelect = getValidInput(6);
                 
                 switch(ElectronicSelect){
                     case 1:
                         VinMall.displayElectronic();
                     break;
                     case 2:
                         VinMall.addElectronic();
                     break;
                     case 3:
                         VinMall.editElectronic();
                     break;
                     case 4:
                         VinMall.deleteElectronic();
                     break;
                     case 5:
                         VinMall.sortElectronic();
                     break;
                     case 6:
                         VinMall.searchElectronic();
                     break;
                     default:
                         System.out.println("Data saved.");
                         System.out.println("Exit.");
                         stopE = false;
                     break;
                 }
                }    
                }
                    //------------------------------------endElectronic--------------------------------
                    break;
                case 5://Food

                    //------------------------------------endFood--------------------------------
                    break;
                case 6://Vehicle

                    //------------------------------------endVehicle--------------------------------
                    break;
                case 7://Employee

                    VinMall.listEmployee();
                    VinMall.EmployeeUI();
                    int EmployeeSelect = getValidInput(4);

                    //------------------------------------endEmployee--------------------------------
                    break;
                default:
                    VinMall.saveData();
                    clearScreen();
                    System.out.println("Data saved.");
                    System.out.println("Exit.");
                    stop = true;
            }
        }

    }
}














