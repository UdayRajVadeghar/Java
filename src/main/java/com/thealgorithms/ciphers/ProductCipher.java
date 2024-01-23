package com.thealgorithms.ciphers;

import java.util.Scanner;

class ProductCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input to be encrypted: ");
        String substitutionInput = sc.nextLine();
        System.out.println(" ");
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int n1 = n;

        // Substitution encryption
        StringBuffer substitutionOutput = new StringBuffer();
        for (int i = 0; i < substitutionInput.length(); i++) {
            char c = substitutionInput.charAt(i);
            substitutionOutput.append((char) (c + n));
        }
        System.out.println(" ");
        System.out.println("Substituted text: ");
        System.out.println(substitutionOutput);

        // Transposition encryption
        String transpositionInput = substitutionOutput.toString();
        StringBuffer transpositionOutput = new StringBuffer();
        System.out.println(" ");
        System.out.println("Transposition Matrix: ");
        for (int i = 0; i < transpositionInput.length(); i++) {
            char c = transpositionInput.charAt(i);
            System.out.print(c);
            transpositionOutput.append(c);
            if ((i + 1) % n == 0) {
                System.out.println();
            }
        }
        System.out.println(" ");
        System.out.println("Final encrypted text: ");
        System.out.println(transpositionOutput);

        // Transposition decryption
        StringBuffer transpositionPlaintext = new StringBuffer();
        for (int i = 0; i < transpositionOutput.length(); i++) {
            char c = transpositionOutput.charAt(i);
            transpositionPlaintext.append(c);
            if ((i + 1) % n == 0) {
                System.out.println();
            }
        }

        // Substitution decryption
        StringBuffer plaintext = new StringBuffer();
        for (int i = 0; i < transpositionPlaintext.length(); i++) {
            char c = transpositionPlaintext.charAt(i);
            plaintext.append((char) (c - n1));
        }

        System.out.println("Plaintext: ");
        System.out.println(plaintext);
        sc.close();
    }
}
