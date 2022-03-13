package pojo;

public class TodosPojo {
   /*
   {
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 } */
    //1.adim Degiskenleri privat yap
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    //2.adim bu degerlere ulasabilmek icin getter ve setter methodlari olustur


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //3.adim parametreli ve parametresiz construtor olustur
    public TodosPojo() {
    }

    public TodosPojo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //4.adim toString methodu olustur

    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
