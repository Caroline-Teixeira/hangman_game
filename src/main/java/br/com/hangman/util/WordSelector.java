package br.com.hangman.util;

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
        String normalizedTopic = topic.toLowerCase().trim();
        if (!wordsByTopic.containsKey(normalizedTopic)) {
            String suggestion = suggestTopic(normalizedTopic);
            throw new IllegalArgumentException("Tópico inválido: '" + topic + "'. Tópicos disponíveis: " + 
                getAvailableTopics() + ". Talvez você quis dizer: " + suggestion);
        }
        List<String> words = wordsByTopic.get(normalizedTopic);
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma palavra disponível para o tópico: " + topic);
        }
        String selectedWord = words.get(new Random().nextInt(words.size()));
        if (selectedWord == null || selectedWord.isEmpty()) {
            throw new IllegalArgumentException("Palavra selecionada é inválida para o tópico: " + topic);
        }
        return selectedWord;
    }

    private String suggestTopic(String input) {
    
        for (String topic : wordsByTopic.keySet()) {
            if (topic.startsWith(input)) {
                return topic;
            }
        }
        return getAvailableTopics().get(0); // Retorna o primeiro tópico disponível como sugestão
    }
}