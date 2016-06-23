package edu.iit.lazaro.bookreviews;

/**
 * Created by Lazaro on 3/28/16.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private String rating;
    private String imageName;

    public Book(){}

    public Book(String title, String author, String rating, String imageName) {
        super();
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.imageName = imageName;
    }
    //getters & setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() {  return author;  }
    public void setAuthor(String author) { this.author = author; }
    public void setRating(String rating) { this.rating = rating; }
    public String getRating() { return rating; }
    public void setImageName(String imageName) { this.imageName = imageName; }
    public String getImageName() { return imageName; }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + ", rating=" + rating + "]";
    }

}
