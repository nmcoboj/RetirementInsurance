package test;

import dominio.Pension;
import dominio.seguroDiscapacidad;
import dominio.seguroPatronal;
import dominio.seguroVejez;
import java.util.Scanner;

public class testSeguro implements Pension {

    static Scanner informacion = new Scanner(System.in);
    static long cedula;
    static String nombre;
    static int aniosAporte;
    static float pensionBase;
    static seguroVejez vejez[];
    static seguroDiscapacidad discapacidad[];
    static seguroPatronal patronal[];
    
    public static void main(String[] args) {
        int entrada = 0;
        Menu menu = new Menu();
        entrada = menu.MenuPrincipal();

        while (entrada != 3) {
            switch (entrada) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Opción 1: Registrar Jubilados.");
                    registrarJubilados();
                    entrada = menu.MenuPrincipal();
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("Opción 2: Listar Jubilados.");
                    listarJubilados();
                    entrada = menu.MenuPrincipal();
                    break;

            }
        }
    }

    public static void registrarJubilados() {
        System.out.println("Cantidad de jubilados por vejez:");
        int j = informacion.nextInt();
        vejez = new seguroVejez[j];
        seguroVejez(vejez);
        System.out.println("Cantidad de jubilados por discapacidad:");
        int k = informacion.nextInt();
        discapacidad = new seguroDiscapacidad[k];
        seguroDiscapacidad(discapacidad);
        System.out.println("Cantidad de jubilados por patrono:");
        int l = informacion.nextInt();
        patronal = new seguroPatronal[l];
        seguroPatronal(patronal);
    }

    public static void listarJubilados() {
        System.out.println(" ");
        System.out.println("Jubilados por vejez:");
        System.out.println(" ");
        for (int i = 0; i < vejez.length; i++) {
            System.out.println("Jubilado #." + (i + 1) );
            System.out.print(" Nombre: " + vejez[i].getNombre()+" ");
            System.out.print(" Cedula: " + vejez[i].getCedula()+" ");
            System.out.println(" Años aportando: " + vejez[i].getAniosAporte()+" ");
            System.out.print("Pensión final: " + vejez[i].getPensionFinal()+" dolares.");
            System.out.println("");
        }
        System.out.println(" ");
        System.out.println("Jubilados por discapacidad:");
        System.out.println(" ");
        for (int i = 0; i < discapacidad.length; i++) {
            System.out.println("Jubilado #." + (i + 1));
            System.out.print("Nombre: " + discapacidad[i].getNombre()+" ");
            System.out.print("Cedula: " + discapacidad[i].getCedula()+" ");
            System.out.print("Años aportando: " + discapacidad[i].getAniosAporte()+" ");
            System.out.println("Discapacidad: " + discapacidad[i].getNivelDiscapacidad() +"%"+" ");
            System.out.print("Pensión final: " + discapacidad[i].getPensionFinal() +" dolares.");
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println("Jubilados patronales, se considera inflación del 0,18%:");
        System.out.println(" ");
        for (int i = 0; i < patronal.length; i++) {
            System.out.println("Jubilado #." + (i + 1));
            System.out.print("Nombre: " + patronal[i].getNombre()+" ");
            System.out.print("Cedula: " + patronal[i].getCedula()+" ");
            System.out.print("Años aportando: " + patronal[i].getAniosAporte()+" ");
            System.out.println("Empresa: " + patronal[i].getEmpresa()+" ");
            System.out.print("Pensión final: " + patronal[i].getPensionFinal()+" dolares.");
            System.out.println("");
        }
    }

    public static void seguroVejez(seguroVejez seguroV[]) {
        for (int i = 0; i < seguroV.length; i++) {
            informacion.nextLine();
            System.out.println("Jubilados por vejez: ");
            System.out.println("Ingrese los datos del Jubilado #." + (i + 1));
            System.out.print("Nombre: ");
            nombre = informacion.nextLine();
            System.out.print("Cedula: ");
            cedula = informacion.nextLong();
            System.out.print("Años aportando: ");
            aniosAporte = informacion.nextInt();
            System.out.println(" ");
            pensionBase = pensionBases(aniosAporte);
            seguroV[i] = new seguroVejez(cedula, nombre, pensionBase, aniosAporte);
        }
    }

    public static void seguroDiscapacidad(seguroDiscapacidad seguroD[]) {
        for (int i = 0; i < seguroD.length; i++) {
            int nivelDisc;
            informacion.nextLine();
            System.out.println("Jubilados por discapacidad: ");
            System.out.println("Ingrese los datos del Jubilado #." + (i + 1));
            System.out.print("Nombre: ");
            nombre = informacion.nextLine();
            System.out.print("Cedula: ");
            cedula = informacion.nextLong();
            System.out.print("Años aportando: ");
            aniosAporte = informacion.nextInt();
            System.out.print("Porcentaje de discapacidad: ");
            nivelDisc = informacion.nextInt();
            System.out.println(" ");
            pensionBase = pensionBases(aniosAporte);
            seguroD[i] = new seguroDiscapacidad(nivelDisc, cedula, nombre, pensionBase, aniosAporte);
        }
    }

    public static void seguroPatronal(seguroPatronal seguroP[]) {
        for (int i = 0; i < seguroP.length; i++) {
            String tipoEmpresa;
            informacion.nextLine();
            System.out.println("Jubilados por discapacidad: ");
            System.out.println("Ingrese los datos del Jubilado #." + (i + 1));
            System.out.print("Nombre: ");
            nombre = informacion.nextLine();
            System.out.print("Cedula: ");
            cedula = informacion.nextLong();
            System.out.print("Años aportando: ");
            aniosAporte = informacion.nextInt();
            informacion.nextLine();
            System.out.print("Empresa(Privada o Publica): ");
            tipoEmpresa = informacion.nextLine();
            System.out.println(" ");
            pensionBase = pensionBases(aniosAporte);
            seguroP[i] = new seguroPatronal(tipoEmpresa, cedula, nombre, pensionBase, aniosAporte);
        }
    }

    public static float pensionBases(int aniosAporte) {
        float pensionBase = 0;
        if (aniosAporte <= 10) {
            pensionBase = (float) (400 * 0.5);
        } else if (aniosAporte >= 11 && aniosAporte <= 20) {
            pensionBase = (float) (400 * 0.6);
        } else if (aniosAporte >= 21 && aniosAporte <= 30) {
            pensionBase = (float) (400 * 0.7);
        } else if (aniosAporte >= 31 && aniosAporte <= 35) {
            pensionBase = (float) (400 * 0.8);
        } else if (aniosAporte >= 36 && aniosAporte <= 39) {
            pensionBase = (float) (400 * 0.9);
        } else if (aniosAporte >= 40) {
            pensionBase = 400;
        }
        return pensionBase;
    }

    @Override
    public void pensionFinal(float pensionBase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float pensionBase(int aniosAporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
