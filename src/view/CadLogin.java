package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CadLogin extends Application {
    private boolean darkMode = false;
    private TextField txtEmail = new TextField();
    private PasswordField pfSenha = new PasswordField();
    private TextField visiblePasswordField = new TextField();

    private VBox loginBox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar imagens
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/hoteltransylvania.jpg"));
        Image imgVampire = new Image(getClass().getResourceAsStream("/view/resources/img/vampiro.jpg"));
        Image imgDarkMode = new Image(getClass().getResourceAsStream("/view/resources/img/solelua.jpg"));
        Image eyeIconImage = new Image(getClass().getResourceAsStream("/view/resources/img/olho.jpg"));

        // Configuração do layout principal
        BorderPane mainPane = new BorderPane();

        // Botão de modo noturno
        Button btnModoNoturno = createDarkModeButton(imgDarkMode, mainPane);

        // Cabeçalho com logo e título
        HBox headerBox = createHeaderBox(imgVampire);

        // Formulário de login
        GridPane loginGrid = createLoginGrid(eyeIconImage);

        // Container principal do formulário
        loginBox = createLoginBox(headerBox, loginGrid, btnModoNoturno);

        // Layout com imagem de fundo
        StackPane root = new StackPane();
        root.setStyle("-fx-background-image: url('/view/resources/img/galaxia.jpg'); " +
                "-fx-background-repeat: stretch; -fx-background-size: cover;");
        root.getChildren().add(loginBox);
        root.setAlignment(Pos.CENTER_RIGHT);

        // Configuração da cena
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Hotel Transylvania - Login");
        primaryStage.getIcons().add(imgIcon);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createDarkModeButton(Image imgDarkMode, BorderPane mainPane) {
        Button btnModoNoturno = new Button();
        btnModoNoturno.setOnAction(e -> toggleDarkMode());
        btnModoNoturno.setStyle("-fx-background-color: #5395DB; -fx-cursor: hand; " +
                "-fx-text-fill: white; -fx-background-radius: 20;");

        ImageView iconNoturno = new ImageView(imgDarkMode);
        iconNoturno.setFitHeight(20);
        iconNoturno.setFitWidth(20);
        btnModoNoturno.setGraphic(iconNoturno);
        return btnModoNoturno;
    }

    private HBox createHeaderBox(Image imgVampire) {
        ImageView viewImgVampire = new ImageView(imgVampire);
        viewImgVampire.setFitHeight(30);
        viewImgVampire.setFitWidth(30);

        Label lblTitulo = new Label("Login");
        lblTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lblTitulo.setTextFill(Color.PURPLE);

        HBox headerBox = new HBox(10, viewImgVampire, lblTitulo);
        headerBox.setAlignment(Pos.TOP_CENTER);
        headerBox.setPadding(new Insets(20));
        return headerBox;
    }

    private GridPane createLoginGrid(Image eyeIconImage) {
        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.TOP_CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(20));

        // Campo de email
        Label lblEmail = new Label("Email:");
        lblEmail.setStyle("-fx-font-weight: bold;");
        txtEmail.setPromptText("Digite seu email");

        // Campo de senha
        Label lblSenha = new Label("Senha:");
        lblSenha.setStyle("-fx-font-weight: bold;");
        pfSenha.setPromptText("Digite sua senha");

        // Campo de senha visível (inicialmente oculto)
        visiblePasswordField.setPromptText("Digite sua senha");
        visiblePasswordField.setVisible(false);
        visiblePasswordField.setManaged(false);

        // Botão de alternar visibilidade da senha
        ImageView eyeIcon = new ImageView(eyeIconImage);
        eyeIcon.setFitHeight(20);
        eyeIcon.setFitWidth(20);
        eyeIcon.setCursor(javafx.scene.Cursor.HAND);

        // Botão de login
        Button btnLogin = new Button("Entrar");
        btnLogin.setStyle("-fx-background-color: #591691; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-cursor: hand; -fx-background-radius: 20;");
        btnLogin.setMaxWidth(Double.MAX_VALUE);

        // Configuração do status


        // Adicionando componentes ao grid
        loginGrid.add(lblEmail, 0, 0);
        loginGrid.add(txtEmail, 1, 0);
        loginGrid.add(lblSenha, 0, 1);
        loginGrid.add(pfSenha, 1, 1);
        loginGrid.add(visiblePasswordField, 1, 1);
        loginGrid.add(eyeIcon, 2, 1);
        loginGrid.add(btnLogin, 1, 2);


        // Configuração do GridPane
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        loginGrid.getColumnConstraints().addAll(col1, col2);

        // Ação do botão de alternar visibilidade da senha
        eyeIcon.setOnMouseClicked(event -> togglePasswordVisibility());

        // Sincronização dos campos de senha
        pfSenha.textProperty().addListener((obs, oldValue, newValue) -> {
            visiblePasswordField.setText(newValue);
        });

        visiblePasswordField.textProperty().addListener((obs, oldValue, newValue) -> {
            pfSenha.setText(newValue);
        });

        // Ação do botão de login
        btnLogin.setOnAction(e -> handleLogin());

        return loginGrid;
    }

    private VBox createLoginBox(HBox headerBox, GridPane loginGrid, Button btnModoNoturno) {
        VBox box = new VBox(20, headerBox, loginGrid, btnModoNoturno);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));
        box.setStyle("-fx-background-color: rgba(43,96,148,0.8); " +
                "-fx-border-color: #000000; -fx-border-width: 2px; " +
                "-fx-border-radius: 10px; -fx-background-radius: 10px");
        box.setMaxWidth(400);
        return box;
    }

    private void togglePasswordVisibility() {
        boolean isPasswordVisible = visiblePasswordField.isVisible();

        visiblePasswordField.setVisible(!isPasswordVisible);
        visiblePasswordField.setManaged(!isPasswordVisible);
        pfSenha.setVisible(isPasswordVisible);
        pfSenha.setManaged(isPasswordVisible);

        if (!isPasswordVisible) {
            visiblePasswordField.requestFocus();
            visiblePasswordField.positionCaret(visiblePasswordField.getText().length());
        } else {
            pfSenha.requestFocus();
            pfSenha.positionCaret(pfSenha.getText().length());
        }
    }

    private void handleLogin() {
        String email = txtEmail.getText();
        String senha = pfSenha.getText();

        if (email.isEmpty() || senha.isEmpty()) {
            showStatusMessage("Email e senha são obrigatórios!", Color.RED);
        } else if (validarLogin(email, senha)) {
            showStatusMessage("Login bem-sucedido! Bem-vindo ao Hotel Transylvania!", Color.GREEN);
            // Aqui você pode redirecionar para a tela principal
        } else {
            showStatusMessage("Credenciais inválidas! Tente novamente.", Color.RED);
        }
    }

    private void showStatusMessage(String message, Color color) {

    }

    private boolean validarLogin(String email, String senha) {
        // Lógica de validação simples (substitua por uma verificação real)
        return email.equals("convidado@hoteltransylvania.com") && senha.equals("vamp123");
    }

    private void toggleDarkMode() {
        darkMode = !darkMode;
        if (darkMode) {
            applyDarkTheme();
        } else {
            applyLightTheme();
        }
    }

    private void applyLightTheme() {
        loginBox.setStyle("-fx-background-color: rgba(43,96,148,0.8); " +
                "-fx-border-color: #000000; -fx-border-width: 2px; " +
                "-fx-border-radius: 10px; -fx-background-radius: 10px");
    }

    private void applyDarkTheme() {
        loginBox.setStyle("-fx-background-color: rgba(60, 60, 60, 0.9); " +
                "-fx-border-color: #9c27b0; -fx-border-width: 2px; " +
                "-fx-border-radius: 10px; -fx-background-radius: 10px; " +
                "-fx-text-fill: white;");
    }

    public static void main(String[] args) {
        launch(args);
    }
}