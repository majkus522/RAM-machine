package pl.majkus522.rammachine;

import pl.majkus522.rammachine.error.InterpreterError;

@FunctionalInterface
public interface FunctionReference<T, R>
{
	R apply(T t) throws InterpreterError;
}