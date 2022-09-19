package Lab6.Problem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JTextField textName, textStreet, textCity, textState, textZip;
	JLabel labelName, labelStreet, labelCity, labelState, labelZip;
	JButton buttonSubmit;

	public Main() {
		PositionFrame();
		InitializeComponents();
		this.getContentPane().add(LayoutComponents());

	}

	private void InitializeComponents() {
		this.textName = new JTextField(10);
		this.textCity = new JTextField(10);
		this.textStreet = new JTextField(10);
		this.textState = new JTextField(10);
		this.textZip = new JTextField(10);

		this.labelCity = new JLabel("City");
		this.labelName = new JLabel("Name");
		this.labelState = new JLabel("State");
		this.labelStreet = new JLabel("Street");
		this.labelZip = new JLabel("Zip");

		this.buttonSubmit = new JButton("Submit");
		this.buttonSubmit.addActionListener(new MyButtonListener());
	}

	private void PositionFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = this.getSize().height;
		int frameWidth = this.getSize().width;
		this.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}

	private JPanel LayoutComponents() {
		JPanel basePanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel topLeftPanel = new JPanel();
		JPanel topMiddlePanel = new JPanel();
		JPanel topRightPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel middleLeftPanel = new JPanel();
		JPanel middleRightPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		topPanel.add(topLeftPanel);
		topPanel.add(topMiddlePanel);
		topPanel.add(topRightPanel);

		basePanel.setLayout(new BorderLayout());
		basePanel.add(topPanel, BorderLayout.NORTH);
		basePanel.add(middlePanel, BorderLayout.CENTER);
		basePanel.add(buttonPanel, BorderLayout.SOUTH);

		topLeftPanel.setLayout(new BorderLayout());
		topLeftPanel.add(labelName, BorderLayout.NORTH);
		topLeftPanel.add(textName, BorderLayout.SOUTH);
		
		topMiddlePanel.setLayout(new BorderLayout());
		topMiddlePanel.add(labelStreet, BorderLayout.NORTH);
		topMiddlePanel.add(textStreet, BorderLayout.SOUTH);

		topRightPanel.setLayout(new BorderLayout());
		topRightPanel.add(labelCity, BorderLayout.NORTH);
		topRightPanel.add(textCity, BorderLayout.SOUTH);

		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(middleLeftPanel);
		middlePanel.add(middleRightPanel);

		middleLeftPanel.setLayout(new BorderLayout());
		middleLeftPanel.add(labelState, BorderLayout.NORTH);
		middleLeftPanel.add(textState, BorderLayout.SOUTH);

		middleRightPanel.setLayout(new BorderLayout());
		middleRightPanel.add(labelZip, BorderLayout.NORTH);
		middleRightPanel.add(textZip, BorderLayout.SOUTH);

		buttonPanel.add(buttonSubmit);

		return basePanel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Main mainFrame = new Main();
				mainFrame.setTitle("Address Form");
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setVisible(true);
				mainFrame.setResizable(false);
				mainFrame.pack();
			}
		});
	}

	public class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			System.out.println(textName.getText());
			System.out.println(textStreet.getText());
			System.out.println(textCity.getText() + ", " + textState.getText() + " " + textZip.getText());
		}
	}
}
