package gui;

import java.awt.EventQueue;

import test.Test;

public class GUIController {

	private static Test t;
	public static ConcertGUI concertGUI;

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

	public static void startConcert() {
		t.testSingInThreads();
	}

	public static void stopConcert() {
		t.stopConcert();
	}

	public static void printText(String lyrics) {
		concertGUI.getTextArea().setText(concertGUI.getTextArea().getText() + lyrics);
	}

	public static boolean isEnabled1() {
		return concertGUI.getBtnStop1().isEnabled();
	}

	public static boolean isEnabled2() {
		return concertGUI.getBtnStop2().isEnabled();
	}

	public static boolean isEnabled3() {
		return concertGUI.getBtnStop3().isEnabled();
	}
}
