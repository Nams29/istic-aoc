package aoc.v2.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

public class ConcreteIHM extends JFrame implements Simulateur {

private static final long serialVersionUID = 9212323680853243952L;
	
	private static final int TEMPO_MIN = 0;
	private static final int TEMPO_MAX = 240;
	private static final int TEMPO_INIT = 60;    

	private Adapter adapter;
	private Horloge horloge;

	public ImageIcon led_on;
	public ImageIcon led_off;
	
	JLabel[] tabLed = new JLabel[3];
	
	public JLabel labelLed1;
	public JLabel labelLed2;
	public JSlider sliderTempo;
	public JTextField textTempo;
	
	public ButtonBool[] tabButton = new ButtonBool[5] ;
	
	public ButtonBool buttonStart; // 1
	public ButtonBool buttonStop; // 2
	public ButtonBool buttonPlus; // 3
	public ButtonBool buttonMinus; // 4	
	
	public JTextField textNbTemps;
	
	private Afficheur afficheur;
	private Clavier clavier;
	private EmetteurSonore emetteurSonore;
	private Molette molette;

	
	public ConcreteIHM() {
		super();
		
		horloge = new ConcreteHorloge();	

		this.initLayout();
		
		afficheur = new ConcreteAfficheur(this);
		clavier = new ConcreteClavier(this); 
		emetteurSonore = new ConcreteEmetteurSonore(this);
		molette = new ConcreteMolette(this);
		
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
		this.buttonStart = new ButtonBool(new ImageIcon(this.getClass().getClassLoader().getResource("play.png")));
		this.getContentPane().add(buttonStart, gbc);

		// Button Stop
		gbc.gridx = 1;
		this.buttonStop = new ButtonBool(new ImageIcon(this.getClass().getClassLoader().getResource("stop.png")));
		this.getContentPane().add(buttonStop, gbc);

		// Bouton Plus
		gbc.gridx = 2;
		gbc.weightx = 0.5;
		this.buttonPlus = new ButtonBool(new ImageIcon(this.getClass().getClassLoader().getResource("plus.png")));
		this.getContentPane().add(buttonPlus, gbc);

		// Bouton Moins
		gbc.gridx = 3;
		this.buttonMinus = new ButtonBool(new ImageIcon(this.getClass().getClassLoader().getResource("minus.png")));
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
	 * @return l'adaptateur
	 */
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	/**
	 * @param adapter L'adaptateur
	 */
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}
	
	@Override
	public Clavier getClavier() {
		return this.clavier;
	}
	
	@Override
	public Molette getMolette() {
		return this.molette;
	}
	
	@Override
	public EmetteurSonore getEmetteurSonore() {
		return this.emetteurSonore;
	}
	
	@Override
	public Afficheur getAfficheur() {
		return this.afficheur;
	}


	@Override
	public Horloge getHorloge() {
		return this.horloge;
	}

}
