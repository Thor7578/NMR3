package com.example.demo.repositories;

import com.example.demo.models.Extra;

import java.util.List;

public interface ExtrasRepo {
    public interface IStudentRepository {
        // CRUD operations
        public boolean create(Extra extra);

        public Extra read(String extraName);

        public List<Extra> readAll();

        public boolean update(Extra extra);

        public boolean delete(String extraName);
    }
}
