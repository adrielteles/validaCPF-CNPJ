package entities;

import java.util.Arrays;

public class Cpf {

    private String cpf;
    private Boolean valid;

    public Cpf(){}

    public Cpf(String cpf){
        this.cpf = formatCpf(cpf);
    }

    public String getCpf(){
        return this.cpf;
    }
    public Boolean getValid(){
        return this.valid;
    }
    private String formatCpf(String cpf){
        return cpf.replace(" ","").replace(".","").replace("-", "");
    }

    public void validateCpf(){
        int sizeCpf = 11;
        char firstChar = this.cpf.charAt(0);
        char[] cpfRepeat = new char[sizeCpf];
        Arrays.fill(cpfRepeat,firstChar);
        String cpfFirstCharRepeat = new String(cpfRepeat);

        if(cpfFirstCharRepeat.equals(this.cpf) || this.cpf.length() != sizeCpf){
            this.valid = false;
        }

        String nineDigits = this.cpf.substring(0,9);
        int regressiveCount = 10;
        int result = 0;

        for(int i=0; i< nineDigits.length();i++){
            result += Character.getNumericValue(nineDigits.charAt(i))*regressiveCount;
            regressiveCount -=1;
        }

        int firstDigit = (result*10) % 11;
        firstDigit = (firstDigit <=9) ?  firstDigit: 0;

        String tenDigits = nineDigits+firstDigit;
        int regressiveCount2 = 11;
        int result2 = 0;

        for(int i=0; i< tenDigits.length();i++){
            result2 += Character.getNumericValue(tenDigits.charAt(i))*regressiveCount2;
            regressiveCount2 -=1;
        }

        int secondDigit = (result2*10) % 11;
        secondDigit = (secondDigit <=9) ?  secondDigit: 0;

        String cpfResult = nineDigits+firstDigit+secondDigit;

        this.valid = cpfResult.equals(this.cpf);

    }
}
