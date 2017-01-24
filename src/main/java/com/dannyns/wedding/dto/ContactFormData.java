package com.dannyns.wedding.dto;

public class ContactFormData {

    private String name;
    private String email;
    private String topic;
    private String target;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ContactFormData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", topic='" + topic + '\'' +
                ", target='" + target + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
