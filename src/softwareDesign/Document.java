package softwareDesign;

import java.util.Date;

public abstract class Document {

    private String title;
    private String author;
    private Date date;
    private PublishingLocation adress;

    public Document(String title, String author, Date date, String city, String state, String postCode) {
	this.title = title;
	this.author = author;
	this.date = date;
	this.adress = new PublishingLocation(city, state, postCode);
    }

    public String getTitle() {
    	return title;
    }

    public String getAuthor() {
    	return author;
    }

    public Date getDate() {
    	return date;
    }

    public String getCity() {
    	return adress.getCity();
    }

    public String getState() {
    	return adress.getState();
    }

    public String getPostCode() {
    	return adress.getPostCode();
    }

    public boolean sameAuthor(NewspaperArticle article) {
    	return this.author.equals(article.getAuthor());
    }

    public int compareDates(NewspaperArticle article) {
    	return this.date.compareTo(article.getDate());
    }

    public int compareWithGeneralDate(Date date) {
    	return this.date.compareTo(date);
    }

}