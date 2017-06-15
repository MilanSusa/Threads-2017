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
	private JButton btnStart1;
	private JButton btnStop1;
	private JPanel panelLevi;
	private JButton btnStart2;
	private JButton btnStart3;
	private JButton btnStop2;
	private JButton btnStop3;
	private JButton btnStartConcert;
	private JButton btnStopConcert;

	/**
	 * Create the frame.
	 */
	public ConcertGUI() {
		setTitle("Concert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
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
			scrollPane.setRowHeaderView(getPanelLevi());
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
			panelGornji.setPreferredSize(new Dimension(0, 100));
			panelGornji.add(getBtnStart1());
			panelGornji.add(getBtnStop1());
			panelGornji.add(getBtnStart2());
			panelGornji.add(getBtnStart3());
			panelGornji.add(getBtnStop2());
			panelGornji.add(getBtnStop3());
		}
		return panelGornji;
	}

	public JButton getBtnStart1() {
		if (btnStart1 == null) {
			btnStart1 = new JButton("Start Thread 1");
			btnStart1.setEnabled(false);
			btnStart1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnStart1.setEnabled(false);
					btnStop1.setEnabled(true);
				}
			});
			btnStart1.setBounds(58, 11, 129, 28);
		}
		return btnStart1;
	}

	public JButton getBtnStop1() {
		if (btnStop1 == null) {
			btnStop1 = new JButton("Stop Thread 1");
			btnStop1.setEnabled(false);
			btnStop1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnStart1.setEnabled(true);
					btnStop1.setEnabled(false);
				}
			});
			btnStop1.setBounds(58, 61, 129, 28);
		}
		return btnStop1;
	}

	private JPanel getPanelLevi() {
		if (panelLevi == null) {
			panelLevi = new JPanel();
			panelLevi.setLayout(null);
			panelLevi.setPreferredSize(new Dimension(150, 0));
			panelLevi.add(getBtnStartConcert());
			panelLevi.add(getBtnStopConcert());
		}
		return panelLevi;
	}

	public JButton getBtnStart2() {
		if (btnStart2 == null) {
			btnStart2 = new JButton("Start Thread 2");
			btnStart2.setEnabled(false);
			btnStart2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnStart2.setEnabled(false);
					btnStop2.setEnabled(true);
				}
			});
			btnStart2.setBounds(321, 11, 129, 28);
		}
		return btnStart2;
	}

	public JButton getBtnStart3() {
		if (btnStart3 == null) {
			btnStart3 = new JButton("Start Thread 3");
			btnStart3.setEnabled(false);
			btnStart3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStart3.setEnabled(false);
					btnStop3.setEnabled(true);
				}
			});
			btnStart3.setBounds(566, 11, 129, 28);
		}
		return btnStart3;
	}

	public JButton getBtnStop2() {
		if (btnStop2 == null) {
			btnStop2 = new JButton("Stop Thread 2");
			btnStop2.setEnabled(false);
			btnStop2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStart2.setEnabled(true);
					btnStop2.setEnabled(false);
				}
			});
			btnStop2.setBounds(321, 61, 129, 28);
		}
		return btnStop2;
	}

	public JButton getBtnStop3() {
		if (btnStop3 == null) {
			btnStop3 = new JButton("Stop Thread 3");
			btnStop3.setEnabled(false);
			btnStop3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStart3.setEnabled(true);
					btnStop3.setEnabled(false);
				}
			});
			btnStop3.setBounds(566, 64, 129, 28);
		}
		return btnStop3;
	}

	public JButton getBtnStartConcert() {
		if (btnStartConcert == null) {
			btnStartConcert = new JButton("Start Concert");
			btnStartConcert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStop1.setEnabled(true);
					btnStop2.setEnabled(true);
					btnStop3.setEnabled(true);
					btnStartConcert.setEnabled(false);
					btnStopConcert.setEnabled(true);
					GUIController.startConcert();
				}
			});
			btnStartConcert.setBounds(10, 104, 130, 38);
		}
		return btnStartConcert;
	}

	public JButton getBtnStopConcert() {
		if (btnStopConcert == null) {
			btnStopConcert = new JButton("Stop Concert");
			btnStopConcert.setEnabled(false);
			btnStopConcert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStart1.setEnabled(false);
					btnStart2.setEnabled(false);
					btnStart3.setEnabled(false);
					btnStop1.setEnabled(false);
					btnStop2.setEnabled(false);
					btnStop3.setEnabled(false);
					btnStartConcert.setEnabled(true);
					btnStopConcert.setEnabled(false);
					GUIController.stopConcert();
				}
			});
			btnStopConcert.setBounds(10, 221, 130, 38);
		}
		return btnStopConcert;
	}
}
