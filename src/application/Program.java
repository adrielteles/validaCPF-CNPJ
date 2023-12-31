package application;

import entities.Cnpj;
import entities.Cpf;

import java.io.EOFException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Cpf cpf;
        Cnpj cnpj;

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        while(true){
            try{
                System.out.print(ANSI_YELLOW);
                System.out.println("CPF-CNPJ TOOL");
                System.out.print(ANSI_RESET);
                System.out.print(ANSI_CYAN);
                System.out.println("\n-----------------------");
                System.out.println("Options:");
                System.out.println("-----------------------");
                System.out.print(ANSI_RESET);
                System.out.print(ANSI_PURPLE);
                System.out.println("1. Validate CPF");
                System.out.println("2. Generate CPF");
                System.out.println("3. Validate CNPJ");
                System.out.println("4. Generate CNPJ");
                System.out.println("5. Exit");
                System.out.print(ANSI_RESET);
                System.out.print(ANSI_CYAN);
                System.out.print("Choice: ");
                System.out.print(ANSI_RESET);
                int option = scan.nextInt();
                scan.nextLine();

                if(option == 1){
                    System.out.print(ANSI_CYAN);
                    System.out.print("Enter CPF"+ANSI_YELLOW+" Ex:(000.000.000-00): "+ANSI_RESET);
                    cpf = new Cpf(scan.nextLine());
                    cpf.validateCpf();
                    System.out.print(ANSI_CYAN);
                    System.out.println("\n-----------------------");
                    String ANSI_RESULT;
                    if(cpf.getValid()){
                        ANSI_RESULT = ANSI_GREEN;
                    }else{
                        ANSI_RESULT = ANSI_RED;
                    }
                    System.out.println("Result: "+ANSI_RESULT+cpf.getCpf()+" -> "+cpf.getValid()+ANSI_RESET);
                    System.out.print(ANSI_CYAN);
                    System.out.println("-----------------------\n");
                    System.out.print(ANSI_RESET);
                }else if(option == 2){
                    System.out.print(ANSI_CYAN);
                    System.out.print("How many:"+ANSI_RESET);
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    System.out.print(ANSI_GREEN);
                    for(int i=0; i<quantity; i++){
                        System.out.println(Cpf.generateCpf());
                    }
                    System.out.print(ANSI_RESET);
                }else if(option == 3){
                    System.out.print(ANSI_CYAN);
                    System.out.print("Enter CPNJ"+ANSI_YELLOW+" Ex:(00.000.000/0000-00): "+ANSI_RESET);
                    cnpj = new Cnpj(scan.nextLine());
                    cnpj.validateCnpj();
                    System.out.print(ANSI_CYAN);
                    System.out.println("\n-----------------------");
                    String ANSI_RESULT;
                    if(cnpj.getValid()){
                        ANSI_RESULT = ANSI_GREEN;
                    }else{
                        ANSI_RESULT = ANSI_RED;
                    }
                    System.out.println("Result: "+ANSI_RESULT+cnpj.getCpnj()+" -> "+cnpj.getValid()+ANSI_RESET);
                    System.out.print(ANSI_CYAN);
                    System.out.println("-----------------------\n");
                    System.out.print(ANSI_RESET);
                }else if(option == 4){
                    System.out.print(ANSI_CYAN);
                    System.out.print("How many:"+ANSI_RESET);
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    System.out.print(ANSI_GREEN);
                    for(int i=0; i<quantity; i++){
                        System.out.println(Cnpj.generateCnpj());
                    }
                    System.out.print(ANSI_RESET);
                }else if(option == 5){
                    break;
                }else{
                    System.out.println("\n-----------------------");
                    System.out.println("Invalid choice!");
                    System.out.println("-----------------------\n");
                }
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}
