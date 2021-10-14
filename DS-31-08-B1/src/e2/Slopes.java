package e2;

public class Slopes {
    public static int downTheSlope(char[][] slopeMap, int right, int down) {

        int arboles=0;
        int aux1=0;
        int aux2=0;
        int aux3=0;
        int aux4=0;

        for (int i = 0; i < slopeMap.length; i++) {
            if (slopeMap.length != slopeMap[i].length) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < slopeMap.length; j++) {
                if (slopeMap[j].length != slopeMap.length) {
                    throw new IllegalArgumentException();
                }
                char c = slopeMap[i][j];
                String content = String.valueOf(c);
                if (!(content.contains(".") || content.contains("#"))) {
                    throw new IllegalArgumentException();
                }
                if (down >= slopeMap.length || down < 1) {
                    throw new IllegalArgumentException();
                }
                if (right >= slopeMap.length || right < 1) {
                    throw new IllegalArgumentException();
                }
            }
        }
        while(aux1<slopeMap.length){
            if(slopeMap[aux1][aux2]=='#'){
                arboles++;
            }
            if(aux1 != aux4 && aux2 == aux3){
                aux1++;
            }
            else if(aux2 == aux3){
                aux2++;
                aux4+=down;
                aux3+=right;
            }
            else{
                aux2++;
            }
            if(aux2>slopeMap[0].length-1){
                aux3=aux3-slopeMap[0].length;
                aux2=0;
            }
        }
        return arboles;
    }

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {

        int arboles=0;
        int aux1=0;
        int aux2=0;
        int aux3=0;

        for (int i = 0; i < slopeMap.length; i++) {
            if (slopeMap.length != slopeMap[i].length) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < slopeMap.length; j++) {
                if (slopeMap[j].length != slopeMap.length) {
                    throw new IllegalArgumentException();
                }
                char c = slopeMap[i][j];
                String content = String.valueOf(c);
                if (!(content.contains(".") || content.contains("#"))) {
                    throw new IllegalArgumentException();
                }
                if (down >= slopeMap.length || down < 1) {
                    throw new IllegalArgumentException();
                }
                if (right >= slopeMap.length || right < 1) {
                    throw new IllegalArgumentException();
                }
                aux3=slopeMap[i].length;
            }
        }
        while(aux1<slopeMap.length){
            if(slopeMap[aux1][aux2%aux3]=='#'){
                arboles++;
            }
            aux1+=down;
            aux2+=right;
        }
        return arboles;
    }
}



