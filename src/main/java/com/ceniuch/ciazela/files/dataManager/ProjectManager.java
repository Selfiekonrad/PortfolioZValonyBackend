package com.ceniuch.ciazela.files.dataManager;

import com.ceniuch.ciazela.files.model.project.Project;
import com.ceniuch.ciazela.files.model.user.User;

import java.util.List;

public interface ProjectManager {
    List<Project> getAllProjectsByUser(String username);
    void addProject(Project project, String username);
    // TODO: is the getUserFromToken method right?
    String getUserFromToken(String token);
}
