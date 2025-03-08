package pl.majkus522;

import java.util.Arrays;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		MachineController.init();
		List<String> input = Arrays.asList("write =1", "halt", "wrte =2");
		MachineController.inputTape = Arrays.asList(2, 3);

		MachineController.runProgram(input);
	}
}