import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Joshua Baker (s5063379)
 * 19/04/18
 * Assignment Program
 * SpeedingTicketGUI
 * This class is dedicated to creating the GUI for 
 * the program. It creates all GUI elements and calls 
 * methods from other classes when needed. It also 
 * contains all of the action listeners for all 
 * of the buttons on the GUI. It also sets the value of
 * certain variables to what the user inputs into the GUI. 
 */

public class SpeedingTicketGUI 
{
	private JPanel createTicketPanel, menuPanel, browsePanel, driversPanel, vehiclesPanel;
	private JFrame createTicketFrame, menuFrame, browseFrame, driversFrame, vehiclesFrame;

	//Menu labels
	private JLabel lblMenuTitle, lblMenuTxt;
	//Menu buttons
	private JButton btnOpenTickets, btnNewTicket, btnExit, btnOpenDrivers;

	//New ticket txtfields
	private JTextField txtDriverReg;
	//New ticket label
	private JLabel lblTicket, lblMainTitle, lblSpeedLmt, lblDriverSpd, lblSpeedOver, lblDriverReg;
	/**
	 * These are the spinner models used to create the spinners
	 * used on the createTicketPanel.
	 */
	private SpinnerModel drivingSpeedModel = new SpinnerNumberModel(50, 0, 150, 1);
	private SpinnerModel speedLimitModel = new SpinnerNumberModel(30, 0, 70, 1);
	//New ticket buttons
	private JButton btnHome, btnMainExit, btnCreateTicket, btnSaveTicket, btnBrowseTickets;

	//Ticket browser labels
	private JLabel lblBrowseTitle, lblDisplaySpeedOvr, lblDisplaySpeedLimit, lblDisplayReg, lblDisplayTicket;
	//Ticket browser buttons
	private JButton btnBrowseFirst, btnBrowseLast, btnBrowseNxt, btnBrowsePrev, btnBrowseExit, btnBrowseCrtTick;

	//Driver browser labels
	private  JLabel lblDriversTitle, lblDisplayFirstName, lblDisplayLastName, lblDisplayLicense, lblDisplayDOB;
	//Driver browser buttons
	private  JButton btnFirstDriver, btnLastDriver, btnNextDriver, btnPreDriver;

	//GUI variables
	private int guiSpeed, guiLimit;
	private String guiReg;

	//Other class objects
	private TicketList ticket = new TicketList();
	private  DriverList driver = new DriverList();
	private Ticket currentTicket;
	private Driver currentDriver;
	private TicketMethods logic = new TicketMethods();
	private TicketList displayTicket = new TicketList();
	private  DriverList displayDriver = new DriverList();

	//Grid bag constraints variable
	private GridBagConstraints gbc = new GridBagConstraints();

	/**
	 * Runs all of the methods within the class to create the 
	 * GUI.
	 */
	public SpeedingTicketGUI()
	{
		createForm();

		//Creates form labels
		createTicketLabels();
		menuLabels();
		browseLabels();

		//Creates form text fields
		createTicketTxtField();

		//Creates form buttons
		menuBtns();
		createTicketBtns();
		browseBtns();

		//Creates form spinners
		createSpinners();

		//Adds panels to their frames
		menuFrame.add(menuPanel);
		createTicketFrame.add(createTicketPanel);
		browseFrame.add(browsePanel);
		driversFrame.add(driversPanel);

		//Sets visibility of frames
		menuFrame.setVisible(true);
		createTicketFrame.setVisible(false);
		browseFrame.setVisible(false);
		driversFrame.setVisible(false);
	}

	/**
	 * This method is used to set the labels on the browsePanel to the value of 
	 * the current ticket that is selected from the arrayList from the class 
	 * TicketList. It does this by using the get methods from the class Ticket
	 * to get the relevant data for each label.
	 */
	public void setLabels()
	{
		//Sets labels to the relevant ticket info
		lblDisplaySpeedOvr.setText("Speed over limit: " + currentTicket.getSpeedOver());
		lblDisplaySpeedLimit.setText("Area speed limit: " + currentTicket.getSpeedLimit());
		lblDisplayReg.setText("Driver registration: " + currentTicket.getDriverReg());
		lblDisplayTicket.setText("Ticket: " + currentTicket.getTicket());
	}

