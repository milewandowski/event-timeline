package com.lew.eventtimeline.event.domain.port.db;

import com.lew.eventtimeline.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
