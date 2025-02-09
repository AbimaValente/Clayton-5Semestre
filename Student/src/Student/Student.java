package Student;
import java.util.Locale;
import java.util.Scanner;
public class Student {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
			String name = scanner.nextLine();
			
			double n1 = scanner.nextDouble();
						
			double n2 = scanner.nextDouble();
			
			double n3 = scanner.nextDouble();
			
	        double result = (n1 + n2 + n3);
	        
	        String mensagemNotaFinal = String.format("NOTA FINAL = %.2f", result);
	        
	        mensagemNotaFinal = mensagemNotaFinal.replace(",",".");
	        
	        System.out.println(mensagemNotaFinal);

	        if(result >= 60) 
	            System.out.println("PASS");
	        
	        else{
	        	System.out.println("FAILED");
	        	
	        	String mensagemReprovado = String.format("FALTARAM %.2f PONTOS", -(result - 60.00) );
	        	
	        	mensagemReprovado = mensagemReprovado.replace(",",".");
	        	
	        	System.out.println(mensagemReprovado);       	
	        }			    
	  }
	
}
