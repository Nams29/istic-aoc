package aoc.ihm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aoc.commands.CommandEteindreLed;
import aoc.commands.CommandStart;
import aoc.commands.CommandStop;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteHorloge;
import aoc.util.Command;
import aoc.util.Horloge;
import aoc.util.Subject;

public class IHM extends JFrame implements Subject {

	private static final long serialVersionUID = 9212323680853243952L;

	private Controleur controller;
	private Horloge horloge;

	private Command eteindreLed;

	JLabel labelLed1;
	JLabel labelLed2;

	private ImageIcon led_on;
	private ImageIcon led_off;
	private File sound;
	private Clip clip;
	private AudioInputStream audio;
	
	JTextField textTempo;

	public IHM(Controleur controller) {
		super();

		this.controller = controller;

		this.horloge = new ConcreteHorloge();

		this.eteindreLed = new CommandEteindreLed(this);
		
		sound = new File("res/click.wav");
		
		Dimension dim = new Dimension(600, 400);
		this.setPreferredSize(dim);
		this.setSize(dim);

		this.initLayout();
	}

	/**
	 * Initialise les éléments graphiques
	 */
	private void initLayout() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 4));

		// Bouton Tempo
		JButton buttonTempo = new JButton();
		buttonTempo.setText("Tempo");

		/* debut modif*/

		final int TEMPO_MIN = 0;
		final int TEMPO_MAX = 240;
		final int TEMPO_INIT = 60;    
		JSlider tempoSlider = new JSlider(JSlider.VERTICAL, TEMPO_MIN, TEMPO_MAX, TEMPO_INIT);

		
		tempoSlider.addChangeListener(new ChangeListener(){
						@Override
						public void stateChanged(ChangeEvent e) {
							JSlider source = (JSlider)e.getSource();
							if (!source.getValueIsAdjusting()) {
								controller.updateTempo((float)source.getValue());
							}
						}
					}
		);
		//framesPerSecond.addChangeListener(this);

		//Turn on labels at major tick marks.
		tempoSlider.setMajorTickSpacing(10);
		tempoSlider.setMinorTickSpacing(5);
		tempoSlider.setPaintTicks(true);
		tempoSlider.setPaintLabels(false);
		
		mainPanel.add(tempoSlider);

		/* end modif */


		//mainPanel.add(buttonTempo);

		// Affichage tempo
		textTempo = new JTextField();
		textTempo.setText("60");
		mainPanel.add(textTempo);

		// LEDS
		this.led_on = new ImageIcon("res/led_red.png");
		this.led_off = new ImageIcon("res/led_gray.png");

		// LED 1
		this.labelLed1 = new JLabel(led_off);
		this.labelLed1.setText("LED 1");
		mainPanel.add(labelLed1);

		// LED 2
		this.labelLed2 = new JLabel(led_off);
		this.labelLed2.setText("LED 2");
		mainPanel.add(labelLed2);

		// Bouton Start
		JButton buttonStart = new JButton();
		buttonStart.setText("START");
		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Command c = new CommandStart(controller);
				c.execute();
			}
		});
		mainPanel.add(buttonStart);

		// Button Stop
		JButton buttonStop = new JButton();
		buttonStop.setText("STOP");
		buttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Command c = new CommandStop(controller);
				c.execute();
			}
		});
		mainPanel.add(buttonStop);

		// Bouton Plus
		JButton buttonPlus = new JButton();
		buttonPlus.setText("+");
		buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.augmenterMesures();
			}
		});
		mainPanel.add(buttonPlus);

		// Bouton Moins
		JButton buttonMoins = new JButton();
		buttonMoins.setText("-");
		buttonMoins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.diminuerMesures();
			}
		});
		mainPanel.add(buttonMoins);

		this.setContentPane(mainPanel);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

	}
	
	public void sonner() {
		try {
			audio = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Allume les LEDs
	 */
	public void flasherLED(boolean mesure) {
		this.labelLed1.setIcon(led_on);
		if (mesure) this.labelLed2.setIcon(led_on);
		this.repaint();
		horloge.activerApresDelai(eteindreLed, (float) 0.2);

	}

	/**
	 * Eteint les LEDs
	 */
	public void eteindreLED() {
		this.labelLed1.setIcon(led_off);
		this.labelLed2.setIcon(led_off);
		this.repaint();
	}
	
	/**
	 * Eteint les LEDs
	 */
	public void majTempo(float tempo) {
		this.textTempo.setText(tempo+"");
	}


}
