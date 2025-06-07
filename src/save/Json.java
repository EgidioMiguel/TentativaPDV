package save;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Json {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) 
            .setPrettyPrinting()
            .create();

    public static <T> void salvarLista(List<T> lista, String caminhoArquivo) throws Exception {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(caminhoArquivo), StandardCharsets.UTF_8)) {
            gson.toJson(lista, writer);
        }
    }

    public static <T> List<T> carregarLista(String caminhoArquivo, Class<T> clazz) throws Exception {
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(caminhoArquivo), StandardCharsets.UTF_8)) {
            Type tipoLista = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, tipoLista);
        }
    }
}