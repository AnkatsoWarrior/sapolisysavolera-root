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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import mg.sapolisysavolera.core.entity.Entity;
import mg.sapolisysavolera.core.entity.Place;
/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 24 sept. 2015
 * Creat. : 25 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public abstract class AbstractSpsvConvas extends JPanel {
	
	protected static final Point THIEF_DEFAULT_POSITION = new Point(500, 500);

	protected static final int[] X_DEFAULT = new int[] { 400, 600, 500 };
	
	protected static final int[] Y_DEFAULT = new int[] { 500, 500, 600 };

	protected static final Color CANVAS_FOREGROUND = Color.BLACK;

	protected static final Color CANVAS_BACKGROUND = Color.WHITE; //new Color(222,243,250);
	
	protected static final Color SCENE_BACKGROUND_COLOR = new Color(222,243,250);// new Color(229,250,222);

	protected static final Color PLACES_DEFAULT_COLOR = Color.LIGHT_GRAY;
	
	protected static final Color PLACES_BACKGROUND_COLOR = new Color(230,245,250);
	
	private static final long serialVersionUID = -4126768433495721928L;

	protected List<Entity> polices;

	protected Entity thief;
	
	protected String message = "Attrappez le !";

	protected Place[] places;
	
	protected int movementsNumber = 0;

	protected static final int[] X_PLACES_RECT = new int[] { 100, 200, 300,
			400, 600, 700, 800, 900, 500, 500, 500, 500, 500, 500, 500, 500,
			108, 108, 400, 400, 600, 600, 892, 892, 500 };

	protected static final int[] Y_PLACES_RECT = new int[] { 500, 500, 500,
			500, 500, 500, 500, 500, 100, 200, 300, 400, 600, 700, 800, 900,
			400, 600, 108, 892, 108, 892, 400, 600, 500 };

	protected static final int[] PLACES_ID = new int[] { 1, 2, 3, 4, 5, 6, 7,
			8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
			25 };
	
	protected static final int[] CENTER_PLACES_ID = new int[] {
			3, 4, 25, 5, 6, 11, 12, 13, 14
	};

	protected static Map<Integer, List<Integer>> PLACES_MAP = new HashMap<Integer, List<Integer>>();
	static {

		PLACES_MAP.put(new Integer(1),
				Arrays.asList(new Integer[] { 2, 17, 18 }));
		PLACES_MAP.put(new Integer(2),
				Arrays.asList(new Integer[] { 1, 3, 17, 18 }));
		PLACES_MAP.put(new Integer(3),
				Arrays.asList(new Integer[] { 2, 4, 11, 14 }));
		PLACES_MAP.put(new Integer(4),
				Arrays.asList(new Integer[] { 3, 25, 12, 13 }));
		PLACES_MAP.put(new Integer(5),
				Arrays.asList(new Integer[] { 6, 25, 12, 13 }));
		PLACES_MAP.put(new Integer(6),
				Arrays.asList(new Integer[] { 5, 7, 11, 14 }));
		PLACES_MAP.put(new Integer(7),
				Arrays.asList(new Integer[] { 6, 8, 23, 24 }));
		PLACES_MAP.put(new Integer(8),
				Arrays.asList(new Integer[] { 7, 23, 24 }));
		PLACES_MAP.put(new Integer(9),
				Arrays.asList(new Integer[] { 19, 21, 10 }));
		PLACES_MAP.put(new Integer(10),
				Arrays.asList(new Integer[] { 9, 11, 19, 21 }));
		PLACES_MAP.put(new Integer(11),
				Arrays.asList(new Integer[] { 10, 12, 3, 6 }));
		PLACES_MAP.put(new Integer(12),
				Arrays.asList(new Integer[] { 4, 5, 11, 25 }));
		PLACES_MAP.put(new Integer(13),
				Arrays.asList(new Integer[] { 4, 5, 14, 25 }));
		PLACES_MAP.put(new Integer(14),
				Arrays.asList(new Integer[] { 3, 6, 13, 15 }));
		PLACES_MAP.put(new Integer(15),
				Arrays.asList(new Integer[] { 14, 16, 20, 22 }));
		PLACES_MAP.put(new Integer(16),
				Arrays.asList(new Integer[] { 20, 22, 15 }));
		PLACES_MAP.put(new Integer(17),
				Arrays.asList(new Integer[] { 1, 2, 19 }));
		PLACES_MAP.put(new Integer(18),
				Arrays.asList(new Integer[] { 1, 2, 20 }));
		PLACES_MAP.put(new Integer(19),
				Arrays.asList(new Integer[] { 9, 10, 17 }));
		PLACES_MAP.put(new Integer(20),
				Arrays.asList(new Integer[] { 15, 16, 18 }));
		PLACES_MAP.put(new Integer(21),
				Arrays.asList(new Integer[] { 9, 10, 23 }));
		PLACES_MAP.put(new Integer(22),
				Arrays.asList(new Integer[] { 15, 16, 24 }));
		PLACES_MAP.put(new Integer(23),
				Arrays.asList(new Integer[] { 7, 8, 21 }));
		PLACES_MAP.put(new Integer(24),
				Arrays.asList(new Integer[] { 7, 8, 22 }));
		PLACES_MAP.put(new Integer(25),
				Arrays.asList(new Integer[] { 4, 5, 12, 13 }));

	}
}
