package test;

import exception.ControleRemotoDesligadoException;
import main.ControleRemoto;
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

<<<<<<< HEAD:src/test/TestControleRemoto.java

=======
>>>>>>> 43dac9b44ef18c253711e9f2b24fa535b9d57938:src/main/TestControleRemoto.java
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
