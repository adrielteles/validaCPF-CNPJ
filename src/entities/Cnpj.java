package entities;

import java.util.Arrays;

public class Cnpj {

    private String cnpj;
    private boolean valid;

    public Cnpj(){}

    public Cnpj(String cnpj){
        this.cnpj = formatCnpj(cnpj);
    }

    public String getCpnj() {
        return cnpj;
    }

    public boolean getValid() {
        return valid;
    }

    public String formatCnpj(String cnpj){
        return cnpj.replaceAll("[^0-9]", "");
    }

    public void validateCnpj(){
        int sizeCnpj = 14;
        char firstChar = this.cnpj.charAt(0);
        char[] cnpjRepeat = new char[sizeCnpj];
        Arrays.fill(cnpjRepeat,firstChar);
        String cnpjFirstCharRepeat = new String(cnpjRepeat);

        if(cnpjFirstCharRepeat.equals(this.cnpj) || this.cnpj.length() != sizeCnpj){
            this.valid = false;
        }

        String twelveDigits = this.cnpj.substring(0,12);

        char firstDigit, secondDigit;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            // converte o i-ésimo caractere do CNPJ em um número:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
            num = (int) (this.cnpj.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1)){
            firstDigit = '0';
        } else{
            firstDigit = (char) ((11 - r) + 48);
        }


        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = (int) (this.cnpj.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
            }

        r = sm % 11;
        if ((r == 0) || (r == 1)){
            secondDigit = '0';
        }else{
            secondDigit = (char) ((11 - r) + 48);
        }

        String cnpjResult = twelveDigits+firstDigit+secondDigit;

        this.valid = cnpjResult.equals(this.cnpj);

    }
}
