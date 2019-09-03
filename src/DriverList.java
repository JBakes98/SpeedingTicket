import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DriverList {

    private ArrayList<Driver> DriverList = new ArrayList<>();
    private int driverNum = 0;
    private String firstName, lastName, licenseNum, address;
    //private Date DOB;

    public DriverList() {
        DriverList.add(new Driver("Josh", "Baker", "testLic123", //new Date(),
                "Test address"));
        DriverList.add(new Driver("Test", "Driver", "testLic234", //new Date(),
                "Test address two"));
    }

    public void addDrivers() {
        try {
            Scanner in = new Scanner(new File("Drivers.txt"));
            while (in.hasNext()) {
                firstName = in.nextLine();
                lastName = in.nextLine();
                licenseNum = in.nextLine();
               // DOB = new Date();
                address = in.nextLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No drivers have been registered");
        }
    }

    public Driver getFirstDriver() {
        if (driverNum == 0) {
            JOptionPane.showMessageDialog(null, "This is the first driver");
        }
        driverNum = 0;
        return DriverList.get(driverNum);
    }

    public Driver getLastDriver()
    {
        if(driverNum == DriverList.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "This is the last driver");
        }
        driverNum = DriverList.size() - 1;
        return DriverList.get(driverNum);
    }

    public Driver getNextDriver()
    {
        if (driverNum < DriverList.size() - 1)
        {
            driverNum ++;
        }
        else if (driverNum == DriverList.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "Ths it the last driver");
        }

        return DriverList.get(driverNum);
    }

    public Driver getPrevDriver()
    {
        if (driverNum > 0)
        {
            driverNum --;
        }
        else if (driverNum == 0)
        {
            JOptionPane.showMessageDialog(null, "This is the first driver");
        }
        return DriverList.get(driverNum);
    }
}