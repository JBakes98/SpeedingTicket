import java.util.Date;

public class Vehicle {

    private String model, make, reg, owner;
    private Date yearMade;

    public Vehicle(String model, String make, String reg, String owner, Date yearMade)
    {
        this.model = model;
        this.make = make;
        this.reg = reg;
        this.owner = owner;
        this.yearMade = yearMade;
    }

    public String getModel() {return model;}
    public String getMake() {return make;}
    public String getReg() {return reg;}
    public String getOwner() {return owner;}
    public Date getYearMade() {return yearMade;}
}
