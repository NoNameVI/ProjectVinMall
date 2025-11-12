package projectvinmall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
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
    // color: reset, red, green, yellow, blue, purple, cyan, white
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
                //delay(40);
                //System.out.println("Data loaded: " + line);
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
                        String[] item = BooksList.get(j).split("~");
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
                        String[] item = EmployeesList.get(j).split("~");
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
                        String[] item = AppliancesList.get(j).split("~");
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
                        String[] item = DrinksList.get(j).split("~");
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
                        String[] item = ElectronicsList.get(j).split("~");
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
                        String[] item = VehiclesList.get(j).split("~");
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
                        String[] item = FoodsList.get(j).split("~");
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
                    //delay(40);
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
    String fS(String string, int lenght) { //Chuan Hoa Do Dai Chuoi
        StringBuilder str = new StringBuilder();
        str.append(string);
        while (str.length() < lenght) {
            str.append(" ");
        }
        return str.toString();
    }

    void listEmployee() {
        printlnfc(CYAN, "Employee's List");

        String[] headers = {"ID", "Name", "Phone Number", "Position", "Salary"};

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Employee E : employeeData) {
            if (E.getId().length() > maxlenght) {
                maxlenght = E.getId().length();
            }
            if (E.getName().length() > maxlenght) {
                maxlenght = E.getName().length();
            }
            if (E.getPhoneNum().length() > maxlenght) {
                maxlenght = E.getPhoneNum().length();
            }
            if (E.getPosition().length() > maxlenght) {
                maxlenght = E.getPosition().length();
            }

            String salaryStr = String.format("%.0f", E.getSalary());
            if (salaryStr.length() > maxlenght) {
                maxlenght = salaryStr.length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 12) + " | "
                + fS(headers[3], maxlenght) + " | "
                + fS(headers[4], 15) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Employee E : employeeData) {
            String salaryStr = String.format("%.0f", E.getSalary());

            printlnfc(YELLOW,
                    fS(E.getId(), 6) + " | "
                    + fS(E.getName(), maxlenght) + " | "
                    + fS(E.getPhoneNum(), 12) + " | "
                    + fS(E.getPosition(), maxlenght) + " | "
                    + fS(salaryStr, 15) + " | "
            );
        }

    }

    void listVehicle() {
        printlnfc(CYAN, "List Vehicle");

        String[] headers = {
            "ID", "Name", "Price", "Rating", "Chassis Number",
            "Engine Type", "Brand", "Year", "Inspection Fee"
        };

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Vehicle v : vehicleData) {
            if (v.getId().length() > maxlenght) {
                maxlenght = v.getId().length();
            }
            if (v.getName().length() > maxlenght) {
                maxlenght = v.getName().length();
            }

            if (String.format("%.2f", v.getPrice()).length() > maxlenght) {
                maxlenght = String.format("%.2f", v.getPrice()).length();
            }
            if (String.format("%.1f", v.getRating()).length() > maxlenght) {
                maxlenght = String.format("%.1f", v.getRating()).length();
            }
            if (v.getChassisNumber().length() > maxlenght) {
                maxlenght = v.getChassisNumber().length();
            }
            if (v.getEngineType().length() > maxlenght) {
                maxlenght = v.getEngineType().length();
            }
            if (v.getBrand().length() > maxlenght) {
                maxlenght = v.getBrand().length();
            }
            if (String.valueOf(v.getManufactureYear()).length() > maxlenght) {
                maxlenght = String.valueOf(v.getManufactureYear()).length();
            }
            if (String.format("%.2f", v.getInspectionFee()).length() > maxlenght) {
                maxlenght = String.format("%.2f", v.getInspectionFee()).length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 15) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], 14) + " | "
                + fS(headers[5], 11) + " | "
                + fS(headers[6], 20) + " | "
                + fS(headers[7], 4) + " | "
                + fS(headers[8], 14) + "|";

        printlnfc(YELLOW, headerRow);
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Vehicle v : vehicleData) {

            String priceStr = String.format("%.2f", v.getPrice());
            String ratingStr = String.format("%.1f", v.getRating());
            String yearStr = String.valueOf(v.getManufactureYear());
            String feeStr = String.format("%.2f", v.getInspectionFee());

            printlnfc(YELLOW,
                    fS(v.getId(), 6) + " | "
                    + fS(v.getName(), maxlenght) + " | "
                    + fS(priceStr, 15) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(v.getChassisNumber(), 14) + " | "
                    + fS(v.getEngineType(), 11) + " | "
                    + fS(v.getBrand(), 20) + " | "
                    + fS(yearStr, 4) + " | "
                    + fS(feeStr, 14) + "|"
            );
        }

    }

    //----Electronic method----------------
    void displayElectronic() {
        printlnfc(CYAN, "Electronic List");

        String[] headers = {
            "ID", "Name", "Price", "Rating", "Brand",
            "Model", "Release Year", "Battery Capacity"
        };

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Electronic E : electronicData) {
            if (E.getId().length() > maxlenght) {
                maxlenght = E.getId().length();
            }
            if (E.getName().length() > maxlenght) {
                maxlenght = E.getName().length();
            }

            String priceStr = String.format("%.2f", E.getPrice());
            if (priceStr.length() > maxlenght) {
                maxlenght = priceStr.length();
            }

            String ratingStr = String.format("%.1f", E.getRating());
            if (ratingStr.length() > maxlenght) {
                maxlenght = ratingStr.length();
            }

            if (E.getBrand().length() > maxlenght) {
                maxlenght = E.getBrand().length();
            }
            if (E.getModel().length() > maxlenght) {
                maxlenght = E.getModel().length();
            }

            String yearStr = String.valueOf(E.getReleaseYear());
            if (yearStr.length() > maxlenght) {
                maxlenght = yearStr.length();
            }

            String batteryStr = String.valueOf(E.getBatteryCapacity());
            if (batteryStr.length() > maxlenght) {
                maxlenght = batteryStr.length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 12) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], 15) + " | "
                + fS(headers[5], 10) + " | "
                + fS(headers[6], 12) + " | "
                + fS(headers[7], 18) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Electronic E : electronicData) {
            String priceStr = String.format("%.2f", E.getPrice());
            String ratingStr = String.format("%.1f", E.getRating());
            String yearStr = String.valueOf(E.getReleaseYear());
            String batteryStr = String.valueOf(E.getBatteryCapacity());

            printlnfc(YELLOW,
                    fS(E.getId(), 6) + " | "
                    + fS(E.getName(), maxlenght) + " | "
                    + fS(priceStr, 12) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(E.getBrand(), 15) + " | "
                    + fS(E.getModel(), 10) + " | "
                    + fS(yearStr, 12) + " | "
                    + fS(batteryStr, 18) + " | "
            );
        }

    }

    void addElectronic() {
        System.out.println("-------------Add new Electronic-----------");
        String newEId;
        while (true) {
            System.out.print("Enter new ID:");
            newEId = getValidString();
            if (checkElectronicID(newEId)
                    && newEId.length() == 6
                    && newEId.charAt(0) == 'E') {
                break;
            } else {
                System.out.println("ID Invalid!");
            }
        }
        System.out.print("Enter new Electronic Name:");
        String newEName = getValidString();
        System.out.print("Enter new Electronic Price:");
        double newEPrice = getValidDouble();
        System.out.print("Enter new Electronic Rating:");
        double newERating = getValidDouble();
        while (newERating > 10.0 || newERating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            newERating = getValidDouble();
        }
        System.out.print("Enter new Electronic Brand:");
        String newEBrand = getValidString();
        System.out.print("Enter new Electronic Model:");
        String newEModel = getValidString();
        System.out.print("Enter new Electronic Release Year:");
        int newEReleaseYear = getValidInt();
        System.out.print("Enter new Electronic Battery Capacity:");
        int newEBatteryCapacity = getValidInt();

        Electronic newE = new Electronic(
                newEId,
                newEName,
                newEPrice,
                newERating,
                newEBrand,
                newEModel,
                newEReleaseYear,
                newEBatteryCapacity
        );
        electronicData.add(newE);
        System.out.println("New Electronic Informantion:" + newE.toString());
    }

    void deleteElectronic() {
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
        if (!found) {
            System.out.println("ID not found!");
        }

    }

    void editElectronic() {
        System.out.println("--------------Edit Electronic Information----------------");
        System.out.print("Enter Electronic ID: ");
        String id = getValidString();
        boolean found = false;

        for (Electronic e : electronicData) {
            if (e.getId().equalsIgnoreCase(id)) {
                found = true;

                System.out.print("New Name: ");
                e.setName(getValidString());

                System.out.print("New Price: ");
                e.setPrice(getValidDouble());

                System.out.print("New Rating: ");
                e.setRating(getValidDouble());
                while (e.getRating() < 0.0 || e.getRating() > 10.0) {
                    System.out.print("Please re-enter Rating (0.0-10.0): ");
                    e.setRating(getValidDouble());
                }

                System.out.print("New Brand: ");
                e.setBrand(getValidString());

                System.out.print("New Model: ");
                e.setModel(getValidString());

                System.out.print("New Release Year: ");
                e.setReleaseYear(getValidInt());

                System.out.print("New Battery Capacity (mAh): ");
                e.setBatteryCapacity(getValidInt());
                while (e.getBatteryCapacity() <= 0) {
                    System.out.print("Please re-enter valid Battery Capacity (>0): ");
                    e.setBatteryCapacity(getValidInt());
                }

                System.out.println("Electronic updated successfully!");
                System.out.println(e.toString());
                break;
            }
        }

        if (!found) {
            System.out.println("Electronic ID not found.");
        }

        waitForEnter("Press enter to continue.");
    }
    // update: optimized

    void searchElectronic() {
        boolean value = true;
        while (value) {
            System.out.println("Search by: ");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            boolean found = false;
            switch (choose) {
                case 1:
                    System.out.println("Enter ID: ");
                    String id = getValidString();
                    for (int index = 0; index < electronicData.size(); index++) {
                        if (electronicData.get(index).getId().equalsIgnoreCase(id)) {
                            found = true;
                            System.out.println(electronicData.get(index).toString());
                            break;
                        }

                    }
                    if (!found) {
                        System.out.println("Electronic id or name not found.");
                        break;
                    }

                case 2:
                    System.out.println("Enter Name: ");
                    String name = getValidString();
                    for (int index = 0; index < electronicData.size(); index++) {
                        if (electronicData.get(index).getName().equalsIgnoreCase(name)) {
                            found = true;
                            System.out.println(electronicData.get(index).toString());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Electronic id or name not found.");
                        break;
                    }

                case 0:
                    System.out.println("Exit.");
                    value = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    void sortElectronic() {
        boolean value = true;
        while (value) {
            System.out.println("Sort by: ");
            System.out.println("1. Brand");
            System.out.println("2. Price");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch (choose) {
                case 1:
                    electronicData.sort(Comparator.comparing(Electronic::getBrand));
                    System.out.println("Sorted by Brand successfully!");
                    value = false;
                    break;
                case 2:
                    electronicData.sort(Comparator.comparing(Electronic::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    value = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    value = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
        waitForEnter("\nPress enter to continue.");
    }

//-------Appliance Method------------------
    void listAppliance() {
        printlnfc(CYAN, "Appliance List");

        String[] headers = {
            "ID", "Name", "Price", "Rating", "Brand", "Model", "Release Year"
        };

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Appliance A : applianceData) {
            if (A.getId().length() > maxlenght) {
                maxlenght = A.getId().length();
            }
            if (A.getName().length() > maxlenght) {
                maxlenght = A.getName().length();
            }

            String priceStr = String.format("%.2f", A.getPrice());
            if (priceStr.length() > maxlenght) {
                maxlenght = priceStr.length();
            }

            String ratingStr = String.format("%.1f", A.getRating());
            if (ratingStr.length() > maxlenght) {
                maxlenght = ratingStr.length();
            }

            if (A.getBrand().length() > maxlenght) {
                maxlenght = A.getBrand().length();
            }
            if (A.getModel().length() > maxlenght) {
                maxlenght = A.getModel().length();
            }

            String yearStr = String.valueOf(A.getReleaseYear());
            if (yearStr.length() > maxlenght) {
                maxlenght = yearStr.length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 15) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], 15) + " | "
                + fS(headers[5], 20) + " | "
                + fS(headers[6], 12) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Appliance A : applianceData) {
            String priceStr = String.format("%.2f", A.getPrice());
            String ratingStr = String.format("%.1f", A.getRating());
            String yearStr = String.valueOf(A.getReleaseYear());

            printlnfc(YELLOW,
                    fS(A.getId(), 6) + " | "
                    + fS(A.getName(), maxlenght) + " | "
                    + fS(priceStr, 15) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(A.getBrand(), 15) + " | "
                    + fS(A.getModel(), 20) + " | "
                    + fS(yearStr, 12) + " | "
            );
        }
    }

    void addAppliance() {

        String Aid;
        while (true) {
            System.out.print("Please enter ID: ");
            Aid = getValidString();

            if (checkApplianceID(Aid) && Aid.matches("A\\d{5}")) {
                break;
            } else {
                System.out.println("ID exist!");
            }
        }

        System.out.print("Please enter Name: ");
        String Aname = getValidString();
        System.out.print("Please enter Price: ");
        double Aprice = getValidDouble();
        System.out.print("Please enter Rating: ");
        double Arating = getValidDouble();
        while (Arating > 10.0 || Arating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            Arating = getValidDouble();
        } // update: gioi han rating
        System.out.print("Please enter Brand: ");
        String Abrand = getValidString();
        System.out.print("Please enter Model: ");
        String Amodel = getValidString();
        System.out.print("Please enter Release Year: ");
        int AreleaseYear = getValidInt();
        int currentYear = Year.now().getValue();
        while (AreleaseYear < 1800 || AreleaseYear > currentYear) {
            System.out.print("Please enter Release Year between 1800 to " + currentYear + ": ");
            AreleaseYear = getValidInt();
        }

        Appliance newapp = new Appliance(Aid, Aname, Aprice, Arating, Abrand, Amodel, AreleaseYear);
        applianceData.add(newapp);
        System.out.println("Appliance added success.");

    }

    void deleteAppliance() {
        System.out.print("Please enter ID: ");
        String Aid = getValidString();
        int i = 0;
        boolean found = false;
        while (true) {
            if (applianceData.get(i).getId().equalsIgnoreCase(Aid)) {
                applianceData.remove(i);
                System.out.println("Appliance deleted success.");
                found = true;
                break;
            } else {
                i++;
            }
        }
        if (found == false) {
            System.out.println("Appliance ID not found.");
        }
    }

    void editAppliance() {
        System.out.print("Please enter ID: ");
        String Aid = getValidString();
        boolean found = false;
        for (Appliance a : applianceData) {
            if (a.getId().equalsIgnoreCase(Aid)) {
                found = true;
                System.out.print("Please enter Name: ");
                a.setName(getValidString());
                System.out.print("Please enter Price: ");
                a.setPrice(getValidDouble());
                System.out.print("Please enter Rating: ");
                a.setRating(getValidDouble());
                while (a.getRating() > 10.0 || a.getRating() < 0.0) {
                    System.out.print("Please re-enter Rating(0.0-10.0): ");
                    a.setRating(getValidDouble());
                } // update: gioi han rating
                System.out.print("Please enter Brand: ");
                a.setBrand(getValidString());
                System.out.print("Please enter Model: ");
                a.setModel(getValidString());
                System.out.print("Please enter Release Year: ");
                int AreleaseYear = getValidInt();
                int currentYear = Year.now().getValue();
                while (AreleaseYear < 1800 || AreleaseYear > currentYear) {
                    System.out.print("Please enter Release Year between 1800 to " + currentYear + ": ");
                    AreleaseYear = getValidInt();
                }
                a.setReleaseYear(AreleaseYear);
                break;
            }
        }
        if (found == false) {
            System.out.println("Appliance ID not found.");
        }
    }
    // update: optimized

    void sortAppliance() {
        boolean Asort = true;
        while (Asort) {
            System.out.println("Sort by: ");
            System.out.println("1. Brand");
            System.out.println("2. Price");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch (choose) {
                case 1:
                    applianceData.sort(Comparator.comparing(Appliance::getBrand));
                    System.out.println("Sorted by Brand successfully!");
                    applianceData.forEach(Appliance -> System.out.println(Appliance.toString()));
                    Asort = false;
                    break;
                case 2:
                    applianceData.sort(Comparator.comparing(Appliance::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    applianceData.forEach(Appliance -> System.out.println(Appliance.toString()));
                    Asort = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Asort = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    void searchAppliance() {
        boolean Asearch = true;
        while (Asearch) {
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

    ///Book method///
    void listAllBooks() {
        printlnfc(CYAN, "Book List");

        String[] headers = {"ID", "Name", "Price", "Rating", "Author", "Pages"};

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Book B : bookData) {
            if (B.getId().length() > maxlenght) {
                maxlenght = B.getId().length();
            }
            if (B.getName().length() > maxlenght) {
                maxlenght = B.getName().length();
            }

            String priceStr = String.format("%.2f", B.getPrice());
            if (priceStr.length() > maxlenght) {
                maxlenght = priceStr.length();
            }

            String ratingStr = String.format("%.1f", B.getRating());
            if (ratingStr.length() > maxlenght) {
                maxlenght = ratingStr.length();
            }

            if (B.getAuthor().length() > maxlenght) {
                maxlenght = B.getAuthor().length();
            }

            String pagesStr = String.valueOf(B.getPages());
            if (pagesStr.length() > maxlenght) {
                maxlenght = pagesStr.length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 15) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], maxlenght) + " | "
                + fS(headers[5], 6) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Book B : bookData) {
            String priceStr = String.format("%.2f", B.getPrice());
            String ratingStr = String.format("%.1f", B.getRating());
            String pagesStr = String.valueOf(B.getPages());

            printlnfc(YELLOW,
                    fS(B.getId(), 6) + " | "
                    + fS(B.getName(), maxlenght) + " | "
                    + fS(priceStr, 15) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(B.getAuthor(), maxlenght) + " | "
                    + fS(pagesStr, 6) + " | "
            );
        }// fix bugs: 2 lan wait for
    }

    public void addBook() {
        String id;
        while (true) {
            System.out.print("Book ID: ");
            id = getValidString();

            if (checkBookID(id) && id.matches("B\\d{5}")) {
                break;
            } else {
                System.out.println("ID Invalid!");
            }
        }

        System.out.print("Book Name: ");
        String name = getValidString();
        System.out.print("Price: ");
        double price = getValidDouble();
        System.out.print("Rating: ");
        double rating = getValidDouble();
        while (rating > 10.0 || rating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            rating = getValidDouble();
        } // update: gioi han rating
        System.out.print("Author: ");
        String author = getValidString();
        System.out.print("Pages: ");
        int pages = getValidInt();
        bookData.add(new Book(id, name, price, rating, author, pages));
        System.out.println("Book added.");
    }

    void editBook() {
        System.out.print("Enter book ID to edit: ");
        String id = getValidString();
        boolean found = false;

        for (Book b : bookData) {
            if (b.getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.print("New Name: ");
                b.setName(getValidString());
                System.out.print("New Price: ");
                b.setPrice(getValidDouble());
                System.out.print("New Rating: ");
                b.setRating(getValidDouble());
                while (b.getRating() < 0.0 || b.getRating() > 10.0) {
                    System.out.print("Re-enter Rating (0.0-10.0): ");
                    b.setRating(getValidDouble());
                } // update: gioi han rating 
                System.out.print("New Author: ");
                b.setAuthor(getValidString());
                System.out.print("New Pages: ");
                b.setPages(getValidInt());
                System.out.println("Book updated.");
                break;
            }
        }

        if (found == false) {
            System.out.println("Book ID not found.");
        }
    } // update: optimized

    public void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        String id = getValidString();
        boolean removed = bookData.removeIf(b -> b.getId().equals(id));
        if (removed) {
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void sortBooks() {
        boolean Bsort = true;
        while (Bsort) {
            System.out.println("Sort by: ");
            System.out.println("1. Author");
            System.out.println("2. Price");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch (choose) {
                case 1:
                    bookData.sort(Comparator.comparing(Book::getAuthor));
                    System.out.println("Sorted by Author successfully!");
                    bookData.forEach(Book -> System.out.println(Book.toString()));
                    Bsort = false;
                    break;
                case 2:
                    bookData.sort(Comparator.comparing(Book::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    bookData.forEach(Book -> System.out.println(Book.toString()));
                    Bsort = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Bsort = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
    }

    public void searchBooks() {
        boolean Bsearch = true;
        while (Bsearch) {
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
                    for (Book b : bookData) {
                        if (b.getId().equalsIgnoreCase(searchId)) {
                            System.out.println("Found book:");
                            System.out.println(b.toString());
                            foundId = true;
                            break;
                        }
                    }
                    if (!foundId) {
                        System.out.println("ID not found!");
                    }
                    Bsearch = false;
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String searchName = getValidString().toLowerCase();
                    boolean foundName = false;
                    for (Book b : bookData) {
                        if (b.getName().equalsIgnoreCase(searchName)) {
                            if (!foundName) {
                                System.out.println("Found book:");
                                System.out.println(b.toString());
                                foundName = true;
                                break;
                            }
                        }
                    }
                    if (!foundName) {
                        System.out.println("Name not found!");
                    }
                    Bsearch = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Bsearch = false;
                    break;
                default:
                    System.out.println("Please choose again!");
                    break;
            }
        }
    }

// ------- Drink methods -------
    void listAllDrinks() {
        printlnfc(CYAN, "Drink List");

        String[] headers = {"ID", "Name", "Price", "Rating", "Size"};

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Drink D : drinkData) {
            if (D.getId().length() > maxlenght) {
                maxlenght = D.getId().length();
            }
            if (D.getName().length() > maxlenght) {
                maxlenght = D.getName().length();
            }

            String priceStr = String.format("%.2f", D.getPrice());
            if (priceStr.length() > maxlenght) {
                maxlenght = priceStr.length();
            }

            String ratingStr = String.format("%.1f", D.getRating());
            if (ratingStr.length() > maxlenght) {
                maxlenght = ratingStr.length();
            }

            if (D.getSize().length() > maxlenght) {
                maxlenght = D.getSize().length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 15) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], 4) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Drink D : drinkData) {
            String priceStr = String.format("%.2f", D.getPrice());
            String ratingStr = String.format("%.1f", D.getRating());

            printlnfc(YELLOW,
                    fS(D.getId(), 6) + " | "
                    + fS(D.getName(), maxlenght) + " | "
                    + fS(priceStr, 15) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(D.getSize(), 4) + " | "
            );
        }

    }

    public void addDrink() {
        String id;
        while (true) {
            System.out.print("Drink ID: ");
            id = getValidString();

            if (checkDrinkID(id) && id.matches("D\\d{5}")) {
                break;
            } else {
                System.out.println("ID exist!");
            }
        }
        System.out.print("Drink Name: ");
        String name = getValidString();
        System.out.print("Price: ");
        double price = getValidDouble();
        System.out.print("Rating: ");
        double rating = getValidDouble();
        while (rating > 10.0 || rating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            rating = getValidDouble();
        } // update: gioi han rating
        System.out.print("Size: ");
        String size = getValidString();
        drinkData.add(new Drink(id, name, price, rating, size));
        System.out.println("Drink added.");
    }

    public void editDrink() {
        System.out.print("Enter drink ID to edit: ");
        String id = getValidString();
        boolean found = false;

        for (Drink d : drinkData) {
            if (d.getId().equalsIgnoreCase(id)) {

                found = true;
                System.out.print("New Name: ");
                d.setName(getValidString());

                System.out.print("New Price: ");
                d.setPrice(getValidDouble());

                System.out.print("New Rating: ");
                d.setRating(getValidDouble());

                while (d.getRating() < 0.0 || d.getRating() > 10.0) {
                    System.out.print("Please re-enter Rating (0.0-10.0): ");
                    d.setRating(getValidDouble());
                } // update: gioi han rating

                System.out.print("New Size: ");
                d.setSize(getValidString());

                System.out.println("Drink updated.");
                break;

            }
        }

        if (found == false) {
            System.out.println("Drink ID not found.");
        }
    } // update: optimized

    public void sortDrinks() {

        boolean Dsort = true;
        while (Dsort) {
            System.out.println("Sort by: ");
            System.out.println("1. Price");
            System.out.println("2. Rating");
            System.out.println("0. Exit");
            int choose = getValidInput(3);
            switch (choose) {
                case 1:
                    drinkData.sort(Comparator.comparing(Drink::getPrice));
                    System.out.println("Sorted by Price successfully!");
                    bookData.forEach(Drink -> System.out.println(Drink.toString()));
                    Dsort = false;
                    break;
                case 2:
                    drinkData.sort(Comparator.comparing(Drink::getPrice));
                    System.out.println("Sorted by Rating successfully!");
                    drinkData.forEach(Drink -> System.out.println(Drink.toString()));
                    Dsort = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Dsort = false;
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }

    }

    public void deleteDrink() {
        System.out.print("Enter drink ID to delete: ");
        String id = getValidString();
        boolean removed = drinkData.removeIf(d -> d.getId().equals(id));
        if (removed) {
            System.out.println("Drink deleted.");
        } else {
            System.out.println("Drink not found.");
        }
    }

    public void SearchDrinks() {
        boolean Dsearch = true;
        while (Dsearch) {
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
                    for (Drink d : drinkData) {
                        if (d.getId().equalsIgnoreCase(searchId)) {
                            System.out.println("Found drink:");
                            System.out.println(d.toString());
                            foundId = true;
                            break;
                        }
                    }
                    if (!foundId) {
                        System.out.println("ID not found!");
                    }
                    Dsearch = false;
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String searchName = getValidString().toLowerCase();
                    boolean foundName = false;
                    for (Drink d : drinkData) {
                        if (d.getName().equalsIgnoreCase(searchName)) {
                            if (!foundName) {
                                System.out.println("Found drink:");
                                System.out.println(d.toString());
                                foundName = true;
                                break;
                            }
                        }
                    }
                    if (!foundName) {
                        System.out.println("Name not found!");
                    }
                    Dsearch = false;
                    break;
                case 0:
                    System.out.println("Exit.");
                    Dsearch = false;
                    break;
                default:
                    System.out.println("Please choose again!");
                    break;
            }
        }
    }
    //-------------Food method-------------------------

    void listAllFoods() {
        printlnfc(CYAN, "Food List");

        String[] headers = {"ID", "Name", "Price", "Rating", "Size"};

        int maxlenght = 0;

        for (String h : headers) {
            if (h.length() > maxlenght) {
                maxlenght = h.length();
            }
        }

        for (Food food : foodData) {
            if (food.getId().length() > maxlenght) {
                maxlenght = food.getId().length();
            }
            if (food.getName().length() > maxlenght) {
                maxlenght = food.getName().length();
            }

            String priceStr = String.format("%.2f", food.getPrice());
            if (priceStr.length() > maxlenght) {
                maxlenght = priceStr.length();
            }

            String ratingStr = String.format("%.1f", food.getRating());
            if (ratingStr.length() > maxlenght) {
                maxlenght = ratingStr.length();
            }

            if (food.getSize().length() > maxlenght) {
                maxlenght = food.getSize().length();
            }
        }

        String headerRow = fS(headers[0], 6) + " | "
                + fS(headers[1], maxlenght) + " | "
                + fS(headers[2], 15) + " | "
                + fS(headers[3], 6) + " | "
                + fS(headers[4], 4) + " | ";

        printlnfc(YELLOW, headerRow);

        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < headerRow.length(); i++) {
            separator.append("_");
        }
        printlnfc(YELLOW, separator.toString());

        for (Food food : foodData) {
            String priceStr = String.format("%.2f", food.getPrice());
            String ratingStr = String.format("%.1f", food.getRating());

            printlnfc(YELLOW,
                    fS(food.getId(), 6) + " | "
                    + fS(food.getName(), maxlenght) + " | "
                    + fS(priceStr, 15) + " | "
                    + fS(ratingStr, 6) + " | "
                    + fS(food.getSize(), 4) + " | "
            );
        }

    }

    public void addFood() {
        String id;
        while (true) {
            System.out.print("Food ID: ");
            id = getValidString();

            if (checkFoodID(id) && id.matches("F\\d{5}")) {
                break;
            } else {
                System.out.println("ID exist!");
            }
        }
        System.out.print("Food Name: ");
        String name = getValidString();
        System.out.print("Price: ");
        double price = getValidDouble();
        System.out.print("Rating: ");
        double rating = getValidDouble();
        while (rating > 10.0 || rating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            rating = getValidDouble();
        } // update: gioi han rating
        System.out.print("Size: ");
        String size = getValidString();
        foodData.add(new Food(id, name, price, rating, size));
        System.out.println("Food added.");
    }

    public void editFood() {
        System.out.print("Enter food ID to edit: ");
        String id = getValidString();
        boolean found = false;

        for (Food f : foodData) {
            if (f.getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.print("New Name: ");
                f.setName(getValidString());

                System.out.print("New Price: ");
                f.setPrice(getValidDouble());

                System.out.print("New Rating: ");
                f.setRating(getValidDouble());
                while (f.getRating() < 0.0 || f.getRating() > 10.0) {
                    System.out.print("Please re-enter Rating (0.0-10.0): ");
                    f.setRating(getValidDouble());
                } // update: gioi han rating

                System.out.print("New Size: ");
                f.setSize(getValidString());

                System.out.println("Food updated.");
                break;
            }
        }

        if (found == false) {
            System.out.println("Food ID not found.");
        }
    }// update: optimized

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
    }
    //-----------------------------------Employee Method-------------------------------

    void addEmployee() {
        System.out.println("--------------Hire new Employee----------------");
        String newEmId;
        while (true) {
            System.out.print("Enter new ID:");
            newEmId = getValidString();
            if (checkEmployeeID(newEmId)
                    && newEmId.length() == 6
                    && newEmId.charAt(0) == 'E') {
                break;
            } else {
                System.out.println("ID exist!");
            }
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

    }

    void editEmployee() {
        System.out.println("--------------Edit Employee Information----------------");
        System.out.print("Enter Employee ID: ");
        String id = getValidString();
        boolean found = false;

        for (Employee e : employeeData) {
            if (e.getId().equalsIgnoreCase(id)) {
                found = true;

                System.out.printf("New Name(Blank to keep %s ): ", e.getName());
                String name = sc.nextLine().trim();
                if (!name.isEmpty()) {
                    e.setName(name);
                }

                System.out.printf("New Position(Blank to keep %s ): ", e.getPosition());
                String pos = sc.nextLine();
                if (!pos.isEmpty()) {
                    e.setPosition(pos);
                }

                System.out.printf("New Phone Number(Blank to keep %s ): ", e.getPhoneNum());
                String phone = sc.nextLine().trim();
                if (!phone.isEmpty()) {
                    e.setPhoneNum(phone);
                }

                while (true) {
                    System.out.printf("New Salary(Blank to keep %.0f ): ", e.getSalary());
                    String salary = sc.nextLine().trim();
                    if (salary.isEmpty()) {
                        break;
                    }
                    double sala;
                    try {
                        sala = Double.parseDouble(salary);
                        if (sala < 0) {
                            printlnfc(GREEN, "Positive Real number only!");
                        } else {
                            e.setSalary(sala);
                            break;
                        }
                    } catch (NumberFormatException err) {
                        printlnfc(GREEN, "Real number only!");
                    }

                }

                System.out.println("Employee infor: " + e.getInfo());

            }
        }

        if (found == false) {
            System.out.println("Employee ID not found.");
        }

    }

    // update: optimized
    void DissmisEmployee() {
        System.out.println("--------------Dissmis Employees-----------------");
        String newEmId;
        while (true) {
            System.out.print("Enter Employee ID:");
            newEmId = getValidString();
            if (!checkEmployeeID(newEmId)) {

                break;
            } else {
                System.out.println("ID not exist!");
            }
        }
        int i = 0;
        for (int index = 0; index < employeeData.size(); index++) {
            if (employeeData.get(index).getId().equalsIgnoreCase(newEmId)) {
                i = index;
                break;
            }
        }

        employeeData.remove(i);
        System.out.println("Employee Dissmised");
    }

    void findEmployee() {
        System.out.println("--------------Find Employees-----------------");
        System.out.print("What are you looking for? :");
        String find = getValidString();
        int notfind = 0;
        for (Employee e : employeeData) {
            if (e.getId().contains(find)
                    || e.getName().contains(find)
                    || e.getPosition().contains(find)) {
                System.out.println(e.getInfo());
                ++notfind;
            }
        }
        if (notfind == 0) {
            System.out.println("No resuft!");

        }

    }

    void sortEmployee() {
        boolean sortstop = false;
        while (!sortstop) {
            System.out.println("--------------Sort Employees-----------------");
            System.out.println("Sorting by what?");
            System.out.println("1. ID");
            System.out.println("2. First Name");
            System.out.println("3. Salary");
            System.out.println("4. Position");
            System.out.println("0. Back to Employees manage");
            int sortEmSelect = getValidInput(4);
            switch (sortEmSelect) {
                case 1:
                    employeeData.sort(Comparator.comparing(Employee::getId));
                    System.out.println("-----------List sorted by ID------------");
                    listEmployee();

                    break;
                case 2:
                    employeeData.sort(Comparator.comparing(Employee::getName));
                    System.out.println("-----------List sorted by Name------------");
                    listEmployee();
                    break;
                case 3:
                    employeeData.sort(Comparator.comparing(Employee::getSalary));
                    System.out.println("-----------List sorted by Salary------------");
                    listEmployee();
                    break;
                case 4:
                    employeeData.sort(Comparator.comparing(Employee::getPosition));
                    System.out.println("-----------List sorted by Position------------");
                    listEmployee();
                    break;
                case 0:
                    System.out.println("Data saved.");
                    sortstop = true;
                    break;
            }

        }

    }

    //Vehicle Method------------------------------------
    void addVehicle() {
        System.out.println("-------------Add new Vehicle-----------");
        String newVeId;
        while (true) {
            System.out.print("Enter new ID:");
            newVeId = getValidString();
            if (checkVehicleID(newVeId)
                    && newVeId.length() == 6
                    && newVeId.charAt(0) == 'V') {
                break;
            } else {
                System.out.println("ID Invalid!");
            }
        }
        System.out.print("Enter new vehicle Name:");
        String newVeName = getValidString();
        System.out.print("Enter new vehicle Price:");
        double newPrice = getValidDouble();
        System.out.print("Enter new vehicle Rating:");
        double newRating = getValidDouble();
        while (newRating > 10.0 || newRating < 0.0) {
            System.out.print("Please re-enter Rating(0.0-10.0): ");
            newRating = getValidDouble();
        } // update: gioi han rating
        System.out.print("Enter new vehicle Chassis Number:");
        String newCha = getValidString();
        System.out.print("Enter new vehicle Engine Type:");
        String newengineType = getValidString();
        System.out.print("Enter new vehicle brand:");
        String newbrand = getValidString();
        System.out.print("Enter new vehicle manufacture Year:");
        int newmanuyear = getValidInt();
        while (newmanuyear < 1800) {
            System.out.print("Enter new vehicle inspection Fee:");
        }
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
        System.out.println("New Vehicle Informantion:" + newVe.toString());

    }

    void editVehicle() {
        System.out.println("--------------Edit Vehicle Information----------------");
        System.out.print("Enter Vehicle ID: ");
        String id = getValidString();
        boolean found = false;

        for (Vehicle v : vehicleData) {
            if (v.getId().equalsIgnoreCase(id)) {
                found = true;

                System.out.printf("New Name(Blank to keep %s): ", v.getName());
                String name = sc.nextLine().trim();
                if (!name.isEmpty()) {
                    v.setName(name);
                }

                System.out.printf("New Price(Blank to keep %.2f): ", v.getPrice());
                String priceLine = sc.nextLine().trim();
                if (!priceLine.isEmpty()) {
                    while (true) {
                        try {
                            double p = Double.parseDouble(priceLine);
                            v.setPrice(p);
                            break;
                        } catch (NumberFormatException err) {
                            printlnfc(GREEN, "Real number only!");
                            System.out.print("New Price(Blank to keep " + String.format("%.2f", v.getPrice()) + "): ");
                            priceLine = sc.nextLine().trim();
                            if (priceLine.isEmpty()) {
                                break;
                            }
                        }
                    }
                }

                System.out.printf("New Rating(Blank to keep %.1f): ", v.getRating());
                String ratingLine = sc.nextLine().trim();
                if (!ratingLine.isEmpty()) {
                    while (true) {
                        try {
                            double r = Double.parseDouble(ratingLine);
                            if (r < 0.0 || r > 10.0) {
                                System.out.print("Please re-enter Rating (0.0-10.0): ");
                                ratingLine = sc.nextLine().trim();
                                if (ratingLine.isEmpty()) {
                                    break;
                                }
                                continue;
                            }
                            v.setRating(r);
                            break;
                        } catch (NumberFormatException err) {
                            printlnfc(GREEN, "Real number only!");
                            System.out.print("New Rating(Blank to keep " + String.format("%.1f", v.getRating()) + "): ");
                            ratingLine = sc.nextLine().trim();
                            if (ratingLine.isEmpty()) {
                                break;
                            }
                        }
                    }
                }

                System.out.printf("New Chassis Number(Blank to keep %s): ", v.getChassisNumber());
                String chassis = sc.nextLine().trim();
                if (!chassis.isEmpty()) {
                    v.setChassisNumber(chassis);
                }

                System.out.printf("New Engine Type(Blank to keep %s): ", v.getEngineType());
                String engine = sc.nextLine().trim();
                if (!engine.isEmpty()) {
                    v.setEngineType(engine);
                }

                System.out.printf("New Brand(Blank to keep %s): ", v.getBrand());
                String brand = sc.nextLine().trim();
                if (!brand.isEmpty()) {
                    v.setBrand(brand);
                }

                System.out.printf("New Manufacture Year(Blank to keep %d): ", v.getManufactureYear());
                String yearLine = sc.nextLine().trim();
                if (!yearLine.isEmpty()) {
                    while (true) {
                        try {
                            int Y = Integer.parseInt(yearLine);
                            int CY = Year.now().getValue();
                            if (Y < 1800 || Y > CY) {
                                if (Y < -230000000) {
                                    printlnfc(GREEN, "Bro think dinosaurs can drive?");
                                } else if (Y < 0) {
                                    printlnfc(GREEN, "Hmm, I think people from before the Common Era could have built vehicles, but I can't prove it.");
                                } else if (Y < 1500) {
                                    printlnfc(GREEN, "There were no cars in the Middle Ages, sir!");
                                } else if (Y > 2100) {
                                    printlnfc(GREEN, "Sir, do you need me to help you find a time machine?");
                                } else {
                                    printlnfc(GREEN, "Bro try again!");
                                }
                                System.out.print("New Manufacture Year(Blank to keep " + v.getManufactureYear() + "): ");
                                yearLine = sc.nextLine().trim();
                                if (yearLine.isEmpty()) {
                                    break;
                                }
                                continue;
                            }
                            v.setManufactureYear(Y);
                            break;
                        } catch (NumberFormatException err) {
                            printlnfc(GREEN, "Integer number only!");
                            System.out.print("New Manufacture Year(Blank to keep " + v.getManufactureYear() + "): ");
                            yearLine = sc.nextLine().trim();
                            if (yearLine.isEmpty()) {
                                break;
                            }
                        }
                    }
                }

                System.out.printf("New Inspection Fee(Blank to keep %.2f): ", v.getInspectionFee());
                String feeLine = sc.nextLine().trim();
                if (!feeLine.isEmpty()) {
                    while (true) {
                        try {
                            double f = Double.parseDouble(feeLine);
                            if (f < 0.0) {
                                System.out.print("Please re-enter Inspection Fee (>=0): ");
                                feeLine = sc.nextLine().trim();
                                if (feeLine.isEmpty()) {
                                    break;
                                }
                                continue;
                            }
                            v.setInspectionFee(f);
                            break;
                        } catch (NumberFormatException err) {
                            printlnfc(GREEN, "Real number only!");
                            System.out.print("New Inspection Fee(Blank to keep " + String.format("%.2f", v.getInspectionFee()) + "): ");
                            feeLine = sc.nextLine().trim();
                            if (feeLine.isEmpty()) {
                                break;
                            }
                        }
                    }
                }

                System.out.println("Vehicle Informantion: " + v.toString());
                break;
            }
        }

        if (found == false) {
            System.out.println("Vehicle ID not found.");
        }

    }
    // update: optimized

    void deleteVehicle() {
        System.out.println("--------------Delete Vehicle-----------------");
        String newEmId;
        while (true) {
            System.out.print("Enter vehicle ID:"); // fix bugs: loi copy ko sua
            newEmId = getValidString();
            if (!checkVehicleID(newEmId)) {
                break;
            } else {
                System.out.println("ID not exist!");
            }
        }
        int i = 0;
        for (int index = 0; index < vehicleData.size(); index++) {
            if (vehicleData.get(index).getId().equalsIgnoreCase(newEmId)) {
                i = index;
                break;
            }
        }

        vehicleData.remove(i);
        System.out.println("Vehicle Deleted.");

    }

    void sortVehicle() {
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
            switch (sortEmSelect) {
                case 1:
                    vehicleData.sort(Comparator.comparing(Vehicle::getId));
                    System.out.println("----------- List sorted by ID ------------");
                    listVehicle();

                    break;
                case 2:
                    vehicleData.sort(Comparator.comparing(Vehicle::getName));
                    System.out.println("----------- List sorted by Name ------------");
                    listVehicle();
                    break;
                case 3:
                    vehicleData.sort(Comparator.comparing(Vehicle::getPrice));
                    System.out.println("----------- List sorted by Price ------------");
                    listVehicle();
                    break;
                case 4:
                    vehicleData.sort(Comparator.comparing(Vehicle::getRating));
                    System.out.println("-----------List sorted by Rating ------------");
                    listVehicle();

                    break;
                case 5:
                    vehicleData.sort(Comparator.comparing(Vehicle::getChassisNumber));
                    System.out.println("-----------List sorted by Chassis Number ------------");
                    listVehicle();
                    break;
                case 6:
                    vehicleData.sort(Comparator.comparing(Vehicle::getEngineType));
                    System.out.println("-----------List sorted by EngineType ------------");
                    listVehicle();
                    break;
                case 7:
                    vehicleData.sort(Comparator.comparing(Vehicle::getBrand));
                    System.out.println("-----------List sorted by Brand ------------");
                    listVehicle();

                    break;
                case 8:
                    vehicleData.sort(Comparator.comparing(Vehicle::getManufactureYear));
                    System.out.println("-----------List sorted by Manufacture Year ------------");
                    listVehicle();
                    break;
                case 9:
                    vehicleData.sort(Comparator.comparing(Vehicle::getInspectionFee));
                    System.out.println("-----------List sorted by Inspection Fee ------------");
                    listVehicle();
                    break;
                case 0:
                    System.out.println("Data saved.");
                    sortstop = true;
                    break;
            }

        }
    }

    void findVehicle() {
        clearScreen();
        System.out.println("--------------Find Vehicle-----------------");

        String find = "find";
        while (!find.isEmpty()) {
            System.out.print("Enter any thing to find(Enter to back):");
            find = sc.nextLine().toLowerCase().trim();
            if (find.isEmpty()) {
                break;
            }
            System.out.println("--------------List Find Vehicle-----------------");
            int notfind = 0;
            for (Vehicle e : vehicleData) {
                if (e.getId().toLowerCase().contains(find)
                        || e.getName().toLowerCase().contains(find)
                        || e.getBrand().toLowerCase().contains(find)
                        || e.getChassisNumber().toLowerCase().contains(find)
                        || e.getEngineType().toLowerCase().contains(find)
                        || String.valueOf(e.getManufactureYear()).toLowerCase().contains(find)
                        || String.valueOf(e.getInspectionFee()).toLowerCase().contains(find)
                        || String.valueOf(e.getPrice()).toLowerCase().contains(find)
                        || String.valueOf(e.getRating()).toLowerCase().contains(find)) {
                    System.out.println(e.toString());
                    ++notfind;
                }
            }
            if (notfind == 0) {
                System.out.println("No resuft!");
            }

        }

    }
    //----------------------------------------------------Anh em them ham UI o day----------------------------------------------------------------------------------------------------------------

    // color: reset, red, green, yellow, blue, purple, cyan, white
    public void mainUI() {//Vi du y nhu cai nay
        printlnfc(YELLOW, "----MALL MANAGEMENT SYSTEM----");
        printlnfc(CYAN, "1. Manage Books");
        printlnfc(CYAN, "2. Manage Appliances");
        printlnfc(CYAN, "3. Manage Drinks");
        printlnfc(CYAN, "4. Manage Electronics");
        printlnfc(CYAN, "5. Manage Foods");
        printlnfc(CYAN, "6. Manage Vehicles");
        printlnfc(CYAN, "7. Manage Employees");
        printlnfc(CYAN, "0. Exit");

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
        System.out.println("---- FOOD MANAGEMENT ----");
        System.out.println("1. List all foods");
        System.out.println("2. Add a food");
        System.out.println("3. Edit a food");
        System.out.println("4. Delete a food");
        System.out.println("5. Sort foods by (ID, Name, Rating, Price)");
        System.out.println("6. Search foods by (ID or Name)");
        System.out.println("0. Back to Main Menu");
    }

    public void BookUI() {
        System.out.println("---- BOOK MANAGEMENT ----");
        System.out.println("1. List all books");
        System.out.println("2. Add a book");
        System.out.println("3. Edit a book");
        System.out.println("4. Delete a book");
        System.out.println("5. Sort books by (Author, Price)");
        System.out.println("6. Search book by (ID, Name)");
        System.out.println("0. Back to Main Menu");
    }

    public void DrinkUI() {
        System.out.println("---- DRINK MANAGEMENT ----");
        System.out.println("1. List all drinks");
        System.out.println("2. Add a drink");
        System.out.println("3. Edit a drink");
        System.out.println("4. Delete a drink");
        System.out.println("5. Sort drinks by (Rating, Price)");
        System.out.println("6. Search drink by (ID, Name)");
        System.out.println("0. Back to Main Menu");
    }

    public boolean checkEmployeeID(String id) {
        return !employeeData.stream().anyMatch((EM) -> (EM.getId().equalsIgnoreCase(id)));
    }

    public boolean checkVehicleID(String id) {

        return !vehicleData.stream().anyMatch((EM) -> (EM.getId().equalsIgnoreCase(id)));
    }

    public boolean checkBookID(String id) {
        return !bookData.stream().anyMatch((B) -> (B.getId().equalsIgnoreCase(id)));
    }

    public boolean checkFoodID(String id) {
        return !foodData.stream().anyMatch((F) -> (F.getId().equalsIgnoreCase(id)));
    }

    public boolean checkDrinkID(String id) {
        return !drinkData.stream().anyMatch((D) -> (D.getId().equalsIgnoreCase(id)));
    }

    public boolean checkApplianceID(String id) {
        return !applianceData.stream().anyMatch((A) -> (A.getId().equalsIgnoreCase(id)));
    }

    public boolean checkElectronicID(String id) {
        return !electronicData.stream().anyMatch((E) -> (E.getId().equalsIgnoreCase(id)));
    }
    //###########################Dung ham nay de nhan input ma nguoi dung nhap ############################

    /**
     *
     * @return
     */
    @Override
    public int getValidInput(int range) {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.print("Please select an option: ");
        if (sc.hasNextInt()) {

            input = sc.nextInt();

            if (input >= 0 && input <= range) { //Nho truyen range la gia tri toi da vao 
                return input;
            } else {
                System.out.printf("The value is out of range(0-%d).\n", range);
            }

        } // fix bugs: tranh repeat 2 lan enter
        return getValidInput(range);
    }

    @Override
    public String getValidString() {
        String string;
        Scanner sc = new Scanner(System.in);
        string = null;
        string = sc.nextLine().trim();
        if (string == null || string.isEmpty()) {
            System.out.print("Try again!:");
            return getValidString(); // fix bugs: khong tra gia tri
        }
        return string;
    }

    @Override
    public double getValidDouble() {
        double input = 0.0;
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextDouble()) {
            input = sc.nextDouble();

        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            return getValidDouble(); // fix bugs: khong tra gia tri
        }

        return input;
    }

    @Override
    public int getValidInt() {
        int input = 0;
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            input = sc.nextInt();

        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            return getValidInt(); // fix bugs: khong tra gia tri
        }

        return input;
    }

    @Override
    public void clearScreen() {
        try {
            delay(350);
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

    @Override
    public void delay(long s) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < s) {
        }
    }

    public void waitForEnter(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextLine()) {
        }
        sc.nextLine();
    } // fix bugs: dung de cho nhan enter

    public static void printfc(String color, String format, Object... args) {
        System.out.printf(color + format + RESET, args);
    }

    public static void printlnfc(String color, String format, Object... args) {
        System.out.printf(color + format + RESET, args);
        System.out.println();
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
                        VinMall.clearScreen();
                        switch (BookSelect) {
                            case 1:
                                VinMall.listAllBooks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addBook();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.editBook();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.deleteBook();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.sortBooks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 6:
                                VinMall.searchBooks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
                    while (stopA) {
                        VinMall.clearScreen();
                        VinMall.ApplianceUI();
                        int ApplianceSelect = VinMall.getValidInput(7);
                        VinMall.clearScreen();
                        switch (ApplianceSelect) {
                            case 1:
                                VinMall.listAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.editAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.deleteAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.sortAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 6:
                                VinMall.searchAppliance();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
                        VinMall.clearScreen();
                        VinMall.DrinkUI();
                        int DrinkSelect = VinMall.getValidInput(6);
                        VinMall.clearScreen();
                        switch (DrinkSelect) {
                            case 1:
                                VinMall.listAllDrinks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addDrink();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.editDrink();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.deleteDrink();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.sortDrinks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 6:
                                VinMall.SearchDrinks();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
                case 4: {
                    boolean stopE = true;
                    while (stopE) {
                        VinMall.clearScreen();
                        VinMall.ElectronicUI();
                        int ElectronicSelect = VinMall.getValidInput(6);
                        VinMall.clearScreen();
                        switch (ElectronicSelect) {
                            case 1:
                                VinMall.displayElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.editElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.deleteElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.sortElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 6:
                                VinMall.searchElectronic();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
                        VinMall.clearScreen();
                        VinMall.FoodUI();
                        int FoodSelect = VinMall.getValidInput(5);
                        VinMall.clearScreen();
                        switch (FoodSelect) {
                            case 1:
                                VinMall.listAllFoods();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.addFood();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.editFood();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.deleteFood();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.SortFoods();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 6:
                                VinMall.searchFoods();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
                    while (!stopVe) {
                        VinMall.clearScreen();
                        VinMall.listVehicle();
                        VinMall.VehicleUI();
                        int VehicleSelect = VinMall.getValidInput(5);

                        switch (VehicleSelect) {
                            case 1:
                                VinMall.addVehicle();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2:
                                VinMall.editVehicle();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3:
                                VinMall.deleteVehicle();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4:
                                VinMall.sortVehicle();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5:
                                VinMall.findVehicle();
                                VinMall.clearScreen();
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
                        VinMall.listEmployee();
                        VinMall.EmployeeUI();
                        int EmployeeSelect = VinMall.getValidInput(5);
                        VinMall.clearScreen();
                        switch (EmployeeSelect) {
                            case 1: //Hire
                                VinMall.addEmployee();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 2://Edit
                                VinMall.editEmployee();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 3://Dissmis
                                VinMall.DissmisEmployee();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 4://Find
                                VinMall.findEmployee();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
                                break;
                            case 5://Sort
                                VinMall.sortEmployee();
                                VinMall.waitForEnter("\nPress enter to continue.");
                                VinMall.clearScreen();
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
    }   // lam mau: cls, wait moi lan nhap lenh

}

