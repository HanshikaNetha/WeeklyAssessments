package com.example.SpringRestOnlineCourseManagment.service;

import com.example.SpringRestOnlineCourseManagment.dto.MaterialResponse;
import com.example.SpringRestOnlineCourseManagment.dto.MaterialUpload;
import com.example.SpringRestOnlineCourseManagment.entity.Course;
import com.example.SpringRestOnlineCourseManagment.entity.CourseMaterial;
import com.example.SpringRestOnlineCourseManagment.repository.CourseMaterialRepository;
import com.example.SpringRestOnlineCourseManagment.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CourseMaterialService {
    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public MaterialResponse uploadMaterial(MaterialUpload materialUpload){
        Course course=courseRepository.findById(materialUpload.getCourseId()).orElseThrow(()->new RuntimeException("course not found"));
        CourseMaterial material = new CourseMaterial();
        material.setTitle(materialUpload.getTitle());
        material.setFileName(materialUpload.getFileName());
        material.setCourse(course);
        material.setUploadDate(LocalDate.now());
        String filetype=material.getFileName().substring(material.getFileName().lastIndexOf(".")+1);
        material.setFileType(filetype);
        CourseMaterial savedMaterial=courseMaterialRepository.save(material);
        String url="/material/"+savedMaterial.getId()+"/download";
        savedMaterial.setFileUrl(url);
        courseMaterialRepository.save(savedMaterial);
        MaterialResponse materialResponse=modelMapper.map(savedMaterial, MaterialResponse.class);
        return materialResponse;
    }

    public MaterialResponse downloadMaterial(Long id){
        CourseMaterial courseMaterial=courseMaterialRepository.findById(id).orElseThrow(()->new RuntimeException("CourseMaterial not found"));
        MaterialResponse materialResponse=modelMapper.map(courseMaterial, MaterialResponse.class);
        return materialResponse;
    }

    public MaterialResponse getMaterialByCourse(Long id){
        CourseMaterial courseMaterial=courseMaterialRepository.findByCourseCourseId(id).orElseThrow(()->new RuntimeException("course not found"));
        MaterialResponse materialResponse=modelMapper.map(courseMaterial, MaterialResponse.class);
        return materialResponse;
    }
}
