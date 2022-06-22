package arquivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoCsv {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream entadaArquivo = new FileInputStream(
                new File("D:\\workspace\\Git\\Jdev\\arquivos\\arquivo.csv"));

        Scanner lerArquivo = new Scanner(entadaArquivo, "utf-8");

        List<Pessoa> pessoas = new ArrayList<>();

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            if (linha != null && !linha.isEmpty()) {

                String[] dados = linha.split("\\;");

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt(dados[2]));

                pessoas.add(pessoa);
            }
        }

        for (Pessoa pa : pessoas) {

            System.out.println(pa);
        }

    }

}
