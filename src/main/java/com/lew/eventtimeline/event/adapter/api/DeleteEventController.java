package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.DeleteEventUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteEventController {

    DeleteEventUseCase deleteEventUseCase;

    @DeleteMapping(PathUtil.EVENT_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        deleteEventUseCase.delete(id);

        return ResponseEntity.ok().build();
    }
}
