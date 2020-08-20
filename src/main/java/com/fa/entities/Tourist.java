package com.fa.entities;

import javax.persistence.*;

@Entity
@Table
public class Tourist {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
