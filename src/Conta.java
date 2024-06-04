import java.util.Objects;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    // atributos
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    // implementando os metodos da classe abstrata
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia)); // usa-se this dentro da propria classe para
        System.out.println(String.format("Numero: %d", this.numero));// se referir a instancia atual
        System.out.println(String.format("Saldo: %.2f", this.saldo));// usa-se super na subclasse para se referir a
                                                                     // superclasse imediata
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia && numero == conta.numero && Double.compare(conta.saldo, saldo) == 0 && Objects.equals(cliente, conta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo, cliente);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
}
}
