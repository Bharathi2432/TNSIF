package com.tnsif.PlacementMangement.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        College college = collegeService.getCollegeById(id);
        return college != null ? ResponseEntity.ok(college) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College savedCollege = collegeService.saveCollege(college);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCollege);
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        College existingCollege = collegeService.getCollegeById(id);
        if (existingCollege == null) {
            return ResponseEntity.notFound().build();
        }
        college.setId(id);
        College updatedCollege = collegeService.saveCollege(college);
        return ResponseEntity.ok(updatedCollege);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        College existingCollege = collegeService.getCollegeById(id);
        if (existingCollege == null) {
            return ResponseEntity.notFound().build();
        }
        collegeService.deleteCollege(id);
        return ResponseEntity.noContent().build();
    }
}
