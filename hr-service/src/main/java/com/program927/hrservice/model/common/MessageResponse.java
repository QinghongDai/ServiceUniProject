package com.program927.hrservice.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {
    private String message;
}