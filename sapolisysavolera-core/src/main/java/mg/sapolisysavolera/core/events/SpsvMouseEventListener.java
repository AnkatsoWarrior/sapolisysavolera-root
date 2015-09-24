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
package mg.sapolisysavolera.core.events;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import mg.sapolisysavolera.core.entity.Entity;
import mg.sapolisysavolera.core.ui.SpsvConvas;

/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 24 sept. 2015
 * Creat. : 24 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public class SpsvMouseEventListener extends MouseAdapter implements MouseMotionListener {

	private SpsvConvas canvas;
	
	private Entity selectedEntity;

	private Point lastPos;
	
	/**
	 * @param canvas
	 */
	public SpsvMouseEventListener(SpsvConvas canvas) {
		super();
		this.canvas = canvas;
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		List<Entity> foundEntities = canvas.findEntities(e.getPoint());
		if(!foundEntities.isEmpty()) {
			selectedEntity = foundEntities.get(0);
			lastPos = (Point) selectedEntity.getPosition().clone();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(selectedEntity != null) {
			if(canvas.isNotAlone(selectedEntity) && lastPos != null) {
				selectedEntity.setPosition(lastPos);
				canvas.repaint();
			}
			selectedEntity = null;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(selectedEntity != null) {
			selectedEntity.setPosition(e.getPoint());
			canvas.invalidate();
			canvas.repaint();
		}
	}

	
	

}
