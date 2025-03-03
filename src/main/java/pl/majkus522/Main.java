package pl.majkus522;

import pl.majkus522.error.RuntimeError;
import pl.majkus522.instructions.BaseInstruction;
import pl.majkus522.instructions.HaltInstruction;
import pl.majkus522.instructions.ReadInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Main
{
	static ArrayList<BaseInstruction> instructions = new ArrayList<>();
	static HashMap<String, Function<String, BaseInstruction>> interpreter = new HashMap<>();
	static ArrayList<Integer> inputTape = new ArrayList<Integer>();
	static ArrayList<Integer> outputTape = new ArrayList<Integer>();
	static ArrayList<Integer> registries = new ArrayList<Integer>();
	static int line;
	static int inputAddr = -1;

	public static void main(String[] args)
	{
		interpreter.put("read", ReadInstruction::new);
		interpreter.put("halt", HaltInstruction::new);

		List<String> input = new ArrayList<>();
		input.add("read 1");
		input.add("halt");
		runProgram(input);
	}

	static void runProgram(List<String> input)
	{
		try
		{
			for (String line : input)
			{
				line = line.trim();
				int index = line.indexOf(" ");
				if (index < 0)
					index = line.length();
				instructions.add(interpreter.get(line.substring(0, index).toLowerCase()).apply(line.substring(index).trim()));
			}
			for (line = 0; line < instructions.size(); line++)
			{
				instructions.get(line).execute();
			}
			setRegistry(2, 2);
			System.out.println(registries);
		}
		catch (RuntimeError e)
		{
			e.printStackTrace();
		}
	}

	public static int readInput() throws RuntimeError
	{
		if (inputAddr < 0)
			throw new RuntimeError("Registry index can't be lesser than 0", line);
		inputAddr++;
		if (inputAddr >= inputTape.size())
			return 0;
		return inputTape.get(inputAddr);
	}

	public static int getRegistry(int addr) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lesser than 0", line);
		if (addr >= registries.size())
			return 0;
		return registries.get(addr);
	}

	public static void setRegistry(int addr, int value) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lesser than 0", line);
		while (registries.size() < addr + 1)
			registries.add(0);
		registries.set(addr, value);
	}

	public static void writeOutput(int value)
	{
		outputTape.add(value);
	}
}