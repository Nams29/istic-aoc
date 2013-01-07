package aoc.v2.ihm;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import aoc.materiel.EmetteurSonore;

public class ConcreteEmetteurSonore implements EmetteurSonore {

	ConcreteIHM ihm;
	private URL sound;
	private Clip clip;
	private AudioInputStream audio;
	
	public ConcreteEmetteurSonore(ConcreteIHM ihm){
		this.ihm=ihm;
		sound = this.getClass().getClassLoader().getResource("click.wav");
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

}
