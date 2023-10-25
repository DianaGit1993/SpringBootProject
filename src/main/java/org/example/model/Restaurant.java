package org.example.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Restaurant {
    private int id;
    private String name;
    private String type;
    private int numberOfTables;

}
