package io.github.frankleyrocha.groqapi.examples;

import io.github.frankleyrocha.groqapi.GroqApi;

public class SingleMessageWithSystemExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "What is Java?", //User message
            "You are an assistant who provides short, "+ //System message
            "concise, and objective answers of no more than 5 lines."
        );

        System.out.println(assistantMessage);

    }
}