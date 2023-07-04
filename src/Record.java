import java.time.LocalDate;

public class Record {
    private String lastname;
    private String firstname;
    private String secondname;
    private String birthday;
    private String phone;
    private String gender;

    @Override
    public String toString() {
        return "<" + lastname +
                "><" + firstname +
                "><" + secondname +
                "><" + birthday +
                "><" + phone +
                "><" + gender +
                ">";
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
