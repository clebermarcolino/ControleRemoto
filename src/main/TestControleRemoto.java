package main;

import exception.ControleRemotoDesligadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestControleRemoto {
    private ControleRemoto controle;

    @BeforeEach
    public void setUp() {
        controle = new ControleRemoto();
    }

    @Test
    public void testLigarMudo() {
        controle.setLigado(true);
        controle.setVolume(10);

        controle.ligarMudo();

        assertEquals(0, controle.getVolume());
    }

    @Test
    public void testDesligarMudo() {
        controle.setLigado(true);
        controle.setVolume(0);

        controle.desligarMudo();

        assertEquals(50, controle.getVolume());
    }

    @Test
    public void testPlayPause() {
        controle.setLigado(true);

        controle.play();
        assertTrue(controle.isTocando());

        controle.pause();
        assertFalse(controle.isTocando());
    }

    @Test
    public void testAbrirFecharMenu() throws ControleRemotoDesligadoException {
        controle.setLigado(true);
        controle.setVolume(30);

        String menuOutput = controle.fecharMenu();
        assertEquals("Fechando Menu...", menuOutput);

        // Aqui, apenas verificamos se não lança exceção
        assertDoesNotThrow(() -> controle.abrirMenu());
    }

    @Test
    public void testAumentarDiminuirVolume() throws ControleRemotoDesligadoException {
        controle.setLigado(true);
        int initialVolume = controle.getVolume();

        controle.aumentarVolume();
        assertEquals(initialVolume + 5, controle.getVolume());

        controle.diminuirVolume();
        assertEquals(initialVolume, controle.getVolume());
    }

    @Test
    public void testLigarDesligar() {
        assertFalse(controle.isLigado());

        controle.ligar();
        assertTrue(controle.isLigado());

        controle.desligar();
        assertFalse(controle.isLigado());
    }
}
