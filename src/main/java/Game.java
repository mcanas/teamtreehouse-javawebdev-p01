import java.io.IOException;

public class Game {

    public static void main(String[] args) throws IOException {
        Prompter prompter = new Prompter();
        prompter.startNewGame();
        prompter.play();
    }
}
