import java.util.*;

class CipherImplementation{
    public static char[][] makeMatrix(String plainText, int fences){
        char[][] matrix = new char [fences][plainText.length()];
        boolean bool = true;
        int i=0, j=0;
        for (char c: plainText.toCharArray()){
            if(j>=plainText.length()){
                break;
            }
            if (i==0){
                bool = true;
            }
            if (i==fences-1){
                bool = false;
            }
            matrix[i][j] = c;
            int x = (bool==true)? i++: i--;
            j++;
        
        }
        return matrix;
    }
    public static String encrypt(String plainText, int fences){
        StringBuffer cipherText = new StringBuffer();
        char[][] matrix = makeMatrix(plainText, fences);
        for (int i=0; i<fences; i++){
            for (int j=0; j< plainText.length(); j++){
                if (matrix[i][j] != '\u0000'){
                    cipherText.append(matrix[i][j]);
                }
            }
        }
        return cipherText.toString();
    }
    public static String decrypt(String cipherText, int fences){
        StringBuffer plainText = new StringBuffer();
        StringBuffer buff = new StringBuffer();
        for (int i=0; i<cipherText.length(); i++){
            buff.append("*");
        }
        char[][] matrix = makeMatrix(buff.toString(), fences);
        int k=0;
        for (int i=0; i<fences; i++){
            for (int j=0; j< cipherText.length(); j++){
                if (matrix[i][j] != '\u0000'){
                    matrix[i][j] = cipherText.charAt(k++);
                }
            }
        }
        boolean bool = true;
        int i=0, j=0;
        for (char c: cipherText.toCharArray()){
            if(j>=cipherText.length()){
                break;
            }
            if (i==0){
                bool = true;
            }
            if (i==fences-1){
                bool = false;
            }
            plainText.append(matrix[i][j]);
            int x = (bool==true)? i++: i--;
            j++;
        
        }
        return plainText.toString();

    }
}

class RailFence{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String pt = sc.nextLine();
        int depth = in.nextInt();
        
        pt = pt.replace(" ", "");
        String ct = CipherImplementation.encrypt(pt, depth);
        System.out.println(ct);
        pt = CipherImplementation.decrypt(ct, depth);
        System.out.println(pt);
    }
}