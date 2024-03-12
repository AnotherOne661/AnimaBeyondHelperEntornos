package org.anotherone661.animabeyondhelper.classes;

import org.anotherone661.animabeyondhelper.enums.MOD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DiceRoller {
    private static Scanner scan = new Scanner(System.in);

    public static int rollDice(int sides) {
        return (int) (Math.random() * (sides - 1) + 1);
    }

    public static int danoCombate(int ATK, int DEF, int DMGArma, int calidadArma) {
        int DMGArmaFinal = danoArma(DMGArma, calidadArma);
        int ATKFinal = ATK + calidadArma;
        int dmg = Math.round((float) (DMGArmaFinal * (ATKFinal - DEF)) / 100);
        return dmg;
    }

    public static int danoCombateMod(int ATK, int DEF, int DMGArma, MOD MOD, int calidadArma) {
        int modifier = 0;
        int dmg = 0;
        modifier = switch (MOD) {
            case BLANCOENMOV -> -30;
            case CIEGO -> -200;
            case MIEDO -> -30;
            case LOCURA -> -120;
            case TERROR -> -60;
            case OSCURAS -> -60;
            case RUIDOSO -> -30;
            case COLORES -> +30;
            case SILENCIO -> +60;
            case CONFUNDIDO -> -30;
            case POSICIONVENTAJOSA -> -30;
            case POSICIONDESVENTAJOSA -> +30;
            case DORMIDO -> -200;
            case QUEMARROPA -> -30;
        };
        dmg = Math.round((float) (DMGArma * (ATK - DEF + modifier)) / 100);
        return dmg;
    }

    public static void menu() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("╔════════════════════════════════════════════╗\n" +
                    "║                                            ║\n" +
                    "║   Anima Beyond Fantasy - Game Menu         ║\n" +
                    "║                                            ║\n" +
                    "║   1. Roll dice                             ║\n" +
                    "║   2. Combat                                ║\n" +
                    "║   3. Combat with Status Effects            ║\n" +
                    "║           Pulse 4 para Salir               ║\n" +
                    "║                                            ║\n" +
                    "║   Please enter the number of your choice.  ║\n" +
                    "║                                            ║\n" +
                    "╚════════════════════════════════════════════╝\n");
            try {
                int a = scan.nextInt();
                int t;
                int d;
                int dam;
                int mod;
                MOD smod = null;
                switch (a) {
                    case 1:
                        System.out.println("Introduzca el número de caras que ha de tener el dado:");
                        t = scan.nextInt();
                        System.out.println(rollDice(t));
                        Thread.sleep(1000);
                        break;
                    case 2:
                        System.out.println("Introduzca la tirada de ATK + su habilidad de ATK: ");
                        t = scan.nextInt();
                        System.out.println("Introduzca la tirada de DEF + su habilidad de DEF: ");
                        d = scan.nextInt();
                        System.out.println("Introduzca el daño del arma atacante: ");
                        dam = scan.nextInt();
                        System.out.println("Introduzca la calidad del arma atacante: ");
                        int ca = scan.nextInt();
                        System.out.println(danoCombate(t, d, dam, ca));
                        Thread.sleep(1000);
                        break;
                    case 3:
                        System.out.println("Introduzca la tirada de ATK + su habilidad de ATK: ");
                        t = scan.nextInt();
                        System.out.println("Introduzca la tirada de DEF + su habilidad de DEF: ");
                        d = scan.nextInt();
                        System.out.println("Introduzca el daño del arma atacante: ");
                        dam = scan.nextInt();
                        System.out.println("Introduzca la calidad del arma atacante: ");
                        ca = scan.nextInt();
                        System.out.println("Seleccione el modificador numéricamente:\n" +
                                "1. CIEGO\n" +
                                "2. OSCURAS\n" +
                                "3. BLANCOENMOV\n" +
                                "4. MIEDO\n" +
                                "5. LOCURA\n" +
                                "6. TERROR\n" +
                                "7. RUIDOSO\n" +
                                "8. COLORES\n" +
                                "9. SILENCIOSO\n" +
                                "10. POSICIONVENTAJOSA\n" +
                                "11. POSICIONDESVENTAJOSA\n" +
                                "12. CONFUNDIDO");
                        mod = scan.nextInt();
                        switch (mod) {
                            case 1:
                                smod = MOD.CIEGO;
                                break;
                            case 2:
                                smod = MOD.OSCURAS;
                                break;
                            case 3:
                                smod = MOD.BLANCOENMOV;
                                break;
                            case 4:
                                smod = MOD.MIEDO;
                                break;
                            case 5:
                                smod = MOD.LOCURA;
                                break;
                            case 6:
                                smod = MOD.TERROR;
                                break;
                            case 7:
                                smod = MOD.RUIDOSO;
                                break;
                            case 8:
                                smod = MOD.COLORES;
                                break;
                            case 9:
                                smod = MOD.SILENCIO;
                                break;
                            case 10:
                                smod = MOD.POSICIONVENTAJOSA;
                                break;
                            case 11:
                                smod = MOD.POSICIONDESVENTAJOSA;
                                break;
                            case 12:
                                smod = MOD.CONFUNDIDO;
                                break;
                            default:
                                System.out.println("Se ha introducido un valor erróneo");
                                break;
                        }
                        System.out.println(danoCombateMod(t, d, dam, smod, ca));
                        Thread.sleep(1000);
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.out.println("No se ha introducido un valor correcto");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor introducido no es correcto");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int danoArma(int DMGArma, int calidad) {
        return DMGArma + (calidad * 2);
    }
    //Esto es una pequeña práctica
}