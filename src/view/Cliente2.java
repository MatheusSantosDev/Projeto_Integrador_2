/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author higor
 */
public class Cliente2 {
    private int Id;
    private String Nome;
    private String Endereco;
    private FileInputStream File;

    public String getEndereco() {
        return Endereco;
    }

    public String getNome() {
        return Nome;
    }

    public FileInputStream getFile() {
        return File;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setFile(FileInputStream File) {
        this.File = File;
    } 
     public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    
}
