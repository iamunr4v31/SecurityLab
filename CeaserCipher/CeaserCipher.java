import java.util.*;

class CipherImplementation{
    public static String encrypt(String plainText, int shift){
        StringBuffer cipherText = new StringBuffer();
        for(char c: plainText.toCharArray()){
            if (Character.isLowerCase(c)){
                Character.toUpperCase(c);
            }
                char ch = (char)(((int) c + shift - 65) % 26 + 65);
                cipherText.append(ch);
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int shift){
        StringBuffer plainText = new StringBuffer();
        for(char c: cipherText.toCharArray()){
            if (Character.isLowerCase(c)){
                Character.toUpperCase(c);
            }
                char ch = (char)(((int) c - shift - 65) % 26 + 65);
                plainText.append(ch);
        }
        return plainText.toString();
    }
}

class CeaserCipher{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Scanner intIn = new Scanner(System.in);
        System.out.print("Enter Plain text: ");
        String plainText = in.nextLine();
        System.out.print("Enter Key value: ");
        int shift = intIn.nextInt();
        String encrypted = CipherImplementation.encrypt(plainText, shift);
        System.out.println("Encrypted String: " + encrypted);
        String decrypted = CipherImplementation.decrypt(encrypted, shift);
        System.out.println("Decrypted String: " + decrypted);
    }
}