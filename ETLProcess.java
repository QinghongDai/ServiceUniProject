import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ETLProcess {

    public static void main(String[] args) {
        // Step 1: Read sales data from CSV
        Map<String, Double> productRevenueMap = readSalesData("sales_data.csv");

        // Step 2: Read customer data from JSON
        Map<String, String> customerIdNameMap = readCustomerData("customer_data.json");

        // Step 3: Join sales data with customer data based on a common field (Product in this case)
        Map<String, Double> productRevenueWithCustomerMap = joinData(productRevenueMap, customerIdNameMap);

        // Step 4: Summarize total revenue by region
        Map<String, Double> regionRevenueMap = summarizeRevenueByRegion(productRevenueWithCustomerMap);

        // Step 5: Display results
        displayResults(productRevenueWithCustomerMap, regionRevenueMap);
    }

    private static Map<String, Double> readSalesData(String csvFilePath) {
        Map<String, Double> productRevenueMap = new HashMap<>();

        try (CSVParser parser = CSVParser.parse(new FileReader(csvFilePath), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : parser) {
                String product = record.get("Product");
                double revenue = Double.parseDouble(record.get("Revenue"));

                productRevenueMap.put(product, productRevenueMap.getOrDefault(product, 0.0) + revenue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productRevenueMap;
    }

    private static Map<String, String> readCustomerData(String jsonFilePath) {
        Map<String, String> customerIdNameMap = new HashMap<>();

        try {
            JSONObject jsonObject = new JSONObject(new FileReader(jsonFilePath));
            JSONArray customers = jsonObject.getJSONArray("Customers");

            for (int i = 0; i < customers.length(); i++) {
                JSONObject customer = customers.getJSONObject(i);
                String customerId = customer.getString("CustomerId");
                String customerName = customer.getString("Name");

                customerIdNameMap.put(customerId, customerName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerIdNameMap;
    }

    private static Map<String, Double> joinData(Map<String, Double> productRevenueMap, Map<String, String> customerIdNameMap) {
        Map<String, Double> productRevenueWithCustomerMap = new HashMap<>();

        for (Map.Entry<String, Double> entry : productRevenueMap.entrySet()) {
            String product = entry.getKey();
            double revenue = entry.getValue();
            String customerId = ""; // You need to determine the common field for joining

            if (customerIdNameMap.containsKey(customerId)) {
                String customerName = customerIdNameMap.get(customerId);
                String keyWithCustomer = product + " - " + customerName;
                productRevenueWithCustomerMap.put(keyWithCustomer, revenue);
            }
        }

        return productRevenueWithCustomerMap;
    }

    private static Map<String, Double> summarizeRevenueByRegion(Map<String, Double> productRevenueWithCustomerMap) {
        // This is a placeholder method, as region information is not provided in the given data
        // You should modify this method based on the actual structure of your data

        Map<String, Double> regionRevenueMap = new HashMap<>();

        for (Map.Entry<String, Double> entry : productRevenueWithCustomerMap.entrySet()) {
            String keyWithCustomer = entry.getKey();
            double revenue = entry.getValue();
            String region = ""; // You need to determine how to extract region information

            regionRevenueMap.put(region, regionRevenueMap.getOrDefault(region, 0.0) + revenue);
        }

        return regionRevenueMap;
    }

    private static void displayResults(Map<String, Double> productRevenueWithCustomerMap, Map<String, Double> regionRevenueMap) {
        System.out.println("Total Revenue for Each Product:");
        for (Map.Entry<String, Double> entry : productRevenueWithCustomerMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nTotal Revenue by Region:");
        for (Map.Entry<String, Double> entry : regionRevenueMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}