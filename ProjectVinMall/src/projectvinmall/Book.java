
package projectvinmall;


public class Book extends Product{
    protected String author;
    protected int pages;
    public Book(String id, String name, double price, double rating, String author, int pages) {
        super(id, name, price, rating);
        this.author = author;
        this.pages = pages;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    @Override
    public String toString() {
        return getId() + "-" +
                getName() + "-" +
                String.format("%.0f-%.1f-", getPrice(), getRating()) +
                getAuthor() + "-" +
                String.format("%d", getPages());
    }
        
}

