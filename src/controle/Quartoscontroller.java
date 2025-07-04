package controle;

import dao.QuartosDAO;
import model.Quarto;

public class Quartoscontroller {
    private final QuartosDAO quartosDAO;


    public Quartoscontroller() {
        this.quartosDAO = new QuartosDAO();
    }

    public void verificarInfodQuartos(int qtd_cama_casal, int qtd_cama_solteiro, String nome, String numero, double preco, Boolean disponivel) {

        Quarto quarto = new Quarto(qtd_cama_casal, qtd_cama_solteiro, nome, numero, preco, disponivel);
        quartosDAO.inserirQuartos(quarto);
    }
}