public class Test {

    public static void main(String[] args) {
        LinkedBag bag = new LinkedBag();
        System.out.println("Current Size: " + bag.getCurrentSize());
        bag.add(1);
        bag.add(1);
        bag.add(1);
        bag.add(13);
        bag.add(99);
        System.out.println("Added: 1 1 1 13 99");
        if (!bag.isEmpty()) {
            System.out.println("Not Empty.");
        }
        bag.remove();
        System.out.println("Removed randomly.");
        bag.remove(1);
        System.out.println("Removed one 1.");
        System.out.print("In the bag: ");
        for (int i = 0; i < bag.toArray().length; i++) {
            System.out.print(bag.toArray()[i] + " ");
        }
        System.out.println("\nFrequency of 1: " + bag.getFrequencyOf(1));
        System.out.println("Contain 5: " + bag.contains(5));
        bag.clear();
        System.out.println("Nullified.");
        System.out.println("Current Size: " + bag.getCurrentSize());
    }
}