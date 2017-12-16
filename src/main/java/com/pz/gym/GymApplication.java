package com.pz.gym;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launchApp(GymApplication.class, GymView.class, args);
	}
}
