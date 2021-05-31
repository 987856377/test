package java8.reflect;

public class Student extends Person {

    private Integer score;
    private String title;
    private Boolean la;
    private User user;

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", title='" + title + '\'' +
                ", la=" + la +
                ", user=" + user +
                "} " + super.toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean isLa() {
        return la;
    }

    public void setLa(Boolean la) {
        this.la = la;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
