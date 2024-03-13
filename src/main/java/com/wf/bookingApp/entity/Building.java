package com.wf.bookingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "buildings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<Floor> floors;

    // Getters and setters
}