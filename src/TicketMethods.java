import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Joshua Baker (s5063379)
 * 19/04/18
 * Assignment Program
 * TicketMethods
 * This class is dedicated to the methods used
 * throughout the program. For example it contains
 * the methods to calculate the speedOver and ticket 
 * variables. It also contains the methods used to 
 * the tickets and letters to files. This class contains
 * both get and set methods. The get methods are used to
 * return variables such as the ticket and speedOver which
 * are then used in another class. The set methods are used
 * to set the value of variables to what the user entered into 
 * the GUI. It also sets the value of the saveSpeedDriven
 * to the string value of speedDriven for use in other 
 * classes. 
 */

public class TicketMethods 
{
	
	private int speedLimit, speedDriven, speedOver;
	private String ticket, driverReg, saveSpeedLimit;

/**
 * This method calculates how much over the speed limit the driver was. It does
 * this by using the speedDriven and speedLimit variables. It then saves the result 
 * to the speedOver variable for later use
 */
	public void speedOver()
	{
		speedOver = speedDriven - speedLimit;
	}

	/**
	 * This is the method that works out what ticket should be given to
	 * the driver. It does this by taking the speedOver variable which is determined 
	 * from the speedOver method. It then runs it through several if else statements.
	 * The one that matches the value of speedOver is then used to determine the value 
	 * of the ticket variable.
	 */
	public void ticketCalc()
	{
		if (speedOver >= 20)
		{
			ticket = "The driver is disqualified and recieves a �1000 fine.";	
		}

		else if (speedOver >= 15 )
		{
			ticket = "The driver recieves 3 points to their license and a �150 fine.";
		}

		else if (speedOver >= 11)
		{
			ticket = "The driver will recieve a �100 fine";
		}

		else if (speedOver >= 6)
		{
			ticket = "The driver will recieve a �50 fine";
		}

		else if (speedOver <= 5)
		{
			ticket = "The driver will recieve a warning with no fine";
		}

		else if (speedOver < 0)
		{
			ticket = "The driver was not speeding no ticket is issued.";
		}
	}

