package noifelse;

public class JudgeRoleByFactory {
    public String judge(String roleName){
        //1行代码搞定！之前的if/else也没了!
        return RoleFactory.getOp(roleName).op();
    }
}
