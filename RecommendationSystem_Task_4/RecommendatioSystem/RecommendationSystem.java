import java.io.*;
import java.util.*;

public class RecommendationSystem {

    // Map<User, Map<Product, Rating>>
    private static Map<String, Map<String, Double>> userRatings = new HashMap<>();

    public static void main(String[] args) {
        loadRatings("ratings.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username to get recommendations: ");
        String user = scanner.nextLine();

        recommendProducts(user);
    }

    // Load ratings from CSV
    private static void loadRatings(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String user = data[0];
                String product = data[1];
                double rating = Double.parseDouble(data[2]);

                userRatings.putIfAbsent(user, new HashMap<>());
                userRatings.get(user).put(product, rating);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Simple recommendation logic (average rating method)
    private static void recommendProducts(String user) {
        if (!userRatings.containsKey(user)) {
            System.out.println("User not found!");
            return;
        }

        Map<String, Double> allProducts = new HashMap<>();

        for (Map<String, Double> ratings : userRatings.values()) {
            for (String product : ratings.keySet()) {
                allProducts.put(product, 0.0);
            }
        }

        for (String product : allProducts.keySet()) {
            double total = 0;
            int count = 0;

            for (Map<String, Double> ratings : userRatings.values()) {
                if (ratings.containsKey(product)) {
                    total += ratings.get(product);
                    count++;
                }
            }

            if (count > 0) {
                allProducts.put(product, total / count);
            }
        }

        System.out.println("\nRecommended Products for " + user + ":");

        userRatings.get(user).forEach((product, rating) -> 
            allProducts.remove(product)
        );

        allProducts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " (Avg Rating: " + entry.getValue() + ")")
                );
    }
}