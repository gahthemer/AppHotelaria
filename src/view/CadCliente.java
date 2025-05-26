package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.componetes.MenuLateral;
import view.componetes.painelbotoes;

public class CadCliente extends Application {
    private boolean darkMode = false;
    private Scene scene;

    @Override
    public void start(Stage janela) throws Exception {

        // Carregar imagens
        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/img/icons8-signup-64.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/img/icons8-17372-0-73111-repetição-direita-43-setas-64.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/img/delete48px.png"));
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/img/Hotel_Transylvania_-_The_Television_Series_logo.png"));
        Image imguser = new Image(getClass().getResourceAsStream("/view/img/icons8-vampiro-64.png"));


        BorderPane mainPane = new BorderPane();

        // Adicionar o MenuLateral ao layout principal
        MenuLateral menuLateral = new MenuLateral();
        mainPane.setLeft(menuLateral);

        painelbotoes botoes = new painelbotoes();

        Button btnModoNoturno = new Button();
        btnModoNoturno.setOnAction(e -> toggleDarkMode(mainPane));
        btnModoNoturno.setStyle("-fx-background-color: #5395DB;-fx-cursor: hand; -fx-text-fill: white;-fx-background-radius: 20;");
        ImageView iconNoturno = new ImageView(new Image(getClass().getResourceAsStream("/view/img/icons8-dia-e-noite-50.png")));
        iconNoturno.setFitHeight(20);
        iconNoturno.setFitWidth(20);
        btnModoNoturno.setGraphic(iconNoturno);


        // Parâmetros para definir como a imagem será visualizada

        ImageView viewimgIcon = new ImageView(imgIcon);
        ImageView viewimguser = new ImageView(imguser);

        viewimguser.setFitHeight(15);
        viewimguser.setFitWidth(15);


        Label lblTitulo = new Label("Cadastro de Clientes");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox Titulobox = new HBox(viewimguser, lblTitulo);
        Titulobox.setPadding(new Insets(20, 20, 20, 20));
        Titulobox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = mascara("###.###.###-##");
        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        ComboBox<String> bootemail = new ComboBox<>();
        bootemail.getItems().addAll("@gmail.com", "@yahoo.com", "hotmail.com");
        bootemail.setPromptText("Selecione:");
        Label lblTel = new Label("Telefone: ");
        TextField txtTel = mascara("(##)####-#####");

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(bootemail, 2, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);


        // Criando um painel para envolver o conteúdo
        VBox contentBox = new VBox(10, Titulobox, formGrid, botoes, btnModoNoturno);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: rgba(155, 155, 155, 0.9); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;-fx-background-radius: 10px");
        contentBox.setMaxHeight(300);
        contentBox.setMaxWidth(400);

        // Layout principal com fundo
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-image: url('/view/img/transylvania2.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover;");
        layout.getChildren().add(contentBox);

        // Adicionar o conteúdo central ao BorderPane
        mainPane.setCenter(layout);

        // Configurar a cena e exibir a janela
        Scene scene = new Scene(mainPane, 800, 600); // Aumentei o tamanho para acomodar o menu lateral
        janela.setTitle("Hotel Transylvania");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.show();
    }
    private void toggleDarkMode(BorderPane mainPane) {
        darkMode = !darkMode;

        if (darkMode) {
            applyDarkTheme(mainPane);
        } else {
            applyLightTheme(mainPane);
        }
    }

    private void applyLightTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(240, 240, 240, 0.9); " +
                    "-fx-border-color: #6a1b9a; -fx-border-width: 2px; " +
                    "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        }
    }

    private void applyDarkTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(60, 60, 60, 0.9); " +
                    "-fx-border-color: #9c27b0; -fx-border-width: 2px; " +
                    "-fx-border-radius: 10px; -fx-background-radius: 10px; " +
                    "-fx-text-fill: white;");
        }
    }


    // Método para aplicar máscara
    private TextField mascara(String mascara) {
        TextField tf = new TextField();
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            String valor = newValue.replaceAll("[^0-9]", "");
            StringBuilder valorFormatado = new StringBuilder();
            int index = 0;
            for (char c : mascara.toCharArray()) {
                if (c == '#') {
                    if (index < valor.length()) {
                        valorFormatado.append(valor.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    valorFormatado.append(c);
                }
            }
            tf.setText(valorFormatado.toString());
            tf.positionCaret(valorFormatado.length());
        });
        return tf;
    }

    public static void main(String[] args) {
        launch(args);
    }
}