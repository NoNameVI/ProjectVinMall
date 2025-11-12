package projectvinmall;

public class Vehicle extends Product {

    protected String chassisNumber, engineType, brand;
    protected int manufactureYear;
    protected double inspectionFee;

    public Vehicle(String id, String name, double price, double rating, String chassisNumber, String engineType,
            String brand, int manufactureYear, double inspectionFee) {
        super(id, name, price, rating);
        this.chassisNumber = chassisNumber;
        this.engineType = engineType;
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.inspectionFee = inspectionFee;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public double getInspectionFee() {
        return inspectionFee;
    }

    public void setInspectionFee(double inspectionFee) {
        this.inspectionFee = inspectionFee;
    }

    @Override
    public String toString() {
        return getId() + "~"
                + getName() + "~"
                + String.format("%.0f~%.1f~", getPrice(), getRating())
                + getChassisNumber() + "~"
                + getEngineType() + "~"
                + getBrand() + "~"
                + String.format("%d", getManufactureYear()) + "~"
                + String.format("%.0f", getInspectionFee());
    }

}
