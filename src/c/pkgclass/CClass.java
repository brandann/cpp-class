/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c.pkgclass;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author brandan
 */
import javax.swing.JOptionPane;
public class CClass {
    private static String xclass;
    private static PrintWriter out;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        xclass = "";

        while(xclass.equals(""))
        {
            xclass = JOptionPane.showInputDialog("Enter Class Name...", "Class");
        }
        write(xclass);
        
    }
    
    static boolean write(String xclass) throws FileNotFoundException
    {
        out = new PrintWriter(new FileOutputStream("cppClass.txt"));
        
        //HEADER
        out.println("//" + xclass + ".h");
        out.println("#ifndef " + xclass.toUpperCase() + "_H");
        out.println("#define " + xclass.toUpperCase() + "_H");
        out.println("#include <iostream>");
        out.println("class " + xclass);
        out.println("{");
        out.println("\tpublic:");
        out.println("\t\t" + xclass + "();");
        out.println("\t\tvirtual ~" + xclass + "();" );
        out.println("\tprotected:");
        out.println("\tprivate:");
        out.println("};");
        out.println("\n");
        out.println("\n");
        out.println("#endif // " + xclass.toUpperCase() + "_H");
        
        out.println("\n\n\n\n--------------------------------------------------------------\n\n\n\n\n");
        
        //CLASS
        out.println("//" + xclass + ".cpp");
        out.println("\n");
        out.println("#include \"" + xclass + ".h\"");
        out.println("#include <iostream>");
        out.println("\n");
        out.println("using namespace std;");
        out.println("\n");
        out.println(xclass + "::" + xclass + "()");
        out.println("{");
        out.println("\t//const");
        out.println("}// end " + xclass);
        out.println("\n");
        out.println(xclass + "::~" + xclass + "()");
        out.println("{");
        out.println("\t//deconst");
        out.println("}// end ~" + xclass);

        out.close();

        //TRY TO OPEN FILE
        try{
                Desktop d = Desktop.getDesktop();
                d.open(new File("cppClass.txt"));
                return true;
            }
            catch(Exception e){
            }
        return false;
    }
    
}
