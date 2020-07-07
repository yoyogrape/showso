package test;

import java.util.Base64;

/**
 * Base64加密解密测试
 */
public class Base64Test {
    public static void main(String[] args) throws Exception {
        byte[] encode = Base64.getEncoder().encode("{\"typ\":\"JWT\",\"alg\":\"HS256\"}".getBytes());
        String s = new String(encode, "UTF-8");
        System.out.println("加密后：：：" + s);


        byte[] decode = Base64.getDecoder().decode("YWFh".getBytes());
        String d = new String(decode, "UTF-8");
        System.out.println("加密后：：：" + d);


    }
}
