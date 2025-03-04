package pl.majkus522;

import pl.majkus522.error.InterpreterError;

@FunctionalInterface
public interface FunctionReference<T, R>
{
    R apply(T t) throws InterpreterError;
}