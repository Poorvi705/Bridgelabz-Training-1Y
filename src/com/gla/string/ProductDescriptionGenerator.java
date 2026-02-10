package com.gla.string;
public class ProductDescriptionGenerator {

    // Replace keywords
    public static String sanitizeText(String text) {
        return text.replace("cheap", "affordable");
    }

    // Reverse product code
    public static String reverseSKU(String sku) {
        StringBuilder sb = new StringBuilder(sku);
        return sb.reverse().toString();
    }

    // Title Section
    public static void addTitle(StringBuilder sb, String title, String sku) {
        sb.append("<h1>").append(title).append("</h1>\n");
        sb.append("<p><b>SKU:</b> ").append(sku)
                .append(" | <b>Verification Code:</b> ")
                .append(reverseSKU(sku)).append("</p>\n");
    }

    // Basic Info
    public static void addBasicInfo(StringBuilder sb, String category,
                                    String brand, String model) {
        sb.append("<p><b>Category:</b> ").append(category).append("</p>\n");
        sb.append("<p><b>Brand:</b> ").append(brand).append("</p>\n");
        sb.append("<p><b>Model:</b> ").append(model).append("</p>\n");
    }

    // Specifications
    public static void addSpecifications(StringBuilder sb, String[] specs) {
        sb.append("<h2>Specifications</h2>\n<ul>\n");
        for (String spec : specs) {
            sb.append("<li>").append(spec).append("</li>\n");
        }
        sb.append("</ul>\n");
    }

    // Features
    public static void addFeatures(StringBuilder sb, String[] features) {
        sb.append("<h2>Features</h2>\n<ul>\n");
        for (String feature : features) {
            sb.append("<li>").append(sanitizeText(feature)).append("</li>\n");
        }
        sb.append("</ul>\n");
    }

    // Ratings
    public static void addRatings(StringBuilder sb, double rating, int reviews) {
        sb.append("<p><b>Customer Rating:</b> ")
                .append(rating).append("/5 (")
                .append(reviews).append(" reviews)</p>\n");
    }

    // Pricing
    public static void addPricing(StringBuilder sb,
                                  double original, double discount) {
        double finalPrice = original - discount;
        sb.append("<p><b>Original Price:</b> ₹").append(original).append("</p>\n");
        sb.append("<p><b>Discount:</b> ₹").append(discount).append("</p>\n");
        sb.append("<p><b>Final Price:</b> ₹").append(finalPrice).append("</p>\n");
    }

    // Availability
    public static void addAvailability(StringBuilder sb, String status) {
        sb.append("<p><b>Availability:</b> ").append(status).append("</p>\n");
    }

    // Promotional Banner
    public static void addPromoBanner(StringBuilder sb, String message) {
        sb.append("<div style='color:red; font-weight:bold;'>")
                .append(message).append("</div>\n");
    }

    // Reading time calculation
    public static int calculateReadingTime(String text) {
        int words = text.split("\\s+").length;
        return Math.max(1, words / 200);
    }

    // Generate Product Description
    public static void generateProduct(String title, String sku,
                                       String category, String brand, String model,
                                       String[] specs, String[] features,
                                       double rating, int reviews,
                                       double original, double discount,
                                       String availability) {

        StringBuilder sb = new StringBuilder();

        addTitle(sb, title, sku);
        addPromoBanner(sb, "🔥 Limited Time Offer!");
        addBasicInfo(sb, category, brand, model);
        addSpecifications(sb, specs);
        addFeatures(sb, features);
        addRatings(sb, rating, reviews);
        addPricing(sb, original, discount);
        addAvailability(sb, availability);

        String description = sb.toString();

        System.out.println("======================================");
        System.out.println(description);
        System.out.println("Description Length: " + description.length() + " characters");
        System.out.println("Estimated Reading Time: " +
                calculateReadingTime(description) + " minute(s)");
        System.out.println("======================================\n");
    }

    public static void main(String[] args) {

        // Product 1: Electronics - Laptop
        generateProduct(
                "UltraSpeed Laptop", "LTP12345",
                "Electronics", "TechBrand", "XPro 15",
                new String[]{
                        "Intel i7 Processor", "16GB RAM", "512GB SSD",
                        "15.6-inch Display", "Windows 11"
                },
                new String[]{
                        "Lightweight design",
                        "cheap power consumption",
                        "High performance",
                        "Long battery life"
                },
                4.5, 1200, 85000, 10000, "In Stock"
        );

        // Product 2: Clothing - Jacket
        generateProduct(
                "Winter Shield Jacket", "JCK67890",
                "Clothing", "WarmWear", "Arctic Pro",
                new String[]{
                        "Polyester Fabric", "Water Resistant",
                        "Thermal Insulation", "Windproof", "Machine Washable"
                },
                new String[]{
                        "Stylish design",
                        "cheap winter protection",
                        "Light and warm",
                        "Durable stitching"
                },
                4.2, 540, 4999, 1000, "Limited Stock"
        );

        // Product 3: Home Appliance - Coffee Maker
        generateProduct(
                "BrewMaster Coffee Maker", "CFM54321",
                "Home Appliances", "HomeTech", "BrewX",
                new String[]{
                        "600W Power", "1.5L Capacity",
                        "Auto Shut-off", "Drip Brewing", "Easy Clean"
                },
                new String[]{
                        "Fast brewing",
                        "cheap maintenance",
                        "Energy efficient",
                        "Compact design"
                },
                4.7, 890, 6999, 1500, "Out of Stock"
        );
    }
}