package Lab6.Problem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton buttonCounter;
	private JButton buttonReverse;
	private JButton buttonRemoveDuplicate;
	private JTextField textInput;
	private JTextField textOutput;
	private JLabel labelInput;
	private JLabel labelOutput;

	public Main() {
		this.PositionFrame();
		this.InitializeComponents();
		this.getContentPane().add(LayoutComponents());
	}

	private void InitializeComponents() {
		buttonCounter = new JButton("Count Letters");
		buttonCounter.addActionListener(new ListenerCounter());
		buttonReverse = new JButton("Reverse Letters");
		buttonReverse.addActionListener(new ListenerReverse());
		buttonRemoveDuplicate = new JButton("Remove Duplicates");
		buttonRemoveDuplicate.addActionListener(new ListenerRemoveDuplicate());
		textInput = new JTextField(10);
		textOutput = new JTextField(10);
		labelInput = new JLabel("Input");
		labelOutput = new JLabel("Output");
	}

	private void PositionFrame() {
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		int height = toolKit.getScreenSize().height;
		int width = toolKit.getScreenSize().width;
		int frameHeight = this.getSize().height;
		int frameWidth = this.getSize().width;
		this.setLocation((width - frameWidth) / 2, (height - frameHeight) / 3);
	}

	private JPanel LayoutComponents() {
		JPanel basePanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel rightTopPanel = new JPanel();
		JPanel rightBottomPanel = new JPanel();

		basePanel.setLayout(new FlowLayout());
		basePanel.add(leftPanel);
		basePanel.add(rightPanel);

		leftPanel.setLayout(new BorderLayout(10, 10));
		leftPanel.add(buttonCounter, BorderLayout.NORTH);
		leftPanel.add(buttonReverse, BorderLayout.CENTER);
		leftPanel.add(buttonRemoveDuplicate, BorderLayout.SOUTH);

		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(rightTopPanel, BorderLayout.NORTH);
		rightPanel.add(rightBottomPanel, BorderLayout.SOUTH);

		rightTopPanel.setLayout(new BorderLayout());
		rightTopPanel.add(labelInput, BorderLayout.NORTH);
		rightTopPanel.add(textInput, BorderLayout.SOUTH);

		rightBottomPanel.setLayout(new BorderLayout());
		rightBottomPanel.add(labelOutput, BorderLayout.NORTH);
		rightBottomPanel.add(textOutput, BorderLayout.SOUTH);
		return basePanel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main mainFrame = new Main();
				mainFrame.setVisible(true);
				mainFrame.setResizable(false);
				mainFrame.setTitle("String Utility");
				mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				mainFrame.pack();
			}
		});
	}

	public class ListenerCounter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = textInput.getText();
			textOutput.setText(String.valueOf(input.length()));
		}
	}

	public class ListenerReverse implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = textInput.getText();
			int length = input.length();
			StringBuilder str = new StringBuilder();
			for (int idx = length - 1; idx >= 0; idx--) {
				str.append(input.charAt(idx));
			}
			textOutput.setText(str.toString());
		}
	}

	public class ListenerRemoveDuplicate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = textInput.getText();
			char[] lst = new char[input.length()];
			boolean isDuplicate = false;
			int lstPos = 0;
			for (int idx = 0; idx < input.length(); idx++) {
				isDuplicate = false;
				char val = input.charAt(idx);
				for (char check : lst) {
					if (val == check) {
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate) {
					lst[lstPos] = val;
					lstPos++;
				}
			}
			StringBuilder strBuilder = new StringBuilder();
			for (Object c : lst) {
				strBuilder.append(c);
			}
			textOutput.setText(strBuilder.toString());
		}
	}
}
