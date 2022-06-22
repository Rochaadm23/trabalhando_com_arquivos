package arquivos;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AppCsv {
    public static void main(String[] args) throws Exception {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Bob Marley");
        pessoa1.setEmail("bob@email.com");
        pessoa1.setIdade(3);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria Jose");
        pessoa2.setEmail("mari@email.com");
        pessoa2.setIdade(60);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Luiz Rocha");
        pessoa3.setEmail("luiz@email.com");
        pessoa3.setIdade(54);

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Bart Simpson");
        pessoa4.setEmail("bart@email.com");
        pessoa4.setIdade(5);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);

        File arquivo = new File("D:\\workspace\\Git\\Jdev\\arquivos\\arquivo.csv");

        if (arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        for (Pessoa pessoa : pessoas) {
            escrever_no_arquivo.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");
        }

        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();
    }
}
