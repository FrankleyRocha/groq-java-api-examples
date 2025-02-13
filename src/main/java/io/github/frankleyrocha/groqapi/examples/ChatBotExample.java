package io.github.frankleyrocha.groqapi.examples;

import java.util.Scanner;

import io.github.frankleyrocha.groqapi.GroqApi;
import io.github.frankleyrocha.groqapi.GroqChatBot;

public class ChatBotExample {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";
        GroqApi api = new GroqApi(apiKey);
        GroqChatBot bot = new GroqChatBot(
            api,
            model,
            "You are an assistant who speaks Portuguese. Speak in the most human-like manner possible!"
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! You are chatting with the model: " + model);
        System.out.println("Type \"exit\" to end the conversation.");

        while (true) {
            System.out.print("$ ");
            String userMessage = sc.nextLine();

            if ("exit".equalsIgnoreCase(userMessage)) {
                sc.close();
                break;
            }

            String assistantMessage = bot.chat(userMessage);

            System.out.println();
            System.out.println(assistantMessage);
            System.out.println();
        }
    }
}