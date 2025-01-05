package com.ceniuch.ciazela.files.dataManagerImpl;

import com.ceniuch.ciazela.files.dataManager.ProjectManager;
import com.ceniuch.ciazela.files.model.project.Project;
import com.ceniuch.ciazela.files.model.user.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class PropertyFileProjectManagerImpl implements ProjectManager {

    String fileName;

    static PropertyFileProjectManagerImpl projectFileProjectManager = null;

    private PropertyFileProjectManagerImpl(String fileName) {
        this.fileName = fileName;
    }

    static public PropertyFileProjectManagerImpl getPropertyFileProjectManager(String fileName) {
        if (projectFileProjectManager == null) {
            projectFileProjectManager = new PropertyFileProjectManagerImpl(fileName);
        }
        return projectFileProjectManager;
    }

    @Override
    public List<Project> getAllProjectsByUser(String username) {

        List<Project> projects = new ArrayList<>();
        Properties properties = new Properties();

        try {

            properties.load(Files.newInputStream(Paths.get(fileName)));
            int i = 1;

            while (properties.containsKey("Project." + i + ".title")) {
                String title = properties.getProperty("Project." + i + ".title");
                LocalDate date = LocalDate.parse(properties.getProperty("Project." + i + ".date"));
                String description = properties.getProperty("Project." + i + ".description");
                String languages = properties.getProperty("Project." + i + ".languages");
                String specificDescription = properties.getProperty("Project." + i + ".specificDescription");
                String profilePictureUrl = properties.getProperty("Project." + i + ".profilePictureUrl");
                String user = properties.getProperty("Project." + i + ".user");



                if (user.equals(username)) {
                    projects.add(new Project(
                            title, date, description, specificDescription, getListOfLanguages(languages), profilePictureUrl, user
                    ));
                }

                i++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    List<String> getListOfLanguages(String languages) {
        return languages != null ? Arrays.asList(languages.split(",")) : null;
    }

    @Override
    public void addProject(Project project, String username) {
        
    }

    // TODO: integrate getUserMethod with tokens or change it completely
    @Override
    public String getUserFromToken(String token) {
        if (token.equals("123"))
            return "Selfiekonrad";
        else
            return "placeholder";
    }

    // TODO make more pretty
    int getLastIndexOfProperties(Properties properties) {
        int projectsCount = 0;

        try {
            properties.load(Files.newInputStream(Paths.get(fileName)));
            int i = 1;

            while (properties.containsKey("Project." + i + ".title")) {
                projectsCount++;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return projectsCount;
    }
}
