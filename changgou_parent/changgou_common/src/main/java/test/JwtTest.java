package test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt创建令牌测试
 */
public class JwtTest {
    public static void main(String[] args) {
//        generateJwt();
        decodeJwt();
    }

    private static void decodeJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLmiJHmsqHmnInkuInpopflv4PohI8iLCJpYXQiOjE1OTQxMzczNzYsInN1YiI6IkpXVOS7pOeJjOa1i-ivlSJ9.LaLOKjDPo0Ayj4OwNYmV4GBRvbX6Wf_t-taopq3NJDc";
        Claims songjn = Jwts.parser()
                .setSigningKey("songjn")//密钥
                .parseClaimsJws(token)//要解析的令牌对象
                .getBody();//获取解析后的数据
        System.out.println(songjn.toString());
    }

    private static void generateJwt() {
        JwtBuilder builder = Jwts.builder();
        builder.setIssuer("我没有三颗心脏");//颁发者
        builder.setIssuedAt(new Date());//颁发时间
        builder.setExpiration(new Date(System.currentTimeMillis()+200000));//设置过期时间
        builder.setSubject("JWT令牌测试");//主题信息
        builder.signWith(SignatureAlgorithm.HS256, "songjn");//签名算法 256 ；密钥（盐）
        System.out.println(builder.compact());
    }
}
