package com.example.testsp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Message {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonProperty("date")
    private String date;

    @JsonProperty("message")
    private String message;

    @JsonProperty("house")
    private String house;

    // Default constructor
    public Message() {
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void decodeMessage() {
        if ("Atreides".equals(house)) {
            // Decodifica mesajele de la Atreides
            message = message.replace("Jbppf", "Messi");
        } else if ("Harkonnen".equals(house)) {
            // Decodifica mesajele de la Harkonnen
            message = message.replace("Oguuk", "Messi");
        }
    }

    public static List<Message> readMessagesFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            URL fileUrl = new URL("file:" + filePath);
            return objectMapper.readValue(fileUrl, new TypeReference<List<Message>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
