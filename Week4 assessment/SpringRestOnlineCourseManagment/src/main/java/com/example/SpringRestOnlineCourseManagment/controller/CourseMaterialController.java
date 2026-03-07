package com.example.SpringRestOnlineCourseManagment.controller;

import com.example.SpringRestOnlineCourseManagment.dto.MaterialResponse;
import com.example.SpringRestOnlineCourseManagment.dto.MaterialUpload;
import com.example.SpringRestOnlineCourseManagment.service.CourseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CourseMaterials")
public class CourseMaterialController {
    private final CourseMaterialService courseMaterialService;

    @PostMapping("/addCourseMaterial")
    public ResponseEntity<String> addCourseMaterial(@RequestBody MaterialUpload materialUpload){
        MaterialResponse materialResponse=courseMaterialService.uploadMaterial(materialUpload);
        return ResponseEntity.ok(materialResponse.getTitle()+"is uploaded");
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<MaterialResponse> downloadMaterialByid(@PathVariable("id") Long id){
        MaterialResponse materialResponse=courseMaterialService.downloadMaterial(id);
        return ResponseEntity.ok(materialResponse);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<MaterialResponse> getCourseeMaterialByCourseid(@PathVariable("id") Long id){
        MaterialResponse materialResponse=courseMaterialService.getMaterialByCourse(id);
        return ResponseEntity.ok(materialResponse);
    }
}
