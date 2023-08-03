package main;

import exception.ControleRemotoDesligadoException;

public class ControleRemoto  implements Controlador {
    private int volume;
    private boolean ligado;
    private boolean tocando;

    public ControleRemoto() {
        volume = 50;
        ligado = false;
        tocando = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    @Override
    public void ligar() {
        setLigado(true);
    }

    @Override
    public void desligar() {
        setLigado(false);
    }

    @Override
    public void abrirMenu() throws ControleRemotoDesligadoException {
        if(isLigado()) {
            System.out.println("Está ligado: " + isLigado());
            System.out.print("volume : " + getVolume() + " ");
            for(int i = 0;i < getVolume();i++) {
                System.out.print("|"); // Quantidade de barras equivalentes ao nível do volume.
            }
        }
        else {
            throw new ControleRemotoDesligadoException();
        }
    }

    @Override
    public String fecharMenu() throws ControleRemotoDesligadoException {
        if(isLigado()) {
            return "Fechando Menu...";
        }
        else {
            throw new ControleRemotoDesligadoException();
        }
    }

    @Override
    public void aumentarVolume() throws ControleRemotoDesligadoException {
        if(isLigado()) {
            setVolume(getVolume() + 5);
            System.out.println("volume : " + getVolume());
        }
        else {
            throw new ControleRemotoDesligadoException();
        }
    }

    @Override
    public void diminuirVolume() throws ControleRemotoDesligadoException {
        if(isLigado()) {
            setVolume(getVolume() - 5);
            System.out.println("volume : " + getVolume());
        }
        else {
            throw new ControleRemotoDesligadoException();

        }
    }

    @Override
    public void ligarMudo() {
        if(isLigado() && getVolume() > 0) {
            setVolume(0);
        }
        else {
            throw new RuntimeException("Não é possível mutar! ");
        }
    }

    @Override
    public void desligarMudo() {
        if(isLigado() && getVolume() == 0 ) {
            setVolume(50);
        }
        else {
            throw new RuntimeException("Não é possível desmutar! ");
        }
    }

    @Override
    public void play() {
        if(isLigado() && !isTocando()) {
            setTocando(true);
        }
        else {
            throw new RuntimeException("Não é possível dar play!");
        }
    }

    @Override
    public void pause() {
        if(isLigado() && isTocando()) {
            setTocando(false);
        }
        else {
            throw new RuntimeException("Não é possível pausar!");
        }

    }
}
