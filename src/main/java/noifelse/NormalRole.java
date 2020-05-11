package noifelse;

public class NormalRole implements RoleOperation {
    private String roleName;
    public NormalRole(String roleName ){
        this.roleName = roleName;
    }
    @Override
    public String op() {
        return roleName +" has CCC permission";
    }
}
