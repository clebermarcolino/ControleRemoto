package main;

import exception.ControleRemotoDesligadoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ControleRemotoDesligadoException {
        int comando;

        ControleRemoto controle = new ControleRemoto();
        Scanner sc = new Scanner(System.in);

        controle.ligar();

        do {
            System.out.print("""
                    Digite abaixo o número correspondente ao comando que você deseja executar:
                    1 = Abrir menu
                    2 = Fechar menu
                    3 = Aumentar volume
                    4 = Diminuir volume
                    5 = Ligar mudo
                    6 = Desligar mudo
                    7 = Play
                    8 = Pause
                    9 = Desligar
                    """);

            comando = sc.nextInt();

            switch (comando) {
                case 1:
                    controle.abrirMenu();
                    System.out.println();
                    break;

                case 2:
                    System.out.println(controle.fecharMenu());
                    break;

                case 3:
                    controle.aumentarVolume();
                    break;

                case 4:
                    controle.diminuirVolume();
                    break;

                case 5:
                    controle.ligarMudo();
                    break;

                case 6:
                    controle.desligarMudo();
                    break;

                case 7:
                    controle.play();
                    break;

                case 8:
                    controle.setTocando(true);
                    controle.pause();
                    break;

                case 9:
                    controle.desligar();
                    break;

                default:
                    System.out.println("Número inválido! Deve - se digitar um número entre 1 a 9. ");
            }
        } while (controle.isLigado());
    }
}