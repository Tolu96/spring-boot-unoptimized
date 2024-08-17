package com.tolunayoezcan.spring_boot_unoptimized.service;

import com.tolunayoezcan.spring_boot_unoptimized.dto.ExamDTO;
import com.tolunayoezcan.spring_boot_unoptimized.enums.StatusEnum;
import com.tolunayoezcan.spring_boot_unoptimized.mapper.ExamMapper;
import com.tolunayoezcan.spring_boot_unoptimized.model.Exam;
import com.tolunayoezcan.spring_boot_unoptimized.model.Student;
import com.tolunayoezcan.spring_boot_unoptimized.repository.ExamRepository;
import com.tolunayoezcan.spring_boot_unoptimized.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExamService {
    private ExamRepository examRepository;
    private StudentRepository studentRepository;
    private ExamMapper examMapper;

    public List<ExamDTO> getAllExams() {
        return examMapper.modelsToDto(examRepository.findAll());
    }

    public ExamDTO getExamById(UUID examId) {
        return examMapper.modelToDto(examRepository.findById(examId).orElseThrow());
    }

    public List<ExamDTO> getAllExamsByStudentId(UUID studentId) {
        return examMapper.modelsToDto(examRepository
                .findAll()
                .stream()
                .filter(e -> e.getStudent().getStudentId().equals(studentId))
                .toList());
    }

    @Transactional
    public ExamDTO createNewExam(ExamDTO examDTO) {
        Exam exam = examMapper.dtoToModel(examDTO);
        exam.setStatus(StatusEnum.AN);
        exam.setAttempt((byte) 1);

        if (exam.getGrade() > 4.0) {
            exam.setStatus(StatusEnum.NB);
        } else if (exam.getGrade() <= 4.0) {
            exam.setStatus(StatusEnum.BE);
        }

        return examMapper.modelToDto(examRepository.save(exam));
    }

    @Transactional
    public ExamDTO updateExam(UUID examId, Exam examToUpdate) {
        Student student = studentRepository.findById(examToUpdate.getStudent().getStudentId()).orElseThrow();
        examToUpdate.setExamId(examId);
        examToUpdate.setStudent(student);
        return examMapper.modelToDto(examRepository.save(examToUpdate));
    }

    public void deleteExam(UUID examId) {
        if (examRepository.existsById(examId)) {
            examRepository.deleteById(examId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam with this Id was not found");
        }
    }

}
