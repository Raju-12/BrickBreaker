package BrickBreaker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class MapGenerator 

{
	public int map[][];
	
	public int brickwidth;
	
	private int score=0;
	
	public int brickheight;
	
	//private int playerX=310;
	
	
	public MapGenerator(int row ,int col)
	{
		map=new int [row][col];
		
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				map[i][j]=15;
			}
		}
		
		brickwidth=540/col;//brick size
		brickheight=150/row;//brick size
		map[0][1]=1;
		map[0][2]=2;
		map[0][3]=3;
		map[0][4]=4;
		map[0][5]=5;
		map[1][5]=6;
		map[1][4]=7;
		map[2][2]=9;
		map[2][4]=8;
		map[1][1]=10;
		
	}
	public void draw(Graphics2D g)
	
	{
		
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				
			       if(map[i][j]>0)			      				    	  
			    	   
			    	  // --------raf code---------//
			    	   
			    	   if(map[i][j]>=1){
			    		   
			    		   g.setColor(new Color(0,200,200)); 
			    	      }
			          if(map[i][j]==2){
			        	  g.setColor(Color.orange);
			        	 // int playerX=310;
			        	  //score+=20;
						//g.fillRect(playerX, 550, 50, 8);
		    		     
		    	          }
			          
			           if(map[i][j]==3){
		    		    
		    		     g.setColor(Color.blue);
		    	          }
			           
			           if(map[i][j]==4){
			    		  
			    		     g.setColor(Color.green);
			    	          }
			           if(map[i][j]==6){
			    		    
			    		     g.setColor(Color.green);
			    	          }
			           
			           
			           if(map[i][j]==5){
			    		    
			    		     g.setColor(Color.yellow);
			    	          }
			           if(map[i][j]==7){
			    		    
			    		     g.setColor(Color.orange);
			    	          }
			           if(map[i][j]==8){
			    		    
			    		     g.setColor(Color.green);
			    	          }
			           if(map[i][j]==9){
			    		     
			    		     g.setColor(Color.red);
			    		     
			    	          }
			           if(map[i][j]==10){
			    		     
			    		     g.setColor(Color.green);
			    	          }
			       
			         // -------main code-----------
			          
			    	   //design brick zone
			    	   g.fillRect(j*brickwidth + 80, i*brickheight +50, brickwidth, brickheight);
			    	   //brick zone show
			    	   g.setStroke(new BasicStroke(3));	//just 3 pixel distance in all brick---
			    	   g.setColor(Color.black);			  //with each other  	   			    	
			    	   g.drawRect(j*brickwidth + 80, i*brickheight +50, brickwidth, brickheight);
			    	   //border show
			    	   
			      }
			}
		}
		
	//}
	
	public void setBrickvalue(int value,int row,int col){
		map[row][col]=value;
		
	}

}
