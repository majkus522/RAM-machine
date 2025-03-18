package pl.majkus522.rammachine.gui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.majkus522.rammachine.MachineController;

import java.util.ArrayList;
import java.util.List;

public class GuiController
{
	@FXML
	protected FlowPane inputTape;
	@FXML
	protected FlowPane outputTape;
	@FXML
	protected TextArea textArea;
	@FXML
	protected VBox registries;

	@FXML
	protected void onPlayButton()
	{
		List<Integer> input = new ArrayList<>();
		for (Node node : inputTape.getChildren())
		{
			input.add(((IntField)node).getValue());
		}
		MachineController.runProgram(textArea.getParagraphs().stream().map(v -> v.toString()).toList(), input);
	}

	@FXML
	protected void onStepButton()
	{
		System.out.println("stop");
	}

	@FXML
	protected void onStopButton()
	{
		System.out.println("stop");
	}

	@FXML
	protected void onAddInput()
	{
		IntField input = new IntField();
		input.setPrefWidth(60);
		inputTape.getChildren().add(input);
	}

	@FXML
	protected void onRemoveInput()
	{
		if (!inputTape.getChildren().isEmpty())
			inputTape.getChildren().removeLast();
	}

	public void display()
	{
		List<Node> children = registries.getChildren();
		children.clear();
		List<Integer> registries = MachineController.getRegistries();
		for (int index = 0; index < registries.size(); index++)
		{
			HBox parent = new HBox();
			parent.setAlignment(Pos.CENTER);
			parent.setSpacing(10);
			Label label = new Label();
			label.setText("Registry " + index);
			parent.getChildren().add(label);
			IntField value = new IntField();
			value.setValue(registries.get(index));
			value.setPrefWidth(60);
			value.setEditable(false);
			parent.getChildren().add(value);
			children.add(parent);
		}
	}
}