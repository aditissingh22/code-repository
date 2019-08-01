package com.securepay;

public class Item {
	float price;
	float shippingCost;
	int rating;

	public static void main(String[] args) {

	}

	public float getPrice() {
		int min = 1;
		int max = 20;
		price = (float) ((Math.random() * ((max - min) + 1)) + min);

		return price;
	}

	public float getShippingCost() {

		int min = 2;
		int max = 5;
		shippingCost = (float) ((Math.random() * ((max - min) + 1)) + min);
		return shippingCost;
	}

	public int getRating() {
		int min = 1;
		int max = 5;
		rating = (int) ((Math.random() * ((max - min) + 1)) + min);
		return rating;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + ", shippingCost=" + shippingCost + ", rating=" + rating + "]";
	}

}
