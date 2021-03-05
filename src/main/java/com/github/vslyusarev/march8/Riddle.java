package com.github.vslyusarev.march8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Riddle {
    public static void main(String[] args) {
        final String key = "I don't trust the creatures who live inside as in wait for me. I just want to know what I look like in the morning.";
        final Decoder decoder = new Decoder();

        new ObjectComparator().annoy(); // Этот класс только портит всё. Просто удали его!

        System.out.print("If you want a lover\n" +
                "I'll do anything you ask me to\n" +
                "And if you want another kind of love\n" +
                "I'll wear a mask for you\n" +
                "If you want a partner, take my hand, or\n" +
                "If you want to strike me down in anger\n" +
                "Here I stand...\n" +
                "Введи ответ: ");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        scanner.close();

        if(new AnswerValidator().validate(answer, key)) {
            try {
                System.out.println(decoder.decode(new String(Files.readAllBytes(Paths.get("secret.txt"))), key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Try again!");
        }
    }
}
