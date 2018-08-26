package com.cultivation.javaBasicExtended.posMachine;

import com.cultivation.javaBasic.util.EscapedChars;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused", "RedundantThrows"})
public class PosMachine {

    private Map<String, Product> products = new HashMap<>(16);

    public void readDataSource(Reader reader) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        List<String> productStrings = getProductsFromReader(reader);

        createProducts(productStrings);
        // --end-->
    }

    private void createProducts(List<String> productStrings) {
        productStrings.forEach(var -> {
            String[] productFields = var.substring(1, var.length() - 2).split(",");
            String id = productFields[0].split(":")[1].trim();
            String name = productFields[1].split(":")[1].trim();
            name = name.substring(1, name.length() - 1);
            Integer price = Integer.valueOf(productFields[2].split(":")[1].trim());
            products.put(id, new Product(id, name, price));
        });
    }

    private List<String> getProductsFromReader(Reader reader) throws IOException {
        List<String> productStrings = new ArrayList<>();
        StringBuilder signalLine = new StringBuilder();

        int next;
        while ((next = reader.read()) != -1) {
            char ch = (char) next;
            if (EscapedChars.LINE_FEED.getValue() == ch) {
                productStrings.add(signalLine.toString());
                signalLine.delete(0, signalLine.length());
            } else {
                signalLine.append(ch);
            }
        }
        productStrings.add(signalLine.toString());

        productStrings.remove(0);
        productStrings.remove(productStrings.size() - 1);
        return productStrings;
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        final String line = System.lineSeparator();
        final String header =  "Receipts" + line +
                               "------------------------------------------------------------" + line;
        final String cutLine = "------------------------------------------------------------" + line;
        final String defaultTail = "Price: 0" + line;
        if (barcodeContent == null) {
            return header + cutLine + defaultTail;
        }

        barcodeContent = barcodeContent.substring(1, barcodeContent.length() - 1);
        if (barcodeContent.trim().equals("")) {
            return header + cutLine + defaultTail;
        }
        String[] ids = barcodeContent.split(",");

        checkAllBarcodeIsLegal(ids);

        StringBuilder receipt = new StringBuilder(128).append(header);
        int totalPrice = getTotalPrice(ids, receipt);

        receipt.append(cutLine).append("Price: ").append(totalPrice).append(line);
        return receipt.toString();

        // --end-->
    }

    private int getTotalPrice(String[] ids, StringBuilder receipt) {
        Map<String, Integer> productCount = countProducts(ids);

        return calcPrice(receipt, productCount);
    }

    private Map<String, Integer> countProducts(String[] ids) {
        Map<String, Integer> productCount = new HashMap<>();

        for (String id : ids) {
            if (productCount.containsKey(id)) {
                productCount.put(id, productCount.get(id) + 1);
            }else {
                productCount.put(id, 1);
            }
        }
        return productCount;
    }

    private int calcPrice(StringBuilder receipt, Map<String, Integer> productCount) {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            String id = entry.getKey();
            Integer count = entry.getValue();
            receipt.append(String.format("%-30s  %-10d %d", products.get(id).getName(), products.get(id).getPrice(), count))
                   .append(System.lineSeparator());

            totalPrice += count * products.get(id).getPrice();
        }
        return totalPrice;
    }

    private void checkAllBarcodeIsLegal(String[] ids) {
        for (String id : ids) {
            if (!products.containsKey(id)) {
                throw new IllegalStateException();
            }
        }
    }
}

@SuppressWarnings("unused")
class Product {
    private String id;
    private String name;
    private Integer price;

    Product(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Product other = (Product) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}