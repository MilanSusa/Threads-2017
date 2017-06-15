package music;

import gui.GUIController;

public class Synchronizer {

	private int voiceFlag;

	public Synchronizer(int voiceFlag) {
		super();
		this.voiceFlag = voiceFlag;
	}

	public Synchronizer() {
	}

	public synchronized void singFirstVoice(String lyrics1, int delay, boolean isEnabled1, boolean isEnabled2,
			boolean isEnabled3) {
		while (voiceFlag != 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics1, delay, isEnabled1, isEnabled2, isEnabled3);
	}

	public synchronized void singSecondVoice(String lyrics2, int delay, boolean isEnabled1, boolean isEnabled2,
			boolean isEnabled3) {
		while (voiceFlag != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics2, delay, isEnabled1, isEnabled2, isEnabled3);
	}

	public synchronized void singThirdVoice(String lyrics3, int delay, boolean isEnabled1, boolean isEnabled2,
			boolean isEnabled3) {
		while (voiceFlag != 3) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singCurrent(lyrics3, delay, isEnabled1, isEnabled2, isEnabled3);
	}

	/**
	 * @param lyrics
	 */
	private void singCurrent(String lyrics, int delay, boolean isEnabled1, boolean isEnabled2, boolean isEnabled3) {
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!GUIController.isEnabled1() && !GUIController.isEnabled2() && !GUIController.isEnabled3()) {
			GUIController.stopConcert();
			GUIController.concertGUI.getBtnStart1().setEnabled(false);
			GUIController.concertGUI.getBtnStart2().setEnabled(false);
			GUIController.concertGUI.getBtnStart3().setEnabled(false);
			GUIController.concertGUI.getBtnStop1().setEnabled(false);
			GUIController.concertGUI.getBtnStop2().setEnabled(false);
			GUIController.concertGUI.getBtnStop3().setEnabled(false);
			GUIController.concertGUI.getBtnStopConcert().setEnabled(false);
			GUIController.concertGUI.getBtnStartConcert().setEnabled(true);
			GUIController.printText("\n\n KRAJ\n");
			return;
		}
		GUIController.printText(lyrics);
		voiceFlag = (voiceFlag % 3) + 1;
		if (!isEnabled1 && voiceFlag == 1) {
			++voiceFlag;
		}
		if (!isEnabled2 && voiceFlag == 2) {
			++voiceFlag;
		}
		if (!isEnabled3 && voiceFlag == 3) {
			++voiceFlag;
		}
		if (voiceFlag > 3) {
			voiceFlag = voiceFlag % 3;
		}
		if (!GUIController.isEnabled1() && !GUIController.isEnabled2() && GUIController.isEnabled3()) {
			voiceFlag = 3;
		}
		if (!GUIController.isEnabled1() && GUIController.isEnabled2() && !GUIController.isEnabled3()) {
			voiceFlag = 2;
		}
		if (GUIController.isEnabled1() && !GUIController.isEnabled2() && !GUIController.isEnabled3()) {
			voiceFlag = 1;
		}
		notifyAll();
	}

	public int getVoiceFlag() {
		return voiceFlag;
	}

	public void setVoiceFlag(int voiceFlag) {
		this.voiceFlag = voiceFlag;
	}

}
