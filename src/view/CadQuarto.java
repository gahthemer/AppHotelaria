package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.componetes.MenuLateral;
import view.componetes.painelbotoes;

public class CadQuarto extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        // Carregar imagens
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/hoteltransylvania.jpg"));
        Image imguser = new Image(getClass().getResourceAsStream("/view/resources/img/vampiro.jpg"));

        BorderPane mainPane = new BorderPane();

        // Adicionar o MenuLateral ao layout principal
        MenuLateral menuLateral = new MenuLateral();
        mainPane.setLeft(menuLateral);

        painelbotoes botoes = new painelbotoes();

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
        VBox contentBox = new VBox(10, Titulobox, formGrid, botoes);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: rgba(155, 155, 155, 0.9); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;-fx-background-radius: 10px");
        contentBox.setMaxHeight(300);
        contentBox.setMaxWidth(400);

        // Layout principal com fundo
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-image: url('/view/resources/img/quarto.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");
        layout.getChildren().add(contentBox);

        // Adicionar o conteúdo central ao BorderPane
        mainPane.setCenter(layout);


        // Configurar a cena e exibir a janela
        Scene scene = new Scene(mainPane, 800, 600); // Aumentei o tamanho para acomodar o menu lateral
        janela.setTitle("Hotel Transylvania");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
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

    public static void main(String[] args) {launch(args);}}