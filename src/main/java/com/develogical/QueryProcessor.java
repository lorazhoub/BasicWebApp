package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
	if (query.toLowerCase().contains("potato")) {
	    return "Potatoes are the greatest food in the world";
	}
	if (query.toLowerCase().contains("name")) {
	    return "Potato";
	}
    if (query.toLowerCase().contains("the largest:")) {
        String[] half = query.split(": ");
        String[] nums = half[1].split(", ");
        int largest = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr_int = Integer.parseInt(nums[i]);
            if (curr_int > largest) {
                largest = curr_int;
            }
        }
        return Integer.toString(largest);
    }

    if (query.toLowerCase().contains("plus")) {
        String[] parts = query.split(" plus ");
        int num1 = Integer.parseInt(parts[1]);
        String[] first_part = parts[0].split(" is ");
        int num2 = Integer.parseInt(first_part[1]);
        return Integer.toString(num1 + num2);
    }
        return "";
    }
}
