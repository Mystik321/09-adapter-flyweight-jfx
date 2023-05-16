package ohm.softa.a09.model.Factory;

import ohm.softa.a09.model.Fighter;
import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
	private final FlyweightFactory flyweightFactory;

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		flyweightFactory = new FlyweightFactory();
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() {
		switch (random.nextInt(NumberOfKnownFighterTypes)) {
			case 0:
				return new AWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/awing.jpg").getImage());
			case 1:
				return new XWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/xwing.jpg").getImage());
			case 2:
				return new YWing(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/ywing.jpg").getImage());
			case 3:
				return new TieBomber(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tiebomber.jpg").getImage());
			case 4:
				return new TieFighter(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tiefighter.jpg").getImage());
			default:
				return new TieInterceptor(nameGenerator.generateName(), flyweightFactory.getFlyweight("fighter/tieinterceptor.jpg").getImage());
		}
	}
}
