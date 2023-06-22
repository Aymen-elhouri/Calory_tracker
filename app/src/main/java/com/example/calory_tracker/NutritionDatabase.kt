class NutritionDatabase {
    companion object{
    internal val foodItems: List<FoodItem>

    init {
        foodItems = listOf(
            FoodItem("Chicken Breast", "100 grams", true, 165.0, 0.0, 31.0, 3.6),
            FoodItem("White Rice", "100 grams", true, 130.0, 28.7, 2.7, 0.3),
            FoodItem("Broccoli", "100 grams", true, 34.0, 6.6, 2.8, 0.4),
            FoodItem("Whole Wheat Bread", "100 grams", true, 247.0, 49.5, 9.9, 2.5),
            FoodItem("Salmon", "100 grams", true, 206.0, 0.0, 22.0, 13.0),
            FoodItem("Spinach", "100 grams", true, 23.0, 3.6, 2.9, 0.4),
            FoodItem("Banana", "100 grams", true, 96.0, 22.0, 1.1, 0.2),
            FoodItem("Eggs", "100 grams", true, 155.0, 1.1, 13.0, 11.0),
            FoodItem("Ground Beef (85% lean)", "100 grams", true, 213.0, 0.0, 19.0, 15.0),
            FoodItem("Oatmeal", "100 grams", true, 389.0, 66.3, 16.9, 6.9),
            FoodItem("Almonds", "100 grams", true, 579.0, 21.6, 21.2, 49.9),
            FoodItem("Sweet Potato", "100 grams", true, 86.0, 20.1, 1.6, 0.1),
            FoodItem("Greek Yogurt (non-fat)", "100 grams", true, 59.0, 3.6, 10.0, 0.4),
            FoodItem("Milk (whole)", "100 milliliters", false, 60.0, 5.2, 3.3, 3.7),
            FoodItem("Tuna (canned in water)", "100 grams", true, 99.0, 0.0, 23.0, 0.5),
            FoodItem("Brown Rice", "100 grams", true, 111.0, 23.2, 2.6, 0.9),
            FoodItem("Peanut Butter", "100 grams", true, 589.0, 20.3, 25.1, 50.0),
            FoodItem("Cottage Cheese (low-fat)", "100 grams", true, 72.0, 3.4, 12.4, 0.3),
            FoodItem("Apple", "100 grams", true, 52.0, 13.8, 0.3, 0.2),
            FoodItem("Avocado", "100 grams", true, 160.0, 8.5, 2.0, 14.7),
            FoodItem("Lentils", "100 grams", true, 116.0, 20.1, 9.0, 0.4),
            FoodItem("Turkey Breast", "100 grams", true, 135.0, 0.0, 29.0, 1.0),
            FoodItem("Quinoa", "100 grams", true, 120.0, 21.3, 4.4, 1.9),
            FoodItem("Pork Chop", "100 grams", true, 143.0, 0.0, 23.0, 5.5),
            FoodItem("Black Beans", "100 grams", true, 132.0, 22.0, 8.9, 0.5),
            FoodItem("Cheddar Cheese", "100 grams", true, 403.0, 1.3, 24.9, 33.1),
            FoodItem("Oranges", "100 grams", true, 43.0, 8.3, 0.9, 0.1),
            FoodItem("Ground Turkey (93% lean)", "100 grams", true, 176.0, 0.0, 17.0, 11.0),
            FoodItem("Tofu", "100 grams", true, 76.0, 1.9, 8.1, 4.8),
            FoodItem("Pasta (whole wheat)", "100 grams", true, 124.0, 71.2, 12.9, 1.5),
            FoodItem("Green Peas", "100 grams", true, 81.0, 14.5, 5.4, 0.4),
            FoodItem("Walnuts", "100 grams", true, 654.0, 13.7, 15.2, 65.2),
            FoodItem("Carrots", "100 grams", true, 41.0, 9.6, 0.9, 0.2),
            FoodItem("Sardines", "100 grams", true, 208.0, 0.0, 24.6, 11.5),
            FoodItem("Shrimp", "100 grams", true, 84.0, 0.0, 20.0, 1.4),
            FoodItem("Yogurt (plain)", "100 grams", true, 61.0, 4.7, 10.0, 0.4),
            FoodItem("Pineapple", "100 grams", true, 50.0, 13.1, 0.5, 0.1),
            FoodItem("Almond Butter", "100 grams", true, 614.0, 21.6, 21.6, 54.0),
            FoodItem("Zucchini", "100 grams", true, 17.0, 3.1, 1.2, 0.3),
            FoodItem("Grapes", "100 grams", true, 69.0, 18.1, 0.6, 0.2),
            FoodItem("Peanuts", "100 grams", true, 567.0, 16.1, 25.8, 49.2),
            FoodItem("Cauliflower", "100 grams", true, 25.0, 4.9, 1.9, 0.3),
            FoodItem("Green Beans", "100 grams", true, 31.0, 7.1, 1.8, 0.2),
            FoodItem("Cucumber", "100 grams", true, 16.0, 3.6, 0.7, 0.1),
            FoodItem("Blueberries", "100 grams", true, 57.0, 14.5, 0.7, 0.3),
            FoodItem("Mango", "100 grams", true, 60.0, 14.0, 0.82, 0.38),
            FoodItem("Peaches", "100 grams", true, 39.0, 9.5, 0.9, 0.3),
            FoodItem("Lettuce", "100 grams", true, 5.0, 2.2, 0.5, 0.1),
            FoodItem("Blackberries", "100 grams", true, 43.0, 9.6, 1.4, 0.4),
            FoodItem("Cantaloupe", "100 grams", true, 34.0, 8.2, 0.8, 0.2),
            FoodItem("Eggplant", "100 grams", true, 25.0, 5.7, 0.8, 0.2),
            FoodItem("Peppers (bell)", "100 grams", true, 31.0, 6.0, 1.0, 0.3),
            FoodItem("Raspberries", "100 grams", true, 53.0, 11.9, 1.2, 0.7),
            FoodItem("Strawberries", "100 grams", true, 32.0, 7.7, 0.7, 0.3),
            FoodItem("Peanut Oil", "100 grams", true, 884.0, 0.0, 0.0, 100.0),
            FoodItem("Olives", "100 grams", true, 115.0, 6.3, 0.9, 10.5),
            FoodItem("Flaxseeds", "100 grams", true, 534.0, 28.9, 18.3, 42.2),
            FoodItem("Coconut Milk", "100 milliliters", false, 230.0, 5.5, 2.3, 23.8),
            FoodItem("Corn", "100 grams", true, 86.0, 18.7, 3.4, 1.2),
            FoodItem("Honey", "100 grams", true, 304.0, 82.4, 0.3, 0.0),
            FoodItem("Tortilla Chips", "100 grams", true, 489.0, 63.5, 6.8, 30.6),
            FoodItem("Pumpkin Seeds", "100 grams", true, 559.0, 15.2, 24.5, 45.8),
            FoodItem("Cottage Cheese (full-fat)", "100 grams", true, 103.0, 2.7, 11.0, 4.3),
            FoodItem("Lamb Chops", "100 grams", true, 332.0, 0.0, 20.0, 28.0),
            FoodItem("Dates", "100 grams", true, 282.0, 75.0, 2.5, 0.4),
            FoodItem("Sesame Seeds", "100 grams", true, 573.0, 23.4, 17.7, 49.7),
            FoodItem("Mushrooms", "100 grams", true, 22.0, 3.3, 3.1, 0.3),
            FoodItem("Raisins", "100 grams", true, 299.0, 79.0, 3.1, 0.5),
            FoodItem("Butter", "100 grams", true, 717.0, 0.1, 0.9, 81.1),
            FoodItem("Ghee", "100 grams", true, 900.0, 0.0, 0.0, 100.0),
            FoodItem("Cheese (American)", "100 grams", true, 336.0, 2.4, 21.6, 27.0),
            FoodItem("Maple Syrup", "100 grams", true, 260.0, 67.0, 0.0, 0.0),
            FoodItem("Vanilla Ice Cream", "100 grams", true, 207.0, 25.0, 3.4, 11.0),
            FoodItem("Chicken Thigh", "100 grams", true, 229.0, 0.0, 20.8, 16.3),
            FoodItem("Olive Oil", "100 grams", true, 884.0, 0.0, 0.0, 100.0),
            FoodItem("Chocolate (dark)", "100 grams", true, 604.0, 45.9, 7.8, 43.1),
            FoodItem("Salted Butter", "100 grams", true, 717.0, 0.0, 0.9, 81.1),
            FoodItem("Canned Tomato Sauce", "100 grams", true, 32.0, 7.2, 1.6, 0.4),
            FoodItem("Coconut Oil", "100 grams", true, 862.0, 0.0, 0.0, 100.0),
            FoodItem("Mayonnaise", "100 grams", true, 684.0, 2.2, 0.4, 75.0),
            FoodItem("Bacon", "100 grams", true, 42.0, 0.1, 2.2, 3.3),
            FoodItem("Soy Sauce", "100 grams", true, 53.0, 10.0, 3.0, 0.0),
            FoodItem("Barbecue Sauce", "100 grams", true, 153.0, 34.0, 0.9, 0.5),
            FoodItem("Ketchup", "100 grams", true, 97.0, 25.0, 1.8, 0.5),
            FoodItem("Hummus", "100 grams", true, 166.0, 8.5, 8.3, 8.6),
            FoodItem("Pesto Sauce", "100 grams", true, 303.0, 3.2, 3.8, 29.0),
            FoodItem("Ranch Dressing", "100 grams", true, 460.0, 5.0, 1.0, 48.0),
            FoodItem("Peanut Sauce", "100 grams", true, 298.0, 13.0, 5.7, 23.0),
            FoodItem("Tahini", "100 grams", true, 595.0, 9.6, 17.0, 53.0),
            FoodItem("Soy Milk", "100 milliliters", false, 45.0, 1.7, 3.0, 2.2),
            FoodItem("Almond Milk", "100 milliliters", false, 17.0, 0.4, 0.6, 1.4),
            FoodItem("Cashew Milk", "100 milliliters", false, 27.0, 3.6, 0.9, 1.4),
            FoodItem("Rice Milk", "100 milliliters", false, 47.0, 9.7, 0.3, 0.2),
            FoodItem("Oat Milk", "100 milliliters", false, 43.0, 6.7, 1.0, 1.4),
            FoodItem("Coconut Water", "100 milliliters", false, 19.0, 3.7, 0.2, 0.4)
        )
    }

        fun searchFoodItemByName(name: String): FoodItem? {
            return foodItems.find { it.name.equals(name, ignoreCase = true) }
        }
    }
}

data class FoodItem(
    val name: String,
    val servingSize: String,
    val isSolid: Boolean,
    val calories: Double,
    val carbohydrates: Double,
    val protein: Double,
    val fat: Double
)





