package org.wpattern.frameworks.javafx.arduino.utils;

import org.controlsfx.dialog.Dialogs;

public final class JavaFXUtils {

	private JavaFXUtils() {
	}

	public static void showDialog(String title, String head, String message) {
		Dialogs.create().title(title).masthead(head).message(message).showInformation();
	}

}
