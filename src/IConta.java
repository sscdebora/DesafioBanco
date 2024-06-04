public interface IConta {
//interface: classe abstrata(caracteristica de solicitar implementacao que ela sozinha nao consegue resolver- a classe que
//for implementar a interface, precisa saber como implementar os metodos- delega responsabilidade de implementacao) 
//com todos os metodos abstratos. Todos os metodos necessariamente sao publicos
     void sacar(double valor);

     void depositar(double valor);

     void transferir(double valor, Conta contaDestino);

     void imprimirExtrato();
    
}
