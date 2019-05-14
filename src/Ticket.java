/**
 * @author Joshua Baker (s5063379)
 * 19/04/18
 * Assignment Program
 * SpeedingTicketGUI
 * This class is dedicated to creating the Ticket
 * object. The class contains the constructor for 
 * the tickets and get methods to get certain 
 * elements from the ticket object for use in other 
 * classes.
 */

public class Ticket 
{
	private String driverReg, ticket, speedOver,  speedLimit;

	/**
	 * Constructor used to create the <code>Ticket</code> object. It 
	 * has 4 parameters which are used by the object. The method sets 
	 * the value of the parameters to their respective variables
	 * 
	 * @param driverReg Registration of car
	 * @param speedLimit Speed limit of area
	 * @param speedOver Speed over the limit the driver was
	 * @param ticket Ticket that was given
	 */
	public Ticket(String driverReg, String speedLimit, String speedOver, String ticket)
	{
		this.driverReg = driverReg;
		this.speedLimit = speedLimit;
		this.speedOver = speedOver;
		this.ticket = ticket;
	}

	/**
	 * Method that returns the driver registration from the 
	 *<code>Ticket</code>.
	 *	 
	 * @return driverReg for use in other classes
	 */
	public String getDriverReg()
	{
		return driverReg;
	}

	/**
	 * Method that returns the speedLimit from the 
	 *<code>Ticket</code>.
	 * 
	 * @return speedLimit for use in other classes
	 */
	public String getSpeedLimit()
	{
		return speedLimit;
	}

	/**
	 * Method that returns the speed over from the 
	 *<code>Ticket</code>.
	 * 
	 * @return speedOver for use in other classes
	 */
	public String getSpeedOver()
	{
		return speedOver;
	}

	/**
	 *Method that returns the ticket from the 
	 *<code>Ticket</code>.
	 * 
	 * @return ticket for use in other classes
	 */
	public String getTicket()
	{
		return ticket;
	}

}
