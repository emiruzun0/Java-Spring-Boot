package com.emirhanuzun.cruddemo.entity.dao;

import com.emirhanuzun.cruddemo.entity.Instructor;
import com.emirhanuzun.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
