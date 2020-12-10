package net.swamp.aoc2020;

import java.util.*;
import java.util.stream.Collectors;

public class Puzzle07 extends AbstractPuzzle {
	public class BagRule {
		public String colorParent;
		public HashMap<String, Integer> containedBags = new HashMap<>();

		public BagRule(String line) {
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
		public boolean equals(Object o){
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
    public List<BagRule> bagRules = Reader();


    public Puzzle07(String puzzleInput) {
        super(puzzleInput);
    }

    public List<BagRule> Reader() {
        List<String> lines = Arrays.asList(getPuzzleInput().split("\n"));
        return lines.stream()
                .map(BagRule::new)
                .collect(Collectors.toList());

    }

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    public String solvePart1() {
        List<BagRule> matchedRules = new ArrayList<>();
        findMatchingRule(bagRules, matchedRules, "shiny gold");
        return String.valueOf(matchedRules.size());
    }

    @Override
    public String solvePart2() {
        return String.valueOf(countChildrenBags(bagRules, "shiny gold"));
    }

    public void findMatchingRule(List<BagRule> totalRules, List<BagRule> matchedRules, String color) {
        totalRules.
                forEach(bagRule -> {
                    if (bagRule.containedBags.containsKey(color) && !matchedRules.contains(bagRule)) {
                        matchedRules.add(bagRule);
                        findMatchingRule(totalRules, matchedRules, bagRule.colorParent);
                    }
                });
    }

    public int countChildrenBags(List<BagRule> totalRules, String color) {
        return (totalRules.stream()
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




}