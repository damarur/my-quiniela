package es.damarur.myquiniela.service;

import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.model.v1.admin.AdminQuinielaDTO;
import es.damarur.myquiniela.repository.QuinielaRepository;
import es.damarur.myquiniela.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuinielaService {

    private final QuinielaRepository quinielaRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public Quiniela addQuiniela(Quiniela quiniela) {
        // TODO validations
        // 1. future date-time
        // 2. matches & teams?
        return quinielaRepository.save(quiniela);
    }
}
