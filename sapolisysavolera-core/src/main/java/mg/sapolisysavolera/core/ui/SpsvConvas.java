/*
 * This game is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see <http://www.gnu.org/licenses/>.
 */
package mg.sapolisysavolera.core.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import mg.sapolisysavolera.core.entity.Entity;
import mg.sapolisysavolera.core.entity.Police;
import mg.sapolisysavolera.core.entity.Thief;

/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 18 sept. 2015
 * Creat. : 18 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public final class SpsvConvas extends JPanel {

	private static final Color CANVAS_FOREGROUND = Color.BLACK;
	
	private static final long serialVersionUID = 4096604472823617894L;
	
	private List<Entity> polices;
	private Entity thief;

	/**
	 * constructeur 
	 */
	public SpsvConvas() {
		super();
		createThief();
		createPolices();
	}

	/**
	 * creation des policiers 
	 */
	private void createPolices() {
		polices = new ArrayList<Entity>();
		int[] xPos = new int[] {
				250, 750, 500
		};
		int[] yPos = new int[] {
				500, 500, 750
		};
		for(int i=0; i < 3; i++) {
			Entity police = new Police();
			police.setPosition(new Point(xPos[i], yPos[i]));
			polices.add(police);
		}
	}

	/**
	 * creation du voleur 
	 */
	private void createThief() {
		thief = new Thief();
		Point thiefPos = new Point(500, 500);
		thief.setPosition(thiefPos);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D drawer = (Graphics2D) g;
		drawScene(drawer);
		drawEntities(drawer);
	}

	/**
	 * dessine les entites 
	 * 
	 * @param drawer
	 */
	private void drawEntities(Graphics2D drawer) {
		// dessiner les policiers 
		for(Iterator<Entity> police = polices.iterator(); police.hasNext();) {
			police.next().draw(drawer);
		}
		// dessiner le voleur 
		thief.draw(drawer);
	}

	/**
	 * @param drawer
	 */
	private void drawScene(Graphics2D drawer) {
		Color lastColor = drawer.getColor();
		drawer.setColor(CANVAS_FOREGROUND);
		drawer.drawOval(250, 250, 500, 500);
		drawer.setColor(lastColor);
	}

	
}