	/**
	 * This method creates the form for the GUI. The method creates
	 * three frames, one for each panel that is used within the program.
	 * The method sets the title of the frames, the size of each frame, 
	 * the default close operation and if the frame is visible. It also 
	 * sets the background of the panels to a pre determined RGB colour.
	 */
	public void createForm()
	{
		//Determines colour using RGB
		Color backColour = new Color(197, 215, 218);

		//Creates forms and panels
		menuFrame = new JFrame("Border layour");
		menuFrame.setTitle("Speeding Ticket");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(500, 600);
		menuFrame.setVisible(true);

		createTicketFrame = new JFrame();
		createTicketFrame.setTitle("Speeding Ticket");
		createTicketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createTicketFrame.setSize(500, 600);
		createTicketFrame.setVisible(false);

		browseFrame = new JFrame();
		browseFrame.setTitle("Speeding Ticket");
		browseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		browseFrame.setSize(500, 600);
		browseFrame.setVisible(false);

		driversFrame = new JFrame();
		driversFrame.setTitle("Speeding Ticket");
		driversFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		driversFrame.setSize(500, 600);
		driversFrame.setVisible(false);

		menuPanel = new JPanel();
		menuPanel.setBackground(backColour);
		menuPanel.setLayout(new GridBagLayout());

		createTicketPanel = new JPanel();
		createTicketPanel.setBackground(backColour);
		createTicketPanel.setLayout(new GridBagLayout());

		browsePanel = new JPanel();
		browsePanel.setBackground(backColour);
		browsePanel.setLayout(new GridBagLayout());

		driversPanel = new JPanel();
		driversPanel.setBackground(backColour);
		driversPanel.setLayout(new GridBagLayout());
	}

	/**
	 * This method adds the buttons to the menuPanel. The method 
	 * defines the grid bag cordinates that each button should appear
	 * along with other properties. It also sets the text that should 
	 * appear on the buttons and what action listeners the buttons should
	 * use.
	 */

	public void menuBtns()
	{
		//Sets grid bad constraints insets
		gbc.insets = new Insets( 5, 5, 5, 5);

//		btnOpenTickets = new JButton("View Tickets");
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//		gbc.anchor = GridBagConstraints.NORTHWEST;
//		gbc.weightx = 1;
//		gbc.weighty = 1;
//		gbc.fill = GridBagConstraints.BOTH;
//		btnOpenTickets.addActionListener(new openTicketBrowse());
//		menuPanel.add(btnOpenTickets, gbc);

//		btnOpenDrivers = new JButton("Open Drivers");
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//		gbc.anchor = GridBagConstraints.NORTHWEST;
//		gbc.weightx = 1;
//		gbc.weighty = 1;
//		gbc.fill = GridBagConstraints.BOTH;
//		btnOpenTickets.addActionListener(new openDriverBrowse());
//		menuPanel.add(btnOpenDrivers, gbc);

		btnNewTicket = new JButton("Create Tickets");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnNewTicket.addActionListener(new openTicketEnter());
		menuPanel.add(btnNewTicket, gbc);

		btnExit = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnExit.addActionListener(new exitBtnHandler());
		menuPanel.add(btnExit, gbc);
	}

