
package projectvinmall;


public class Food extends Product{
    protected String size;

    public Food(String id, String name, double price, double rating, String size) {
        super(id, name, price, rating);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public void update() {

    }

    public static void UI() {
        System.out.println("----Food UI");
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%.0f-%,1f-%s",getId(),getName(),getPrice(),getRating(),getSize());
    }
    
}