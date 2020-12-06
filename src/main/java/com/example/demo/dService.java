package com.example.demo;

import java.util.List;

public interface dService {
    List<Directory> getALL();
    Directory get(Integer id);
    void save(Directory d);
    void delete(Integer id);
}
