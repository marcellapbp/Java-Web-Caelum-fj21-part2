package beans;

import java.util.Calendar;

/**
 *
 * @author marcella
 */
public class Contact {
    private int Id;
    private String Name;
    private String Email;
    private String Address;
    private Calendar BirthDate;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Calendar getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Calendar BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
