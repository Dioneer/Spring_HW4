package Pegas.dto;

import lombok.Value;

import java.util.List;

public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    @Value
    public static class Metadata{
        int page;
        int size;
        long totalElements;
    }
}
