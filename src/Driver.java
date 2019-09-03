import java.util.Date;

public class Driver {
    private String firstName, lastName, licenseNum;
    private Date DOB;
    private String address;

    public Driver(String firstName, String lastName, String licenseNum, //Date DOB,
         String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNum = licenseNum;
        //this.DOB = DOB;
        this.address = address;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getLicenseNum() {return licenseNum;}
    public Date getDOB() {return DOB;}
    public String getAddress() {return address;}

}
