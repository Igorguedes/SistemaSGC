/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Apresentacao.Exception;

/**
 *
 * @author Igor
 */
public class CampoVazioException extends RuntimeException{
    public CampoVazioException(String mensagem){
        super(mensagem);
    }
}
