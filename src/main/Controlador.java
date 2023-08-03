package main;

import exception.ControleRemotoDesligadoException;

public interface Controlador {
    public void ligar();
    public void desligar();
    public void abrirMenu() throws ControleRemotoDesligadoException;
    public String fecharMenu() throws ControleRemotoDesligadoException;
    public void aumentarVolume() throws ControleRemotoDesligadoException;
    public void diminuirVolume() throws ControleRemotoDesligadoException;
    public void ligarMudo();
    public void desligarMudo();
    public void play();
    public void pause();
}
