package com.securepay;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
 * @author Aditi Kumari 
 * This class is written to get the
 *  • Print the coordinates of the selected items. e.g. CategoryA:ItemX,CategoryB:ItemY , 
 *  • Total cost, and
 *  • Sum of ratings of all the items that were picked.
 *
 */
public class App {

	public static void main(String[] args) {

		ArrayList<ArrayList<Item>> category; // each type of category [C1, C2,....C20]
		float totalCost = 0;
		int totalRating = 0;

		// Please uncomment these two lines to see the available categories and their items
		// System.out.println("These are the available Categories and their items:");
		// getAllCategories();

		System.out.println("Printing the coordinates of the selected items...");
		System.out.println();
		for (int i = 1; i <= 20; i++) { // Iterating the loop for each Category [C1, C2,....C20]

			if (totalCost < 50) {

				category = new ArrayList<ArrayList<Item>>();

				ArrayList<Item> items = new ArrayList<>();// List of Items[Item1, Item2, ....,Item10] in each category

				for (int j = 1; j <= 10; j++) {

					Item obj = new Item(); // Object of Item class

					// Getting the random values for each attribute of Item class
					String.valueOf(obj.getPrice());
					String.valueOf(obj.getShippingCost());
					String.valueOf(obj.getRating());

					items.add(obj);
				}
				category.add(items); // Adding each Item in the Category List

				float costOfCategory = lowestCostIteminEachCategory(category).getValue();// Getting the cost of the lowest
																						// item of the currently
																						// executing Category list
				float currentTotalCost = totalCost + costOfCategory;// Getting the current total cost

				int key = lowestCostIteminEachCategory(category).getKey();// Getting the key of lowest priced Item in
																			// currently executing Category

				if (currentTotalCost < 50) {
					totalCost = currentTotalCost;
					System.out.print("Category" + i + ":Item" + key + ", ");

					int currentRating = category.get(0).get(key - 1).rating;
					totalRating = totalRating + currentRating;

				}

			}

		}

		System.out.println();
		System.out.println();
		System.out.println("Total Cost: " + totalCost);
		System.out.println();
		System.out.println("Sum of ratings of all the items that were picked: " + totalRating);

	}

	/**
	 * lowestCostIteminEachCategory
	 * 
	 * @param eachCategory
	 * @return lowest value item from each category
	 */
	static Entry<Integer, Float> lowestCostIteminEachCategory(ArrayList<ArrayList<Item>> eachCategory) {

		Map<Integer, Float> map = new LinkedHashMap<Integer, Float>();

		for (ArrayList<Item> i : eachCategory) {

			int k = 1;
			for (Item j : i) {

				map.put(k, j.price + j.shippingCost);
				k++;
			}
		}

		List<Entry<Integer, Float>> sortedData = map.entrySet() // Returns a Set view of the mappings contained in this
																// map
				.stream() // Returns a sequential Stream with this collection as its source

				.sorted(Map.Entry.comparingByValue())// Sorted according to the provided Comparator
				.collect(Collectors.toList());// returns the sorted list

		return sortedData.get(0);// getting the lowest price item(first index of the sorted list, sorted based on
									// value(cost))

	}

	/**
	 * This method is created for printing all the Items of all the Categories
	 */
	static void getAllCategories() {

		for (int i = 1; i <= 20; i++) {
			ArrayList<ArrayList<Item>> EachCategory = new ArrayList<ArrayList<Item>>();

			ArrayList<Item> items = new ArrayList<>();// Items for each category

			System.out.println("Category" + i + ":");
			for (int j = 1; j <= 10; j++) {

				Item obj = new Item();

				String.valueOf(obj.getPrice());
				String.valueOf(obj.getShippingCost());
				String.valueOf(obj.getRating());

				items.add(obj);
				System.out.println("Item" + j + ":" + obj);
			}

			System.out.println();

			EachCategory.add(items);

		}
	}
}
