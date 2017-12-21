package com.pz.gym;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymApplication extends AbstractJavaFxApplicationSupport {




	public static void main(String[] args) {
		launchApp(GymApplication.class, Gym.class, args);

	}
	@Override
	public void start(Stage stage) throws Exception{
		super.start(stage);
	}
}
