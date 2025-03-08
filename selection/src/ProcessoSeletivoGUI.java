import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela interface gráfica do sistema RSlection.
 */
public class ProcessoSeletivoGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField candidatoField;
    private JTextField salarioField;
    private JTextField experienciaField;
    private List<Candidato> candidatos = new ArrayList<>();
    private ProcessoSeletivo processoSeletivo;

    /**
     * Construtor que inicializa a interface gráfica.
     */
    public ProcessoSeletivoGUI() {
        processoSeletivo = new ProcessoSeletivo();

        // Configuração da janela principal
        frame = new JFrame("RSlection - Processo Seletivo");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel para entrada de candidatos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel nomeLabel = new JLabel("Nome do Candidato:");
        candidatoField = new JTextField();

        JLabel salarioLabel = new JLabel("Pretensão Salarial:");
        salarioField = new JTextField();

        JLabel experienciaLabel = new JLabel("Experiência (anos):");
        experienciaField = new JTextField();

        JButton addButton = new JButton("Adicionar");

        // Adiciona os componentes ao painel de entrada
        inputPanel.add(nomeLabel);
        inputPanel.add(candidatoField);
        inputPanel.add(salarioLabel);
        inputPanel.add(salarioField);
        inputPanel.add(experienciaLabel);
        inputPanel.add(experienciaField);
        inputPanel.add(new JLabel()); // Espaço vazio
        inputPanel.add(addButton);

        // Área de saída de texto para exibir os resultados
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Botão para iniciar a seleção dos candidatos
        JButton startButton = new JButton("Iniciar Seleção");

        // Adiciona componentes à janela principal
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        // Define ações dos botões
        addButton.addActionListener(this::adicionarCandidato);
        startButton.addActionListener(this::selecionarCandidatos);

        frame.setVisible(true);
    }

    /**
     * Método que adiciona um novo candidato à lista.
     */
    private void adicionarCandidato(ActionEvent e) {
        String nome = candidatoField.getText().trim();
        String salarioText = salarioField.getText().trim();
        String experienciaText = experienciaField.getText().trim();

        if (nome.isEmpty() || salarioText.isEmpty() || experienciaText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double salario = Double.parseDouble(salarioText);
            double experiencia = Double.parseDouble(experienciaText);

            candidatos.add(new Candidato(nome, salario, experiencia));
            outputArea.append("Candidato adicionado: " + nome + "\n");

            // Limpar campos após a adição
            candidatoField.setText("");
            salarioField.setText("");
            experienciaField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Digite valores numéricos válidos para salário e experiência.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que inicia o processo de seleção dos candidatos.
     */
    private void selecionarCandidatos(ActionEvent e) {
        outputArea.append("\n=== Iniciando Seleção ===\n");
        List<String> resultado = processoSeletivo.selecionarCandidatos(candidatos);
        for (String linha : resultado) {
            outputArea.append(linha + "\n");
        }
    }

    /**
     * Método principal para iniciar a interface gráfica.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProcessoSeletivoGUI::new);
    }
}
