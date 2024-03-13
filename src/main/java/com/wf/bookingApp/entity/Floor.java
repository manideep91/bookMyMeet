package com.wf.bookingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "floors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {

    @Id
    private String id;

    private int floorNumber;

    @DBRef
    private List<Room> rooms;
}
