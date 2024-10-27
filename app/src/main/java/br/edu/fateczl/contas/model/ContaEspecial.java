package br.edu.fateczl.contas.model;
/*
 *@author:<Gustavo de Paula>
 */
public class ContaEspecial extends ContaBancaria {

    public float limite;

    public void sacar(float valor) {

        if (valor <= saldo + limite) {
            saldo = saldo - valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
