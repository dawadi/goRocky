/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorocky;
/**
 *
 * @author dawadi
 */

import static gorocky.FlappyBird.goRocky;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		FlappyBird.goRocky.repaint(g);
	}
	
}

