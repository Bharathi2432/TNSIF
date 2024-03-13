package com.tnsif.PlacementMangement.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    @Override
    public College saveCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
