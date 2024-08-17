package com.tolunayoezcan.spring_boot_unoptimized.service;

import com.tolunayoezcan.spring_boot_unoptimized.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_unoptimized.enums.CampusEnum;
import com.tolunayoezcan.spring_boot_unoptimized.mapper.DegreeProgramMapper;
import com.tolunayoezcan.spring_boot_unoptimized.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_unoptimized.repository.DegreeProgramRepository;
import com.tolunayoezcan.spring_boot_unoptimized.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DegreeProgramService {
    private DegreeProgramRepository degreeProgramRepository;
    private FacultyRepository facultyRepository;
    private DegreeProgramMapper degreeProgramMapper;

    public List<DegreeProgramDTO> getAllDegreePrograms() {
        return degreeProgramMapper.modelsToDto(degreeProgramRepository.findAll());
    }

    public DegreeProgramDTO getAllDegreeProgramsById(int degreeProgramId) {
        return degreeProgramMapper.modelToDto(degreeProgramRepository.findById(degreeProgramId).orElseThrow());
    }

    public List<DegreeProgramDTO> getAllDegreeProgramsByCampus(CampusEnum campus) {
        return degreeProgramMapper.modelsToDto(degreeProgramRepository
                .findAll()
                .stream()
                .filter(d -> d.getCampus().equals(campus))
                .toList());
    }

    public List<DegreeProgramDTO> getAllDegreeProgramsByFacultyId(int facultyId) {

        return degreeProgramMapper.modelsToDto(degreeProgramRepository
                .findAll()
                .stream()
                .filter(d -> d.getFaculty().getFacultyId() == facultyId)
                .toList());
    }

    @Transactional
    public DegreeProgramDTO createNewDegreeProgram(DegreeProgramDTO degreeProgramDTO) {
        DegreeProgram degreeProgram = degreeProgramMapper.dtoToModel(degreeProgramDTO);

        return degreeProgramMapper.modelToDto(degreeProgramRepository.save(degreeProgram));
    }

    @Transactional
    public DegreeProgramDTO updateDegreeProgram(int degreeProgramId, DegreeProgram degreeProgramToUpdate) {
        degreeProgramToUpdate.setDegreeProgramId(degreeProgramId);
        degreeProgramToUpdate.setFaculty(degreeProgramRepository.findById(degreeProgramId).get().getFaculty());
        return degreeProgramMapper.modelToDto(degreeProgramRepository.save(degreeProgramToUpdate));
    }

    public void deleteDegreeProgram(int degreeProgramId) {
        if (degreeProgramRepository.existsById(degreeProgramId)) {
            degreeProgramRepository.deleteById(degreeProgramId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DegreeProgram with this Id was not found");
        }
    }

}
