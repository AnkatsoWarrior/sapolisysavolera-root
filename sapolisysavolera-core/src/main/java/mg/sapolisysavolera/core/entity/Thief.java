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
public class Thief extends Entity {
	private static final long serialVersionUID = 6215857836744340808L;

	private static final Color THIEF_BACKGROUND_COLOR = Color.RED;

	public Thief() {
		super();
		background = THIEF_BACKGROUND_COLOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics2D drawer) {
		Color lastColor = drawer.getColor();

		drawer.setColor(background);
		drawer.fillOval(rectangle.x, rectangle.y, rectangle.width,
				rectangle.height);

		drawer.setColor(foreground);
		drawer.drawOval(rectangle.x, rectangle.y, rectangle.width,
				rectangle.height);

		drawer.setColor(lastColor);

	}

}