	/**
	 * This is the method that creates the labels for the <code>menuPanel</code>.
	 * The method also declares a font to be used by one of the labels 
	 * whilst the other label uses pre-defined HTML text created in the 
	 * method. The elements are then placed onto the panel using the grid 
	 * bag layout.
	 */
	public void menuLabels()
	{
		//Sets grid bag contraints insets.
		gbc.insets = new Insets(5, 5, 5, 5);

		//Set fonts
		Font title = new Font ("Comic Sans MS", Font.BOLD, 20);

		//Creates border to be used on lblLoginTitle
		Border lblOutline = BorderFactory.createLineBorder(Color.BLACK, 2);

		//HTML text to be used for lblMenuTxt
		String lblText = 
				"<html>Welcome to the speeding ticket software" + 
						"<p>" +
						"<p>" +
						"This software has two main functions viewing " + 
						"and creating speeding tickets. On the left of the " + 
						"screen you will see two buttons, one will allow you " +
						" to view exsisting tickets whilst the other will " + 
						" allow you to create more and save them to the system." +
						"</p></html>";

		//Start of labels for login screen
		lblMenuTitle = new JLabel ("Speeding Ticket System Menu", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		lblMenuTitle.setFont(title);
		lblMenuTitle.setBorder(lblOutline);;
		menuPanel.add(lblMenuTitle, gbc);

		lblMenuTxt = new JLabel ("<html><div style='text-align: center;'>" + lblText + "</div></html>");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		menuPanel.add(lblMenuTxt, gbc);	
	}

	/**
	 * This method creates the labels for the <code>createTicketPanel</code> and declares two
	 * fonts and a border. There are six labels created each of these use one of 
	 * the fonts created and <code>lblMainTitle</code> uses the border. The method declares the
	 * position of the labels and the size they should be along with what text text 
	 * they display.
	 */
	public void createTicketLabels()
	{
		//Creates fonts to be used by labels
		Font title = new Font ("Comic Sans MS", Font.BOLD, 20);
		Font label = new Font ("Comic Sans MS", Font.BOLD, 14);

		//Creates border to be used by lblMainTitle
		Border lblOutline = BorderFactory.createLineBorder(Color.BLACK, 2);

		//Start of labels for main screen
		lblMainTitle = new JLabel("Create New Speeding Ticket", SwingConstants.CENTER);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		lblMainTitle.setFont(title);
		lblMainTitle.setBorder(lblOutline);
		createTicketPanel.add(lblMainTitle, gbc);

		lblSpeedLmt = new JLabel("Area Speed Limit: ");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		lblSpeedLmt.setFont(label);
		createTicketPanel.add(lblSpeedLmt, gbc);

		lblDriverSpd = new JLabel("Drivers Speed: ");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		lblDriverSpd.setFont(label); 
		createTicketPanel.add(lblDriverSpd, gbc);

		lblDriverReg = new JLabel("Drivers Registration: ");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		lblDriverReg.setFont(label);
		createTicketPanel.add(lblDriverReg, gbc);

		lblSpeedOver = new JLabel("Placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		lblSpeedOver.setFont(label);
		lblSpeedOver.setBorder(lblOutline);
		createTicketPanel.add(lblSpeedOver, gbc);

		lblTicket = new JLabel("Ticket result placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		lblTicket.setFont(label);
		lblTicket.setBorder(lblOutline);
		createTicketPanel.add(lblTicket, gbc);
	}

	/**
	 * This method creates the text field for the createTicketPanel.
	 * It also sets the position using the grid bag layout.
	 * The cordinites determine where it should appear and what size 
	 * the text field should be.
	 */
	public void createTicketTxtField()
	{
		//Text fields for main panel
		txtDriverReg = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		createTicketPanel.add(txtDriverReg, gbc);
	}

	/**
	 * This method creates the spinners used for the createTicketPanel.
	 * The method sets the position of the spinner and the size that it
	 * should be through the grid bag layout. It also states what spinner model each spinner should 
	 * use, these are declared elsewhere.
	 */
	public void createSpinners()
	{
		//Creates spinners for createTicketPanel
		JSpinner spinSpeedDriven = new JSpinner(drivingSpeedModel);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		createTicketPanel.add(spinSpeedDriven, gbc);

		JSpinner spinSpeedLmt = new JSpinner(speedLimitModel);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		createTicketPanel.add(spinSpeedLmt, gbc);
	}

	/**
	 * This is the method that creates the buttons for the createTicketPanel.
	 * This method adds the four buttons and sets the position each button 
	 * should be in respectively. It also adds all of the button action listeners.
	 */
	public void createTicketBtns()
	{
		//Buttons used on main panel
		btnCreateTicket = new JButton("Generate ticket");
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnCreateTicket.addActionListener(new createTicketBtnHandler());
		createTicketPanel.add(btnCreateTicket,gbc);

		btnSaveTicket = new JButton("Save ticket");
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnSaveTicket.addActionListener(new saveTicketBtnHandler());
		createTicketPanel.add(btnSaveTicket,gbc);

		btnMainExit = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnMainExit.addActionListener(new exitBtnHandler());
		createTicketPanel.add(btnMainExit, gbc);

		btnBrowseTickets = new JButton("View Tickets");
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseTickets.addActionListener(new openTicketBrowse());
		createTicketPanel.add(btnBrowseTickets, gbc);

		btnHome = new JButton("Home");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		btnHome .addActionListener(new goHome());
		createTicketPanel.add(btnHome, gbc);
	}

	/**
	 * This method creates the labels for the browsePanel. This method 
	 * creates five labels and two fonts for the labels to use. The method 
	 * declares what the labels should display and what their position and 
	 * size should be. The two fonts are used by the labels declared in the 
	 * method.
	 */
	public void browseLabels() 
	{
		//Creates fonts to be used by labels
		Font title = new Font ("Comic Sans MS", Font.BOLD, 20);
		Font label = new Font ("Comic Sans MS", Font.BOLD, 12);

		//Creates border to be used for lblBrowseTitle
		Border lblOutline = BorderFactory.createLineBorder(Color.BLACK, 2);

		//Labels for browsePanel
		lblBrowseTitle = new JLabel("Saved Tickets", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.anchor =  GridBagConstraints.LAST_LINE_END;
		gbc.fill = GridBagConstraints.BOTH;
		lblBrowseTitle.setFont(title);
		lblBrowseTitle.setBorder(lblOutline);
		browsePanel.add(lblBrowseTitle, gbc);

		lblDisplayReg = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplayReg.setFont(label);
		browsePanel.add(lblDisplayReg, gbc);

		lblDisplaySpeedLimit = new JLabel("PlaceHolder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplaySpeedLimit.setFont(label);
		browsePanel.add(lblDisplaySpeedLimit, gbc);

		lblDisplaySpeedOvr = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplaySpeedOvr.setFont(label);
		browsePanel.add(lblDisplaySpeedOvr, gbc);

		lblDisplayTicket = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplayTicket.setFont(label);
		browsePanel.add(lblDisplayTicket, gbc);		
	}

	/**
	 * This is the method that creates the buttons for the browsePanel.
	 * This method creates the six buttons and sets where on the panel 
	 * each should be placed. It also adds the action listener to all 
	 * of the buttons.
	 */
	public void browseBtns()
	{
		//Sets the grid bag layout insets
		gbc.insets = new Insets( 5, 5, 5, 5);

		//Buttons used on browsePanel
		btnBrowseFirst = new JButton("First Ticket");
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseFirst.addActionListener(new viewFirstTicket());
		browsePanel.add(btnBrowseFirst, gbc);

		btnBrowseLast = new JButton("Last Ticket");
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseLast.addActionListener(new viewLastTicket());
		browsePanel.add(btnBrowseLast, gbc);

		btnBrowseNxt = new JButton("Next Ticket");
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseNxt.addActionListener(new viewNextTicket());
		browsePanel.add(btnBrowseNxt, gbc);

		btnBrowsePrev = new JButton("Prev Ticket");
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowsePrev.addActionListener(new viewPrevTicket());
		browsePanel.add(btnBrowsePrev,gbc);

		btnBrowseExit = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseExit.addActionListener(new exitBtnHandler());
		browsePanel.add(btnBrowseExit, gbc);

		btnBrowseCrtTick = new JButton("Create Ticket");
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseCrtTick.addActionListener(new openTicketEnter());
		browsePanel.add(btnBrowseCrtTick, gbc);
	}

	/**
	 * Creates the labels for the driver panel.
	 **/
	public void driverLabels()
	{
		//Creates fonts to be used by labels
		Font title = new Font ("Comic Sans MS", Font.BOLD, 20);
		Font label = new Font ("Comic Sans MS", Font.BOLD, 12);

		//Creates border to be used for lblBrowseTitle
		Border lblOutline = BorderFactory.createLineBorder(Color.BLACK, 2);

		//Labels for browsePanel
		lblDriversTitle = new JLabel("Saved Drivers", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.anchor =  GridBagConstraints.LAST_LINE_END;
		gbc.fill = GridBagConstraints.BOTH;
		lblDriversTitle.setFont(title);
		lblDriversTitle.setBorder(lblOutline);
		driversPanel.add(lblDriversTitle, gbc);

		lblDisplayFirstName = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplayFirstName.setFont(label);
		driversPanel.add(lblDisplayFirstName, gbc);

		lblDisplayLastName = new JLabel("PlaceHolder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplaySpeedLimit.setFont(label);
		driversPanel.add(lblDisplayLastName, gbc);

		lblDisplayDOB = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplayDOB.setFont(label);
		driversPanel.add(lblDisplayDOB, gbc);

		lblDisplayLicense = new JLabel("placeholder", SwingConstants.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		lblDisplayLicense.setFont(label);
		driversPanel.add(lblDisplayLicense, gbc);
	}

	/**
	 * This is the method that creates the buttons for the browsePanel.
	 * This method creates the six buttons and sets where on the panel
	 * each should be placed. It also adds the action listener to all
	 * of the buttons.
	 */
	public void driverBtns()
	{
		//Sets the grid bag layout insets
		gbc.insets = new Insets( 5, 5, 5, 5);

		//Buttons used on browsePanel
		btnFirstDriver = new JButton("First Driver");
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnFirstDriver.addActionListener(new viewFirstDriver());
		driversPanel.add(btnFirstDriver, gbc);

		btnLastDriver = new JButton("Last Driver");
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnLastDriver.addActionListener(new viewLastDriver());
		driversPanel.add(btnLastDriver, gbc);

		btnNextDriver = new JButton("Next Driver");
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnNextDriver.addActionListener(new viewNextDriver());
		driversPanel.add(btnNextDriver, gbc);

		btnPreDriver = new JButton("Prev Driver");
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnPreDriver.addActionListener(new viewPrevDriver());
		driversPanel.add(btnPreDriver,gbc);

		btnBrowseExit = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		btnBrowseExit.addActionListener(new exitBtnHandler());
		browsePanel.add(btnBrowseExit, gbc);


	}

	class exitBtnHandler implements ActionListener
	{
		/**
		 * This method is used by the exitBtnHandler class. This method 
		 * is used for the exit buttons used throughout the program. The 
		 * method works by first showing an option box to the user 
		 * and asking if they are sure they would like to exit. If the 
		 * user selects yes then the program ends.
		 * 
		 * @see ActionListener#actionPerformed(ActionEvent)
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Creates dialog box asking user if they are sure they want to exit
			int n = JOptionPane.showConfirmDialog(menuFrame, "Are you sure you would like to exit?",
					"Exit", JOptionPane.YES_NO_OPTION);

			//Closes program if user selects yes
			if (n == JOptionPane.YES_NO_OPTION)
			{
				System.exit(0);
			}
		}
	}

	class createTicketBtnHandler implements ActionListener
	{
		/**
		 * This method is used by the creatTicketBtn. The method
		 * works by setting the value of three variables with data
		 * the user enters into the respective object. The program
		 * then checks that the user has entered a value into the
		 * Variable guiReg. If they havent then the program creates
		 * a dialog box informing the user they must enter a registration.
		 * If they have entered a registration then it runs the three
		 * set methods from the TicketMethods class. It then runs the
		 * speedOver and ticketCalc methods from TicketMethods class as
		 * well. Once this is done it then sets the labels lblTicket and
		 * lblSpeedOver to the value of the getTicket and string value of
		 * getSpeedOver from the TicketMethods class.
		 *
		 * @see ActionListener#actionPerformed(ActionEvent)
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Sets the value of guiSpeed & guiLimit to the values of the spinners
			guiSpeed = (Integer) drivingSpeedModel.getValue();
			guiLimit = (Integer) speedLimitModel.getValue();
			//Sets the value of guiReg from txtDriverReg
			guiReg = txtDriverReg.getText();
			//Checks to see guiReg has a value and is not empty shows error is so
			if (guiReg.equals(""))
			{
				JOptionPane.showMessageDialog(createTicketFrame, "Please enter the driver reg", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//Runs set methods from TicketMethods class to set the three variables
				logic.setSpeed(guiSpeed);
				logic.setLimit(guiLimit);
				logic.setReg(guiReg);

				//Runs methods from TicketMethods to calculate speedOver and the ticket
				logic.speedOver();
				logic.ticketCalc();

				//Sets the value of lblTicket to ticket through the getTicket method and the lblSpeedOver through getSpeedOver
				lblTicket.setText(logic.getTicket());
				lblSpeedOver.setText("The driver broke the speed limit by: " + String.valueOf(logic.getSpeedOver()));
			}
		}
	}

	class saveTicketBtnHandler implements ActionListener
	{
		/**
		 * This method is used by the saveTicketBtn. The method
		 * works by first setting the value of three variables 
		 * from the three objects on the GUI, the values will
		 * be determined by the user interacting with the GUI.
		 * The method then checks the guiReg variable has 
		 * a value. If it doesnt then it creates a dialog box to
		 * the user they must enter a registration. If the user 
		 * had entered a registration then the method runs the 
		 * writeFile and writeLetterOfNotice from the TicketMethods
		 * class. This is all surrounded by a try catch statement. The 
		 * method catches the exception and creates a dialog box 
		 * informing the user that the file cannot be found to 
		 * save the ticket to.
		 * 
		 * @throws IOException e throws exceptions in case writeFile method 
		 * cant find file.
		 */
		public void actionPerformed(ActionEvent event)
		{
			guiSpeed = (Integer) drivingSpeedModel.getValue();
			guiLimit = (Integer) speedLimitModel.getValue();
			//Sets the value of guiReg from txtDriverReg
			guiReg = txtDriverReg.getText();
			if (guiReg.equals(""))
			{
				JOptionPane.showMessageDialog(createTicketFrame, "Please enter the driver reg before saving", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					//Writes ticket to file and writes txt file for letter of notice
					logic.writeFile();
					logic.writeLetterOfNotice();
				} 
				catch (IOException e) 
				{
					//Shows message in case file cannot be found
					JOptionPane.showMessageDialog(createTicketFrame, "File cannot be found");
				}
			}
		}
	}

	class openTicketBrowse implements ActionListener
	{
		/**
		 * This is the method that is used by the btnBrowseTickets.
		 * This method sets the visibility of the menuFrame and 
		 * createTicketFrame to false whilst setting the browseFrame 
		 * to true. It then runs the addTickets, getFirstTikcet methods from the 
		 * TicketList class and the setLabels method from this class.
		 */
		public void actionPerformed(ActionEvent event)
		{
			menuFrame.setVisible(false);
			createTicketFrame.setVisible(false);
			browseFrame.setVisible(true);

			//Run addTickets, getFirstTicket methods from TicketList class sets the 
			//current ticket to the first and sets the labels for the first ticket
			displayTicket.addTickets();
			currentTicket = ticket.getFirstTicket();
			setLabels();
		}
	}

	class goHome implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			menuFrame.setVisible(true);
			createTicketFrame.setVisible(false);
			browseFrame.setVisible(false);
		}
	}

	class openTicketEnter implements ActionListener
	{
		/**
		 * This method is used by the btnBrowseCrtTick action 
		 * listener. The method sets the visibility of the 
		 * browseFrame and menuFrame to false and the 
		 * createTicketFrame to true.
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Closes the browseFrame and opens mainFrame
			browseFrame.setVisible(false);
			menuFrame.setVisible(false);
			createTicketFrame.setVisible(true);
		}
	}

	class openDriverBrowse implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			browseFrame.setVisible(false);
			menuFrame.setVisible(false);
			createTicketFrame.setVisible(false);
			driversFrame.setVisible(true);

			displayDriver.addDrivers();
			currentDriver = driver.getFirstDriver();
			setLabels();
		}
	}

	class viewFirstDriver implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			currentDriver = displayDriver.getFirstDriver();
		}
	}

	class viewLastDriver implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			currentDriver = displayDriver.getLastDriver();
		}
	}

	class viewNextDriver implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			currentDriver = displayDriver.getNextDriver();
		}
	}

	class viewPrevDriver implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			currentDriver = displayDriver.getPrevDriver();
		}
	}

	class viewFirstTicket implements ActionListener
	{
		/**
		 * This method is used by the btnBrowseFirst action
		 * listener. The method sets the value of currentTicket
		 * to the value of the method getFirstTicket from the
		 * TicketList class. It then runs the setLabels method.
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Calls the getFirstTicket method from class TicketList and updates labels
			currentTicket = displayTicket.getFirstTicket();
			setLabels();
		}
	}

	class viewLastTicket implements ActionListener
	{
		/**
		 * This method is used by the btnBrowseLast action
		 * listener. The method sets the value of currentTicket
		 * to the value of the method getLastTicket from the
		 * TicketList class. It then runs the setLabels method.
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Calls the getLastTicket method from class TicketList and updates labels
			currentTicket = displayTicket.getLastTicket();
			setLabels();
		}
	}

	class viewNextTicket implements ActionListener
	{
		/**
		 * This method is used by the btnBrowseNext action
		 * listener. The method sets the value of currentTicket
		 * to the value of the method getNextTicket from the
		 * TicketList class. It then runs the setLabels method.
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Calls the getNextTicket method from class TicketList and updates labels
			currentTicket = displayTicket.getNextTicket();
			setLabels();
		}
	}

	class viewPrevTicket implements ActionListener
	{
		/**
		 * This method is used by the btnBrowsePrev action
		 * listener. The method sets the value of currentTicket
		 * to the value of the method getPrevTicket from the
		 * TicketList class. It then runs the setLabels method.
		 */
		public void actionPerformed(ActionEvent event)
		{
			//Calls the getPrevTicket method from class TicketList and updates labels
			currentTicket = displayTicket.getPrevTicket();
			setLabels();
		}
	}

	public static void main(String[] args)
	{
		new
                SpeedingTicketGUI();
	}
}
