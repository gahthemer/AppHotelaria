package view.componetes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class painelbotoes extends HBox {

    private static final String BACKGROUND_COLOR = "-fx-background-color: #4a6b8a;; -fx-text-fill: white;";
    private static final String FONT_STYLE = "-fx-font-size: 16px; -fx-font-weight: bold;";
    private static final String BACKGROUND_STYLE = "-fx-background-color: #2c3e50;";
    private static final String BUTTON_STYLE = "-fx-background-color: #34495e";


    private final Button btnCadastrar = new Button("Cadastro");
    private final Button btnExcluir = new Button("Excluir");
    private final Button btnAtualizar = new Button("Atuslizar");

    public painelbotoes (){

        inicializarComponentes();

        ImageView iconCadastrar = new ImageView(new Image(getClass().getResourceAsStream("/view/img/icons8-signup-64.png")));
        iconCadastrar.setFitHeight(20);
        iconCadastrar.setFitWidth(20);
        btnCadastrar.setGraphic(iconCadastrar);

        ImageView iconAtualizar = new ImageView(new Image(getClass().getResourceAsStream("/view/img/icons8-17372-0-73111-repetição-direita-43-setas-64.png")));
        iconAtualizar.setFitHeight(20);
        iconAtualizar.setFitWidth(20);
        btnAtualizar.setGraphic(iconAtualizar);

        ImageView iconExcluir = new ImageView(new Image(getClass().getResourceAsStream("/view/img/delete48px.png")));
        iconExcluir.setFitHeight(20);
        iconExcluir.setFitWidth(20);
        btnExcluir.setGraphic(iconExcluir);

        String styleButtonCadastrar = "-fx-background-color: #5395DB;-fx-cursor: hand; -fx-text-fill: white";
        String styleButtonAtualizar = "-fx-background-color: #3585DB;-fx-cursor: hand; -fx-text-fill: white";
        String styleButtonExcluir = "-fx-background-color: #DB4035;-fx-cursor: hand; -fx-text-fill: white";

        btnCadastrar.setStyle(styleButtonCadastrar);
        btnAtualizar.setStyle(styleButtonAtualizar);
        btnExcluir.setStyle(styleButtonExcluir);


        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButtonCadastrar.replace("#5395DB", "#5677E5")));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButtonCadastrar));


        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButtonExcluir.replace("#DB4035", "#5677E5")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButtonExcluir));

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButtonAtualizar.replace("#3585DB", "#5677E5")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButtonAtualizar));

        getChildren().addAll( btnCadastrar, btnAtualizar, btnExcluir);


    }

    private void inicializarComponentes() {
        setPadding(new Insets(20));
        setSpacing(15);
        //setStyle(BACKGROUND_COLOR);


    }

    private void configurarBotoes() {

        btnCadastrar.setMaxWidth(Double.MAX_VALUE);
        btnExcluir.setMaxWidth(Double.MAX_VALUE);
        btnAtualizar.setMaxWidth(Double.MAX_VALUE);
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }

    public Button getBtnCadCliente() {
        return btnAtualizar;
    }

    public Button getBtnCadQuarto() {
        return btnExcluir;
    }



}
