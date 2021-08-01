package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.dataTypes.TypeFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

/**
 * Main entry point for the application.
 * <p>
 * This class runs the application, creating the window for it
 * and runs the main logic
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Videla Donoso.
 */
public class Scrabble extends Application {
  private static final TextField result = new TextField("0");
  private static final Group root = new Group();
  private static final int width = 900;
  private static final int height = 600;
  private static final int xPos = 10;
  private static final Scene scene = new Scene(root, width, height);
  private static final String[] operatorNames = {"Add", "Subtraction", "Multiplication", "Division", "Negation", "Conjunction", "Disjunction"};
  private static final String[] valueNames = {"String", "Boolean", "Float", "Int", "Binary"};

  private static final Text inputText = new Text("Input: ");
  private static final Text signText = new Text("Positive");
  private static final TextField input = new TextField("");
  private static final Button C = new Button("C");
  private static final Button submitButton = new Button("Submit");
  private static final Button cancelButton = new Button("Cancel");
  private static final Button trueBoolean = new Button("True");
  private static final Button falseBoolean = new Button("False");
  private static final Button negativeButton = new Button("Make negative");
  private static boolean negativeNumber = false;

  private static int count = 0;

  /**
   * The function for running the application
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Where the main logic of the app occurs
   */
  @Override
  public void start(@NotNull Stage primaryStage) {
    primaryStage.setTitle("Scrabble");
    reStart();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * To call everything that needs to be created whenever the calculator starts.
   * This is also called when calculator is reset
   */
  private static void reStart(){
    int yPos = 10;

    for (int i=0; i< operatorNames.length; i++){
      root.getChildren().add(setupButton(xPos, yPos + 31*i, operatorNames[i], 24, 0, i));
    }

    for (int i=0; i< valueNames.length; i++){
      root.getChildren().add(setupButton(2*xPos + 100, yPos + 45*i, valueNames[i], 32, 1, i));
    }

    var resultText = new Text("Result: ");
    resultText.setLayoutX(40);
    resultText.setLayoutY(height - 10);
    resultText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    root.getChildren().add(resultText);

    C.setLayoutX(xPos);
    C.setLayoutY(height - 150);
    C.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
    C.setOnAction(Scrabble::Reset);
    root.getChildren().add(C);

    result.setLayoutX(240);
    result.setLayoutY(height - 50);
    result.setPrefWidth(width - 260);
    result.setDisable(true);
    result.setStyle("-fx-opacity: 1;");
    result.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
    result.setAlignment(Pos.BASELINE_RIGHT);
    root.getChildren().add(result);

    createSubmitThings();
  }


  /**
   * Called for the "C" button to delete everything and restart
   */
  private static void Reset(ActionEvent actionEvent) {
    root.getChildren().clear();
    reStart();
    count = 0;
  }

  /**
   * Function for creating a button
   * @param x the horizontal position of the button
   * @param y the vertical position of the button
   * @param string the string that will be displayed on the button
   * @param height the height of the button
   * @param type whether it's an operation or a value
   * @param subtype what type of operation or value it is
   * @return the button
   */
  private @NotNull static Button setupButton(int x, int y, String string, int height, int type, int subtype) {
    VBox vBox = new VBox();
    vBox.setPrefWidth(100);
    vBox.setPrefHeight(height);

    var button = new Button(string);
    button.setLayoutX(x);
    button.setLayoutY(y);
    button.setMinWidth(vBox.getPrefWidth());
    button.setMinHeight(vBox.getPrefHeight());
    button.setFocusTraversable(false);
    if (type == 0) {
      button.setOnAction(Scrabble::AddSumNode);
    }
    else {
      switch (subtype) {
        default:
          break;
        case 0: {
          button.setOnAction(Scrabble::AddStringNode);
        } break;
        case 1: {
          button.setOnAction(Scrabble::AddBooleanNode);
        } break;
        case 2: {
          button.setOnAction(Scrabble::AddFloatNode);
        } break;
        case 3: {
          button.setOnAction(Scrabble::AddIntNode);
        } break;
        case 4: {
          button.setOnAction(Scrabble::AddBinaryNode);
        } break;
      }
    }
    return button;
  }

  /**
   * Function for creating everything necessary for submitting a value
   */
  private static void createSubmitThings(){

    inputText.setLayoutX(xPos);
    inputText.setLayoutY(275);
    inputText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

    signText.setLayoutX(xPos);
    signText.setLayoutY(290);
    signText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

    input.setLayoutX(xPos);
    input.setLayoutY(300);
    input.setPrefWidth(220);
    input.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

    submitButton.setLayoutX(120);
    submitButton.setLayoutY(350);
    submitButton.setFocusTraversable(false);

    cancelButton.setLayoutX(180);
    cancelButton.setLayoutY(350);
    cancelButton.setFocusTraversable(false);
    cancelButton.setOnAction(Scrabble::cancelInput);

    negativeButton.setLayoutX(xPos);
    negativeButton.setLayoutY(350);
    negativeButton.setFocusTraversable(false);
    negativeButton.setOnAction(Scrabble::negativeInput);

    trueBoolean.setLayoutX(xPos);
    trueBoolean.setLayoutY(300);
    trueBoolean.setPrefWidth(100);
    trueBoolean.setPrefHeight(25);
    trueBoolean.setFocusTraversable(false);
    trueBoolean.setOnAction(Scrabble::trueBooleanInput);

    falseBoolean.setLayoutX(xPos + 110);
    falseBoolean.setLayoutY(300);
    falseBoolean.setPrefWidth(100);
    falseBoolean.setPrefHeight(25);
    falseBoolean.setFocusTraversable(false);
    falseBoolean.setOnAction(Scrabble::falseBooleanInput);
  }

  /**
   * After the value is submitted, this is called to remove
   * everything no longer needed
   */
  private static void removeSubmitThings(){
    input.setText("");
    root.getChildren().remove(input);
    root.getChildren().remove(submitButton);
    root.getChildren().remove(cancelButton);
    negativeButton.setText("Make negative");
    signText.setText("Positive");
    negativeNumber = false;
    root.getChildren().remove(negativeButton);
    root.getChildren().remove(trueBoolean);
    root.getChildren().remove(falseBoolean);
    root.getChildren().remove(inputText);
    root.getChildren().remove(signText);
  }


  /**
   * A button that calls this for changing the sign of
   * the number being inputted
   */
  private static void negativeInput(ActionEvent actionEvent) {
    negativeNumber = !negativeNumber;
    if (negativeNumber) {
      negativeButton.setText("Make positive");
      signText.setText("Negative");
    }
    else {
      negativeButton.setText("Make negative");
      signText.setText("Positive");
    }
  }

  /**
   * A button calls this for canceling any input that
   * was being inputted
   */
  private static void cancelInput(ActionEvent event) {
    removeSubmitThings();
  }

  /**
   * Function for changing the input text format depending on
   * the type of the value that was selected
   * @param textField the textfield that will be affected
   * @param formatString the text format
   */
  public static void makeTextFormat(@NotNull TextField textField, String formatString) {
    StringConverter<Integer> stringConverter = new StringConverter<>() {

      @Override
      public String toString(Integer object) {
        if (object == null || object == 0) {
          return "";
        }
        return object.toString();
      }

      @Override
      public Integer fromString(String string) {
        if (string == null || string.isEmpty()) {
          return 0;
        }
        return Integer.parseInt(string);
      }

    };
    UnaryOperator<TextFormatter.Change> textFilter = c -> {

      if (c.getText().matches(formatString)) {
        return c;
      } else
        // if not adding any text (delete or selection change), accept as is
        if (c.getText().isEmpty()) {
          return c ;
        }
      // otherwise veto change
      return null ;
    };

    TextFormatter<Integer> formatter = new TextFormatter<>(stringConverter, 0, textFilter);

    textField.setTextFormatter(formatter);
  }


  /**
   * Function called to create the input window where
   * the value that the created string will have.
   * It also adds the buttons to confirm or cancel
   * the creation of the string node.
   */
  private static void AddStringNode(ActionEvent event) {
    submitButton.setOnAction(Scrabble::CreateString);
    root.getChildren().add(inputText);
    root.getChildren().add(input);
    root.getChildren().add(submitButton);
    root.getChildren().add(cancelButton);
    makeTextFormat(input, ".");
  }

  /**
   * Called by the submit button for creating a string
   * with the input value
   */
  private static void CreateString(ActionEvent event) {
    var inputValue = input.getText();
    var value = TypeFactory.createSString(inputValue);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Function called to create the buttons to decide
   * the value that the created boolean will have.
   * It also adds the buttons to confirm or cancel
   * the creation of the boolean node.
   */
  private static void AddBooleanNode(ActionEvent event) {
    submitButton.setOnAction(Scrabble::CreateString);
    root.getChildren().add(inputText);
    root.getChildren().add(cancelButton);
    root.getChildren().add(trueBoolean);
    root.getChildren().add(falseBoolean);
  }

  /**
   * Called by the submit button for creating a boolean
   * with the "true" value
   */
  private static void trueBooleanInput(ActionEvent actionEvent) {
    var value = TypeFactory.createSBool(true);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Called by the submit button for creating a boolean
   * with the "false" value
   */
  private static void falseBooleanInput(ActionEvent actionEvent) {
    var value = TypeFactory.createSBool(false);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Function called to create the input window where
   * the value that the created float will have.
   * It also adds the buttons to confirm or cancel
   * the creation of the float node.
   */
  private static void AddFloatNode(ActionEvent event) {
    submitButton.setOnAction(Scrabble::CreateFloat);
    root.getChildren().add(inputText);
    root.getChildren().add(input);
    root.getChildren().add(signText);
    root.getChildren().add(submitButton);
    root.getChildren().add(cancelButton);
    root.getChildren().add(negativeButton);
    makeTextFormat(input, "[\\p{Digit}\\.]");
  }

  /**
   * Called by the submit button for creating a float
   * with the input value
   */
  private static void CreateFloat(ActionEvent actionEvent) {
    var inputValue = input.getText();
    var doubleValue = Double.parseDouble(inputValue);
    if (negativeNumber) {
      doubleValue = -Double.parseDouble(inputValue);
    }
    var value = TypeFactory.createSFloat(doubleValue);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Function called to create the input window where
   * the value that the created integer will have.
   * It also adds the buttons to confirm or cancel
   * the creation of the integer node.
   */
  private static void AddIntNode(ActionEvent event) {
    submitButton.setOnAction(Scrabble::CreateInt);
    root.getChildren().add(inputText);
    root.getChildren().add(input);
    root.getChildren().add(signText);
    root.getChildren().add(submitButton);
    root.getChildren().add(cancelButton);
    root.getChildren().add(negativeButton);
    makeTextFormat(input, "[0-9]");
  }

  /**
   * Called by the submit button for creating an integer
   * with the input value
   */
  private static void CreateInt(ActionEvent actionEvent) {
    var inputValue = input.getText();
    var intValue = Integer.parseInt(inputValue);
    if (negativeNumber) {
      intValue = -Integer.parseInt(inputValue);
    }
    var value = TypeFactory.createSInt(intValue);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Function called to create the input window where
   * the value that the created binary will have.
   * It also adds the buttons to confirm or cancel
   * the creation of the binary node.
   */
  private static void AddBinaryNode(ActionEvent event) {
    submitButton.setOnAction(Scrabble::CreateBinary);
    root.getChildren().add(inputText);
    root.getChildren().add(input);
    root.getChildren().add(submitButton);
    root.getChildren().add(cancelButton);
    makeTextFormat(input, "[0|1]");
  }

  /**
   * Called by the submit button for creating a binary
   * with the input value
   */
  private static void CreateBinary(ActionEvent actionEvent) {
    var inputValue = input.getText();
    var value = TypeFactory.createSBinary(inputValue);
    var node = new ValueNodeBuilder().setPosition(400,count*30 + 30).setValue(value).build();
    root.getChildren().add(node.getNode());
    count++;
    removeSubmitThings();
  }

  /**
   * Function that would have been called to create
   * a Sum node.
   */
  private static void AddSumNode(ActionEvent event) {

  }

}