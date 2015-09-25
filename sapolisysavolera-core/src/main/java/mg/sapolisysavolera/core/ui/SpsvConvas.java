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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mg.sapolisysavolera.core.entity.Entity;
import mg.sapolisysavolera.core.entity.Police;
import mg.sapolisysavolera.core.entity.Thief;
/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 18 sept. 2015
 * Creat. : 24 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public final class SpsvConvas extends AbstractSpsvConvas {
	
	private static final long serialVersionUID = 726103956233099838L;

	public SpsvConvas() {
		super();
		createPolices();
		createThief();
	}

	private void createPolices() {
		polices = new ArrayList<Entity>();
		for (int i = 0; i < 3; i++) {
			Entity police = new Police();
			police.setPosition(new Point(X_DEFAULT[i], Y_DEFAULT[i]));
			polices.add(police);
		}
	}

	private void createThief() {
		thief = new Thief();
		thief.setPosition(THIEF_DEFAULT_POSITION);
	}
	
	public List<Entity> findEntities(Point pos) {
		List<Entity> foundEntities = new ArrayList<Entity>();
		for(Iterator<Entity> iter = polices.iterator(); iter.hasNext();) {
			Entity next = iter.next();
			if(next.getRectangle().contains(pos)) {
				foundEntities.add(next);
			}
		}
		return foundEntities;
	}
	
	public boolean isAlone(Entity entity) {
		final Rectangle rect = entity.getRectangle();
		if(thief.getRectangle().intersects(rect)) {
			return false;
		}
		for(Iterator<Entity> iter = polices.iterator(); iter.hasNext();) {
			Entity current = iter.next();
			if(current.equals(entity)) {
				continue;
			}
			if(current.getRectangle().intersects(rect)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isNotAlone(Entity entity) {
		return !isAlone(entity);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D drawer = (Graphics2D) g;
		drawScene(drawer);
		drawEntities(drawer);
	}

	
	private void drawEntities(Graphics2D drawer) {
		for (Iterator<Entity> police = polices.iterator(); police.hasNext();) {
			police.next().draw(drawer);
		}
		thief.draw(drawer);
	}

	
	private void drawScene(Graphics2D drawer) {
		Color lastColor = drawer.getColor();
		
		drawer.setColor(CANVAS_BACKGROUND);
		drawer.fillRect(0, 0, getWidth(), getHeight());
		
		
		drawer.setStroke(new BasicStroke(2));
		
		drawer.setColor(CANVAS_FOREGROUND);
		drawer.drawOval(100, 100, 800, 800);
		
		drawer.drawOval(300, 300, 400, 400);
		
		drawer.drawOval(400, 400, 200, 200);
		
		drawer.drawArc(0, 400, 200, 200, 0, 82);
		
		drawer.drawArc(0, 400, 200, 200, 0, -82);
		
		drawer.drawArc(800, 400, 200, 200, 98, 164);
		
		drawer.drawArc(400, 0, 200, 200, -8, -164);
		
		drawer.drawArc(400, 800, 200, 200, 8, 164);
		
		drawer.drawLine(100, 500, 900, 500);
		drawer.drawLine(500, 100, 500, 900);
		drawer.setColor(lastColor);
	}

}
