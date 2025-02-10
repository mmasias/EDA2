package src.casosDeUso.enumSet.ejemplo001;

import java.util.EnumSet;

public class EnumSetExample {
    public static void main(String[] args) {
        
        EnumSet<ProductFeature> features = EnumSet.of(ProductFeature.ECO_FRIENDLY, ProductFeature.LOCAL);

        features.add(ProductFeature.LIMITED_EDITION);

        if (features.contains(ProductFeature.PREMIUM)) {
            System.out.println("The product is premium.");
        } else {
            System.out.println("The product is not premium.");
        }

        features.addAll(EnumSet.of(ProductFeature.HANDMADE, ProductFeature.PREMIUM));

        features.remove(ProductFeature.LOCAL);

        System.out.println("Product features: " + features);
    }
}
