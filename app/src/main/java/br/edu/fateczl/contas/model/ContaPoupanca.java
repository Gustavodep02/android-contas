package br.edu.fateczl.contas.model;
/*
 *@author:<Gustavo de Paula>
 */
public class ContaPoupanca extends ContaBancaria{

    public int dia_de_rendimento;

    public void calcularNovoSaldo(float taxa) {
        saldo = saldo + (saldo * taxa);
    }
}
