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




public class ProjectVinMall implements IMall {

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
    void listVehicle() {
        vehicleData.forEach(Vehicle -> {
            System.out.println(Vehicle.toString());
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
    boolean found = false;
    for (int i = 0; i < electronicData.size(); i++) {
    if (electronicData.get(i).getId().equalsIgnoreCase(EId)) {
        electronicData.remove(i);
        found = true;
        System.out.println("Delete success!");
        break;
        }
    }
    if (!found) System.out.println("ID not found!");
    
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
        List<Electronic> app;
        while(value){
            System.out.println("Sort by: ");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch(choose){
                case 1:
                    electronicData.sort(Comparator.comparing(Electronic::getBrand));
                    System.out.println("Sorted by Price successfully!");
                    value=false;
                break;
                case 2:
                    electronicData.sort(Comparator.comparing(Electronic::getPrice));
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

    
    ///Bookmethot///
    public void listAllBooks() {
        for (Book book : bookData) {
            System.out.println(book);
        }
}

public void addBook() {
    
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
    
    System.out.print("Enter drink ID to delete: ");
    String id = sc.nextLine();
    boolean removed = drinkData.removeIf(d -> d.getId().equals(id));
    if (removed) {
        System.out.println("Drink deleted.");
    } else {
        System.out.println("Drink not found.");
    }
}
    //-------------Food method-------------------------
public void listAllFoods() {
        for (Food food : foodData) {
            System.out.println(food);
        }
    }

    public void addFood() {
        System.out.print("Food ID: ");
        String id = getValidString();
        System.out.print("Food Name: ");
        String name = getValidString();
        System.out.print("Price: ");
        double price = getValidDouble();
        System.out.print("Rating: ");
        double rating = getValidDouble();
        System.out.print("Size: ");
        String size = getValidString();
        foodData.add(new Food(id, name, price, rating, size));
        System.out.println("Food added.");
    }

    public void editFood() {
        System.out.print("Enter food ID to edit: ");
        String id = getValidString();
        Food food = null;
        for (Food f : foodData) {
            if (f.getId().equals(id)) {
                food = f;
                break;
            }
        }
        if (food != null) {
            System.out.print("New Name [" + food.getName() + "]: ");
            food.setName(getValidString());

            System.out.print("New Price [" + food.getPrice() + "]: ");
            food.setPrice(getValidDouble());

            System.out.print("New Rating [" + food.getRating() + "]: ");
            food.setRating(getValidDouble());

            System.out.print("New Size [" + food.getSize() + "]: ");
            food.setSize(getValidString());

            System.out.println("Food updated.");
        } else {
            System.out.println("Food not found.");
        }
    }

    public void deleteFood() {
        System.out.print("Enter food ID to delete: ");
        String id = getValidString();
        boolean removed = foodData.removeIf(f -> f.getId().equals(id));
        if (removed) {
            System.out.println("Food deleted.");
        } else {
            System.out.println("Food not found.");
        }
    }

    public void SortFoods() {
        boolean Fsort = true;
        while (Fsort) {
            System.out.println("Sort by: ");
            System.out.println("1. Price");
            System.out.println("2. Rating");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch (choose) {
                case 1:
                    foodData.sort(Comparator.comparing(Food::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    foodData.forEach(Food -> System.out.println(Food.toString()));
                    Fsort = false;
                    break;
                case 2:
                    foodData.sort(Comparator.comparing(Food::getRating));
                    System.out.println("Sorted by Rating successfully!");
                    foodData.forEach(Food -> System.out.println(Food.toString()));
                    Fsort = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Fsort = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    public void searchFoods() {
        boolean Fsearch = true;
        while (Fsearch) {
            System.out.println("Search by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);

            switch (choose) {
                case 1:
                    System.out.print("Enter ID: ");
                    String searchId = getValidString();
                    boolean foundId = false;
                    for (Food f : foodData) {
                        if (f.getId().equalsIgnoreCase(searchId)) {
                            System.out.println("Found food:");
                            System.out.println(f.toString());
                            foundId = true;
                            break;
                        }
                    }
                    if (!foundId) {
                        System.out.println("ID not found!");
                    }
                    Fsearch = false;
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String searchName = getValidString().toLowerCase();
                    boolean foundName = false;
                    for (Food f : foodData) {
                        if (f.getName().equalsIgnoreCase(searchName)) {
                            if (!foundName) {
                                System.out.println("Found food:");
                                System.out.println(f.toString());
                                foundName = true;
                                break;
                            }
                        }
                    }
                    if (!foundName) {
                        System.out.println("Name not found!");
                    }
                    Fsearch = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Fsearch = false;
                    break;
                default:
                    System.out.println("Please choose again!");
                    break;
            }
        }

    //-----------------------------------Employee Method-------------------------------
    
    void addEmployee(){
        System.out.println("--------------Hire new Employee----------------");
        String newEmId;
        while (true){
            System.out.print("Enter new ID:");
            newEmId = getValidString();
            if (checkEmployeeID(newEmId)){
                
                break;
            } else System.out.println("ID exist!");
        }
        System.out.print("Enter Employee Name:");
        String newEmName = getValidString();
        System.out.print("Enter Employee position:");
        String newEmPos = getValidString();
        System.out.print("Enter Employee phone number:");
        String newEmPhone = getValidString();
        System.out.print("Enter Employee salary:");
        double newEmSa = getValidDouble();
        
        Employee newEmp = new Employee(newEmId, newEmName, newEmPos, newEmPhone, newEmSa);
        
        employeeData.add(newEmp);
        System.out.println("New Employee infor:" + newEmp.getInfo());
        waitForEnter("Enter to continue.");
    }
    
    void editEmloyee(){
        System.out.println("--------------Edit Employees information----------------");
        String newEmId;
        while (true){
            System.out.print("Enter Employee ID:");
            newEmId = getValidString();
            if (!checkEmployeeID(newEmId)){
                break;
            } else System.out.println("ID not exist!");
        }
        System.out.print("Enter Employee Name:");
        String newEmName = getValidString();
        System.out.print("Enter Employee position:");
        String newEmPos = getValidString();
        System.out.print("Enter Employee phone number:");
        String newEmPhone = getValidString();
        System.out.print("Enter Employee salary:");
        double newEmSa = getValidDouble();
        Employee newEmp = new Employee(newEmId, newEmName, newEmPos, newEmPhone, newEmSa);
        
        int index =0;
        for (int i =0 ; i < employeeData.size() ; i++){
            if (employeeData.get(i).getId().equalsIgnoreCase(newEmId)){
                index = i;
                break;
            }
        }
        employeeData.set(index, newEmp);
        System.out.println("Employee infor:" + newEmp.getInfo());
        waitForEnter("Enter to continue.");
    }
    
    void DissmisEmployee(){
        System.out.println("--------------Dissmis Employees-----------------");
        String newEmId;
        while (true){
            System.out.print("Enter Employee ID:");
            newEmId = getValidString();
            if (!checkEmployeeID(newEmId)){
                
                break;
            } else System.out.println("ID not exist!");
        }
        int i=0;
        for (int index =0 ; index < employeeData.size() ; index++){
                if (employeeData.get(index).getId().equalsIgnoreCase(newEmId)){
                    i = index;
                    break;
                }
        }
        
        employeeData.remove(i);
        System.out.println("Employee Dissmised");
    }
    
    void findEmployee(){
        System.out.println("--------------Find Employees-----------------");
        System.out.print("Enter id, name or position :");
        String find = getValidString();
        int notfind = 0;
        for (Employee e : employeeData){
            if (  e.getId().contains(find) ||
                   e.getName().contains(find) ||
                   e.getPosition().contains(find)
                    ){
                System.out.println(e.getInfo());
                ++notfind;
            }
        }
        if (notfind == 0){
            System.out.println("No resuft!");
            
        }
        waitForEnter("Enter to continue.");
    }
    
    void sortEmployee(){
        boolean sortstop = false;
        while (!sortstop) {
        System.out.println("--------------Sort Employees-----------------");
        System.out.println("Sorting by what?");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Salary");
        System.out.println("0. Back to Employees manage");
        int sortEmSelect = getValidInput(3);
            switch (sortEmSelect){
                case 1:
                    employeeData.sort(Comparator.comparing(Employee :: getId));
                    System.out.println("-----------List sorted by ID------------");
                    listEmployee();
                    
                    break;
                case 2:
                    employeeData.sort(Comparator.comparing(Employee :: getName));
                    System.out.println("-----------List sorted by Name------------");
                    listEmployee();
                    break;
                case 3:
                    employeeData.sort(Comparator.comparing(Employee :: getSalary));
                    System.out.println("-----------List sorted by Salary------------");
                    listEmployee();
                    break;
                case 0:
                    System.out.println("Data saved.");
                    sortstop = true;                    
                    break;
            }
            waitForEnter("Enter to continue.");
        }
        
    }
    
    //Vehicle Method------------------------------------
    
    
    void addVehicle(){
    System.out.println("-------------Add new Vehicle-----------");
    String newVeId;
        while (true){
            System.out.print("Enter new ID:");
            newVeId = getValidString();
            if (checkVehicleID(newVeId)){
                break;
            } else System.out.println("ID exist!");
        }
    System.out.print("Enter new vehicle Name:");
    String newVeName = getValidString();
    System.out.print("Enter new vehicle Price:");
    double newPrice = getValidDouble();
    System.out.print("Enter new vehicle Rating:");
    double newRating = getValidDouble();
    System.out.print("Enter new vehicle Chassis Number:");
    String newCha = getValidString();
    System.out.print("Enter new vehicle Engine Type:");
    String newengineType = getValidString();
    System.out.print("Enter new vehicle brand:");
    String newbrand = getValidString();
    System.out.print("Enter new vehicle manufacture Year:");
    int newmanuyear = getValidInt();
    System.out.print("Enter new vehicle inspection Fee:");
    double Fee = getValidDouble();
    
    Vehicle newVe = new Vehicle(
            newVeId,
            newVeName,
            newPrice,
            newRating,
            newCha,
            newengineType,
            newbrand,
            newmanuyear,
            Fee
    );
    vehicleData.add(newVe);
    System.out.println("New Vehicle Informantion:"+newVe.toString());
    waitForEnter("Enter to continue.");
    }
    
    
    void editVehicle(){
        System.out.println("--------------Edit Vehicle information----------------");
        String newId;
        while (true){
            System.out.print("Enter Vehicle ID:");
            newId = getValidString();
            if (!checkVehicleID(newId)){
                break;
            } else System.out.println("ID not exist!");
        }
        
    System.out.print("Enter new vehicle Name:");
    String newVeName = getValidString();
    System.out.print("Enter new vehicle Price:");
    double newPrice = getValidDouble();
    System.out.print("Enter new vehicle Rating:");
    double newRating = getValidDouble();
    System.out.print("Enter new vehicle Chassis Number:");
    String newCha = getValidString();
    System.out.print("Enter new vehicle Engine Type:");
    String newengineType = getValidString();
    System.out.print("Enter new vehicle brand:");
    String newbrand = getValidString();
    System.out.print("Enter new vehicle manufacture Year:");
    int newmanuyear = getValidInt();
    System.out.print("Enter new vehicle inspection Fee:");
    double Fee = getValidDouble();
        Vehicle newVe = new Vehicle(
            newId,
            newVeName,
            newPrice,
            newRating,
            newCha,
            newengineType,
            newbrand,
            newmanuyear,
            Fee
    );
        int index = 0;
        for (int i = 0 ; i<vehicleData.size() ; ++i ){
            if (vehicleData.get(i).getId().equalsIgnoreCase(newId)){
                index = i;
                break;
            }
        }
        vehicleData.set(index, newVe);
        System.out.println("Vehicle Informantion:"+newVe.toString());
        waitForEnter("Enter to continue.");  
    }
    
    
    void deleteVehicle(){
        System.out.println("--------------Delete Vehicle-----------------");
        String newEmId;
        while (true){
            System.out.print("Enter Employee ID:");
            newEmId = getValidString();
            if (!checkVehicleID(newEmId)){
                break;
            } else System.out.println("ID not exist!");
        }
        int i=0;
        for (int index =0 ; index < vehicleData.size() ; index++){
                if (vehicleData.get(index).getId().equalsIgnoreCase(newEmId)){
                    i = index;
                    break;
                }
        }
        
        vehicleData.remove(i);
        System.out.println("Vehicle Deleted.");
        waitForEnter("Enter to continue.");  
    }
    
    
   void sortVehicle(){
       boolean sortstop = false;
        while (!sortstop) {
        System.out.println("--------------Sort Vehicle-----------------");
        System.out.println("Sorting by what?");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Price");
        System.out.println("4. Rating");
        System.out.println("5. Chassis Number");
        System.out.println("6. EngineType");
        System.out.println("7. Brand");
        System.out.println("8. Manufacture Year");
        System.out.println("9. Inspection Fee");
        System.out.println("0. Back to Employees manage");
        int sortEmSelect = getValidInput(9);
            switch (sortEmSelect){
                case 1:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getId));
                    System.out.println("----------- List sorted by ID ------------");
                    listVehicle();
                    
                    break;
                case 2:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getName));
                    System.out.println("----------- List sorted by Name ------------");
                    listVehicle();
                    break;
                case 3:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getPrice));
                    System.out.println("----------- List sorted by Price ------------");
                    listVehicle();
                    break;
                case 4:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getRating));
                    System.out.println("-----------List sorted by Rating ------------");
                    listVehicle();
                    
                    break;
                case 5:
                    vehicleData.sort(Comparator.comparing(Vehicle ::  getChassisNumber));
                    System.out.println("-----------List sorted by Chassis Number ------------");
                    listVehicle();
                    break;
                case 6:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getEngineType));
                    System.out.println("-----------List sorted by EngineType ------------");
                    listVehicle();
                    break;
                case 7:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getBrand));
                    System.out.println("-----------List sorted by Brand ------------");
                    listVehicle();
                    
                    break;
                case 8:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getManufactureYear));
                    System.out.println("-----------List sorted by Manufacture Year ------------");
                    listVehicle();
                    break;
                case 9:
                    vehicleData.sort(Comparator.comparing(Vehicle :: getInspectionFee));
                    System.out.println("-----------List sorted by Inspection Fee ------------");
                    listVehicle();
                    break;
                case 0:
                    System.out.println("Data saved.");
                    sortstop = true;                    
                    break;
            }
            waitForEnter("Enter to continue.");
        }   
   }
   
   void findVehicle(){
        System.out.println("--------------Find Vehicle-----------------");
        System.out.print("Enter any thing to find:");
        String find = getValidString();
        System.out.println("--------------List Find Vehicle-----------------");
        int notfind = 0;   
   
            for (Vehicle e : vehicleData){
            if (  e.getId().contains(find) ||
                   e.getName().contains(find) ||
                   e.getBrand().contains(find) ||
                   e.getChassisNumber().contains(find) ||
                   e.getEngineType().contains(find) ||
                   String.valueOf(e.getManufactureYear()).contains(find) ||
                   String.valueOf(e.getInspectionFee()).contains(find) ||
                   String.valueOf(e.getPrice()).contains(find) ||
                   String.valueOf(e.getRating()).contains(find)
                    ){
                System.out.println(e.toString());
                ++notfind;
            }
        }
        if (notfind == 0){
            System.out.println("No resuft!");  
        
        }
        waitForEnter("Enter to continue.");
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
        System.out.println("5. Sort Employee");
        System.out.println("0. Back To MALL MANAGEMENT");

    }
    public void VehicleUI() {

        System.out.println("----VEHICLE MANAGEMENT----");
        System.out.println("1. Add new Vehicle");
        System.out.println("2. Edit vehicle infomation");
        System.out.println("3. Delete vehicle");
        System.out.println("4. Sort Vehicle");
        System.out.println("5. Search Vehicle");
        System.out.println("0. Back To MALL MANAGEMENT");

    }

    public void ElectronicUI() {
        System.out.println("----Electronic MANAGEMENT----");
        System.out.println("1. Display list ");
        System.out.println("2. Add new device ");
        System.out.println("3. Edit information ");
        System.out.println("4. Delete device");
        System.out.println("5. Sort by (brand or price)");
        System.out.println("6. Search information by (Id or name)");
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

    public void FoodUI() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---- FOOD MANAGEMENT ----");
            System.out.println("1. List all foods");
            System.out.println("2. Add a food");
            System.out.println("3. Edit a food");
            System.out.println("4. Delete a food");
            System.out.println("5. Sort foods by (ID, Name, Rating, Price)");
            System.out.println("6. Search foods by (ID or Name)");
            System.out.println("0. Back to Main Menu");
            int choice = getValidInput(6);
            switch (choice) {
                case 1:
                    listAllFoods();
                    break;
                case 2:
                    addFood();
                    break;
                case 3:
                    editFood();
                    break;
                case 4:
                    deleteFood();
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

    
    public boolean checkEmployeeID(String id){
        return !employeeData.stream().anyMatch((EM) -> (EM.getId().equalsIgnoreCase(id)));
    }
    public boolean checkVehicleID(String id){
        return !vehicleData.stream().anyMatch((EM) -> (EM.getId().equalsIgnoreCase(id)));
    }
    //###########################Dung ham nay de nhan input ma nguoi dung nhap ############################

    /**
     *
     * @return
     */
    @Override
    public int getValidInput(int range) {
        Scanner lsc = new Scanner(System.in);
        int input; 
            System.out.print("Please select an option: ");
            if (lsc.hasNextInt()) {

                input = lsc.nextInt();
             
                if (input >= 0 && input <= range) { //Nho truyen range la gia tri toi da vao 
                    return input;
                } else {
                    System.out.printf("The value is out of range(0-%d).", range);
                }

            } else {
                System.out.println("Please select an option:");
            }
        return getValidInput(range);  
    }

    @Override
    public String getValidString() {
        String string;
        Scanner lsc = new Scanner(System.in);
        string = null;
        string = lsc.nextLine().trim();
     
        if (string == null || string.isEmpty()) {
            System.out.println("Try again!");
            getValidString();
        } 
        return string;
    }

    @Override 
    public double getValidDouble() {
        double input = 0;
        Scanner lsc = new Scanner(System.in);
       
        if (lsc.hasNextDouble()) {
            input = lsc.nextDouble(); 
           
        } else {
                System.out.println("Invalid input. Please enter a valid number.");
                getValidDouble();
            }
        
        return input;
    }
    @Override
    public int getValidInt() {
        int input = 0;
        Scanner lsc = new Scanner(System.in);
        
        if (lsc.hasNextInt()) {
            input = lsc.nextInt(); 
            
        } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                getValidInt();
            }
        
        return input;
    }

    @Override
    public void clearScreen() {
        try {
            Thread.sleep(1000);
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Can not clear the Screen!" + e.getMessage());
        }
    }
    // clear cmd cho dep
    
    @Override
    public void delay(long s) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < s) {
        }
    }
    public void waitForEnter(String prompt) {
        System.out.print(prompt);
        sc.nextLine();
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
            VinMall.clearScreen();
            VinMall.mainUI();
            int MainSelect = VinMall.getValidInput(7);

            switch (MainSelect) {
                case 1: //Book
                    boolean stopB = true;
                    VinMall.clearScreen();
                    while (stopB) {
                        VinMall.BookUI();
                        int BookSelect = VinMall.getValidInput(6);
                        switch (BookSelect) {
                            case 1:
                                VinMall.clearScreen();
                                VinMall.listAllBooks();
                                VinMall.delay(5000);
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addBook();
                                break;
                            case 3:
                                VinMall.editBook();
                                break;
                            case 4:
                                VinMall.deleteBook();
                                break;
                            case 5:
                                VinMall.sortBooks();
                                break;
                            case 6:
                                VinMall.searchBooks();
                                break;
                            default:
                                System.out.println("Data saved.");
                                System.out.println("Exit.");
                                stopB = false;
                                break;
                        }
                    }
                    //------------------------------------endBook-------------------------------------
                    break;
                case 2://Appliance
                    boolean stopA = true;
                    while(stopA){
                        VinMall.ApplianceUI();
                        int ApplianceSelect = VinMall.getValidInput(7);
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
                    boolean stopD = true;
                    while (stopD) {
                        VinMall.DrinkUI();
                        int DrinkSelect = VinMall.getValidInput(6);

                        switch (DrinkSelect) {
                            case 1:
                                VinMall.listAllDrinks();
                                break;
                            case 2:
                                VinMall.addDrink();
                                break;
                            case 3:
                                VinMall.editDrink();
                                break;
                            case 4:
                                VinMall.deleteDrink();
                                break;
                            case 5:
                                VinMall.sortDrinks();
                                break;
                            case 6:
                                VinMall.SearchDrinks();
                                break;
                            default:
                                System.out.println("Data saved.");
                                System.out.println("Exit.");
                                stopD = false;
                                break;
                        }
                    }
                    //------------------------------------endDrinks--------------------------------
                    break;
                case 4:{
                    boolean stopE = true;
                while(stopE){
                 VinMall.ElectronicUI();
                 int ElectronicSelect = VinMall.getValidInput(6);
                 
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
                    boolean stopF = true;
                    while (stopF) {
                        VinMall.FoodUI();
                        int FoodSelect = VinMall.getValidInput(5);

                        switch (FoodSelect) {
                            case 1:
                                VinMall.listAllFoods();
                                break;
                            case 2:
                                VinMall.addFood();
                                break;
                            case 3:
                                VinMall.editFood();
                                break;
                            case 4:
                                VinMall.deleteFood();
                                break;
                            case 5:
                                VinMall.SortFoods();
                                break;
                            case 6:
                                VinMall.searchFoods();
                                break;
                            default:
                                System.out.println("Data saved.");
                                System.out.println("Exit.");
                                stopF = false;
                                break;
                        }
                    }
                    //------------------------------------endFood--------------------------------
                    break;
                case 6://Vehicle
                    boolean stopVe = false;
                    while (!stopVe){
                    VinMall.clearScreen();
                     System.out.println("------------------- Vehicle List---------------");
                    VinMall.listVehicle();
                    VinMall.VehicleUI();   
                    int VehicleSelect = VinMall.getValidInput(5);
                    switch (VehicleSelect){
                        case 1:
                            VinMall.addVehicle();
                            break;
                        case 2:
                            VinMall.editVehicle();
                            break;
                        case 3:
                            VinMall.deleteVehicle();
                            break;
                        case 4:
                            VinMall.sortVehicle();
                            break;
                        case 5:
                            VinMall.findVehicle();
                            break;
                        case 0:
                            System.out.println("Back");
                            stopVe = true;
                            break;
                    }
                    }
                    //------------------------------------endVehicle--------------------------------
                    break;
                case 7://Employee
                    
                    boolean stopEmp = false;
                    while (!stopEmp) {
                            VinMall.clearScreen();
                            System.out.println("-------------List Employee--------------");
                            VinMall.listEmployee();
                            VinMall.EmployeeUI();
                            int EmployeeSelect = VinMall.getValidInput(5);
                            switch (EmployeeSelect){
                                case 1: //Hire
                                    VinMall.addEmployee();
                                    break;
                                case 2://Edit
                                    VinMall.editEmloyee();
                                    break;
                                case 3://Dissmis
                                    VinMall.DissmisEmployee();
                                    break;
                                case 4://Find
                                    VinMall.findEmployee();
                                    break;
                                case 5://Sort
                                    VinMall.sortEmployee();
                                    break;
                                case 0:
                                    System.out.println("Back");
                                    stopEmp = true;
                            }
                    }        
                    //------------------------------------endEmployee--------------------------------
                    break;
                case 0:
                    VinMall.saveData();
                    VinMall.clearScreen();
                    System.out.println("Data saved.");
                    System.out.println("Exit.");
                    stop = true;
                    break;
            }
        }
    }

}

