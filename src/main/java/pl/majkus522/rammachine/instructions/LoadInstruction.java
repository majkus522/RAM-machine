package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;

import static pl.majkus522.rammachine.MachineController.setRegistry;

public class LoadInstruction extends BaseInstruction
{
    public LoadInstruction(String address) throws InterpreterError
    {
        super(address);
    }

    @Override
    public void execute() throws RuntimeError
    {
        setRegistry(0, getValueFromRegistry());
    }
}