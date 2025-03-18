package pl.majkus522.rammachine;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;
import pl.majkus522.rammachine.gui.GuiApplication;
import pl.majkus522.rammachine.instructions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MachineController
{
	static List<BaseInstruction> instructions = new ArrayList<>();
	static HashMap<String, FunctionReference<String, BaseInstruction>> interpreter = new HashMap<>();
	static List<Integer> inputTape = new ArrayList<>();
	static List<Integer> outputTape = new ArrayList<>();
	static List<Integer> registries = new ArrayList<>();
	static HashMap<String, Integer> labels = new HashMap<>();
	static int lineIndex;
	static int inputAddr = -1;

	public static void init()
	{
		interpreter.put("load", LoadInstruction::new);
		interpreter.put("store", StoreInstruction::new);
		interpreter.put("add", AddInstruction::new);
		interpreter.put("sub", SubInstruction::new);
		interpreter.put("mult", MultInstruction::new);
		interpreter.put("div", DivInstruction::new);
		interpreter.put("read", ReadInstruction::new);
		interpreter.put("write", WriteInstruction::new);
		interpreter.put("jump", JumpInstruction::new);
		interpreter.put("jzero", JzeroInstruction::new);
		interpreter.put("jgtz", JgtzInstruction::new);
		interpreter.put("halt", HaltInstruction::new);
	}

	public static void data(List<Integer> tape)
	{
		inputTape = tape;
		registries = new ArrayList<>();
		labels = new HashMap<>();
		instructions = new ArrayList<>();
		inputAddr = -1;
		lineIndex = 0;
		outputTape = new ArrayList<>();
	}

	public static void runAll(List<String> input)
	{
		try
		{
			// TODO: add commnets
			for (String line : input)
			{
				line = line.trim();
				if (line.length() == 0)
					continue;
				String[] split = line.split(":");
				if (split.length > 2)
					throw new InterpreterError("Illegal use of ':'");
				else if (split.length == 2)
				{
					labels.put(split[0].trim(), lineIndex);
					line = split[1].trim();
				}
				int index = line.indexOf(" ");
				if (index < 0)
					index = line.length();

				//TODO: fix null pointer exception
				try
				{
					instructions.add(interpreter.get(line.substring(0, index).toLowerCase()).apply(line.substring(index).trim()));
				}
				catch (NullPointerException e)
				{
					throw new InterpreterError("Unknown command");
				}
				lineIndex++;
			}
			for (lineIndex = 0; lineIndex < instructions.size(); lineIndex++)
			{
				if (lineIndex < 0)
					break;
				instructions.get(lineIndex).execute();
			}
			GuiApplication.getController().display(registries, outputTape);
		}
		catch (RuntimeError | InterpreterError e)
		{
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Text text = new Text(e.getMessage());
			text.setTextAlignment(TextAlignment.CENTER);
			Button button = new Button("Ok");
			button.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent mouseEvent)
				{
					dialogStage.close();
				}
			});
			VBox vbox = new VBox(text, button);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(15, 50, 15, 50));
			vbox.setSpacing(10);
			dialogStage.setScene(new Scene(vbox));
			dialogStage.show();
		}
	}

	public static int readInput() throws RuntimeError
	{
		inputAddr++;
		if (inputAddr >= inputTape.size())
			throw new RuntimeError("Input tape ended");
		return inputTape.get(inputAddr);
	}

	public static int getRegistry(int addr) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lower than 0");
		if (addr >= registries.size())
			return 0;
		return registries.get(addr);
	}

	public static void setRegistry(int addr, int value) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lower than 0");
		while (registries.size() < addr + 1)
			registries.add(0);
		registries.set(addr, value);
	}

	public static void writeOutput(int value)
	{
		outputTape.add(value);
	}

	public static int getLineIndex()
	{
		return lineIndex;
	}

	public static void goTo(String label)
	{
		lineIndex = labels.get(label) - 1;
	}
}