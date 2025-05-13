package com.example.eventosconwhereby.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDto {
    private Long orderId;
    private String email;
    private List<String> products;

}