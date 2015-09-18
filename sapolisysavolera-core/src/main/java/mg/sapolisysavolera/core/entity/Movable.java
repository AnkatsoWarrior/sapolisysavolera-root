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

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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
public interface Movable {
	/**
	 * change la position de l'element
	 * 
	 * @param position
	 *            la nouvelle position de l'element
	 */
	void setPosition(Point position);

	/**
	 * recupere la position de l'element
	 * 
	 * @return la position actuelle de l'element
	 */
	Point getPosition();

	/**
	 * dessine l'element
	 * 
	 * @param drawer
	 *            objet dessinateur utilise pour dessiner l'element
	 */
	void draw(Graphics2D drawer);

	/**
	 * recupere le rectangle correspondant a l'element
	 * 
	 * @return le rectangle correspondant a l'element
	 */
	Rectangle getRectangle();

}
