package Lab6.Problem3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserIO extends JFrame {
	private final String MAIN_LABEL = "User Input/Output Tool";
	private final String USER_INPUT = "User Input";
	private final String OUTPUT = "Output";
	private final String SUBMIT = "Submit";
	private final String CLEAR = "Clear Screen";
	private static final long serialVersionUID = 1L;
	Employee[] emps = null;
	// text areas
	private JTextArea upperText;
	private JTextArea lowerText;

	// JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel middleSubpanel;
	private JPanel lowerSubpanel;

	// altered constructor
	public UserIO() {

		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);

		emps = new Employee[3];
		emps[0] = new Employee("Sujit", 1995, 01, 10);
		emps[1] = new Employee("Fahim", 1998, 1, 5);
		emps[2] = new Employee("Susan", 1997, 2, 13);

		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[1].createNewRetirement(9000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	

		boolean result = emps[2].withdraw(AccountType.SAVINGS, 100);
		System.out.println(result);

		// pack();

	}

	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setSize(GuiControl.SCREEN_WIDTH, GuiControl.SCREEN_HEIGHT);
		GuiControl.centerFrameOnDesktop(this);

	}

	private void defineMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(GuiControl.FILLER_COLOR);
		mainPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		defineUpperPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.add(upperSubpanel, BorderLayout.NORTH);
		mainPanel.add(middleSubpanel, BorderLayout.CENTER);
		mainPanel.add(lowerSubpanel, BorderLayout.SOUTH);

	}

	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		upperSubpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upperSubpanel.add(mainLabel);
	}

	private void defineMiddlePanel() {
		middleSubpanel = new JPanel();
		middleSubpanel.setLayout(new BorderLayout());
		middleSubpanel.setBackground(GuiControl.FILLER_COLOR);
		middleSubpanel.setBorder(GuiControl.createBlueTitledBorder(USER_INPUT, middleSubpanel.getFont()));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// define textPanel
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.setBackground(GuiControl.FILLER_COLOR);
		textPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		upperText = new JTextArea(8, 54);
		textPanel.add(upperText);
		middleSubpanel.add(textPanel, BorderLayout.NORTH);

		// define button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(GuiControl.FILLER_COLOR);
		JButton submitButn = new JButton(SUBMIT);
		SubmitListener sl = new SubmitListener();
		int y = sl.k;
		submitButn.addActionListener(sl);
		buttonPanel.add(submitButn);
		middleSubpanel.add(buttonPanel, BorderLayout.SOUTH);

	}

	private void defineLowerPanel() {
		lowerSubpanel = new JPanel();
		lowerSubpanel.setLayout(new BorderLayout());
		lowerSubpanel.setBackground(GuiControl.FILLER_COLOR);
		lowerSubpanel.setBorder(GuiControl.createBlueTitledBorder(OUTPUT, lowerSubpanel.getFont()));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// define textPanel
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.setBackground(GuiControl.OUTPUT_SCREEN);
		textPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		lowerText = new JTextArea(8, 54);
		JScrollPane scroll = new JScrollPane(lowerText);
		lowerText.setBackground(GuiControl.OUTPUT_SCREEN);
		lowerText.setEditable(false);
		textPanel.add(scroll);
		lowerSubpanel.add(textPanel, BorderLayout.NORTH);

		// define button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(GuiControl.FILLER_COLOR);
		JButton clearButn = new JButton(CLEAR);
		clearButn.addActionListener(new ClearListener());
		buttonPanel.add(clearButn);
		lowerSubpanel.add(buttonPanel, BorderLayout.SOUTH);

	}

	public void setOutputValue(String val) {
		lowerText.setText(val);
	}

	class SubmitListener implements ActionListener {
		private int k;

		public void actionPerformed(ActionEvent evt) {

			String inputString = upperText.getText();
			setOutputValue(inputString);

			if (upperText.getText().equalsIgnoreCase("y")) {
				String info = "";
				for (int i = 0; i < emps.length; i++) {
					info += emps[i].getFormattedAcctInfo();

//					System.out.println(info);
				}
				lowerText.setText(info);
			} else {
				JOptionPane.showMessageDialog(lowerSubpanel, "We will exit the system now.");
				System.exit(0);
			}
		}
	}

	class ClearListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			lowerText.setText("");
			upperText.setText("");
			setOutputValue("");
			System.out.println("Clearing output text area.");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				UserIO userIo = new UserIO();
				userIo.setVisible(true);
			}
		});
	}
}