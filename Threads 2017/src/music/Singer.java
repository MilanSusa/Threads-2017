package music;

import gui.GUIController;

public class Singer extends Thread {

	private String singerName;
	private Voice voice;
	private Performance performance;

	private Synchronizer synch;
	private boolean stopIt;

	public Singer(String singerName, Voice voice, Performance performance, Synchronizer synch, boolean stopIt) {
		super();
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.synch = synch;
		this.stopIt = stopIt;
	}

	public Singer() {
		super();
	}

	@Override
	public void run() {
		sing();
	}

	private synchronized void sing() {
		while (!stopIt) {
			if (voice == Voice.FIRST) {
				synch.singFirstVoice(performance.getLyrics(), performance.getDelay(), GUIController.isEnabled1(),
						GUIController.isEnabled2(), GUIController.isEnabled3());
			} else if (voice == Voice.SECOND) {
				synch.singSecondVoice(performance.getLyrics(), performance.getDelay(), GUIController.isEnabled1(),
						GUIController.isEnabled2(), GUIController.isEnabled3());
			} else if (voice == Voice.THIRD) {
				synch.singThirdVoice(performance.getLyrics(), performance.getDelay(), GUIController.isEnabled1(),
						GUIController.isEnabled2(), GUIController.isEnabled3());
			}
		}
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public Synchronizer getSynch() {
		return synch;
	}

	public void setSynch(Synchronizer synch) {
		this.synch = synch;
	}

	public boolean isStopIt() {
		return stopIt;
	}

	public void setStopIt(boolean stopIt) {
		this.stopIt = stopIt;
	}

}
