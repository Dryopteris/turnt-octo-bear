package lab22;

import java.lang.Thread;

public class ThreadRunner extends Thread {
	private int restValue, runnerSpeed;

	public ThreadRunner(String name, int rest, int speed) {
		setName(name);
		this.restValue = rest;
		this.runnerSpeed = speed;

	}

	@Override
	public void run() {
		int distance = 0;
		Thread ct = Thread.currentThread();

		while (!ct.isInterrupted() && distance < 1000) {
			try {
				int random = (int) (Math.random() * 100 + 1);
				if (restValue <= random) {
					distance += runnerSpeed;
					System.out.println(getName() + ": " + distance);
				}

				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out
						.println(getName() + ": You beat me fair and square!");
				break;
			}
			if (distance >= 1000) {
				System.out.println(getName() + ": I finished!");
				RaceApp.finished(ct);
				return;
			}
		}
	}
}