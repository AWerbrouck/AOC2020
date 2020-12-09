package AoC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bags {
	
	
	public static void findMatchingRule(List<BagRule> totalRules, List<BagRule> matchedRules, String color) {
		totalRules.
				          forEach(bagRule -> {
					          if (bagRule.containedBags.containsKey(color) && !matchedRules.contains(bagRule)) {
						          matchedRules.add(bagRule);
						          findMatchingRule(totalRules, matchedRules, bagRule.colorParent);
					          }
				          });
	}
	
	public static int part1(List<BagRule> bagRules) {
		List<BagRule> matchedRules = new ArrayList<>();
		findMatchingRule(bagRules, matchedRules, "shiny gold");
		return matchedRules.size();
	}
	
	
	public static int countChildrenBags(List<BagRule> totalRules, String color) {
		return Objects.requireNonNull(totalRules.stream()
		                                        .filter(r -> r
				                                        .colorParent.equals(color))
		                                        .findFirst()
		                                        .orElse(null))
				.containedBags.entrySet()
				              .stream()
				              .map(e -> e
						              .getValue() + (e.getValue() * countChildrenBags(totalRules, e.getKey())))
				              .reduce(Integer::sum)
				              .orElse(0);
	}
	
	public static int part2(List<BagRule> bagRules) {
		return countChildrenBags(bagRules, "shiny gold");
	}
	
	public static void day7() throws IOException {
		List<String> lines = ReadPuzzle.readStringsBySeparator("d7.txt", "\n");
		List<BagRule> bagRules = lines.stream()
		                              .map(BagRule::new)
		                              .collect(Collectors.toList());
		
		System.out.println("dag 7 deel1: " +part1(bagRules));
		System.out.println("dag 7 deel2: " +part2(bagRules));
	}
	
	public static void main(String[] args) throws IOException {
	}
}