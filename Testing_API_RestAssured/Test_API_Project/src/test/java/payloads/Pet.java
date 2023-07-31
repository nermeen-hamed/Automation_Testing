package payloads;

import groovy.lang.GString;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pet {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }





    public List<HashMap> getTags() {
        return tags;
    }

    public void setTags(List<HashMap> tags) {
        this.tags = tags;
    }

    String id;
    HashMap<String, String> category = new HashMap<String, String>();

    String name;
    List<String>photoUrls=new ArrayList<>();

    List <HashMap>tags=new ArrayList<>();
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
