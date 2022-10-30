package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.type.domain.port.api.DeleteTypeUseCase;
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
public class DeleteTypeController {

    DeleteTypeUseCase deleteTypeUseCase;

    @DeleteMapping(PathUtil.TYPE_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        deleteTypeUseCase.delete(id);

        return ResponseEntity.ok().build();
    }
}
