package gorocky;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public final class RockyLogic implements ActionListener, MouseListener, KeyListener
{

	public static RockyLogic goRocky;
	public final int WIDTH = 1200, HEIGHT = 700;
        public int speed = 10;
	public Renderer renderer;
	public Rectangle rocky;
        public ImageIcon rocky1;
	public ArrayList<Rectangle> obstacle;
	public int ticks, rockyY, score;
        public boolean gameOver, begin;
	public Random rand;
        public boolean flag=true;
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();


	public RockyLogic()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("goRocky");
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);
                
                //Rectangle(int x, int y, int width, int height) 
		rocky = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);

                
                
               JLabel rockyFace = new JLabel();
               rockyFace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rocky.png"))); 
               jframe.add(rockyFace);
               rockyFace.setVisible(true);
              
//  jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rocky.png")));
              //  jl.setVisible(true);
                //jframe.add(jl);
                //add(jframe);
                //validate();
		obstacle = new ArrayList<>();

		addObstacle(true);
		addObstacle(true);
		addObstacle(true);
		addObstacle(true);

		timer.start();
	}

	public void addObstacle(boolean start)
	{
		int space = 300; //gap between two obstacle
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start)
		{
                    System.out.println("start: "+start);
                    //for the lower obstacle
                    obstacle.add(new Rectangle(WIDTH + width + obstacle.size() * 300, HEIGHT - height - 120, width, height));
                    //for the obstacle above
                    obstacle.add(new Rectangle(WIDTH + width + (obstacle.size() - 1) * 300, 0, width, HEIGHT - height - space));
                        
                }
		else
		{ 
                    obstacle.add(new Rectangle(obstacle.get(obstacle.size() - 1).x + 600, HEIGHT - height - 120, width, height));
                    obstacle.add(new Rectangle(obstacle.get(obstacle.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}
        
        //paints the obstacle
	public void paintObstacle(Graphics g, Rectangle column)
	{
                Color purple = new Color(140, 26, 255);
                g.setColor(purple);
                //Fills the specified rectangle.
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void jump()
	{
		if (gameOver)
		{
                    //rocky = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
                    //rocky1 = new ImageIcon(getClass().getResource("rocky.png"));
                        obstacle.clear();
			rockyY = 0;
			score = 0;

			addObstacle(true);
			addObstacle(true);
			addObstacle(true);
			addObstacle(true);
			gameOver = false;
		}

		if (!begin)
		{
			begin = true;
		}
		else if (!gameOver)
		{
			if (rockyY > 0)
			{
				rockyY = 0;
			}

			rockyY -= 10;
		}
	}//end of jump

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ticks++;
                //System.out.println("ticks: "+ticks);
		if (begin)
		{
                    //move the column as the value of the speed of rocky
                    for (int i = 0; i < obstacle.size(); i++)
			{
				Rectangle column = obstacle.get(i);
                                //System.out.println("asfasfas "+obstacle.get(i));
				//move the column left with the speed
                                column.x -= speed;
			}

			if (ticks % 2 == 0 && rockyY < 15)
			{
				rockyY += 2;
			}

			
                        for (int i = 0; i < obstacle.size(); i++)
			{
				Rectangle column = obstacle.get(i);

				if (column.x + column.width < 0)
				{
					obstacle.remove(column);

					if (column.y == 0)
					{
						addObstacle(false);
					}
				}
			} 


			rocky.y += rockyY;
                                                
                        //to calculate score and collision detection
			for (Rectangle column : obstacle)
			{
				if (column.y == 0 && rocky.x + rocky.width / 2 > column.x + column.width / 2 - 10 && rocky.x + rocky.width / 2 < column.x + column.width / 2 + 10)
				{
                                    //System.out.println("Score initial: "+score);
                                    score++;
                                        
                                        if(score%5==0)
                                            {
                                                speed=speed+2;
                                            }
				}

				if (column.intersects(rocky))
				{
                                                                        
                                        gameOver = true;
                                        speed=10;
					if (rocky.x <= column.x)
					{
						rocky.x = column.x - rocky.width;

					}
					else
					{
						if (column.y != 0)
						{
							rocky.y = column.y - rocky.height;
						}
						else if (rocky.y < column.height)
						{
							rocky.y = column.height;
						}
					}
				}//end of intersect
			}//end of for loop
                        
                        //if goes above or below
			if (rocky.y > HEIGHT - 120 || rocky.y < 0)
			{
				gameOver = true;
                                //reset speed to initial value 10
                                speed=10;
			}

			if (rocky.y + rockyY >= HEIGHT - 120)
			{
				rocky.y = HEIGHT - 120 - rocky.height;
				gameOver = true;
                                speed=10;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g)
	{
		Color background = new Color(179, 240, 255);
                g.setColor(background);
		g.fillRect(0, 0, WIDTH, HEIGHT);
                
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
                
		Color grass = new Color(51, 204, 51);
                g.setColor(grass);
		g.fillRect(0, HEIGHT - 120, WIDTH, 80);

		g.setColor(Color.red);
		g.fillRect(rocky.x, rocky.y, rocky.width, rocky.height);

		//paint the rectangular bars
                for (Rectangle column : obstacle)
		{
			paintObstacle(g, column);
		}

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));

		if (!begin)
		{
			g.drawString("Click to start!", 75, HEIGHT / 2 - 50);
		}

		if (gameOver)
		{
                        if(flag==true)
                        {
                            try {
                                File file = new File("Score.txt");
                                try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
                                output.newLine();
                                output.append("Score:" + score);
                                flag=false;
                            }
                            } catch ( IOException error) {
                            } 
                        }
                        g.drawString("Game Over!!!", 195, HEIGHT / 2 - 50);
                        g.setFont(new Font("Arial", 1, 50));
                        g.drawString("Click to start, Again!", 240, HEIGHT / 2 + 40);
                        g.drawString("(" + MouseInfo.getPointerInfo().getLocation().x + ", " +MouseInfo.getPointerInfo().getLocation().y + ")",800, 650);
		}

		if (!gameOver && begin)
		{
                    if(score%5==0 && score>=5)
                       {
                            g.drawString("Level Up", 195, HEIGHT / 2);
                       }
                    g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);

		}
	}
        
        //main metod
	public static void main(String[] args)
	{
		goRocky = new RockyLogic();
	}

	@Override
        //click to jump
	public void mouseClicked(MouseEvent e)
	{
		jump();
	}

	@Override
        //space to jump
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			jump();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

	}

}