	/**
	 * This method uses a buffered file writer to create a new .txt file for the letter of notice. 
	 * The method uses the driver registration entered by the user in the title of the document.
	 * It calculates if the speedOver is high enough to require a letter. If it is below 5 
	 * it doesn't as the driver doesn't get a ticket and the user gets a message to inform them
	 * however if it is over 5 then it does, whilst checking if its over 20. This is because it
	 * writes different text if its over 20. The method then gives a message to the user to inform
	 * it has created the text file. 
	 * 
	 * @throws IOException throws exception in the event isnt found
	 */
	public void writeLetterOfNotice() throws IOException
	{
		//Creates file and buffered writers.
		FileWriter fw = new FileWriter(driverReg + " Fine Letter.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		//Writes this letter if driver broke the limit by 20
		if (speedOver >= 20)
		{
			bw.write(driverReg + "Letter of Notice");
			bw.newLine();
			bw.write("Mr - Mrs, This letter has been sent to you as you have been caught speeding");
			bw.newLine();
			bw.write("in the car with the registration " + driverReg + " If this was not you then you must send");
			bw.newLine();
			bw.write("proof to the address DVLA, Swansea, SH8 8AB. Please find below your ticket:");
			bw.newLine();
			bw.write(ticket);
			bw.newLine();
			bw.write("Due to the high speed you were driving the punishment is the disqualification of your");
			bw.newLine();
			bw.write("license. You have 1 month to contend this measure and to pay the given fine.");
			bw.newLine();
			bw.write("If you drive after this then you will be prosecuted for driving without a valid license");
			//Creates a dialog box to inform the user the file had been created.
			JOptionPane.showMessageDialog(null, "The ticket has now been saved and the fine letter created");
		}

		else if (speedOver > 5)
		{
			bw.write(driverReg + " Letter of Notice");
			bw.newLine();
			bw.write("Mr - Mrs, This letter is being written to you today as you have been caught ");
			bw.newLine();
			bw.write("speeding in the car with the registration " + driverReg + " If this was not you");
			bw.newLine();
			bw.write("then you must inform us with proof at the address of DVLA, Swansea, SH8 8AB.");
			bw.newLine();
			bw.write("Please find below your ticket and your fine, failure to pay this within 1 month will");
			bw.newLine();
			bw.write("result in further action being taken against you.");
			bw.newLine();
			bw.write(ticket);
			//Creates a dialog box to inform the user the letter has been saved
			JOptionPane.showMessageDialog(null, "The ticket has now been saved and the fine letter created");
		}

		else 
		{
			//Shows a dialog box to say that a letter was not produced as no ticket was given
			JOptionPane.showMessageDialog(null, "A letter cannot be produced as not ticket was given");
		}
		bw.close();
	}

	/**
	 * This method takes the information that was entered from the user on the GUI and writes it to the file speeding 
	 * ticket. It does this by first using a file writer to create the file in case it isn't present on the users computer
	 * and then uses a buffered writer to write to it. The method saves the variables driverReg, speedOver and ticket.
	 * However the method first checks that the variable speedOver is higher than 6. If it isn't then the method doesn't 
	 * save and informs the user through a message it didn't save as the driver only received a warning not a ticket.
	 * It also checks that the speedOver is higher than 0, if it is not then it informs the user that it wont save 
	 * as the driver did not break the speed limit. 
	 * 
	 * @throws IOException throws exception in the event isnt found
	 */
	public void writeFile() throws IOException
	{
		//Initialised file and buffered writer.
		FileWriter fw = new FileWriter("SpeedingTicket.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		//Checks that the driver recieves a ticket before saving to file
		if (speedOver > 6)
		{
			try 
			{
				//Writes driver information to file
				bw.write(driverReg);	
				bw.newLine();
				bw.write(String.valueOf(speedLimit));
				bw.newLine();
				bw.write(String.valueOf(speedOver));
				bw.newLine();
				bw.write(ticket);
				bw.newLine();
			} 
			catch (IOException e) 
			{
				//Shows dialog box informing user the ticket file is not found
				JOptionPane.showMessageDialog(null, "File cannot be found");
			}
		}
		//Shows dialog box to inform user it wont be saved as the driver only received a warning
		else if (speedOver > 0)
		{
			JOptionPane.showMessageDialog(null, "This will not be saved as the driver recieves a warning");
		}
		//Shows dialog box to inform user it wont be saved as the driver didnt break the speed limit
		else 
		{
			JOptionPane.showMessageDialog(null, "This will not be saved as the driver did not speed");
		}
		bw.close();
	}

	/**
	 * This method returns the variable speedOver for later use in another class.
	 * 
	 * @return speedOver for use in SpeedingTicketGUI class
	 */
	public int getSpeedOver()
	{
		return speedOver;
	}

	/**
	 * This method returns the variable ticket for later use in another class.
	 * 
	 * @return ticket for use in SpeedingTicketGUI class
	 */
	public String getTicket()
	{
		return ticket;
	}

	/**
	 * This method sets the value of speedDriven as guiSpeed which is determined from
	 * the user using the SpeedingTicketGUI class.
	 * 
	 * @param guiSpeed used to set the value of speedDriven
	 */
	public void setSpeed(int guiSpeed)
	{
		speedDriven = guiSpeed;
	}

	/**
	 * This method sets the value of speedLimit as guiSpeed which is determined from
	 * the user using the SpeedingTicketGUI class.
	 * 
	 * @param guiLimit used to set the value of speedLimit
	 */
	public void setLimit(int guiLimit)
	{
		speedLimit = guiLimit;
	}

	/**
	 * This method sets the value of driverReg as guiSpeed which is determined from
	 * the user using the SpeedingTicketGUI class.
	 * 
	 * @param guiReg used to set the value of driverReg 
	 */
	public void setReg(String guiReg)
	{
		driverReg = guiReg;
	}

	/**
	 * This method changes the value of saveSpeedLimit to string
	 * for use in other methods.
	 */
	public void speedLimitToString() 
	{
		saveSpeedLimit.substring(speedLimit);
	}
}
