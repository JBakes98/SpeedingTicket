import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class DriverMethods {

    private String firstName, lastName, licenseNum;
    private Date DOB;
    private String address;


    public void writeFile() throws IOException {
        //Initialised file and buffered writer.
        FileWriter fw = new FileWriter("Drivers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        //Checks that the driver recieves a ticket before saving to file

        try {
            //Writes driver information to file
            bw.write(firstName);
            bw.newLine();
            bw.write(lastName);
            bw.newLine();
            bw.write(licenseNum);
            bw.newLine();
            bw.write(address);
            bw.newLine();
        } catch (IOException e) {
            //Shows dialog box informing user the ticket file is not found
            JOptionPane.showMessageDialog(null, "File cannot be found");
        }

        //Shows dialog box to inform user it wont be saved as the driver only received a warning
        bw.close();
    }
}

