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
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

import mg.sapolisysavolera.core.entity.Entity;
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
public abstract class AbstractSpsvConvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The default position of the Thief
	protected static final Point THIEF_DEFAULT_POSITION = new Point(500, 500);

	// The default positions of the polices
	protected static int[] X_DEFAULT = new int[] { 300, 700, 500 };
	protected static int[] Y_DEFAULT = new int[] { 500, 500, 700 };

	// The default canvas forground color
	protected static final Color CANVAS_FOREGROUND = Color.BLACK;

	protected static final Color CANVAS_BACKGROUND = Color.WHITE;

	protected List<Entity> polices;

	protected Entity thief;
	
	protected Rectangle[] places;
	
	protected static int[] X_PLACES_RECT = new int[] {
		500
	};

	protected static int[] Y_PLACES_RECT = new int[] {
		500
	};
}
