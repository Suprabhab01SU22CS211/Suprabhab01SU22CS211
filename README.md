import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {

    private static Map<String, Integer> candidates = new HashMap<>();
    private static Map<String, Boolean> voterStatus = new HashMap<>();

    public static void main(String[] args) {
        initializeCandidates();
        initializeVoters();

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayCandidates();
                    break;
                case 2:
                    vote();
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    System.out.println("Exiting the voting system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void initializeCandidates() {
        candidates.put("Candidate A", 0);
        candidates.put("Candidate B", 0);
        candidates.put("Candidate C", 0);
    }

    private static void initializeVoters() {
        // Assuming three voters for simplicity
        voterStatus.put("Voter1", false);
        voterStatus.put("Voter2", false);
        voterStatus.put("Voter3", false);
    }

    private static void displayMenu() {
        System.out.println("\n===== Online Voting System =====");
        System.out.println("1. Display Candidates");
        System.out.println("2. Vote");
        System.out.println("3. Display Results");
        System.out.println("4. Exit");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void displayCandidates() {
        System.out.println("\n===== Candidates =====");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    private static void vote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to vote: ");
        String voterName = scanner.nextLine();

        if (voterStatus.containsKey(voterName) && !voterStatus.get(voterName)) {
            displayCandidates();
            System.out.print("Enter the name of the candidate you want to vote for: ");
            String candidateName = scanner.nextLine();

            if (candidates.containsKey(candidateName)) {
                candidates.put(candidateName, candidates.get(candidateName) + 1);
                voterStatus.put(voterName, true);
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("Invalid candidate name.");
            }
        } else {
            System.out.println("You have already voted or your name is not in the voter list.");
        }
    }

    private static void displayResults() {
        System.out.println("\n===== Voting Results =====");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
