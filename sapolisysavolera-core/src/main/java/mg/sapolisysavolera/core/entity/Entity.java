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
package mg.sapolisysavolera.core.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

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
public abstract class Entity implements Movable, Serializable {
	
	private static final long serialVersionUID = 8397003303413422425L;

	protected static final int DEFAULT_HEIGHT= 50;
	
	protected static final int DEFAULT_WIDTH = 50;
	
	protected static final Color DEFAULT_FOREGROUND_COLOR = Color.GRAY;
	
	protected static final Color DEFAULT_BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	protected Rectangle rectangle;
	
	protected Color foreground;
	
	protected Color background;
	
	protected int id;
	
	private static int idGenerator;
	
	/**
	 * constructeur
	 */
	public Entity() {
		super();
		rectangle = new Rectangle(0,0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		foreground = DEFAULT_FOREGROUND_COLOR;
		background = DEFAULT_BACKGROUND_COLOR;
		id = ++idGenerator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPosition(Point position) {
		rectangle.x = position.x - rectangle.width / 2;
		rectangle.y = position.y - rectangle.height / 2;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point getPosition() {
		Point position = new Point();
		position.x = rectangle.x + rectangle.width / 2;
		position.y = rectangle.y + rectangle.height / 2;
		return position;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getRectangle() {
		return (Rectangle) rectangle.clone();
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

	/**
	 * @return the foreground
	 */
	public Color getForeground() {
		return foreground;
	}

	/**
	 * @param foreground the foreground to set
	 */
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	/**
	 * @return the background
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(Color background) {
		this.background = background;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void draw(Graphics2D drawer);
	
	
}
