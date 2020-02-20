package BrickBreaker;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

//import java.util.Timer;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private boolean play=false;
	
	private int score=0;
	
	private int totalbricks=21;
	
	private Timer timer;
	
	public int delay=8;
	
	private int playerX=310;
	
	// public int playerX=310;
	
	private int ballposX=120;
	
	private int ballposY=350;
	
	private int ballXdir=-1;//-1
	
	private int ballYdir=-2;//-2
	
	//private int map1[][];
	private MapGenerator map;
	
	public int i,j;
	
	public Gameplay()
	{

		map=new MapGenerator(3,7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer =new Timer(delay,  this);
		timer.start();
	
	}
	
	
public void paint (Graphics g)

{

	
	//background
	
	g.setColor(Color.black);
	g.fillRect(1, 1, 692, 592);
	//drawing map
	
	map.draw((Graphics2D)g);
	
	//border
	
	g.setColor(Color.yellow);
	g.fillRect(0, 0, 3, 592);//left side
	g.fillRect(0, 0, 692, 3);//top side
	g.fillRect(691, 0, 3, 592);//right side
	
	//scores
	
	g.setColor(Color.white);
	g.setFont(new Font("serif",Font.BOLD,25));
	g.drawString("score :"+score, 530, 30);
	
	//the paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 550, 100, 8);//playerX means it can be rotate along with x -axis
	

	
	
	//the ball
	
	g.setColor(Color.yellow);
	g.fillOval(ballposX, ballposY, 20, 20);//posx,posy means it can rotate x and y axis
	
	if(totalbricks<=0){
		play=false;
		ballXdir=0;
		ballYdir=0;
		g.setColor(Color.RED);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("you won and score is :"+score,190, 350);
		g.setFont(new Font("serif",Font.BOLD,20));
		if(score==640){
			g.drawString("Game Over ", 190, 380);
		}
		else
		{
			g.drawString("Press Enter to go next level ", 190, 380);
		}
		
		
	}
	
	
	
	if(ballposY > 570)
	{
		play=false;
		ballXdir=0;
		ballYdir=0;
		g.setColor(Color.RED);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("You lose,your score :"+score,190, 350);
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("Press ENTER to Restart ", 190, 380);
		
	}
	
	g.dispose();
		
		
}



	public void actionPerformed(ActionEvent e) 
	
	
	{
		
		
		timer.start();
		if(play)
			
		{
			//detect paddle with ball
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
			{
				
				ballYdir=-ballYdir;//detect ball with paddle---
				//-----padle sound
				
				PlaySound("file:./Resource/bat+hit+ball.wav", 0);								
			}
			
		
			
			A:for( i=0;i<map.map.length;i++){
				for( j=0;j<map.map[0].length;j++){
					if(map.map[i][j]>0){
						
						int brickX=j* map.brickwidth+80;
						int brickY=i* map.brickheight+50;
						int brickwidth=map.brickwidth;
						int brickheight=map.brickheight;
						
						Rectangle rect=new Rectangle(brickX,brickY,brickwidth,brickheight);
						Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
						Rectangle brickRect=rect;
						
						
						
						if(ballRect.intersects(brickRect)){
																			
							totalbricks--;
							
			// started identify individual brick and increase several brick score	
							
							//Graphics g ;
							
							if(map.map[i][j]==2){	
								map.map[0][2]=2;
								score+=10; //+5 extra add hobe
								//timer =new Timer(7,  this);
								//timer.start();
								map.setBrickvalue(0, i, j);
																								
							}
							if(map.map[i][j]==3){	
								map.map[0][3]=3;
								score+=15; //+5 extra add hobe
								
								//timer =new Timer(15,  this);
								//timer.start();
								map.setBrickvalue(0, i, j);
																								
							}
							if(map.map[i][j]==4){	
								map.map[0][4]=4;
								//timer =new Timer(10,  this);
								score+=20;
								//timer.start();//+5 extra add hobe						
								map.setBrickvalue(0, i, j);
																								
							}
							if(map.map[i][j]==5){	
								map.map[0][5]=5;
								//timer =new Timer(20,  this);
								score+=30;		//+5 extra add hobe
								//timer.start();
								map.setBrickvalue(0, i, j);
																								
							}
							
							if(map.map[i][j]==6){	
								map.map[1][5]=6;
								//timer.start();
								//timer =new Timer(15,  this);
								score+=20;	//+5 extra add hobe							
								map.setBrickvalue(0, i, j);
																								
							}
							if(map.map[i][j]==7){	
								map.map[1][4]=7;
								score+=10;
								//timer.start();
								//timer =new Timer(7,  this);//+5 extra add hobe							
								map.setBrickvalue(0, i, j);
																								
							}
							
							if(map.map[i][j]==9){	
								map.map[2][2]=9;
								
								score+=5;	//+5 extra add hobe	
								//timer =new Timer(10,  this);
								
								//Graphics g = null;
								
								//g.fillRect(playerX, 550, 50, 8);
								
								map.setBrickvalue(0, i, j);
								
																								
							}
							if(map.map[i][j]==8){	
								map.map[2][4]=8;
								score+=20;	//+5 extra add hobe	
								//timer =new Timer(10,  this);
								//timer.start();
								map.setBrickvalue(0, i, j);
								
																								
							}
							if(map.map[i][j]==10){	
								map.map[1][1]=10;
								score+=20;	//+5 extra add hobe	
								//timer =new Timer(11,  this);
								map.setBrickvalue(0, i, j);
								//timer.start();
																								
							}
							 
							
							else
							{								
									map.setBrickvalue(0, i, j);
									score+=5;
								//+5 extra add hobe								
								//timer =new Timer(delay,  this);
								//timer.start();
								//totalbricks--;								
							}
							
				// end brick score 
							
							
						//----brick breaker sound
							
							PlaySound("file:./Resource/Smashing.wav", 0);
							//19----1
							if(ballposX + 19<=brickRect.x || ballposX +1>=brickRect.x+brickRect.width){
								ballXdir=-ballXdir;
							}
							else{
								ballYdir=-ballYdir;
							}
							break A;
												
							
						}
					}
				}
			}
			
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			
		//	move ball
			
			if(ballposX < 0)
			{
				ballXdir=-ballXdir;//ball touch left border and come back
			}
			if(ballposY < 0)
			{
				ballYdir=-ballYdir;//ball touch top border and come back
			}
			if(ballposX >670)
			{
				ballXdir=-ballXdir;//ball touch right border and come back
			}
		}
				
		repaint();
				
	}

//	private void PlaySound(String string, int i) {
//		// TODO Auto-generated method stub
//		
//	}

//
//	private void playSound(String string, int i) {
//		// TODO Auto-generated method stub
		
//	}


	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(playerX >=600)
			{
				playerX=600;
			}
			else
			{
				moveRight();
				
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerX < 10)
			{
				playerX=10;
			}
			else
			{
				moveLeft();
				
			}
		}
		if(totalbricks<=0){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				if(!play){
					play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-1;
					ballYdir=-2;
					playerX=310;
					score=250;
					totalbricks=49;
					//delay=3;
					
					map=new MapGenerator(7,7);
					repaint();
					
				}
			}
						
	}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if(!play){
				play=true;
				ballposX=120;
				ballposY=350;
				ballXdir=-1;
				ballYdir=-2;
				playerX=310;
				score=0;
				totalbricks=21;
				//delay=3;
				map=new MapGenerator(3,7);
				repaint();
				
			}
			
		}
			
			
	}
		
	
	
	public void moveRight()
	{
		play=true;
		playerX+=20;//move paddle right
	}
	
	public void moveLeft()
	{

		play=true;
		playerX-=20;//move padle right
	}
	//PlaySound("file:./Resource/Smashing.wav", 0);
	public void PlaySound(String soundFile, int times) 
	{
		try{
			URL soundLocation=new URL(soundFile);
			AudioInputStream audio=AudioSystem.getAudioInputStream(soundLocation);
			Clip clip=AudioSystem.getClip();
			clip.open(audio);
			clip.loop(times);
			clip.start();
			
		}catch(UnsupportedAudioFileException uae){
			System.out.println(uae);
			
		}catch(IOException ioe){
			System.out.println(ioe);
	    }catch(LineUnavailableException lua){
	    	System.out.println(lua);
	    }
		  
	
	  }
	

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
