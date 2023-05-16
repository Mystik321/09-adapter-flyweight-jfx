package ohm.softa.a09.model.Factory;
import javafx.scene.image.Image;
import ohm.softa.a09.resource.ResourceLoader;

import java.io.File;

public class Flyweight {
	private Image image;
	private final ResourceLoader<Image> imageResourceLoader;

	{
		imageResourceLoader = new ResourceLoader<>(Image::new);
	}

	Flyweight(String path) {
		try {
			image = imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), path);
			File file = new File(getClass().getClassLoader().getResource(path).toURI());
		}
		catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
	}

	public Image getImage() {
		return image;
	}
}
