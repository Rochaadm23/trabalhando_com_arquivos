package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiRead {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(new File("D:\\workspace\\Git\\Jdev\\arquivos\\arquivo_excel.xls."));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file); // Prepara a entrada do arquivo excel
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pega a primeira planilha do arquivo excel

        Iterator<Row> linhaIterator = planilha.iterator();
        
        List<Pessoa> pessoas = new ArrayList<>();

        while(linhaIterator.hasNext()){ // Equanto tiver linha no arquivo excel
            
            Row linha = linhaIterator.next(); // Dados da pessoa na linha
            
            Iterator<Cell> celula = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while(celula.hasNext()){
                Cell cell = celula.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                }
            }

            pessoas.add(pessoa);
        }
        file.close();
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
    
}