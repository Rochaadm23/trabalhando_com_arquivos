package arquivos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSON {

    public static void main(String[] args) throws IOException, UnsupportedEncodingException, FileNotFoundException {

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        usuario1.setNome("Fernando Rocha");
        usuario1.setLogin("fernando.rocha");
        usuario1.setSenha("12345678");
        usuario1.setCpf("18895589878");

        usuario2.setNome("Samuel Rocha");
        usuario2.setLogin("samuel.rocha");
        usuario2.setSenha("12345678");
        usuario2.setCpf("18895589878");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        OutputStreamWriter fileWriter = new OutputStreamWriter(
                new FileOutputStream("D:\\workspace\\Git\\Jdev\\arquivos\\arquivo.json"), "UTF-8");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();
    }
}