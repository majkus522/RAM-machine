package pl.majkus522;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;
import pl.majkus522.instructions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MachineController
{
	static List<BaseInstruction> instructions = new ArrayList<>();
	static HashMap<String, FunctionReference<String, BaseInstruction>> interpreter = new HashMap<>();
	public static List<Integer> inputTape = new ArrayList<>();
	static List<Integer> outputTape = new ArrayList<>();
	static List<Integer> registries = new ArrayList<>();
	public static HashMap<String, Integer> labels = new HashMap<>();
	public static int lineIndex;
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

	public static void runProgram(List<String> input)
	{
		try
		{
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
		}
		catch (RuntimeError e)
		{
			e.printStackTrace();
		}
		catch (InterpreterError e)
		{
			e.printStackTrace();
		}

		System.out.println(registries);
		System.out.println(outputTape);
	}

	public static int readInput() throws RuntimeError
	{
		inputAddr++;
		if (inputAddr >= inputTape.size())
			return 0;
		return inputTape.get(inputAddr);
	}

	public static int getRegistry(int addr) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lesser than 0");
		if (addr >= registries.size())
			return 0;
		return registries.get(addr);
	}

	public static void setRegistry(int addr, int value) throws RuntimeError
	{
		if (addr < 0)
			throw new RuntimeError("Registry index can't be lesser than 0");
		while (registries.size() < addr + 1)
			registries.add(0);
		registries.set(addr, value);
	}

	public static void writeOutput(int value)
	{
		outputTape.add(value);
	}
}