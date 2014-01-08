package org.q31.util;

/**
 * Created with IntelliJ IDEA.
 * User: jothi
 * Date: 8/10/12
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeFormatterTest {

    public static final String test1 = "public static void main (String[] args) {int x = 10; String abc = \"abc\"; for (i=0; i<10; i++) { (i == 10) " +
            "{System.out.println(interesting);}} int 1 = 5;}";

    public static final String test2 = "public static void main (String[] args) {int x = 10; String abc = \"abc\"; if (x == 2) { x = 1; } for (i=0; i<10; i++) { (i == 10) " +
            "{System.out.println(interesting);}} int 1 = 5;}";

    public static final String test3 = "public static void main (String[] args) { int x = 10; String abc = \"abc\"; for (i=0; i<10; i++) { if (i == 10) { System.out.println(interesting); while (x == 10) { int a = 5; for (int a = 10; a++) { System.out.println(a); } } } } int 1 = 5; }";

    public static final String test4 = "public static void main (String[] args) { int x = 10; String abc = \"abc\"; for (i=0; i<10; i++) { if (i == 10) { try { callAnotherMethod(); if(isValid) { System.out.println(true); } } catch (Exception ex || Throwable tx) { throw new Exception(); } System.out.println(interesting); while (x == 10) { int a = 5; for (int a = 10; a++) { System.out.println(a); } } } } int 1 = 5; }";

    public static final String test5 = "public static void main (String[] args) { int x = 10; String abc = \"abc\"; for (i=0; i<10; i++) { if (i == 10) { try { callAnotherMethod(); if(isValid) { System.out.println(true); } } catch (Exception ex || Throwable tx) { try { for(int i=0; i<10; i++) { System.out.println(\"Just printing\"); } } catch(Exception ex) { System.out.println(\"Just printing\"); } finally { System.out.println(\"Just printing\"); } throw new Exception(); } System.out.println(interesting); while (x == 10) { int a = 5; for (int a = 10; a++) { System.out.println(a); } } } } int 1 = 5; }";

    public static void main() {
        // call the CodeFormatter.java
        new CodeFormatter(test5).getFormattedSourceCode();
    }
}
