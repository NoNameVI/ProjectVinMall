
package projectvinmall;

import java.time.Year;


public class Appliance extends Product{
    protected String brand, model;
    protected int releaseYear;
    public Appliance(String id, String name, double price, double rating, String brand, String model, int releaseYear) {
        super(id, name, price, rating);
        this.setBrand(brand);
        this.setModel(model);
        this.setReleaseYear(releaseYear);
    }
    public String getBrand() {return brand;}
    public String getModel() {return model;}
    public int getReleaseYear() {return releaseYear;}
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException("brand cannot be empty");}
        this.brand = brand;}
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()){
            throw new IllegalArgumentException("model cannot be empty");}
        this.model = model;}
    public void setReleaseYear(int releaseYear) {
        int currentYear = Year.now().getValue();
        if (releaseYear<2000 || releaseYear > currentYear){
            throw new IllegalArgumentException("releaseYear should be in 2000-"+currentYear);}
        this.releaseYear = releaseYear;}
    
    @Override
    public String toString(){
        return getId()+"-"+getName()+"-"+String.format("%.0f-%.1f-",getPrice(),getRating())+getBrand()+"-"+getModel()+String.format("-%d",getReleaseYear());
    }
}
