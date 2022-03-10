package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ServiceAccountantDTO;

import java.util.Arrays;
import java.util.List;

public class parserJSON {
    public static List to_parse (String str, Class<ServiceAccountantDTO[]> valueType) {
        List<ServiceAccountantDTO> list = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = Arrays.asList(objectMapper.readValue(str, valueType));
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return list;
        }
    }
}
