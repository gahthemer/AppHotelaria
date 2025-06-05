package view.componetes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MenuLateral extends VBox {

    private static final String BACKGROUND_COLOR = "-fx-background-color: #4a6b8a;; -fx-text-fill: white;";
    private static final String FONT_STYLE = "-fx-font-size: 16px; -fx-font-weight: bold;";
    private static final String BACKGROUND_STYLE = "-fx-background-color: #2c3e50;";
    private static final String BUTTON_STYLE = "-fx-background-color: #34495e";

    private final Button btnCadCliente = new Button("Cadastro de Cliente");
    private final Button btnCadQuarto = new Button("Cadastro de Quarto");
    private final Button btnCadReserva = new Button("Reserva");
    private final Button btnRelatorio = new Button("Relatório");
    private final Button btnFuncionario = new Button("Funcionario");
    private final Button btnPorta = new Button("Saida");
    private final Button btnnoturno = new Button("modo noturno");

    private boolean darkMode = false;
    private Scene scene;

    public MenuLateral() {

        inicializarComponentes();

        ImageView iconFuncionario = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/funcionario.jpg")));
        iconFuncionario.setFitHeight(20);
        iconFuncionario.setFitWidth(20);
        btnFuncionario.setGraphic(iconFuncionario);

        ImageView iconRelatorio = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/up2.jpg")));
        iconRelatorio.setFitHeight(20);
        iconRelatorio.setFitWidth(20);
        btnRelatorio.setGraphic(iconRelatorio);

        ImageView iconCliente = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/man.jpg")));
        iconCliente.setFitHeight(20);
        iconCliente.setFitWidth(20);
        btnCadCliente.setGraphic(iconCliente);

        ImageView iconQuarto = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/quarto1.jpg")));
        iconQuarto.setFitHeight(20);
        iconQuarto.setFitWidth(20);
        btnCadQuarto.setGraphic(iconQuarto);

        ImageView iconReserva = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/salvar.jpg")));
        iconReserva.setFitHeight(20);
        iconReserva.setFitWidth(20);
        btnCadReserva.setGraphic(iconReserva);

        ImageView iconPorta = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/porta.jpg")));
        iconPorta.setFitHeight(20);
        iconPorta.setFitWidth(20);
        btnPorta.setGraphic(iconReserva);

        ImageView iconNoturno = new ImageView(new Image(getClass().getResourceAsStream("/view/resources/img/solelua.jpg")));
        iconNoturno.setFitHeight(20);
        iconNoturno.setFitWidth(20);
        btnnoturno.setGraphic(iconNoturno);

        String styleButton = "-fx-background-color: transparent;-fx-cursor: hand;";

        btnCadCliente.setStyle(styleButton);
        btnCadQuarto.setStyle(styleButton);
        btnCadReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnPorta.setStyle(styleButton);
        btnnoturno.setStyle(styleButton);


        btnCadCliente.setOnMouseEntered(evento->
        btnCadCliente.setStyle(styleButton.replace("transparent","#5677E5")));
        btnCadCliente.setOnMouseExited(evento -> btnCadCliente.setStyle(styleButton));

        btnCadQuarto.setOnMouseEntered(evento->
                btnCadQuarto.setStyle(styleButton.replace("transparent","#5677E5")));
        btnCadQuarto.setOnMouseExited(evento -> btnCadQuarto.setStyle(styleButton));

        btnCadReserva.setOnMouseEntered(evento->
                btnCadReserva.setStyle(styleButton.replace("transparent","#5677E5")));
        btnCadReserva.setOnMouseExited(evento -> btnCadReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento->
                btnRelatorio.setStyle(styleButton.replace("transparent","#5677E5")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento->
                btnFuncionario.setStyle(styleButton.replace("transparent","#5677E5")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnPorta.setOnMouseEntered(evento->
                btnPorta.setStyle(styleButton.replace("transparent","#5677E5")));
        btnPorta.setOnMouseExited(evento -> btnPorta.setStyle(styleButton));

        btnnoturno.setOnMouseEntered(evento->
                btnnoturno.setStyle(styleButton.replace("transparent","#5677E5")));
        btnnoturno.setOnMouseExited(evento -> btnnoturno.setStyle(styleButton));

    }

    private void inicializarComponentes() {
        setPadding(new Insets(20));
        setSpacing(15);
        setStyle(BACKGROUND_COLOR);


        Label lblMenu = new Label("Menu Principal");
        lblMenu.setStyle("-fx-text-fill: white;");
        configurarBotoes();
        getChildren().addAll(lblMenu, btnCadCliente, btnCadQuarto, btnCadReserva, btnRelatorio, btnFuncionario,btnPorta,btnnoturno);

    }

    private void configurarBotoes() {

        btnCadCliente.setMaxWidth(Double.MAX_VALUE);
        btnCadQuarto.setMaxWidth(Double.MAX_VALUE);
        btnCadReserva.setMaxWidth(Double.MAX_VALUE);
        btnRelatorio.setMaxWidth(Double.MAX_VALUE);
        btnFuncionario.setMaxWidth(Double.MAX_VALUE);
        btnPorta.setMaxWidth(Double.MAX_VALUE);
        btnnoturno.setMaxWidth(Double.MAX_VALUE);
    }

    public  Button getBtnNoturno() { return btnnoturno; }

    public Button getBtnPorta(){return btnPorta;}

    public Button getBtnFuncionario(){return btnFuncionario;}

    public Button getBtnCadCliente() {
        return btnCadCliente;
    }

    public Button getBtnCadQuarto() {
        return btnCadQuarto;
    }

    public Button getBtnCadReserva() {
        return btnCadReserva;
    }

    public Button getBtnRelatorio() {
        return btnRelatorio;
    }
}