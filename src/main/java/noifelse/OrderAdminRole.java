package noifelse;

public class OrderAdminRole implements RoleOperation {
    private String roleName;
    public OrderAdminRole(String roleName ){
        this.roleName = roleName;
    }
    @Override
    public String op() {
        return roleName +" has BBB permission";
    }
}
