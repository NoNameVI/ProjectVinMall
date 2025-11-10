package projectvinmall;

class Drink extends Product{
    protected String size;

    public Drink(String id, String name, double price, double rating, String size) {
        super(id, name, price, rating);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getId() + "-" +
           getName() + "-" +
           String.format("%.0f-%.1f-", getPrice(), getRating()) +
           getSize();
    }
    
}