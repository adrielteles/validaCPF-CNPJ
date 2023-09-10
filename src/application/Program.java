package application;

import entities.Cpf;

import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Cpf cpf;

        System.out.print("cpf:");
        cpf = new Cpf(scan.nextLine());
        cpf.validateCpf();
        System.out.println(cpf.getValid());
    }
}
