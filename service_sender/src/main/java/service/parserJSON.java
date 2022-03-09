package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ServiceAccountantDTO;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class parserJSON {
    public static List to_parse (String path, Class<ServiceAccountantDTO[]> valueType) {
        List<ServiceAccountantDTO> list = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = Arrays.asList(objectMapper.readValue(Paths.get(path).toFile(), valueType));
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return list;
        }
    }
}
