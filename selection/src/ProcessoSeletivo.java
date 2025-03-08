import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar o processo seletivo de candidatos.
 */
public class ProcessoSeletivo {
    private final double salarioBase = 3000; // Definição do salário base
    private final double experienciaEsperada = 1; // Experiência mínima esperada

    /**
     * Método para selecionar candidatos com base nos critérios definidos.
     *
     * @param candidatos Lista de candidatos a serem avaliados.
     * @return Lista de mensagens com o resultado da seleção.
     */
    public List<String> selecionarCandidatos(List<Candidato> candidatos) {
        List<String> selecionados = new ArrayList<>();
        List<String> listaEspera = new ArrayList<>();

        // Percorre a lista de candidatos
        for (Candidato candidato : candidatos) {
            double salarioPretendido = candidato.getSalarioPretendido();
            double experiencia = candidato.getExperiencia();

            // Monta a mensagem com os dados do candidato
            String resultado = candidato.getNome() + " - Pretende: " + salarioPretendido +
                    ", Experiência: " + experiencia + " anos\n";

            // Regras de seleção
            if (salarioPretendido <= salarioBase && experiencia >= experienciaEsperada) {
                selecionados.add("✅ " + resultado + "Selecionado para entrevista.");
            } else if (salarioPretendido > salarioBase && experiencia >= experienciaEsperada && listaEspera.size() < 2) {
                listaEspera.add("🟡 " + resultado + "Adicionado à lista de espera.");
            } else {
                selecionados.add("❌ " + resultado + "Não atende aos requisitos.");
            }
        }

        // Adiciona os candidatos da lista de espera ao final da seleção
        selecionados.addAll(listaEspera);
        return selecionados;
    }
}
