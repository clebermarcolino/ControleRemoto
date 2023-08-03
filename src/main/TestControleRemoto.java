package main;

import exception.ControleRemotoDesligadoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestControleRemoto {
    private ControleRemoto controleRemoto;

    @BeforeEach
    public void setUp() {
        controleRemoto = new ControleRemoto();
    }

    @Test
    public void testLigarDesligar() {
        assertFalse(controleRemoto.isLigado());
        controleRemoto.ligar();
        assertTrue(controleRemoto.isLigado());
        controleRemoto.desligar();
        assertFalse(controleRemoto.isLigado());
    }

    @Test
    public void testAumentarDiminuirVolume() {
        assertEquals(50, controleRemoto.getVolume());
        controleRemoto.ligar();
        assertDoesNotThrow(() -> controleRemoto.aumentarVolume());
        assertEquals(55, controleRemoto.getVolume());
        assertDoesNotThrow(() -> controleRemoto.diminuirVolume());
        assertEquals(50, controleRemoto.getVolume());
    }

    @Test
    public void testLigarMudo() {
        controleRemoto.ligar();
        controleRemoto.ligarMudo();
        assertEquals(0, controleRemoto.getVolume());
    }

    @Test
    public void testDesligarMudo() {
        controleRemoto.ligar();
        controleRemoto.ligarMudo();
        controleRemoto.desligarMudo();
        assertEquals(50, controleRemoto.getVolume());
    }

    @Test
    public void testPlayPause() {
        controleRemoto.ligar();
        assertFalse(controleRemoto.isTocando());
        controleRemoto.play();
        assertTrue(controleRemoto.isTocando());
        controleRemoto.pause();
        assertFalse(controleRemoto.isTocando());
    }

    @Test
    public void testAbrirMenu() {
        controleRemoto.ligar();
        assertDoesNotThrow(() -> controleRemoto.abrirMenu());
    }

    @Test
    public void testFecharMenu() {
        controleRemoto.ligar();
        Assertions.assertDoesNotThrow(() -> controleRemoto.fecharMenu());
    }

    @Test
    public void testMenuDesligado() {
        assertThrows(ControleRemotoDesligadoException.class, () -> controleRemoto.abrirMenu());
        assertThrows(ControleRemotoDesligadoException.class, () -> controleRemoto.fecharMenu());
        assertThrows(ControleRemotoDesligadoException.class, () -> controleRemoto.aumentarVolume());
        assertThrows(ControleRemotoDesligadoException.class, () -> controleRemoto.diminuirVolume());
        assertThrows(RuntimeException.class, () -> controleRemoto.ligarMudo());
        assertThrows(RuntimeException.class, () -> controleRemoto.desligarMudo());
        assertThrows(RuntimeException.class, () -> controleRemoto.play());
        assertThrows(RuntimeException.class, () -> controleRemoto.pause());
    }
}
