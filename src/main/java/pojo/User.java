package pojo;

public class User {
    private int id;
    private String user;
    private String password;
    private int type;
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User(int id, String user, String password, int type, int grade) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.type = type;
        this.type = grade;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

}
