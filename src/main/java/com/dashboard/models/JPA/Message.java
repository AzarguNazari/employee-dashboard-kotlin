package com.dashboard.models.JPA;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "message")
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String message;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created;

    public Message(String message){
        this.message = message;
    }
}
