package reflection;

import java.util.List;
import java.util.Objects;

public class MethodInfo {


	private final String name;
	private final boolean isAbstract;
	private final List<Class> args;
	private final Class returnType;

	public MethodInfo(String name, boolean isAbstract, List<Class> args, Class returnType) {
		this.name = name;
		this.isAbstract = isAbstract;
		this.args = args;
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public List<Class> getArgs() {
		return args;
	}

	public Class getReturnType() {
		return returnType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodInfo that = (MethodInfo) o;
		return isAbstract == that.isAbstract &&
				Objects.equals(name, that.name) &&
				Objects.equals(args, that.args) &&
				Objects.equals(returnType, that.returnType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, isAbstract, args, returnType);
	}

	@Override
	public String toString() {
		return "MethodInfo{" +
				"name='" + name + '\'' +
				", isAbstract=" + isAbstract +
				", args=" + args +
				", returnType=" + returnType +
				'}';
	}


}
