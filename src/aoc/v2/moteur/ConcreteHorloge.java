package aoc.v2.moteur;

import java.util.Timer;
import java.util.TimerTask;

import aoc.util.Command;
import aoc.util.Horloge;



public class ConcreteHorloge implements Horloge {
	
	private Timer timer;
	private TimerTask task;
	
	public ConcreteHorloge() {
		this.timer = new Timer();
	}
	
	@Override
	public void activerPeriodiquement(Command cmd, float periode) {
		this.task = new HorlogeTask(cmd);
		this.timer = new Timer();
		this.timer.schedule(task, 0, (long)(periode*1000));
	}

	@Override
	public void activerApresDelai(Command cmd, float delaiEnSecondes) {
		task = new HorlogeTask(cmd);
		timer.schedule(task, (long)(delaiEnSecondes*1000));
	}

	@Override
	public void desactiver(Command cmd) {
		timer.cancel();
	}
	
	private class HorlogeTask extends TimerTask {
		
		Command cmd;
		
		public HorlogeTask(Command cmd) {
			this.cmd = cmd;
		}
		
		@Override
		public void run() {
			this.cmd.execute();
		}
		
	}

}
