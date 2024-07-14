package singleton;

// Class to represent the game state
class GameState {
    private int level;
    private int score;
    private String playerName;

    public GameState(int level, int score, String playerName) {
        this.level = level;
        this.score = score;
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "level=" + level +
                ", score=" + score +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}

// Singleton class to manage the game state
class GameStateManager {
    private static GameStateManager instance;
    private static final Object lock = new Object();
    private GameState gameState;

    // Private constructor to prevent instantiation
    private GameStateManager() {
        // Initialize with default game state
        this.gameState = new GameState(1, 0, "Player1");
    }

    // Public method to provide access to the instance
    public static GameStateManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new GameStateManager();
                }
            }
        }
        return instance;
    }

    // Method to get the current game state
    public GameState getGameState() {
        return gameState;
    }

    // Method to set the game state
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

// Client code to test the Singleton
public class SingletonProblem_3 {
    public static void main(String[] args) {
        GameStateManager manager1 = GameStateManager.getInstance();
        System.out.println(manager1.getGameState()); // Output: GameState{level=1, score=0, playerName='Player1'}

        // Update the game state
        manager1.getGameState().setLevel(2);
        manager1.getGameState().setScore(100);
        manager1.getGameState().setPlayerName("Player2");

        // Get the instance again and print the game state
        GameStateManager manager2 = GameStateManager.getInstance();
        System.out.println(manager2.getGameState()); // Output: GameState{level=2, score=100, playerName='Player2'}

        // Verify that both instances are the same
        System.out.println(manager1 == manager2); // Output: true (same instance)
    }
}
