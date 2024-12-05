package com.tharun.Crud_Operation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="tutorial")
@NoArgsConstructor
@AllArgsConstructor
public class Crud_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private String  description;
    private boolean published;



    public Crud_Model(String title, String description, boolean b) {
    }
}
