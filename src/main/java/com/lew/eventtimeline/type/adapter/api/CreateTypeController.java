package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.type.domain.port.api.CreateTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateTypeController {

    CreateTypeUseCase createTypeUseCase;

    @PostMapping(PathUtil.TYPE)
    public ResponseEntity<TypeDto> create(@RequestBody @Valid TypeDto typeDto) {

        return ResponseEntity.ok(createTypeUseCase.create(typeDto));
    }
}
