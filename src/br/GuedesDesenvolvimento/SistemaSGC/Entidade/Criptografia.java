/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Entidade;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Igor
 */
public class Criptografia {
    
    public String converterHexadecimalParaString(byte[] valorHexadecimal){
        StringBuilder valorConvertido = new StringBuilder();
        for(byte caracter: valorHexadecimal){
            valorConvertido.append(String.format("%02X",0xFF & caracter));
        }
        return valorConvertido.toString();
    }
    
    public String criptografiaSHA(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException{
       
        MessageDigest algorotimo = MessageDigest.getInstance("SHA-256");
        byte[] codigoHashHexaDecimal = algorotimo.digest(texto.getBytes("UTF-8"));
        String codigoHashFinal= converterHexadecimalParaString(codigoHashHexaDecimal);
        
        return codigoHashFinal;
    }
    
}
