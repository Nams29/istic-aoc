package aoc.v2.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aoc.materiel.Afficheur;
import aoc.materiel.Clavier;
import aoc.materiel.EmetteurSonore;
import aoc.materiel.Molette;
import aoc.moteur.ConcreteHorloge;
import aoc.util.Horloge;
import aoc.v2.adapter.Adapter;

public class IHM extends JFrame implements Simulateur {

private static final long serialVersionUID = 9212323680853243952L;
	
	private static final int TEMPO_MIN = 0;
	private static final int TEMPO_MAX = 240;
	private static final int TEMPO_INIT = 60;    

	private Adapter adapter;
	
	private Horloge horloge;

	private ImageIcon led_on;
	private ImageIcon led_off;
	
	JLabel[] tabLed = new JLabel[3];
	
	private JLabel labelLed1;
	private JLabel labelLed2;
	public JSlider sliderTempo;
	private JTextField textTempo;
	
	public ButtonBool[] tabButton = new ButtonBool[5] ;
	
	public ButtonBool buttonStart; // 1
	public ButtonBool buttonStop; // 2
	public ButtonBool buttonPlus; // 3
	public ButtonBool buttonMinus; // 4	
	
	
	private JTextField textNbTemps;
	
	private File sound;
	private Clip clip;
	private AudioInputStream audio;
	
	public IHM() {
		super();
		
		horloge = new ConcreteHorloge();	
		sound = new File("res/click.wav");

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
		this.led_on = new ImageIcon("res/red_led.png");
		this.led_off = new ImageIcon("res/grey_led.png");		
		// LED 1
		this.labelLed1 = new JLabel(led_off);
		this.getContentPane().add(this.labelLed1, gbc);
		
		// LED 2
		gbc.gridx = 1;
		this.labelLed2 = new JLabel(led_off);
		this.getContentPane().add(this.labelLed2, gbc);
		
		tabLed[1]=labelLed1;
		tabLed[2]=labelLed2;
		
		
		// Slider tempo
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		this.sliderTempo = new JSlider(SwingConstants.HORIZONTAL, TEMPO_MIN, TEMPO_MAX, TEMPO_INIT);
		this.sliderTempo.setMajorTickSpacing(50);
		this.sliderTempo.setMinorTickSpacing(10);
		this.sliderTempo.setPaintTicks(true);
		this.sliderTempo.setPaintLabels(true);		
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
		this.buttonStart = new ButtonBool(new ImageIcon("res/play.png"));
		this.getContentPane().add(buttonStart, gbc);

		// Button Stop
		gbc.gridx = 1;
		this.buttonStop = new ButtonBool(new ImageIcon("res/stop.png"));
		this.getContentPane().add(buttonStop, gbc);

		// Bouton Plus
		gbc.gridx = 2;
		gbc.weightx = 0.5;
		this.buttonPlus = new ButtonBool(new ImageIcon("res/plus.png"));
		this.getContentPane().add(buttonPlus, gbc);

		// Bouton Moins
		gbc.gridx = 3;
		this.buttonMinus = new ButtonBool(new ImageIcon("res/minus.png"));
		this.getContentPane().add(buttonMinus, gbc);
		
		tabButton[1] = buttonStart;
		tabButton[2] = buttonStop;
		tabButton[3] = buttonPlus;
		tabButton[4] = buttonMinus;
		
		// Text nb temps
		gbc.gridx = 4;
		gbc.weightx = 0;
		this.textNbTemps = new JTextField("3");
		this.textNbTemps.setSize(dim);
		this.textNbTemps.setPreferredSize(dim);
		this.textNbTemps.setMinimumSize(dim);
		this.getContentPane().add(textNbTemps, gbc);
	}


	/**
	 * @return the controller
	 */
	public Adapter getAdapter() {
		return adapter;
	}


	/**
	 * @param controller the controller to set
	 */
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}


	@Override
	public void allumerLED(int numLED) {
		tabLed[numLED].setIcon(led_on);
		this.repaint();
	}



	@Override
	public void eteindreLED(int numLED) {
		this.tabLed[numLED].setIcon(led_off);
		
		this.repaint();
	}



	@Override
	public void afficherTempo(int valeurTempo) {
		this.textTempo.setText(valeurTempo+"");
	}
	
	@Override
	public void afficherMesure(int valeurMesure) {
		this.textNbTemps.setText(valeurMesure+"");
	}
	
	@Override
	public boolean touchePressée(int i) {
		return tabButton[i].isActive();
	}
	
	@Override
	public void emettreClic() {
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
	public float position() {
		return this.sliderTempo.getValue();
	}
	
	@Override
	public Horloge getHorloge() {
		return this.horloge;
	}
	
	@Override
	public Clavier getClavier() {
		return null;
	}
	
	@Override
	public Molette getMolette() {
		return null;
	}
	
	@Override
	public EmetteurSonore getEmetteurSonore() {
		return null;
	}
	
	@Override
	public Afficheur getAfficheur() {
		return null;
	}

}
