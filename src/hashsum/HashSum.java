package hashsum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashSum
{
    private static String byte_to_string(byte[] hashBytes)
    {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes)
        {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
            {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public static String hash(String text, String algorithm)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashByte = digest.digest(text.getBytes());
            // RETURNS HASHED PASSWORD
            return byte_to_string(hashByte);
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("No such algorithm error: " + e);
            return "";
        }
    }
}

