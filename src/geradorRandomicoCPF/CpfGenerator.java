package geradorRandomicoCPF;

import java.util.Random;

public class CpfGenerator {

    // Cria uma instância de Random para gerar números aleatórios
    private static final Random RANDOM = new Random();

    // Método para gerar um CPF
    public static String generateCpf() {
        int[] digits = new int[9]; // Array para armazenar os primeiros 9 dígitos do CPF
        for (int i = 0; i < 9; i++) {
            digits[i] = RANDOM.nextInt(10); // Preenche o array com números aleatórios de 0 a 9
        }

        // Calcula o primeiro dígito verificador
        int digit1 = calculateDigit(digits, 10);
        // Cria um novo array que inclui o primeiro dígito verificador
        int[] digitsWithFirstDigit = new int[10];
        System.arraycopy(digits, 0, digitsWithFirstDigit, 0, digits.length);
        digitsWithFirstDigit[9] = digit1;

        // Calcula o segundo dígito verificador
        int digit2 = calculateDigit(digitsWithFirstDigit, 11);

        // Retorna o CPF formatado
        return formatCpf(digits, digit1, digit2);
    }

    // Método para calcular os dígitos verificadores
    private static int calculateDigit(int[] digits, int factor) {
        int sum = 0;
        for (int i = 0; i < factor - 1; i++) {
            sum += digits[i] * (factor - i); // Multiplica os dígitos pelo fator decrescente
        }
        int remainder = (sum * 10) % 11; // Calcula o resto da divisão de sum * 10 por 11
        return remainder == 10 ? 0 : remainder; // Se o resto for 10, retorna 0, caso contrário, retorna o resto
    }

    // Método para converter os dígitos em strings
    private static String[] digitsToString(int[] digits) {
        String[] strDigits = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            strDigits[i] = String.valueOf(digits[i]); // Converte cada dígito para string
        }
        return strDigits;
    }

    // Método para formatar o CPF
    private static String formatCpf(int[] digits, int digit1, int digit2) {
        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", 
                digits[0], digits[1], digits[2], 
                digits[3], digits[4], digits[5], 
                digits[6], digits[7], digits[8], 
                digit1, digit2); // Retorna o CPF no formato 000.000.000-00
    }
}
