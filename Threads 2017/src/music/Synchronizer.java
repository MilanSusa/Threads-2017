package music;

import java.awt.TextArea;

import gui.ConcertGUI;
import gui.GUIController;

public class Synchronizer {

	private int voiceFlag;

	public Synchronizer(int voiceFlag) {
		super();
		this.voiceFlag = voiceFlag;
	}

	public Synchronizer() {
	}

	public synchronized void singFirstVoice(String lyrics1, int delay) {
		while (voiceFlag != 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics1, delay);
	}

	public synchronized void singSecondVoice(String lyrics2, int delay) {
		while (voiceFlag != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics2, delay);
	}

	public synchronized void singThirdVoice(String lyrics3, int delay) {
		while (voiceFlag != 3) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics3, delay);
	}

	/**
	 * @param lyrics
	 */
	private void singCurrent(String lyrics, int delay) {
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GUIController.printText(lyrics);
		voiceFlag = (voiceFlag % 3) + 1;
		notifyAll();
	}

	public int getVoiceFlag() {
		return voiceFlag;
	}

	public void setVoiceFlag(int voiceFlag) {
		this.voiceFlag = voiceFlag;
	}

}
