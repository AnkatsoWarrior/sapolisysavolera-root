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
package mg.sapolisysavolera.core.threads;

import java.awt.Point;

import mg.sapolisysavolera.core.entity.Thief;

/**
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 25 sept. 2015
 * Creat. : 25 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public class ThiefMover implements Runnable {
	
	private Thief thief;
	
	private Point startPos;
	
	private Point endPos;

	/**
	 * @param thief
	 */
	public ThiefMover(Thief thief) {
		super();
		this.thief = thief;
	}



	/**
	 * @return the startPos
	 */
	public Point getStartPos() {
		return startPos;
	}



	/**
	 * @param startPos the startPos to set
	 */
	public void setStartPos(Point startPos) {
		this.startPos = startPos;
	}



	/**
	 * @return the endPos
	 */
	public Point getEndPos() {
		return endPos;
	}



	/**
	 * @param endPos the endPos to set
	 */
	public void setEndPos(Point endPos) {
		this.endPos = endPos;
	}



	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// not ready yet ..
	}

}
