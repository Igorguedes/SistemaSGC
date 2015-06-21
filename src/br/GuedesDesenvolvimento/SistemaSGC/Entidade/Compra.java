/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Igor
 */
public class Compra {
    private int codigo;
    private Cliente cliente;
    private Produto produto;
    private double valorTotal;
    private Date data;
    
    
    private List <Produto> produtos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public String getDataFormatadaBanco(){
        String data;
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        data = dt.format(this.data);
        return data;
    }
   public void addProdutos(Produto produto){
       this.produtos.add(produto);
   }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
   public void setData() {
        this.data = new java.sql.Date(System.currentTimeMillis());
    }
   
    
    
}
