package pl.majkus522;

import java.util.Arrays;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		MachineController.init();
		List<String> input = Arrays.asList("read 1", "read 2", "load 1", "add 2", "write 0", "halt");
		MachineController.inputTape = Arrays.asList(2, 3);
		MachineController.runProgram(input);
	}
}