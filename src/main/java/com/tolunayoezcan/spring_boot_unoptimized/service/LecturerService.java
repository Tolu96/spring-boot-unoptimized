package com.tolunayoezcan.spring_boot_unoptimized.service;

import com.tolunayoezcan.spring_boot_unoptimized.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_unoptimized.mapper.LecturerMapper;
import com.tolunayoezcan.spring_boot_unoptimized.model.Lecturer;
import com.tolunayoezcan.spring_boot_unoptimized.repository.DegreeProgramRepository;
import com.tolunayoezcan.spring_boot_unoptimized.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class LecturerService {

    private LecturerRepository lecturerRepository;
    private DegreeProgramRepository degreeProgramRepository;
    private LecturerMapper lecturerMapper;

    public List<LecturerDTO> getAllLecturers() {
        return lecturerMapper.modelsToDto(lecturerRepository
                .findAll());
    }

    public LecturerDTO getLecturerById(int lecturerId) {
        return lecturerMapper.modelToDto(lecturerRepository
                .findById(lecturerId)
                .orElseThrow());
    }

    public LecturerDTO getLecturerByPersonnelNumber(int personnelNumber) {
        return lecturerMapper.modelToDto(lecturerRepository
                .findAll()
                .stream()
                .filter(l -> l.getPersonnelNumber() == personnelNumber)
                .findFirst()
                .orElseThrow());
    }

    public List<LecturerDTO> getAllLecturersByDean(boolean isDean) {
        return lecturerMapper.modelsToDto(lecturerRepository
                .findAll()
                .stream()
                .filter(l -> l.isDean() == isDean)
                .toList());
    }

    public List<LecturerDTO> getAllLecturersByDegreeProgramId(int degreeProgramId) {
        return lecturerMapper.modelsToDto(lecturerRepository
                .findAll()
                .stream()
                .filter(l -> l.getDegreeProgram().getDegreeProgramId() == degreeProgramId)
                .toList());
    }

    @Transactional
    public LecturerDTO createNewLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.dtoToModel(lecturerDTO);

        return lecturerMapper.modelToDto(lecturerRepository.save(lecturer));
    }

    @Transactional
    public LecturerDTO updateLecturer(int lecturerId, Lecturer lecturerToUpdate) {
        lecturerToUpdate.setLecturerId(lecturerId);
        lecturerToUpdate.setDegreeProgram(lecturerRepository.findById(lecturerId).orElseThrow().getDegreeProgram());

        return lecturerMapper.modelToDto(lecturerRepository.save(lecturerToUpdate));
    }

    public void deleteLecturer(int lecturerId) {
        if (lecturerRepository.existsById(lecturerId)) {
            lecturerRepository.deleteById(lecturerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer with this Id was not found");
        }
    }


}
