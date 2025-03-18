package pl.majkus522.rammachine;

@FunctionalInterface
public interface FunctionReference<T, R>
{
	R apply(T t) throws RMerror;
}