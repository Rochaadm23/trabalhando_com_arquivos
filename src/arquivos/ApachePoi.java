package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\workspace\\Git\\Jdev\\arquivos\\arquivo_excel.xls.");

        if (file.exists()) {
            file.createNewFile();
        }

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

        Pessoa pessoa5 = new Pessoa();
        pessoa5.setNome("Mil House");
        pessoa5.setEmail("puguinha@email.com");
        pessoa5.setIdade(2);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa5);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento");

        int numeroLinha = 0;
        for (Pessoa row : pessoas) {
            Row linha = linhaPessoa.createRow(numeroLinha++); // Criando a linha na planilha

            int celula = 0;

            Cell celNome = linha.createCell(celula++); // Celula 1
            celNome.setCellValue(row.getNome());

            Cell celEmail = linha.createCell(celula++); // Celula 2
            celEmail.setCellValue(row.getEmail());

            Cell celIdade = linha.createCell(celula++); // Celula 3
            celIdade.setCellValue(row.getIdade());

        } // Terminou de montar a planilha

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida); // Escreve a planilha em arquivo;
        saida.flush();
        saida.close();

        System.out.println("Planilha Criada");

    }

}