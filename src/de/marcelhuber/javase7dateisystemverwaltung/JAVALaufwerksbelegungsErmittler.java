package de.marcelhuber.javase7dateisystemverwaltung;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Marcel Huber; letzte Änderung 13.08.2017
 */
public class JAVALaufwerksbelegungsErmittler {

    private final int[] platzFuerZeichen;
    private final NumberFormat nf;
    private final Locale loc;

    {
        platzFuerZeichen = new int[]{20, 30, 30};
//        loc = new Locale("de", "DE");
        // besser direkt so:
        loc = Locale.GERMAN;
        nf = NumberFormat.getInstance(loc);
//        nf.setGroupingUsed(false);
        nf.setGroupingUsed(true);
    }

    public static void main(String[] args) {
        JAVALaufwerksbelegungsErmittler dummyObject
                = new JAVALaufwerksbelegungsErmittler();
        dummyObject.showLaufwerksbelegung();
    }

    private void showLaufwerksbelegung() {
        System.out.println("");
        System.out.println(("----------      Die aktuelle Speicherplatzbelegung "
                + "Ihres Rechners      -----------").toUpperCase());
        System.out.println("");
        File[] laufwerke = File.listRoots();
        System.out.printf("%" + platzFuerZeichen[0] + "s "
                + "%" + platzFuerZeichen[1] + "s "
                + "%" + platzFuerZeichen[2] + "s \n", "Laufwerk", "Speicherplatz insg. "
                + "(Bytes)", "freier Speicher (Bytes)");
        String outputString;
        for (File laufwerk : laufwerke) {
            outputString = "%" + platzFuerZeichen[0] + "s "
                    + "%" + platzFuerZeichen[1] + "s "
                    + "%" + platzFuerZeichen[2] + "s\n";
            outputString = String.format(outputString, laufwerk.getPath(),
                    nf.format(laufwerk.getTotalSpace()),
                    nf.format(laufwerk.getUsableSpace()));
            System.out.print(outputString.replace('.', '\''));
        }
//        System.out.println("Ä");
        System.out.println("");
        System.out.println(("----------    Die aktuelle Speicherplatzbelegung "
                + "Ihres Rechners (GB)   -----------").toUpperCase());
        System.out.println("");
        outputString = "%" + platzFuerZeichen[0] + "s "
                + "%" + platzFuerZeichen[1] + "s "
                + "%" + platzFuerZeichen[2] + "s \n";
        System.out.printf(outputString, "Laufwerk", "Speicherplatz insg. "
                + "(GB)", "freier Speicher (GB)");
        for (File laufwerk : laufwerke) {
            outputString = String.format("%" + platzFuerZeichen[0] + "s "
                    + "%" + platzFuerZeichen[1] + "s "
                    + "%" + platzFuerZeichen[2] + "s\n",
                    laufwerk.getPath(),
                    nf.format(laufwerk.getTotalSpace() / 1_024.0 / 1_024 / 1_024),
                    nf.format(laufwerk.getUsableSpace() / 1_024.0 / 1_024 / 1_024));
            System.out.print(outputString.replace('.', '\''));
        }
        System.out.println("");
    }
}
