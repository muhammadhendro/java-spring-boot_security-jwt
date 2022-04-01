package com.hendro.springsecurity.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {


    @Serial
    private static final long serialVersionUID = -6931238964079082050L;



    private Object data;
}