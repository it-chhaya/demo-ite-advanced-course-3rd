package co.istad.chanchhaya.ecommerce.restapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record RestApiErrorResponse<T>(
        String code,
        String message,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T detail
) {
}
