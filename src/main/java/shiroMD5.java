import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class shiroMD5 {
    public static void main(String[] args) {
        //密码明文
        String password = "z3";
        // 使用MD5加密
        Md5Hash md5 = new Md5Hash(password);
        System.out.println("md5 = " + md5);
        // 带盐加密
        Md5Hash md5Hash2 = new Md5Hash(password,"salt");
        System.out.println("md5Hash2 = " + md5Hash2);
        // 多次加密
        Md5Hash md5Hash3 = new Md5Hash(password,"salt",3);
        System.out.println("md5Hash3 = " + md5Hash3);
        // 使用父类加密
        SimpleHash simpleHash = new SimpleHash("MD5",password,"salt",3);
        System.out.println("simpleHash = " + simpleHash);
    }
}
