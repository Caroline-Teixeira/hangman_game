package main.java.br.com.hangman.util;

import java.util.*;

public class WordSelector {
    private final Map<String, List<String>> wordsByTopic;

    public WordSelector() {
        this.wordsByTopic = new HashMap<>();
        wordsByTopic.put("programacao", Arrays.asList("JAVA", "PYTHON", "JAVASCRIPT", "RUBY", "KOTLIN", "SWIFT"));
        wordsByTopic.put("comida", Arrays.asList("PIZZA", "HAMBURGUER", "SUSHI", "LASANHA", "FEIJOADA", "TACOS"));
        wordsByTopic.put("casa", Arrays.asList("SOFA", "CAMA", "MESA", "CADEIRA", "GELADEIRA", "FOGAO"));
    }

    public List<String> getAvailableTopics() {
        return new ArrayList<>(wordsByTopic.keySet());
    }

    public String getRandomWordByTopic(String topic) {
        List<String> words = wordsByTopic.getOrDefault(topic.toLowerCase(), wordsByTopic.get("programacao"));
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Tópico inválido: " + topic + ". Usando padrão.");
        }
        return words.get(new Random().nextInt(words.size()));
    }
}