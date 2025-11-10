package projectvinmall;

public class Electronic extends Product {

    protected String brand, model;
    protected int releaseYear, batteryCapacity;

    public Electronic(String id, String name, double price, double rating, String brand, String model, int releaseYear, int batteryCapacity) {
        super(id, name, price, rating);
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.batteryCapacity = batteryCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return getId() + "-"
                + getName() + "-"
                + String.format("%.0f-%.1f-", getPrice(), getRating())
                + getBrand() + "-"
                + getModel() + "-"
                + String.format("%d", getReleaseYear()) + "-"
                + String.format("%d", getBatteryCapacity());
    }

}
