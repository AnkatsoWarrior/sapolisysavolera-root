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
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera Fr : Ce
 * fichier fait partie du projet saPolisySaVolera En : This file is part of
 * saPolisySaVolera project <br>
 * Modif. : 18 sept. 2015 Creat. : 24 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public final class SpsvConvas extends AbstractSpsvConvas {

	private static final long serialVersionUID = 726103956233099838L;

	/**
	 * procede a l'initialisation et a la preparation de tous les elements
	 * permettant au jeu d'etre fonctionnel
	 * 
	 * @see #createPlaces()
	 * @see #createPolices()
	 * @see #createThief()
	 */
	public SpsvConvas() {
		super();
		createPlaces();
		createPolices();
		createThief();
	}

	/**
	 * cree des rectangles permettant de reperer si une place peut etre occupee
	 * par une entite
	 * 
	 * @see #createRectangles(int[], int[])
	 */
	private void createPlaces() {
		places = createRectangles(X_PLACES_RECT, X_PLACES_RECT);
	}

	/**
	 * cree les policiers
	 * 
	 * @see Police
	 */
	private void createPolices() {
		polices = new ArrayList<Entity>();
		for (int i = 0; i < 3; i++) {
			Entity police = new Police();
			police.setPosition(new Point(X_DEFAULT[i], Y_DEFAULT[i]));
			polices.add(police);
		}
	}

	/**
	 * cree le voleur
	 * 
	 * @see Thief
	 */
	private void createThief() {
		thief = new Thief();
		thief.setPosition(THIEF_DEFAULT_POSITION);
	}

	/**
	 * permet de recuperer tous les entites se trouvant sous le point
	 * {@code pos}.
	 * 
	 * @param pos
	 *            le point sous lequel on veut recuperer les entites
	 * @return la liste des entites existant sous le point
	 * @see Point
	 * @see Entity
	 */
	public List<Entity> findEntities(Point pos) {
		List<Entity> foundEntities = new ArrayList<Entity>();
		for (Iterator<Entity> iter = polices.iterator(); iter.hasNext();) {
			Entity next = iter.next();
			if (next.getRectangle().contains(pos)) {
				foundEntities.add(next);
			}
		}
		return foundEntities;
	}

	/**
	 * permet de savoir si une entite est seule a cet emplacement ou non. Dans
	 * le cas ou l'entite n'est pas seule a l'emplacement actuel, il faut
	 * absolument le remettre a son ancien emplacement.
	 * 
	 * @param entity
	 *            l'entite dont on veut savoir si elle est seule a son
	 *            emplacement actuel
	 * @return true si l'entite {@code entity} est seule a son emplacement
	 *         actuel
	 * @see Entity
	 * @see #isNotAlone(Entity)
	 */
	public boolean isAlone(Entity entity) {
		final Rectangle rect = entity.getRectangle();
		if (thief.getRectangle().intersects(rect)) {
			return false;
		}
		for (Iterator<Entity> iter = polices.iterator(); iter.hasNext();) {
			Entity current = iter.next();
			if (current.equals(entity)) {
				continue;
			}
			if (current.getRectangle().intersects(rect)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * permet de savoir si une entite n'est pas seule a cet emplacement ou non.
	 * Dans le cas ou l'entite n'est pas seule a l'emplacement actuel, il faut
	 * absolument le remettre a son ancien emplacement.
	 * 
	 * @param entity
	 *            l'entite dont on veut savoir si elle n'est pas seule a son
	 *            emplacement actuel
	 * @return true si l'entite {@code entity} n'est pas seule a son emplacement
	 *         actuel
	 * @see Entity
	 * @see #isAlone(Entity)
	 */
	public boolean isNotAlone(Entity entity) {
		return !isAlone(entity);
	}

	/**
	 * cree un {@code java.awt.Rectangle} a partir d'un point.
	 * 
	 * @param center
	 *            le centre du rectangle a creer
	 * @return le rectangle dont le centre est passe en parametre et le longeur
	 *         et le largeur correspondent a ceux des objets {@code Entity}
	 * @see Entity
	 * @see #createRectangles(int[], int[])
	 */
	private Rectangle createRectangle(Point center) {
		return new Rectangle(center.x - Entity.DEFAULT_WIDTH / 2, center.y
				- Entity.DEFAULT_HEIGHT / 2, Entity.DEFAULT_WIDTH,
				Entity.DEFAULT_HEIGHT);

	}

	/**
	 * cree un ensemble de rectangles a partir d'un ensemble d'abscisses et
	 * d'ordonnees de points
	 * 
	 * @param xPos
	 *            un ensemble d'abscisses de points
	 * @param yPos
	 *            un ensemble d'ordonnees de points
	 * @return un ensemble de rectangles
	 * @see #createRectangle(Point)
	 */
	private Rectangle[] createRectangles(int[] xPos, int[] yPos) {
		Rectangle[] rectangles = new Rectangle[xPos.length];
		for (int i = 0; i < rectangles.length; i++) {
			rectangles[i] = createRectangle(new Point(xPos[i], yPos[i]));
		}
		return rectangles;
	}

	/**
	 * retourne une position si possible relative a l'emplacement actuel de
	 * l'entite passee en parametre
	 * 
	 * @param entity
	 *            l'entite dont la position est a tester
	 * @return une instance de {@code Point} si une position est possible a
	 *         l'emplacement actuel de l'entite. retourne {@code null} sinon.
	 * @see Entity
	 */
	public Point getPlaceIfExists(Entity entity) {
		Rectangle entityRect = entity.getRectangle();
		for (Rectangle currentRect : places) {
			if (currentRect.intersects(entityRect)) {
				return entity.getPosition();
			}
		}
		return null;
	}

	/**
	 * dessine l'ensemble des elements du jeu
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D drawer = (Graphics2D) g;
		drawScene(drawer);
		drawEntities(drawer);
	}

	/**
	 * dessine l'ensemble des entites actifs du jeu
	 * 
	 * @param drawer
	 *            un objet dessinateur
	 * @see Graphics2D
	 */
	private void drawEntities(Graphics2D drawer) {
		for (Iterator<Entity> police = polices.iterator(); police.hasNext();) {
			police.next().draw(drawer);
		}
		thief.draw(drawer);
	}

	/**
	 * dessine la scene principale du jeu.
	 * 
	 * @param drawer
	 *            un objet dessinateur
	 * @see Graphics2D
	 */
	private void drawScene(Graphics2D drawer) {
		// memorise la couleur utilisee par defaut
		// en vue d'une restitution
		Color lastColor = drawer.getColor();
		drawer.setColor(CANVAS_BACKGROUND);
		// dessine le background de la scene principale
		drawer.fillRect(0, 0, getWidth(), getHeight());
		drawer.setStroke(new BasicStroke(2));
		// dessine la scend du jeu a partir d'ici
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
		// restitue la couleur utilisee par defaut
		drawer.setColor(lastColor);
	}

}
