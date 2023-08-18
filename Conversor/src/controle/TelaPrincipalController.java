package controle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private TextField campoValor;
    @FXML
    private Label labelResultado;
    @FXML
    private Label labelAviso;
    @FXML
    private ChoiceBox<String> boxOpcoes;
    @FXML
    private ChoiceBox<String> boxOpcoes2;
    @FXML
    private Button btnConversao;
    @FXML
    private Button btnMinimizar;
    @FXML
    private Button btnFechar;
    ObservableList<String> listaConversoes = FXCollections.observableArrayList("Km", "hm", "dam", "m", "dm", "cm", "mm");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boxOpcoes.setItems(listaConversoes);
        boxOpcoes2.setItems(listaConversoes);
    }
    
    @FXML
    public void converterValor(ActionEvent event) throws Exception {
        String undAtual = boxOpcoes.getValue();
        String undFinal = boxOpcoes2.getValue();
        Double valor = null;
        Double resultado = 0.0;
        try {
            valor = Double.parseDouble(campoValor.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (undAtual == null || undFinal == null || valor == null){
            labelResultado.setText("");
            labelAviso.setText("Preencha corretamente!");
        } else{
            labelAviso.setText("");
            switch(undAtual){
                case "Km":
                    if (undFinal.equals("hm")){
                        resultado = valor*10;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor*100;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor*1000;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor*10000;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor*100000;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*1000000;
                    }
                    break;
                case "hm":
                    if (undFinal.equals("Km")){
                        resultado = valor/10;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor*10;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor*100;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor*1000;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor*10000;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*100000;
                    }
                    break;
                case "dam":
                    if (undFinal.equals("Km")){
                        resultado = valor/100;
                    }
                    if (undFinal.equals("hm")){
                        resultado = valor/10;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor*10;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor*100;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor*1000;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*10000;
                    }
                    break;
                case "m":
                    if (undFinal.equals("Km")){
                        resultado = valor/1000;
                    }
                    if (undFinal.equals("hm")){
                        resultado = valor/100;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor/10;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor*10;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor*100;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*1000;
                    }
                    break;
                case "dm":
                    if (undFinal.equals("Km")){
                        resultado = valor/10000;
                    }
                    if (undFinal.equals("hm")){
                        resultado = valor/1000;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor/100;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor/10;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor*10;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*100;
                    }
                    break;
                case "cm":
                    if (undFinal.equals("Km")){
                        resultado = valor/100000;
                    }
                    if (undFinal.equals("hm")){
                        resultado = valor/10000;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor/1000;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor/100;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor/10;
                    }
                    if (undFinal.equals("mm")){
                        resultado = valor*10;
                    }
                    break;
                case "mm":
                    if (undFinal.equals("Km")){
                        resultado = valor/1000000;
                    }
                    if (undFinal.equals("hm")){
                        resultado = valor/100000;
                    }
                    if (undFinal.equals("dam")){
                        resultado = valor/10000;
                    }
                    if (undFinal.equals("m")){
                        resultado = valor/1000;
                    }
                    if (undFinal.equals("dm")){
                        resultado = valor/100;
                    }
                    if (undFinal.equals("cm")){
                        resultado = valor/10;
                    }
                    break;
            }
            if (!undAtual.equals(undFinal)){
                labelResultado.setText(resultado + " " + undFinal);
            } else{
                labelResultado.setText(valor + " " + undFinal);
            }
        }
    }

    @FXML
    public void minimizar(ActionEvent event){
        Stage stage = (Stage) btnMinimizar.getScene().getWindow(); 
        stage.setIconified(true);
    }

    @FXML
    public void fechar(ActionEvent event) { 
        System.exit(0); 
    }

    @FXML
    public void mouseOn(MouseEvent event){
        if (event.getSource().equals(btnFechar)){
            btnFechar.setStyle("-fx-border-radius: 6px; -fx-background-radius: 6px; -fx-background-color: #1979EB;");
        }
        if (event.getSource().equals(btnMinimizar)){
            btnMinimizar.setStyle("-fx-border-radius: 6px; -fx-background-radius: 6px; -fx-background-color: #1979EB;");
        }
        if (event.getSource().equals(btnConversao)){
            btnConversao.setStyle("-fx-border-radius: 20px; -fx-background-radius: 20px; -fx-background-color: #69A3E6");
        }
    }

    @FXML
    public void mouseOff(MouseEvent event){
        if (event.getSource().equals(btnFechar)){
            btnFechar.setStyle("-fx-border-radius: 6px; -fx-background-radius: 6px; -fx-background-color:  #7AAFED;");
        }
        if (event.getSource().equals(btnMinimizar)){
            btnMinimizar.setStyle("-fx-border-radius: 6px; -fx-background-radius: 6px; -fx-background-color:  #7AAFED;");
        }
        if (event.getSource().equals(btnConversao)){
            btnConversao.setStyle("-fx-border-radius: 20px; -fx-background-radius: 20px; -fx-background-color:  #7AAFED;");
        }
    }

}
