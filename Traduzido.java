import java.util.Scanner;
public class Traduzido {
    public static void main(String[] args) {
    int a = 0;
    int b = 0;
    int i = 0;
    double x = 0.0;
    String nome = "";
    System.out.println("Digite A");
    Scanner scanner = new Scanner(System.in);
    a = scanner.nextInt();
    scanner.nextLine(); // Consumir o \n após o número inteiro
    System.out.println("Digite B");
    b = scanner.nextInt();
    scanner.nextLine(); // Consumir o \n após o número inteiro
    System.out.println("Digite o nome");
    nome = scanner.nextLine();
    System.out.println("Digite um número real");
    x = scanner.nextDouble();
    for (i=0; i<b; i=i+1) {
    System.out.print("Valor de i: ");
    System.out.println(i);
    }
    System.out.print("Valor final de i: ");
    System.out.println(i);
    while (a<b) {
    }
    System.out.print("Valor final de a: ");
    System.out.println(a);
    System.out.print("O nome digitado foi: ");
    System.out.println(nome);
    System.out.print("O número real digitado foi: ");
    System.out.print(x);
    }
}
