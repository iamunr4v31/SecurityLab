import java.util.*;

class CipherImplementation{
    public static char[][] makeMatrix(String key){
        char [][] matrix = new char [5][5];
        Set <String> set = new LinkedHashSet<>();
        for (char c: key.toCharArray()){
            set.add(String.valueOf(c));
        }
        String [] setRes = set.toArray(new String[set.size()]);
        char starter = 'A';
        int iter = 0;
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (iter < set.size()){
                    matrix[i][j] = setRes[iter++].charAt(0);
                }
                else if (set.contains(String.valueOf(starter))){
                    j--;
                    starter = (char) ((int) starter + 1);
                }
                else if (starter == 'J'){
                    j--;
                    starter = (char) ((int) starter + 1);
                    continue;
                }
                else {
                    matrix[i][j] = starter;
                    starter = (char) ((int) starter + 1);
                }
            }
        }
        return matrix;
    }
    public static List<String> makeDigrams(String plainText){
        List<String> digrams = new ArrayList<String>();
        for (int i=0; i < plainText.length() - 1; i++){
            if (plainText.charAt(i) == plainText.charAt(i+1) || plainText.length() == 1){
                digrams.add(plainText.charAt(i) + "x");
            }
            else{
                digrams.add(plainText.charAt(i) + "" + plainText.charAt(i+1));
                i++;
            }
        }
        for (String s: digrams){
            System.out.println(s);
        }
        return digrams;
    }
    public static String encrypt(String plainText, String key){
        char [][] keyMatrix = CipherImplementation.makeMatrix(key);
        List <String> digrams = CipherImplementation.makeDigrams(plainText);

        return "something";
    }
}

class PlayFairCipher{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text: ");
        String plainText = sc.nextLine();
        System.out.print("Enter they key text: ");
        String key = sc.nextLine();
        CipherImplementation.encrypt(plainText, key);
    }
}