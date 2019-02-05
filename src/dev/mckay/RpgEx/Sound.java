package dev.mckay.RpgEx;


import java.io.*;
import javax.sound.sampled.*;

public class Sound {
	public File wavFile, slice, coin, warpGate, sandStorm , door, shopHey, robot, littleHey;
	AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;
	public Sound(){
		initializeSoundBytes();
	}
	
	public void playSound(File fileName){
		 try {
			 	System.out.println(fileName);
				wavFile = fileName;
			    stream = AudioSystem.getAudioInputStream(wavFile);
			    format = stream.getFormat();
			    info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
		} 
		catch (Exception e) {
			System.out.println("failure");
		}
	}
	
	
	public void initializeSoundBytes(){
		
		warpGate = new File(System.getProperty("user.dir") + "/res/soundFiles/warp.wav");
		sandStorm = new File(System.getProperty("user.dir") + "/res/soundFiles/sandStorm.wav");
		slice = new File(System.getProperty("user.dir") + "/res/soundFiles/slice.wav");
		coin = new File(System.getProperty("user.dir") + "/res/soundFiles/smallBeep.wav");
		door = new File(System.getProperty("user.dir") + "/res/soundFiles/smallDoor.wav");
		shopHey = new File(System.getProperty("user.dir") + "/res/soundFiles/shopHey.wav");
		robot = new File(System.getProperty("user.dir") + "/res/soundFiles/robot.wav");
		littleHey = new File(System.getProperty("user.dir") + "/res/soundFiles/littleHey.wav");
	}
	
    
}