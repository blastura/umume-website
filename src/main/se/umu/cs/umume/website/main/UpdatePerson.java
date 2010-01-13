package se.umu.cs.umume.website.main;

public class UpdatePerson {

    private String description;
    private String twitter;
    private String ticket;
    private String userName;
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTwitter() {
        return twitter;
    }
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public String getTicket() {
        return ticket;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
}
