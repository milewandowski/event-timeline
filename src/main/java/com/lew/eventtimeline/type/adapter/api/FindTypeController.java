package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.api.FindEventsPageUseCase;
import com.lew.eventtimeline.event.domain.port.api.GetEventUseCase;
import com.lew.eventtimeline.type.domain.port.api.FindTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.GetTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindTypeController {

    FindTypeUseCase findTypeUseCase;
    GetTypeUseCase getTypeUseCase;

    @GetMapping(PathUtil.TYPE)
    public ResponseEntity<List<TypeDto>> find() {

        return ResponseEntity.ok(findTypeUseCase.find());
    }

    @GetMapping(PathUtil.TYPE_ID)
    public ResponseEntity<TypeDto> get(@PathVariable Long id) {

        return ResponseEntity.ok(getTypeUseCase.get(id));
    }
}
