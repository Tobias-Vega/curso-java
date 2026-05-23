package com.devtalles.proyecto;

import lombok.*;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Value
@Data
@Builder
@ToString
public class Person {
    private String name;
    private int age;
    private String lastName;
}
