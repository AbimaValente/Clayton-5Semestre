package CurrencyConverter;
import java.util.Locale;
import java.util.Scanner;

class CurrencyConverter {

    private double cotacaoDolar;

    public static void main(String[] args) {
    	Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual o valor do dólar? ");
        double cotacaoDolar = scanner.nextDouble();

        System.out.print("Quantos dólares serão comprados? ");
        double valorDolar = scanner.nextDouble();

        CurrencyConverter conversor = new CurrencyConverter(cotacaoDolar);

        double valorReais = conversor.converterParaReais(valorDolar);

        System.out.printf("Valor a ser pago em reais: R$ %.2f%n", valorReais);

        scanner.close();
    }

    public CurrencyConverter(double cotacaoDolar) {
        this.cotacaoDolar = cotacaoDolar;
    }

    public double converterParaReais(double valorDolar) {
        double iof = 0.06;
        double valorComIOF = valorDolar * (1 + iof);
        return valorComIOF * cotacaoDolar;
 }
}