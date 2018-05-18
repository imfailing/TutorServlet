package pojo;

public class User {
    private int id;
    private String user;
    private String password;
    private int type;

    public User(int id, String user, String password, int type) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.type = type;
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
