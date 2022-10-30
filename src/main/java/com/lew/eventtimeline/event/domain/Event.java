package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.type.domain.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String shortDesc;
    String longDesc;
    String imageUrl;
    LocalDate startDate;
    LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    Type type;
}
