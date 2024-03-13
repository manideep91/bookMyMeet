package com.wf.bookingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    private String id;
    private String name;
    private String address;

    @DBRef
    private List<Building> buildings;

}