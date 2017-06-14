package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConcertGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelMiddle;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panelGornji;
	private JButton btnStart;
	private JButton btnStop;

	/**
	 * Create the frame.
	 */
	public ConcertGUI() {
		setTitle("Concert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelMiddle(), BorderLayout.CENTER);
	}

	private JPanel getPanelMiddle() {
		if (panelMiddle == null) {
			panelMiddle = new JPanel();
			panelMiddle.setLayout(new BorderLayout(0, 0));
			panelMiddle.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelMiddle;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getPanelGornji());
		}
		return scrollPane;
	}

	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private JPanel getPanelGornji() {
		if (panelGornji == null) {
			panelGornji = new JPanel();
			panelGornji.setLayout(null);
			panelGornji.setPreferredSize(new Dimension(0, 50));
			panelGornji.add(getBtnStart());
			panelGornji.add(getBtnStop());
		}
		return panelGornji;
	}

	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.startSinging();
				}
			});
			btnStart.setBounds(58, 11, 129, 28);
		}
		return btnStart;
	}

	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.stopSinging();
				}
			});
			btnStop.setBounds(237, 11, 129, 28);
		}
		return btnStop;
	}
}
