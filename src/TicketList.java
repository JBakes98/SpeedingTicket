import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Joshua Baker (s5063379)
 * 19/04/18
 * Assignment Program
 * TicketList
 * This class is dedicated to the TicketList
 * ArrayList. This class contains the methods
 * to add the tickets to the array and the methods
 * to get the tickets from the array when needed.
 * It then returns that ticket for use in another 
 * class. 
 */

public class TicketList 
{
	private ArrayList<Ticket> TicketList = new ArrayList<>();
	private int ticketNum = 0;
	private String driverReg, ticket, speedLimit, speedOver;
	

	/**
	 * This method adds some tickets to the arrayList so there is always 
	 * tickets in the array.
	 */
	public TicketList()
	{
		TicketList.add(new Ticket("HardTest1 ", "30 ", "21 ", "The driver is disqualified and recieves a �1000 fine."));
		TicketList.add(new Ticket("HardTest2 ", "70 ", "2 ", "The driver will recieve a warning with no fine"));
	}

	/**
	 * This method adds the tickets from the SpeedintTicket.txt file.
	 * The method first checks that the scanner has something to scan 
	 * through a try catch loop.If it doesn't then it displays a dialog 
	 * box informing the user  no tickets have yet been saved to the file.
	 * If there are tickets in the file then it goes through each line 
	 * declaring it to a variable. The variables are then added to the 
	 * TicketList array as a ticket object.
	 */
	public void addTickets()
	{
		try 
		{
			Scanner in = new Scanner(new File("SpeedingTicket.txt"));
			while (in.hasNext())
			{
				driverReg = in.nextLine();
				speedLimit = in.nextLine();
				speedOver = in.nextLine();
				ticket = in.nextLine();
				TicketList.add(new Ticket(driverReg, speedLimit, speedOver, ticket));
			}
		} 
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "No tickets have yet been created");
		}
	}

	/**
	 * This method is used to return the first ticket from the <code>TicketList</code>  
	 * array. The method checks that the ticketNum variable is not equal to 
	 * 0. If it is then a dialog box displays informing the user they are
	 * already looking at the first ticket. If it isn't then sets the value 
	 * of <code>ticketNum</code>  to 0 and displays the first ticket from the array.
	 * 	  
	 * @return TicketList(ticketNum) This method returns the index of the 
	 * TicketList array at the value of the ticketNum variable.
	 */
	public Ticket getFirstTicket()
	{
		if (ticketNum == 0)
		{
			JOptionPane.showMessageDialog(null, "This is the first ticket");
		}
		ticketNum = 0;
		return TicketList.get(ticketNum);
	}

	/**
	 * This method is used to returns the last ticket from the <code>TicketList</code> 
	 * array. The method checks that the <code>ticketNum</code> variable is not equal to 
	 * the size of TicketList -1. If it is then a dialog box displays 
	 * informing the user they are already looking at the last ticket. If 
	 * it isn't then sets the value of <code>ticketNum</code>  to 0 and displays the last
	 * ticket from the array.
	 * 
	 * @return TicketList(ticketNum) This method returns the index of the 
	 * TicketList array at the value of the <code>ticketNum</code>  variable.
	 */
	public Ticket getLastTicket()
	{
		if (ticketNum == TicketList.size() - 1)
		{
			JOptionPane.showMessageDialog(null, "This is the last ticket");
		}
		ticketNum = TicketList.size() - 1;
		return TicketList.get(ticketNum);
	}

	/**
	 * This method is used to returns the next ticket from the <code>TicketList</code> 
	 * array. The method checks that the <code>ticketNum</code> variable is not below  
	 * the size of TicketList -1. If it is then it adds 1 to <code>ticketNum</code> 
	 * dialog box displays informing the user they are already looking at the last 
	 * ticket. If it isn't then sets the value of ticketNum to 0 and displays the last
	 * ticket from the array.
	 * 
	 * @return TicketList(ticketNum) This method returns the index of the 
	 * TicketList array at the value of the <code>ticketNum</code> variable.
	 */

	public Ticket getNextTicket()
	{
		if (ticketNum < TicketList.size() - 1)
		{
			ticketNum ++;
		}
		else if (ticketNum == TicketList.size() - 1)
		{
			JOptionPane.showMessageDialog(null, "This is the last ticket");
		}

		return TicketList.get(ticketNum);
	}

	/**
	 * This method is used to returns the previous ticket from the <code>TicketList</code> 
	 * array. The method checks that the <code>ticketNum</code> variable is above 0  
	 * If it is then it takes 1 away from <code>ticketNum</code>. If it equals 0 then a
	 * dialog box displays informing the user they are already looking at the first
	 * ticket. 
	 * 
	 * @return TicketList(ticketNum) This method returns the index of the 
	 * TicketList array at the value of the <code>ticketNum</code> variable.
	 */
	public Ticket getPrevTicket()
	{
		if (ticketNum > 0)
		{
			ticketNum --;
		}
		else if (ticketNum == 0)
		{
			JOptionPane.showMessageDialog(null, "This is the first ticket");
		}

		return TicketList.get(ticketNum);
	}
}
