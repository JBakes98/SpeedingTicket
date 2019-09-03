import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class VehicleList {

    private ArrayList<Vehicle> VehicleList = new ArrayList<>();
    private int vehicleNum;
    private String model, make, reg, owner;
    private Date yearMade;

    public  VehicleList()
    {
        VehicleList.add(new Vehicle("Focus", "Ford","v126 dte","testLic123", new Date()));
        VehicleList.add(new Vehicle("720s", "Mclaren", "JB 98", "testLic123", new Date()));
        VehicleList.add(new Vehicle("XC90", "Volvo", "test", "testLic234", new Date()));
    }

    public void addVehicles()
    {
        try
        {
            Scanner in = new Scanner(new File("Vehicle.txt"));
            while(in.hasNext())
            {
                model = in.nextLine();
                make = in.nextLine();
                reg = in.nextLine();
                owner = in.nextLine();
            }
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "No drivers stored");
        }
    }

    public Vehicle getFirstVehicle()
    {
        if (vehicleNum == 0)
        {
            JOptionPane.showMessageDialog(null, "This is the first ticket");
        }
        vehicleNum = 0;
        return VehicleList.get(vehicleNum);
    }

    public Vehicle getLastVehicle()
    {
        if (vehicleNum == VehicleList.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "This is the last vehicle");
        }
        vehicleNum = VehicleList.size() - 1;
        return VehicleList.get(vehicleNum);
    }

    public Vehicle getNextVehicle()
    {
        if (vehicleNum < VehicleList.size() - 1)
        {
            vehicleNum++;
        }
        else if (vehicleNum == VehicleList.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "This is the last vehicle");
        }
        return VehicleList.get(vehicleNum);
    }

    public Vehicle getPrevVehicle()
    {
        if (vehicleNum > 0)
        {
            vehicleNum --;
        }
        else if (vehicleNum == 0)
        {
            JOptionPane.showMessageDialog(null, "This is the first vehicle");
        }
        return VehicleList.get(vehicleNum);
    }
}
