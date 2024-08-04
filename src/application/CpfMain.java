package application;

import geradorRandomicoCPF.CpfGenerator;
import geradorRandomicoCPF.CpfValidator;

public class CpfMain {

    public static void main(String[] args) {
    	
        // Gera um CPF aleatório
        String cpf = CpfGenerator.generateCpf();
        System.out.println("Generated CPF: " + cpf);
        
        // Valida o CPF gerado (removendo os caracteres especiais para validação)
        System.out.println("Is valid: " + CpfValidator.isValid(cpf.replace(".", "").replace("-", "")));
    }
}
