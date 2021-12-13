//Hassow's project
//EB3/37705/18
//Package name
package GuessGame;

/*
* Program to demonstrate a GUI guessing game using javafx
 */

 /*
* Import the required classes/packages
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

//Main class extending application class and implementing ValuesC
public class GuessGame extends Application implements ValuesC {//Start of Main class

    //Class properties/data fields
    private int random;
    private int count = 0;
    public boolean playAgain = false;

    //Override the start method defined in Application class
    @Override
    public void start(Stage primaryStage) {

        //Create a BorderPane
        BorderPane pane = new BorderPane();
        //Set pane style using javafx css
        pane.setStyle("-fx-border: 1px solid red");
        pane.setStyle("-fx-background-color: white");

        //Create a VBox with spacing of 10
        VBox vBox = new VBox(10);

        //Create a TextArea and add text IMP from ValuesC interface
        TextArea textArea = new TextArea(IMP);

        //Set the TextArea properties
        textArea.setPrefColumnCount(8);
        textArea.setMinHeight(HEIGHT);
        textArea.setWrapText(true);
        textArea.setEditable(false);

        //Add textArea to vBox
        vBox.getChildren().add(textArea);

        //Create a GridPane
        GridPane gridPane = new GridPane();

        //Set GridPane properties
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Create a Label
        Label label = new Label("Enter your guess");

        //Add label to the gridPane
        gridPane.add(label, 0, 0);

        //Create a TextField
        TextField textField = new TextField();

        //Set textField properties
        textArea.setPrefColumnCount(5);

        //Add textField to the gridPane
        gridPane.add(textField, 1, 0);

        //Create a Label (label1)
        Label label1 = new Label("Press to guess");

        //Add label to the gridPane
        gridPane.add(label1, 0, 1);

        //Create a button
        Button button = new Button("Guess");

        //Add button to the gridPane
        gridPane.add(button, 1, 1);

        //Create a Label (label2)
        Label label2 = new Label("Outcome ");

        //Add label2 to the gridPane
        gridPane.add(label2, 0, 2);

        //Create a TextFiled (textField1)
        TextField textField1 = new TextField();

        //Set textField properties
        textField1.setPrefColumnCount(5);

        //Add textField to the gridPane
        gridPane.add(textField1, 1, 2);

        //Create a Label
        Label label3 = new Label("Guess count");

        //Add label to the gridPane
        gridPane.add(label3, 0, 3);

        //Create a TextField (textField2)
        TextField textField2 = new TextField();

        //Set textField properties
        textField2.setPrefColumnCount(5);

        //Add textField2 to the gridPane
        gridPane.add(textField2, 1, 3);

        //Create a Label (label4)
        Label label4 = new Label("Play again?");

        //Add label4 to the gridPane
        gridPane.add(label4, 0, 4);

        //Create a Button (button1)
        Button button1 = new Button("Play Again");

        //Add button1 to the gridPane
        gridPane.add(button1, 1, 4);

        //Set the vBox at the left of BorderPane (pane)
        pane.setLeft(vBox);

        //Set GridPane (gridPane) at the center of the BorderPane (pane)
        pane.setCenter(gridPane);

        //Generate a random number after launching the application
        random = genRandom(9, 1);

        //Tell the program what to do when button is pressed
        button.setOnAction(e -> {//Start of button action

            //Set playAgain to false
            playAgain = false;

            //Increment count by 1 after each button press
            count += 1;

            //Check if count is greater than 3 and if playAgain is false
            if (count > 2&& playAgain != true) {

                //Change text color using javafx-css
                textField.setStyle("-fx-text-fill: blue");
                textField1.setStyle("-fx-text-fill: red");
                textField2.setStyle("-fx-text-fill: red");
                textArea.setStyle("-fx-text-fill: green");

                //Output some text to indicate that the game is over
                textField2.setText("Game Over");
                textField.setText("The Guess is " + random);
                textField1.setText("You lost!");
                textField.setEditable(false);
                textField1.setEditable(false);
                textField2.setEditable(false);
            } //If the count is less than three and playAgain is still false continue to play
            else {

                //Set textFiled2 to indicate the current count
                textField2.setText("Attempts:" + count);

                //Check if the number submitted is an integer and is is one digit
                if (!textField.getText().matches("\\d{1}")) {

                    //Output error message
                    textField1.setText("The guess is out of range (1-4");

                } //If the number submitted is an integer and is one digit continue to play
                else if (textField.getText().matches("\\d{1}")) {

                    //Clear the textFiled1
                    textField1.clear();

                    //Check if the number submitted is not equal to the random number
                    if (Integer.parseInt(textField.getText()) != random) {

                        //If less than random output a less than sign
                        if (Integer.parseInt(textField.getText()) < random) {
                            textField1.setText("Wrong guess ");
                        } //If greater than random output a greater than sign
                        else if (Integer.parseInt(textField.getText()) > random) {
                            textField1.setText("Wrong guess");
                        }
                    } //If guess is correct indicate that is corret
                    else {
                        textField1.setText("CONGRATULATION\n Correct guess" + random);
                        textField.setText("Press Play Again");
                    }
                }
            }
        });//End of button one action

        //Tell the program what to do when button1 is pressed
        button1.setOnAction((ActionEvent e) -> {//Start of button1 action

            //Set playAgain to true
            playAgain = true;

            //Set count to 0
            count = 0;

            //Clear each textFiled
            textField.clear();
            textField1.clear();
            textField2.clear();
            textField.setEditable(true);

            //Generate a new random number to guess
            random = genRandom(9, 1);

            //Set text color back to normal
            textField.setStyle("-fx-text-fill: green");
            textField1.setStyle("-fx-text-fill: black");
            textField2.setStyle("-fx-text-fill: black");
            textArea.setStyle("-fx-text-fill: black");
        });//End of button action

        //Create a Scene (scene) and place it in the Stage (stage)
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        //Set the stage title
        primaryStage.setTitle("GUESS GAME");

        //Set the scene on the stage
        primaryStage.setScene(scene);

        //Display the scene
        primaryStage.show();

        //Set the primaryStage not to be resizable
        primaryStage.setResizable(false);
    }

    //Main method
    public static void main(String[] args) {//Start of main method

        //Launch the application
        Application.launch(args);
    }//End of main method

    /*
    * Method to generate random number
    * s is the upper limit
    * l is the lower limit
     */
    public int genRandom(int s, int l) {//Start of genRandom method

        //Return a random number
        return l + (int) (Math.random() * s);

    }//End of genRandom
}//End of Main Class

/*
* Interface ValueC
 */
interface ValuesC {//Start of interface

    //Width and Height of the stage
    int WIDTH = 450;
    int HEIGHT = 350;

    //String
    String IMP = " GUESS A NUMBER BETWEEN \n0 to 9";
}//End of interface
