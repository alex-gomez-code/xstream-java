package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args) {
        Miembro m1 = new Miembro ("Keishin Ukai", "Sin número", "Entrenador", "Graduado", "Activo");
        Miembro m3 = new Miembro ("Ittetsu Takeda", "Sin número", "Consejero Escolar", "Profesor", "Activo");
        Miembro m4 = new Miembro ("Hitoka Yachi", "Sin número", "Manager", "Primero", "Activo");
        //System.out.println(m1);
        List<Miembro> lista = new ArrayList<Miembro>();
        lista.add(m1);
        lista.add(m3);
        lista.add(m4);
        
        XStream xs = new XStream(new DomDriver());
        xs.alias("miembro", Miembro.class);
        xs.aliasField("curso", Miembro.class, "year");
        xs.useAttributeFor(Miembro.class, "estado");
        xs.omitField(Miembro.class, "numero");
        xs.alias("Miembros", java.util.List.class);
        
        String salida = xs.toXML(lista);
        String xmlMiembro = xs.toXML(m1);
        System.out.println(salida);
        
        Miembro m2 = (Miembro) xs.fromXML(xmlMiembro);
        System.out.println(m2);
        
        try {
            xs.toXML(lista, Files.newBufferedWriter(Paths.get("karasuno2.xml")));
        } catch (IOException ex) {
            System.err.println("ERROR");
        }
        
        try {
            ArrayList<Miembro> lista2 = (ArrayList<Miembro>) xs.fromXML(Files.newBufferedReader(Paths.get("karasuno2.xml")));
            for (Miembro miembro : lista2) {
                System.out.println(miembro);
            }
        } catch (IOException ex) {
            System.err.println("ERROR");
        }
        
        XStream xs2 = new XStream(new JsonHierarchicalStreamDriver());
        xs2.alias("miembro", Miembro.class);
        xs2.aliasField("curso", Miembro.class, "year");
        xs2.useAttributeFor(Miembro.class, "estado");
        xs2.omitField(Miembro.class, "numero");
        xs2.alias("Miembros", java.util.List.class);
        String salida2 = xs2.toXML(lista);
        
        System.out.println(salida2);
    }
    
}
