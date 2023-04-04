package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusItineraryEntity {
    @Id()
    private Long id;
    @Column(unique = true)
    private String code;
    @Column()
    private String name;
    @Column()
    private String itinerary;
}
