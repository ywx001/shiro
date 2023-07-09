import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroRun {
    public static void main(String[] args) {
        // 初始化获取manage
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //获取对象
        Subject subject = SecurityUtils.getSubject();

        // 创建token对象
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");
        //完成登录
        try {
            subject.login(token);
            System.out.println("login success");
            //判断角色
            boolean hasRole = subject.hasRole("role1");
            System.out.println("hasRole = " + hasRole);
            // 判断权限
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println("permitted = " + permitted);

        }  catch ( UnknownAccountException uae ) {
            System.out.println("No UserName" );
            //username wasn't in the system, show them an error message?
        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
            System.out.println("password didn't match" );
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
        } catch ( AuthenticationException ae ) {
        //unexpected condition - error?
    }


    }
}
