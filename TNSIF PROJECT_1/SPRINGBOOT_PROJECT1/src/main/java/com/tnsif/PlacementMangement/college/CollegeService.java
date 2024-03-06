package com.tnsif.PlacementMangement.college;

import java.util.List;

public interface CollegeService {
    List<College> getAllColleges();
    College getCollegeById(Long id);
    College saveCollege(College college);
    void deleteCollege(Long id);
}

