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
        int modulus;
        if ((modulus = transpositionInput.length() % n) != 0) {
            modulus = n - modulus;

            for (; modulus != 0; modulus--) {
                transpositionInput += "/";
            }
        }
        StringBuffer transpositionOutput = new StringBuffer();
        System.out.println(" ");
        System.out.println("Transposition Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < transpositionInput.length() / n; j++) {
                char c = transpositionInput.charAt(i + (j * n));
                System.out.print(c);
                transpositionOutput.append(c);
            }
            System.out.println();
        }
        System.out.println(" ");
        System.out.println("Final encrypted text: ");
        System.out.println(transpositionOutput);

        // Transposition decryption
        n1 = transpositionOutput.length() / n1;
        StringBuffer transpositionPlaintext = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < transpositionOutput.length() / n; j++) {
                char c = transpositionOutput.charAt(i + (j * n));
                transpositionPlaintext.append(c);
            }
        }

        // Substitution decryption
        StringBuffer plaintext = new StringBuffer();
        for (int i = 0; i < transpositionPlaintext.length(); i++) {
            char c = transpositionPlaintext.charAt(i);
            plaintext.append((char) (c - n));
        }

        System.out.println("Plaintext: ");
        System.out.println(plaintext);
        sc.close();
    }
}