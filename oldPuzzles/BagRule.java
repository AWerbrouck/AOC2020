package AoC;

import java.util.HashMap;
import java.util.Objects;

public class BagRule extends Bags {
	String colorParent;
	HashMap<String, Integer> containedBags = new HashMap<>();
	
	BagRule(String line) {
		String readableLine = line
				.replace(" bags contain ", ":")
				.replace("bags, ", "")
				.replace("bag, ", "")
				.replace(" bags.", "")
				.replace("bag.", "");
		String[] split = readableLine.split(":"); // output color contains colours
		colorParent = split[0];
		String allColorsChild = split[1].strip();
		if (allColorsChild.contains("no other")) { // if the parent bag has no child bags
			return;
		}
		String[] colorChild = allColorsChild.split(" ");
		for (int i = 0; i < colorChild.length; i += 3) {
			int amount = Integer.parseInt(colorChild[i]);
			String color = colorChild[i + 1] + " " + colorChild[i + 2]; // i = amount i+1 = type of color eg bright i+2 = color itself eg blue
			containedBags.put(color, amount);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BagRule)) return false;
		BagRule bagRule = (BagRule) o;
		return Objects.equals(colorParent, bagRule.colorParent);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(colorParent);
	}
}