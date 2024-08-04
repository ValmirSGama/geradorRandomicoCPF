package geradorRandomicoCPF;

public class CpfValidator {

    // Método para validar um CPF
    public static boolean isValid(String cpf) {
        // Verifica se o CPF é nulo, tem um tamanho diferente de 11 ou se todos os caracteres são iguais
        if (cpf == null || cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Converte os caracteres do CPF em um array de inteiros
        int[] digits = cpf.chars().map(c -> c - '0').toArray();
        
        // Calcula o primeiro dígito verificador
        int digit1 = calculateDigit(digits, 10);
        // Cria um novo array que inclui o primeiro dígito verificador
        int[] digitsWithFirstDigit = new int[10];
        System.arraycopy(digits, 0, digitsWithFirstDigit, 0, 9);
        digitsWithFirstDigit[9] = digit1;

        // Calcula o segundo dígito verificador
        int digit2 = calculateDigit(digitsWithFirstDigit, 11);

        // Verifica se os dígitos verificadores calculados são iguais aos dígitos verificadores do CPF
        return digits[9] == digit1 && digits[10] == digit2;
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
}
