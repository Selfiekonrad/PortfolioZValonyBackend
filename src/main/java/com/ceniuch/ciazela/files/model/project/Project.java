package com.ceniuch.ciazela.files.model.project;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "date",
    "description",
    "specificDescription",
    "languages",
    "profilePictureUrl",
    "user"
})
@Generated("jsonschema2pojo")
public class Project {

    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("description")
    private String description;
    @JsonProperty("specificDescription")
    private String specificDescription;
    @JsonProperty("languages")
    private List<String> languages;
    @JsonProperty("profilePictureUrl")
    private String profilePictureUrl;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Project() {
    }

    public Project(String title, LocalDate date, String description, String specificDescription, List<String> languages, String profilePictureUrl, String user) {
        super();
        this.title = title;
        this.date = date;
        this.description = description;
        this.specificDescription = specificDescription;
        this.languages = languages;
        this.profilePictureUrl = profilePictureUrl;
        this.user = user;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("date")
    public LocalDate getDate() {return date;}

    @JsonProperty("date")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("specificDescription")
    public String getSpecificDescription() {
        return specificDescription;
    }

    @JsonProperty("specificDescription")
    public void setSpecificDescription(String specificDescription) {
        this.specificDescription = specificDescription;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @JsonProperty("profilePictureUrl")
    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    @JsonProperty("profilePictureUrl")
    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Project.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("specificDescription");
        sb.append('=');
        sb.append(((this.specificDescription == null)?"<null>":this.specificDescription));
        sb.append(',');
        sb.append("languages");
        sb.append('=');
        sb.append(((this.languages == null)?"<null>":this.languages));
        sb.append(',');
        sb.append("profilePictureUrl");
        sb.append('=');
        sb.append(((this.profilePictureUrl == null)?"<null>":this.profilePictureUrl));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
