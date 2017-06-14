package test;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimerTask extends TimerTask {

	private Timer timer;

	public TestTimerTask(Timer timer) {
		super();
		this.timer = timer;
	}

	public TestTimerTask() {
		super();
	}

	@Override
	public void run() {
		System.out.println();
		System.out.println("Hi :)");
		System.out.println();
		timer.cancel(); // cancel timer task (terminate its thread)
		timer.purge(); // remove all cancelled tasks from this timer's task
						// queue; practically unnecessary after cancel()
	}

}
