package com.emirhanuzun.cruddemo.entity.dao;

import com.emirhanuzun.cruddemo.entity.Instructor;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
