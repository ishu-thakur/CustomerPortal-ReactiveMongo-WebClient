package com.webClient.webClientReactiveMongo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebClientEmployee {

    private String id;
    private String name;
    private int age;
}
