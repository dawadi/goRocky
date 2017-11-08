package gorocky;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class RockyLogic implements ActionListener, MouseListener, KeyListener
{

	public static RockyLogic goRocky;

	public final int WIDTH = 800, HEIGHT = 600;

	public Renderer renderer;

	public Rectangle rocky;
        
        //public ImageIcon rocky;
        
	public ArrayList<Rectangle> columns;

	public int ticks, yMotion, score;

	public boolean gameOver, started;

	public Random rand;

	public RockyLogic()
	{
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("goRocky");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		rocky = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
                // = new ImageIcon(getClass().getResource("rocky.png"));
		columns = new ArrayList<Rectangle>();

		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);

		timer.start();
	}

	public void addColumn(boolean start)
	{
		int space = 250;
		int width = 50;
		int height = 50 + rand.nextInt(300);

		if (start)
		{
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else
		{
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}
        
        //paints the obstacle
	public void paintColumn(Graphics g, Rectangle column)
	{
                Color purple = new Color(140, 26, 255);
                g.setColor(purple);
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void jump()
	{
		if (gameOver)
		{
                    rocky = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
                    // = new ImageIcon(getClass().getResource("rocky.png"));
                    columns.clear();
			yMotion = 0;
			score = 0;

			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);

			gameOver = false;
		}

		if (!started)
		{
			started = true;
		}
		else if (!gameOver)
		{
			if (yMotion > 0)
			{
				yMotion = 0;
			}

			yMotion -= 10;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int speed = 10;

		ticks++;

		if (started)
		{
			for (int i = 0; i < columns.size(); i++)
			{
				Rectangle column = columns.get(i);

				column.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15)
			{
				yMotion += 2;
			}

			for (int i = 0; i < columns.size(); i++)
			{
				Rectangle column = columns.get(i);

				if (column.x + column.width < 0)
				{
					columns.remove(column);

					if (column.y == 0)
					{
						addColumn(false);
					}
				}
			}

			rocky.y += yMotion;

			for (Rectangle column : columns)
			{
				if (column.y == 0 && rocky.x + rocky.width / 2 > column.x + column.width / 2 - 10 && rocky.x + rocky.width / 2 < column.x + column.width / 2 + 10)
				{
					score++;
				}

				if (column.intersects(rocky))
				{
					gameOver = true;

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
				}
			}

			if (rocky.y > HEIGHT - 120 || rocky.y < 0)
			{
				gameOver = true;
			}

			if (rocky.y + yMotion >= HEIGHT - 120)
			{
				rocky.y = HEIGHT - 120 - rocky.height;
				gameOver = true;
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

		for (Rectangle column : columns)
		{
			paintColumn(g, column);
		}

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));

		if (!started)
		{
			g.drawString("Click to start!", 75, HEIGHT / 2 - 50);
		}

		if (gameOver)
		{
			g.drawString("Game Over!!!", 100, HEIGHT / 2 - 50);
		}

		if (!gameOver && started)
		{
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
