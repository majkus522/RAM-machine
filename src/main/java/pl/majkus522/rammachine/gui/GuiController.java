package pl.majkus522.rammachine.gui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
	protected Button stopButton;
	@FXML
	protected Label programCounter;

	boolean stepByStep = false;

	@FXML
	protected void onPlayButton()
	{
		if (!stepByStep)
		{
			List<Integer> input = new ArrayList<>();
			for (Node node : inputTape.getChildren())
			{
				input.add(((IntField) node).getValue());
			}
			MachineController.passData(textArea.getParagraphs().stream().map(CharSequence::toString).toList(), input);
		}
		MachineController.runAll();
		stepByStep = false;
		stopButton.setDisable(true);
	}

	@FXML
	protected void onStepButton()
	{
		if (!stepByStep)
		{
			List<Integer> input = new ArrayList<>();
			for (Node node : inputTape.getChildren())
			{
				input.add(((IntField) node).getValue());
			}
			MachineController.passData(textArea.getParagraphs().stream().map(CharSequence::toString).toList(), input);
		}
		MachineController.runStep();
		stepByStep = true;
		stopButton.setDisable(false);
	}

	@FXML
	protected void onStopButton()
	{
		stopButton.setDisable(true);
		stepByStep = false;
	}

	@FXML
	protected void onAddInput()
	{
		IntField input = new IntField(0);
		input.setPrefWidth(60);
		inputTape.getChildren().add(input);
	}

	@FXML
	protected void onRemoveInput()
	{
		if (!inputTape.getChildren().isEmpty())
			inputTape.getChildren().removeLast();
	}

	public void display(List<Integer> registries, List<Integer> output)
	{
		List<Node> regChildren = this.registries.getChildren();
		List<Node> outputChildren = this.outputTape.getChildren();
		regChildren.clear();
		outputChildren.clear();
		for (int index = 0; index < registries.size(); index++)
		{
			HBox parent = new HBox();
			parent.setAlignment(Pos.CENTER);
			parent.setSpacing(10);
			Label label = new Label();
			label.setText("Rejestr " + index);
			parent.getChildren().add(label);
			IntField value = new IntField(registries.get(index));
			value.setPrefWidth(60);
			value.setEditable(false);
			parent.getChildren().add(value);
			regChildren.add(parent);
		}
		for (int value : output)
		{
			IntField field = new IntField(value);
			field.setPrefWidth(60);
			field.setEditable(false);
			outputChildren.add(field);
		}
		stopButton.setDisable(false);
	}

	public void setPC(int index)
	{
		programCounter.setText("\t" + index);
	}

	public void stopPC()
	{
		programCounter.setText("");
	}
}