package entity;

import java.sql.Date;

public class User {
    private int id;
    private String userName;
    private String password;
    private Date birthDate;
    private String phone;

    public User(int id, String userName, String password, Date birthDate, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
