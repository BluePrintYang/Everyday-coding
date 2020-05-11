package noifelse;

public class JudgeRoleByContext {
    public String judge(RoleOperation roleOperation){
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.execute();
    }
}
