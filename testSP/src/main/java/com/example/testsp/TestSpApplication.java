package com.example.testsp;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static com.example.testsp.Message.readMessagesFromFile;

@SpringBootApplication
public class TestSpApplication {

    public static void main(String[] args) {
        String filePath = "src/messages.json";

        List<Message> messages = Message.readMessagesFromFile(filePath);

        if (messages != null) {
            for (Message msg : messages) {
                System.out.println("Original Message: " + msg.getMessage());
                // Apelăm metoda pentru decodificare
                msg.decodeMessage();
                System.out.println("Decoded Message: " + msg.getMessage());
                System.out.println("House: " + msg.getHouse());
                System.out.println();
            }
        }
    }
}




