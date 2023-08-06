package control;
import java.net.URL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainScreenController implements Initializable {
    @FXML
    private Label labelVisor;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn0;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnMult;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnEqual;
    @FXML
    private Button btnGoBack;

    private int valueA = 0;
    private int valueB = 0;
    private String valueAString = "";
    private String valueBString = "";
    private char operation = 'n';
    private String visorValue = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelVisor.setText(" ");
    }

    private void assignValues(String value){
        if(operation == 'n'){
            valueAString += value;
            valueA = Integer.parseInt(valueAString);
            visorValue += value;
        }else{
            valueBString += value;
            valueB = Integer.parseInt(valueBString);
            visorValue += value;
        }
    }

    public void pressButton(ActionEvent event){
        if(event.getSource().equals(btn1)){
            assignValues("1");
        }
        if(event.getSource().equals(btn2)){
            assignValues("2");
        }
        if(event.getSource().equals(btn3)){
            assignValues("3");
        }
        if(event.getSource().equals(btn4)){
            assignValues("4");
        }
        if(event.getSource().equals(btn5)){
            assignValues("5");
        }
        if(event.getSource().equals(btn6)){
            assignValues("6");
        }
        if(event.getSource().equals(btn7)){
            assignValues("7");
        }
        if(event.getSource().equals(btn8)){
            assignValues("8");
        }
        if(event.getSource().equals(btn9)){
            assignValues("9");
        }
        if(event.getSource().equals(btn0)){
            assignValues("0");
        }
        if(event.getSource().equals(btnPlus)){
            operation = '+';
            visorValue += " " + operation + " ";
        }
        if(event.getSource().equals(btnSub)){
            operation = '-';
            visorValue += " " + operation + " ";
        }
        if(event.getSource().equals(btnMult)){
            operation = 'x';
            visorValue+= " " + operation + " ";
        }
        if(event.getSource().equals(btnDiv)){
            operation = '/';
            visorValue +=" " + operation + " ";
        }

        if(event.getSource().equals(btnGoBack)){
            visorValue = "";
        }

        if(event.getSource().equals(btnEqual)){
            double result;
            switch (operation){
                case '+':
                    result = (double) valueA + valueB;
                    break;
                case '-':
                    result = (double) valueA - valueB;
                    break;
                case 'x':
                    result = (double) valueA * valueB;
                    break;
                case '/':
                    result = (double) valueA / valueB;
                    break;
                default:
                result = 0;
            }
            Platform.runLater(() -> {
                labelVisor.setText(result+"");
            });
            
            operation = 'n';
            valueA = 0;
            valueB = 0;
            valueAString = "";
            valueBString = "";
            visorValue = "";
            return;
        }
    
        Platform.runLater(() -> {
            labelVisor.setText(visorValue);
        });
    }
}

