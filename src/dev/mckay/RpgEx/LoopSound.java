package dev.mckay.RpgEx;

import java.io.*;
import javax.sound.sampled.*;

public class LoopSound {
	public float volume = -10;
	File wavFile;
	AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;
    FloatControl volumeControl;
	public LoopSound(){
	}
	
	public void playSong(String fileName){
			if (clip != null){
				newSong();
			}
		 try {
			 	
				wavFile = new File(System.getProperty("user.dir") + fileName);
			    stream = AudioSystem.getAudioInputStream(wavFile);
			    format = stream.getFormat();
			    info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volumeControl.setValue(volume);
			    clip.loop(clip.LOOP_CONTINUOUSLY);
		} 
		catch (Exception e) {
			System.out.println(volume);
		}
	}
	
	public void newSong(){
		clip.close();
	}
    
}