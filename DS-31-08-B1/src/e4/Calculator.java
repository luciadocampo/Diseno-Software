package e4;

public class Calculator {
    private String simbolo;
    private int cnt,cont;
    enum Operation{
        SUMAR("+"), RESTAR("-"), MULTIPLICAR("*"), DIVIDIR("/");

        String simbolo;

        Operation(String simbolo){
            this.simbolo = simbolo;
        }
    }
    private Operation[] operaciones;
    private float[] operandos;

    public Calculator () {
        operaciones=new Operation[10];
        operandos=new float[10];
        cnt=0;
        cont=0;

    }

    public void cleanOperations () {
        operaciones=new Operation[10];
        operandos=new float[10];
        cnt=0;
        cont=0;
    }

    public void addOperation ( String operation , float ... values ) {
        Operation op;
        int cantidad= values.length;

        if(!(operation.contains("+") || operation.contains("-") || operation.contains("*") || operation.contains("/"))) {
            throw new IllegalArgumentException();
        }else{
            if(operation.contains("+")){
                op=Operation.SUMAR;
                operaciones[cnt]=op;
            }
            if(operation.contains("-")){
                op=Operation.RESTAR;
                operaciones[cnt]=op;
            }
            if(operation.contains("*")){
                op=Operation.MULTIPLICAR;
                operaciones[cnt]=op;
            }
            if(operation.contains("/")){
                op=Operation.DIVIDIR;
                operaciones[cnt]=op;
            }
            cnt++;
            if(cantidad<1){
                throw new IllegalArgumentException();
            }else{
                int k=0;
                while(k<values.length){
                    operandos[cont]=values[k];
                    cont++;
                    k++;
                }
            }
        }
    }

    public float executeOperations () {

        float result=operandos[0];
        for(int i=0;i<cnt;i++){
            if(operaciones[i]==Operation.DIVIDIR && operandos[i+1]==0){
                cont=0;
                cnt=0;
                throw new ArithmeticException();
            }
            if (operaciones[i] == Operation.SUMAR) {
                    result += operandos[i + 1];
                }
            if (operaciones[i] == Operation.RESTAR) {
                    result -= operandos[i + 1];
                }
            if (operaciones[i] == Operation.MULTIPLICAR) {
                    result = result * operandos[i + 1];
                }
            if (operaciones[i] == Operation.DIVIDIR) {
                    result = result / operandos[i + 1];
                }
        }
        cleanOperations();
        return result;
    }

    @Override
    public String toString () {
        StringBuilder cadena = new StringBuilder();
        cadena.append("[STATE:");
        if(cont!=0){
            cadena.append("[").append(operaciones[0].simbolo).append("]").append(operandos[0]).append("_").append(operandos[1]);
            for (int k = 1; k < cnt; k++) {
                cadena.append("[").append(operaciones[k].simbolo).append("]").append(operandos[k + 1]);
            }
        }
        cadena.append("]");

        return cadena.toString();
    }
}

