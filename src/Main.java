import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Meu Banco");
        banco.setContas(new ArrayList<>());

        Cliente cliente1 = new Cliente("Debora");
        Cliente cliente2 = new Cliente("Cristina");

        Conta cc1 = new ContaCorrente(cliente1);
        Conta cp1 = new ContaPoupanca(cliente1);

        Conta cc2 = new ContaCorrente(cliente2);
        Conta cp2 = new ContaPoupanca(cliente2);

        banco.getContas().add(cc1);
        banco.getContas().add(cp1);
        banco.getContas().add(cc2);
        banco.getContas().add(cp2);

        cc1.depositar(1000);
        cc1.imprimirInfosComuns();

        cp1.depositar(500);
        cp1.imprimirInfosComuns();

        cc1.transferir(200, cp1);
        cc1.imprimirInfosComuns();
        cp1.imprimirInfosComuns();

        cc2.depositar(1500);
        cp2.depositar(700);
        cc2.transferir(300, cp2);
        cc2.imprimirInfosComuns();
        cp2.imprimirInfosComuns();
    }
}
