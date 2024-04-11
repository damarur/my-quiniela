package es.damarur.myquiniela.controller.v1.admin;

import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.mapper.AdminMapper;
import es.damarur.myquiniela.model.v1.admin.AdminQuinielaDTO;


import es.damarur.myquiniela.service.QuinielaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class QuinielaAdminController implements QuinielaAdmin {

    private final NativeWebRequest request;
    private final QuinielaService quinielaService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<AdminQuinielaDTO> getQuinielaById(Long quinielaId) {
        return QuinielaAdmin.super.getQuinielaById(quinielaId);
    }

    @Override
    public ResponseEntity<AdminQuinielaDTO> addQuiniela(AdminQuinielaDTO adminQuinielaDTO) {
        Quiniela quiniela = AdminMapper.INSTANCE.fromAdminQuiniela(adminQuinielaDTO);
        Quiniela storedQuiniela = quinielaService.addQuiniela(quiniela);
        return ResponseEntity.ok(AdminMapper.INSTANCE.fromQuiniela(storedQuiniela));
    }

    @Override
    public ResponseEntity<Void> updateQuiniela(Long quinielaId) {
        return QuinielaAdmin.super.updateQuiniela(quinielaId);
    }

    @Override
    public ResponseEntity<Void> deleteQuiniela(Long quinielaId) {
        return QuinielaAdmin.super.deleteQuiniela(quinielaId);
    }

}
