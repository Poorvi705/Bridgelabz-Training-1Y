package com.gla.string;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ChatAnalytics {
    static Map<String, Integer> mentionCount = new HashMap<>();
    static Map<String, Integer> hashtagCount = new HashMap<>();
    static List<Integer> messageLengths = new ArrayList<>();
    static long startTime = System.currentTimeMillis();
}

class ChatFormatter {

    // Part A: Parse message
    public static Map<String, Integer> parseMessage(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message, " ");
        int words = 0, mentions = 0, hashtags = 0, commands = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.startsWith("@")) {
                mentions++;
                ChatAnalytics.mentionCount.put(token,
                        ChatAnalytics.mentionCount.getOrDefault(token, 0) + 1);
            } else if (token.startsWith("#")) {
                hashtags++;
                ChatAnalytics.hashtagCount.put(token,
                        ChatAnalytics.hashtagCount.getOrDefault(token, 0) + 1);
            } else if (token.startsWith("/")) {
                commands++;
            } else {
                words++;
            }
        }

        Map<String, Integer> counts = new HashMap<>();
        counts.put("words", words);
        counts.put("mentions", mentions);
        counts.put("hashtags", hashtags);
        counts.put("commands", commands);
        return counts;
    }

    // Part B: Format message
    public static String formatMessage(String user, String message) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(message, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.startsWith("@")) {
                sb.append("**").append(token).append("** ");
            } else if (token.startsWith("#")) {
                sb.append("*").append(token).append("* ");
            } else if (token.startsWith("/")) {
                sb.append("[CMD: ").append(token.substring(1)).append("] ");
            } else {
                sb.append(token).append(" ");
            }
        }

        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String formatted = "[" + time + "] " + user + ": " + sb.toString().trim();

        ChatAnalytics.messageLengths.add(formatted.length());
        return formatted;
    }
}

class ConversationBuffer {
    static StringBuffer conversation = new StringBuffer();

    public static synchronized void addMessage(String msg) {
        conversation.append(msg).append("\n");
    }
}

// User Thread
class ChatUser extends Thread {
    String user;
    String[] messages;
    int sleepTime;

    ChatUser(String user, String[] messages, int sleepTime) {
        this.user = user;
        this.messages = messages;
        this.sleepTime = sleepTime;
    }

    public void run() {
        for (String msg : messages) {
            System.out.println(user + " is typing...");
            ChatFormatter.parseMessage(msg);
            String formatted = ChatFormatter.formatMessage(user, msg);
            ConversationBuffer.addMessage(formatted);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
        }
    }
}

public class ChatMessageFormatterAnalyzer {

    public static void main(String[] args) {

        String[] aliceMsgs = {
                "Hey @Bob check out #JavaTutorial",
                "Anyone using #Java?",
                "Learning #Programming today",
                "Hello @Charlie",
                "/help"
        };

        String[] bobMsgs = {
                "@Alice thanks",
                "Using #SpringBoot now",
                "Love #Java",
                "Any tips @Charlie?",
                "Good night"
        };

        String[] charlieMsgs = {
                "/help how to join #JavaTutorial",
                "Hello everyone",
                "@Bob welcome",
                "Discussing #Programming",
                "Bye all"
        };

        Thread alice = new ChatUser("Alice", aliceMsgs, 100);
        Thread bob = new ChatUser("Bob", bobMsgs, 120);
        Thread charlie = new ChatUser("Charlie", charlieMsgs, 150);

        alice.start();
        bob.start();
        charlie.start();

        try {
            alice.join();
            bob.join();
            charlie.join();
        } catch (InterruptedException e) {}

        // Display conversation
        System.out.println("\n========= CHAT CONVERSATION =========");
        System.out.println(ConversationBuffer.conversation);

        // Analytics
        System.out.println("========= ANALYTICS =========");
        System.out.println("Total Messages: 15");

        String mostMentioned = ChatAnalytics.mentionCount.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("None");

        String mostHashtag = ChatAnalytics.hashtagCount.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("None");

        int totalLen = ChatAnalytics.messageLengths.stream().mapToInt(i -> i).sum();
        int maxLen = Collections.max(ChatAnalytics.messageLengths);
        int minLen = Collections.min(ChatAnalytics.messageLengths);

        System.out.println("Most Mentioned User: " + mostMentioned);
        System.out.println("Most Used Hashtag: " + mostHashtag);
        System.out.println("Average Message Length: " + (totalLen / 15));
        System.out.println("Longest Message Length: " + maxLen);
        System.out.println("Shortest Message Length: " + minLen);
        System.out.println("Conversation Duration (ms): " +
                (System.currentTimeMillis() - ChatAnalytics.startTime));
    }
}