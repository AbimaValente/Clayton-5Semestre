package employeeSalary;

import java.util.Scanner;
import java.util.Locale;
public class employeeSalary {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Nome: ");
			String name = scanner.nextLine();
			
			
		System.out.print("Salário bruto: ");
			double grossSalary = scanner.nextDouble();
			
			
		System.out.print("Imposto: ");
			double tax = scanner.nextDouble();

			
	        double netSalary = NetSalary (grossSalary, tax);

	        
	    System.out.println ("Funcionário: " + name + ", $ " + netSalary);

	        
	    System.out.print ("Qual a porcentagem para aumentar o salário? ");
	        double percentage = scanner.nextDouble();

	        
	        double newSalary = IncreaseSalary(grossSalary, percentage);
	    System.out.println ("Dados atualizados: " + name + ", $ " + (netSalary + newSalary));
	  }
	

	    public static double NetSalary (double grossSalary, double tax) {
	        return grossSalary - tax;
	    }

	    public static double  IncreaseSalary (double grossSalary, double percentage) {
	        return grossSalary * percentage / 100;
	 }
}