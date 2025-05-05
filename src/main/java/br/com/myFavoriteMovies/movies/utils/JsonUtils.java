package br.com.myFavoriteMovies.movies.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> byte[] toJsonByteArray(T object) throws IOException {
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T fromJsonByteArray(byte[] bytes, Class<T> clazz) throws IOException {
        return mapper.readValue(bytes, clazz);
    }

    public static <T> T fromJsonByteArray(byte[] bytes, TypeReference<T> typeRef) throws IOException {
        return mapper.readValue(bytes, typeRef);
    }
}
