package lizun.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lizun.model.Customer;
import lizun.model.User;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

@Service
public class SecurityService {
    private String transformation = "AES/CBC/PKCS5Padding";
    private Cipher cipher;
    private byte[] sec_bytes = new byte[16];
    public static final int MIN_COST = 4;
    public static final int MAX_COST = 31;

    public void init() {
        SecureRandom random = new SecureRandom();
        random.nextBytes(sec_bytes);
    }

    public String getDecryptPhone(Customer customer){
        SecretKeySpec key = transformStringToSecretKey(customer.getKey());
        System.out.println(DatatypeConverter.parseHexBinary(customer.getKey()).length+" "+DatatypeConverter.parseHexBinary(customer.getIv()).length);
        byte[] bytes = decrypt(key, DatatypeConverter.parseHexBinary(customer.getPhone()),
                DatatypeConverter.parseHexBinary(customer.getIv()));
        return new String(bytes);

    }

    public boolean comparePhone(Customer customer, String phone){
        return phone.equals(getDecryptPhone(customer));
    }

    public User createCryptoUser(String pswd){
        int cost = (int) (Math.random() * (MAX_COST-MIN_COST+1)) + MIN_COST;
        String bcryptHashString = BCrypt.withDefaults().hashToString(6, pswd.toCharArray());
        User user = new User();
        user.setHash(bcryptHashString);
        return user;
    }

    public Customer createCryptoCustomer(String phone){
        init();
        //шифрование телефона
        SecretKeySpec key = createSecretKey();
        byte[] enc = encrypt(key,phone.getBytes());
        Customer customer =new Customer();
        customer.setIv(DatatypeConverter.printHexBinary(sec_bytes));
        customer.setKey(DatatypeConverter.printHexBinary(key.getEncoded()));
        customer.setPhone(DatatypeConverter.printHexBinary(enc));
        return customer;
    }

    public SecretKeySpec createSecretKey() {
        SecretKeySpec sks = null;
        byte[] bytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        try {
            /*KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            return secretKey;*/
            MessageDigest md;
            byte[] key;
            md = MessageDigest.getInstance("SHA-1");
            key = md.digest(bytes);
            key = Arrays.copyOf(key, 16);
            sks = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
        }
        return sks;
    }

    public SecretKeySpec transformStringToSecretKey(String key){
        return new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "AES");
    }

    public byte[] encrypt(SecretKey secretKey,
                          byte[] plainText) {
        try {
            cipher = Cipher.getInstance(transformation);
            if (transformation.contains("ECB"))
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            else {
                IvParameterSpec ivSpecEnc = new IvParameterSpec(sec_bytes);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey,
                        ivSpecEnc);
            }
            return cipher.doFinal(plainText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public byte[] decrypt(SecretKey secretKey,
                          byte[] encryptedText,byte[] iv) {
        try {
            cipher = Cipher.getInstance(transformation);
            if (transformation.contains("ECB"))
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            else {
                IvParameterSpec ivSpec;
                ivSpec = new IvParameterSpec(iv);
                cipher.init(Cipher.DECRYPT_MODE, secretKey,
                        ivSpec);
            }
            return cipher.doFinal(encryptedText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
