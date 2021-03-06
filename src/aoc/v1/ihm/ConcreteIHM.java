package aoc.v1.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aoc.command.CommandStart;
import aoc.command.CommandStop;
import aoc.controller.Controleur;
import aoc.util.Command;

public class ConcreteIHM extends JFrame implements IHM {

	private static final long serialVersionUID = 9212323680853243952L;
	
	private static final int TEMPO_MIN = 0;
	private static final int TEMPO_MAX = 240;
	private static final int TEMPO_INIT = 60;    

	private Controleur controller;

	private ImageIcon led_on;
	private ImageIcon led_off;
	
	public JLabel labelLed1;
	public JLabel labelLed2;
	private JSlider sliderTempo;
	public JTextField textTempo;
	private JButton buttonStart;
	private JButton buttonStop;
	private JButton buttonPlus;
	private JButton buttonMinus;
	public JTextField textNbTemps;
	
	private URL sound;
	private Clip clip;
	private AudioInputStream audio;
	
	public ConcreteIHM(Controleur controller) {
		super();
		
		this.controller = controller;
		
		this.sound = this.getClass().getClassLoader().getResource("click.wav");

		this.initLayout();
		
		Dimension dim = new Dimension(600, 400);
		this.setPreferredSize(dim);
		this.setSize(dim);
	}

	/**
	 * Initialise les éléments graphiques
	 */
	private void initLayout() {
		// Layout
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = gbc.weighty = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);

		// LEDS
		this.led_on = new ImageIcon(this.getClass().getClassLoader().getResource("red_led.png"));
		this.led_off = new ImageIcon(this.getClass().getClassLoader().getResource("grey_led.png"));	
		
		// LED 1
		this.labelLed1 = new JLabel(led_off);
		this.getContentPane().add(this.labelLed1, gbc);
		
		// LED 2
		gbc.gridx = 1;
		this.labelLed2 = new JLabel(led_off);
		this.getContentPane().add(this.labelLed2, gbc);
		
		// Slider tempo
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		this.sliderTempo = new JSlider(SwingConstants.HORIZONTAL, TEMPO_MIN, TEMPO_MAX, TEMPO_INIT);
		this.sliderTempo.setMajorTickSpacing(50);
		this.sliderTempo.setMinorTickSpacing(10);
		this.sliderTempo.setPaintTicks(true);
		this.sliderTempo.setPaintLabels(true);		
		this.sliderTempo.addChangeListener(new ChangeListener(){
						@Override
						public void stateChanged(ChangeEvent e) {
							JSlider source = (JSlider)e.getSource();
							if (!source.getValueIsAdjusting()) {
								controller.updateTempo((float)source.getValue());
							}
						}
					}
		);
		this.getContentPane().add(sliderTempo, gbc);
		
		// Text tempo
		gbc.gridx = 4;
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		this.textTempo = new JTextField(""+this.sliderTempo.getValue());
		Dimension dim = new Dimension(60, 30);
		this.textTempo.setSize(dim);
		this.textTempo.setPreferredSize(dim);
		this.textTempo.setMinimumSize(dim);
		this.getContentPane().add(textTempo, gbc);
		
		// Bouton Start
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.buttonStart = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("play.png")));
		this.buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Command c = new CommandStart(controller);
				c.execute();
			}
		});
		this.getContentPane().add(buttonStart, gbc);

		// Button Stop
		gbc.gridx = 1;
		this.buttonStop = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("stop.png")));
		this.buttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Command c = new CommandStop(controller);
				c.execute();
			}
		});
		this.getContentPane().add(buttonStop, gbc);

		// Bouton Plus
		gbc.gridx = 2;
		gbc.weightx = 0.5;
		this.buttonPlus = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("plus.png")));
		this.buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.augmenterMesures();
			}
		});
		this.getContentPane().add(buttonPlus, gbc);

		// Bouton Moins
		gbc.gridx = 3;
		this.buttonMinus = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("minus.png")));
		this.buttonMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.diminuerMesures();
			}
		});
		this.getContentPane().add(buttonMinus, gbc);
		
		// Text nb temps
		gbc.gridx = 4;
		gbc.weightx = 0;
		this.textNbTemps = new JTextField("3");
		this.textNbTemps.setSize(dim);
		this.textNbTemps.setPreferredSize(dim);
		this.textNbTemps.setMinimumSize(dim);
		this.getContentPane().add(textNbTemps, gbc);
	}
	
	@Override
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
	
	@Override
	public void flasherLED(boolean mesure) {
		this.labelLed1.setIcon(led_on);
		
		if (mesure) {
			this.labelLed2.setIcon(led_on);
		}
		this.repaint();
	}

	@Override
	public void eteindreLED() {
		this.labelLed1.setIcon(led_off);
		this.labelLed2.setIcon(led_off);
		this.repaint();
	}
	
	@Override
	public void majTempo(float tempo) {
		this.textTempo.setText(tempo+"");
	}

	@Override
	public void majMesure(int nbTemps) { 
		this.textNbTemps.setText(nbTemps+"");
	}

	@Override
	public Controleur getController() {
		return this.controller;
	}

	@Override
	public void setController(Controleur controller) {
		this.controller = controller;
	}
	
}