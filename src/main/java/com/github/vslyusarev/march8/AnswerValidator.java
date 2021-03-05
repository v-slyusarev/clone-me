package com.github.vslyusarev.march8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AnswerValidator {
    boolean validate(String answer, String key) {
        final Decoder decoder = new Decoder();
        try {
            final String correctAnswer = decoder.decode(new String(Files.readAllBytes(Paths.get("answer.txt"))), key);
            return answer.toLowerCase().replaceAll("\\W", "").equals(correctAnswer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
