/**
 * Classe que representa um candidato no processo seletivo.
 */
public class Candidato {
    private String nome;
    private double salarioPretendido;
    private double experiencia;

    /**
     * Construtor da classe Candidato.
     *
     * @param nome Nome do candidato.
     * @param salarioPretendido Pretensão salarial do candidato.
     * @param experiencia Tempo de experiência do candidato em anos.
     */
    public Candidato(String nome, double salarioPretendido, double experiencia) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
        this.experiencia = experiencia;
    }

    // Métodos getter para acessar os atributos da classe
    public String getNome() {
        return nome;
    }

    public double getSalarioPretendido() {
        return salarioPretendido;
    }

    public double getExperiencia() {
        return experiencia;
    }
}
