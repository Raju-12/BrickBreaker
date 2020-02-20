package BrickBreaker;

import java.awt.Component;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame obj=new JFrame(); 
		
		Gameplay gameplay=new Gameplay();
		
		//design layout of this game
		obj.setBounds(10,10,700,600);
		
		obj.setTitle("Breakout Ball");
		
		obj.setResizable(false);
		
		obj.setVisible(true);
		
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		obj.add(gameplay);
		
		//background sound
		File Clap =new File("Resource/one.wav");
		
		PlaySound(Clap);
	}
		
		//new.............
		
		 static  void PlaySound(File Sound)
	{
			try{
				Clip clip=AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(Sound));
				clip.start();
				Thread.sleep(clip.getMicrosecondLength()/100);
				
				}catch(Exception e)
			{
					
			}
			
		}
		

}