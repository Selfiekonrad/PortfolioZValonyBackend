package com.ceniuch.ciazela.files;

import com.ceniuch.ciazela.files.dataManager.ProjectManager;
import com.ceniuch.ciazela.files.dataManagerImpl.PropertyFileProjectManagerImpl;
import com.ceniuch.ciazela.files.model.project.Project;
import com.ceniuch.ciazela.files.model.project.TokenProject;
import com.ceniuch.ciazela.files.model.MessageAnswer;
import com.ceniuch.ciazela.files.model.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    ProjectManager propertyFileProjectManager =
            PropertyFileProjectManagerImpl.getPropertyFileProjectManager(
                    "src/main/resources/ProjectList.properties"
            );

    @PostMapping(
            path="/users",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public MessageAnswer createUser(@RequestBody User user) {

        Logger logger = Logger.getLogger("CreateUserLogger");
        logger.info("Received a POST request on users with user-email: " + user.getEmail());

        // TODO create user in database

        MessageAnswer answer = new MessageAnswer();
        answer.setMessage("Successfully created user with email: " + user.getEmail());

        return answer;
    }

    @PostMapping(
            path="/project",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public MessageAnswer createProject(@RequestBody TokenProject tokenProject) {


        Logger logger = Logger.getLogger("CreateProjectLogger");
        logger.info("Received a POST request on project with token: " + tokenProject.getToken());

        // TODO create user in database
        // TODO if token valid

        propertyFileProjectManager.addProject(tokenProject.getProject(), "123");

        MessageAnswer answer = new MessageAnswer();
        answer.setMessage("Token was " + tokenProject.getToken() + " and the project title was: " + tokenProject.getProject().getTitle());

        return answer;
    }

    @GetMapping("/project")
    public List<Project> getProjects(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "token", defaultValue = "123") String token) {

        Logger myLogger = Logger.getLogger("CreateTaskLogger");
        myLogger.info("Received a GET request on hszg-tasks with token " + token);

        // check Token
        // TokenManager

        final List<Project> allProject = propertyFileProjectManager.getAllProjectsByUser(username);

        return allProject;
    }

}
