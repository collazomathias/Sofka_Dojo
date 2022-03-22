package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void cargarInformacion(List<Mail> mails){
        mails.add(new Mail("lucas", '@', "gmail.com", false));
        mails.add(new Mail("mathias", '@', "gmail.com", false));
        mails.add(new Mail("fernando", '@', "gmail.com", false));
        mails.add(new Mail("franccesco", '@', "gmail.com", false));
        mails.add(new Mail("leonardo", '@', "gmail.com", false));
        mails.add(new Mail("ignacio", '@', "gmail.com", false));
        mails.add(new Mail("mauricio", '@', "gmail.com", false));
        mails.add(new Mail("lucia", '@', "gmail.com", false));
        mails.add(new Mail("henry", '@', "gmail.com", false));
        mails.add(new Mail("dariel", '@', "gmail.com", false));
        mails.add(new Mail("lucas", '@', "hotmail.com", false));
        mails.add(new Mail("mathias", '@', "hotmail.com", false));
        mails.add(new Mail("fernando", '@', "hotmail.com", false));
        mails.add(new Mail("franccesco", '@', "hotmail.com", false));
        mails.add(new Mail("leonardo", '@', "hotmail.com", false));
        mails.add(new Mail("ignacio", '@', "hotmail.com", false));
        mails.add(new Mail("mauricio", '@', "hotmail.com", false));
        mails.add(new Mail("lucia", '@', "hotmail.com", false));
        mails.add(new Mail("henry", '@', "hotmail.com", false));
        mails.add(new Mail("dariel", '@', "hotmail.com", false));
        mails.add(new Mail("lucas", '@', "outlook.com", false));
        mails.add(new Mail("mathias", '@', "outlook.com", false));
        mails.add(new Mail("fernando", '@', "outlook.com", false));
        mails.add(new Mail("franccesco", '@', "outlook.com", false));
        mails.add(new Mail("leonardo", '@', "outlook.com", false));
        mails.add(new Mail("ignacio", '@', "outlook.com", false));
        mails.add(new Mail("mauricio", '@', "outlook.com", false));
        mails.add(new Mail("lucia", '@', "outlook.com", false));
        mails.add(new Mail("henry", '@', "outlook.com", false));
        mails.add(new Mail("dariel", '@', "outlook.com", false));

        // Correos repetidos
        mails.add(new Mail("mathias", '@', "hotmail.com", false));
        mails.add(new Mail("lucas", '@', "hotmail.com", false));

        // Correos mal formulados
        mails.add(new Mail("mathias", '*', "hotmail.com", false));
        mails.add(new Mail("lucas", '/', "hotmail.com", false));
        mails.add(new Mail("franccesco", '@', "asdasd", false));
    }

    public static void main(String[] args) {
        List<Mail> mails = new ArrayList<>();
        cargarInformacion(mails);
        // Correos correctamente formulados


        // Cantidad total de correos sin validar
        System.out.println("\nCantidad total de correos (sin verificar que esten correctamente formulados): " + mails.size());
        // Cantidad total de correos validados
        System.out.println("Cantidad total de correos bien formulados (gmail.com & outlook.com & hotmail.com): " + mails
                .stream()
                .filter(mail -> mail.prefijo.equals('@') &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$") &&
                        mail.dominio.equals("hotmail.com") ||
                        mail.dominio.equals("gmail.com") ||
                        mail.dominio.equals("outlook.com")).count());
        //Cantidad de correos con dominio 'hotmail.com'
        System.out.println("Cantidad total de correos (hotmail.com): " + mails
                .stream()
                .filter(mail -> mail.dominio.equals("hotmail.com") &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$")).count());
        //Cantidad de correos con dominio 'gmail.com'
        System.out.println("Cantidad total de correos (gmail.com): " + mails
                .stream()
                .filter(mail -> mail.dominio.equals("gmail.com") &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$")).count());
        //Cantidad de correos con dominio 'outlook.com'
        System.out.println("Cantidad total de correos (outlook.com): " + mails
                .stream()
                .filter(mail -> mail.dominio.equals("outlook.com") &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$")).count());

        // Correos validados sin repetir
        System.out.println("\nLista de correos sin repetir: ");
        List<Mail> mails_correctos_sin_repetir = mails
                .stream()
                .filter(mail -> mail.prefijo.equals('@') &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$") &&
                        mail.dominio.equals("hotmail.com") ||
                        mail.dominio.equals("gmail.com") ||
                        mail.dominio.equals("outlook.com"))
                .distinct()
                .collect(Collectors.toList());
        mails_correctos_sin_repetir.forEach(System.out::println);

        // Verificar si todos los mails están correctamente formulados
        System.out.println("\n¿Todos los mails están correctamente formulados?");
        List<Boolean> mails_correctos = mails
                .stream()
                .map(mail -> (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$"))
                .distinct()
                .collect(Collectors.toList());
        if(mails_correctos.contains(false)) {
            System.out.println("No, al menos un mail está mal formulado.");
        } else {
            System.out.println("Si, todos están bien formulados.");
        }

        List<Mail> mails_enviados_cambiar_estado = mails
                .stream()
                .filter(mail -> mail.prefijo.equals('@') &&
                        (mail.nombre+mail.prefijo+mail.dominio).matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$") &&
                        mail.dominio.equals("hotmail.com") ||
                        mail.dominio.equals("gmail.com") ||
                        mail.dominio.equals("outlook.com"))
                .distinct()
                .peek(mail -> {
                    if(mail.estado) mail.estado = false;
                })
                .collect(Collectors.toList());

        System.out.println("\nCorreos con estado enviado: ");
        mails_enviados_cambiar_estado.forEach(System.out::println);

    }
}
