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

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import mg.sapolisysavolera.core.events.SpsvMouseEventListener;

/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 19 sept. 2015
 * Creat. : 19 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public final class SpsvFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6403606822072388287L;
	
	private SpsvConvas canvas;

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public SpsvFrame(String title) throws HeadlessException {
		super(title);
		setSize(new Dimension(1000, 1000));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new SpsvConvas();
		new SpsvMouseEventListener(canvas);
		getContentPane().add(canvas);
		
	}

	
}
