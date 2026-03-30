package Menu;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            Scanner sc = new Scanner();
            String escolha = sc.nextLine();

            Switch
        }
    }
}
