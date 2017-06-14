package gui;

import java.awt.EventQueue;

import test.Test;

public class GUIController {

	private static Test t;
	private static ConcertGUI concertGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concertGUI = new ConcertGUI();
					concertGUI.setVisible(true);
					t = new Test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void startSinging() {
		t.testSingInThreads();
	}

	public static void printText(String lyrics) {
		concertGUI.getTextArea().setText(concertGUI.getTextArea().getText() + lyrics);
	}

	public static void stopSinging() {
		t.stopSinging();
	}

}
