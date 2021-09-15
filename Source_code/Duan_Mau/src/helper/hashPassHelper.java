/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author Tran Van Thanh
 */
//Hỗ trợ băm pass trước khi lưu vào đb
public class hashPassHelper {

    public static String encrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String inputtext;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] textBytes = text.getBytes("UTF-8");
        byte[] enrTextBytes = md.digest(textBytes);

        BigInteger bigInt = new BigInteger(1, enrTextBytes);
        inputtext = bigInt.toString(16);
        return inputtext;
    }
//    public static String MyEncrypt(String text){//Băm code đơn giản 2 chiều
//        String outtext="";
//        char[] chas=text.toCharArray();
//        for(char c : chas){
//            c+=5;
//            outtext=String.valueOf(c);
//        }
//        return outtext;
//    }
//    public static String decryption(String text){//Giải mã
//        String outtext="";
//        char[] chas=text.toCharArray();
//        for(char c : chas){
//            c-=5;
//            outtext=String.valueOf(c);
//        }
//        return outtext;
//    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

    private static final int TAG_LENGTH_BIT = 128; // phải là một trong những {128, 120, 112, 104, 96}
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    // Trả về một văn bản được mã hóa AES được mã hóa Base64
    public static String Myencrypt(byte[] pText) throws Exception {
        String password ="thanhit";
        // 16 bytes salt
        byte[] salt = CryptoUtils.getRandomNonce(SALT_LENGTH_BYTE);

        // GCM recommended 12 bytes iv?
        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

        //Khóa bí mật từ mật khẩu
        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        // ASE-GCM needs GCMParameterSpec
        cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] cipherText = cipher.doFinal(pText);

        // Tiền tố IV và muối để mã hóa văn bản
        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                .put(iv)
                .put(salt)
                .put(cipherText)
                .array();

        // Đại diện chuỗi, Base64, gửi chuỗi này sang phân giải khác để giải mã.
        return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);

    }

    // Chúng ta cần cùng một mật khẩu, muối và IV để giải mã nó
    public static String decrypt(String cText) throws Exception {
        String password ="thanhit";
        byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));

        // lấy lại IV và muối từ văn bản mật mã
        ByteBuffer bb = ByteBuffer.wrap(decode);

        byte[] iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);

        byte[] salt = new byte[SALT_LENGTH_BYTE];
        bb.get(salt);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        // lấy lại khóa AES từ cùng một mật khẩu và muối
        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] plainText = cipher.doFinal(cipherText);

        return new String(plainText, UTF_8);

    }
}
