import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {

    // 自定义登录认证

    //配置

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取身份信息
        String principal = token.getPrincipal().toString();
        System.out.println("principal = " + principal);
        //获取凭证信息
        String password =  String.valueOf((char [])token.getCredentials());
        System.out.println("password = " + password);
        //获取用户信息
        if (principal.equals("zhangsan")) {
            String pwdInfo = "7174f64b13022acd3c56e2781e098a5f";
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                    token.getPrincipal()
                    , pwdInfo
                    , ByteSource.Util.bytes("salt")
                    , token.getPrincipal().toString()
            );
            return info;
        }

        //创建封装检验逻辑对象，返回

        return null;
    }
}
