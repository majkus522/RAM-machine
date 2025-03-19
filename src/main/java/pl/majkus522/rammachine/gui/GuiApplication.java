package pl.majkus522.rammachine.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiApplication extends Application
{
	static GuiController controller;

	public static void start()
	{
		launch();
	}

	public static GuiController getController()
	{
		return controller;
	}

	@Override
	public void start(Stage stage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(GuiApplication.class.getResource("gui-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		controller = fxmlLoader.getController();
		stage.setTitle("RAM Machine");
		stage.setScene(scene);
		stage.setMinWidth(940);
		stage.setMinHeight(480);
		stage.show();
	}
}