package co.istad.chanchhaya.ecommerce.restapi.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record PageResponse<T>(
        List<T> items,
        int page,
        int size,
        boolean hasNext
) {
}
