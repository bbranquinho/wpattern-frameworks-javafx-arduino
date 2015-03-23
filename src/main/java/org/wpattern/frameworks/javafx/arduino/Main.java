package org.wpattern.frameworks.javafx.arduino;

import javafx.application.Application;
import javafx.stage.Stage;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wpattern.frameworks.javafx.arduino.configs.ScreensConfiguration;

/**
 * Example of applications using JavaFX, Spring, Spring Data JPA, Hibernate, Arduino and others frameworks.
 *
 * Thanks Marco Jakob for tutorial: http://code.makery.ch/library/javafx-8-tutorial/
 *
 * @author Augusto
 */
public class Main extends Application {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("resource")
	@Override
	public void start(Stage stage) throws Exception {
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(ScreensConfiguration.class);
			ScreensConfiguration screens = context.getBean(ScreensConfiguration.class);
			screens.setPrimaryStage(stage);
			screens.show();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			System.exit(-1);
		}
	}

}
