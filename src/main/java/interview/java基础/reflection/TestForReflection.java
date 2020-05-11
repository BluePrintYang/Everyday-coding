package interview.java基础.reflection;

public class TestForReflection {
    private int var;

    public TestForReflection() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "var=" + var +
                '}';
    }

    public TestForReflection(int var) {
        this.var = var;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
}
