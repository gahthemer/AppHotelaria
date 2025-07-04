package controle;

import dao.UsuariosDAO;
import javafx.scene.paint.Color;
import model.Usuario;

public class UsuariosControllers {
    private  final UsuariosDAO usuariosDAO;


    public UsuariosControllers() {
        this.usuariosDAO = new UsuariosDAO();
    }

    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()){
            return false;
        }
        Usuario usuario = new Usuario("",email,senha,0);
        return usuariosDAO.autenticarUsuario(usuario);
    }
}

