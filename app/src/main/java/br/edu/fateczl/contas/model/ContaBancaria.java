package br.edu.fateczl.contas.model;
/*
 *@author:<Gustavo de Paula>
 */
public class ContaBancaria {

    public String cliente;
    public int num_conta;
    public float saldo;

    public void sacar(float valor){

        if(valor<=saldo){
            saldo = saldo - valor;
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    public void depositar(float valor) {
        saldo = saldo + valor;
    }
}
